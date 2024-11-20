package enemies.bats;

import enemies.Enemy;
import gui.exceptions.EnemyDeadException;
import items.misc.BatEar;
import items.misc.BatWing;
import player.Player;
import player.Stats;
import util.annotations.RegularEnemy;
import util.interfaces.Randomized;

import javax.swing.*;

@RegularEnemy
public class TinyBat extends Enemy {

	public TinyBat(Player player) {

		super(player, "Mur. Diminuto", 5, 5, 5, 3);
		image = imageManager.getImage("tinyBat",
				new ImageIcon("img\\enemies\\bats\\tinyBat.png").getImage());
		stats.put(Stats.ATTACK, 7);
		stats.put(Stats.DEFENSE, 2);
		stats.put(Stats.LUCK, 3);
		stats.put(Stats.SPEED, 5);
		stats.put(Stats.DEXTERITY, 4);
	}


	@Override
	public String getAttack() throws EnemyDeadException {

		Player player = Player.getInstance();
		String message = "";
		if (!isDead()) {

			double simpleAttackProbability = 0.5;
			double screechProbability = 0.5;
			double totalProbability = simpleAttackProbability + screechProbability;
			double ratio = Randomized.randomizeDouble(totalProbability);
			// simpleAttackProbability = 50%, screechProbability = 50%
			// simpleAttackProbability + screechProbability = 100%
			// ratio = 0.0 - 0.5 -> simpleAttack, ratio = 0.51 - 1.0 -> screech
			if (ratio <= simpleAttackProbability) message = simpleAttack(player);
			else message = screech(player);
		} else {
			throw new EnemyDeadException();
		}
		return message;
	}

	@Override
	public void dropItem(Player player) {

		int ratio = Randomized.randomizeNumber(1, 100);
		player.getInventory().addItem(ratio > 50 ? new BatWing() : new BatEar());
	}

	public String simpleAttack(Player player) {

		int damage = getDamage(player);
		String message = String.format("¡%s ataca con %d punto(s) de daño!\n", getName(), damage);
		message += player.takeDamage(damage);
		return message;
	}

	public String screech(Player player) {

		int damage = getAdjustedAttack() + 3;
		String message = String.format("¡%s emite un chillido ensordecedor que causa %d punto(s) de daño!\n", getName(),
				damage);
		message += player.takeDamage(damage);
		return message;
	}
}
