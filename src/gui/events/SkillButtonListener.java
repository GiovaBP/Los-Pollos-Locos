package gui.events;

import player.skills.Skill;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SkillButtonListener implements ActionListener {

	private final Skill skill;

	public SkillButtonListener(Skill skill) {

		this.skill = skill;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		skill.activate();
	}
}
