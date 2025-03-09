package KeinnerRamos.base;

/**
 *
 * @author Keinner Ramos
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.*;


public class Main {
    public static void main(String[] args) {
        
        // Creamos un medico
        Medico medico = new Medico();
        
        medico.setNombre("Dr. David Perez");
        medico.setNumColegiado("12345");
        medico.setCategoria("Titular");
        medico.setHorarioConsulta("Lunes a Viernes, 8:00 a.m - 12:30 p.m ");
        
        // Creamos un paciente
        Paciente paciente = new Paciente();
        
        paciente.setNombre("Gabriel Montes");
        paciente.setDireccion("San Jose de Los Campanos");
        paciente.setTelefono("444-444");
        paciente.setMedicoAsignado(medico);
        
        // Creamos una cita medica
        CitaMedica cita = new CitaMedica();
        cita.setFecha(new Date()); // Fecha Actual
        cita.setHora("10:00");
        cita.setConsultorio("Consultorio B1");
        cita.setIPS("Clinica de Baru");
        cita.setEPS("Salud Total");
        cita.setMedico(medico);
        cita.setPaciente(paciente);
        
        // Programar cita
        
        cita.programarCita();
        
        // Creamos un diagnostico
        Diagnostico diagnostico = new Diagnostico();
        
        diagnostico.setEnfermedad("Gripa");
        List<String> sintomas = new ArrayList<>();
        sintomas.add("Fiebre");
        sintomas.add("Tos");
        sintomas.add("Dolor de cabeza");
        diagnostico.setSintomas(sintomas);
        diagnostico.setDescripcion("Paciente con sintomas de gripe comun");
        
        
        // Asociamos el diagnostico a la cita
        cita.setDiagnostico(diagnostico);
        
        
        // Creamos un medicamento
        Medicamento medicamento = new Medicamento();
        
        medicamento.setNombreComercial("Aspirina 1");
        medicamento.setNombreGenerico("Aspirina 2");
        medicamento.setPrincipioActivo("Aspirina 3");
        medicamento.setDosisAdulto("500 mg");
        medicamento.setDosisNino("250 mg");
        medicamento.setNecesitaReceta(true);
        
        
        // Creamos una Receta Medica
        RecetaMedica receta = new RecetaMedica();
        
        List<Medicamento> medicamentos = new ArrayList<>();
        medicamentos.add(medicamento); // Agregar el medicamento a la lista
        receta.setMedicamentos(medicamentos); // Pasar la lista al método
        
        // Asociar la receta al diagnostico
        
        diagnostico.setMedicamentos(medicamentos);
        
        
        
        // Mostramos toda la informacion anterior pa' ve qlq
        
        //System.out.println("=== Informacion de la Cita Medica ===");
        // System.out.println("Paciente: " + cita.getPaciente().getNombre());
        //System.out.println("Medico: " + cita.getMedico().getNombre());
        //System.out.println("Fecha: " + cita.getFecha());
        //System.out.println("Hora: " + cita.getHora());
        //System.out.println("Consultorio: " + cita.getConsultorio());
        //System.out.println("Diagnositco: " + cita.getDiagnostico().getEnfermedad());
        //System.out.println("Sintomas: " + cita.getDiagnostico().getSintomas());
        //System.out.println("Medicamento recetado: " + cita.getDiagnostico().getMedicamentos().get(0).getNombreComercial());
        
        
        JOptionPane.showMessageDialog(null, "Informacion de la cita Medica\n" +
                            "Paciente: " + cita.getPaciente().getNombre() + "\n" + 
                            "Medico: " + cita.getMedico().getNombre() + "\n" + 
                            "Fecha: " + cita.getFecha() + "\n" + 
                            "Hora: " + cita.getHora() + "\n" +
                            "Consultorio: " + cita.getConsultorio() + "\n" +
                            "Diagnositco: " + cita.getDiagnostico().getEnfermedad() + "\n" +
                            "Sintomas: " + cita.getDiagnostico().getSintomas() + "\n" +
                            "Medicamento recetado: " + cita.getDiagnostico().getMedicamentos().get(0).getNombreComercial());
            
        
      /*  JOptionPane.showMessageDialog(null, "Paciente: " + cita.getPaciente().getNombre());
        JOptionPane.showMessageDialog(null, "Medico: " + cita.getMedico().getNombre());
        JOptionPane.showMessageDialog(null, "Fecha: " + cita.getFecha());
        JOptionPane.showMessageDialog(null, "Hora: " + cita.getHora());
        JOptionPane.showMessageDialog(null, "Consultorio: " + cita.getConsultorio());
        JOptionPane.showMessageDialog(null, "Diagnositco: " + cita.getDiagnostico().getEnfermedad());
        JOptionPane.showMessageDialog(null, "Sintomas: " + cita.getDiagnostico().getSintomas());
        JOptionPane.showMessageDialog(null, "Medicamento recetado: " + cita.getDiagnostico().getMedicamentos().get(0).getNombreComercial());

*/
    }
}
