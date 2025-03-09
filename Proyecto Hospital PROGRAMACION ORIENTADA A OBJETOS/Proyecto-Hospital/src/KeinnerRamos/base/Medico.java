package KeinnerRamos.base;
import java.util.Date;
import java.util.List;
/**
 *
 * @author Keinner Ramos
 */
public class Medico extends Persona {
    private String numColegiado;
    private String categoria;
    private String horarioConsulta;

    public Medico() {
    }

    public String getNumColegiado() {
        return numColegiado;
    }

    public void setNumColegiado(String numColegiado) {
        this.numColegiado = numColegiado;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getHorarioConsulta() {
        return horarioConsulta;
    }

    public void setHorarioConsulta(String horarioConsulta) {
        this.horarioConsulta = horarioConsulta;
    }
}
