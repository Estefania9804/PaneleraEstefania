/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package configuracion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author estefania
 */
public class Conexion {
    String bd="panelera";
    //String url="jdbc:mysql://localhost:3306/";
    String url="localhost:3306/";
    String user="root";
    String password="12345678";
    String driver="com.mysql.cj.jdbc.Driver";
    Connection cx;
    public Conexion(){
    }
    public Connection conectar(){
       try {
            Class.forName(driver);
            cx=DriverManager.getConnection(url + bd, user, password);
            System.out.println("se conecto a la base de datos: " + bd);
            
       } catch (ClassNotFoundException | SQLException ex){
         Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
         System.out.println("No se conecto a la base de datos: " +bd);
       }
       return cx;
    }
    public void desconectar(){
           try{
               cx.close();
               
           } catch (SQLException ex){
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
           }
    }
    public static void main(String[] args){
         Conexion conn=new Conexion();
         conn.conectar();
    }
    public int ejecutarSentanciasql(String sentSQL){
         try{
              PreparedStatement preSt=cx.prepareStatement(sentSQL);
              preSt.execute();
              return 1;
         }  catch (SQLException ex){
             Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
             return 0;
         }
    
    }
    public ResultSet consultarReg(String sentSQL){
        try{
            PreparedStatement preSt=cx.prepareStatement(sentSQL);
            ResultSet res= preSt.executeQuery();
            return res;
        } catch(Exception e){
           System.out.println(e.getMessage());
           return null;
        }
    }

    
}
