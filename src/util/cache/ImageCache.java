package util.cache;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Clase que implementa un caché de imágenes
 */
public class ImageCache {
	/**
	 * Instancia de la clase
	 */
	private static ImageCache instance;
	/**
	 * Mapa que almacena las imágenes
	 */
	private final Map<String, Image> imageCache;

	/**
	 * Constructor de la clase
	 */
	private ImageCache() {

		imageCache = new HashMap<>();
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

	/**
	 * Método que devuelve la instancia de la clase
	 *
	 * @return instancia de la clase
	 */
	public static ImageCache getInstance() {

		if (instance == null) {
			instance = new ImageCache();
		}
		return instance;
	}

	/**
	 * Método que añade una imagen al caché
	 *
	 * @param imageName nombre de la imagen
	 * @param image     imagen
	 */
	public void addImage(String imageName, Image image) {

		imageCache.put(imageName, image);
	}

	/**
	 * Método que devuelve una imagen del caché
	 *
	 * @param imageName nombre de la imagen
	 *
	 * @return imagen
	 */
	public Image getImage(String imageName) {

		return imageCache.get(imageName);
	}

	/**
	 * Método que comprueba si el caché contiene una imagen
	 *
	 * @param imageName nombre de la imagen
	 *
	 * @return true si la imagen está en el caché, false en caso contrario
	 */
	public boolean containsImage(String imageName) {

		return imageCache.containsKey(imageName);
	}

	/**
	 * Método que comprueba si el caché está vacío
	 *
	 * @return true si el caché está vacío, false en caso contrario
	 */
	public boolean isCacheEmpty() {

		return imageCache.isEmpty();
	}
}
