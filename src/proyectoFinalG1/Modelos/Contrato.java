package proyectoFinalG1.Modelos;

import java.time.LocalDate;
import java.util.Objects;

public class Contrato {

    private int idContrato;

    private LocalDate inicio;

    private LocalDate finalizacion;

    private LocalDate firma;

    private Empleado empleado;

    private Inquilino inquilino;

    private Inmueble inmueble;

    private boolean activo;

    public Contrato() {
    }

    public Contrato(LocalDate inicio, LocalDate finalizacion, LocalDate firma, Empleado dniEmpleado, Inquilino inquilino, Inmueble inmueble, boolean activo) {
        this.inicio = inicio;
        this.finalizacion = finalizacion;
        this.firma = firma;
        this.empleado = dniEmpleado;
        this.inquilino = inquilino;
        this.inmueble = inmueble;
        this.activo = activo;
    }

    public Contrato(int idContrato, LocalDate inicio, LocalDate finalizacion, LocalDate firma, Empleado dniEmpleado, Inquilino inquilino, Inmueble inmueble, boolean activo) {
        this.idContrato = idContrato;
        this.inicio = inicio;
        this.finalizacion = finalizacion;
        this.firma = firma;
        this.empleado = dniEmpleado;
        this.inquilino = inquilino;
        this.inmueble = inmueble;
        this.activo = activo;
    }

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

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setDniEmpleado(Empleado dniEmpleado) {
        this.empleado = dniEmpleado;
    }

    public Inquilino getInquilino() {
        return inquilino;
    }

    public void setInquilino(Inquilino inquilino) {
        this.inquilino = inquilino;
    }

    public Inmueble getInmueble() {
        return inmueble;
    }

    public void setInmueble(Inmueble inmueble) {
        this.inmueble = inmueble;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + this.idContrato;
        hash = 73 * hash + Objects.hashCode(this.inicio);
        hash = 73 * hash + Objects.hashCode(this.finalizacion);
        hash = 73 * hash + Objects.hashCode(this.firma);
        hash = 73 * hash + Objects.hashCode(this.empleado);
        hash = 73 * hash + Objects.hashCode(this.inquilino);
        hash = 73 * hash + Objects.hashCode(this.inmueble);
        hash = 73 * hash + (this.activo ? 1 : 0);
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

    @Override
    public String toString() {
        return "Contrato{" + "idContrato=" + idContrato + ", inicio=" + inicio + ", finalizacion=" + finalizacion + ", firma=" + firma + ", empleado=" + empleado + ", inquilino=" + inquilino + ", inmueble=" + inmueble + ", activo=" + activo + '}';
    }

}
