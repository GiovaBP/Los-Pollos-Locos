package gui.buttons;

import enemies.Enemy;
import gui.events.AttackButtonListener;

public class AttackButton extends ActionButton {

	// Constructor que recibe un enemigo como parámetro
	public AttackButton(Enemy enemy) {

		super("Atacar");
		// Asignar la acción de atacar al enemigo
		addActionListener(new AttackButtonListener(enemy));
	}
}
