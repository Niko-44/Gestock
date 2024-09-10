/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Presentancion.Venta;

import Presentancion.Articulo.*;
import java.text.SimpleDateFormat;
import logica.Fabrica;
import logica.Clases.Venta;
import logica.Interfaces.IControladorVenta;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import logica.Clases.Empleado;
import logica.Interfaces.IControladorEmpleado;
import logica.servicios.VentasServicios;

public class MenuVenta extends javax.swing.JPanel {

    MenuLineaVenta menuLineaVenta = new MenuLineaVenta();

    private DefaultTableModel modeloTabla;

    private IControladorVenta ICV;
    private IControladorEmpleado ICE;
    private int selectedRow;

    Fabrica fabrica = Fabrica.getInstance();

    SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");

    public MenuVenta() {
        initComponents();
        DefaultTableModel model = (DefaultTableModel) tbl_venta.getModel();

        txtDate.setValue(new Date()); //Establecer fecha actual al txtFormattedField

        this.ICV = fabrica.getIControladoreVenta();
        this.ICE = fabrica.getIControladoreEmpleado();

        cargarDatosEnTabla();
        cargarDatosCombobox();

    }

    private void cargarDatosEnTabla() {
        String[] columnas = {"ID", "Fecha Venta", "Estado", "Empleado"};
        modeloTabla = new DefaultTableModel(columnas, 0);

        ArrayList<Venta> ventas = ICV.obtenerVenta();
        ArrayList<Empleado> dataEmpleado = ICE.obtenerEmpleado();

        for (Venta venta : ventas) {

            //Obtener el nombre del empleado que realizo la venta

            Object[] fila = {
                venta.getId(),
                venta.getFechaVenta(),
                venta.getEstado(),
                venta.getEmpleado().getNombre()

            };

            modeloTabla.addRow(fila);
        }

        tbl_venta.setModel(modeloTabla);
    }

    private String buscarEmpleado(int id_empleado, ArrayList<Empleado> dataEmleado) {
        for (Empleado empleado : dataEmleado) {
            if (empleado.getId() == id_empleado) {
                return empleado.getNombre();
            }
        }

        return "Desconocido";
    }

    private int buscarEmpleadoID(String nombreEmpleado, ArrayList<Empleado> dataEmleado) {
        for (Empleado empleado : dataEmleado) {

            if (empleado.getNombre().equals(nombreEmpleado)) {
                return empleado.getId();
            }
        }

        return 0;
    }

    private void cargarDatosCombobox() {
        ArrayList<Empleado> dataEmpleado = ICE.obtenerEmpleado();

        for (Empleado item : dataEmpleado) {
            cmbEmpleado.addItem(item.getNombre());
        }
    }

    private void eliminarVenta(int selectedRow) {
        DefaultTableModel model = (DefaultTableModel) tbl_venta.getModel();
        model.removeRow(selectedRow);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_venta = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnVerLineaVenta = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtDate = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        cmbEstado = new javax.swing.JComboBox<>();
        cmbEmpleado = new javax.swing.JComboBox<>();

        setMaximumSize(getPreferredSize());

        tbl_venta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Fecha venta", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_venta.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tbl_venta.setMaximumSize(getPreferredSize());
        jScrollPane1.setViewportView(tbl_venta);

        jPanel1.setMaximumSize(getPreferredSize());
        jPanel1.setMinimumSize(new java.awt.Dimension(325, 23));
        jPanel1.setPreferredSize(new java.awt.Dimension(688, 25));
        jPanel1.setLayout(new java.awt.GridLayout(1, 3, 10, 50));

        btnAgregar.setActionCommand("jButtonAgregar");
        btnAgregar.setLabel("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar);

        btnEliminar.setText("Eliminar");
        btnEliminar.setActionCommand("jButtonEliminar");
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarMouseClicked(evt);
            }
        });
        jPanel1.add(btnEliminar);

        btnModificar.setText("Modificar");
        btnModificar.setActionCommand("jButtonModificar");
        jPanel1.add(btnModificar);

        btnBuscar.setText("Buscar");
        btnBuscar.setActionCommand("jButtonBuscar");
        jPanel1.add(btnBuscar);

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Venta");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.insets = new java.awt.Insets(0, 324, 0, 322);
        jPanel2.add(jLabel1, gridBagConstraints);

        btnVerLineaVenta.setText("Ver lineas de venta");
        btnVerLineaVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerLineaVentaActionPerformed(evt);
            }
        });

        java.awt.GridBagLayout jPanel4Layout = new java.awt.GridBagLayout();
        jPanel4Layout.columnWidths = new int[] {0, 10, 0, 10, 0};
        jPanel4Layout.rowHeights = new int[] {0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0};
        jPanel4.setLayout(jPanel4Layout);

        jLabel2.setText("ID");
        jLabel2.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel4.add(jLabel2, gridBagConstraints);

        txtID.setEditable(false);
        txtID.setActionCommand("txtArticuloID");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        jPanel4.add(txtID, gridBagConstraints);

        jLabel3.setText("Fecha venta");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel4.add(jLabel3, gridBagConstraints);

        jLabel4.setText("Empleado");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel4.add(jLabel4, gridBagConstraints);

        txtDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd"))));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel4.add(txtDate, gridBagConstraints);

        jLabel5.setText("Estado");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel4.add(jLabel5, gridBagConstraints);

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pendiente", "Completada", "Cancelada" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel4.add(cmbEstado, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel4.add(cmbEmpleado, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(btnVerLineaVenta)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 752, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVerLineaVenta)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerLineaVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerLineaVentaActionPerformed
        menuLineaVenta.setVisible(true);
    }//GEN-LAST:event_btnVerLineaVentaActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        try {
            String estadoVenta = (String) cmbEstado.getSelectedItem();
            String nombreEmpleado = (String) cmbEmpleado.getSelectedItem();
            String fechaTexto = txtDate.getText();

            Date fecha = formatoFecha.parse(fechaTexto);
            ArrayList<Empleado> dataEmpleado = ICE.obtenerEmpleado();

            int id_empleado = buscarEmpleadoID(nombreEmpleado, dataEmpleado);
            Empleado nuevoEmpleado = new Empleado();
            nuevoEmpleado.setId(id_empleado);

            Venta nuevaVenta = new Venta(0, fecha, Venta.EstadoVenta.valueOf(estadoVenta), nuevoEmpleado);

            if (ICV.agregarVenta(nuevaVenta) == true) {
                JOptionPane.showMessageDialog(this, "La venta se agrego correctamente");
            } else {
                JOptionPane.showMessageDialog(this, "Error al intentar agregar la venta");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseClicked
        try {
            if (this.selectedRow != -1) {
                int idVenta = (Integer) tbl_venta.getValueAt(selectedRow, 0);
                // Mostrar un diálogo de confirmación
                int confirmacion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que deseas eliminar esta venta?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
                if (confirmacion == JOptionPane.YES_OPTION) {
                    if (ICV.eliminarVenta(idVenta) == true) {
                        eliminarVenta(this.selectedRow);
                        JOptionPane.showMessageDialog(this, "La venta se eliminó correctamente.");
                    } else {
                        JOptionPane.showMessageDialog(this, "Hubo un error al eliminar la venta.");
                    }

                }
            } else {
                JOptionPane.showMessageDialog(this, "Selecciona una venta para eliminar.");
            }
        } catch (Exception e) {
            e.printStackTrace(); // Puedes cambiar esto por un manejo de errores más adecuado
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnVerLineaVenta;
    private javax.swing.JComboBox<String> cmbEmpleado;
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_venta;
    private javax.swing.JFormattedTextField txtDate;
    private javax.swing.JTextField txtID;
    // End of variables declaration//GEN-END:variables
}
