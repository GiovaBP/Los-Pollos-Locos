package gui.panels;

import gui.buttons.SkillButton;
import player.skills.Skill;
import util.managers.FontManager;
import util.managers.ImageManager;

import javax.swing.*;
import java.awt.*;

public class SkillDetail extends BackGroundPanel {


	private JLabel skillNameLabel;
	private JLabel manaCostLabel;
	private JLabel skillDetailLabel;
	private JButton useSkillButton;
	private JPanel mainPanel;
	private final Skill skill;

	public SkillDetail(Skill skill) {

		super(ImageManager.getInstance().getImage("skillDetailPanel"),
				new Dimension(530, 116));
		this.skill = skill;
		add(mainPanel);
		skillNameLabel.setText(skill.getName());
		skillNameLabel.setFont(FontManager.getInstance().getFont("Standard"));
		manaCostLabel.setText(String.format("(MP: %d)", skill.getManaCost()));
		manaCostLabel.setFont(FontManager.getInstance().getFont("Standard"));
		skillDetailLabel.setText(skill.getDescription());
		skillDetailLabel.setFont(FontManager.getInstance().getFont("Standard"));
	}

	private void createUIComponents() {

		useSkillButton = new SkillButton(skill);
	}

	public JButton getUseSkillButton() {

		return useSkillButton;
	}
}
