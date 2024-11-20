package gui.panels;

import util.managers.ImageManager;

import javax.swing.*;
import java.awt.*;

public class ItemScrollPanel extends JScrollPane {

	public ItemScrollPanel(JPanel panel) {

		super(panel);
		setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		getVerticalScrollBar().setOpaque(false);
		getVerticalScrollBar().setBorder(null);
		getViewport().setOpaque(false);
		getViewport().setBorder(null);
		setOpaque(false);
		setBorder(null);
	}

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.drawImage(ImageManager.getInstance().getImage("skillPanel"), 0, 0,
				974, 291, null);
	}
}
