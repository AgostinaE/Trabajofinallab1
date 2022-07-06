package ProyectoFinalG1.Data;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import ProyectoFG1.Modelos.Inmueble;
import  ProyectoFinalG1.Data.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author POSITIVO BGH
 */
public class InmuebleData {
    
    private Connection con = null;
    
public InmuebleData(Conexion conexion){
    
    con = conexion.getConexion();
}

public boolean agregarInmueble(Inmueble inmueble){
    
    boolean insertado = true;
     String sql = "INSERT INTO inmueble (caracteristica, direccion, precio, superficie, tipoLocal, zona, propietario, codigoInmueble, activo)  VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            ps.setString(1, inmueble.getCaracteristicas());
            ps.setString(2, inmueble.getDireccion());
            ps.setDouble(3, inmueble.getPrecio());
            ps.set(4, alumno.getDni());
            ps.setBoolean(5, alumno.isActivo());
            
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
     if (rs.next()) {
                alumno.setIdAlumno(rs.getInt(1));
            } else {
                // JOptionPane.showMessageDialog(null, "Error al intentar agregar al alumno");
                insert = false;
            }

            ps.close();
        } catch (SQLException ex) {
            insert=false;
            if(ex instanceof java.sql.SQLIntegrityConstraintViolationException){
                JOptionPane.showMessageDialog(null, "Ya existe un alumno con ese dni " );
            }else {
            
                JOptionPane.showMessageDialog(null, "Error de sintaxis "+ex );
                
            }
            

        }
   return insertado; 
}
    
}
