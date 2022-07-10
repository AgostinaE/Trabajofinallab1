package proyectoFinalG1.Data;

import proyectoFinalG1.Data.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import proyectoFinalG1.Modelos.Contrato;
import proyectoFinalG1.Modelos.Empleado;
import proyectoFinalG1.Modelos.Inmueble;
import proyectoFinalG1.Modelos.Inquilino;

/**
 *
 * @author Grupo 1
 */
public class ContratoData {

    //Paso 1 crear un atributo coneccion 
    private Connection con = null;
    private InquilinoData inquilinoData;
    private EmpleadoData empleadoData;
    private PropietarioData propietarioData;
    private InmuebleData inmuebleData;
    //paso 2 creo un constructor y le paso el objeto connection e imboco al metodo getConection

    public ContratoData(Conexion conexion) {
        con = conexion.getConexion();
        this.inmuebleData = new InmuebleData(conexion);
        this.inquilinoData = new InquilinoData(conexion);
        this.empleadoData = new EmpleadoData(conexion);
        this.propietarioData = new PropietarioData(conexion);
    }

    public boolean crearContrato(Contrato contrato) {
        boolean creado = true;
        try {
            String sql = "INSERT INTO contrato ( inicio , finalizacion , firma , dniEmpleado , idInquilino , idInmueble , activo ) VALUES ( ? , ? , ? , ? , ? , ? , ? );";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setDate(1, Date.valueOf(contrato.getInicio()));
            ps.setDate(2, Date.valueOf(contrato.getFinalizacion()));
            ps.setDate(3, Date.valueOf(contrato.getFirma()));
            ps.setInt(4, contrato.getEmpleado().getDni());
            ps.setInt(5, contrato.getInquilino().getIdInquilino());
            ps.setInt(6, contrato.getInmueble().getIdInmueble());
            ps.setBoolean(7, true);

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                contrato.setIdContrato(rs.getInt(1));
            } else {
                creado = false;
                JOptionPane.showMessageDialog(null, "No se pudo cargar el contrato");
            }
            ps.close();
        } catch (Exception ex) {
            creado = false;
            if (ex instanceof java.sql.SQLIntegrityConstraintViolationException) {
                JOptionPane.showMessageDialog(null, "El contrato que esta queriendo cargar ya existe");
            } else {
                JOptionPane.showMessageDialog(null, "El inquilino que esta cargando no existe ");
            }
        }
        return creado;
    }

    public boolean borrarContrato(int idContrato) {
        boolean cancelado = false;
        String sql = "DELETE FROM contrato WHERE idContrato = ?;";
        try {

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idContrato);
            int rs = ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Eliminacion exitosa");
            if (rs == 0) {
                cancelado = false;
            }
            //////// el if de arriba ////////
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de sintaxis ");
        }
        return cancelado;
    }

    public boolean renovarContrato(int idContrato, LocalDate renovacionI, LocalDate renovacionF) {
        boolean renovado = false;
        String sql = "UPDATE contrato SET inicio = ? , finalizacion = ? , firma = ? , activo=true WHERE idContrato = ?;";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(renovacionI));
            ps.setDate(2, Date.valueOf(renovacionF));
            ps.setDate(3, Date.valueOf(LocalDate.now()));
            ps.setInt(4, idContrato);
            if (ps.executeUpdate() != 0) {
                renovado = true;
            }
            JOptionPane.showMessageDialog(null, "Se renovo");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error");
        }
        return renovado;
    }

    public Contrato buscarContratoXId(int idContrato) {
        Contrato contrato = null;
        try {
            String sql = " SELECT * FROM contrato WHERE idContrato = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idContrato);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                //idContrato, inicio,finalizacion,firma,dniEmpleado,idInquilino,idInmueble,activo
                contrato = new Contrato();
                contrato.setIdContrato(rs.getInt("idContrato"));
                contrato.setInicio(rs.getDate("inicio").toLocalDate());
                contrato.setFinalizacion(rs.getDate("finalizacion").toLocalDate());
                contrato.setFirma(rs.getDate("firma").toLocalDate());
                Empleado empleado = empleadoData.obtenerEmpleadoXDNI(rs.getInt("dniEmpleado"));
                contrato.setDniEmpleado(empleado);
                Inquilino inquilino = inquilinoData.obetenerInquilinoPorID(rs.getInt("idInquilino"));
                contrato.setInquilino(inquilino);
                Inmueble inmueble = inmuebleData.obtenerInmuebleXId(rs.getInt("idInmueble"));
                contrato.setInmueble(inmueble);
                contrato.setActivo(rs.getBoolean("activo"));
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ocurrio un error");
        }
        return contrato;
    }
    
    public List<Contrato> obtenerContratos(){
        ArrayList<Contrato> contratos = new ArrayList<Contrato>();
        try {
            Contrato contrato;
            String sql = "SELECT * FROM contrato;";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                contrato = new Contrato();
                contrato.setIdContrato(rs.getInt("idContrato"));
                contrato.setInicio(rs.getDate("inicio").toLocalDate());
                contrato.setFinalizacion(rs.getDate("finalizacion").toLocalDate());
                contrato.setFirma(rs.getDate("firma").toLocalDate());
                Empleado empleado = empleadoData.obtenerEmpleadoXDNI(rs.getInt("dniEmpleado"));
                contrato.setDniEmpleado(empleado);
                Inquilino inquilino = inquilinoData.obetenerInquilinoPorID(rs.getInt("idInquilino"));
                contrato.setInquilino(inquilino);
                Inmueble inmueble = inmuebleData.obtenerInmuebleXId(rs.getInt("idInmueble"));
                contrato.setInmueble(inmueble);
                contrato.setActivo(rs.getBoolean("activo"));
                contratos.add(contrato);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ocurrio un error");
        }
        return contratos;
    }

    public List<Contrato> buscarContratosXPropiedad(String codigoPropiedad) {
        ArrayList<Contrato> contratos = new ArrayList<Contrato>();
        Inmueble in = inmuebleData.obtenerInmuebleXCodigoInmueble(codigoPropiedad);
        int idPropiedad = in.getIdInmueble();
        try {
            Contrato contrato;
            String sql = "SELECT * FROM contrato WHERE idInmueble = ? ;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idPropiedad);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                contrato = new Contrato();
                contrato.setIdContrato(rs.getInt("idContrato"));
                contrato.setInicio(rs.getDate("inicio").toLocalDate());
                contrato.setFinalizacion(rs.getDate("finalizacion").toLocalDate());
                contrato.setFirma(rs.getDate("firma").toLocalDate());
                Empleado empleado = empleadoData.obtenerEmpleadoXDNI(rs.getInt("dniEmpleado"));
                contrato.setDniEmpleado(empleado);
                Inquilino inquilino = inquilinoData.obetenerInquilinoPorID(rs.getInt("idInquilino"));
                contrato.setInquilino(inquilino);
                Inmueble inmueble = inmuebleData.obtenerInmuebleXId(rs.getInt("idInmueble"));
                contrato.setInmueble(inmueble);
                contrato.setActivo(rs.getBoolean("activo"));
                contratos.add(contrato);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ocurrio un error");
        }
        return contratos;
    }

    public List<Contrato> buscarContratosXInquilino(long cuilInquilino) {
        ArrayList<Contrato> contratos = new ArrayList<Contrato>();
        Inquilino in = inquilinoData.obetenerInquilinoPorCuil(cuilInquilino);
        int idInquilino = in.getIdInquilino();
        try {
            Contrato contrato;
            String sql = "SELECT * FROM contrato WHERE idInquilino = ? ;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idInquilino);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                contrato = new Contrato();
                contrato.setIdContrato(rs.getInt("idContrato"));
                contrato.setInicio(rs.getDate("inicio").toLocalDate());
                contrato.setFinalizacion(rs.getDate("finalizacion").toLocalDate());
                contrato.setFirma(rs.getDate("firma").toLocalDate());
                Empleado empleado = empleadoData.obtenerEmpleadoXDNI(rs.getInt("dniEmpleado"));
                contrato.setDniEmpleado(empleado);
                Inquilino inquilino = inquilinoData.obetenerInquilinoPorID(rs.getInt("idInquilino"));
                contrato.setInquilino(inquilino);
                Inmueble inmueble = inmuebleData.obtenerInmuebleXId(rs.getInt("idInmueble"));
                contrato.setInmueble(inmueble);
                contrato.setActivo(rs.getBoolean("activo"));
                contratos.add(contrato);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ocurrio un error aca");
        }
        return contratos;
    }

    public List<Contrato> buscarContratosXVendedor(int dniEmpleado) {
        ArrayList<Contrato> contratos = new ArrayList<Contrato>();
        //Empleado em = empleadoData.obtenerEmpleadoXDNI(dniEmpleado);
        //int idEmpleado = em.getIdEmpleado();
        try {
            Contrato contrato;
            String sql = "SELECT * FROM contrato WHERE dniEmpleado = ? ;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dniEmpleado);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                contrato = new Contrato();
                contrato.setIdContrato(rs.getInt("idContrato"));
                contrato.setInicio(rs.getDate("inicio").toLocalDate());
                contrato.setFinalizacion(rs.getDate("finalizacion").toLocalDate());
                contrato.setFirma(rs.getDate("firma").toLocalDate());
                Empleado empleado = empleadoData.obtenerEmpleadoXDNI(rs.getInt("dniEmpleado"));
                contrato.setDniEmpleado(empleado);
                Inquilino inquilino = inquilinoData.obetenerInquilinoPorID(rs.getInt("idInquilino"));
                contrato.setInquilino(inquilino);
                Inmueble inmueble = inmuebleData.obtenerInmuebleXId(rs.getInt("idInmueble"));
                contrato.setInmueble(inmueble);
                contrato.setActivo(rs.getBoolean("activo"));
                contratos.add(contrato);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ocurrio un error");
        }
        return contratos;
    }

    public List<Contrato> buscarContratosVencidos() {
        ArrayList<Contrato> contratos = new ArrayList<Contrato>();
        try {
            Contrato contrato;
            String sql = "SELECT * FROM contrato WHERE finalizacion < ? ;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(LocalDate.now()));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                contrato = new Contrato();
                contrato.setIdContrato(rs.getInt("idContrato"));
                contrato.setInicio(rs.getDate("inicio").toLocalDate());
                contrato.setFinalizacion(rs.getDate("finalizacion").toLocalDate());
                contrato.setFirma(rs.getDate("firma").toLocalDate());
                Empleado empleado = empleadoData.obtenerEmpleadoXDNI(rs.getInt("dniEmpleado"));
                contrato.setDniEmpleado(empleado);
                Inquilino inquilino = inquilinoData.obetenerInquilinoPorID(rs.getInt("idInquilino"));
                contrato.setInquilino(inquilino);
                Inmueble inmueble = inmuebleData.obtenerInmuebleXId(rs.getInt("idInmueble"));
                contrato.setInmueble(inmueble);
                contrato.setActivo(rs.getBoolean("activo"));
                contratos.add(contrato);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ocurrio un error");
        }
        return contratos;
    }

    public boolean cancelarContrato(int idContrato) {
        boolean cancelado = false;
        String sql = "UPDATE contrato SET activo=0 WHERE idContrato = ?;";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idContrato);
            System.out.println(idContrato);
            int rs = ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cancelacion exitosa");
            if (rs == 0) {
                cancelado = true;
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de sintaxis ");
        }
        return cancelado;
    }

}
