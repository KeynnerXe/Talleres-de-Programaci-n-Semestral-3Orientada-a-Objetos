/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taller29;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author anton
 */
public class VentanaPrincipal extends JFrame {
    // Declaración de los cuatro objetos de tipo Rectángulo
    Rectangulo paredNorte = new Rectangulo();
    Rectangulo paredSur = new Rectangulo();
    Rectangulo paredEste = new Rectangulo();
    Rectangulo paredOeste = new Rectangulo();

    // Elementos de la ventana
    JRadioButton rbParedNorte, rbParedSur, rbParedEste, rbParedOeste;
    JTextField tfBase, tfAltura;
    JButton btnAsignar, btnArea, btnPerimetro;

    public VentanaPrincipal() {
        // Configuración de la ventana
        setTitle("Gestión de Paredes");
        setSize(400, 300);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear botones de opción para seleccionar la pared
        rbParedNorte = new JRadioButton("Pared Norte");
        rbParedSur = new JRadioButton("Pared Sur");
        rbParedEste = new JRadioButton("Pared Este");
        rbParedOeste = new JRadioButton("Pared Oeste");

        // Agrupar los botones para que sólo uno esté seleccionado
        ButtonGroup group = new ButtonGroup();
        group.add(rbParedNorte);
        group.add(rbParedSur);
        group.add(rbParedEste);
        group.add(rbParedOeste);

        // Establecer que la opción "Pared Norte" esté seleccionada por defecto
        rbParedNorte.setSelected(true);

        // Posicionar los botones en la ventana
        rbParedNorte.setBounds(10, 10, 150, 30);
        rbParedSur.setBounds(10, 40, 150, 30);
        rbParedEste.setBounds(10, 70, 150, 30);
        rbParedOeste.setBounds(10, 100, 150, 30);

        add(rbParedNorte);
        add(rbParedSur);
        add(rbParedEste);
        add(rbParedOeste);

        // Crear campos de texto para ingresar base y altura
        tfBase = new JTextField();
        tfBase.setBounds(180, 10, 100, 30);
        add(tfBase);

        tfAltura = new JTextField();
        tfAltura.setBounds(180, 50, 100, 30);
        add(tfAltura);

        // Crear botones para Asignar, Área y Perímetro
        btnAsignar = new JButton("Asignar");
        btnAsignar.setBounds(10, 140, 100, 30);
        add(btnAsignar);

        btnArea = new JButton("Área");
        btnArea.setBounds(120, 140, 100, 30);
        add(btnArea);

        btnPerimetro = new JButton("Perímetro");
        btnPerimetro.setBounds(230, 140, 100, 30);
        add(btnPerimetro);

        // Acción del botón "Asignar"
        btnAsignar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener los valores ingresados en los campos de texto
                double base = Double.parseDouble(tfBase.getText());
                double altura = Double.parseDouble(tfAltura.getText());

                // Asignar los valores a la pared seleccionada
                if (rbParedNorte.isSelected()) {
                    paredNorte.setBase(base);
                    paredNorte.setAltura(altura);
                } else if (rbParedSur.isSelected()) {
                    paredSur.setBase(base);
                    paredSur.setAltura(altura);
                } else if (rbParedEste.isSelected()) {
                    paredEste.setBase(base);
                    paredEste.setAltura(altura);
                } else if (rbParedOeste.isSelected()) {
                    paredOeste.setBase(base);
                    paredOeste.setAltura(altura);
                }
            }
        });

        // Acción del botón "Área"
        btnArea.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Calcular el área de la pared seleccionada y mostrarlo en un JOptionPane
                double area = 0;
                if (rbParedNorte.isSelected()) {
                    area = paredNorte.getArea();
                } else if (rbParedSur.isSelected()) {
                    area = paredSur.getArea();
                } else if (rbParedEste.isSelected()) {
                    area = paredEste.getArea();
                } else if (rbParedOeste.isSelected()) {
                    area = paredOeste.getArea();
                }
                JOptionPane.showMessageDialog(null, "Área: " + area);
            }
        });

        // Acción del botón "Perímetro"
        btnPerimetro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Calcular el perímetro de la pared seleccionada y mostrarlo en un JOptionPane
                double perimetro = 0;
                if (rbParedNorte.isSelected()) {
                    perimetro = paredNorte.getPerimetro();
                } else if (rbParedSur.isSelected()) {
                    perimetro = paredSur.getPerimetro();
                } else if (rbParedEste.isSelected()) {
                    perimetro = paredEste.getPerimetro();
                } else if (rbParedOeste.isSelected()) {
                    perimetro = paredOeste.getPerimetro();
                }
                JOptionPane.showMessageDialog(null, "Perímetro: " + perimetro);
            }
        });
    }

    public static void main(String[] args) {
        // Iniciar la ventana principal
        VentanaPrincipal ventana = new VentanaPrincipal();
        ventana.setLocationRelativeTo(null); // Centrar la ventana
        ventana.setVisible(true);
    }
}
