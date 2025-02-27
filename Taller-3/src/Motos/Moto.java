package Motos;

import Vehiculos.Vehiculo;
import javax.swing.*;

/**
 *
 * @author Keynner Ramos
 */
public class Moto extends Vehiculo {
        private int cilindrada;
        
        public Moto(String tipo, int cilindrada) {
            super(tipo);
            this.cilindrada = cilindrada;
        }
        
        public int getCilindrada() {
            return cilindrada;
        }
        
        public void setCilindrada(int cilindrada) {
            this.cilindrada = cilindrada;
        }
        
        public void MostrarInfo() {
        MostrarInfo();
        JOptionPane.showMessageDialog(null, "Cilindrada: " + cilindrada + " cc");
        }

    public void mostrarInfo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    }
