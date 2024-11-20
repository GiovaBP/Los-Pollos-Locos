package gui.labels;

import javax.swing.*;
import java.awt.*;

/**
 * Clase que representa una etiqueta de texto con fondo rojo
 */
public class RedTextLabel extends JLabel {

	/**
	 * Texto a mostrar
	 */
	protected String displayText;

	/**
	 * Constructor de la clase
	 *
	 * @param text texto a mostrar
	 */
	public RedTextLabel(String text) {

		super();
		//Establecemos el texto
		this.displayText = text;
		//Establecemos las propiedades del componente
		Dimension size = new Dimension(117, 39);
		setPreferredSize(size);
		setMaximumSize(size);
		setMinimumSize(size);
		setOpaque(false);
		setFont(new Font("Arial", Font.BOLD, 15));
		setForeground(Color.BLACK);
		//Añadimos un borde invisible superior de 10px para separar el texto del borde
		setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
	}

	/**
	 * Método que pinta el componente
	 *
	 * @param g gráficos
	 */
	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		//Cargamos la imagen de fondo
		Image image = new ImageIcon("img/ui/holders/textHolder.png").getImage();
		//Activamos la interpolación
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g2d.drawImage(image, 0, 10, null);
		//Calculamos la posición del texto
		int textPositionY = image.getHeight(null) / 2 + (g2d.getFontMetrics().getHeight() / 2) + 7;
		int textPositionX = (image.getWidth(null) - g2d.getFontMetrics().stringWidth(displayText)) / 2;
		//Pintamos el texto
		g2d.drawString(displayText, textPositionX, textPositionY);
	}

	/**
	 * Método que establece el texto a mostrar
	 *
	 * @param text texto a mostrar
	 */
	public void setText(String text) {

		this.displayText = text;
		repaint();
	}
}
