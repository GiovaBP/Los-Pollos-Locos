package gui.buttons;

import gui.events.EquipButtonListener;
import items.Item;

public class EquipButton extends ActionButton {

	public EquipButton(Item item) {

		super("Equipar");
		addActionListener(new EquipButtonListener(item));
	}
}
