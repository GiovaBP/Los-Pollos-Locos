package gui.panels;

import gui.events.HandCursorListener;
import gui.tabs.GameTab;

import javax.swing.*;
import java.awt.*;

public class ActionsPanel extends JTabbedPane {

	private static ActionsPanel instance;

	public static ActionsPanel getInstance() {

		if (instance == null) {

			instance = new ActionsPanel();
		}
		return instance;
	}

	private ActionsPanel() {

		super();
		Dimension size = new Dimension(1024, 384);
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setSize(size);
		setOpaque(false);
		setUI(new GameTab());
		addMouseMotionListener(new HandCursorListener(this));
	}
}
