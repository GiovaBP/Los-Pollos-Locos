package player;

import characters.BasicCharacter;
import enemies.Enemy;
import gui.exceptions.EnemyDeadException;
import gui.exceptions.PlayerDeadException;
import gui.panels.DialogPanel;
import gui.panels.StatusPanel;
import items.armors.Armor;
import items.weapons.Weapon;
import org.jetbrains.annotations.NotNull;
import player.skills.BasicHeal;
import player.skills.FuryAttack;
import player.skills.Skill;
import util.interfaces.Randomized;
import util.managers.ImageManager;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Un jugador es un personaje que puede luchar contra enemigos, ganar experiencia y oro, y equipar armas y armaduras.
 *
 * @version 1.0
 * @autor jesus
 */
public class Player extends BasicCharacter implements Serializable {

	/**
	 * La instancia de la clase jugador
	 */
	private static Player instance;
	/**
	 * La fuerza del jugador.
	 */
	private int strength;
	/**
	 * La defensa del jugador.
	 */
	private int defense;
	/**
	 * La inteligencia del jugador.
	 */
	private int intelligence;
	private int dexterity;
	private int luck;
	private int resistance;
	private int speed;
	private int experience;
	private int level;
	private int gold;
	private Weapon weapon;
	private Armor headArmor;
	private Armor chestArmor;
	private Armor legArmor;
	private Armor footArmor;
	private Armor handArmor;
	private final Inventory inventory;
	private final Map<String, Skill> skillMap;

	/**
	 * Devuelve la instancia de la clase jugador.
	 *
	 * @return la instancia de la clase jugador
	 */
	public static Player getInstance(String name) {

		if (instance == null) {

			instance = new Player(name);
		}
		return instance;
	}

	public static synchronized Player getInstance() {

		return instance;
	}

	public static void setInstance(Player player) {

		instance = player;
	}

	/**
	 * Construye un nuevo jugador con un nombre.
	 *
	 * @param name el nombre del jugador
	 */
	private Player(String name) {

		super(name, 30, 10);
		experience = 0;
		level = 1;
		gold = 0;
		weapon = null;
		headArmor = null;
		chestArmor = null;
		legArmor = null;
		footArmor = null;
		handArmor = null;
		strength = 5;
		defense = 5;
		randomizeStats(25);
		inventory = new Inventory();
		skillMap = new HashMap<>();
		skillMap.put(BasicHeal.NAME, BasicHeal.getInstance());
		skillMap.put(FuryAttack.NAME, FuryAttack.getInstance());
	}

	/**
	 * Reparte aleatoriamente los puntos de fuerza, defensa, inteligencia, destreza y suerte.
	 *
	 * @param maxPoints los puntos a repartir
	 */
	public void randomizeStats(int maxPoints) {

		int stat = Randomized.randomizeNumber(1, 7);
		while (maxPoints > 0) {
			switch (stat) {
				case 1 -> {
					if (strength < (level * 5)) strength++;
					else maxPoints++;
				}
				case 2 -> {
					if (defense < (level * 5)) defense++;
					else maxPoints++;
				}
				case 3 -> intelligence++;
				case 4 -> dexterity++;
				case 5 -> luck++;
				case 6 -> resistance++;
				case 7 -> speed++;
			}
			maxPoints--;
			stat = Randomized.randomizeNumber(1, 7);
		}
	}

	/**
	 * El jugador equipa un arma.
	 *
	 * @param weapon el arma a equipar
	 */
	public void equipWeapon(Weapon weapon) {

		this.weapon = weapon;
	}

	/**
	 * El jugador equipa una armadura.
	 *
	 * @param armor la armadura a equipar
	 */
	public void equipArmor(Armor armor) {

		switch (armor.getArmorType()) {
			case HEAD -> headArmor = armor;
			case CHEST -> chestArmor = armor;
			case LEGS -> legArmor = armor;
			case FEET -> footArmor = armor;
			case HANDS -> handArmor = armor;
		}
	}

	/**
	 * El jugador revive con toda su salud y mana.
	 */
	public void revive() {

		hp = maxHp;
		mp = maxMp;
	}

	/**
	 * El jugador ataca a un enemigo.
	 *
	 * @param enemy el enemigo a atacar
	 *
	 * @throws PlayerDeadException si el jugador está muerto
	 */
	public void attack(@NotNull Enemy enemy) throws PlayerDeadException, EnemyDeadException {

		if (!isDead()) {

			DialogPanel.getInstance().addText(String.format("%s", enemy.takeDamage(this)));
			if (enemy.isDead()) getRewards(enemy);
		} else {
			throw new PlayerDeadException();
		}
	}

	/**
	 * El Jugador obtiene las recompensas por derrotar a un enemigo.
	 *
	 * @param enemy el enemigo derrotado
	 */
	public void getRewards(@NotNull Enemy enemy) throws EnemyDeadException {

		String message = gainExperience(enemy.getExperience());
		message += gainGold(enemy.getGold());
		DialogPanel.getInstance().addText(message);
		enemy.dropItem(this);
		StatusPanel.getInstance(0).update();
		throw new EnemyDeadException();
	}

	public String getActualHp() {

		return String.format("%d/%d", getHp(), getMaxHp());
	}

	public String getActualMp() {

		return String.format("%d/%d", getMp(), getMaxMp());
	}

	private int getWeaponStat(Weapon weapon, Stats stat) {

		return weapon != null && weapon.getStats().containsKey(stat) ? weapon.getStats().get(stat) : 0;
	}

	private int getArmorStat(Armor armor, Stats stat) {

		return armor != null && armor.getStats().containsKey(stat) ? armor.getStats().get(stat) : 0;
	}

	public void tryToFlee() throws EnemyDeadException {

		if (Randomized.randomizeNumber(1, 100) <= 50) {

			DialogPanel.getInstance().addText("¡Has huido!\n");
			throw new EnemyDeadException();
		} else {
			DialogPanel.getInstance().addText("¡No has podido huir!\n");
		}
	}

	public String getDisplayAttack() {

		int plusAttack = getTotalAttack();
		return plusAttack == strength ? String.format("FUE: %d", strength) :
				String.format("FUE: %d (+%d)", getStrength(), plusAttack);
	}

	private int getTotalAttack() {

		int plusAttack = 0;
		plusAttack += getWeaponStat(weapon, Stats.ATTACK);
		plusAttack += getArmorStat(headArmor, Stats.ATTACK);
		plusAttack += getArmorStat(chestArmor, Stats.ATTACK);
		plusAttack += getArmorStat(legArmor, Stats.ATTACK);
		plusAttack += getArmorStat(footArmor, Stats.ATTACK);
		plusAttack += getArmorStat(handArmor, Stats.ATTACK);
		return plusAttack > 0 ? strength + plusAttack : strength;
	}

	public String getDisplayDefense() {

		int plusDefense = getTotalDefense();
		return plusDefense == defense ? String.format("DEF: %d", defense) :
				String.format("DEF: %d (+%d)", getDefense(), plusDefense);
	}

	private int getTotalDefense() {

		int plusDefense = 0;
		plusDefense += getArmorStat(headArmor, Stats.DEFENSE);
		plusDefense += getArmorStat(chestArmor, Stats.DEFENSE);
		plusDefense += getArmorStat(legArmor, Stats.DEFENSE);
		plusDefense += getArmorStat(footArmor, Stats.DEFENSE);
		plusDefense += getArmorStat(handArmor, Stats.DEFENSE);
		return plusDefense > 0 ? defense + plusDefense : defense;
	}

	public String getDisplayIntelligence() {

		int plusIntelligence = getTotalIntelligence();
		return plusIntelligence == intelligence ? String.format("INT: %d", intelligence) :
				String.format("INT: %d (+%d)", intelligence, plusIntelligence);
	}

	private int getTotalIntelligence() {

		int plusIntelligence = 0;
		plusIntelligence += getArmorStat(headArmor, Stats.INTELLIGENCE);
		plusIntelligence += getArmorStat(chestArmor, Stats.INTELLIGENCE);
		plusIntelligence += getArmorStat(legArmor, Stats.INTELLIGENCE);
		plusIntelligence += getArmorStat(footArmor, Stats.INTELLIGENCE);
		plusIntelligence += getArmorStat(handArmor, Stats.INTELLIGENCE);
		return plusIntelligence > 0 ? intelligence + plusIntelligence : intelligence;
	}

	public String getDisplayDexterity() {

		int plusDexterity = getTotalDexterity();
		return plusDexterity == dexterity ? String.format("DES: %d", dexterity) :
				String.format("DES: %d (+%d)", dexterity, plusDexterity);

	}

	private int getTotalDexterity() {

		int plusDexterity = 0;
		plusDexterity += getArmorStat(headArmor, Stats.DEXTERITY);
		plusDexterity += getArmorStat(chestArmor, Stats.DEXTERITY);
		plusDexterity += getArmorStat(legArmor, Stats.DEXTERITY);
		plusDexterity += getArmorStat(footArmor, Stats.DEXTERITY);
		plusDexterity += getArmorStat(handArmor, Stats.DEXTERITY);
		return plusDexterity > 0 ? dexterity + plusDexterity : dexterity;
	}

	public String getDisplayLuck() {

		int plusLuck = getTotalLuck();
		return plusLuck == luck ? String.format("SUE: %d", luck) :
				String.format("SUE: %d (+%d)", luck, plusLuck);
	}

	private int getTotalLuck() {

		int plusLuck = 0;
		plusLuck += getArmorStat(headArmor, Stats.LUCK);
		plusLuck += getArmorStat(chestArmor, Stats.LUCK);
		plusLuck += getArmorStat(legArmor, Stats.LUCK);
		plusLuck += getArmorStat(footArmor, Stats.LUCK);
		plusLuck += getArmorStat(handArmor, Stats.LUCK);
		return plusLuck > 0 ? luck + plusLuck : luck;
	}

	public String getDisplayResistance() {

		int plusResistance = getTotalResistance();
		return plusResistance == resistance ? String.format("RES: %d", resistance) :
				String.format("RES: %d (+%d)", resistance, plusResistance);
	}

	private int getTotalResistance() {

		int plusResistance = 0;
		plusResistance += getArmorStat(headArmor, Stats.RESISTANCE);
		plusResistance += getArmorStat(chestArmor, Stats.RESISTANCE);
		plusResistance += getArmorStat(legArmor, Stats.RESISTANCE);
		plusResistance += getArmorStat(footArmor, Stats.RESISTANCE);
		plusResistance += getArmorStat(handArmor, Stats.RESISTANCE);
		return plusResistance > 0 ? resistance + plusResistance : resistance;
	}

	public String getDisplaySpeed() {

		int plusSpeed = getTotalSpeed();
		return plusSpeed == speed ? String.format("VEL: %d", speed) :
				String.format("VEL: %d (+%d)", speed, plusSpeed);
	}

	private int getTotalSpeed() {

		int plusSpeed = 0;
		plusSpeed += getArmorStat(headArmor, Stats.SPEED);
		plusSpeed += getArmorStat(chestArmor, Stats.SPEED);
		plusSpeed += getArmorStat(legArmor, Stats.SPEED);
		plusSpeed += getArmorStat(footArmor, Stats.SPEED);
		plusSpeed += getArmorStat(handArmor, Stats.SPEED);
		return plusSpeed > 0 ? speed + plusSpeed : speed;
	}

	public String takeDamage(int damage) {

		damage -= getTotalDefense();
		String message;
		if (damage < 0) damage = 0;
		message = super.takeDamage(damage);
		if (isDead())
			message += String.format("%s\n", printDeath());
		return message;
	}

	public String gainExperience(int experience) {

		this.experience += experience;
		String message = printExperience(experience);
		message += levelUp();
		return message;
	}

	/**
	 * Revisa si el jugador sube de nivel.
	 */
	private String levelUp() {

		if (this.experience >= level * 20) {

			level++;
			maxHp += 10;
			maxMp += 10;
			hp = maxHp;
			mp = maxMp;
			strength += Randomized.randomizeNumber(0, 3);
			defense += Randomized.randomizeNumber(0, 3);
			speed += Randomized.randomizeNumber(0, 3);
			randomizeStats(10);
			StatusPanel.getInstance(0).update();
			return String.format("¡%s ha subido al nivel %d!\n", getName(), level);
		} else {
			return "";
		}
	}

	public String gainGold(int gold) {

		this.gold += gold;
		return printGold(gold);
	}

	public String printDeath() {

		return "¡Has muerto!";
	}

	public String printGold(int gold) {

		return String.format("Has ganado %d monedas de oro!\n", gold);
	}

	public String printExperience(int experience) {

		return String.format("Has ganado %d puntos de experiencia!\n", experience);
	}

	//Getters and Setters

	public int getLevel() {

		return level;
	}

	public int getGold() {

		return gold;
	}

	public void setGold(int gold) {

		this.gold = gold;
	}

	public int getExperience() {

		return experience;
	}

	public int getStrength() {

		return strength;
	}

	public int getDefense() {

		return defense;
	}

	public void setDefense(int defense) {

		this.defense = defense;
	}

	public int getDexterity() {

		return dexterity;
	}

	public int getLuck() {

		return luck;
	}

	public Weapon getWeapon() {

		return weapon;
	}

	public int getDamage() {

		return getTotalAttack();
	}

	public String getName() {

		return super.getName();
	}

	public Inventory getInventory() {

		return inventory;
	}

	public int getSpeed() {

		return speed;
	}

	public Armor getHeadArmor() {

		return headArmor;
	}

	public Armor getChestArmor() {

		return chestArmor;
	}

	public Armor getLegArmor() {

		return legArmor;
	}

	public Armor getFootArmor() {

		return footArmor;
	}

	public Armor getHandArmor() {

		return handArmor;
	}

	public Image getImage() {

		return ImageManager.getInstance().getImage("player",
				new ImageIcon("img\\player\\player.png").getImage());
	}

	public Map<String, Skill> getSkillMap() {

		return skillMap;
	}
}
