/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import configuracion.Conexion;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.FuncionariosDTO;

/**
 *
 * @author estefania
 */
public class FuncionariosControlador {
    
    public ArrayList<FuncionariosDTO> consultarFuncionarios() {
        Conexion conn = new Conexion();
        conn.conectar();
        ResultSet resul = null;
        ArrayList<FuncionariosDTO> funcionario = new ArrayList<>();
        
        try {            
            resul = conn.consultarReg("SELECT * FROM funcionarios");
            while (resul.next()) {
                FuncionariosDTO funcionariosDTO = new FuncionariosDTO();
                                
                funcionariosDTO.setID(resul.getInt ("ID"));
                funcionariosDTO.setSuperUsuarioID(resul.getInt ("superUsuarioID"));
                funcionariosDTO.setCargo(resul.getString ("cargo"));             

               
                funcionario.add(funcionariosDTO);               
               
            } 
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            conn.desconectar();
        }
        return funcionario;
    
    }
    
}
