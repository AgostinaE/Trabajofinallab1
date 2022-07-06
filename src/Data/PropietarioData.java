package Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import ProyectoFG1.Modelos.Propietario;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class PropietarioData {

    //Crear conexion
    private Connection con = null;
//Constructor con conexio por parametro

    public PropietarioData(Conexion conexion) {
        con = conexion.getConexion();
    }
//Metodo de insertar Propietario

    public boolean agregarPropietario(Propietario propietario) {
        boolean insert = true;
        //Sentancia SQL
        String sql = "INSERT INTO propietario (nombre, apellido, dni, telefono, domicilio) VALUES ( ?,?,?,?,?)";

        try {
            //preparar la sentencia
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            //Recupero los valores de la Base de Datos
            ps.setString(1, propietario.getNombre());
            ps.setString(2, propietario.getApellido());
            ps.setInt(3, propietario.getDni());
            ps.setInt(4, propietario.getTelefono());
            ps.setString(5, propietario.getDomicilio());

            //Ejecuto la accion
            ps.executeUpdate();
            //Devuelve un resultSet
            ResultSet rs = ps.getGeneratedKeys();
            //Si se agrega genera una llave

            if (rs.next()) {
                propietario.setIdPropietario(rs.getInt(1));
                //JOptionPane.showMessageDialog(null, " Se agreg� al propietario " + propietario + " correctamente");

            } else {
                // JOptionPane.showMessageDialog(null, "Error al intentar agregar al propietario");
                insert = false;
            }
            //Se cierra la sentencia.
            ps.close();

        } catch (SQLException ex) {
            //Se captura la excepcion
            insert = false;
            if (ex instanceof java.sql.SQLIntegrityConstraintViolationException) {
                //Si existe un repetido se mostrara el mensaje
                JOptionPane.showMessageDialog(null, "Ya existe un propietario con ese dni ");
            } else {
                //De lo contrario significa que hubo un error sintactico en la sentencia
                JOptionPane.showMessageDialog(null, "Error de sintaxis " + ex);
            }
        }
        return insert;
    }

    //Metodo Modificar Elemento Propietario
    public boolean modificarPropietario(Propietario propietario) {
        //Sentencia SQL
        String sql = "UPDATE propietario SET nombre = ?, apellido = ?, dni = ?, telefono = ?, domicilio = ? WHERE idPropietario = ?";
        boolean modificado = false;
        try {
            //preparar la sentencia
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            //Recupero los valores de la Base de Datos
            ps.setString(1, propietario.getNombre());
            ps.setString(2, propietario.getApellido());
            ps.setInt(3, propietario.getDni());
            ps.setInt(4, propietario.getTelefono());
            ps.setString(5, propietario.getDomicilio());

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

//Metodo para obetener el elemento propietario por ID
    public Propietario obetenerPropietarioPorID(int id) {
        Propietario propietario = null;
        try {
            String sql = "SELECT * FROM propietario WHERE idPropietario = ?;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                propietario = new Propietario();
                propietario.setIdPropietario(resultSet.getInt("idPropietario"));
                propietario.setNombre(resultSet.getString("nombre"));
                propietario.setApellido(resultSet.getString("apellido"));
                propietario.setDni(resultSet.getInt("dni"));
                propietario.setTelefono(resultSet.getInt("telefono"));
                propietario.setDomicilio(resultSet.getString("domicilio"));

            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener el propietario");
        }
        return propietario;
    }

    //Metodo para obetener el elemento propietario por DNI
    public Propietario obetenerPropietarioPorDNI(int dni) {
        Propietario propietario = null;
        try {
            String sql = "SELECT * FROM propietario WHERE dni = ?;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                propietario = new Propietario();
                propietario.setIdPropietario(resultSet.getInt("idPropietario"));
                propietario.setNombre(resultSet.getString("nombre"));
                propietario.setApellido(resultSet.getString("apellido"));
                propietario.setDni(resultSet.getInt("dni"));
                propietario.setTelefono(resultSet.getInt("telefono"));
                propietario.setDomicilio(resultSet.getString("domicilio"));

            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener el propietario");
        }
        return propietario;
    }
    //Metodo para obtener todos los propietarios de la base de datos
    public List<Propietario> obtenerPropietarios() {
        ArrayList<Propietario> propietarios = new ArrayList<Propietario>();

        try {
            String sql = "SELECT * FROM propietario;";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ResultSet resultSet = ps.executeQuery();
           Propietario propietario;
            while (resultSet.next()) {
                propietario = new Propietario();
                propietario.setIdPropietario(resultSet.getInt("idPropietario"));
                propietario.setNombre(resultSet.getString("nombre"));
                propietario.setApellido(resultSet.getString("apellido"));
                propietario.setDni(resultSet.getInt("dni"));
                propietario.setTelefono(resultSet.getInt("telefono"));
                propietario.setDomicilio(resultSet.getString("domicilio"));


                propietarios.add(propietario);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al obtener alumnos");
        }

        return propietarios;
    }
    
}
