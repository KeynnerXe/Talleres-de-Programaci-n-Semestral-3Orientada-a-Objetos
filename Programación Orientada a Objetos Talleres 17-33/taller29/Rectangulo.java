/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taller29;

/**
 *
 * @author anton
 */
public class Rectangulo {
    
 // Propiedades de la clase
    private double base;
    private double altura;

    // Constructor
    public Rectangulo() {
        this.base = 100; // Valor inicial de la base
        this.altura = 50; // Valor inicial de la altura
    }

    // Métodos set
    public void setBase(double base) {
        this.base = base;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    // Métodos get
    public double getBase() {
        return this.base;
    }

    public double getAltura() {
        return this.altura;
    }

    // Método para obtener el área
    public double getArea() {
        return this.base * this.altura;
    }

    // Método para obtener el perímetro
    public double getPerimetro() {
        return 2 * (this.base + this.altura);
    }

    // Método para hacer que la altura sea igual a la base
    public void cuadrar() {
        this.altura = this.base;
    }
}
