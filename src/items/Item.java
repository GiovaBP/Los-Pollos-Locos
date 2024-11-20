package items;

import player.Stats;

import java.io.Serializable;
import java.util.HashMap;

public abstract class Item implements Serializable {

	protected final String name;
	protected final String description;
	protected final int price;
	protected final Rarity rarity;
	protected final HashMap<Stats, Integer> stats;
	protected ItemType type;

	public Item(String name, String description, int price) {

		this.name = name;
		this.description = description;
		this.price = price;
		this.rarity = Rarity.getRandomRarity();
		stats = new HashMap<>();
		type = ItemType.MISC;
	}

	public String getRarity() {

		return switch (rarity) {
			case COMMON -> "Común";
			case UNCOMMON -> "Poco común";
			case RARE -> "Raro";
			case EPIC -> "Épico";
			case LEGENDARY -> "Legendario";
			default -> throw new IllegalArgumentException("Invalid rarity: " + rarity);
		};
	}

	public String getName() {

		return name;
	}

	public String getDescription() {

		return description;
	}

	public int getPrice() {

		return price;
	}

	public HashMap<Stats, Integer> getStats() {

		return stats;
	}

	public ItemType getType() {

		return type;
	}
}
