package gui.tabs;

import util.managers.ImageManager;

import javax.swing.plaf.basic.BasicTabbedPaneUI;
import java.awt.*;

public class InventoryTab extends BasicTabbedPaneUI {

	@Override
	protected int calculateTabWidth(int tabPlacement, int tabIndex, FontMetrics metrics) {

		return 49;
	}

	@Override
	protected int calculateTabHeight(int tabPlacement, int tabIndex, int fontHeight) {

		return 24;
	}

	@Override
	protected void paintTab(Graphics g, int tabPlacement, Rectangle[] rects, int tabIndex, Rectangle iconRect, Rectangle textRect) {

		Image img;
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		img = switch (tabIndex) {
			case 0 -> ImageManager.getInstance().getImage(
					tabIndex == tabPane.getSelectedIndex() ? "weaponTab" : "weaponTabInactive");
			case 1 -> ImageManager.getInstance().getImage(
					tabIndex == tabPane.getSelectedIndex() ? "armorTab" : "armorTabInactive");
			default -> ImageManager.getInstance().getImage(
					tabIndex == tabPane.getSelectedIndex() ? "miscTab" : "miscTabInactive");
		};
		int imgX = rects[tabIndex].x + (rects[tabIndex].width - img.getWidth(null)) / 2;
		int imgY = rects[tabIndex].y + (rects[tabIndex].height - img.getHeight(null)) / 2;
		g2d.drawImage(img, imgX, imgY, img.getWidth(null), img.getHeight(null), null);
		if (tabIndex == tabPane.getSelectedIndex()) {

			paintFocusIndicator(g, tabPlacement, rects, tabIndex, iconRect, textRect, true);
		}
	}

	@Override
	protected void paintContentBorder(Graphics g, int tabPlacement, int selectedIndex) {


	}
}
