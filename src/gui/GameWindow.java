package gui;

import enemies.Enemy;
import player.Player;
import util.enemies.EnemyFactory;
import gui.panels.*;

import javax.swing.*;

/**
 * Clase que representa la ventana principal del juego
 */
public class GameWindow extends JFrame {

	/**
	 * Instancia de la ventana principal
	 */
	private static GameWindow instance;
	/**
	 * Panel principal de la ventana
	 */
	private JPanel backgroundPanel;
	private Player player;
	private Enemy enemy;
	private JTabbedPane actionTabs;
	private JPanel topPanel;
	private JPanel playerPanel;
	private JPanel enemyPanel;
	private JPanel mainPanel;
	private JPanel statusPanel;
	private JPanel battlePanel;
	private JPanel inventoryPanel;

	/**
	 * Método que devuelve la instancia de la ventana principal
	 *
	 * @return instancia de la ventana principal
	 */
	public static synchronized GameWindow getInstance(Player player) {

		//Si la instancia es nula, la creamos
		if (instance == null) {

			instance = new GameWindow(player);
		}
		//Devolvemos la instancia
		return instance;
	}

	/**
	 * Constructor de la clase
	 */
	private GameWindow(Player player) {

		this.player = player;
	}

	/**
	 * Método que inicializa la ventana
	 */
	public void startGame() {

		//Título de la Ventana
		setTitle("Game Window");
		//Operación por defecto de cierre
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		//No la hacemos escalable
		setResizable(false);
		//Agregamos el panel principal
		add(backgroundPanel);
		//Tamaño de la ventana
		pack();
		//Centramos la ventana
		setLocationRelativeTo(null);
		//Hacemos visible la ventana
		setVisible(true);
	}

	public static void main(String[] args) {

		//Obtenemos la instancia de la ventana principal
		GameWindow.getInstance(Player.getInstance()).startGame();
	}

	private void createUIComponents() {

		DialogPanel.getInstance().addText("¡Bienvenido a la aventura!\n");
		//Agregamos el panel del jugador
		playerPanel = PlayerPanel.getInstance(player);
		//Agregamos el enemigo
		enemy = EnemyFactory.generateRegularEnemy();
		//Agregamos el panel del enemigo
		enemyPanel = EnemyPanel.getInstance(enemy);
		//Agregamos el panel principal
		mainPanel = MainPanel.getInstance(enemy);
		//Agregamos las pestañas
		actionTabs = ActionsPanel.getInstance();
		//Agregamos el panel de estado
		statusPanel = StatusPanel.getInstance(0);
		//Agregamos el panel de batalla
		battlePanel = BattlePanel.getInstance(1, enemy);
		//Agregamos el panel de inventario
		inventoryPanel = InventoryPanel.getInstance(2);
	}

	public Player getPlayer() {

		return player;
	}

	public void setPlayer(Player player) {

		this.player = player;
	}

	public Enemy getEnemy() {

		return enemy;
	}

	public void setEnemy(Enemy enemy) {

		BattlePanel.getInstance(1, this.enemy).setEnemy(enemy);
		this.enemy = enemy;
	}
}
