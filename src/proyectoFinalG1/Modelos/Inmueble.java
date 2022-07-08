package proyectoFinalG1.Modelos;

import java.util.Objects;

public class Inmueble {

    private int idInmueble;

    private String caracteristicas;

    private String direccion;

    private double precio;

    private float superficie;

    private String tipoLocal;

    private int zona;

    private Propietario propietario;

    private String codigoInmueble;
    
    private boolean activo;

    public Inmueble() {
    }

    public Inmueble(String caracteristicas, String direccion, double precio, float superficie, String tipoLocal, int zona, Propietario propietario, String codigoInmueble, boolean activo) {
        this.caracteristicas = caracteristicas;
        this.direccion = direccion;
        this.precio = precio;
        this.superficie = superficie;
        this.tipoLocal = tipoLocal;
        this.zona = zona;
        this.propietario = propietario;
        this.codigoInmueble = codigoInmueble;
        this.activo = activo;
    }

    public Inmueble(int idInmueble, String caracteristicas, String direccion, double precio, float superficie, String tipoLocal, int zona, Propietario propietario, String codigoInmueble, boolean activo) {
        this.idInmueble = idInmueble;
        this.caracteristicas = caracteristicas;
        this.direccion = direccion;
        this.precio = precio;
        this.superficie = superficie;
        this.tipoLocal = tipoLocal;
        this.zona = zona;
        this.propietario = propietario;
        this.codigoInmueble = codigoInmueble;
        this.activo = activo;
    }

    public int getIdInmueble() {
        return idInmueble;
    }

    public void setIdInmueble(int idInmueble) {
        this.idInmueble = idInmueble;
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

    public String getCodigoInmueble() {
        return codigoInmueble;
    }

    public void setCodigoInmueble(String codigoInmueble) {
        this.codigoInmueble = codigoInmueble;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.idInmueble;
        hash = 97 * hash + Objects.hashCode(this.caracteristicas);
        hash = 97 * hash + Objects.hashCode(this.direccion);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.precio) ^ (Double.doubleToLongBits(this.precio) >>> 32));
        hash = 97 * hash + Float.floatToIntBits(this.superficie);
        hash = 97 * hash + Objects.hashCode(this.tipoLocal);
        hash = 97 * hash + this.zona;
        hash = 97 * hash + Objects.hashCode(this.propietario);
        hash = 97 * hash + Objects.hashCode(this.codigoInmueble);
        hash = 97 * hash + (this.activo ? 1 : 0);
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
        if (!Objects.equals(this.codigoInmueble, other.codigoInmueble)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return codigoInmueble;
    }

    
}
