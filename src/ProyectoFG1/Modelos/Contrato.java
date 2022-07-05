package ProyectoFG1.Modelos;

import java.time.LocalDate;

public class Contrato {

    private int idContrato;

    private LocalDate inicio;

    private LocalDate finalizacion;

    private LocalDate firma;

    private String empleado;

    private Inquilino inquilino;

    public int getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(int idContrato) {
        this.idContrato = idContrato;
    }

    public LocalDate getInicio() {
        return inicio;
    }

    public void setInicio(LocalDate inicio) {
        this.inicio = inicio;
    }

    public LocalDate getFinalizacion() {
        return finalizacion;
    }

    public void setFinalizacion(LocalDate finalizacion) {
        this.finalizacion = finalizacion;
    }

    public LocalDate getFirma() {
        return firma;
    }

    public void setFirma(LocalDate firma) {
        this.firma = firma;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    public Inquilino getInquilino() {
        return inquilino;
    }

    public void setInquilino(Inquilino inquilino) {
        this.inquilino = inquilino;
    }

    public Inmueble getIdInmueble() {
        return idInmueble;
    }

    public void setIdInmueble(Inmueble idInmueble) {
        this.idInmueble = idInmueble;
    }

    public Contrato(int idContrato, LocalDate inicio, LocalDate finalizacion, LocalDate firma, String empleado, Inquilino inquilino, Inmueble idInmueble) {
        this.idContrato = idContrato;
        this.inicio = inicio;
        this.finalizacion = finalizacion;
        this.firma = firma;
        this.empleado = empleado;
        this.inquilino = inquilino;
        this.idInmueble = idInmueble;
    }

    public Contrato(LocalDate inicio, LocalDate finalizacion, LocalDate firma, String empleado, Inquilino inquilino, Inmueble idInmueble) {
        this.inicio = inicio;
        this.finalizacion = finalizacion;
        this.firma = firma;
        this.empleado = empleado;
        this.inquilino = inquilino;
        this.idInmueble = idInmueble;
    }

    public Contrato() {
    }

    private Inmueble idInmueble;

    @Override
    public String toString() {
        return "Contrato{" + "idContrato=" + idContrato + ", inicio=" + inicio + ", finalizacion=" + finalizacion + ", firma=" + firma + ", empleado=" + empleado + ", inquilino=" + inquilino + ", idInmueble=" + idInmueble + '}';
    }
        @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.idContrato;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Contrato other = (Contrato) obj;
        if (this.idContrato != other.idContrato) {
            return false;
        }
        return true;
    }
    
}
