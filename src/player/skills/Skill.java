package player.skills;

import enemies.Enemy;
import gui.GameWindow;
import gui.buttons.SkillButton;
import gui.panels.*;
import player.Player;

import java.io.Serializable;

public abstract class Skill implements Serializable {

	protected String name;
	protected String description;
	protected int level;
	protected int manaCost;
	protected SkillButton button;

	public Skill(String name, String description, int level, int manaCost) {

		this.name = name;
		this.description = description;
		this.level = level;
		this.manaCost = manaCost;
		this.button = new SkillButton(this);
	}

	protected void updatePanels(Player player) {

		Enemy enemy = GameWindow.getInstance(player).getEnemy();
		// Actualizamos los paneles
		GameWindow.getInstance(player).repaint();
		StatusPanel.getInstance(0).update();
		MainPanel.getInstance(enemy).update(enemy);
		PlayerPanel.getInstance(player).update();
		EnemyPanel.getInstance(enemy).setEnemy(enemy);
		EnemyPanel.getInstance(enemy).update();
		InventoryPanel.getInstance(2).update();
	}

	protected abstract void skillAction();

	public void activate() {

		if (Player.getInstance().getMp() < manaCost) {

			DialogPanel.getInstance().addText("No tienes suficiente mana para usar esta habilidad\n");
		} else {
			skillAction();
		}
	}

	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name = name;
	}

	public String getDescription() {

		return description;
	}

	public int getLevel() {

		return level;
	}

	public int getManaCost() {

		return manaCost;
	}

	public SkillDetail getSkillDetailPanel() {

		return new SkillDetail(this);
	}

	public SkillButton getButton() {

		return button;
	}
}
