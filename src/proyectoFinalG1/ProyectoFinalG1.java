/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoFinalG1;

import java.time.LocalDate;
import proyectoFinalG1.Data.Conexion;
import proyectoFinalG1.Data.ContratoData;
import proyectoFinalG1.Data.EmpleadoData;
import proyectoFinalG1.Data.InmuebleData;
import proyectoFinalG1.Data.InquilinoData;
import proyectoFinalG1.Data.PropietarioData;
import proyectoFinalG1.Modelos.Contrato;
import proyectoFinalG1.Modelos.Empleado;
import proyectoFinalG1.Modelos.Inmueble;
import proyectoFinalG1.Modelos.Inquilino;
import proyectoFinalG1.Modelos.Propietario;

/**
 *
 * @author POSITIVO BGH
 */
public class ProyectoFinalG1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       Conexion conexion=new Conexion(); 
       
       Empleado e = new Empleado("Carmen", "Paz", 123456, true);
       EmpleadoData ed = new EmpleadoData(conexion);
       ed.agregarEmpleado(e);
       
       Inquilino i = new Inquilino("Lord", "Longbow", 20123456, "Programmer", "Yisus", 002, true);
       InquilinoData id = new InquilinoData(conexion);
       id.agregarInquilino(i);
       
       Propietario p = new Propietario("Al", "Pachino", 8975492, 1164578564, "pastorutti 23", true);
       PropietarioData pd = new PropietarioData(conexion);
       pd.agregarPropietario(p);
       
       Inmueble in = new Inmueble("2 habitaciones, 1 baño", "amsterdam 88", 15500.99, (float) 20.7, "departamento", 1, p, "asfd243", true);
       InmuebleData ind = new InmuebleData(conexion);
       ind.agregarInmueble(in);
       
       Contrato c = new Contrato(LocalDate.of(2022, 3, 4), LocalDate.of(2025, 11, 7), LocalDate.now(), e, i, in, true);
       ContratoData cd = new ContratoData(conexion);
       cd.crearContrato(c); 
       cd.cancelarContrato(c.getIdContrato());
        System.out.println("Paso");
    }
    
}
