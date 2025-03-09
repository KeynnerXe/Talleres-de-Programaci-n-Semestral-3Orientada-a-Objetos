package KeinnerRamos.base;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Keinner Ramos
 */
public class RecetaMedica {
    private List<Medicamento> medicamentos;
    private int cantidad;
    private String dosis;
    private Date fechaInicio;
    private Date fechaFin;

    // Constructor
    public RecetaMedica() {
    }

    // Getters y Setters
    public List<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<Medicamento> medicamentos) {
        this.medicamentos = medicamentos;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
}
