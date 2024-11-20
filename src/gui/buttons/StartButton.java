package gui.buttons;

import gui.GameWindow;
import gui.NewGameWindow;
import player.Player;

public class StartButton extends ActionButton {


	public StartButton(NewGameWindow window) {

		super("Iniciar");
		// Asignamos la acción de iniciar el juego
		addActionListener(e -> {

			// Obtenemos el jugador y la ventana de inicio de juego
			Player player = Player.getInstance(window.getPlayerName());
			// Cerramos la ventana de inicio de juego y abrimos la ventana de juego
			window.dispose();
			// Iniciamos el juego
			GameWindow.getInstance(player).startGame();
		});
	}
}
