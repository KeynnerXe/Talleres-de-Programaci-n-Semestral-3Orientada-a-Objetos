/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taller32;
import javax.swing.*;
import java.io.*;
/**
 *
 * @author anton
 */
public class VentanaInterna extends JInternalFrame {

    private JTextPane txtTexto;

    public VentanaInterna(File fichero) {
        super(fichero.getName(), true, true, true, true);

        txtTexto = new JTextPane();
        JScrollPane scrollPane = new JScrollPane(txtTexto);
        getContentPane().add(scrollPane);

        ponerTexto(fichero.getAbsolutePath());
        setSize(400, 300);
    }

    public void ponerTexto(String caminoFichero) {
        try {
            File fi = new File(caminoFichero);
            FileReader lectura = new FileReader(fi);
            BufferedReader entrada = new BufferedReader(lectura);
            String linea;
            String texto = "";
            while ((linea = entrada.readLine()) != null) {
                texto += linea + "\n";
            }
            entrada.close();
            lectura.close();
            txtTexto.setText(texto);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al leer fichero.");
        }
    }
}
