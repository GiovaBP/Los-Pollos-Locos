package gui.buttons;

import gui.events.ThrowButtonListener;
import items.Item;

public class ThrowButton extends ActionButton {

	public ThrowButton(Item item) {

		super("Tirar");
		addActionListener(new ThrowButtonListener(item));
	}
}
