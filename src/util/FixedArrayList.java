package util;

import items.Item;
import items.ItemType;
import items.armors.Armor;
import items.weapons.Weapon;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Una FixedArrayList es una lista que tiene una capacidad fija y puede cambiar de tamaño de acuerdo a su función
 * expandCapacity.
 *
 * @param <T> the type of elements in the list
 *
 * @author jesus
 * @version 1.0
 */
public class FixedArrayList<T> extends ArrayList<T> implements Serializable {
	private int capacity;

	/**
	 * Construye una nueva FixedArrayList con la capacidad especificada.
	 *
	 * @param capacity la capacidad de la lista
	 */
	public FixedArrayList(int capacity) {

		super(capacity);
		this.capacity = capacity;
	}

	/**
	 * Agrega el elemento especificado a la lista si la lista no está llena.
	 *
	 * @param e el elemento a agregar
	 *
	 * @return verdadero si se agregó el elemento, falso si la lista está llena.
	 */
	@Override
	public boolean add(T e) {

		return size() < capacity && super.add(e);
	}

	/**
	 * Expande la capacidad de la lista en la cantidad especificada.
	 *
	 * @param amount la cantidad en la que se expandirá la capacidad.
	 */
	public void expandCapacity(int amount) {

		capacity += amount;
		ensureCapacity(capacity);
	}

	/**
	 * Filtra los elementos de la lista que son armaduras.
	 *
	 * @return una lista de armaduras
	 */
	public List<Armor> filterArmors() {

		return this.stream().filter(item -> ((Item) item).getType() == ItemType.ARMOR)
				.map(item -> (Armor) item).collect(Collectors.toList());
	}

	public List<Item> filterMiscItems() {

		return this.stream().filter(item -> ((Item) item).getType() == ItemType.MISC)
				.map(item -> (Item) item).collect(Collectors.toList());
	}

	/**
	 * Filtra los elementos de la lista que son armas.
	 *
	 * @return una lista de armas
	 */
	public List<Weapon> filterWeapons() {

		return this.stream().filter(item -> ((Item) item).getType() == ItemType.WEAPON)
				.map(item -> (Weapon) item).collect(Collectors.toList());
	}
}
