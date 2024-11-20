package gui.labels;

import javax.swing.*;
import java.awt.*;

public class SpriteLabel extends JLabel {

	private Image image;

	public SpriteLabel(Image image) {

		this.image = image;
		Dimension size = new Dimension(256, 161);
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setSize(size);
		setOpaque(false);
		setVisible(true);
	}

	public void updateImage(Image image) {

		this.image = image;
		repaint();
	}

	@Override
	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		int w = Math.min(image.getWidth(null), 256);
		int h = Math.min(image.getHeight(null), 161);
		int x = (256 - w) / 2;
		int y = (161 - h) / 2;
		g2d.drawImage(image, x, y, w, h, null);
	}
}
