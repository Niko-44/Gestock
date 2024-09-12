/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Presentancion.Venta;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import logica.Fabrica;
import logica.Clases.Venta;
import logica.Interfaces.IControladorVenta;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import logica.Clases.Empleado;
import logica.Clases.EstadoCellRenderer;
import logica.Interfaces.IControladorEmpleado;

public class MenuVenta extends javax.swing.JPanel {

    MenuLineaVenta menuLineaVenta = new MenuLineaVenta();

    private DefaultTableModel modeloTabla;

    private IControladorVenta ICV;
    private IControladorEmpleado ICE;
    private int selectedRow;
    ArrayList<Integer> empleadoprueba_id = new ArrayList<>();

    Fabrica fabrica = Fabrica.getInstance();

    SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");

    private int id_venta; 
    
    public MenuVenta() {
        
        
        initComponents();
        DefaultTableModel model = (DefaultTableModel) tbl_venta.getModel();
        UIManager.put("OptionPane.yesButtonText", "Sí");// poner el botón yes de la confirmaión en español
        UIManager.put("OptionPane.noButtonText", "No");// poner el botón no de la confirmaión en español

        this.ICV = fabrica.getIControladoreVenta();
        this.ICE = fabrica.getIControladoreEmpleado();

        cargarDatosEnTabla();

        tbl_venta.getSelectionModel().addListSelectionListener(event -> {
            if (!event.getValueIsAdjusting()) { // Este chequeo asegura que solo se ejecute una vez por selección
                selectedRow = tbl_venta.getSelectedRow();
                if (selectedRow != -1) {
                    // Obtener los valores de la fila seleccionada
                    String id = tbl_venta.getValueAt(selectedRow, 0).toString();
                    String date = tbl_venta.getValueAt(selectedRow, 1).toString();
                    
                    id_venta = Integer.parseInt(id);
                    
                    

                }
            }
        });

    }

    private void cargarDatosEnTabla() {
        String[] columnas = { "ID", "Fecha Venta", "Estado", "Empleado", "ID Empleado" };
        
        modeloTabla = new DefaultTableModel(columnas, 0);
        
        ArrayList<Venta> ventas = ICV.obtenerVenta();
        ArrayList<Empleado> dataEmpleado = ICE.obtenerEmpleado();

        for (Venta venta : ventas) {

            // Obtener el nombre del empleado que realizo la venta
            Object[] fila = {
                    venta.getId(),
                    venta.getFechaVenta(),
                    venta.getEstado(),
                    venta.getEmpleado().getNombre(),
                    venta.getEmpleado().getId(), };

            modeloTabla.addRow(fila);
        }

        tbl_venta.setModel(modeloTabla);
        tbl_venta.getColumnModel().getColumn(2).setCellRenderer(new EstadoCellRenderer());
    }

    private int buscarEmpleadoID(String nombreEmpleado, ArrayList<Empleado> dataEmleado) {
        for (Empleado empleado : dataEmleado) {

            if (empleado.getNombre().equals(nombreEmpleado)) {
                return empleado.getId();
            }
        }

        return 0;
    }

    private void eliminarVenta(int selectedRow) {
        DefaultTableModel model = (DefaultTableModel) tbl_venta.getModel();
        model.removeRow(selectedRow);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_venta = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnVerLineaVenta = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

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

        btnEliminar.setText("Eliminar");
        btnEliminar.setActionCommand("jButtonEliminar");
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 886, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnVerLineaVenta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVerLineaVenta)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerLineaVentaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnVerLineaVentaActionPerformed
        menuLineaVenta.id_venta = id_venta;
        menuLineaVenta.cargarDatosEnTabla();
        menuLineaVenta.setVisible(true);
    }// GEN-LAST:event_btnVerLineaVentaActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAgregarActionPerformed
        /*try {
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
        }*/
    }// GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_btnEliminarMouseClicked
        /*try {
            this.selectedRow = tbl_venta.getSelectedRow();
            if (this.selectedRow != -1) {
                int idVenta = (Integer) tbl_venta.getValueAt(selectedRow, 0);
                // Mostrar un diálogo de confirmación
                int confirmacion = JOptionPane.showConfirmDialog(this,
                        "¿Estás seguro de que deseas eliminar esta venta?", "Confirmar Eliminación",
                        JOptionPane.YES_NO_OPTION);
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
        } // TODO add your handling code here:
    }// GEN-LAST:event_btnEliminarMouseClicked

    private void btnModificarMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_btnModificarMouseClicked
        try {

            String idText = txtID.getText();
            if (idText.isBlank()) {
                throw new Exception("El ID no puede estar vacío.");
            }
            int id;
            try {
                id = Integer.parseInt(idText);
                if (id <= 0) {
                    throw new Exception("El ID debe ser un número positivo.");
                }
            } catch (NumberFormatException e) {
                throw new Exception("El ID debe ser un número entero válido.");
            }

            String fechaText = txtDate.getText();
            if (fechaText.isBlank()) {
                throw new Exception("La fecha no puede estar vacía.");
            }
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaV;
            try {
                fechaV = formato.parse(fechaText);
            } catch (ParseException e) {
                throw new Exception("La fecha debe tener el formato 'yyyy-MM-dd'.");
            }

            String comboEstado = cmbEstado.getSelectedItem().toString();
            if (comboEstado.isBlank()) {
                throw new Exception("Debe seleccionar un estado.");
            }

            if (cmbEmpleado.getSelectedIndex() < 0) {
                throw new Exception("Debe seleccionar un empleado.");
            }
            int cmb_id = empleadoprueba_id.get(cmbEmpleado.getSelectedIndex());
            Empleado nuevoEmpleado = new Empleado();
            nuevoEmpleado.setId(cmb_id);

            Venta venta = new Venta(id, fechaV, Venta.EstadoVenta.valueOf(comboEstado), nuevoEmpleado);
            ICV.modificarDatosVentas(venta);

            JOptionPane.showMessageDialog(this, "La venta se ha actualizado correctamente.", "Éxito",
                    JOptionPane.INFORMATION_MESSAGE);
            cargarDatosEnTabla();

            txtID.setText("");
            txtDate.setText("");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
*/
    }// GEN-LAST:event_btnModificarMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnVerLineaVenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_venta;
    // End of variables declaration//GEN-END:variables
}
