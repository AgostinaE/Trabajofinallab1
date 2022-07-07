package proyectoFinalG1.Data;

import proyectoFinalG1.Data.Conexion;
import proyectoFinalG1.Modelos.Inquilino;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import proyectoFinalG1.Modelos.Propietario;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class InquilinoData {

    //Crear conexion
    private Connection con = null;
//Constructor con conexio por parametro

    public InquilinoData(Conexion conexion) {
        con = conexion.getConexion();
    }
//Metodo de insertar Inquilino

    public boolean agregarInquilino(Inquilino inquilino) {
        boolean insert = true;
        //Sentancia SQL
        String sql = "INSERT INTO inquilino (nombre, apellido, cuil, trabajo, garante, dniGarante, activo) VALUES ( ?,?,?,?,?,?,?)";

        try {
            //preparar la sentencia
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            //Recupero los valores de la Base de Datos
            ps.setString(1, inquilino.getNombre());
            ps.setString(2, inquilino.getApellido());
            ps.setLong(3, inquilino.getCuil());
            ps.setString(4, inquilino.getTrabajo());
            ps.setString(5, inquilino.getGarante());
            ps.setInt(6, inquilino.getDniGarante());
            ps.setBoolean(7, inquilino.isActivo());
            //Ejecuto la accion
            ps.executeUpdate();
            //Devuelve un resultSet
            ResultSet rs = ps.getGeneratedKeys();
            //Si se agrega genera una llave

            if (rs.next()) {
                inquilino.setIdInquilino(rs.getInt(1));
                //JOptionPane.showMessageDialog(null, " Se agreg� al inquilino " + inquilino + " correctamente");

            } else {
                // JOptionPane.showMessageDialog(null, "Error al intentar agregar al inquilino");
                insert = false;
            }
            //Se cierra la sentencia.
            ps.close();

        } catch (SQLException ex) {
            //Se captura la excepcion
            insert = false;
            if (ex instanceof java.sql.SQLIntegrityConstraintViolationException) {
                //Si existe un repetido se mostrara el mensaje
                JOptionPane.showMessageDialog(null, "Ya existe un inquilino con ese dni ");
            } else {
                //De lo contrario significa que hubo un error sintactico en la sentencia
                JOptionPane.showMessageDialog(null, "Error de sintaxis " + ex);
            }
        }
        return insert;
    }

    //Metodo Modificar Elemento inquilino
    public boolean modificarInquilino(Inquilino inquilino) {
        //Sentencia SQL
        String sql = "UPDATE inquilino SET nombre = ?, apellido = ?, cuil = ?, trabajo = ?, garante = ?, dniGarante = ? WHERE idInquilino = ?";
        boolean modificado = false;
        try {
            //preparar la sentencia
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            //Recupero los valores de la Base de Datos
            ps.setString(1, inquilino.getNombre());
            ps.setString(2, inquilino.getApellido());
            ps.setLong(3, inquilino.getCuil());
            ps.setString(4, inquilino.getTrabajo());
            ps.setString(5, inquilino.getGarante());
            ps.setInt(6, inquilino.getDniGarante());
            if (ps.executeUpdate() != 0) {
                //Ejecuta lo modificado, si devuelve 0 significa que no hubo cambios;
                modificado = true;
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de sintaxis ");
        }
        return modificado;
    }

//Metodo para obetener el elemento inquilino por ID
    public Inquilino obetenerInquilinoPorID(int id) {
        Inquilino inquilino = null;
        try {
            String sql = "SELECT * FROM inquilino WHERE idInquilino = ? AND activo=1;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                inquilino = new Inquilino();
                inquilino.setIdInquilino(resultSet.getInt("idInquilino"));
                inquilino.setNombre(resultSet.getString("nombre"));
                inquilino.setApellido(resultSet.getString("apellido"));
                inquilino.setCuil(resultSet.getLong("cuil"));
                inquilino.setTrabajo(resultSet.getString("trabajo"));
                inquilino.setGarante(resultSet.getString("garante"));
                inquilino.setDniGarante(resultSet.getInt("dniGarante"));
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener el inquilino");
        }
        return inquilino;
    }

    //Metodo para obetener el elemento inquilino por cuil
    public Inquilino obetenerInquilinoPorCuil(Long cuil) {
        Inquilino inquilino = null;
        try {
            String sql = "SELECT * FROM inquilino WHERE dni = ? AND activo=1;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, cuil);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                inquilino = new Inquilino();
                inquilino.setIdInquilino(resultSet.getInt("idInquilino"));
                inquilino.setNombre(resultSet.getString("nombre"));
                inquilino.setApellido(resultSet.getString("apellido"));
                inquilino.setCuil(resultSet.getLong("cuil"));
                inquilino.setTrabajo(resultSet.getString("trabajo"));
                inquilino.setGarante(resultSet.getString("garante"));
                inquilino.setDniGarante(resultSet.getInt("dniGarante"));
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener el inquilino");
        }
        return inquilino;
    }

    //Metodo para obtener todos los propietarios de la base de datos
    public List<Inquilino> obtenerInquilino() {
        ArrayList<Inquilino> inquilinos = new ArrayList<Inquilino>();

        try {
            String sql = "SELECT * FROM inquilino WHERE activo=1;";
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet resultSet = ps.executeQuery();
            Inquilino inquilino;
            while (resultSet.next()) {
                inquilino = new Inquilino();
                inquilino.setIdInquilino(resultSet.getInt("idInquilino"));
                inquilino.setNombre(resultSet.getString("nombre"));
                inquilino.setApellido(resultSet.getString("apellido"));
                inquilino.setCuil(resultSet.getLong("cuil"));
                inquilino.setTrabajo(resultSet.getString("trabajo"));
                inquilino.setGarante(resultSet.getString("garante"));
                inquilino.setDniGarante(resultSet.getInt("dniGarante"));
                inquilinos.add(inquilino);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener alumnos");
        }

        return inquilinos;
    }
//Metodo para "Borrar" un elemento inquilino

    public boolean borrarInquilino(int id) {

        boolean borrado = false;
        String sql = "UPDATE inquilino SET activo = 0 WHERE idInquilino = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            if (ps.executeUpdate() != 0) {
                borrado = true;
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de sintaxis ");
        }
        return borrado;
    }
}
