/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taller33;

/**
 *
 * @author anton
 */
public class Cliente {
    
    private String cif;
    private String nombre;
    private String ciudad;
    private String telefono;

    // Constructor
    public Cliente(String cif, String nombre, String ciudad, String telefono) {
        this.cif = cif;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.telefono = telefono;
    }

    // Métodos getter y setter
    public String getCif() { return cif; }
    public void setCif(String cif) { this.cif = cif; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    @Override
    public String toString() {
        return nombre + " (" + cif + ")";
    }
}
 

