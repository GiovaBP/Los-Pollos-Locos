package items;

import java.io.Serializable;

public enum Rarity implements Serializable {
	COMMON, UNCOMMON, RARE, EPIC, LEGENDARY;

	public static Rarity getRandomRarity() {

		return values()[(int) (Math.random() * values().length)];
	}
}
