package gui.buttons;

import enemies.Enemy;
import gui.events.FleeButtonListener;

public class FleeButton extends ActionButton {

	public FleeButton(Enemy enemy) {

		super("Huir");
		addActionListener(new FleeButtonListener(enemy));
	}
}
