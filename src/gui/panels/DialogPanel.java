package gui.panels;

import util.managers.FontManager;
import util.managers.ImageManager;

import javax.swing.*;
import java.awt.*;

public class DialogPanel extends BackGroundPanel {

	private static DialogPanel instance;
	private JPanel mainPanel;
	private JTextArea dialogBox;
	private JScrollPane scrollPanel;

	public static DialogPanel getInstance() {

		if (instance == null) {

			instance = new DialogPanel(ImageManager.getInstance().getImage("dialogPanel"),
					new Dimension(500, 182));
		}
		return instance;
	}

	private DialogPanel(Image image, Dimension dimension) {

		super(image, dimension);
		add(mainPanel);
		scrollPanel.getViewport().setOpaque(false);
		scrollPanel.setOpaque(false);
		scrollPanel.setBorder(null);
		scrollPanel.getVerticalScrollBar().setOpaque(false);
		dialogBox.setOpaque(false);
		dialogBox.setLineWrap(true);
		dialogBox.setWrapStyleWord(true);
		dialogBox.setFont(FontManager.getInstance().getFont("Standard"));
		dialogBox.setForeground(Color.WHITE);
		dialogBox.setBorder(null);
		dialogBox.setBackground(null);
		dialogBox.setMargin(new Insets(10, 10, 10, 10));
		dialogBox.setEditable(false);
		dialogBox.setAutoscrolls(true);
		scrollPanel.setAutoscrolls(true);
	}

	public void addText(String text) {

		SwingUtilities.invokeLater(() -> {
			dialogBox.append(text);
			dialogBox.setCaretPosition(dialogBox.getDocument().getLength());
		});
	}

	public JPanel getBackgroundPanel() {

		return mainPanel;
	}

	public JTextArea getDialogBox() {

		return dialogBox;
	}

	public JScrollPane getScrollPanel() {

		return scrollPanel;
	}
}
