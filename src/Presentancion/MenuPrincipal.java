/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Presentancion;

import Presentancion.Articulo.MenuArticulo;
import Presentancion.Empleado.MenuEmpleado;
import Presentancion.Ingresa.MenuIngresa;
import Presentancion.Proveedor.MenuProveedor;
import Presentancion.Venta.MenuLineaVenta;
import Presentancion.Venta.MenuVenta;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;


public class MenuPrincipal extends javax.swing.JFrame {

    //---------------------------LISTA------------------------------------------
    MenuArticulo menuArticulo = new MenuArticulo();
    MenuVenta menuVenta = new MenuVenta();
    MenuProveedor menuProveedor = new MenuProveedor();
    MenuIngresa menuIngresa = new MenuIngresa();
    MenuEmpleado menuEmpleado = new MenuEmpleado();

    public MenuPrincipal() {
        initComponents();
        menuArticulo.setLocation(0, 0);
        jPanelContenido.setLayout(new BorderLayout()); // Asegúrate de tener BorderLayout.
        jPanelContenido.removeAll();
        jPanelContenido.add(menuArticulo, BorderLayout.CENTER);
        jPanelContenido.revalidate();
        jPanelContenido.repaint();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelMenu = new javax.swing.JPanel();
        btnVenta = new javax.swing.JButton();
        btnIngresa = new javax.swing.JButton();
        btnArticulo = new javax.swing.JButton();
        btnFabricante = new javax.swing.JButton();
        btnEmpleado = new javax.swing.JButton();
        btnProveedor = new javax.swing.JButton();
        jPanelContenido = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelMenu.setBackground(new java.awt.Color(0, 255, 204));
        jPanelMenu.setMaximumSize(getPreferredSize());

        btnVenta.setText("Ventas");
        btnVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentaActionPerformed(evt);
            }
        });

        btnIngresa.setText("Compras Mercaderia");
        btnIngresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresaActionPerformed(evt);
            }
        });

        btnArticulo.setText("Articulos");
        btnArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArticuloActionPerformed(evt);
            }
        });

        btnFabricante.setText("Fabricantes");

        btnEmpleado.setText("Empleado");
        btnEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmpleadoActionPerformed(evt);
            }
        });

        btnProveedor.setText("Proveedores");
        btnProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProveedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelMenuLayout = new javax.swing.GroupLayout(jPanelMenu);
        jPanelMenu.setLayout(jPanelMenuLayout);
        jPanelMenuLayout.setHorizontalGroup(
            jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnFabricante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnArticulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnIngresa, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelMenuLayout.setVerticalGroup(
            jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMenuLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(btnIngresa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnVenta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEmpleado)
                .addGap(12, 12, 12)
                .addComponent(btnProveedor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnArticulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnFabricante)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelContenido.setMaximumSize(getPreferredSize());

        javax.swing.GroupLayout jPanelContenidoLayout = new javax.swing.GroupLayout(jPanelContenido);
        jPanelContenido.setLayout(jPanelContenidoLayout);
        jPanelContenidoLayout.setHorizontalGroup(
            jPanelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 661, Short.MAX_VALUE)
        );
        jPanelContenidoLayout.setVerticalGroup(
            jPanelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 431, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelContenido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelContenido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpleadoActionPerformed
        menuEmpleado.setLocation(0, 0);
        jPanelContenido.setLayout(new BorderLayout()); // Asegúrate de tener BorderLayout.
        jPanelContenido.removeAll();
        jPanelContenido.add(menuEmpleado, BorderLayout.CENTER);
        jPanelContenido.revalidate();
        jPanelContenido.repaint();
    }//GEN-LAST:event_btnEmpleadoActionPerformed

    private void btnArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArticuloActionPerformed
        menuArticulo.setLocation(0, 0);
        jPanelContenido.setLayout(new BorderLayout()); // Asegúrate de tener BorderLayout.
        jPanelContenido.removeAll();
        jPanelContenido.add(menuArticulo, BorderLayout.CENTER);
        jPanelContenido.revalidate();
        jPanelContenido.repaint();
    }//GEN-LAST:event_btnArticuloActionPerformed

    private void btnIngresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresaActionPerformed
        menuIngresa.setLocation(0, 0);
        jPanelContenido.setLayout(new BorderLayout()); // Asegúrate de tener BorderLayout.
        jPanelContenido.removeAll();
        jPanelContenido.add(menuIngresa, BorderLayout.CENTER);
        jPanelContenido.revalidate();
        jPanelContenido.repaint();
    }//GEN-LAST:event_btnIngresaActionPerformed

    private void btnVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentaActionPerformed
        menuVenta.setLocation(0, 0);
        jPanelContenido.setLayout(new BorderLayout()); // Asegúrate de tener BorderLayout.
        jPanelContenido.removeAll();
        jPanelContenido.add(menuVenta, BorderLayout.CENTER);
        jPanelContenido.revalidate();
        jPanelContenido.repaint();
    }//GEN-LAST:event_btnVentaActionPerformed

    private void btnProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProveedorActionPerformed
        menuProveedor.setLocation(0, 0);
        jPanelContenido.setLayout(new BorderLayout()); // Asegúrate de tener BorderLayout.
        jPanelContenido.removeAll();
        jPanelContenido.add(menuProveedor, BorderLayout.CENTER);
        jPanelContenido.revalidate();
        jPanelContenido.repaint();
    }//GEN-LAST:event_btnProveedorActionPerformed

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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnArticulo;
    private javax.swing.JButton btnEmpleado;
    private javax.swing.JButton btnFabricante;
    private javax.swing.JButton btnIngresa;
    private javax.swing.JButton btnProveedor;
    private javax.swing.JButton btnVenta;
    private javax.swing.JPanel jPanelContenido;
    private javax.swing.JPanel jPanelMenu;
    // End of variables declaration//GEN-END:variables
}
