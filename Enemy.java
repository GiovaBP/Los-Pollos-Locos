import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Random;

/* Enumeración de las estadísticas */
enum Stats {
    HP, MAX_HP, ATTACK, DEFENSE, SPEED
}

/* Interfaz IEnemy para los enemigos */
interface IEnemy {
    void attack(Player player);
    void takeDamage(int damage);
    boolean isAlive();
    String getName();
    HashMap<Stats, Integer> getStats();
}

/* Clase base abstracta Enemy que implementa la interfaz IEnemy */
abstract class Enemy implements IEnemy {
    protected String name;
    protected HashMap<Stats, Integer> stats;

    public Enemy(String name) {
        this.name = name;
        this.stats = new HashMap<>();
        initializeStats();
    }

    protected abstract void initializeStats();

    public String getName() {
        return name;
    }

    public void attack(Player player) {
        int damage = calculateDamage(player);
        player.getStats().put(Stats.HP, Math.max(player.getStats().get(Stats.HP) - damage, 0));
        JOptionPane.showMessageDialog(null, name + " ataca a " + player.getName() + " e inflige " + damage + " de daño.");
    }

    private int calculateDamage(Player player) {
        int attackPower = stats.get(Stats.ATTACK);
        int defensePower = player.getStats().get(Stats.DEFENSE);
        Random rand = new Random();
        return Math.max(attackPower - defensePower + rand.nextInt(5), 0);
    }

    public void takeDamage(int damage) {
        stats.put(Stats.HP, Math.max(stats.get(Stats.HP) - damage, 0));
    }

    public boolean isAlive() {
        return stats.get(Stats.HP) > 0;
    }

    public HashMap<Stats, Integer> getStats() {
        return stats;
    }
}

/* Diferentes tipos de enemigos */

/* Clase Undead */
class Undead extends Enemy {
    public Undead() {
        super("Zombie");
    }

    @Override
    protected void initializeStats() {
        stats.put(Stats.MAX_HP, 50);
        stats.put(Stats.HP, 50);
        stats.put(Stats.ATTACK, 12);
        stats.put(Stats.DEFENSE, 5);
        stats.put(Stats.SPEED, 2);
    }
}

/* Clase Beast */
class Beast extends Enemy {
    public Beast() {
        super("Lobo Salvaje");
    }

    @Override
    protected void initializeStats() {
        stats.put(Stats.MAX_HP, 70);
        stats.put(Stats.HP, 70);
        stats.put(Stats.ATTACK, 18);
        stats.put(Stats.DEFENSE, 10);
        stats.put(Stats.SPEED, 7);
    }
}

/* Clase Demon */
class Demon extends Enemy {
    public Demon() {
        super("Demonio");
    }

    @Override
    protected void initializeStats() {
        stats.put(Stats.MAX_HP, 100);
        stats.put(Stats.HP, 100);
        stats.put(Stats.ATTACK, 25);
        stats.put(Stats.DEFENSE, 15);
        stats.put(Stats.SPEED, 6);
    }
}

/* Clase Robot */
class Robot extends Enemy {
    public Robot() {
        super("Robot de Combate");
    }

    @Override
    protected void initializeStats() {
        stats.put(Stats.MAX_HP, 120);
        stats.put(Stats.HP, 120);
        stats.put(Stats.ATTACK, 20);
        stats.put(Stats.DEFENSE, 20);
        stats.put(Stats.SPEED, 4);
    }
}

/* Clase Alien */
class Alien extends Enemy {
    public Alien() {
        super("Alienígena");
    }

    @Override
    protected void initializeStats() {
        stats.put(Stats.MAX_HP, 90);
        stats.put(Stats.HP, 90);
        stats.put(Stats.ATTACK, 22);
        stats.put(Stats.DEFENSE, 12);
        stats.put(Stats.SPEED, 9);
    }
}

/* Clase Player */
class Player {
    private String name;
    private HashMap<Stats, Integer> stats;

    public Player(String name) {
        this.name = name;
        this.stats = new HashMap<>();
        initializeStats();
    }

    private void initializeStats() {
        stats.put(Stats.MAX_HP, 20);
        stats.put(Stats.HP, 20);
        stats.put(Stats.ATTACK, 20);
        stats.put(Stats.DEFENSE, 10);
        stats.put(Stats.SPEED, 5);
    }

    public String getName() {
        return name;
    }

    public void attack(IEnemy enemy) {
        int damage = calculateDamage(enemy);
        enemy.takeDamage(damage);
        JOptionPane.showMessageDialog(null, name + " ataca a " + enemy.getName() + " e inflige " + damage + " de daño.");
    }

    private int calculateDamage(IEnemy enemy) {
        int attackPower = stats.get(Stats.ATTACK);
        int defensePower = enemy.getStats().get(Stats.DEFENSE);
        Random rand = new Random();
        return Math.max(attackPower - defensePower + rand.nextInt(5), 0);
    }

    public boolean isAlive() {
        return stats.get(Stats.HP) > 0;
    }

    public HashMap<Stats, Integer> getStats() {
        return stats;
    }
}

