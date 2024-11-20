package player.skills;

import enemies.Enemy;
import gui.exceptions.EnemyDeadException;
import gui.exceptions.PlayerDeadException;
import gui.GameWindow;
import gui.panels.DialogPanel;
import player.Player;
import player.Stats;
import util.enemies.EnemyFactory;

import java.io.Serializable;

public class FuryAttack extends Skill implements Serializable {

	private final static FuryAttack instance = new FuryAttack();
	public final static String NAME = "Ataque Furia";

	public static FuryAttack getInstance() {

		if (instance == null) {

			return new FuryAttack();
		} else {
			return instance;
		}
	}

	public FuryAttack() {

		super(NAME, "Ataque al enemigo con +5 puntos de daño", 5, 3);
	}

	private void attack(Player player, Enemy enemy) throws EnemyDeadException {

		int damage = player.getDamage() + 5;
		player.useMp(manaCost);
		DialogPanel.getInstance().addText(
				String.format("¡%s ataca a %s con %d puntos de daño!\n", player.getName(), enemy.getName(), damage));
		DialogPanel.getInstance().addText(enemy.takeDamage(damage - enemy.getAdjustedDefense()));
		if (enemy.isDead()) {
			player.getRewards(enemy);
		}
		updatePanels(player);
	}

	private void setNewEnemy(Player player) {

		// Si el enemigo está muerto o escapo por una habilidad
		// Creamos un nuevo enemigo
		Enemy enemy = GameWindow.getInstance(player).getEnemy();
		Enemy newEnemy = EnemyFactory.generateRegularEnemy();
		// Asignamos el nuevo enemigo al panel de juego
		GameWindow.getInstance(player).setEnemy(newEnemy);
		// Actualizamos los paneles
		updatePanels(player);
	}

	@Override
	public void skillAction() {

		Player player = Player.getInstance();
		Enemy enemy = GameWindow.getInstance(player).getEnemy();
		// Validamos si el jugador tiene el maná suficiente
		if (player.getMp() < manaCost) {

			DialogPanel.getInstance().addText("¡No tienes suficiente maná para realizar esta habilidad!\n");
		} else {
			//Si el jugador es más rápido, entonces se cura y el enemigo ataca
			if (player.getSpeed() >= enemy.getStats().get(Stats.SPEED)) {

				try {
					// Primero el jugador ataca
					attack(player, enemy);
					// Luego el enemigo ataca si sigue con vida
					enemy.attack();
				} catch (EnemyDeadException e) {
					// Si el enemigo muere, entonces se crea un nuevo enemigo
					setNewEnemy(player);
					updatePanels(player);
				}
				// Actualizamos los paneles
				updatePanels(player);
			} else {
				//Si el enemigo es más rápido, entonces el enemigo ataca y el jugador se cura
				try {
					enemy.attack();
				} catch (EnemyDeadException e) {
					// Si el enemigo muere, entonces se crea un nuevo enemigo
					setNewEnemy(player);
				}
				try {
					if (!player.isDead()) attack(player, enemy);
					else throw new PlayerDeadException();
				} catch (PlayerDeadException e) {
					// Si el jugador muere, mostramos un mensaje de consolación
					DialogPanel.getInstance().addText("¡Quizás deberías entrenar más duro!\n");
					// Revivimos al jugador
					player.revive();
					// Mostramos un mensaje de que el jugador fue revivido
					DialogPanel.getInstance().addText("¡Has sido revivido!\n");
					// Creamos un nuevo enemigo
					setNewEnemy(player);
					updatePanels(player);
				} catch (EnemyDeadException e) {
					// Si el enemigo muere, entonces se crea un nuevo enemigo
					setNewEnemy(player);
					updatePanels(player);
				}
			}
		}
	}
}
