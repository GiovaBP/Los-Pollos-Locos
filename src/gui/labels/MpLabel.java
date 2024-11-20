package gui.labels;

import characters.BasicCharacter;

import javax.swing.*;
import java.awt.*;

public class MpLabel extends JLabel {

	private BasicCharacter character;
	private Image image;
	private String displayText;

	public MpLabel(BasicCharacter character) {

		super(character.getName());
		this.character = character;
		init();
		Font font = new Font("Arial", Font.BOLD, 15);
		Dimension size = new Dimension(image.getWidth(null), image.getHeight(null) + 10);
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setSize(size);
		setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
		setFont(font);
	}

	private void init() {

		displayText = String.format("%d/%d", character.getMp(), character.getMaxMp());
		double hpPercentage = (double) character.getMp() / character.getMaxMp();
		Color color;
		if (hpPercentage >= .8) {
			image = new ImageIcon("img/player/mp100.png").getImage();
			color = new Color(0, 0, 0, 255);
		} else if (hpPercentage > 0.6) {
			image = new ImageIcon("img/player/mp80.png").getImage();
			color = new Color(0, 0, 0, 255);
		} else if (hpPercentage > 0.4) {
			image = new ImageIcon("img/player/mp60.png").getImage();
			color = new Color(109, 109, 109, 255);
		} else if (hpPercentage > 0.2) {
			image = new ImageIcon("img/player/mp40.png").getImage();
			color = new Color(109, 109, 109, 255);
		} else if (hpPercentage > 0) {
			image = new ImageIcon("img/player/mp20.png").getImage();
			color = new Color(109, 109, 109, 255);
		} else {
			image = new ImageIcon("img/player/mp0.png").getImage();
			color = new Color(255, 255, 255, 255);
		}
		setForeground(color);
	}

	public void updateCharacter(BasicCharacter character) {

		this.character = character;
		init();
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g2d.drawImage(image, 0, 10, null);
		int textPositionY = image.getHeight(null) / 2 + 11 + g2d.getFontMetrics().getHeight() / 4;
		int textPositionX = ((image.getWidth(null) - 28) / 2) -
		                    (g2d.getFontMetrics().stringWidth(displayText) / 2) - 7;
		g2d.translate(textPositionX, textPositionY);
		g2d.drawString(displayText, 0, 0);
	}

	public void setText(String text){

		this.displayText = text;
		repaint();
	}
}
