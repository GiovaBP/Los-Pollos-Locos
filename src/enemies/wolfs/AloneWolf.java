package enemies.wolfs;

import enemies.Enemy;
import gui.exceptions.EnemyDeadException;
import items.armors.head.WoodHelmet;
import items.misc.WolfFur;
import player.Player;
import player.Stats;
import util.annotations.RegularEnemy;
import util.interfaces.Randomized;

import javax.swing.*;

/**
 * La clase AloneWolf es una subclase de la clase Enemy. Es un enemigo básico que el jugador puede encontrar en el juego.
 * Tiene un método de ataque único que le permite realizar una de tres acciones: simpleAttack, howl, or bite.
 * El método simpleAttack permite que AloneWolf ataque al jugador con una cantidad determinada de daño.
 * El método howl permite que AloneWolf aúlle.
 * El método bite permite que AloneWolf muerda al jugador provocando una cantidad determinada de daño.
 */
@RegularEnemy
public class AloneWolf extends Enemy {

	/**
	 * Constructor de la clase Lobo solitario.
	 */
	public AloneWolf(Player player) {

		super(player, "Lobo Solitario", 10, 10, 5, 4);
		image = imageManager.getImage("aloneWolf",
				new ImageIcon("img\\enemies\\wolfs\\aloneWolf.png").getImage());
		stats.put(Stats.ATTACK, 8);
		stats.put(Stats.DEFENSE, 3);
		stats.put(Stats.LUCK, 3);
		stats.put(Stats.SPEED, 5);
		stats.put(Stats.DEXTERITY, 4);
	}

	/**
	 * Función que permite al lobo solitario atacar al jugador.
	 *
	 */
	@Override
	public String getAttack() throws EnemyDeadException {

		String message;
		if (!isDead()) {

			double simpleAttackProbability = 0.5;
			double howlProbability = 0.3;
			double biteProbability = 0.2;
			double totalProbability = simpleAttackProbability + howlProbability + biteProbability;
			double ratio = Randomized.randomizeDouble(totalProbability);
			// simpleAttackProbability = 50%, howlProbability = 30%, biteProbability = 20%
			// simpleAttackProbability + howlProbability + biteProbability = 100%
			// ratio = 0.0 - 0.5 -> simpleAttack, ratio = 0.51 - 0.7 -> bite, ratio = 0.71 - 1.0 -> howl
			if (ratio <= simpleAttackProbability) message = simpleAttack(player);
			else if (ratio <= simpleAttackProbability + biteProbability) message = bite(player);
			else message = howl(player);
		} else {
			throw new EnemyDeadException();
		}
		return message;
	}

	/**
	 * Función que permite al lobo solitario soltar un objeto al morir.
	 *
	 * @param player Jugador al que se le suelta el objeto.
	 */
	@Override
	public void dropItem(Player player) {

		if (getLevel() > 5) {

			int ratio = Randomized.randomizeNumber(1, 100);
			player.getInventory().addItem(ratio > 65 ? new WoodHelmet() : new WolfFur());
		} else {
			player.getInventory().addItem(new WolfFur());
		}
	}

	/**
	 * Función que permite al lobo solitario atacar.
	 *
	 * @param player Jugador al que se le ataca.
	 */
	public String simpleAttack(Player player) {

		int damage = getDamage(player);
		String message = String.format("¡%s ataca con %d punto(s) de daño!\n", getName(), damage);
		message += player.takeDamage(damage);
		return message;
	}

	/**
	 * Función que permite al lobo solitario aullar.
	 *
	 * @param player Jugador al que se le aúlla.
	 */
	public String howl(Player player) {

		//TODO: Implementar efecto de aullido.
		return String.format("¡%s aúlla!\n", getName());
	}

	/**
	 * Función que permite al lobo lanzar una mordida poderosa.
	 *
	 * @param player Jugador al que se le muerde.
	 */
	public String bite(Player player) {

		int totalDamage = getAdjustedAttack() + 1;
		String message = String.format("¡%s muerde con %d punto(s) de daño!\n", getName(), totalDamage);
		return message + player.takeDamage(totalDamage);
	}
}
