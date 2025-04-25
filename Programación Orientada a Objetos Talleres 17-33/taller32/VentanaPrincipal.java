/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taller32;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.filechooser.*;
import java.io.*;
/**
 *
 * @author anton
 */
public class VentanaPrincipal extends JFrame {

    private JDesktopPane panelInterno; // Panel que contiene las ventanas internas

    public VentanaPrincipal() {
        super("Editor de Archivos");

        // Configuración de la ventana principal
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panelInterno = new JDesktopPane(); // El área donde se abrirán las ventanas internas
        getContentPane().add(panelInterno, BorderLayout.CENTER);

        // Menú
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menuArchivo = new JMenu("Archivo");
        JMenuItem itemAbrir = new JMenuItem("Abrir");
        JMenuItem itemCerrar = new JMenuItem("Cerrar");
        JMenuItem itemCerrarTodos = new JMenuItem("Cerrar Todos");
        JMenuItem itemSalir = new JMenuItem("Salir");
        
        menuArchivo.add(itemAbrir);
        menuArchivo.add(itemCerrar);
        menuArchivo.add(itemCerrarTodos);
        menuArchivo.add(itemSalir);
        
        JMenu menuVentana = new JMenu("Ventana");
        JMenuItem itemCascada = new JMenuItem("Cascada");
        JMenuItem itemMosaicoHorizontal = new JMenuItem("Mosaico Horizontal");
        JMenuItem itemMosaicoVertical = new JMenuItem("Mosaico Vertical");
        
        menuVentana.add(itemCascada);
        menuVentana.add(itemMosaicoHorizontal);
        menuVentana.add(itemMosaicoVertical);
        
        menuBar.add(menuArchivo);
        menuBar.add(menuVentana);

        // Eventos
        itemAbrir.addActionListener(e -> abrirFichero());
        itemCerrar.addActionListener(e -> cerrarVentana());
        itemCerrarTodos.addActionListener(e -> cerrarTodasLasVentanas());
        itemSalir.addActionListener(e -> System.exit(0));
        
        itemCascada.addActionListener(e -> aplicarCascada());
        itemMosaicoHorizontal.addActionListener(e -> aplicarMosaicoHorizontal());
        itemMosaicoVertical.addActionListener(e -> aplicarMosaicoVertical());
    }

    // Abrir un archivo
    private void abrirFichero() {
        JFileChooser fileChooser = new JFileChooser();
        int seleccion = fileChooser.showOpenDialog(this);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File fichero = fileChooser.getSelectedFile();
            abrirVentanaInterna(fichero);
        }
    }

    // Crear una ventana interna
    private void abrirVentanaInterna(File fichero) {
        JInternalFrame ventanaInterna = new VentanaInterna(fichero);
        panelInterno.add(ventanaInterna);
        ventanaInterna.setVisible(true);
    }

    // Cerrar la ventana activa
    private void cerrarVentana() {
        JInternalFrame ventana = panelInterno.getSelectedFrame();
        if (ventana != null) {
            ventana.dispose();
        }
    }

    // Cerrar todas las ventanas
    private void cerrarTodasLasVentanas() {
        JInternalFrame[] ventanas = panelInterno.getAllFrames();
        for (JInternalFrame ventana : ventanas) {
            ventana.dispose();
        }
    }

    // Cascada
    private void aplicarCascada() {
        JInternalFrame[] ventanas = panelInterno.getAllFrames();
        int x = 10, y = 10;
        for (JInternalFrame ventana : ventanas) {
            ventana.setLocation(x, y);
            x += 30;
            y += 30;
        }
    }

    // Mosaico Horizontal
    private void aplicarMosaicoHorizontal() {
        JInternalFrame[] ventanas = panelInterno.getAllFrames();
        int altura = panelInterno.getHeight() / ventanas.length;
        int y = 0;
        for (JInternalFrame ventana : ventanas) {
            ventana.setSize(panelInterno.getWidth(), altura);
            ventana.setLocation(0, y);
            y += altura;
        }
    }

    // Mosaico Vertical
    private void aplicarMosaicoVertical() {
        JInternalFrame[] ventanas = panelInterno.getAllFrames();
        int anchura = panelInterno.getWidth() / ventanas.length;
        int x = 0;
        for (JInternalFrame ventana : ventanas) {
            ventana.setSize(anchura, panelInterno.getHeight());
            ventana.setLocation(x, 0);
            x += anchura;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaPrincipal ventana = new VentanaPrincipal();
            ventana.setVisible(true);
        });
    }
}
