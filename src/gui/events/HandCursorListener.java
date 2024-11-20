package gui.events;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class HandCursorListener implements MouseMotionListener {

	private JTabbedPane tabbedPane;

	public HandCursorListener(JTabbedPane tabbedPane) {

		this.tabbedPane = tabbedPane;
	}

	@Override
	public void mouseDragged(MouseEvent e) {

	}

	@Override
	public void mouseMoved(MouseEvent e) {

		int tabIndex = this.tabbedPane.indexAtLocation(e.getX(), e.getY());
		if (tabIndex != -1) {

			this.tabbedPane.setCursor(new Cursor(Cursor.HAND_CURSOR));
		} else {

			this.tabbedPane.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}
	}
}
