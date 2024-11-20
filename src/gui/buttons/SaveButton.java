package gui.buttons;

import gui.panels.DialogPanel;
import player.Player;
import util.managers.FileManager;

public class SaveButton extends ActionButton {

	public SaveButton(Player player) {

		super("Guardar");
		// Asignar la acción de guardar el avance del jugador en el archivo correspondiente
		addActionListener(e -> {
			// Save the game
			FileManager.saveGame(player);
			// Agregamos un texto al panel de diálogo para indicar que la partida se guardó correctamente
			DialogPanel.getInstance().addText("""
					------------------------------------------------
					¡Partida guardada correctamente!
					------------------------------------------------
					""");
		});
	}
}