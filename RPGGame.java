import javax.swing.*;

/* Clase RPGGame */
public class RPGGame {
    private Player player;
    private IEnemy enemy;

    public RPGGame(Player player, IEnemy enemy) {
        this.player = player;
        this.enemy = enemy;
    }

    public void startGame() {
        JOptionPane.showMessageDialog(null, "¡Comienza la batalla entre " + player.getName() + " y " + enemy.getName() + "!");
        while (player.isAlive() && enemy.isAlive()) {
            playerTurn();
            if (enemy.isAlive()) {
                enemyTurn();
            }
        }

        if (player.isAlive()) {
            JOptionPane.showMessageDialog(null, player.getName() + " ha derrotado a " + enemy.getName() + "!");
        } else {
            JOptionPane.showMessageDialog(null, enemy.getName() + " ha derrotado a " + player.getName() + "!");
        }
    }

    private void playerTurn() {
        int option = JOptionPane.showConfirmDialog(null, "¿Quieres atacar?", "Turno de " + player.getName(), JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            player.attack(enemy);
        }
    }

    private void enemyTurn() {
        JOptionPane.showMessageDialog(null, enemy.getName() + " se prepara para atacar.");
        enemy.attack(player);
    }

    public static void main(String[] args) {
        Player player = new Player("Spartan");

        // Cambiar aquí el tipo de enemigo
        IEnemy enemy = new Undead();

        RPGGame game = new RPGGame(player, enemy);
        game.startGame();
    }
}