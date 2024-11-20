package gui.buttons;

public class ExitButton extends ActionButton {

	public ExitButton() {

		super("Salir");
		addActionListener(e -> System.exit(0));
	}
}
