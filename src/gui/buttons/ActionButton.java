package gui.buttons;

import gui.events.ButtonCursorAdapter;
import util.managers.FontManager;
import util.managers.ImageManager;

import javax.swing.*;
import java.awt.*;

public abstract class ActionButton extends JButton {

	private String displayText;
	private Font font;
	private Icon image;
	private int topPadding;

	public ActionButton(String text) {

		// Inicializamos los atributos
		this.displayText = text;
		// Configuramos el botón
		// Establecemos las imágenes
		setIcon(new ImageIcon(ImageManager.getInstance().getImage("button")));
		// Establecemos la imagen de rollover o cuando el jugador tiene el mouse sobre el botón
		setRolloverIcon(new ImageIcon(ImageManager.getInstance().getImage("buttonHover")));
		image = getIcon();
		// Establecemos el texto con un padding superior de 2px
		topPadding = 2;
		// Establecemos la fuente en Standard
		font = FontManager.getInstance().getFont("Standard");
		// Establecemos el tamaño del botón
		Dimension size = new Dimension(117, 29);
		setSize(size);
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		// Establecemos que el botón no tenga fondo ni borde, y además sea transparente lo que no sea la imagen
		setContentAreaFilled(false);
		setBorderPainted(false);
		setFocusPainted(true);
		setOpaque(false);
		// Establecemos el cursor del mouse
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		// Agregamos la acción del botón cuando el jugador pasa el mouse sobre él
		addMouseListener(new ButtonCursorAdapter(this));
	}

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		//Activamos la interpolación
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g2d.setFont(font);
		g2d.setColor(Color.BLACK);
		//Pintamos la imagen
		image.paintIcon(this, g2d, 0, 0);
		//Calculamos la posición del texto
		int textPositionY = image.getIconHeight() / 2 + (g2d.getFontMetrics().getHeight() / 4) + topPadding;
		int textPositionX = (image.getIconWidth() - g2d.getFontMetrics().stringWidth(displayText)) / 2;
		//Pintamos el texto
		g2d.drawString(displayText, textPositionX, textPositionY);
	}

	@Override
	public Font getFont() {

		return font;
	}

	public Icon getImage() {

		return image;
	}

	@Override
	public void setFont(Font font) {

		this.font = font;
	}

	public void setImage(Icon image) {

		this.image = image;
	}

	public void setTopPadding(int topPadding) {

		this.topPadding = topPadding;
	}
}
