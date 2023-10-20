/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import configuracion.Conexion;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.PedidoDTO;

/**
 *
 * @author estefania
 */
public class PedidoControlador {
    
    public ArrayList<PedidoDTO> consultarPedidos() {
        Conexion conn = new Conexion();
        conn.conectar();
        ResultSet resul = null;
        ArrayList<PedidoDTO> pedidos = new ArrayList<>();
        
        try {            
            resul = conn.consultarReg("SELECT * FROM pedidos");
            while (resul.next()) {
                PedidoDTO pedidoDTO = new PedidoDTO();
                System.out.println(resul.getString ("presentacion") + " - " + resul.getString ("tipoEnvio"));

                
                pedidoDTO.setId(resul.getInt ("ID"));
                pedidoDTO.setCantidad(resul.getInt ("cantidad"));
                pedidoDTO.setPresentacion(resul.getString ("presentacion"));
                pedidoDTO.setTipoEnvio(resul.getString ("tipoEnvio"));
                pedidoDTO.setCiudadOrigen(resul.getString ("ciudadOrigen"));
                pedidoDTO.setCiudadDestino(resul.getString ("ciudadDestino"));
                pedidoDTO.setTipoPago(resul.getString ("tipoPago"));
                pedidoDTO.setFechaEnvio(resul.getDate("fechaEnvio"));
                pedidoDTO.setFechaEstimadaEntrega(resul.getDate("fechaEstimadaEntrega"));
                pedidoDTO.setUsuarioID(resul.getInt ("usuarioID"));
                
                

               
                pedidos.add(pedidoDTO);               
               
            } 
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            conn.desconectar();
        }
        return pedidos;
    }
}
