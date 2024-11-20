package gui.events;

import gui.panels.InventoryPanel;
import gui.panels.PlayerPanel;
import gui.panels.StatusPanel;
import items.Item;
import items.armors.Armor;
import items.weapons.Weapon;
import player.Player;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EquipButtonListener implements ActionListener {

	private final Item item;

	public EquipButtonListener(Item item) {

		this.item = item;
	}

	@Override
	public void actionPerformed(ActionEvent evt) {

		Player player = Player.getInstance();
		// Equipamos el item
		switch (item.getType()) {
			case WEAPON -> equipWeapon((Weapon) item);
			case ARMOR -> equipArmor((Armor) item);
		}
		// Actualizamos los paneles
		updatePanels();
	}

	private void equipWeapon(Weapon weapon) {

		Player player = Player.getInstance();
		Weapon equippedWeapon = player.getWeapon();
		// La eliminamos del inventario
		player.getInventory().removeItem(weapon);
		// Si el jugador ya tiene un arma equipada
		if (equippedWeapon != null) {
			// La añadimos al inventario
			player.getInventory().addItem(equippedWeapon);
		}
		// Equipamos el arma
		player.equipWeapon(weapon);
	}

	private void equipArmor(Armor armor) {

		Player player = Player.getInstance();
		Armor equippedArmor =
				switch (armor.getArmorType()) {
					case HEAD -> player.getHeadArmor();
					case CHEST -> player.getChestArmor();
					case LEGS -> player.getLegArmor();
					case HANDS -> player.getHandArmor();
					case FEET -> player.getFootArmor();
					default -> null;
				};
		// La eliminamos del inventario
		player.getInventory().removeItem(armor);
		// Si el jugador ya tiene una armadura equipada
		if (equippedArmor != null) {
			// La añadimos al inventario
			player.getInventory().addItem(equippedArmor);
		}
		// Equipamos la armadura
		player.equipArmor(armor);
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
