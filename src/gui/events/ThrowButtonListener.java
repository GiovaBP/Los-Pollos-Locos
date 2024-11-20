package gui.events;

import gui.panels.DialogPanel;
import gui.panels.InventoryPanel;
import gui.panels.PlayerPanel;
import gui.panels.StatusPanel;
import items.Item;
import player.Player;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ThrowButtonListener implements ActionListener {

	private final Item item;

	public ThrowButtonListener(Item item) {

		this.item = item;
	}

	@Override
	public void actionPerformed(ActionEvent evt) {

		Player player = Player.getInstance();
		player.getInventory().removeItem(item);
		DialogPanel.getInstance().addText(
				String.format("Tiraste %s.\n", item.getName()));
		updatePanels();
	}

	/**
	 * Método que actualiza los paneles de la interfaz gráfica.
	 */
	private void updatePanels() {

		Player player = Player.getInstance();
		// Actualizamos los paneles
		StatusPanel.getInstance(0).update();
		PlayerPanel.getInstance(player).update();
		InventoryPanel.getInstance(2).update();
	}
}
