/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import configuracion.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64.Encoder;
import modelo.UsuarioDTO;

/**
 *
 * @author estefania
 * 
 * 
 */
public class UsuarioControlador {  
    
    public boolean validarUsuario(String usuario, String contraseña) {
        //Encoder encoder = new Encoder();
        Conexion conn = new Conexion();
        conn.conectar();

        boolean flag = false;

        try {

            ResultSet result = conn.consultarReg("SELECT usuario, contraseña FROM usuario WHERE rol IN ('admin','Empleado','Funcionario')");

            while (result.next()) {
                System.out.println(result.getString("usuario"));
                System.out.println(result.getString("contraseña"));

                if (usuario.equals(result.getString("usuario")) && contraseña.equals(result.getString("contraseña")))
                {
                    flag = true;
                }
            }
        } catch(Exception e) {
                   System.out.println(e);
                   }finally{
                           conn.desconectar();
                           }
            return flag;
    }

    
             
        
    
    public boolean crearUsuarioNew(UsuarioDTO usuarioDTO) {
        boolean flag = false;
        Conexion conn = new Conexion();
        conn.conectar();
        
       
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String fechaNacimientoStr = dateFormat.format(usuarioDTO.getFechaNacimiento());
        
    
        int res = conn.ejecutarSentanciasql("INSERT INTO panelera.usuario (nombres, apellidos, tipoDocumento, documento, "
                + "fechaNacimiento, correo, celular, pais, ciudad, direccion, rol, "
                + "cargo) VALUES "
                //+ "cargo, usuario, contraseña) VALUES "
                + "('" +  usuarioDTO.getNombres() 
                + "', '" + usuarioDTO.getApellidos() 
                + "', '" + usuarioDTO.getTipoDocumento() 
                + "', '" + usuarioDTO.getDocumento()
                + "', '" + fechaNacimientoStr
                + "', '" + usuarioDTO.getCorreo()
                + "', '" + usuarioDTO.getCelular()
                + "', '" + usuarioDTO.getPais()
                + "', '" + usuarioDTO.getCiudad()
		+ "', '" + usuarioDTO.getDireccion()
		+ "', '" + usuarioDTO.getRol()
		+ "', '" + usuarioDTO.getCargo()
//		+ "', " + usuarioDTO.getUsuario()
//		+ "', " + usuarioDTO.getContraseña()
                + "');");
        if (res == 1) {
            System.out.println("Usuario creado con exito");
            flag = true;
        }
        return flag;
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
    
    /**
     * Metodo para eliminar un Usuario.
     * @param id Identificador del Usuario.
     * @return Valor de tipo boolean.
     */
    public boolean eliminarUsuario(int id) {
        boolean flag = false;
        Conexion conn = new Conexion();
        conn.conectar();
        int res = conn.ejecutarSentanciasql("DELETE FROM panelera.usuario WHERE id = " + id + ";");
        if (res == 1) {
            System.out.println("Usuario eliminado con exito");
            flag = true;
        }
        return flag;
    }
    
    /**
     * Metodo para actualizar un usuario.
     * @param usuarioDTO entidad de tipo usuarioDTO.
     * @return boolean.
     */
    public boolean editarUsuario(UsuarioDTO usuarioDTO) {
        boolean flag = false;
        Conexion conn = new Conexion();
        conn.conectar();
        
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String fechaNacimientoStr = dateFormat.format(usuarioDTO.getFechaNacimiento());
    
        int res = conn.ejecutarSentanciasql("UPDATE panelera.usuario SET "
                + "  nombres = '" + usuarioDTO.getNombres() 
                + "', apellidos = '" + usuarioDTO.getApellidos()
                + "', tipoDocumento = '" + usuarioDTO.getTipoDocumento() 
                + "', documento = '" + usuarioDTO.getDocumento()
                + "', fechaNacimiento = '" + fechaNacimientoStr
                + "', correo = '" + usuarioDTO.getCorreo()
                + "', celular = '" + usuarioDTO.getCelular()
                + "', pais = '" + usuarioDTO.getPais()
                + "', ciudad = '" + usuarioDTO.getCiudad()
		+ "', direccion = '" + usuarioDTO.getDireccion() 
		+ "', rol = '" + usuarioDTO.getRol() 
		+ "', cargo = '" + usuarioDTO.getCargo() 
		//+ "', usuario = '" + usuarioDTO.getUsuario()
		//+ "', contraseña = '" + usuarioDTO.getContraseña()            
                + "' WHERE id = " + usuarioDTO.getId() + ";");
        if (res == 1) {
            System.out.println("Usuario actualizado con exito");
            flag = true;
        }
        return flag;
    }
    
    /**
     * Metodo para consultar el usuario de la base de datos.
     * @param id Identificador del Usuario.
     * @return instancia de tipo UsuarioDTO.
     * @throws SQLException.
     */ 
    public UsuarioDTO consultarUsuarioId(int id) throws SQLException {
        ResultSet resul;
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        Conexion conn = new Conexion();
        conn.conectar();

        try {
            resul = conn.consultarReg("SELECT * FROM panelera.usuario WHERE id = " + id + ";");
            while (resul.next()) {
                usuarioDTO.setId(resul.getInt("id"));
                usuarioDTO.setNombres(resul.getString("nombres"));
                usuarioDTO.setApellidos(resul.getString("apellidos"));
                usuarioDTO.setTipoDocumento(resul.getString("tipoDocumento"));
                usuarioDTO.setDocumento(resul.getString("documento"));
                usuarioDTO.setFechaNacimiento(resul.getDate("fechaNacimiento"));
                usuarioDTO.setCorreo(resul.getString("correo"));
                usuarioDTO.setCelular(resul.getString("celular"));
                usuarioDTO.setPais(resul.getString("pais"));
                usuarioDTO.setCiudad(resul.getString("ciudad"));
                usuarioDTO.setDireccion(resul.getString("direccion"));
                usuarioDTO.setRol(resul.getString("rol"));
                usuarioDTO.setCargo(resul.getString("cargo"));
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            conn.desconectar();
        }
        return usuarioDTO;
    }
    
    /**
     * Metodo para consultar el usuario de la base de datos a partir del usuario y contraseña.
     * @param usuario Usuario.
     * @param contraseña Contrasena
     * @return instancia de tipo UsuarioDTO.
     * @throws SQLException.
     */ 
    public UsuarioDTO consultarPorUsuarioYContrasena(String usuario, String contraseña) throws SQLException {
        ResultSet resul;
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        Conexion conn = new Conexion();
        conn.conectar();

        try {
            resul = conn.consultarReg("SELECT * FROM panelera.usuario WHERE usuario = '" + usuario + "' AND contraseña = '" + contraseña + "';");
            while (resul.next()) {
                usuarioDTO.setId(resul.getInt("id"));
                usuarioDTO.setNombres(resul.getString("nombres"));
                usuarioDTO.setApellidos(resul.getString("apellidos"));
                usuarioDTO.setTipoDocumento(resul.getString("tipoDocumento"));
                usuarioDTO.setDocumento(resul.getString("documento"));
                usuarioDTO.setFechaNacimiento(resul.getDate("fechaNacimiento"));
                usuarioDTO.setCorreo(resul.getString("correo"));
                usuarioDTO.setCelular(resul.getString("celular"));
                usuarioDTO.setPais(resul.getString("pais"));
                usuarioDTO.setCiudad(resul.getString("ciudad"));
                usuarioDTO.setDireccion(resul.getString("direccion"));
                usuarioDTO.setRol(resul.getString("rol"));
                usuarioDTO.setCargo(resul.getString("cargo"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            conn.desconectar();
        }
        return usuarioDTO;
    }
     
    /**
     * Metodo para consultar los usuarios.
     * @return Lista de usuarios que estan en la base de datos.
     */     
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
    
    /**
     * Metodo para consultar los usuarios de determinado rol.
     * @param rolUsuario String indicado el rol a filtrar.
     * @return Lista de usuarios que estan en la base de datos.
     */
    public ArrayList<UsuarioDTO> consultarUsuariosPorRol(String rolUsuario) {
        Conexion conn = new Conexion();
        conn.conectar();
        ResultSet resul = null;
        ArrayList<UsuarioDTO> usuarios = new ArrayList<>();
        
        try {            
            resul = conn.consultarReg("SELECT * FROM panelera.usuario WHERE rol = '" + rolUsuario + "';");
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
    
    
    
     

    
    
    
}
