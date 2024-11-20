package gui.buttons;

import gui.events.SellButtonListener;
import items.Item;

public class SellButton extends ActionButton{

	public SellButton(Item item) {

		super("Vender");
		addActionListener(new SellButtonListener(item));
	}
}
