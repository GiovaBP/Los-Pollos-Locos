package items.weapons.blades;

import items.weapons.Weapon;
import player.Stats;

import java.io.Serializable;

public class WoodBlade extends Weapon implements Serializable {

	public WoodBlade() {

		super("Espada de madera", "Una simple espada de madera", 5);
	}

	@Override
	public String effect() {

		return null;
	}

	@Override
	protected void initStats() {

		switch (rarity) {
			case COMMON:
				stats.put(Stats.ATTACK, 1);
				break;
			case UNCOMMON:
				stats.put(Stats.ATTACK, 2);
				stats.put(Stats.DEXTERITY, 1);
				break;
			case RARE:
				stats.put(Stats.ATTACK, 3);
				stats.put(Stats.DEXTERITY, 2);
				stats.put(Stats.LUCK, 1);
				break;
			case EPIC:
				stats.put(Stats.ATTACK, 4);
				stats.put(Stats.DEXTERITY, 3);
				stats.put(Stats.LUCK, 2);
				break;
			case LEGENDARY:
				stats.put(Stats.ATTACK, 5);
				stats.put(Stats.DEXTERITY, 4);
				stats.put(Stats.LUCK, 3);
				stats.put(Stats.RESISTANCE, 1);
				break;
			default:
				throw new IllegalArgumentException("Invalid rarity: " + rarity);
		}
	}

	@Override
	public void callEffect() {

	}

	@Override
	public String toString() {

		return "Espada de madera";
	}
}
