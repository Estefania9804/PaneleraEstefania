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
import modelo.PedidoDTO;

/**
 *
 * @author estefania
 */
public class PedidoControlador {

    /**
     * Metodo para crear un Pedido.
     * @param pedidoDTO Instancia de tipo pedidoDTO.
     * @return Dato de tipo boolean.
     */
    public boolean crearPedido(PedidoDTO pedidoDTO) {
        boolean flag = false;
        Conexion conn = new Conexion();
        conn.conectar();
        
        // Utiliza SimpleDateFormat para formatear las fechas en un formato aceptable para MySQL
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String fechaEnvioStr = dateFormat.format(pedidoDTO.getFechaEnvio());
        String fechaEstimadaEntregaStr = dateFormat.format(pedidoDTO.getFechaEstimadaEntrega());

    
        int res = conn.ejecutarSentanciasql("INSERT INTO panelera.pedidos (cantidad, presentacion, tipoEnvio, ciudadOrigen, "
                + "ciudadDestino, tipoPago, fechaEnvio, fechaEstimadaEntrega, usuarioID) VALUES "
                + "(" +  pedidoDTO.getCantidad() 
                + ", '" + pedidoDTO.getPresentacion() 
                + "', '" + pedidoDTO.getTipoEnvio() 
                + "', '" + pedidoDTO.getCiudadOrigen()
                + "', '" + pedidoDTO.getCiudadDestino()
                + "', '" + pedidoDTO.getTipoPago()
                + "', '" + fechaEnvioStr
                + "', '" + fechaEstimadaEntregaStr
                + "', " + pedidoDTO.getUsuarioID()
                + ");");
        if (res == 1) {
            System.out.println("Actualizado con exito");
            flag = true;
        }
        return flag;
    }

    /**
     * Metodo utilizado para eliminar un pedido.
     * @param id Identificador del Pedido.
     * @return Dato de tipo boolean.
     */
    public boolean eliminarPedido(int id) {
        boolean flag = false;
        Conexion conn = new Conexion();
        conn.conectar();
        int res = conn.ejecutarSentanciasql("DELETE FROM panelera.pedidos WHERE id = " + id + ";");
        if (res == 1) {
            System.out.println("Borrado con exito");
            flag = true;
        }
        return flag;
    }
    
    /**
     * Metodo para editar un Pedido.
     * @param pedidoDTO Instancia de tipo pedidoDTO.
     * @return Dato de tipo boolean.
     */
    public boolean editarPedido(PedidoDTO pedidoDTO) {
        boolean flag = false;
        Conexion conn = new Conexion();
        conn.conectar();
        
        // Utiliza SimpleDateFormat para formatear las fechas en un formato aceptable para MySQL
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String fechaEnvioStr = dateFormat.format(pedidoDTO.getFechaEnvio());
        String fechaEstimadaEntregaStr = dateFormat.format(pedidoDTO.getFechaEstimadaEntrega());

    
        int res = conn.ejecutarSentanciasql("UPDATE panelera.pedidos SET "
                + "  cantidad = " + pedidoDTO.getCantidad() 
                + ", presentacion = '" + pedidoDTO.getPresentacion() 
                + "', tipoEnvio = '" + pedidoDTO.getTipoEnvio() 
                + "', ciudadOrigen = '" + pedidoDTO.getCiudadOrigen()
                + "', ciudadDestino = '" + pedidoDTO.getCiudadDestino()
                + "', tipoPago = '" + pedidoDTO.getTipoPago()
                + "', fechaEnvio = '" + fechaEnvioStr
                + "', fechaEstimadaEntrega = '" + fechaEstimadaEntregaStr
                + "', usuarioID = " + pedidoDTO.getUsuarioID()                
                + " WHERE id = " + pedidoDTO.getId() + ";");
        if (res == 1) {
            System.out.println("Actualizado con exito");
            flag = true;
        }
        return flag;
    }
    
    public PedidoDTO consultarPedidoId(int id) throws SQLException {
        ResultSet resul;
        PedidoDTO pedidoDTO = new PedidoDTO();
        Conexion conn = new Conexion();
        conn.conectar();
        
        try {            
            resul = conn.consultarReg("SELECT * FROM panelera.pedidos WHERE id = " + id + ";");
            while (resul.next()) {
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
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            conn.desconectar();
        }
        return pedidoDTO;
    }
    
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
