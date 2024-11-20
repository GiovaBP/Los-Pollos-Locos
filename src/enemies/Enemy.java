package enemies;

import characters.BasicCharacter;

import gui.exceptions.EnemyDeadException;
import gui.panels.DialogPanel;
import player.Player;
import player.Stats;
import util.interfaces.Randomized;
import util.managers.ImageManager;

import java.awt.*;
import java.util.HashMap;

public abstract class Enemy extends BasicCharacter {

	protected final int adjustmentFactor = 3;
	protected final String name;
	protected final HashMap<Stats, Integer> stats = new HashMap<>();
	protected final int gold;
	protected final int experience;
	protected final int level;
	protected final int maxLevel;
	protected Image image;
	protected final ImageManager imageManager = ImageManager.getInstance();
	protected final Player player;
	private static final int BASE_LEVEL = 1;

	public Enemy(Player player, String name, int maxLevel, int health, int gold, int experience) {

		super(name, health, 0);
		this.player = player;
		this.maxLevel = maxLevel;
		this.level = getLevel(player, maxLevel);
		this.name = name;
		this.maxHp = getHealth(health);
		this.hp = maxHp;
		this.gold = getGold(gold);
		this.experience = getExperience(experience);
	}

	private int getExperience(int experience) {

		return Randomized.randomizeNumber(experience, experience + 2) * level;
	}

	private int getGold(int gold) {

		return Randomized.randomizeNumber(gold, gold + 2) * level;
	}

	private int getHealth(int health) {

		return (Randomized.randomizeNumber(health, health + 2)) * level;
	}

	protected int getDefense(Player player) {

		int defense = getAdjustedDefense();
		if (stats.get(Stats.LUCK) > player.getDexterity()) {
			//TODO: Implementar críticos
		}
		return defense;
	}

	public int getAdjustedSpeed() {

		return stats.get(Stats.SPEED) + (player.getLevel() - BASE_LEVEL) * adjustmentFactor;
	}

	public int getAdjustedAttack() {

		int adjustedAttack = stats.get(Stats.ATTACK) + (player.getLevel() - BASE_LEVEL) * adjustmentFactor;
		if (adjustedAttack <= player.getDefense()) adjustedAttack = player.getDefense() + adjustmentFactor;
		return adjustedAttack;
	}

	public int getAdjustedDefense() {

		int adjustedDefense = stats.get(Stats.DEFENSE) + (player.getLevel() - BASE_LEVEL) * adjustmentFactor;
		if (adjustedDefense >= player.getDamage()) adjustedDefense = player.getDamage() - adjustmentFactor;
		return adjustedDefense;
	}

	protected int getDamage(Player player) {

		int damage = getAdjustedAttack();
		if (stats.get(Stats.DEXTERITY) > player.getLuck()) {

			//TODO: Implementar críticos
		}
		return damage;
	}

	private int getLevel(Player player, int maxLevel) {

		return player.getLevel();
	}

	public int getLuck() {

		return stats.get(Stats.LUCK);
	}

	public Image getImage() {

		return image;
	}

	public ImageManager getImageManager() {

		return imageManager;
	}

	public int getLevel() {

		return level;
	}

	public int getMaxLevel() {

		return maxLevel;
	}

	public String getName() {

		return name;
	}

	public int getGold() {

		return gold;
	}

	public int getExperience() {

		return experience;
	}

	public int calculateDamage(Player player) {

		return Math.max(0, (player.getDamage() - getDefense(player)));
	}

	public int calculateDamage(Player player, int damage) {

		return Math.max(0, (damage - getDefense(player)));
	}

	public String takeDamage(Player player) {

		int damage = calculateDamage(player);
		String message = String.format("¡%s ataca con %d punto(s) de daño!\n", player.getName(), player.getDamage());
		message += String.format("¡%s sufre %d punto(s) de daño!\n", name, damage);
		hp -= damage;
		if (isDead())
			message += String.format("¡%s ha sido derrotado!\n", name);
		return message;
	}

	public String takeDamage(Player player, int damage) {

		int finalDamage = calculateDamage(player, damage);
		hp -= finalDamage;
		String message = String.format("¡%s sufre %d punto(s) de daño!\n", name, finalDamage);
		message += String.format("¡%s ataca con %d punto(s) de daño!\n", name, damage);
		if (isDead())
			message += String.format("¡%s ha sido derrotado!\n", name);
		return message;
	}

	public void attack() throws EnemyDeadException {

		DialogPanel.getInstance().addText(getAttack());
	}

	public abstract String getAttack() throws EnemyDeadException;

	public abstract void dropItem(Player player);

	public HashMap<Stats, Integer> getStats() {

		return stats;
	}
}
