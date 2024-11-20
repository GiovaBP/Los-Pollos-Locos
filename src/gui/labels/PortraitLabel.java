package gui.labels;

import javax.swing.*;
import java.awt.*;

/**
 * Clase que representa una etiqueta con la imagen de un retrato
 */
public class PortraitLabel extends JLabel {

	/**
	 * Constructor de la clase
	 */
	public PortraitLabel() {

		super();
		Dimension size = new Dimension(117, 127);
		setSize(size);
		setPreferredSize(size);
		setMaximumSize(size);
		setMinimumSize(size);
	}

	/**
	 * Método que pinta el componente
	 *
	 * @param g gráficos
	 */
	@Override
	public void paint(Graphics g) {

		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		Image image = new ImageIcon("img/player/portrait.png").getImage();
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.drawImage(image, 0, 0, null);
	}
}
