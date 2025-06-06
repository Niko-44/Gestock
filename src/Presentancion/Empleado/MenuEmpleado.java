/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Presentancion.Empleado;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import javax.swing.table.DefaultTableModel;
import logica.Fabrica;
import logica.Clases.Empleado;
import logica.Interfaces.IControladorEmpleado;

/**
 *
 * @author vale5
 */
public class MenuEmpleado extends javax.swing.JPanel {

    private DefaultTableModel modeloTabla;
    private IControladorEmpleado ICE;
    Fabrica fabrica = Fabrica.getInstance();
    private int selectedRow;

    public MenuEmpleado() {
        initComponents();
        this.ICE = fabrica.getIControladoreEmpleado();
        cargarDatosEnTabla();
        UIManager.put("OptionPane.yesButtonText", "Sí");//poner el botón yes de la confirmaión en español
        UIManager.put("OptionPane.noButtonText", "No");//poner el botón no de la confirmaión en español

        tbl_Empleado.getSelectionModel().addListSelectionListener(event -> {
            if (!event.getValueIsAdjusting()) { // Este chequeo asegura que solo se ejecute una vez por selección
                int selectedRow = tbl_Empleado.getSelectedRow();
                if (selectedRow != -1) {
                    // Obtener los valores de la fila seleccionada
                    String id = tbl_Empleado.getValueAt(selectedRow, 0).toString();
                    String nombre = tbl_Empleado.getValueAt(selectedRow, 1).toString();
                    String apellido = tbl_Empleado.getValueAt(selectedRow, 2).toString();
                    String cedula = tbl_Empleado.getValueAt(selectedRow, 3).toString();
                    String nombre_usuario = tbl_Empleado.getValueAt(selectedRow, 4).toString();
                    String email = tbl_Empleado.getValueAt(selectedRow, 5).toString();
                    String rol = tbl_Empleado.getValueAt(selectedRow, 6).toString();

                    // Asignar los valores a los JTextField
                    txt_id.setText(id);
                    txt_nombre.setText(nombre);
                    txt_apellido.setText(apellido);
                    txt_cedula.setText(cedula);
                    txt_nombre_usuario.setText(nombre_usuario);
                    txt_email.setText(email);
                    cmb_Empleado.setSelectedItem(rol);

                    btn_Agregar.setEnabled(false);
                    btn_Modificar.setEnabled(true);
                    jBtnEliminarEmpleado.setEnabled(true);

                }
            }
        });

    }

    public void cargarDatosEnTabla() {
        String[] columnas = {"ID", "Nombre", "Apellido", "Cédula", "Usuario", "Email", "Rol"};
        modeloTabla = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Retornar false para que ninguna celda sea editable
                return false;
            }
        };
        ArrayList<Empleado> empleados = ICE.obtenerEmpleado();
        for (Empleado empleado : empleados) {
            Object[] fila = {
                empleado.getId(),
                empleado.getNombre(),
                empleado.getApellido(),
                empleado.getCedula(),
                empleado.getNombreUsuario(),
                empleado.getEmail(),
                empleado.getRol()
            };
            modeloTabla.addRow(fila);
        }

        tbl_Empleado.setModel(modeloTabla);
    }

    private void eliminarEmpleado(int selectedRow) {
        DefaultTableModel model = (DefaultTableModel) tbl_Empleado.getModel();
        model.removeRow(selectedRow);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Empleado = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        lbl_Articulo = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lbl_id = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        lbl_nombre = new javax.swing.JLabel();
        lbl_nombre1 = new javax.swing.JLabel();
        lbl_descripcion = new javax.swing.JLabel();
        lbl_stock = new javax.swing.JLabel();
        lbl_precio = new javax.swing.JLabel();
        lbl_peso = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        txt_apellido = new javax.swing.JTextField();
        txt_cedula = new javax.swing.JTextField();
        txt_nombre_usuario = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        txt_contraseña = new javax.swing.JTextField();
        lbl_fecha_actualizada = new javax.swing.JLabel();
        cmb_Empleado = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        btn_Agregar = new javax.swing.JButton();
        jBtnEliminarEmpleado = new javax.swing.JButton();
        btn_Modificar = new javax.swing.JButton();
        btn_Buscar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_Buscar = new javax.swing.JTextPane();
        btn_Refrescar = new javax.swing.JButton();
        btn_Limpiar = new javax.swing.JButton();
        cmb_BusquedaEmpleado = new javax.swing.JComboBox<>();

        setMaximumSize(getPreferredSize());

        tbl_Empleado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Apellido", "Cedula", "Nombre_Usuario", "Email", "Contraseña", "Rol"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_Empleado.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane1.setViewportView(tbl_Empleado);

        jPanel2.setLayout(new java.awt.GridBagLayout());

        lbl_Articulo.setText("Empleado");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.insets = new java.awt.Insets(0, 324, 0, 322);
        jPanel2.add(lbl_Articulo, gridBagConstraints);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Nuevo empleado"));
        jPanel4.setLayout(new java.awt.GridBagLayout());

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
        gridBagConstraints.ipadx = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(6, 2, 2, 2);
        jPanel4.add(txt_id, gridBagConstraints);

        lbl_nombre.setText("Nombre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel4.add(lbl_nombre, gridBagConstraints);

        lbl_nombre1.setText("Apellido");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel4.add(lbl_nombre1, gridBagConstraints);

        lbl_descripcion.setText("Cedula");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel4.add(lbl_descripcion, gridBagConstraints);

        lbl_stock.setText("Nombre Usuario");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel4.add(lbl_stock, gridBagConstraints);

        lbl_precio.setText("Email");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel4.add(lbl_precio, gridBagConstraints);

        lbl_peso.setText("Contraseña");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel4.add(lbl_peso, gridBagConstraints);

        txt_nombre.setActionCommand("txtArticuloNombre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(6, 2, 2, 2);
        jPanel4.add(txt_nombre, gridBagConstraints);

        txt_apellido.setActionCommand("txtArticuloDesc");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(6, 2, 2, 2);
        jPanel4.add(txt_apellido, gridBagConstraints);

        txt_cedula.setActionCommand("txtArticuloStock");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(6, 2, 2, 2);
        jPanel4.add(txt_cedula, gridBagConstraints);

        txt_nombre_usuario.setActionCommand("txtArticuloPrecio");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(6, 2, 2, 2);
        jPanel4.add(txt_nombre_usuario, gridBagConstraints);

        txt_email.setActionCommand("txtArticuloPeso");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(6, 2, 2, 2);
        jPanel4.add(txt_email, gridBagConstraints);

        txt_contraseña.setActionCommand("txtArticuloSku");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(6, 2, 2, 2);
        jPanel4.add(txt_contraseña, gridBagConstraints);

        lbl_fecha_actualizada.setText("Rol");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel4.add(lbl_fecha_actualizada, gridBagConstraints);

        cmb_Empleado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "admin", "vendedor" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.insets = new java.awt.Insets(6, 2, 2, 2);
        jPanel4.add(cmb_Empleado, gridBagConstraints);

        jPanel1.setMinimumSize(new java.awt.Dimension(325, 23));
        jPanel1.setPreferredSize(new java.awt.Dimension(688, 25));
        jPanel1.setLayout(new java.awt.GridLayout(1, 3, 10, 50));

        btn_Agregar.setActionCommand("jButtonAgregar");
        btn_Agregar.setLabel("Agregar");
        btn_Agregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_AgregarMouseClicked(evt);
            }
        });
        btn_Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Agregar);

        jBtnEliminarEmpleado.setText("Eliminar");
        jBtnEliminarEmpleado.setActionCommand("jButtonEliminar");
        jBtnEliminarEmpleado.setEnabled(false);
        jBtnEliminarEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnEliminarEmpleadoMouseClicked(evt);
            }
        });
        jPanel1.add(jBtnEliminarEmpleado);

        btn_Modificar.setText("Modificar");
        btn_Modificar.setActionCommand("jButtonModificar");
        btn_Modificar.setEnabled(false);
        btn_Modificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ModificarMouseClicked(evt);
            }
        });
        jPanel1.add(btn_Modificar);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 2;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.insets = new java.awt.Insets(6, 2, 2, 2);
        jPanel4.add(jPanel1, gridBagConstraints);

        btn_Buscar.setText("Buscar");
        btn_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BuscarActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(txt_Buscar);

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

        cmb_BusquedaEmpleado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombre", "Apellido", "Cedula", "Nombre Usuario" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btn_Buscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2)
                        .addGap(38, 38, 38)
                        .addComponent(cmb_BusquedaEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(btn_Refrescar)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Limpiar)))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_Refrescar)
                        .addComponent(btn_Limpiar)
                        .addComponent(cmb_BusquedaEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_Buscar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_AgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_AgregarMouseClicked

    }//GEN-LAST:event_btn_AgregarMouseClicked

    private void btn_ModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ModificarMouseClicked
        try {
            int respuesta = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea modificar este empleado?", "Confirmación", JOptionPane.YES_NO_OPTION);
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

            String apellido = txt_apellido.getText();
            if (apellido.isBlank()) {
                throw new Exception("El apellido no puede estar vacío.");
            }
            if (apellido.length() > 50) {
                throw new Exception("El apellido no puede exceder los 50 caracteres.");
            }

            String cedulaText = txt_cedula.getText();
            if (cedulaText.isBlank()) {
                throw new Exception("La cédula no puede estar vacía.");
            }
            int cedula;
            try {
                cedula = Integer.parseInt(cedulaText);
                if (cedula <= 0) {
                    throw new Exception("La cédula debe ser un número positivo.");
                }
            } catch (NumberFormatException e) {
                throw new Exception("La cédula debe ser un número entero válido.");
            }

            String nombre_usuario = txt_nombre_usuario.getText();
            if (nombre_usuario.isBlank()) {
                throw new Exception("El nombre de usuario no puede estar vacío.");
            }
            if (nombre_usuario.length() > 50) {
                throw new Exception("El nombre de usuario no puede exceder los 50 caracteres.");
            }

            String email = txt_email.getText();
            if (email.isBlank()) {
                throw new Exception("El email no puede estar vacío.");
            }
            if (email.length() > 100) {
                throw new Exception("El email no puede exceder los 100 caracteres.");
            }

            String contraseña = txt_contraseña.getText();
            if (contraseña.isBlank()) {
                throw new Exception("La contraseña no puede estar vacía.");
            }
            if (contraseña.length() < 8 || contraseña.length() > 20) {
                throw new Exception("La contraseña debe tener entre 8 y 20 caracteres.");
            }

            String rol = cmb_Empleado.getSelectedItem().toString();
            if (rol.isBlank()) {
                throw new Exception("Debe seleccionar un rol.");
            }

            Empleado empleado = new Empleado(id, nombre, apellido, cedula, nombre_usuario, email, contraseña, Empleado.ROLEMPLEADO.valueOf(rol), null);
            ICE.modificaDatosEmpleado(empleado, true);

            cargarDatosEnTabla();

            txt_id.setText("");
            txt_nombre.setText("");
            txt_apellido.setText("");
            txt_cedula.setText("");
            txt_nombre_usuario.setText("");
            txt_email.setText("");
            txt_contraseña.setText("");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btn_ModificarMouseClicked

    private void jBtnEliminarEmpleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnEliminarEmpleadoMouseClicked
        try {
            this.selectedRow = tbl_Empleado.getSelectedRow();
            if (this.selectedRow != -1) {
                int idEmpleado = (Integer) tbl_Empleado.getValueAt(selectedRow, 0);
                // Mostrar un diálogo de confirmación
                int confirmacion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que deseas eliminar este empleado?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
                if (confirmacion == JOptionPane.YES_OPTION) {
                    if (ICE.eliminarEmpleado(idEmpleado) == true) {
                        eliminarEmpleado(this.selectedRow);
                        JOptionPane.showMessageDialog(this, "El empleado se eliminó correctamente.");
                    } else {
                        JOptionPane.showMessageDialog(this, "Hubo un error al eliminar el empleado.");
                    }

                }
            } else {
                JOptionPane.showMessageDialog(this, "Selecciona un empleado para eliminar.");
            }
        } catch (Exception e) {
            e.printStackTrace(); // Puedes cambiar esto por un manejo de errores más adecuado
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnEliminarEmpleadoMouseClicked

    private void btn_AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AgregarActionPerformed
        try {

            if (txt_nombre.getText().isBlank()
                    || txt_apellido.getText().isBlank()
                    || txt_cedula.getText().isBlank()
                    || txt_nombre_usuario.getText().isBlank()
                    || txt_email.getText().isBlank()
                    || txt_contraseña.getText().isBlank()) {

                throw new Exception("Hay campos vacíos o inválidos");
            }

            Empleado nuevoEmpleado = new Empleado();

            nuevoEmpleado.setNombre(txt_nombre.getText());
            nuevoEmpleado.setApellido(txt_apellido.getText());
            nuevoEmpleado.setCedula(Integer.parseInt(txt_cedula.getText()));
            nuevoEmpleado.setNombreUsuario(txt_nombre_usuario.getText());
            nuevoEmpleado.setEmail(txt_email.getText());
            nuevoEmpleado.setContraseña(txt_contraseña.getText());
            nuevoEmpleado.setRol(Empleado.ROLEMPLEADO.valueOf(cmb_Empleado.getSelectedItem().toString()));

            System.out.println(nuevoEmpleado.getRol());

            if (ICE.agregarEmpleado(nuevoEmpleado) == true) {
                JOptionPane.showMessageDialog(this, "El empleado se agrego correctamente");

                cargarDatosEnTabla();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_AgregarActionPerformed

    private void cargarDatosBuscados(ArrayList<Empleado> DatosBuscados) {
        String[] columnas = {"ID", "Nombre", "Apellido", "Cédula", "Nombre Usuario", "Email", "Contraseña", "Rol"};
        modeloTabla = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Retornar false para que ninguna celda sea editable
                return false;
            }
        };

        for (Empleado empleado : DatosBuscados) {
            Object[] fila = {
                empleado.getId(),
                empleado.getNombre(),
                empleado.getApellido(),
                empleado.getCedula(),
                empleado.getNombreUsuario(),
                empleado.getEmail(),
                empleado.getContraseña(),
                empleado.getRol()
            };
            modeloTabla.addRow(fila);
        }

        tbl_Empleado.setModel(modeloTabla);
    }

    private void btn_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BuscarActionPerformed
        String atributo = cmb_BusquedaEmpleado.getSelectedItem().toString();
        String datoBuscado = txt_Buscar.getText();
        if (datoBuscado == "") {
            JOptionPane.showMessageDialog(this, "Debe ingresar dato a buscar.");
        } else {
            cargarDatosBuscados(ICE.buscarEmpleado(datoBuscado, atributo));
        }

    }//GEN-LAST:event_btn_BuscarActionPerformed

    private void btn_RefrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RefrescarActionPerformed
        cargarDatosEnTabla();
        btn_Agregar.setEnabled(true);
    }//GEN-LAST:event_btn_RefrescarActionPerformed

    private void btn_LimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LimpiarActionPerformed
        txt_apellido.setText("");
        txt_id.setText("");
        txt_nombre.setText("");
        txt_cedula.setText("");
        txt_contraseña.setText("");
        txt_email.setText("");
        txt_nombre_usuario.setText("");

        btn_Agregar.setEnabled(true);
        btn_Modificar.setEnabled(false);
        jBtnEliminarEmpleado.setEnabled(false);
    }//GEN-LAST:event_btn_LimpiarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Agregar;
    private javax.swing.JButton btn_Buscar;
    private javax.swing.JButton btn_Limpiar;
    private javax.swing.JButton btn_Modificar;
    private javax.swing.JButton btn_Refrescar;
    private javax.swing.JComboBox<String> cmb_BusquedaEmpleado;
    private javax.swing.JComboBox<String> cmb_Empleado;
    private javax.swing.JButton jBtnEliminarEmpleado;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_Articulo;
    private javax.swing.JLabel lbl_descripcion;
    private javax.swing.JLabel lbl_fecha_actualizada;
    private javax.swing.JLabel lbl_id;
    private javax.swing.JLabel lbl_nombre;
    private javax.swing.JLabel lbl_nombre1;
    private javax.swing.JLabel lbl_peso;
    private javax.swing.JLabel lbl_precio;
    private javax.swing.JLabel lbl_stock;
    private javax.swing.JTable tbl_Empleado;
    private javax.swing.JTextPane txt_Buscar;
    private javax.swing.JTextField txt_apellido;
    private javax.swing.JTextField txt_cedula;
    private javax.swing.JTextField txt_contraseña;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_nombre_usuario;
    // End of variables declaration//GEN-END:variables
}
