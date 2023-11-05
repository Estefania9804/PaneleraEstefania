/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import controlador.UsuarioControlador;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.UsuarioDTO;

/**
 *
 * @author estefania
 */
public class AdministarUsuarioVista extends javax.swing.JFrame {
    
    DefaultTableModel modelo;

    /**
     * Creates new form AdministarUsuarioVista
     */
    public AdministarUsuarioVista() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        UsuarioControlador usuarioControlador = new UsuarioControlador();
        ArrayList<UsuarioDTO> usuarioDTOs = usuarioControlador.consultarUsuarios();
        System.out.println("ESTEFANIA : " + usuarioDTOs);
        
    
         String[] titulos_tabla = {
            "ID", "Nombres", "Apellidos", "Tipo de documento", "Documento", "Fecha de nacimiento", "Correo", "Celular", "Pais","Ciudad","Dirección","Rol","Cargo"};

        modelo = new DefaultTableModel(null, titulos_tabla);
        tUsuarios.setModel(modelo);
        
        buscarYcolocarUsuariosEnTabla();       
    }
    
    
     private void buscarYcolocarUsuariosEnTabla() {
       
        UsuarioControlador usuarioControlador = new UsuarioControlador();
        
        ArrayList<UsuarioDTO> usuarioDTOs = usuarioControlador.consultarUsuarios();
        
        for (UsuarioDTO usuarioDTO : usuarioDTOs) {
            Object[] oUsuario = {
                usuarioDTO.getId(), 
                usuarioDTO.getNombres(), 
                usuarioDTO.getApellidos(), 
                usuarioDTO.getTipoDocumento(), 
                usuarioDTO.getDocumento(), 
                usuarioDTO.getFechaNacimiento(),
                usuarioDTO.getCorreo(),
                usuarioDTO.getCelular(),
                usuarioDTO.getPais(),
       		usuarioDTO.getCiudad(),
		usuarioDTO.getDireccion(),
		usuarioDTO.getRol(),
		usuarioDTO.getCargo()
            };
            modelo.addRow(oUsuario);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tUsuarios = new javax.swing.JTable();
        btnCrearUsuario = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnEditarUsuario = new javax.swing.JButton();
        btnMenu = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombres", "Apellidos", "Tipo documento", "Documento", "Fecha nacimiento", "Correo", "Celular", "País", "Ciudad", "Dirección", "Rol", "Cargo"
            }
        ));
        jScrollPane1.setViewportView(tUsuarios);

        btnCrearUsuario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCrearUsuario.setText("Crear usuario");
        btnCrearUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearUsuarioActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEliminar.setText("Eliminar usuario");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnEditarUsuario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEditarUsuario.setText("Editar usuario");
        btnEditarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarUsuarioActionPerformed(evt);
            }
        });

        btnMenu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnMenu.setText("Menú principal");
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("EXPORTACIONES ESTEFANIA");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 655, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(256, 256, 256)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(btnCrearUsuario)
                .addGap(18, 18, 18)
                .addComponent(btnEliminar)
                .addGap(18, 18, 18)
                .addComponent(btnEditarUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnMenu)
                .addGap(43, 43, 43))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar)
                    .addComponent(btnEditarUsuario)
                    .addComponent(btnMenu)
                    .addComponent(btnCrearUsuario))
                .addGap(68, 68, 68))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void btnCrearUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearUsuarioActionPerformed
        CrearUsuarioVista crearUsuarioVista = new CrearUsuarioVista();
        crearUsuarioVista.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_btnCrearUsuarioActionPerformed

    private void btnEditarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarUsuarioActionPerformed
        if (tUsuarios.getSelectedRowCount() > 0) {
            EditarUsuarioVista editarUsuarioVista;
            try{
                editarUsuarioVista = new EditarUsuarioVista();
                int id = Integer.parseInt(tUsuarios.getValueAt(tUsuarios.getSelectedRow(),0).toString());
                editarUsuarioVista.setIdUsuario(id);
                editarUsuarioVista.setVisible(true);
            } catch (SQLException ex){
                Logger.getLogger(AdministarUsuarioVista.class.getName()).log(Level.SEVERE,null, ex);
            }

            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null,"Debe seleccionar un usuario de la tabla");
        }
    
    }//GEN-LAST:event_btnEditarUsuarioActionPerformed

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        new PrincipalVista().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMenuActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
         UsuarioControlador usuarioControlador = new UsuarioControlador();
         boolean flag = usuarioControlador.eliminarUsuario(Integer.parseInt(tUsuarios.getValueAt(tUsuarios.getSelectedRow(), 0).toString()));
         if (flag) {
            System.out.println("Borrado con exito");
            JOptionPane.showMessageDialog(null, "Usuario borrado con exito");
            int count = modelo.getRowCount();
            for (int i = 0; i< count; i++) {
                modelo.removeRow(0);
            }
            
            buscarYcolocarUsuariosEnTabla();
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdministarUsuarioVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdministarUsuarioVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdministarUsuarioVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdministarUsuarioVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdministarUsuarioVista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearUsuario;
    private javax.swing.JButton btnEditarUsuario;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tUsuarios;
    // End of variables declaration//GEN-END:variables
}
