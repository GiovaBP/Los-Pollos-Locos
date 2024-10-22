package Gui;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

    public GameFrame() {
        // Configurar el título de la ventana
        setTitle("2D RPG Game");

        // Configurar el tamaño de la ventana
        setSize(1280, 1024);

        // Configurar la operación de cierre por defecto
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Establecer el administrador de diseño
        setLayout(new BorderLayout());

        // Crear un panel de juego y agregarlo al marco
        GamePanel gamePanel = new GamePanel();
        add(gamePanel, BorderLayout.CENTER);

        // Centrar la ventana en la pantalla
        setLocationRelativeTo(null);

        // Hacer la ventana visible
        setVisible(true);
    }

    // Clase interna para el panel del juego
    private static class GamePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // Aquí puedes dibujar los elementos del juego
            g.setColor(Color.GREEN);
            g.fillRect(0, 0, getWidth(), getHeight()); // Fondo
            g.setColor(Color.RED);
            g.fillRect(100, 100, 50, 50); // Sprite de ejemplo
        }
    }

    public static void main(String[] args) {
        // Crear el marco del juego
        SwingUtilities.invokeLater(GameFrame::new);
    }
}
