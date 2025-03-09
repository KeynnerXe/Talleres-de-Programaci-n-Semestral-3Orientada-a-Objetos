package KeinnerRamos.base;

import java.util.List;

/**
 *
 * @author Keinner Ramos
 */
public class Medicamento {
    private String nombreComercial;
    private String nombreGenerico;
    private String principioActivo;
    private String laboratorio;
    private String marca;
    private String presentacion;
    private boolean esGenerico;
    private String unidad;
    private String dosisAdulto;
    private String dosisNino;
    private List<String> contraindicaciones;
    private boolean necesitaReceta;
    private boolean coberturaPOS;
    private int unidadesDisponibles;

    // Constructor
    public Medicamento() {
    }

    // Getters y Setters
    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getNombreGenerico() {
        return nombreGenerico;
    }

    public void setNombreGenerico(String nombreGenerico) {
        this.nombreGenerico = nombreGenerico;
    }

    public String getPrincipioActivo() {
        return principioActivo;
    }

    public void setPrincipioActivo(String principioActivo) {
        this.principioActivo = principioActivo;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public boolean isEsGenerico() {
        return esGenerico;
    }

    public void setEsGenerico(boolean esGenerico) {
        this.esGenerico = esGenerico;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getDosisAdulto() {
        return dosisAdulto;
    }

    public void setDosisAdulto(String dosisAdulto) {
        this.dosisAdulto = dosisAdulto;
    }

    public String getDosisNino() {
        return dosisNino;
    }

    public void setDosisNino(String dosisNino) {
        this.dosisNino = dosisNino;
    }

    public List<String> getContraindicaciones() {
        return contraindicaciones;
    }

    public void setContraindicaciones(List<String> contraindicaciones) {
        this.contraindicaciones = contraindicaciones;
    }

    public boolean isNecesitaReceta() {
        return necesitaReceta;
    }

    public void setNecesitaReceta(boolean necesitaReceta) {
        this.necesitaReceta = necesitaReceta;
    }

    public boolean isCoberturaPOS() {
        return coberturaPOS;
    }

    public void setCoberturaPOS(boolean coberturaPOS) {
        this.coberturaPOS = coberturaPOS;
    }

    public int getUnidadesDisponibles() {
        return unidadesDisponibles;
    }

    public void setUnidadesDisponibles(int unidadesDisponibles) {
        this.unidadesDisponibles = unidadesDisponibles;
    }
}
