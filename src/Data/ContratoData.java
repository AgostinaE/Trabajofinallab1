
package Data;

import java.sql.Connection;

/**
 *
 * @author POSITIVO BGH
 */
public class ContratoData {
    //Paso 1 crear un atributo coneccion 
   private Conexion con = null;
   
   //paso 2 creo un constructor y le paso el objeto connection e imboco al metodo getConection

    public ContratoData(Conexion conexion) {
        con = (Conexion) conexion.getConexion();
    }
   
    
   

 
}
