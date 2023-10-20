/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import configuracion.Conexion;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.EmpleadosDTO;

/**
 *
 * @author estefania
 */
public class EmpleadosControlador {
    
    public ArrayList<EmpleadosDTO> consultarEmpleados() {
        Conexion conn = new Conexion();
        conn.conectar();
        ResultSet resul = null;
        ArrayList<EmpleadosDTO> empleado = new ArrayList<>();
        
        try {            
            resul = conn.consultarReg("SELECT * FROM empleados");
            while (resul.next()) {
                EmpleadosDTO empleadosDTO = new EmpleadosDTO();
                                
                empleadosDTO.setID(resul.getInt ("ID"));
                empleadosDTO.setSuperUsuarioID(resul.getInt ("superUsuarioID"));
                empleadosDTO.setDireccion(resul.getString ("direccion"));
                empleadosDTO.setCargo(resul.getString ("cargo"));             

               
                empleado.add(empleadosDTO);               
               
            } 
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            conn.desconectar();
        }
        return empleado;
    
    }
    
}
