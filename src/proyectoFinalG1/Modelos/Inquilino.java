package proyectoFinalG1.Modelos;

import java.util.Objects;

public class Inquilino {

    private int idInquilino;

    private String nombre;

    private String apellido;

    private int cuil;

    private String trabajo;

    private String garante;

    private long dniGarante;
    
    private boolean activo;

    public Inquilino() {
    }

    public Inquilino(String nombre, String apellido, int cuil, String trabajo, String nombreGarante, long dniGarante, boolean activo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cuil = cuil;
        this.trabajo = trabajo;
        this.garante = nombreGarante;
        this.dniGarante = dniGarante;
        this.activo = activo;
    }

    public Inquilino(int idInquilino, String nombre, String apellido, int cuil, String trabajo, String nombreGarante, long dniGarante, boolean activo) {
        this.idInquilino = idInquilino;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cuil = cuil;
        this.trabajo = trabajo;
        this.garante = nombreGarante;
        this.dniGarante = dniGarante;
        this.activo = activo;
    }

    public int getIdInquilino() {
        return idInquilino;
    }

    public void setIdInquilino(int idInquilino) {
        this.idInquilino = idInquilino;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getCuil() {
        return cuil;
    }

    public void setCuil(int cuil) {
        this.cuil = cuil;
    }

    public String getTrabajo() {
        return trabajo;
    }

    public void setTrabajo(String trabajo) {
        this.trabajo = trabajo;
    }

    public String getGarante() {
        return garante;
    }

    public void setGarante(String garante) {
        this.garante = garante;
    }

    public long getDniGarante() {
        return dniGarante;
    }

    public void setDniGarante(long dniGarante) {
        this.dniGarante = dniGarante;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.idInquilino;
        hash = 89 * hash + Objects.hashCode(this.nombre);
        hash = 89 * hash + Objects.hashCode(this.apellido);
        hash = 89 * hash + this.cuil;
        hash = 89 * hash + Objects.hashCode(this.trabajo);
        hash = 89 * hash + Objects.hashCode(this.garante);
        hash = 89 * hash + (int) (this.dniGarante ^ (this.dniGarante >>> 32));
        hash = 89 * hash + (this.activo ? 1 : 0);
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
        final Inquilino other = (Inquilino) obj;
        if (this.cuil != other.cuil) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Inquilino{" + "idInquilino=" + idInquilino + ", nombre=" + nombre + ", apellido=" + apellido + ", cuil=" + cuil + ", trabajo=" + trabajo + ", nombreGarante=" + garante + ", dniGarante=" + dniGarante + ", activo=" + activo + '}';
    }

    
}
