package gui.buttons;

import gui.events.BuyButtonListener;
import items.Item;

public class BuyButton extends ActionButton {

	public BuyButton(Item item) {

		super("Comprar");
		addActionListener(new BuyButtonListener(item));
	}
}