
package Main;

/**
 *
 * @author Dimerson
 */
import Vistas.LoginFrame;
import Logica.LogicaBilletera;

/**
 * Clase principal que lanza la aplicación de la Billetera Virtual.
 * Inicializa la lógica del sistema y muestra la pantalla de Login.
 */
public class Main {
    
    public static void main(String[] args) {
        // Crear una instancia de la lógica de la billetera
        LogicaBilletera logica = new LogicaBilletera();
        
        // Lanzar la pantalla de Login, pasando la lógica creada
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame(logica).setVisible(true);
            }
        });
    }
}
