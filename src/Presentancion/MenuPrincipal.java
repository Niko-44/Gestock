/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Presentancion;

import Presentancion.Articulo.MenuArticulo;
import Presentancion.Articulo.MenuFabricante;
import Presentancion.Empleado.MenuEmpleado;
import Presentancion.Ingresa.MenuIngresa;
import Presentancion.Proveedor.MenuProveedor;
import Presentancion.Venta.MenuLineaVenta;
import Presentancion.Venta.MenuVenta;
import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.ImageIcon;

import logica.Clases.RoundedPanel;

public class MenuPrincipal extends javax.swing.JFrame {

    //---------------------------LISTA------------------------------------------
    MenuArticulo menuArticulo = new MenuArticulo();
    MenuVenta menuVenta = new MenuVenta();
    MenuProveedor menuProveedor = new MenuProveedor();
    MenuIngresa menuIngresa = new MenuIngresa();
    MenuEmpleado menuEmpleado = new MenuEmpleado();
    MenuFabricante menuFabricante = new MenuFabricante();

    //VARIABLES
    Color selectedColor = new Color(156, 40, 177);
    Color unSelectedColor = new Color(85, 51, 91);

    public MenuPrincipal() {
        initComponents();
        setTitle("Venta");
        ImageIcon icon = new ImageIcon(getClass().getResource("/Icon/icono.png"));
        setIconImage(icon.getImage());

        btnPanelVenta.setBackground(selectedColor);
        btnPanelProveedor.setBackground(unSelectedColor);
        btnPanelEmpleado.setBackground(unSelectedColor);
        btnPanelIngresa.setBackground(unSelectedColor);
        btnPanelArticulo.setBackground(unSelectedColor);
        btnPanelSalir.setBackground(unSelectedColor);

        menuVenta.setLocation(0, 0);
        jPanelContenido.setLayout(new BorderLayout()); // Asegúrate de tener BorderLayout.
        jPanelContenido.removeAll();
        jPanelContenido.add(menuVenta, BorderLayout.CENTER);
        jPanelContenido.revalidate();
        jPanelContenido.repaint();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanelMenu = new javax.swing.JPanel();
        JPanelButtons = new javax.swing.JPanel();
        btnPanelVenta = new RoundedPanel(20);
        btnVenta = new javax.swing.JButton();
        btnPanelArticulo = new RoundedPanel(20);
        btnArticulo = new javax.swing.JButton();
        btnPanelEmpleado = new RoundedPanel(20);
        btnEmpleado = new javax.swing.JButton();
        btnPanelProveedor = new RoundedPanel(20);
        btnProveedor = new javax.swing.JButton();
        btnPanelIngresa = new RoundedPanel(20);
        btnIngresa = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnPanelSalir = new RoundedPanel(20);
        btnSalir = new javax.swing.JButton();
        jPanelContenido = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(0, 0));
        setMinimumSize(new java.awt.Dimension(1000, 740));
        setResizable(false);

        jPanelMenu.setBackground(new java.awt.Color(36, 37, 39));
        jPanelMenu.setMaximumSize(getPreferredSize());
        jPanelMenu.setName(""); // NOI18N

        JPanelButtons.setBackground(new java.awt.Color(36, 37, 39));
        JPanelButtons.setForeground(new java.awt.Color(36, 37, 39));
        JPanelButtons.setLayout(new java.awt.GridBagLayout());

        btnPanelVenta.setBackground(new java.awt.Color(156, 40, 177));

        btnVenta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnVenta.setForeground(new java.awt.Color(255, 255, 255));
        btnVenta.setText("Ventas");
        btnVenta.setContentAreaFilled(false);
        btnVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout btnPanelVentaLayout = new javax.swing.GroupLayout(btnPanelVenta);
        btnPanelVenta.setLayout(btnPanelVentaLayout);
        btnPanelVentaLayout.setHorizontalGroup(
            btnPanelVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnPanelVentaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnPanelVentaLayout.setVerticalGroup(
            btnPanelVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnVenta)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(18, 0, 1, 0);
        JPanelButtons.add(btnPanelVenta, gridBagConstraints);

        btnPanelArticulo.setBackground(new java.awt.Color(156, 40, 177));
        btnPanelArticulo.setLayout(new java.awt.BorderLayout());

        btnArticulo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnArticulo.setForeground(new java.awt.Color(255, 255, 255));
        btnArticulo.setText("Articulos");
        btnArticulo.setContentAreaFilled(false);
        btnArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArticuloActionPerformed(evt);
            }
        });
        btnPanelArticulo.add(btnArticulo, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(18, 0, 1, 0);
        JPanelButtons.add(btnPanelArticulo, gridBagConstraints);

        btnPanelEmpleado.setBackground(new java.awt.Color(156, 40, 177));
        btnPanelEmpleado.setLayout(new java.awt.BorderLayout());

        btnEmpleado.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEmpleado.setForeground(new java.awt.Color(255, 255, 255));
        btnEmpleado.setText("Empleado");
        btnEmpleado.setContentAreaFilled(false);
        btnEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmpleadoActionPerformed(evt);
            }
        });
        btnPanelEmpleado.add(btnEmpleado, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(18, 0, 1, 0);
        JPanelButtons.add(btnPanelEmpleado, gridBagConstraints);

        btnPanelProveedor.setBackground(new java.awt.Color(156, 40, 177));
        btnPanelProveedor.setLayout(new java.awt.BorderLayout());

        btnProveedor.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnProveedor.setForeground(new java.awt.Color(255, 255, 255));
        btnProveedor.setText("Proveedores");
        btnProveedor.setContentAreaFilled(false);
        btnProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProveedorActionPerformed(evt);
            }
        });
        btnPanelProveedor.add(btnProveedor, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(18, 0, 1, 0);
        JPanelButtons.add(btnPanelProveedor, gridBagConstraints);

        btnPanelIngresa.setBackground(new java.awt.Color(85, 51, 91));
        btnPanelIngresa.setLayout(new java.awt.BorderLayout());

        btnIngresa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnIngresa.setForeground(new java.awt.Color(255, 255, 255));
        btnIngresa.setText("Compras Mercaderia");
        btnIngresa.setBorderPainted(false);
        btnIngresa.setContentAreaFilled(false);
        btnIngresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresaActionPerformed(evt);
            }
        });
        btnPanelIngresa.add(btnIngresa, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(18, 0, 1, 0);
        JPanelButtons.add(btnPanelIngresa, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Gestock");

        jPanel1.setBackground(new java.awt.Color(36, 37, 39));

        btnPanelSalir.setBackground(new java.awt.Color(156, 40, 177));
        btnPanelSalir.setLayout(new java.awt.BorderLayout());

        btnSalir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setText("Salir");
        btnSalir.setBorderPainted(false);
        btnSalir.setContentAreaFilled(false);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        btnPanelSalir.add(btnSalir, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(3, 3, 3)
                    .addComponent(btnPanelSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 136, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(107, 107, 107)
                    .addComponent(btnPanelSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanelMenuLayout = new javax.swing.GroupLayout(jPanelMenu);
        jPanelMenu.setLayout(jPanelMenuLayout);
        jPanelMenuLayout.setHorizontalGroup(
            jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMenuLayout.createSequentialGroup()
                .addGroup(jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMenuLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(JPanelButtons, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE))
                    .addGroup(jPanelMenuLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanelMenuLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelMenuLayout.setVerticalGroup(
            jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMenuLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JPanelButtons, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        jPanelContenido.setMaximumSize(getPreferredSize());

        javax.swing.GroupLayout jPanelContenidoLayout = new javax.swing.GroupLayout(jPanelContenido);
        jPanelContenido.setLayout(jPanelContenidoLayout);
        jPanelContenidoLayout.setHorizontalGroup(
            jPanelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 641, Short.MAX_VALUE)
        );
        jPanelContenidoLayout.setVerticalGroup(
            jPanelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 503, Short.MAX_VALUE)
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
        setTitle("Empleado");

        btnPanelVenta.setBackground(unSelectedColor);
        btnPanelProveedor.setBackground(unSelectedColor);
        btnPanelEmpleado.setBackground(selectedColor);
        btnPanelIngresa.setBackground(unSelectedColor);
        btnPanelArticulo.setBackground(unSelectedColor);

        menuEmpleado.setLocation(0, 0);
        menuEmpleado.cargarDatosEnTabla();
        jPanelContenido.setLayout(new BorderLayout()); // Asegúrate de tener BorderLayout.
        jPanelContenido.removeAll();
        jPanelContenido.add(menuEmpleado, BorderLayout.CENTER);
        jPanelContenido.revalidate();
        jPanelContenido.repaint();
    }//GEN-LAST:event_btnEmpleadoActionPerformed

    private void btnArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArticuloActionPerformed
        setTitle("Articulo");

        btnPanelVenta.setBackground(unSelectedColor);
        btnPanelProveedor.setBackground(unSelectedColor);
        btnPanelEmpleado.setBackground(unSelectedColor);
        btnPanelIngresa.setBackground(unSelectedColor);
        btnPanelArticulo.setBackground(selectedColor);

        menuArticulo.cargarDatosCategoria();
        menuArticulo.cargarDatosEnTabla();

        menuArticulo.setLocation(0, 0);
        jPanelContenido.setLayout(new BorderLayout()); // Asegúrate de tener BorderLayout.
        jPanelContenido.removeAll();
        jPanelContenido.add(menuArticulo, BorderLayout.CENTER);
        jPanelContenido.revalidate();
        jPanelContenido.repaint();
    }//GEN-LAST:event_btnArticuloActionPerformed

    private void btnIngresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresaActionPerformed
        setTitle("Ingresa");

        btnPanelVenta.setBackground(unSelectedColor);
        btnPanelProveedor.setBackground(unSelectedColor);
        btnPanelEmpleado.setBackground(unSelectedColor);
        btnPanelIngresa.setBackground(selectedColor);
        btnPanelArticulo.setBackground(unSelectedColor);

        menuIngresa.setLocation(0, 0);
        menuIngresa.cargarDatosCombobox();
        menuIngresa.cargarDatosEnTabla();

        jPanelContenido.setLayout(new BorderLayout()); // Asegúrate de tener BorderLayout.
        jPanelContenido.removeAll();
        jPanelContenido.add(menuIngresa, BorderLayout.CENTER);
        jPanelContenido.revalidate();
        jPanelContenido.repaint();
    }//GEN-LAST:event_btnIngresaActionPerformed

    private void btnVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentaActionPerformed

        setTitle("Venta");

        btnPanelVenta.setBackground(selectedColor);
        btnPanelProveedor.setBackground(unSelectedColor);
        btnPanelEmpleado.setBackground(unSelectedColor);
        btnPanelIngresa.setBackground(unSelectedColor);
        btnPanelArticulo.setBackground(unSelectedColor);

        menuVenta.setLocation(0, 0);
        menuVenta.cargarDatosEnTabla();
        
        
        jPanelContenido.setLayout(new BorderLayout()); // Asegúrate de tener BorderLayout.
        jPanelContenido.removeAll();
        jPanelContenido.add(menuVenta, BorderLayout.CENTER);
        jPanelContenido.revalidate();
        jPanelContenido.repaint();
    }//GEN-LAST:event_btnVentaActionPerformed

    private void btnProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProveedorActionPerformed

        setTitle("Proveedor");

        btnPanelVenta.setBackground(unSelectedColor);
        btnPanelProveedor.setBackground(selectedColor);
        btnPanelEmpleado.setBackground(unSelectedColor);
        btnPanelIngresa.setBackground(unSelectedColor);
        btnPanelArticulo.setBackground(unSelectedColor);

        menuProveedor.setLocation(0, 0);
        menuProveedor.cargarDatosEnTabla();
        
        jPanelContenido.setLayout(new BorderLayout()); // Asegúrate de tener BorderLayout.
        jPanelContenido.removeAll();
        jPanelContenido.add(menuProveedor, BorderLayout.CENTER);
        jPanelContenido.revalidate();
        jPanelContenido.repaint();
    }//GEN-LAST:event_btnProveedorActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

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
    private javax.swing.JPanel JPanelButtons;
    private javax.swing.JButton btnArticulo;
    private javax.swing.JButton btnEmpleado;
    private javax.swing.JButton btnIngresa;
    private javax.swing.JPanel btnPanelArticulo;
    private javax.swing.JPanel btnPanelEmpleado;
    private javax.swing.JPanel btnPanelIngresa;
    private javax.swing.JPanel btnPanelProveedor;
    private javax.swing.JPanel btnPanelSalir;
    private javax.swing.JPanel btnPanelVenta;
    private javax.swing.JButton btnProveedor;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnVenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelContenido;
    private javax.swing.JPanel jPanelMenu;
    // End of variables declaration//GEN-END:variables
}
