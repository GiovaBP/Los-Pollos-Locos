package gui.panels;

import gui.events.HandCursorListener;
import gui.tabs.InventoryTab;
import items.ItemType;
import player.Player;
import util.managers.ImageManager;

import javax.swing.*;
import java.awt.*;

public class InventoryPanel extends JPanel {

	private static InventoryPanel instance;
	private final Image img;
	private final Player player;
	private final ActionsPanel actionsPanel;
	private final int tabIndex;
	private JPanel backgroundPanel;
	private JTabbedPane itemDisplayPanel;
	private JPanel weaponsPanel;
	private JPanel armorsPanel;
	private JPanel miscsPanel;

	public static InventoryPanel getInstance(int tabIndex) {

		if (instance == null) {

			instance = new InventoryPanel(tabIndex);
		}
		return instance;
	}

	@Override
	public void update(Graphics g) {

		super.update(g);
		revalidate();
		repaint();
	}

	private InventoryPanel(int tabIndex) {

		player = Player.getInstance();
		itemDisplayPanel.setUI(new InventoryTab());
		img = ImageManager.getInstance().getImage("inventoryPanel");
		this.tabIndex = tabIndex;
		this.actionsPanel = ActionsPanel.getInstance();
		Dimension size = new Dimension(1019, 342);
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setSize(size);
		add(backgroundPanel);
		setOpaque(false);
		setBackground(null);
		setMixingCutoutShape(new Rectangle(0, 0, 0, 0));
		setName("Inventario");
		itemDisplayPanel.addMouseMotionListener(new HandCursorListener(itemDisplayPanel));
	}

	/**
	 * Método que inicializa el panel
	 */
	@Override
	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.drawImage(img, 0, 0, 1019, 342, null);
	}

	private void createUIComponents() {

		weaponsPanel = new ItemPanel(ItemType.WEAPON);
		armorsPanel = new ItemPanel(ItemType.ARMOR);
		miscsPanel = new ItemPanel(ItemType.MISC);
	}

	public void update() {

		((ItemPanel) weaponsPanel).initComponents();
		((ItemPanel) armorsPanel).initComponents();
		((ItemPanel) miscsPanel).initComponents();
	}
}
