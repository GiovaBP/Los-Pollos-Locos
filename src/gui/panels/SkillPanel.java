package gui.panels;

import player.Player;
import player.skills.Skill;
import util.managers.ImageManager;

import javax.swing.*;
import java.awt.*;

public class SkillPanel extends BackGroundPanel {


	private JPanel mainPanel;
	private JPanel skillList;
	private JScrollPane scrollPanel;

	public SkillPanel() {

		super(ImageManager.getInstance().getImage("skillPanel"), new Dimension(560, 254));
		scrollPanel.getViewport().setOpaque(false);
		add(mainPanel);
		setOpaque(false);
		initSkills();
	}

	private void initSkills() {

		Player player = Player.getInstance();
		GridBagLayout layout = new GridBagLayout();
		layout.columnWidths = new int[]{540};
		layout.rowHeights = new int[]{106};
		skillList.setLayout(layout);
		skillList.setBorder(null);
		skillList.setOpaque(false);
		scrollPanel.setBorder(null);
		player.getSkillMap().forEach((k, v) -> addSkill(v));
	}

	private void addSkill(Skill skill) {

		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = skillList.getComponentCount();
		c.fill = GridBagConstraints.BOTH;
		c.anchor = GridBagConstraints.CENTER;
		c.weightx = 1;
		c.weighty = 1;
		skillList.add(skill.getSkillDetailPanel(), c);
		skillList.revalidate();
		skillList.repaint();
	}
}
