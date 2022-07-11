package proyectoFinalG1.Data;

import proyectoFinalG1.Data.Conexion;
import proyectoFinalG1.Modelos.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class EmpleadoData {

    private Connection con = null;

    public EmpleadoData(Conexion conexion) {

        con = conexion.getConexion();

    }

    public boolean agregarEmpleado(Empleado empleado) {

        boolean insert = true;
        String sql = "INSERT INTO empleado (nombre, apellido, dni, activo)  VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, empleado.getNombre());
            ps.setString(2, empleado.getApellido());
            ps.setLong(3, empleado.getDni());
            ps.setBoolean(4, empleado.isActivo());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            //JOptionPane.showMessageDialog(null, " Se agregó al empleado " + empleado + " correctamente");
            if (rs.next()) {
                empleado.setIdEmpleado(rs.getInt(1));
            } else {
                JOptionPane.showMessageDialog(null, "Error al intentar agregar al empleado");
                insert = false;
            }

            ps.close();
        } catch (SQLException ex) {
            insert = false;
            if (ex instanceof java.sql.SQLIntegrityConstraintViolationException) {
                JOptionPane.showMessageDialog(null, "Ya existe un empleado con ese dni ");
            } else {

                JOptionPane.showMessageDialog(null, "Error de sintaxis " + ex);

            }
        }
        return insert;

    }

    public List<Empleado> obtenerEmpleados() {
        ArrayList<Empleado> empleados = new ArrayList<Empleado>();

        try {
            String sql = "SELECT * FROM empleado WHERE activo = 1;";
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet resultSet = ps.executeQuery();
            Empleado empleado;
            while (resultSet.next()) {
                empleado = new Empleado();
                empleado.setIdEmpleado(resultSet.getInt("idEmpleado"));
                empleado.setApellido(resultSet.getString("apellido"));
                empleado.setNombre(resultSet.getString("nombre"));
                empleado.setDni(resultSet.getInt("dni"));
                empleado.setActivo(resultSet.getBoolean("activo"));

                empleados.add(empleado);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener empleados");
        }

        return empleados;
    }

    public Empleado obtenerEmpleadoXDNI(long dni) {

        Empleado empleado = null;

        try {
            String sql = "SELECT * FROM empleado WHERE dni = ? AND activo = 1;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, dni);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                empleado = new Empleado();
                empleado.setIdEmpleado(resultSet.getInt("idEmpleado"));
                empleado.setApellido(resultSet.getString("apellido"));
                empleado.setNombre(resultSet.getString("nombre"));
                empleado.setDni(resultSet.getInt("dni"));
                empleado.setActivo(resultSet.getBoolean("activo"));

            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener empleado");
        }

        return empleado;
    }

    public boolean borrarEmpleado(int idEmpleado) {

        boolean borrado = false;
        String sql = "UPDATE empleado SET activo = 0 WHERE idEmpleado = ?";
        try {

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idEmpleado);

            if (ps.executeUpdate() != 0) {

                borrado = true;
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de sintaxis Borrado ");
        }

        return borrado;
    }

    public boolean modificarEmpleado(Empleado empleado) {

        String sql = "UPDATE empleado SET nombre=?,apellido=?,dni=?,activo=? WHERE idEmpleado = ? ";
        boolean modificado = false;
        try {
            System.out.println("paso");
            PreparedStatement ps = con.prepareStatement(sql);
            System.out.println("paso");
            ps.setString(1, empleado.getNombre());
            System.out.println("paso");
            ps.setString(2, empleado.getApellido());
            System.out.println("paso");
            ps.setInt(3, empleado.getDni());
            System.out.println("paso");
            ps.setBoolean(4, empleado.isActivo());
            System.out.println("paso");
            ps.setInt(5, empleado.getIdEmpleado());
            System.out.println("paso");

            if (ps.executeUpdate() != 0) {
                System.out.println("Entro");
                modificado = true;
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de sintaxis ");
        }
        return modificado;
    }
}
