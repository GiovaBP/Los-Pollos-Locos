package gui;

import gui.buttons.ExitButton;
import gui.buttons.StartButton;
import gui.labels.PortraitLabel;
import util.managers.FontManager;
import util.managers.ImageManager;

import javax.swing.*;
import java.awt.*;

public class NewGameWindow extends JFrame {

	private JPanel backgroundPanel;
	private JButton exitButton;
	private JButton startButton;
	private JTextArea welcomeText;
	private JTextField playerName;
	private JLabel playerLabel;
	private JLabel portraitLabel;

	public NewGameWindow() {

		setTitle("New Game");
		add(backgroundPanel);
		pack();
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		welcomeText.append("¡Bienvenido al mundo de JavaRPG!\n");
		welcomeText.append("¿Estás listo para comenzar tu aventura?\n");
		welcomeText.append("¡Elige tu nombre de jugador y comencemos!");
		welcomeText.setOpaque(false);
		welcomeText.setEditable(false);
		welcomeText.setFont(FontManager.getInstance().getFont("Standard"));
		welcomeText.setForeground(Color.WHITE);
		playerName.setFont(FontManager.getInstance().getFont("Standard"));
		playerName.setForeground(Color.WHITE);
		playerLabel.setFont(FontManager.getInstance().getFont("Standard"));
		playerLabel.setForeground(Color.WHITE);
	}

	private void createUIComponents() {

		backgroundPanel = new JPanel() {

			@Override
			public void paintComponent(Graphics g) {

				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g;
				g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				g2d.drawImage(ImageManager.getInstance().getImage("skillPanel"), 0, 0, null);
			}
		};
		portraitLabel = new PortraitLabel();
		startButton = new StartButton(this);
		exitButton = new ExitButton();
	}

	public String getPlayerName() {

		return playerName.getText();
	}
}
