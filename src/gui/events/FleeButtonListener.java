package gui.events;

import enemies.Enemy;
import gui.exceptions.EnemyDeadException;
import gui.GameWindow;
import gui.panels.EnemyPanel;
import gui.panels.MainPanel;
import gui.panels.PlayerPanel;
import gui.panels.StatusPanel;
import player.Player;
import util.enemies.EnemyFactory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase que implementa el comportamiento del botón de huir.
 */
public class FleeButtonListener implements ActionListener {

	// Enemigo al que se le aplicará el comportamiento de huir.
	private Enemy enemy;

	/**
	 * Constructor de la clase.
	 *
	 * @param enemy Enemigo al que se le aplicará el comportamiento de huir.
	 */
	public FleeButtonListener(Enemy enemy) {

		this.enemy = enemy;
	}

	/**
	 * Método que se ejecuta al hacer clic en el botón de huir.
	 *
	 * @param e Evento de acción.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// Se obtiene la instancia del jugador.
		Player player = Player.getInstance();
		// Se intenta huir del enemigo.
		try {
			// Si la velocidad del jugador es mayor que la velocidad ajustada del enemigo,
			// el jugador tratará de huir.
			if (player.getSpeed() > enemy.getAdjustedSpeed()) {
				// Se intenta huir.
				player.tryToFlee();
				// En caso de no poder huir, es el enemigo quien atacará.
				enemy.attack();
				// Si el enemigo muere o escapa se lanza una excepción.
				if (enemy.isDead()) throw new EnemyDeadException();
			} else {
				// En caso contrario el enemigo atacará y el jugador tratará de huir.
				enemy.attack();
				// Si el enemigo muere o escapa se lanza una excepción.
				if (enemy.isDead()) throw new EnemyDeadException();
				// Se intenta huir.
				player.tryToFlee();
			}
			// Se actualizan los paneles.
			updatePanels(player);
		} catch (EnemyDeadException ex) {
			// Si el enemigo muere o huye haremos esto.
			// Se genera un nuevo enemigo.
			enemy = EnemyFactory.generateRegularEnemy();
			// Se actualiza la instancia del enemigo en la ventana de juego.
			GameWindow.getInstance(player).setEnemy(enemy);
			// Se actualizan los paneles.
			updatePanels(player);
		}
	}

	private void updatePanels(Player player) {

		GameWindow.getInstance(player).repaint();
		StatusPanel.getInstance(0).update();
		MainPanel.getInstance(enemy).update(enemy);
		PlayerPanel.getInstance(player).update();
		EnemyPanel.getInstance(enemy).setEnemy(enemy);
		EnemyPanel.getInstance(enemy).update();
	}
}
