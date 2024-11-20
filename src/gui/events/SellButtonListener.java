package gui.events;

import gui.panels.DialogPanel;
import gui.panels.InventoryPanel;
import gui.panels.PlayerPanel;
import gui.panels.StatusPanel;
import items.Item;
import player.Player;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SellButtonListener implements ActionListener {

	private final Item item;

	public SellButtonListener(Item item) {

		this.item = item;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Player player = Player.getInstance();
		player.getInventory().removeItem(item);
		player.setGold(player.getGold() + item.getPrice());
		DialogPanel.getInstance().addText(
				String.format("Vendiste %s por %d.\n", item.getName(), item.getPrice()));
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
