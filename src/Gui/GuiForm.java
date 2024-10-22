package Gui;

import javax.swing.*;
import java.awt.*;

public class GuiForm extends JFrame {

    private JPanel mainPanel;

    // Constructor de la clase GUIForm
    public GuiForm() {
        // Configuración de la ventana
        setTitle("Ventana Principal"); // Título de la ventana
        setSize(800, 600); // Tamaño de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cerrar el programa al cerrar la ventana
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla

        // Crear un panel para agregar componentes
        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY); // Color de fondo del panel

        // Agregar una etiqueta de bienvenida
        JLabel welcomeLabel = new JLabel("Bienvenido a la Ventana Principal");
        panel.add(welcomeLabel); // Añadir la etiqueta al panel

        // Establecer el panel como contenido de la ventana
        setContentPane(panel);

        // Hacer visible la ventana
        setVisible(true);
    }

    // Método principal para ejecutar la aplicación
    public static void main(String[] args) {
        // Utilizar SwingUtilities para asegurar que la creación de la GUI se ejecute en el hilo de eventos
        SwingUtilities.invokeLater(GuiForm::new);
    }
}
