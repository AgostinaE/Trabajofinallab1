package ProyectoFG1.Modelos;

import java.util.Objects;

public class Inmueble {

    private int idInmueble;

    private String accesibilidad;

    private String caracteristicas;

    private String direccion;

    private double precio;

    private float superficie;

    private String tipoLocal;

    private int zona;

    private Propietario propietario;

    private boolean estado;

    private String codigoInmueble;

    public Inmueble(int idInmueble, String accesibilidad, String caracteristicas, String direccion, double precio, float superficie, String tipoLocal, int zona, Propietario propietario, boolean estado, String codigoInmueble) {
        this.idInmueble = idInmueble;
        this.accesibilidad = accesibilidad;
        this.caracteristicas = caracteristicas;
        this.direccion = direccion;
        this.precio = precio;
        this.superficie = superficie;
        this.tipoLocal = tipoLocal;
        this.zona = zona;
        this.propietario = propietario;
        this.estado = estado;
        this.codigoInmueble = codigoInmueble;
    }

    public Inmueble(String accesibilidad, String caracteristicas, String direccion, double precio, float superficie, String tipoLocal, int zona, Propietario propietario, boolean estado, String codigoInmueble) {
        this.accesibilidad = accesibilidad;
        this.caracteristicas = caracteristicas;
        this.direccion = direccion;
        this.precio = precio;
        this.superficie = superficie;
        this.tipoLocal = tipoLocal;
        this.zona = zona;
        this.propietario = propietario;
        this.estado = estado;
        this.codigoInmueble = codigoInmueble;
    }

    public Inmueble() {
    }

    public int getIdInmueble() {
        return idInmueble;
    }

    public void setIdInmueble(int idInmueble) {
        this.idInmueble = idInmueble;
    }

    public String getAccesibilidad() {
        return accesibilidad;
    }

    public void setAccesibilidad(String accesibilidad) {
        this.accesibilidad = accesibilidad;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public float getSuperficie() {
        return superficie;
    }

    public void setSuperficie(float superficie) {
        this.superficie = superficie;
    }

    public String getTipoLocal() {
        return tipoLocal;
    }

    public void setTipoLocal(String tipoLocal) {
        this.tipoLocal = tipoLocal;
    }

    public int getZona() {
        return zona;
    }

    public void setZona(int zona) {
        this.zona = zona;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getCodigoInmueble() {
        return codigoInmueble;
    }

    public void setCodigoInmueble(String codigoInmueble) {
        this.codigoInmueble = codigoInmueble;
    }

    @Override
    public String toString() {
        return "Inmueble{" + "idInmueble=" + idInmueble + ", accesibilidad=" + accesibilidad + ", caracteristicas=" + caracteristicas + ", direccion=" + direccion + ", precio=" + precio + ", superficie=" + superficie + ", tipoLocal=" + tipoLocal + ", zona=" + zona + ", propietario=" + propietario + ", estado=" + estado + ", codigoInmueble=" + codigoInmueble + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.idInmueble;
        hash = 17 * hash + Objects.hashCode(this.codigoInmueble);
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
        final Inmueble other = (Inmueble) obj;
        if (this.idInmueble != other.idInmueble) {
            return false;
        }
        if (!Objects.equals(this.codigoInmueble, other.codigoInmueble)) {
            return false;
        }
        return true;
    }
    
}
