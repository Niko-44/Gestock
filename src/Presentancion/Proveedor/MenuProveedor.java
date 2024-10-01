/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Presentancion.Proveedor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.xml.crypto.Data;
import logica.Clases.Fabricante;

import logica.Fabrica;
import logica.Clases.Proveedor;
import logica.Interfaces.IControladorProveedor;

/**
 *
 *
 * @author Cristian
 */
public class MenuProveedor extends javax.swing.JPanel {

    private IControladorProveedor ICP;
    Fabrica fabrica = Fabrica.getInstance();
    private int selectedRow;
    MenuDireccion menuDireccion = new MenuDireccion();
    private DefaultTableModel modeloTabla;

    public MenuProveedor() {
        initComponents();
        this.ICP = fabrica.getIControladorProveedor();
        cargarDatosEnTabla();

        Date fechaactual = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        String fechaFormateada = formatoFecha.format(fechaactual);

       // txt_fecha_actualizada.setValue(fechaFormateada); // Establecer el valor formateado
        //txt_fecha_creada.setText(fechaFormateada); // Establecer el valor formateado
        UIManager.put("OptionPane.yesButtonText", "Sí");//poner el botón yes de la confirmaión en español
        UIManager.put("OptionPane.noButtonText", "No");//poner el botón no de la confirmaión en español

        tbl_Proveedor.getSelectionModel().addListSelectionListener(event -> {
            if (!event.getValueIsAdjusting()) { // Este chequeo asegura que solo se ejecute una vez por selección
                int selectedRow = tbl_Proveedor.getSelectedRow();
                if (selectedRow != -1) {
                    // Obtener los valores de la fila seleccionada
                    String id = tbl_Proveedor.getValueAt(selectedRow, 0).toString();
                    String nombre = tbl_Proveedor.getValueAt(selectedRow, 1).toString();
                    String email = tbl_Proveedor.getValueAt(selectedRow, 2).toString();
                    String telefono = tbl_Proveedor.getValueAt(selectedRow, 3).toString();
                    String update_date = tbl_Proveedor.getValueAt(selectedRow, 4).toString();
                    String create_date = tbl_Proveedor.getValueAt(selectedRow, 5).toString();

                    // Asignar los valores a los JTextField
                    txt_id.setText(id);
                    txt_nombre.setText(nombre);
                    txt_telefono.setText(telefono);
                    txt_email.setText(email);
                  //  txt_fecha_actualizada.setText(update_date);
                   // txt_fecha_creada.setText(create_date);

                    btn_agregar.setEnabled(false);
                    btn_modificar.setEnabled(true);
                    btn_eliminar.setEnabled(true);
                }
            }
        });
    }

    public void cargarDatosEnTabla() {
        String[] columnas = {"ID", "Nombre", "Correo", "Telefono", "Fecha Actualización", "Fecha Creación"};
        modeloTabla = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Retornar false para que ninguna celda sea editable
                return false;
            }
        };

        ArrayList<Proveedor> proveedores = ICP.obtenerProveedor();
        for (Proveedor proveedor : proveedores) {
            Object[] fila = {
                proveedor.getId(),
                proveedor.getNombre(),
                proveedor.getEmail(),
                proveedor.getTelefonos(),
                proveedor.getFechaUpdateFormateada(),
                proveedor.getFechaCreadaFormateada()

            };
            modeloTabla.addRow(fila);
        }

        tbl_Proveedor.setModel(modeloTabla);
    }

    private void eliminarProveedor(int selectedRow) {
        DefaultTableModel model = (DefaultTableModel) tbl_Proveedor.getModel();
        model.removeRow(selectedRow);

    }

    private void cargarDatosBuscados(ArrayList<Proveedor> DatosBuscados) {
        String[] columnas = {"ID", "Nombre", "Correo", "Telefono", "Fecha Actualización", "Fecha Creación"};
        modeloTabla = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Retornar false para que ninguna celda sea editable
                return false;
            }
        };

        for (Proveedor proveedor : DatosBuscados) {
            Object[] fila = {
                proveedor.getId(),
                proveedor.getNombre(),
                proveedor.getEmail(),
                proveedor.getTelefonos(),
                proveedor.getFechaUpdateFormateada(),
                proveedor.getFechaCreadaFormateada()
            };
            modeloTabla.addRow(fila);

        }

        tbl_Proveedor.setModel(modeloTabla);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Proveedor = new javax.swing.JTable();
        btn_direcciones = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        lbl_id = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        lbl_nombre = new javax.swing.JLabel();
        lbl_telefono = new javax.swing.JLabel();
        lbl_email = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        txt_telefono = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btn_agregar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lbl_proveedor = new javax.swing.JLabel();
        cmb_Atributo = new javax.swing.JComboBox<>();
        btn_Refrescar = new javax.swing.JButton();
        btn_Limpiar = new javax.swing.JButton();
        btn_Buscar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_Buscar = new javax.swing.JTextPane();

        tbl_Proveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Teléfono", "Email", "Fecha Actualizada", "Fecha Creada"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_Proveedor.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane1.setViewportView(tbl_Proveedor);

        btn_direcciones.setText("Direcciones");
        btn_direcciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_direccionesActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Nuevo proveedor"));
        java.awt.GridBagLayout jPanel4Layout = new java.awt.GridBagLayout();
        jPanel4Layout.columnWidths = new int[] {0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0};
        jPanel4Layout.rowHeights = new int[] {0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0};
        jPanel4.setLayout(jPanel4Layout);

        lbl_id.setText("ID");
        lbl_id.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel4.add(lbl_id, gridBagConstraints);

        txt_id.setEditable(false);
        txt_id.setActionCommand("txtArticuloID");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        jPanel4.add(txt_id, gridBagConstraints);

        lbl_nombre.setText("Nombre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel4.add(lbl_nombre, gridBagConstraints);

        lbl_telefono.setText("Teléfono");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel4.add(lbl_telefono, gridBagConstraints);

        lbl_email.setText("Email");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel4.add(lbl_email, gridBagConstraints);

        txt_nombre.setActionCommand("txtArticuloNombre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        jPanel4.add(txt_nombre, gridBagConstraints);

        txt_telefono.setActionCommand("txtArticuloDesc");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        jPanel4.add(txt_telefono, gridBagConstraints);

        txt_email.setActionCommand("txtArticuloStock");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        jPanel4.add(txt_email, gridBagConstraints);

        jPanel1.setMinimumSize(new java.awt.Dimension(325, 23));
        jPanel1.setPreferredSize(new java.awt.Dimension(688, 25));
        jPanel1.setLayout(new java.awt.GridLayout(1, 3, 10, 50));

        btn_agregar.setActionCommand("jButtonAgregar");
        btn_agregar.setLabel("Agregar");
        btn_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_agregar);

        btn_eliminar.setText("Eliminar");
        btn_eliminar.setActionCommand("jButtonEliminar");
        btn_eliminar.setEnabled(false);
        btn_eliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_eliminarMouseClicked(evt);
            }
        });
        jPanel1.add(btn_eliminar);

        btn_modificar.setText("Modificar");
        btn_modificar.setActionCommand("jButtonModificar");
        btn_modificar.setEnabled(false);
        btn_modificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_modificarMouseClicked(evt);
            }
        });
        jPanel1.add(btn_modificar);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel4.add(jPanel1, gridBagConstraints);

        jPanel2.setLayout(new java.awt.GridBagLayout());

        lbl_proveedor.setText("Proveedor");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.insets = new java.awt.Insets(0, 324, 0, 322);
        jPanel2.add(lbl_proveedor, gridBagConstraints);

        cmb_Atributo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombre", "Teléfono", "Correo" }));

        btn_Refrescar.setText("Refrescar");
        btn_Refrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RefrescarActionPerformed(evt);
            }
        });

        btn_Limpiar.setText("Limpiar");
        btn_Limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LimpiarActionPerformed(evt);
            }
        });

        btn_Buscar.setText("Buscar");
        btn_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BuscarActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(txt_Buscar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(btn_direcciones)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(cmb_Atributo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_Buscar)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Refrescar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_Limpiar)
                        .addGap(60, 60, 60)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_Refrescar)
                        .addComponent(btn_Limpiar)
                        .addComponent(btn_Buscar))
                    .addComponent(cmb_Atributo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_direcciones)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_eliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_eliminarMouseClicked

        try {
            this.selectedRow = tbl_Proveedor.getSelectedRow();
            if (this.selectedRow != -1) {
                int idProveedor = (Integer) tbl_Proveedor.getValueAt(selectedRow, 0);
                // Mostrar un diálogo de confirmación
                int confirmacion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que deseas eliminar este proveedor?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
                if (confirmacion == JOptionPane.YES_OPTION) {
                    if (ICP.eliminarProveedor(idProveedor) == true) {
                        eliminarProveedor(this.selectedRow);
                        txt_id.setText("");
                        txt_nombre.setText("");
                        txt_telefono.setText("");
                        txt_email.setText("");
                       // txt_fecha_actualizada.setText("");
                       // txt_fecha_creada.setText("");
                        JOptionPane.showMessageDialog(this, "El proveedor se eliminó correctamente.");
                    } else {
                        JOptionPane.showMessageDialog(this, "Hubo un error al eliminar el proveedor.");
                    }

                }
            } else {
                JOptionPane.showMessageDialog(this, "Selecciona un proveedor para eliminar.");
            }
        } catch (Exception e) {
            e.printStackTrace(); // Puedes cambiar esto por un manejo de errores más adecuado
        }

    }//GEN-LAST:event_btn_eliminarMouseClicked

    private void btn_direccionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_direccionesActionPerformed
        menuDireccion.cargarDatosCombobox();
        menuDireccion.setVisible(true);

    }//GEN-LAST:event_btn_direccionesActionPerformed

    private void btn_modificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_modificarMouseClicked
        try {

            int respuesta = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea modificar este proveedor?", "Confirmación", JOptionPane.YES_NO_OPTION);
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

            String nombre = txt_nombre.getText();
            if (nombre.isBlank()) {
                throw new Exception("El nombre no puede estar vacío.");
            }
            if (nombre.length() > 50) {
                throw new Exception("El nombre no puede exceder los 50 caracteres.");
            }

            String telefono = txt_telefono.getText();
            if (telefono.isBlank()) {
                throw new Exception("El teléfono no puede estar vacío.");
            }

            String correo = txt_email.getText();
            if (correo.isBlank()) {
                throw new Exception("El correo electrónico no puede estar vacío.");
            }

            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaActual = new Date();
            // Verificación de la fecha de creación
            String fechaCreadaText = formato.format(fechaActual);
            if (fechaCreadaText.isBlank()) {
                throw new Exception("La fecha de creación no puede estar vacía.");
            }
            Date create_date;
            try {
                create_date = formato.parse(fechaCreadaText);
            } catch (ParseException e) {
                throw new Exception("La fecha de creación debe tener el formato 'yyyy-MM-dd'.");
            }

            // Creación del objeto Proveedor y actualización de datos
            Proveedor proveedor = new Proveedor(id, nombre, telefono, correo, new Date(), create_date);
            ICP.modificarDatosProveedor(proveedor);

            cargarDatosEnTabla();

            // Limpieza de campos
            txt_id.setText("");
            txt_nombre.setText("");
            txt_telefono.setText("");
            txt_email.setText("");
           // txt_fecha_actualizada.setText("");
           // txt_fecha_creada.setText("");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_btn_modificarMouseClicked

    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarActionPerformed
        try {
            // Crear un nuevo proveedor
            Proveedor nuevoProveedor = new Proveedor();

            // Obtener y validar el nombre
            String nombre = txt_nombre.getText();
            if (nombre == null || nombre.trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "El nombre no puede estar vacío");
                return;
            }
            nuevoProveedor.setNombre(nombre);

            // Obtener y validar el email
            String email = txt_email.getText();
            if (email == null || email.trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "El email no puede estar vacío");
                return;
            }

            nuevoProveedor.setEmail(email);

            // Obtener y validar el teléfono
            String telefono = txt_telefono.getText();
            if (telefono == null || telefono.trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "El teléfono no puede estar vacío");
                return;
            }
            nuevoProveedor.setTelefonos(telefono);

            // Establecer fechas de creación y actualización
            nuevoProveedor.setUpdateDate(new Date());
            nuevoProveedor.setCreateDate(new Date());

            // Intentar agregar el proveedor
            if (ICP.agregarProveedor(nuevoProveedor)) {
                JOptionPane.showMessageDialog(this, "El proveedor se agregó correctamente");
                cargarDatosEnTabla();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_agregarActionPerformed

    private void btn_RefrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RefrescarActionPerformed
        cargarDatosEnTabla();
        btn_agregar.setEnabled(true);
    }//GEN-LAST:event_btn_RefrescarActionPerformed

    private void btn_LimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LimpiarActionPerformed
        txt_id.setText("");
        txt_nombre.setText("");
        txt_telefono.setText("");
        txt_email.setText("");
        

        btn_agregar.setEnabled(true);
        btn_modificar.setEnabled(false);
        btn_eliminar.setEnabled(false);
    }//GEN-LAST:event_btn_LimpiarActionPerformed

    private void btn_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BuscarActionPerformed
        String atributo = cmb_Atributo.getSelectedItem().toString();
        String datoBuscado = txt_Buscar.getText();
        if (datoBuscado == "") {
            JOptionPane.showMessageDialog(this, "Debe ingresar dato a buscar.");
        } else {
            cargarDatosBuscados(ICP.buscarProveedor(atributo, datoBuscado));
        }
    }//GEN-LAST:event_btn_BuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Buscar;
    private javax.swing.JButton btn_Limpiar;
    private javax.swing.JButton btn_Refrescar;
    private javax.swing.JButton btn_agregar;
    private javax.swing.JButton btn_direcciones;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JComboBox<String> cmb_Atributo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_email;
    private javax.swing.JLabel lbl_id;
    private javax.swing.JLabel lbl_nombre;
    private javax.swing.JLabel lbl_proveedor;
    private javax.swing.JLabel lbl_telefono;
    private javax.swing.JTable tbl_Proveedor;
    private javax.swing.JTextPane txt_Buscar;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_telefono;
    // End of variables declaration//GEN-END:variables
}
