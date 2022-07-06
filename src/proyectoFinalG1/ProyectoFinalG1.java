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
        
       Empleado e = new Empleado("Carlitos", "Perez", 45568978, true);
       EmpleadoData ed = new EmpleadoData(conexion);
       ed.agregarEmpleado(e);
       
       Inquilino i = new Inquilino("ElMas", "Capo", 2045475892, "Camionero", "DiosPaga", 001, true);
       InquilinoData id = new InquilinoData(conexion);
       id.agregarInquilino(i);
       
       Propietario p = new Propietario("PromocionAl", "Grupo", 45475892, 1161821564, "Carlotta 33", true);
       PropietarioData pd = new PropietarioData(conexion);
       pd.agregarPropietario(p);
       
       Inmueble in = new Inmueble("4 habitaciones, 1 baño y balcon", "amsterdam 33", 15200.99, (float) 23.7, "departamento", 1, p, "obd34x", true);
       InmuebleData ind = new InmuebleData(conexion);
       ind.agregarInmueble(in);
       
       Contrato c = new Contrato(LocalDate.of(2022, 2, 6), LocalDate.of(2025, 10, 15), LocalDate.now(), e, i, in, true);
       ContratoData cd = new ContratoData(conexion);
       cd.crearContrato(c);
       
    }
    
}
