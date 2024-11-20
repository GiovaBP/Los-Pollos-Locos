package gui.panels;

import player.Player;
import gui.labels.StatLabel;
import util.managers.ImageManager;

import javax.swing.*;
import java.awt.*;

public class StatusPanel extends JPanel {

	private static StatusPanel instance;
	private final Image img;
	private final Player player;
	private final ActionsPanel actionsPanel;
	private final int tabIndex;
	private JPanel backgroundPanel;
	private JLabel levelLabel;
	private JLabel attackLabel;
	private JLabel defenseLabel;
	private JLabel goldLabel;
	private JLabel intLabel;
	private JLabel resLabel;
	private JLabel luckLabel;
	private JLabel desLabel;
	private JLabel speedLabel;
	private JLabel weaponLabel;
	private JLabel headArmorLabel;
	private JLabel chestArmorLabel;
	private JLabel feetArmorLabel;
	private JLabel legArmorLabel;
	private JLabel handArmorLabel;

	public static StatusPanel getInstance(int tabIndex) {

		if (instance == null) {

			instance = new StatusPanel(tabIndex, Player.getInstance());
		}
		return instance;
	}

	/**
	 * Constructor de la clase
	 *
	 * @param tabIndex índice de la pestaña
	 * @param player   jugador
	 */
	private StatusPanel(int tabIndex, Player player) {

		this.player = player;
		img = ImageManager.getInstance().getImage("statusPanel");
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
		setName("Estado");
		update();
	}

	public void update() {

		levelLabel.setText("EXP: " + player.getExperience());
		attackLabel.setText(player.getDisplayAttack());
		defenseLabel.setText(player.getDisplayDefense());
		goldLabel.setText("ORO: " + player.getGold());
		intLabel.setText(player.getDisplayIntelligence());
		resLabel.setText(player.getDisplayResistance());
		luckLabel.setText(player.getDisplayLuck());
		desLabel.setText(player.getDisplayDexterity());
		speedLabel.setText(player.getDisplaySpeed());
		weaponLabel.setText(player.getWeapon() != null ? player.getWeapon().getName() : "No equipado");
		headArmorLabel.setText(player.getHeadArmor() != null ? player.getHeadArmor().getName() : "No equipado");
		chestArmorLabel.setText(player.getChestArmor() != null ? player.getChestArmor().getName() : "No equipado");
		feetArmorLabel.setText(player.getFootArmor() != null ? player.getFootArmor().getName() : "No equipado");
		legArmorLabel.setText(player.getLegArmor() != null ? player.getLegArmor().getName() : "No equipado");
		handArmorLabel.setText(player.getHandArmor() != null ? player.getHandArmor().getName() : "No equipado");
		repaint();
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

		levelLabel = new StatLabel("EXP: " + player.getExperience(),
				new ImageIcon("img/ui/holders/expHolder.png").getImage());
		attackLabel = new StatLabel(player.getDisplayAttack(),
				new ImageIcon("img/ui/holders/attackHolder.png").getImage());
		defenseLabel = new StatLabel(player.getDisplayDefense(),
				new ImageIcon("img/ui/holders/defenseHolder.png").getImage());
		goldLabel = new StatLabel("ORO: " + player.getGold(),
				new ImageIcon("img/ui/holders/goldHolder.png").getImage());
		intLabel = new StatLabel(player.getDisplayIntelligence(),
				new ImageIcon("img/ui/holders/intHolder.png").getImage());
		resLabel = new StatLabel(player.getDisplayResistance(),
				new ImageIcon("img/ui/holders/resHolder.png").getImage());
		luckLabel = new StatLabel(player.getDisplayLuck(),
				new ImageIcon("img/ui/holders/lukHolder.png").getImage());
		desLabel = new StatLabel(player.getDisplayDexterity(),
				new ImageIcon("img/ui/holders/dexterityHolder.png").getImage());
		speedLabel = new StatLabel(player.getDisplaySpeed(),
				new ImageIcon("img/ui/holders/velHolder.png").getImage());
		weaponLabel = new StatLabel(player.getWeapon() != null ? player.getWeapon().getName() : "No equipado",
				new ImageIcon("img/ui/holders/weaponHolder.png").getImage());
		headArmorLabel = new StatLabel(player.getHeadArmor() != null ? player.getHeadArmor().getName() : "No equipado",
				new ImageIcon("img/ui/holders/headArmorHolder.png").getImage());
		chestArmorLabel = new StatLabel(player.getChestArmor() != null ? player.getChestArmor().getName() : "No equipado",
				new ImageIcon("img/ui/holders/chestArmorHolder.png").getImage());
		feetArmorLabel = new StatLabel(player.getFootArmor() != null ? player.getFootArmor().getName() : "No equipado",
				new ImageIcon("img/ui/holders/feetArmorHolder.png").getImage());
		legArmorLabel = new StatLabel(player.getLegArmor() != null ? player.getLegArmor().getName() : "No equipado",
				new ImageIcon("img/ui/holders/legArmorHolder.png").getImage());
		handArmorLabel = new StatLabel(player.getHandArmor() != null ? player.getHandArmor().getName() : "No equipado",
				new ImageIcon("img/ui/holders/handArmorHolder.png").getImage());
	}
}
