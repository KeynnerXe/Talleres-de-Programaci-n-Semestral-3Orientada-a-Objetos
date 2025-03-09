package KeinnerRamos.base;

import java.util.Date;
/**
 *
 * @author Keinner Ramos
 */
public class CitaMedica {
    private Date fecha;
    private String hora;
    private String consultorio;
    private String IPS;
    private String EPS;
    private Medico medico;
    private Paciente paciente;
    private Diagnostico diagnostico;

    // Constructor
    public CitaMedica() {
    }

    // Getters y Setters
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(String consultorio) {
        this.consultorio = consultorio;
    }

    public String getIPS() {
        return IPS;
    }

    public void setIPS(String IPS) {
        this.IPS = IPS;
    }

    public String getEPS() {
        return EPS;
    }

    public void setEPS(String EPS) {
        this.EPS = EPS;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Diagnostico getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(Diagnostico diagnostico) {
        this.diagnostico = diagnostico;
    }

    // Método para programar la cita
    public void programarCita() {
        System.out.println("Cita programada para el paciente: " + paciente.getNombre());
    }
}
