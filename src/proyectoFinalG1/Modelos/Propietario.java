package proyectoFinalG1.Modelos;

import java.util.Objects;

public class Propietario {

    private int idPropietario;

    private String nombre;

    private String apellido;

    private int dni;

    private int telefono;

    private String domicilio;

    private boolean activo;

    public Propietario() {
    }

    public Propietario(String nombre, String apellido, int dni, int telefono, String domicilio, boolean activo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.telefono = telefono;
        this.domicilio = domicilio;
        this.activo = activo;
    }

    public Propietario(int idPropietario, String nombre, String apellido, int dni, int telefono, String domicilio, boolean activo) {
        this.idPropietario = idPropietario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.telefono = telefono;
        this.domicilio = domicilio;
        this.activo = activo;
    }

    public int getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(int idPropietario) {
        this.idPropietario = idPropietario;
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

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
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
        hash = 31 * hash + this.idPropietario;
        hash = 31 * hash + Objects.hashCode(this.nombre);
        hash = 31 * hash + Objects.hashCode(this.apellido);
        hash = 31 * hash + this.dni;
        hash = 31 * hash + this.telefono;
        hash = 31 * hash + Objects.hashCode(this.domicilio);
        hash = 31 * hash + (this.activo ? 1 : 0);
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
        final Propietario other = (Propietario) obj;
        if (this.dni != other.dni) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return apellido + ", " + nombre + ", " + telefono;
    }

}
