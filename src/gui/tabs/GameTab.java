package gui.tabs;

import util.managers.FontManager;
import util.managers.ImageManager;

import javax.swing.*;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import java.awt.*;

public class GameTab extends BasicTabbedPaneUI {

	private final Font tabFont;
	private final FontMetrics tabMetrics;

	public GameTab() {

		tabFont = FontManager.getInstance().getFont("Standard");
		tabMetrics = new JLabel().getFontMetrics(tabFont);
	}

	@Override
	protected int calculateTabWidth(int tabPlacement, int tabIndex, FontMetrics metrics) {

		return 100;
	}

	@Override
	protected int calculateTabHeight(int tabPlacement, int tabIndex, int fontHeight) {

		return 32;
	}

	@Override
	protected void paintTab(Graphics g, int tabPlacement, Rectangle[] rects, int tabIndex, Rectangle iconRect, Rectangle textRect) {

		Image img;
		String title = tabPane.getComponentAt(tabIndex).getName();
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g2d.setFont(tabFont);
		g2d.setColor(Color.BLACK);
		if (tabIndex == tabPane.getSelectedIndex()) {

			img = ImageManager.getInstance().getImage("inactiveTab");
		} else {

			img = ImageManager.getInstance().getImage("activeTab");
		}
		int imgX = rects[tabIndex].x + (rects[tabIndex].width - img.getWidth(null)) / 2;
		int imgY = rects[tabIndex].y + (rects[tabIndex].height - img.getHeight(null)) / 2;
		g2d.drawImage(img, imgX, imgY, img.getWidth(null), img.getHeight(null), null);
		int textX = rects[tabIndex].x + (rects[tabIndex].width - tabMetrics.stringWidth(title)) / 2;
		int textY;
		if (tabIndex == tabPane.getSelectedIndex()) {

			textY = rects[tabIndex].y + rects[tabIndex].height / 2 + tabMetrics.getHeight() / 4 + 2;
		} else {

			textY = rects[tabIndex].y + rects[tabIndex].height / 2 + tabMetrics.getHeight() / 4;
		}
		g2d.drawString(title, textX, textY);
	}

	@Override
	protected void paintContentBorder(Graphics g, int tabPlacement, int selectedIndex) {

	}
}
