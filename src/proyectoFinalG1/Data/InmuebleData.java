package proyectoFinalG1.Data;

import proyectoFinalG1.Data.Conexion;
import proyectoFinalG1.Modelos.Inmueble;
import proyectoFinalG1.Modelos.Propietario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Grupo 1
 */
public class InmuebleData {

    private Connection con = null;
    private PropietarioData propietarioData;

    public InmuebleData(Conexion conexion) {

        con = conexion.getConexion();
        this.propietarioData = new PropietarioData(conexion);
    }

    public boolean agregarInmueble(Inmueble inmueble) {

        boolean insertado = true;
        String sql = "INSERT INTO inmueble (caracteristicas, direccion, precio, superficie, tipoLocal, zona, idPropietario, codigoInmueble, activo)  VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, inmueble.getCaracteristicas());
            ps.setString(2, inmueble.getDireccion());
            ps.setDouble(3, inmueble.getPrecio());
            ps.setDouble(4, inmueble.getSuperficie());
            ps.setString(5, inmueble.getTipoLocal());
            ps.setInt(6, inmueble.getZona());
            ps.setInt(7, inmueble.getPropietario().getIdPropietario());
            ps.setString(8, inmueble.getCodigoInmueble());
            ps.setBoolean(9, inmueble.isActivo());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                inmueble.setIdInmueble(rs.getInt(1));
            } else {

                insertado = false;
            }

            ps.close();
        } catch (SQLException ex) {
            insertado = false;
            if (ex instanceof java.sql.SQLIntegrityConstraintViolationException) {
                JOptionPane.showMessageDialog(null, "Ya existe un Inmueble con ese Codigo ");
            } else {

                JOptionPane.showMessageDialog(null, "Error de sintaxis aca " + ex);

            }

        }
        return insertado;
    }

    public List<Inmueble> obtenerInmuebles() {
        ArrayList<Inmueble> inmuebles = new ArrayList<Inmueble>();

        try {
            String sql = "SELECT * FROM inmueble WHERE activo = 1;";
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet resultSet = ps.executeQuery();
            Inmueble inmueble;
            while (resultSet.next()) {
                inmueble = new Inmueble();
                inmueble.setIdInmueble(resultSet.getInt("idInmueble"));
                inmueble.setCaracteristicas(resultSet.getString("caracteristicas"));
                inmueble.setDireccion(resultSet.getString("direccion"));
                inmueble.setPrecio(resultSet.getDouble("precio"));
                inmueble.setSuperficie(resultSet.getFloat("superficie"));
                inmueble.setTipoLocal(resultSet.getString("tipoLocal"));
                Propietario i = propietarioData.obetenerPropietarioPorID(resultSet.getInt("idPropietario"));
                inmueble.setPropietario(i);
                inmueble.setCodigoInmueble(resultSet.getString("codigoInmueble"));
                inmueble.setActivo(resultSet.getBoolean("activo"));

                inmuebles.add(inmueble);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al obtener Inmuebles ");
        }

        return inmuebles;
    }

    public Inmueble obtenerInmuebleXId(int id) {
        Inmueble inmueble = null;
        try {
            String sql = "SELECT * FROM inmueble WHERE idInmueble = ? AND activo = 1;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                inmueble = new Inmueble();
                inmueble.setIdInmueble(resultSet.getInt("idInmueble"));
                inmueble.setCaracteristicas(resultSet.getString("caracteristicas"));
                inmueble.setDireccion(resultSet.getString("direccion"));
                inmueble.setPrecio(resultSet.getDouble("precio"));
                inmueble.setSuperficie(resultSet.getFloat("superficie"));
                inmueble.setTipoLocal(resultSet.getString("tipoLocal"));
                Propietario i = propietarioData.obetenerPropietarioPorID(resultSet.getInt("idPropietario"));
                inmueble.setPropietario(i);
                inmueble.setCodigoInmueble(resultSet.getString("codigoInmueble"));
                inmueble.setActivo(resultSet.getBoolean("activo"));
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener Inmueble");
        }
        return inmueble;
    }

    public Inmueble obtenerInmuebleXCodigoInmueble(String codigoInmueble) {

        Inmueble inmueble = null;

        try {
            String sql = "SELECT * FROM inmueble WHERE codigoInmueble = ? AND activo = 1;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, codigoInmueble);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                inmueble = new Inmueble();
                inmueble.setIdInmueble(resultSet.getInt("idInmueble"));
                inmueble.setCaracteristicas(resultSet.getString("caracteristicas"));
                inmueble.setDireccion(resultSet.getString("direccion"));
                inmueble.setPrecio(resultSet.getDouble("precio"));
                inmueble.setSuperficie(resultSet.getFloat("superficie"));
                inmueble.setTipoLocal(resultSet.getString("tipoLocal"));
                Propietario i = propietarioData.obetenerPropietarioPorID(resultSet.getInt("idPropietario"));
                inmueble.setPropietario(i);
                inmueble.setCodigoInmueble(resultSet.getString("codigoInmueble"));
                inmueble.setActivo(resultSet.getBoolean("activo"));

            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener Inmuebles por Codigo Inmueble");
        }

        return inmueble;
    }

    public boolean borrarInmueble(int idInmueble) {

        boolean borrado = false;
        String sql = "UPDATE inmueble SET activo = 0 WHERE idInmueble = ?";
        try {

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idInmueble);

            if (ps.executeUpdate() != 0) {

                borrado = true;
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de sintaxis ");
        }

        return borrado;
    }

    public boolean modificarInmueble(Inmueble inmueble) {

        String sql = "UPDATE inmueble SET caracteristicas = ?, direccion = ?, precio = ?, superficie = ?, tipoLocal = ?, zona = ?, idPropietario = ?, codigoInmueble = ?, activo = ? WHERE idInmueble = ? AND activo=true;";
        boolean modificado = false;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, inmueble.getCaracteristicas());
            ps.setString(2, inmueble.getDireccion());
            ps.setDouble(3, inmueble.getPrecio());
            ps.setDouble(4, inmueble.getSuperficie());
            ps.setString(5, inmueble.getTipoLocal());
            ps.setInt(6, inmueble.getZona());
            ps.setString(8, inmueble.getCodigoInmueble());
            ps.setInt(7, inmueble.getPropietario().getIdPropietario());
            ps.setBoolean(9, inmueble.isActivo());
            ps.setInt(10, inmueble.getIdInmueble());

            if (ps.executeUpdate() != 0) {

                modificado = true;
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de sintaxis ");
        }
        return modificado;
    }

    //Listar los inmuebles que estén alquilados al día de hoy
    public List<Inmueble> alquilados() {
        ArrayList<Inmueble> inmuebles = new ArrayList<Inmueble>();

        try {
            String sql = "SELECT inmueble.* FROM contrato , inmueble WHERE inmueble.idInmueble=contrato.idInmueble AND inmueble.activo = 1 AND contrato.finalizacion>'?'; ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(LocalDate.now()));
            ResultSet resultSet = ps.executeQuery();
            Inmueble inmueble;
            while (resultSet.next()) {
                inmueble = new Inmueble();
                inmueble.setIdInmueble(resultSet.getInt("idInmueble"));
                inmueble.setCaracteristicas(resultSet.getString("caracteristicas"));
                inmueble.setDireccion(resultSet.getString("direccion"));
                inmueble.setPrecio(resultSet.getDouble("precio"));
                inmueble.setSuperficie(resultSet.getFloat("superficie"));
                inmueble.setTipoLocal(resultSet.getString("tipoLocal"));
                Propietario i = propietarioData.obetenerPropietarioPorID(resultSet.getInt("idPropietario"));
                inmueble.setPropietario(i);
                inmueble.setCodigoInmueble(resultSet.getString("codigoInmueble"));
                inmueble.setActivo(resultSet.getBoolean("activo"));

                inmuebles.add(inmueble);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al obtener Inmuebles ");
        }

        return inmuebles;
    }

    //Listar los inmuebles no alquilados al día de hoy
    public List<Inmueble> NoAlquilados() {
        ArrayList<Inmueble> inmuebles = new ArrayList<Inmueble>();
        LocalDate fecha = LocalDate.now();
       try {
            System.out.println("1");
            String sql = "SELECT inmueble.* FROM inmueble WHERE \n" +
"inmueble.activo=1 AND inmueble.idInmueble NOT IN\n" +
"(SELECT inmueble.idInmueble FROM contrato , inmueble WHERE inmueble.idInmueble=contrato.idInmueble AND inmueble.activo = 1 AND contrato.finalizacion>'"+Date.valueOf(fecha)+"');";
            System.out.println("2");
            PreparedStatement ps = con.prepareStatement(sql);
            System.out.println("3");
            //ps.setDate(1, Date.valueOf(fecha));
            System.out.println("4");
            ResultSet resultSet = ps.executeQuery();
            System.out.println("5");
            Inmueble inmueble;
            System.out.println("6");
            while (resultSet.next()) {
                inmueble = new Inmueble();
                System.out.println("1");
                inmueble.setIdInmueble(resultSet.getInt("idInmueble"));
                System.out.println("2");
                inmueble.setCaracteristicas(resultSet.getString("caracteristicas"));
                System.out.println("3");
                inmueble.setDireccion(resultSet.getString("direccion"));
                System.out.println("4");
                inmueble.setPrecio(resultSet.getDouble("precio"));
                System.out.println("5");
                inmueble.setSuperficie(resultSet.getFloat("superficie"));
                System.out.println("6");
                inmueble.setTipoLocal(resultSet.getString("tipoLocal"));
                System.out.println("7");
                Propietario i = propietarioData.obetenerPropietarioPorID(resultSet.getInt("idPropietario"));
                System.out.println("8");
                inmueble.setPropietario(i);
                System.out.println("9");
                inmueble.setCodigoInmueble(resultSet.getString("codigoInmueble"));
                System.out.println("10");
                inmueble.setActivo(resultSet.getBoolean("activo"));
                System.out.println("11");
                inmuebles.add(inmueble);
                System.out.println("12");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al obtener Inmuebles ");
        }

        return inmuebles;
    }

    public List<Inmueble> obtenerDireccionYPrecioAlquileresXDueño(int idPropietario) {
        ArrayList<Inmueble> inmuebles = new ArrayList<Inmueble>();

        try {
            String sql = "SELECT inmueble.direccion, inmueble.precio FROM propietario , inmueble, contrato WHERE inmueble.idPropietario=propietario.idPropietario AND inmueble.activo = 1 AND ontrato.finalizacion>'?' AND propietario.idPropietario=? AND inmueble.idInmueble=contrato.idInmueble;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(LocalDate.now()));
            ps.setInt(2, idPropietario);
            ResultSet resultSet = ps.executeQuery();
            Inmueble inmueble;
            while (resultSet.next()) {
                inmueble = new Inmueble();
                inmueble.setIdInmueble(resultSet.getInt("idInmueble"));
                inmueble.setCaracteristicas(resultSet.getString("caracteristicas"));
                inmueble.setDireccion(resultSet.getString("direccion"));
                inmueble.setPrecio(resultSet.getDouble("precio"));
                inmueble.setSuperficie(resultSet.getFloat("superficie"));
                inmueble.setTipoLocal(resultSet.getString("tipoLocal"));
                Propietario i = propietarioData.obetenerPropietarioPorID(resultSet.getInt("idPropietario"));
                inmueble.setPropietario(i);
                inmueble.setCodigoInmueble(resultSet.getString("codigoInmueble"));
                inmueble.setActivo(resultSet.getBoolean("activo"));

                inmuebles.add(inmueble);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al obtener Inmuebles ");
        }

        return inmuebles;
    }
    //Listar dirección y precio de los inmuebles alquilados actualmente de un determinado propietario

}
/*

SELECT inmueble.direccion, inmueble.precio FROM propietario , inmueble, contrato WHERE inmueble.idPropietario=propietario.idPropietario AND inmueble.activo = 1 AND ontrato.finalizacion>'?' AND propietario.idPropietario=? AND inmueble.idInmueble=contrato.idInmueble;
*/
