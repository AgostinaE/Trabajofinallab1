
package proyectoFinalG1.Data;

import proyectoFinalG1.Data.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import proyectoFinalG1.Modelos.Contrato;

/**
 *
 * @author POSITIVO BGH
 */
public class ContratoData {
    //Paso 1 crear un atributo coneccion 
   private Connection con = null;
   private InquilinoData inquilinoData;
   private EmpleadoData empleadoData;
   private PropietarioData propietarioData;
   //paso 2 creo un constructor y le paso el objeto connection e imboco al metodo getConection

    public ContratoData(Conexion conexion) {
        con = conexion.getConexion();
        this.inquilinoData = new InquilinoData(conexion);
        this.empleadoData = new EmpleadoData(conexion);
        this.propietarioData = new PropietarioData(conexion);
    }
   
    public boolean crearContrato(Contrato contrato){
        boolean creado = true;
        try{
            String sql = "INSERT INTO contrato ( inicio , finalizacion , firma , dniEmpleado , idInquilino , idInmueble , activo ) VALUES ( ? , ? , ? , ? , ? , ? , ? );";
            PreparedStatement ps = con.prepareStatement(sql , Statement.RETURN_GENERATED_KEYS);
            ps.setDate(1, Date.valueOf(contrato.getInicio()));
            ps.setDate(2, Date.valueOf(contrato.getFinalizacion()));
            ps.setDate(3, Date.valueOf(contrato.getFirma()));
            ps.setInt(4, contrato.getEmpleado().getDni());
            ps.setInt(5, contrato.getInquilino().getIdInquilino());
            ps.setInt(6, contrato.getInmueble().getIdInmueble());
            ps.setBoolean(7, contrato.isActivo());
            
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            
            if(rs.next()){
                contrato.setIdContrato(rs.getInt(1));
                JOptionPane.showMessageDialog(null,"Se agrego un contrato correctamente");
            }else{
                creado= false;
                JOptionPane.showMessageDialog(null,"pincho");
            }
            ps.close();
        }catch(Exception ex){
            creado=false;
            if(ex instanceof java.sql.SQLIntegrityConstraintViolationException){
                JOptionPane.showMessageDialog(null, "El contrato que esta queriendo cargar ya existe" );
            }else {
                JOptionPane.showMessageDialog(null, "Error de sintaxis "+ex );
            }
        }
        return creado;
    }

    public boolean cancelarContrato(int idContrato){
        boolean cancelado = false;
        String sql = "UPDATE contrato SET finalizacion = ? , activo = 0 WHERE idContrato = ?;";
        try{
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setDate(1, Date.valueOf(LocalDate.now()));
            ps.setInt(2,idContrato);
            if(ps.executeUpdate()!=0){
                JOptionPane.showMessageDialog(null,"Se cancelo");
                cancelado=true;
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error de sintaxis ");
        }
        return cancelado;
    }
    
    public boolean renovarContrato(int idContrato, LocalDate renovacionI, LocalDate renovacionF){
        boolean renovado = false;
        String sql = "UPDATE contrato SET inicio = ? , finalizacion = ? WHERE idContrato = ?;";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(renovacionI));
            ps.setDate(2, Date.valueOf(renovacionF));
            ps.setInt(3, idContrato);
            if(ps.executeUpdate()!=0){
            renovado=true;
            }
            JOptionPane.showMessageDialog(null,"Se cancelo");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"se rompio");
        }
        return renovado;
    }
}
