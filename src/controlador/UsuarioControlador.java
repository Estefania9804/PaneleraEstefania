/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import configuracion.Conexion;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.UsuarioDTO;

/**
 *
 * @author estefania
 */
public class UsuarioControlador {
    
    public ArrayList<UsuarioDTO> consultarUsuarios() {
        Conexion conn = new Conexion();
        conn.conectar();
        ResultSet resul = null;
        ArrayList<UsuarioDTO> usuarios = new ArrayList<>();
        
        try {            
            resul = conn.consultarReg("SELECT * FROM usuario");
            while (resul.next()) {
                UsuarioDTO usuarioDTO = new UsuarioDTO();
                                
                usuarioDTO.setId(resul.getInt ("id"));
                usuarioDTO.setNombres(resul.getString ("nombres"));
                usuarioDTO.setApellidos(resul.getString ("apellidos"));
                usuarioDTO.setTipoDocumento(resul.getString ("tipoDocumento"));
                usuarioDTO.setDocumento(resul.getString ("documento"));
                usuarioDTO.setFechaNacimiento(resul.getDate("fechaNacimiento"));
                usuarioDTO.setCorreo(resul.getString ("correo"));
                usuarioDTO.setCelular(resul.getString ("celular"));
                usuarioDTO.setPais(resul.getString ("pais"));
                usuarioDTO.setCiudad(resul.getString ("ciudad"));
		usuarioDTO.setDireccion(resul.getString ("direccion"));
                usuarioDTO.setRol(resul.getString ("rol"));
		usuarioDTO.setCargo(resul.getString ("cargo"));

                usuarios.add(usuarioDTO);              
            } 
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            conn.desconectar();
        }
        return usuarios;
    }
    
    public boolean crearUsuario(UsuarioDTO usuarioDTO){
        
        boolean flag = false;
        Conexion conn = new Conexion();
        conn.conectar();
        int res = conn.ejecutarSentanciasql("INSERT INTO 'usuario' ('nombres','apellidos','tipoDocumento','documento','fechaNacimiento','correo','celular','pais','ciudad','dirección','rol','cargo','usuario','contraseña') VALUES ('"+usuarioDTO.getNombres()+"','"+usuarioDTO.getApellidos()+"','"+usuarioDTO.getTipoDocumento()+"','"+usuarioDTO.getDocumento()+"','"+usuarioDTO.getFechaNacimiento()+"','"+usuarioDTO.getCorreo()+"','"+usuarioDTO.getCelular()+"','"+usuarioDTO.getPais()+"','"+usuarioDTO.getCiudad()+"','"+usuarioDTO.getDireccion()+"','"+usuarioDTO.getRol()+"','"+usuarioDTO.getCargo()+"','"+usuarioDTO.getUsuario()+"','"+usuarioDTO.getContraseña()+"');");
        
        if (res==1){
            System.out.println("Usuario creado con exito");
            flag = true;
        }
        return flag;
       
    }
    
    
    
}