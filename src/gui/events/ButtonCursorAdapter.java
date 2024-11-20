package gui.events;

import gui.buttons.ActionButton;

import java.awt.event.MouseAdapter;

public class ButtonCursorAdapter extends MouseAdapter {

	private ActionButton button;

	public ButtonCursorAdapter(ActionButton button) {

		this.button = button;
	}

	// Cuando el mouse entra en el botón
	public void mouseEntered(java.awt.event.MouseEvent evt) {

		button.setImage(button.getRolloverIcon());
		button.setTopPadding(0); // Establecemos el padding superior en 0
		button.repaint();
	}

	// Cuando el mouse sale del botón
	public void mouseExited(java.awt.event.MouseEvent evt) {

		button.setImage(button.getIcon());
		button.setTopPadding(2); // Establecemos el padding superior en 2
		button.repaint();
	}
}
