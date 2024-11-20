package characters;

import java.io.Serializable;

/**
 * Clase abstracta que representa a un personaje básico.
 */
public abstract class BasicCharacter implements Serializable {

	/**
	 * Nombre del personaje.
	 */
	protected String name;
	/**
	 * Puntos de vida del personaje.
	 */
	protected int hp;
	/**
	 * Puntos de maná del personaje.
	 */
	protected int mp;
	/**
	 * Puntos de vida máximos del personaje.
	 */
	protected int maxHp;
	/**
	 * Puntos de maná máximos del personaje.
	 */
	protected int maxMp;

	/**
	 * Constructor de la clase.
	 * @param name Nombre del personaje.
	 * @param hp Puntos de vida del personaje.
	 * @param mp Puntos de maná del personaje.
	 */
	public BasicCharacter(String name, int hp, int mp) {

		this.name = name;
		this.hp = hp;
		this.mp = mp;
		this.maxHp = hp;
		this.maxMp = mp;
	}

	/**
	 * Método que realiza un ataque.
	 * @return Mensaje del ataque.
	 */
	public String takeDamage(int damage) {

		hp -= damage;
		String message = String.format("¡%s recibe %d puntos de daño!\n", name, damage);
		if (isDead()) message += String.format("¡%s ha sido derrotado!\n", name);
		return message;
	}

	/**
	 * Método que cura al personaje.
	 * @param amount Cantidad de puntos de vida a curar.
	 */
	public void heal(int amount) {

		hp += amount;
		if (hp > maxHp) hp = maxHp;
	}

	/**
	 * Método que recupera maná.
	 * @param amount Cantidad de maná a recuperar.
	 */
	public void recoverMp(int amount) {

		mp += amount;
		if (mp > maxMp) mp = maxMp;
	}

	/**
	 * Método que gasta maná.
	 * @param amount Cantidad de maná a gastar.
	 */
	public void useMp(int amount) {

		mp -= amount;
	}

	/**
	 * Método que comprueba si el personaje está muerto.
	 * @return true si el personaje está muerto, false en caso contrario.
	 */
	public boolean isDead() {

		return hp <= 0;
	}

	// Getters
	public String getName() {

		return name;
	}

	public int getHp() {

		return hp;
	}

	public int getMp() {

		return mp;
	}

	public int getMaxHp() {

		return maxHp;
	}

	public int getMaxMp() {

		return maxMp;
	}
}
