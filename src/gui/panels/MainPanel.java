package gui.panels;

import enemies.Enemy;
import player.Player;
import gui.labels.SpriteLabel;
import util.managers.ImageManager;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends BackGroundPanel {

	private static MainPanel instance;
	private Enemy enemy;
	private JPanel mainPanel;
	private JPanel spritesPanel;
	private JPanel dialogPanel;
	private JLabel enemySprite;
	private JLabel playerSprite;

	public static MainPanel getInstance(Enemy enemy) {

		if (instance == null) {
			instance = new MainPanel(enemy, ImageManager.getInstance().getImage("charactersPanel"),
					new Dimension(512, 360));
		}
		return instance;
	}

	private MainPanel(Enemy enemy, Image image, Dimension dimension) {

		super(image, dimension);
		this.enemy = enemy;
		add(mainPanel);
	}

	public void update(Enemy enemy) {

		((SpriteLabel) enemySprite).updateImage(enemy.getImage());
		repaint();
	}

	private void createUIComponents() {

		dialogPanel = DialogPanel.getInstance();
		playerSprite = new SpriteLabel(Player.getInstance().getImage());
		enemySprite = new SpriteLabel(enemy.getImage());
	}

	public void setEnemy(Enemy enemy) {

		this.enemy = enemy;
	}

	public JPanel getSpritesPanel() {

		return spritesPanel;
	}

	public JPanel getDialogPanel() {

		return dialogPanel;
	}

	public JLabel getPlayerSprite() {

		return playerSprite;
	}
}
