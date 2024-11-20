package gui.events;

import enemies.Enemy;
import gui.exceptions.EnemyDeadException;
import gui.exceptions.PlayerDeadException;
import gui.GameWindow;
import gui.panels.*;
import player.Player;
import util.enemies.EnemyFactory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase que implementa la interfaz ActionListener para manejar los eventos de los botones de ataque.
 */
public class AttackButtonListener implements ActionListener {

	// Enemigo al que se le va a atacar
	private Enemy enemy;

	// Constructor que recibe un enemigo como parámetro
	public AttackButtonListener(Enemy enemy) {

		this.enemy = enemy;
	}

	// Método que se ejecuta al presionar el botón de ataque
	@Override
	public void actionPerformed(ActionEvent e) {

		// Obtenemos las instancias de los paneles necesarios
		DialogPanel dialogPanel = DialogPanel.getInstance();
		// Obtenemos la instancia del jugador
		Player player = Player.getInstance();
		// Intentamos atacar al enemigo
		try {
			// Si la velocidad del jugador es mayor a la velocidad ajustada del enemigo
			if (player.getSpeed() > enemy.getAdjustedSpeed()) {
				// Si el jugador está muerto, lanzamos una excepción
				if (player.isDead()) throw new PlayerDeadException();
				// Si no, atacamos al enemigo
				player.attack(enemy);
				// Si el enemigo no está muerto
				if (!enemy.isDead()) {
					// El enemigo nos ataca
					enemy.attack();
					// Si escapa por una habilidad, para el sistema está muerto
					if (enemy.isDead()) throw new EnemyDeadException();
				} else throw new EnemyDeadException();
			} else {
				// Si el enemigo no está muerto, nos ataca
				enemy.attack();
				// Si escapa por una habilidad, para el sistema está muerto
				if (enemy.isDead()) throw new EnemyDeadException();
				// Atacamos al enemigo
				player.attack(enemy);
			}
			// Actualizamos los paneles
			updatePanels(player);
		} catch (EnemyDeadException ex) {
			// Si el enemigo está muerto o escapo por una habilidad
			// Creamos un nuevo enemigo
			enemy = EnemyFactory.generateRegularEnemy();
			// Asignamos el nuevo enemigo al panel de juego
			GameWindow.getInstance(player).setEnemy(enemy);
			// Actualizamos los paneles
			updatePanels(player);
		} catch (PlayerDeadException ex) {
			// Si el jugador está muerto, mostramos un mensaje de consolación
			dialogPanel.addText("¡Quizás deberías entrenar más duro!\n");
			// Revivimos al jugador
			player.revive();
			// Mostramos un mensaje de que el jugador fue revivido
			dialogPanel.addText("¡Has sido revivido!\n");
			// Creamos un nuevo enemigo
			enemy = EnemyFactory.generateRegularEnemy();
			// Asignamos el nuevo enemigo al panel de juego
			GameWindow.getInstance(player).setEnemy(enemy);
			// Actualizamos los paneles
			updatePanels(player);
		}
	}

	/**
	 * Método que actualiza los paneles de la interfaz gráfica.
	 *
	 * @param player Jugador actual
	 */
	private void updatePanels(Player player) {

		// Actualizamos los paneles
		GameWindow.getInstance(player).repaint();
		StatusPanel.getInstance(0).update();
		MainPanel.getInstance(enemy).update(enemy);
		PlayerPanel.getInstance(player).update();
		EnemyPanel.getInstance(enemy).setEnemy(enemy);
		EnemyPanel.getInstance(enemy).update();
		InventoryPanel.getInstance(2).update();
	}
}
