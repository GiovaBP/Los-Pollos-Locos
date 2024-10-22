import Enemy.Enemys.DragonHielo;
import Enemy.Enemys.SirenaVenenosa;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import Enemy.Enemys.*;
import Enemy.Enemys.SombraViviente;
import Game.Game;
import Player.Player;

public class Main {
    public static void main(String[] args) {
        // Crear un jugador
        String playerName = JOptionPane.showInputDialog("Introduce el nombre del jugador:");
        if (playerName == null || playerName.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nombre no válido. El juego se cerrará.");
            System.exit(0);
        }

        // Crear el jugador con nombre, salud, poder de ataque y defensa
        Player player = new Player(playerName, 100, 30, 50); // Salud, ataque, defensa

        // Crear una lista de enemigos
        List<Enemy> enemies = new ArrayList<>();
        try {
            enemies.add(new SombraViviente());      // Instancia de la subclase Raptor
            enemies.add(new DragonHielo());         // Instancia de la subclase Rex
            enemies.add(new SirenaVenenosa());   // Instancia de la subclase Therizino
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al crear enemigos: " + e.getMessage());
            System.exit(1);
        }

        // Inicializar el juego
        Game game = new Game(player, enemies); // Asegúrate de que Game acepte una lista de enemigos

        // Iniciar el juego
        game.startGame();
    }
}
