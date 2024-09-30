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

    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");

    private int id_venta;
    private int id_empleado;

    public MenuVenta() {

        initComponents();
        DefaultTableModel model = (DefaultTableModel) tbl_venta.getModel();
        UIManager.put("OptionPane.yesButtonText", "Sí");// poner el botón yes de la confirmaión en español
        UIManager.put("OptionPane.noButtonText", "No");// poner el botón no de la confirmaión en español

        this.ICV = fabrica.getIControladoreVenta();
        this.ICE = fabrica.getIControladoreEmpleado();

        cargarDatosEnTabla();
        cargarDatosEmpleado();
        
        tbl_venta.getSelectionModel().addListSelectionListener(event -> {
            if (!event.getValueIsAdjusting()) { // Este chequeo asegura que solo se ejecute una vez por selección
                selectedRow = tbl_venta.getSelectedRow();
                if (selectedRow != -1) {
                    // Obtener los valores de la fila seleccionada
                    String id = tbl_venta.getValueAt(selectedRow, 0).toString();
                    String date = tbl_venta.getValueAt(selectedRow, 1).toString();
                    String estado = tbl_venta.getValueAt(selectedRow, 2).toString();
                    String empleado = tbl_venta.getValueAt(selectedRow, 3).toString();
                    
                    id_venta = Integer.parseInt(id);
                    
                    txt_fecha.setText(date);
                    cmbEstado.setSelectedItem(estado);
                    cmbEmpleado.setSelectedItem(empleado);

                }
            }
        });

    }
    
    public void cargarDatosEmpleado() {
        cmbEmpleado.removeAllItems();

        ArrayList<Venta> datosVenta = ICV.obtenerVenta();

        for (Venta item : datosVenta) {
            
            cmbEmpleado.addItem(String.valueOf(item.getEmpleado().getNombre()));
            
        }
    }
    

    public void cargarDatosEnTabla() {
        String[] columnas = {"ID", "Fecha Venta", "Estado", "Empleado"};

        modeloTabla = new DefaultTableModel(columnas, 0){
            @Override
            public boolean isCellEditable(int row, int column) {
                // Retornar false para que ninguna celda sea editable
                return false;
            }
        };

        ArrayList<Venta> ventas = ICV.obtenerVenta();
        ArrayList<Empleado> dataEmpleado = ICE.obtenerEmpleado();

        for (Venta venta : ventas) {

            // Obtener el nombre del empleado que realizo la venta
            Object[] fila = {
                venta.getId(),
                formatoFecha.format(venta.getFechaVenta()),
                venta.getEstado(),
                venta.getEmpleado().getNombre(),
                venta.getEmpleado().getId(),};

            modeloTabla.addRow(fila);
        }

        tbl_venta.setModel(modeloTabla);
        tbl_venta.getColumnModel().getColumn(2).setCellRenderer(new EstadoCellRenderer());
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
        btn_Buscar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_Buscar = new javax.swing.JTextPane();
        cmb_Atributo = new javax.swing.JComboBox<>();
        btn_Refrescar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        btn_Modificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        txt_fecha = new javax.swing.JTextField();
        lbl_fechaVenta = new javax.swing.JLabel();
        lbl_estado = new javax.swing.JLabel();
        lbl_empleado = new javax.swing.JLabel();
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
                false, false, false
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

        btn_Buscar.setText("Buscar");
        btn_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BuscarActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(txt_Buscar);

        cmb_Atributo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fecha", "Estado", "ID" }));

        btn_Refrescar.setText("Refrescar");
        btn_Refrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RefrescarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Nueva venta"));

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btn_Modificar.setText("Modificar");
        btn_Modificar.setActionCommand("jButtonModificar");

        btnEliminar.setText("Eliminar");
        btnEliminar.setActionCommand("jButtonEliminar");
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarMouseClicked(evt);
            }
        });
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        txt_fecha.setActionCommand("txtArticuloNombre");

        lbl_fechaVenta.setText("Fecha venta");

        lbl_estado.setText("Estado");

        lbl_empleado.setText("Empleado");

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Completado", "Pendiente", "Cancelado" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbl_empleado, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbEmpleado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_Modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbl_fechaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(txt_fecha))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbl_estado, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbEstado, 0, 641, Short.MAX_VALUE)))))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAgregar, btnEliminar, btn_Modificar});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_fechaVenta)
                    .addComponent(txt_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_estado)
                    .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_empleado)
                    .addComponent(cmbEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btn_Modificar)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(btnVerLineaVenta)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(btn_Buscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmb_Atributo, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_Refrescar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_Refrescar)
                        .addComponent(cmb_Atributo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_Buscar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVerLineaVenta)
                .addGap(17, 17, 17))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BuscarActionPerformed
        String atributo = cmb_Atributo.getSelectedItem().toString();
        String datoBuscado = txt_Buscar.getText();
        
        if (datoBuscado.isBlank()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar dato a buscar.");
        } else {
            cargarDatosBuscados(ICV.buscarVenta(atributo, datoBuscado, id_venta));
        }
    }//GEN-LAST:event_btn_BuscarActionPerformed

    private void cargarDatosBuscados(ArrayList<Venta> DatosBuscados) {
        String[] columnas = {"ID", "Fecha Venta", "Estado", "Empleado", "ID Empleado"};

        modeloTabla = new DefaultTableModel(columnas, 0){
            @Override
            public boolean isCellEditable(int row, int column) {
                // Retornar false para que ninguna celda sea editable
                return false;
            }
        };

        for (Venta venta : DatosBuscados) {

            // Obtener el nombre del empleado que realizo la venta
            Object[] fila = {
                venta.getId(),
                formatoFecha.format(venta.getFechaVenta()),
                venta.getEstado(),
                venta.getEmpleado().getNombre(),
                venta.getEmpleado().getId(),};

            modeloTabla.addRow(fila);
        }

        tbl_venta.setModel(modeloTabla);
        tbl_venta.getColumnModel().getColumn(2).setCellRenderer(new EstadoCellRenderer());
    }

    private void btn_RefrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RefrescarActionPerformed
        cargarDatosEnTabla();
    }//GEN-LAST:event_btn_RefrescarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
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
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnVerLineaVentaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnVerLineaVentaActionPerformed
        menuLineaVenta.id_venta = id_venta;
        menuLineaVenta.cargarDatosEnTabla();
        menuLineaVenta.setVisible(true);
    }// GEN-LAST:event_btnVerLineaVentaActionPerformed

   

    private void btnEliminarMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_btnEliminarMouseClicked
        
        try {
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
        /*try {

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
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnVerLineaVenta;
    private javax.swing.JButton btn_Buscar;
    private javax.swing.JButton btn_Modificar;
    private javax.swing.JButton btn_Refrescar;
    private javax.swing.JComboBox<String> cmbEmpleado;
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JComboBox<String> cmb_Atributo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_empleado;
    private javax.swing.JLabel lbl_estado;
    private javax.swing.JLabel lbl_fechaVenta;
    private javax.swing.JTable tbl_venta;
    private javax.swing.JTextPane txt_Buscar;
    private javax.swing.JTextField txt_fecha;
    // End of variables declaration//GEN-END:variables
}
