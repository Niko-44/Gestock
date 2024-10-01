/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Presentancion.Venta;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import logica.Fabrica;
import logica.Clases.Venta;
import logica.Interfaces.IControladorVenta;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import logica.Clases.DateLabelFormatter;
import logica.Clases.Empleado;
import logica.Clases.EstadoCellRenderer;
import logica.Interfaces.IControladorEmpleado;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class MenuVenta extends javax.swing.JPanel {

    MenuLineaVenta menuLineaVenta = new MenuLineaVenta();

    private DefaultTableModel modeloTabla;

    private IControladorVenta ICV;
    private IControladorEmpleado ICE;
    private int selectedRow;
    ArrayList<Integer> empleadoprueba_id = new ArrayList<>();

    Fabrica fabrica = Fabrica.getInstance();

    UtilDateModel model = new UtilDateModel();
    Properties p = new Properties();
    JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
    private JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");

    private int id_venta;

    public MenuVenta() {

        initComponents();
        DefaultTableModel model = (DefaultTableModel) tbl_venta.getModel();
        UIManager.put("OptionPane.yesButtonText", "Sí");// poner el botón yes de la confirmaión en español
        UIManager.put("OptionPane.noButtonText", "No");// poner el botón no de la confirmaión en español

        this.ICV = fabrica.getIControladoreVenta();
        this.ICE = fabrica.getIControladoreEmpleado();

        cargarDatosEnTabla();
        cargarDatosEmpleado();
        agregarDatePicker();

        tbl_venta.getSelectionModel().addListSelectionListener(event -> {
            if (!event.getValueIsAdjusting()) { // Este chequeo asegura que solo se ejecute una vez por selección
                selectedRow = tbl_venta.getSelectedRow();
                if (selectedRow != -1) {
                    // Obtener los valores de la fila seleccionada
                    String id = tbl_venta.getValueAt(selectedRow, 0).toString();
                    String fecha_v = tbl_venta.getValueAt(selectedRow, 1).toString();
                    String Estado = tbl_venta.getValueAt(selectedRow, 2).toString();
                    String Empleado = tbl_venta.getValueAt(selectedRow, 3).toString();

                    id_venta = Integer.parseInt(id);
                    datePicker.getJFormattedTextField().setText(fecha_v);
                    txt_id.setText(id);
                    cmbEstado.setSelectedItem(Estado);
                    cmbEmpleado.setSelectedItem(Empleado);
                    
                    btn_Agregar.setEnabled(false);

                }
            }
        });

    }

    public void cargarDatosEmpleado() {
        cmbEmpleado.removeAllItems();

        ArrayList<Empleado> dataEmpleado = ICE.obtenerEmpleado();

        for (Empleado item : dataEmpleado) {

            cmbEmpleado.addItem(item.getNombre());
            empleadoprueba_id.add(item.getId());
        }
    }

    public void cargarDatosEnTabla() {
        String[] columnas = {"ID", "Fecha Venta", "Estado", "Empleado"};

        modeloTabla = new DefaultTableModel(columnas, 0) {
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

    private void agregarDatePicker() {
        // Configurar el JDatePicker
        p.put("text.today", "Hoy");
        p.put("text.month", "Mes");
        p.put("text.year", "Año");

        // Establecer tamaño preferido para el DatePicker
        datePicker.setPreferredSize(new java.awt.Dimension(200, 30));

        // Quitar el JTextField y agregar el DatePicker en su lugar
        txt_fechaVenta.setVisible(false);  // Ocultar el JTextField
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 2;  // Ajustar el GridBagConstraints según la posición que desees
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;  // Ajustar el componente horizontalmente
        gbc.insets = new Insets(4, 0, 0, 15);  // Márgenes para mayor espacio alrededor

        jPanel4.add(datePicker, gbc);  // Añadir el DatePicker al JPanel
        jPanel4.revalidate();  // Actualizar el layout
        jPanel4.repaint();
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
        btn_Buscar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_Buscar = new javax.swing.JTextPane();
        cmb_Atributo = new javax.swing.JComboBox<>();
        btn_Refrescar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        lbl_id = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        lbl_nombre = new javax.swing.JLabel();
        lbl_descripcion = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btn_Agregar = new javax.swing.JButton();
        btn_Eliminar = new javax.swing.JButton();
        btn_Modificar = new javax.swing.JButton();
        btnVerLineaVenta = new javax.swing.JButton();
        cmbEstado = new javax.swing.JComboBox<>();
        cmbEmpleado = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txt_fechaVenta = new javax.swing.JTextField();
        btn_limpiar = new javax.swing.JButton();

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

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Nueva categoria"));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        lbl_id.setText("ID");
        lbl_id.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel4.add(lbl_id, gridBagConstraints);

        txt_id.setEditable(false);
        txt_id.setActionCommand("txtArticuloID");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 15);
        jPanel4.add(txt_id, gridBagConstraints);

        lbl_nombre.setText("Estado");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel4.add(lbl_nombre, gridBagConstraints);

        lbl_descripcion.setText("Empleado");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel4.add(lbl_descripcion, gridBagConstraints);

        jPanel1.setMinimumSize(new java.awt.Dimension(325, 23));
        jPanel1.setPreferredSize(new java.awt.Dimension(688, 25));
        jPanel1.setLayout(new java.awt.GridLayout(1, 3, 10, 50));

        btn_Agregar.setActionCommand("jButtonAgregar");
        btn_Agregar.setLabel("Agregar");
        btn_Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Agregar);

        btn_Eliminar.setText("Eliminar");
        btn_Eliminar.setActionCommand("jButtonEliminar");
        btn_Eliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_EliminarMouseClicked(evt);
            }
        });
        jPanel1.add(btn_Eliminar);

        btn_Modificar.setText("Modificar");
        btn_Modificar.setActionCommand("jButtonModificar");
        btn_Modificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ModificarMouseClicked(evt);
            }
        });
        jPanel1.add(btn_Modificar);

        btnVerLineaVenta.setText("Ver lineas de venta");
        btnVerLineaVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerLineaVentaActionPerformed(evt);
            }
        });
        jPanel1.add(btnVerLineaVenta);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 19);
        jPanel4.add(jPanel1, gridBagConstraints);

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pendiente", "Completada", "Cancelada" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 4;
        gridBagConstraints.weightx = 0.6;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 0, 15);
        jPanel4.add(cmbEstado, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 0, 15);
        jPanel4.add(cmbEmpleado, gridBagConstraints);

        jLabel2.setText("Fecha de venta");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel4.add(jLabel2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 4;
        gridBagConstraints.weightx = 0.6;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 0, 15);
        jPanel4.add(txt_fechaVenta, gridBagConstraints);

        btn_limpiar.setText("Limpiar");
        btn_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 776, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 776, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btn_Buscar)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmb_Atributo, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Refrescar)
                        .addGap(18, 18, 18)
                        .addComponent(btn_limpiar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_Refrescar)
                            .addComponent(cmb_Atributo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_limpiar))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(btn_Buscar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        modeloTabla = new DefaultTableModel(columnas, 0) {
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
        btn_Agregar.setEnabled(true);
    }//GEN-LAST:event_btn_RefrescarActionPerformed

    private void btn_EliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_EliminarMouseClicked
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
        }
    }//GEN-LAST:event_btn_EliminarMouseClicked

    private void btn_ModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ModificarMouseClicked
        try {
            int respuesta = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea modificar esta venta?", "Confirmación", JOptionPane.YES_NO_OPTION);
            if (respuesta != JOptionPane.YES_OPTION) {
                return; // Salir si el usuario elige "No"
            }
            String idText = txt_id.getText();
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

            Venta venta = new Venta(id, null, Venta.EstadoVenta.valueOf(comboEstado), nuevoEmpleado);
            ICV.modificarDatosVentas(venta);

            JOptionPane.showMessageDialog(this, "La venta se ha actualizado correctamente.", "Éxito",
                    JOptionPane.INFORMATION_MESSAGE);
            cargarDatosEnTabla();

            txt_id.setText("");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btn_ModificarMouseClicked

    private void btn_AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AgregarActionPerformed
        try {
            String estadoVenta = (String) cmbEstado.getSelectedItem();
            String nombreEmpleado = (String) cmbEmpleado.getSelectedItem();

            if (estadoVenta == null || estadoVenta.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Seleccione un estado para la venta.");
                return;
            }

            if (nombreEmpleado == null || nombreEmpleado.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Seleccione un empleado para la venta.");
                return;
            }

            Date fecha = new Date();
            ArrayList<Empleado> dataEmpleado = ICE.obtenerEmpleado();

            int cmb_id = empleadoprueba_id.get(cmbEmpleado.getSelectedIndex());
            Empleado nuevoEmpleado = new Empleado();
            nuevoEmpleado.setId(cmb_id);

            Venta nuevaVenta = new Venta(0, fecha, Venta.EstadoVenta.valueOf(estadoVenta), nuevoEmpleado);

            if (ICV.agregarVenta(nuevaVenta) == true) {
                JOptionPane.showMessageDialog(this, "La venta se agrego correctamente");
                cargarDatosEnTabla();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_AgregarActionPerformed

    private void btn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarActionPerformed
        txt_id.setText("");
        txt_fechaVenta.setText("");
        
        btn_Agregar.setEnabled(true);
    }//GEN-LAST:event_btn_limpiarActionPerformed

    private void btnVerLineaVentaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnVerLineaVentaActionPerformed
        menuLineaVenta.id_venta = id_venta;
        menuLineaVenta.cargarDatosEnTabla();
        menuLineaVenta.setVisible(true);
    }// GEN-LAST:event_btnVerLineaVentaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVerLineaVenta;
    private javax.swing.JButton btn_Agregar;
    private javax.swing.JButton btn_Buscar;
    private javax.swing.JButton btn_Eliminar;
    private javax.swing.JButton btn_Modificar;
    private javax.swing.JButton btn_Refrescar;
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JComboBox<String> cmbEmpleado;
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JComboBox<String> cmb_Atributo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_descripcion;
    private javax.swing.JLabel lbl_id;
    private javax.swing.JLabel lbl_nombre;
    private javax.swing.JTable tbl_venta;
    private javax.swing.JTextPane txt_Buscar;
    private javax.swing.JTextField txt_fechaVenta;
    private javax.swing.JTextField txt_id;
    // End of variables declaration//GEN-END:variables
}
