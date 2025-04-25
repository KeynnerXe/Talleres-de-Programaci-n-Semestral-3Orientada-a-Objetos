/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taller30;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author anton
 */
public class EtiquetaTemperatura extends JLabel {
    // Propiedad para almacenar la temperatura
    private double temperatura;

    // Constructor
    public EtiquetaTemperatura() {
        // Inicializamos la temperatura a 0
        this.temperatura = 0;
        // Establecemos que la etiqueta sea opaca para poder cambiar su color de fondo
        setOpaque(true);
        // Iniciamos la etiqueta con la temperatura
        setText(temperatura + " ºC");
    }

    // Método para establecer la temperatura y mostrarla en la etiqueta
    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
        setText(temperatura + " ºC");
        mostrarRangoColor(); // Actualizamos el color de la etiqueta cuando se cambia la temperatura
    }

    // Método para obtener la temperatura actual
    public double getTemperatura() {
        return this.temperatura;
    }

    // Método para cambiar el color de la etiqueta según la temperatura
    public void mostrarRangoColor() {
        if (temperatura < 0) {
            setBackground(Color.BLUE); // Azul para temperaturas menores a 0
        } else if (temperatura >= 0 && temperatura < 10) {
            setBackground(Color.CYAN); // Cyan para temperaturas entre 0 y 10
        } else if (temperatura >= 10 && temperatura < 25) {
            setBackground(Color.MAGENTA); // Magenta para temperaturas entre 10 y 25
        } else if (temperatura >= 25 && temperatura < 35) {
            setBackground(Color.ORANGE); // Naranja para temperaturas entre 25 y 35
        } else if (temperatura >= 35) {
            setBackground(Color.RED); // Rojo para temperaturas mayores o iguales a 35
        }

        // Si la temperatura no es válida, hacemos la etiqueta transparente
        if (Double.isNaN(temperatura) || Double.isInfinite(temperatura)) {
            setOpaque(false);
        } else {
            setOpaque(true);
        }
    }

    // Método para cambiar la temperatura, aumentando o disminuyendo
    public void cambiarTemperatura(double cambio) {
        this.temperatura += cambio;
        setText(temperatura + " ºC");
        mostrarRangoColor(); // Actualizamos el color de la etiqueta después de cambiar la temperatura
    }
}
