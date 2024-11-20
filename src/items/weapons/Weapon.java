package items.weapons;

import items.Item;
import items.ItemType;

import java.io.Serializable;

public abstract class Weapon extends Item implements Serializable {

	public Weapon(String name, String description, int price) {

		super(name, description, price);
		initStats();
		type = ItemType.WEAPON;
	}

	public abstract String effect();

	protected abstract void initStats();

	public abstract void callEffect();
}
