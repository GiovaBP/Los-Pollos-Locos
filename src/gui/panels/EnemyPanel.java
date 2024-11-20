package gui.panels;

import enemies.Enemy;
import gui.labels.HpLabel;
import gui.labels.RedTextLabel;
import player.Stats;
import util.managers.ImageManager;

import javax.swing.*;
import java.awt.*;

public class EnemyPanel extends BackGroundPanel {

	private static EnemyPanel instance;
	private JPanel mainPanel;
	private JLabel enemyName;
	private JLabel hpLabel;
	private JLabel attackLabel;
	private JLabel defenseLabel;
	private JLabel speedLabel;
	private JLabel expLabel;
	private JLabel goldLabel;
	private Enemy enemy;

	public static EnemyPanel getInstance(Enemy enemy) {

		if (instance == null) {
			instance = new EnemyPanel(enemy, ImageManager.getInstance().getImage("enemyPanel"),
					new Dimension(256, 360));
		}
		return instance;
	}

	private EnemyPanel(Enemy enemy, Image image, Dimension dimension) {

		super(image, dimension);
		this.enemy = enemy;
		add(mainPanel);
		update();
	}

	public void update() {

		enemyName.setText(enemy.getName());
		((HpLabel) hpLabel).updateCharacter(enemy);
		attackLabel.setText(String.format("%s: %d", Stats.ATTACK.getName(),
				enemy.getAdjustedAttack()));
		defenseLabel.setText(String.format("%s: %d", Stats.DEFENSE.getName(),
				enemy.getAdjustedDefense()));
		speedLabel.setText(String.format("%s: %d", Stats.SPEED.getName(),
				enemy.getAdjustedSpeed()));
		expLabel.setText(String.format("EXP: %d", enemy.getExperience()));
		goldLabel.setText(String.format("ORO: %d", enemy.getGold()));
		repaint();
	}

	private void createUIComponents() {
		//Agregamos la etiqueta del nombre
		enemyName = new RedTextLabel(enemy.getName());
		//Agregamos la etiqueta de los puntos de vida
		hpLabel = new HpLabel(enemy);
		//Agregamos la etiqueta del ataque
		attackLabel = new RedTextLabel(String.format("%s: %d", Stats.ATTACK.getName(),
				enemy.getAdjustedAttack()));
		//Agregamos la etiqueta de la defensa
		defenseLabel = new RedTextLabel(String.format("%s: %d", Stats.DEFENSE.getName(),
				enemy.getAdjustedDefense()));
		//Agregamos la etiqueta de la velocidad
		speedLabel = new RedTextLabel(String.format("%s: %d", Stats.SPEED.getName(),
				enemy.getAdjustedSpeed()));
		//Agregamos la etiqueta de la experiencia
		expLabel = new RedTextLabel(String.format("EXP: %d", enemy.getExperience()));
		//Agregamos la etiqueta del oro
		goldLabel = new RedTextLabel(String.format("ORO: %d", enemy.getGold()));
	}

	public void setEnemy(Enemy enemy) {

		this.enemy = enemy;
	}
}