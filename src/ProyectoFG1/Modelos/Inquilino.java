package ProyectoFG1.Modelos;

public class Inquilino {

    private int idInquilino;

    private String nombre;

    private String apellido;

    private int cuil;

    private String trabajo;

    private String nombreGarante;

    private int dniGarante;

    public Inquilino() {
    }

    public Inquilino(String nombre, String apellido, int cuil, String trabajo, String nombreGarante, int dniGarante) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cuil = cuil;
        this.trabajo = trabajo;
        this.nombreGarante = nombreGarante;
        this.dniGarante = dniGarante;
    }

    public Inquilino(int idInquilino, String nombre, String apellido, int cuil, String trabajo, String nombreGarante, int dniGarante) {
        this.idInquilino = idInquilino;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cuil = cuil;
        this.trabajo = trabajo;
        this.nombreGarante = nombreGarante;
        this.dniGarante = dniGarante;
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

    public String getNombreGarante() {
        return nombreGarante;
    }

    public void setNombreGarante(String nombreGarante) {
        this.nombreGarante = nombreGarante;
    }

    public int getDniGarante() {
        return dniGarante;
    }

    public void setDniGarante(int dniGarante) {
        this.dniGarante = dniGarante;
    }

    @Override
    public String toString() {
        return "Inquilino{" + "idInquilino=" + idInquilino + ", nombre=" + nombre + ", apellido=" + apellido + ", cuil=" + cuil + ", trabajo=" + trabajo + ", nombreGarante=" + nombreGarante + ", dniGarante=" + dniGarante + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.idInquilino;
        hash = 17 * hash + this.dniGarante;
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
        if (this.idInquilino != other.idInquilino) {
            return false;
        }
        if (this.dniGarante != other.dniGarante) {
            return false;
        }
        return true;
    }
    
}
