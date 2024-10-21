package Player;

import java.util.EnumMap;
import javax.swing.JOptionPane;
import Enemy.Enemys.Enemy;

public class Player {
    private String name;
    private EnumMap<Stats, Integer> stats;

    public Player(String name, int health, int attackPower, int defense) {
        this.name = name;
        this.stats = new EnumMap<>(Stats.class);
        this.stats.put(Stats.HP, health);
        this.stats.put(Stats.ATTACK, attackPower);
        this.stats.put(Stats.DEFENSE, defense);
    }

    public String getName() {
        return name;
    }

    public boolean isAlive() {
        return getStat(Stats.HP) > 0;
    }

    public void attack(Enemy enemy) {
        if (!isAlive()) {
            JOptionPane.showMessageDialog(null, name + " no puede atacar porque está muerto!");
            return;
        }
        int attackPower = getStat(Stats.ATTACK);
        JOptionPane.showMessageDialog(null, name + " ataca a " + enemy.getName() + " por " + attackPower + " de daño!");
        enemy.takeDamage(attackPower);
    }

    public void takeDamage(int damage) {
        int currentDefense = getStat(Stats.DEFENSE);
        int currentHealth = getStat(Stats.HP);

        if (currentDefense > 0) {
            if (currentDefense >= damage) {
                currentDefense -= damage;
                damage = 0;
            } else {
                damage -= currentDefense;
                currentDefense = 0;
            }
        }

        if (damage > 0) {
            currentHealth -= damage;
            if (currentHealth < 0) {
                currentHealth = 0;
            }
        }

        putStat(Stats.DEFENSE, currentDefense);
        putStat(Stats.HP, currentHealth);

        JOptionPane.showMessageDialog(null, name + " recibe " + damage + " de daño. " +
                "Defensa restante: " + currentDefense + ".");
    }

    public int getStat(Stats stat) {
        return stats.getOrDefault(stat, 0);
    }

    public void putStat(Stats stat, int value) {
        stats.put(stat, value);
    }

    public int getStat(Enums.Stats stats) {
        return 0;
    }

    public void putStat(Enums.Stats stats, int value) {
    }

    public void displayInfo() {
    }
}
