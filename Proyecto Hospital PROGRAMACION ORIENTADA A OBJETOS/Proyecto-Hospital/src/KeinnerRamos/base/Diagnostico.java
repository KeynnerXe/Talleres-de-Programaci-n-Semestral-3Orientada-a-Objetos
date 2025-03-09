package KeinnerRamos.base;

import java.util.List;

/**
 *
 * @author Keinner Ramos
 */

public class Diagnostico {
    private String enfermedad;
    private List<String> sintomas;
    private String descripcion;
    private List<Medicamento> medicamentos;

    // Constructor
    public Diagnostico() {
    }

    // Getters y Setters
    public String getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }

    public List<String> getSintomas() {
        return sintomas;
    }

    public void setSintomas(List<String> sintomas) {
        this.sintomas = sintomas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<Medicamento> medicamentos) {
        this.medicamentos = medicamentos;
    }
}
