package player.skills;

import enemies.Enemy;
import gui.exceptions.EnemyDeadException;
import gui.GameWindow;
import gui.panels.DialogPanel;
import org.jetbrains.annotations.NotNull;
import player.Player;
import player.Stats;

import java.io.Serializable;

public class BasicHeal extends Skill implements Serializable {

	private static final BasicHeal instance = new BasicHeal();
	public static final String NAME = "Curación Básica";

	public static BasicHeal getInstance() {

		if (instance == null) {

			return new BasicHeal();
		} else {
			return instance;
		}
	}

	private BasicHeal() {

		super(NAME, "Cura al jugador 8 puntos de vida", 3, 5);
	}

	@Override
	public void skillAction() {

		//Primero debo determinar quien es más rápido
		Player player = Player.getInstance();
		Enemy enemy = GameWindow.getInstance(player).getEnemy();
		//Si el jugador es más rápido, entonces se cura y el enemigo ataca
		if (player.getSpeed() >= enemy.getStats().get(Stats.SPEED)) {

			heal(player);
			try {
				enemy.attack();
			} catch (EnemyDeadException e) {
				throw new RuntimeException(e);
			}
			updatePanels(player);
		} else {
			//Si el enemigo es más rápido, entonces el enemigo ataca y el jugador se cura
			try {
				enemy.attack();
			} catch (EnemyDeadException e) {
				throw new RuntimeException(e);
			}
			heal(player);
			updatePanels(player);
		}
	}

	private void heal(@NotNull Player player) {

		player.heal(8);
		player.useMp(manaCost);
		String message = String.format("¡%s usa curación básica y recupera 8 puntos de vida!", player.getName());
		DialogPanel.getInstance().addText(message);
	}
}
