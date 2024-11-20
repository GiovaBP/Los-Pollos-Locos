package gui.panels;

import javax.swing.*;
import java.awt.*;

public abstract class BackGroundPanel extends JPanel {

	protected Image image;
	protected Dimension dimension;

	public BackGroundPanel(Image image, Dimension dimension) {

		this.image = image;
		this.dimension = dimension;
		this.setSize(dimension);
		this.setMaximumSize(dimension);
		this.setMinimumSize(dimension);
		this.setPreferredSize(dimension);
		this.setOpaque(false);
	}

	@Override
	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.drawImage(image, 0, 0, dimension.width, dimension.height, null);
	}
}
