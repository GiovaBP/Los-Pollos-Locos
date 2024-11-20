package gui.buttons;

import gui.events.SkillButtonListener;
import player.skills.Skill;

public class SkillButton extends ActionButton {


	public SkillButton(Skill skill) {

		super("Usar");
		addActionListener(new SkillButtonListener(skill));
	}
}
