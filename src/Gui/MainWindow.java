package Gui;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    // Definición de constantes para el tamaño de la ventana
    private static final int WINDOW_WIDTH = 800;  // Ancho de la ventana
    private static final int WINDOW_HEIGHT = 600; // Alto de la ventana

    public MainWindow() {
        // Establecer el título de la ventana
        setTitle("Nebula Warriors RPG");

        // Establecer el tamaño de la ventana usando constantes
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        // Establecer la operación de cierre predeterminada
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Inicializar los paneles
        JPanel statusBar = new JPanel();
        JPanel gamePanel = new JPanel();
        JPanel actionBar = new JPanel();

        // Configurar los tamaños de los paneles
        statusBar.setPreferredSize(new Dimension(WINDOW_WIDTH, 150)); // Barra de Estado
        gamePanel.setPreferredSize(new Dimension(WINDOW_WIDTH, 370)); // Panel de Juego
        actionBar.setPreferredSize(new Dimension(WINDOW_WIDTH, 340)); // Barra de Acción

        // Establecer colores de fondo
        statusBar.setBackground(Color.ORANGE); // Color de fondo para la barra de estado
        gamePanel.setBackground(Color.LIGHT_GRAY); // Color de fondo para el panel de juego
        actionBar.setBackground(Color.PINK); // Color de fondo para la barra de acción

        // Establecer el layout del panel principal
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS)); // Layout vertical

        // Agregar los paneles al panel principal
        mainPanel.add(statusBar);
        mainPanel.add(gamePanel);
        mainPanel.add(actionBar);

        // Establecer el contenido del panel
        setContentPane(mainPanel);

        // Centrar la ventana en la pantalla
        setLocationRelativeTo(null);

        // Hacer visible la ventana
        setVisible(true);
    }

    public static void main(String[] args) {
        // Crear la ventana principal en el hilo de despacho de eventos
        SwingUtilities.invokeLater(MainWindow::new);
    }
}
