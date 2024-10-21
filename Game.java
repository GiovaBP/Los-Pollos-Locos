package Game;

/*
   Esta clase representa el flujo principal del juego en el que el jugador lucha contra varios enemigos.
   Proporciona la lógica para gestionar los turnos del jugador y los enemigos, así como el inicio y final del juego.
*/

import Enemy.Enemys.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import Player.Player;
import Enemy.Enemys.Enemy;
import Gui.*;

public class Game {
    private final Player player;
    private final List<Enemy> enemies;

    public Game(Player player, List<Enemy> enemies) {
        this.player = player;
        this.enemies = new ArrayList<>();

        // Añadir los enemigos al juego
        this.enemies.add(new SombraViviente());  // SombraViviente
        this.enemies.add(new DragonHielo());
        this.enemies.add(new SirenaVenenosa());
        this.enemies.add(new QuimeraMutante());
    }

    public void startGame() {
        System.out.println("¡El juego ha comenzado!");

        for (Enemy enemy : enemies) {
            enemy.displayInfo();

            while (player.isAlive() && enemy.isAlive()) {
                playerTurn(enemy); // Llama al turno del jugador
                if (!enemy.isAlive()) {
                    System.out.println(enemy.getName() + " ha sido derrotado!");
                    break;
                }
                enemyTurn(enemy);
            }

            if (!player.isAlive()) {
                System.out.println(player.getName() + " ha sido derrotado!");
                break;
            }
        }

        // Mostrar mensaje final según el estado del jugador
        if (player.isAlive()) {
            System.out.println("¡Has derrotado a todos los enemigos!");
        } else {
            System.out.println("¡Has perdido el juego!");
        }
    }

    private void playerTurn(Enemy enemy) {
        // Crear opciones para atacar y ver estadísticas
        String[] options = {"Atacar", "Ver estadísticas"};

        // Mostrar el diálogo con las opciones
        int choice = JOptionPane.showOptionDialog(null,
                "Es tu turno. ¿Qué deseas hacer?",
                "Turno del Jugador",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[0]); // Primer botón seleccionado por defecto

        if (choice == 0) { // Atacar
            player.attack(enemy);
            if (!enemy.isAlive()) {
                JOptionPane.showMessageDialog(null, enemy.getName() + " ha sido derrotado!");
            }
        } else if (choice == 1) { // Ver estadísticas
            player.displayInfo();
            enemy.displayInfo();
        }
    }

    private void enemyTurn(Enemy enemy) {
        // Implementa la lógica para el turno del enemigo
        enemy.attack(player);
    }

    public static void main(String[] args) {
        // Crear una instancia de GUIForm para mostrar la ventana principal
        SwingUtilities.invokeLater(GuiForm::new);
    }
}
