package gui.events;

import gui.panels.DialogPanel;
import gui.panels.InventoryPanel;
import gui.panels.PlayerPanel;
import gui.panels.StatusPanel;
import items.Item;
import player.Player;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuyButtonListener implements ActionListener {

	private final Item item;

	public BuyButtonListener(Item item) {

		this.item = item;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Player player = Player.getInstance();
		if (player.getGold() >= item.getPrice()) {
			player.getInventory().addItem(item);
			player.setGold(player.getGold() - item.getPrice());
			DialogPanel.getInstance().addText(
					String.format("Compraste %s por %d.\n", item.getName(), item.getPrice()));
		} else {
			DialogPanel.getInstance().addText("No tienes suficiente oro para comprar este objeto.\n");
		}
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