package util.cache;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Clase que implementa un caché de fuentes
 */
public class FontCache {

	/**
	 * Instancia de la clase
	 */
	private static FontCache instance;
	/**
	 * Mapa que almacena las fuentes
	 */
	private final Map<String, Font> fontCache;

	/**
	 * Constructor de la clase
	 */
	private FontCache() {

		fontCache = new HashMap<>();
	}

	/**
	 * Método que devuelve la instancia de la clase
	 *
	 * @return instancia de la clase
	 */
	public static FontCache getInstance() {

		if (instance == null) {
			instance = new FontCache();
		}
		return instance;
	}

	/**
	 * Método que lanza una excepción si se intenta clonar la clase
	 *
	 * @return excepción
	 *
	 * @throws CloneNotSupportedException excepción
	 */
	@Override
	public Object clone() throws CloneNotSupportedException {

		throw new CloneNotSupportedException("Clonación no permitida para la clase Singleton.");
	}

	public void addFont(String fontName, Font font){

		fontCache.put(fontName, font);
	}

	/**
	 * Método que añade una fuente al caché
	 *
	 * @param fontName nombre de la fuente
	 * @param file     archivo de la fuente
	 * @param size     tamaño de la fuente
	 */
	public void addFont(String fontName, File file, float size) {

		try {
			Font font = Font.createFont(Font.TRUETYPE_FONT, file).deriveFont(size);
			fontCache.put(fontName, font);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al cargar la fuente: " + fontName,
					"Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Método que devuelve una fuente del caché
	 *
	 * @param fontName nombre de la fuente
	 *
	 * @return fuente
	 */
	public Font getFont(String fontName) {

		return fontCache.get(fontName);
	}

	/**
	 * Método que elimina una fuente del caché
	 *
	 * @param fontName nombre de la fuente
	 */
	public void removeFont(String fontName) {

		fontCache.remove(fontName);
	}

	/**
	 * Método que limpia el caché
	 */
	public void clearCache() {

		fontCache.clear();
	}

	/**
	 * Método que comprueba si el caché contiene una fuente
	 *
	 * @param fontName nombre de la fuente
	 *
	 * @return true si el caché contiene la fuente, false en caso contrario
	 */
	public boolean containsFont(String fontName) {

		return fontCache.containsKey(fontName);
	}

	/**
	 * Método que imprime el caché
	 */
	public void printCache() {

		for (Map.Entry<String, Font> entry : fontCache.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}

	/**
	 * Método que comprueba si el caché está vacío
	 *
	 * @return true si el caché está vacío, false en caso contrario
	 */
	public boolean isCacheEmpty() {

		return fontCache.isEmpty();
	}
}
