package KeinnerRamos.base;

import java.util.Date;

/**
 *
 * @author Keinner Ramos
 */
public class Paciente extends Persona {
    private Medico medicoAsignado;

    public Paciente() {
    }

    public Medico getMedicoAsignado() {
        return medicoAsignado;
    }

    public void setMedicoAsignado(Medico medicoAsignado) {
        this.medicoAsignado = medicoAsignado;
    }
}
