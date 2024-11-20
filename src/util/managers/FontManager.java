package util.managers;

import util.cache.FontCache;

import java.awt.*;
import java.io.File;

public class FontManager {

	private static FontManager instance;

	private final FontCache fontCache;

	private FontManager() {

		fontCache = FontCache.getInstance();
		initFonts();
	}

	private void initFonts() {

		fontCache.addFont("Game Title", new File("fonts\\fortune.otf"), 24f);
		fontCache.addFont("Game File", new File("fonts\\player.ttf"), 20f);
		fontCache.addFont("Player Status", new File("fonts\\player.ttf"), 16f);
		fontCache.addFont("Player", new File("fonts\\player.ttf"), 16f);
		fontCache.addFont("Standard", new Font("Arial", Font.BOLD, 15));
	}

	public static FontManager getInstance() {

		if (instance == null) {
			instance = new FontManager();
		}
		return instance;
	}

	public Font getFont(String fontName) {

		return fontCache.getFont(fontName);
	}
}
