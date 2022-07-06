/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoFinalG1.Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author POSITIVO BGH
 */
    public class Conexion {
//Atributos drivers, usuarios y contraseña
    private String url = "jdbc:mysql://localhost/inmobiliariag1";
    private String usuario = "root";
    private String password = "";
// atributo de tipo Conection
    private Connection conexion;
//Constructor con el for name de la direccion de la clase
    public Conexion() {
        try {

            Class.forName("org.mariadb.jdbc.Driver");

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar drivers de conexion");
        }

//Class.forName("direccion de la calse")
//new Paquete. subpaquete. nombre de la clase
    }
//metodo getConection 
    public Connection getConexion() {

        try {
            if (conexion == null) {
                // Setup the connection with the DB
                conexion = DriverManager
                        .getConnection(url + "?useLegacyDatetimeCode=false&serverTimezone=UTC"
                                + "&user=" + usuario + "&password=" + password);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse a la Base de Datos");
        }

        return conexion;
    }
}