/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Presentancion.Proveedor;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import logica.Fabrica;
import logica.Clases.Direccion;
import logica.Clases.Ingresa;
import logica.Clases.Proveedor;
import logica.Interfaces.IControladorProveedor;

/**
 *
 * @author Cristian
 */
public class MenuDireccion extends javax.swing.JFrame {

    private IControladorProveedor ICP;
    Fabrica fabrica = Fabrica.getInstance();
    private int selectedRow;
    private DefaultTableModel modeloTabla;
    ArrayList<Integer> cmbProveedor_id = new ArrayList<>();

    /**
     * Creates new form MenuDirecciones
     */
    public MenuDireccion() {
        initComponents();
        this.ICP = fabrica.getIControladorProveedor();
        cargarDatosEnTabla();
        UIManager.put("OptionPane.yesButtonText", "Sí");//poner el botón yes de la confirmaión en español
        UIManager.put("OptionPane.noButtonText", "No");//poner el botón no de la confirmaión en español

        tbl_Direccion.getSelectionModel().addListSelectionListener(event -> {
            if (!event.getValueIsAdjusting()) { // Este chequeo asegura que solo se ejecute una vez por selección
                int selectedRow = tbl_Direccion.getSelectedRow();
                if (selectedRow != -1) {
                    // Obtener los valores de la fila seleccionada
                    String id = tbl_Direccion.getValueAt(selectedRow, 0).toString();
                    String calle = tbl_Direccion.getValueAt(selectedRow, 1).toString();
                    String num_puerta = tbl_Direccion.getValueAt(selectedRow, 2).toString();
                    String localidad = tbl_Direccion.getValueAt(selectedRow, 3).toString();
                    String departamento = tbl_Direccion.getValueAt(selectedRow, 4).toString();
                    String proveedor = tbl_Direccion.getValueAt(selectedRow, 5).toString();

                    // Asignar los valores a los JTextField
                    txt_id.setText(id);
                    txt_calle.setText(calle);
                    txt_numeroPuerta.setText(num_puerta);
                    txt_localidad.setText(localidad);
                    txt_departamento.setText(departamento);
                    cmb_proveedor.setSelectedItem(proveedor);

                    btn_agregar.setEnabled(false);
                    btn_eliminar.setEnabled(true);
                    btn_modificar.setEnabled(true);
                }
            }
        });

    }

    public void cargarDatosCombobox() {
        cmb_proveedor.removeAllItems();
        ArrayList<Proveedor> dataProveedor = ICP.obtenerProveedor();

        for (Proveedor item : dataProveedor) {

            cmb_proveedor.addItem(String.valueOf(item.getNombre()));
            cmbProveedor_id.add(item.getId());
        }
    }

    private void eliminarDireccion(int selectedRow) {
        DefaultTableModel model = (DefaultTableModel) tbl_Direccion.getModel();
        model.removeRow(selectedRow);

    }

    private void cargarDatosEnTabla() {

        String[] columnas = {"ID", "Calle", "Número de puerta", "Localidad", "Departamento", "Proveedor"};
        modeloTabla = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Retornar false para que ninguna celda sea editable
                return false;
            }
        };

        ArrayList<Direccion> direcciones = ICP.obtenerDireccion();
        for (Direccion direccion : direcciones) {
            Object[] fila = {
                direccion.getId(),
                direccion.getCalle(),
                direccion.getNumeroPuerta(),
                direccion.getLocalidad(),
                direccion.getDepartamento(),
                direccion.getProveedor().getNombre(),
                direccion.getProveedor().getId()
            };
            modeloTabla.addRow(fila);
        }

        tbl_Direccion.setModel(modeloTabla);
    }

    private void cargarDatosBuscados(ArrayList<Direccion> DatosBuscados) {
        String[] columnas = {"ID", "Calle", "Número de puerta", "Localidad", "Departamento", "Proveedor"};
        modeloTabla = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Retornar false para que ninguna celda sea editable
                return false;
            }
        };

        for (Direccion direccion : DatosBuscados) {
            Object[] fila = {
                direccion.getId(),
                direccion.getCalle(),
                direccion.getNumeroPuerta(),
                direccion.getLocalidad(),
                direccion.getDepartamento(),
                direccion.getProveedor().getNombre(),
                direccion.getProveedor().getId()
            };
            modeloTabla.addRow(fila);

        }

        tbl_Direccion.setModel(modeloTabla);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Direccion = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        lbl_id = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        lbl_calle = new javax.swing.JLabel();
        lbl_numeroPuerta = new javax.swing.JLabel();
        lbl_localidad = new javax.swing.JLabel();
        lbl_departamento = new javax.swing.JLabel();
        txt_calle = new javax.swing.JTextField();
        txt_numeroPuerta = new javax.swing.JTextField();
        txt_localidad = new javax.swing.JTextField();
        txt_departamento = new javax.swing.JTextField();
        lbl_proveedor = new javax.swing.JLabel();
        cmb_proveedor = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        btn_agregar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lbl_direccion = new javax.swing.JLabel();
        cmb_Atributo = new javax.swing.JComboBox<>();
        btn_Refrescar = new javax.swing.JButton();
        btn_Limpiar = new javax.swing.JButton();
        btn_Buscar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_Buscar = new javax.swing.JTextPane();

        jTextField1.setText("jTextField1");

        setTitle("Direccion");
        setResizable(false);

        tbl_Direccion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Calle", "Número de puerta", "Localidad", "Departamento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_Direccion.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane1.setViewportView(tbl_Direccion);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Nueva dirección"));
        java.awt.GridBagLayout jPanel4Layout = new java.awt.GridBagLayout();
        jPanel4Layout.columnWidths = new int[] {0, 10, 0};
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

        lbl_calle.setText("Calle");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel4.add(lbl_calle, gridBagConstraints);

        lbl_numeroPuerta.setText("Número de puerta");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel4.add(lbl_numeroPuerta, gridBagConstraints);

        lbl_localidad.setText("Localidad");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel4.add(lbl_localidad, gridBagConstraints);

        lbl_departamento.setText("Departamento");
        lbl_departamento.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel4.add(lbl_departamento, gridBagConstraints);

        txt_calle.setActionCommand("txtArticuloNombre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        jPanel4.add(txt_calle, gridBagConstraints);

        txt_numeroPuerta.setActionCommand("txtArticuloDesc");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        jPanel4.add(txt_numeroPuerta, gridBagConstraints);

        txt_localidad.setActionCommand("txtArticuloStock");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        jPanel4.add(txt_localidad, gridBagConstraints);

        txt_departamento.setActionCommand("txtArticuloPrecio");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        jPanel4.add(txt_departamento, gridBagConstraints);

        lbl_proveedor.setText("Proveedor");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel4.add(lbl_proveedor, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        jPanel4.add(cmb_proveedor, gridBagConstraints);

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

        lbl_direccion.setText("Dirección");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.insets = new java.awt.Insets(0, 324, 0, 322);
        jPanel2.add(lbl_direccion, gridBagConstraints);

        cmb_Atributo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Calle", "Número de puerta", "Localidad", "Departamento", "Proveedor" }));

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(btn_Buscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmb_Atributo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_Refrescar)
                .addGap(18, 18, 18)
                .addComponent(btn_Limpiar)
                .addGap(34, 34, 34))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(308, 308, 308)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_Refrescar)
                        .addComponent(cmb_Atributo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_Limpiar))
                    .addComponent(btn_Buscar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(390, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_modificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_modificarMouseClicked
        try {

            int respuesta = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea modificar la direccion?", "Confirmación", JOptionPane.YES_NO_OPTION);
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

            String calle = txt_calle.getText();
            if (calle.isBlank()) {
                throw new Exception("La calle no puede estar vacía.");
            }
            if (calle.length() > 100) {
                throw new Exception("La calle no puede exceder los 100 caracteres.");
            }

            String numPuertaText = txt_numeroPuerta.getText();
            if (numPuertaText.isBlank()) {
                throw new Exception("El número de puerta no puede estar vacío.");
            }
            int num_puerta;
            try {
                num_puerta = Integer.parseInt(numPuertaText);
                if (num_puerta <= 0) {
                    throw new Exception("El número de puerta debe ser un número positivo.");
                }
            } catch (NumberFormatException e) {
                throw new Exception("El número de puerta debe ser un número entero válido.");
            }

            String localidad = txt_localidad.getText();
            if (localidad.isBlank()) {
                throw new Exception("La localidad no puede estar vacía.");
            }
            if (localidad.length() > 100) {
                throw new Exception("La localidad no puede exceder los 100 caracteres.");
            }

            String departamento = txt_departamento.getText();
            if (departamento.isBlank()) {
                throw new Exception("La departamento no puede estar vacía.");
            }
            if (departamento.length() > 100) {
                throw new Exception("La departamento no puede exceder los 100 caracteres.");
            }

            if (cmb_proveedor.getSelectedIndex() < 0) {
                throw new Exception("Debe seleccionar un proveedor.");
            }
            int cmb_id = cmbProveedor_id.get(cmb_proveedor.getSelectedIndex());

            Proveedor nuevoProveedor = new Proveedor();
            nuevoProveedor.setId(cmb_id);

            Direccion direccion = new Direccion(id, calle, num_puerta, localidad, departamento, nuevoProveedor);
            ICP.administradorModificaDireccion(direccion);

            cargarDatosEnTabla();

            txt_id.setText("");
            txt_calle.setText("");
            txt_numeroPuerta.setText("");
            txt_localidad.setText("");
            txt_departamento.setText("");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btn_modificarMouseClicked

    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarActionPerformed
        try {
            if (txt_calle.getText().isBlank()
                    || txt_numeroPuerta.getText().isBlank()
                    || txt_localidad.getText().isBlank()
                    || txt_departamento.getText().isBlank()) {

                throw new Exception("Hay campos vacíos o inválidos");
            }

            Direccion nuevaDireccion = new Direccion();

            nuevaDireccion.setCalle(txt_calle.getText());
            nuevaDireccion.setNumeroPuerta(Integer.parseInt(txt_numeroPuerta.getText()));
            nuevaDireccion.setDepartamento(txt_departamento.getText());
            nuevaDireccion.setLocalidad(txt_localidad.getText());

            int cmb_id = cmbProveedor_id.get(cmb_proveedor.getSelectedIndex());

            Proveedor nuevoProveedor = new Proveedor();
            nuevoProveedor.setId(cmb_id);
            nuevoProveedor.setNombre(cmb_proveedor.getSelectedItem().toString());

            nuevaDireccion.setProveedor(nuevoProveedor);

            if (ICP.agregarDireccion(nuevaDireccion) == true) {
                JOptionPane.showMessageDialog(this, "La direccion se agrego correctamente");
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
        txt_calle.setText("");
        txt_numeroPuerta.setText("");
        txt_localidad.setText("");
        txt_departamento.setText("");
        btn_agregar.setEnabled(true);
        btn_eliminar.setEnabled(false);
        btn_modificar.setEnabled(false);
    }//GEN-LAST:event_btn_LimpiarActionPerformed

    private void btn_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BuscarActionPerformed
        String atributo = cmb_Atributo.getSelectedItem().toString();
        String datoBuscado = txt_Buscar.getText();
        if (datoBuscado == "") {
            JOptionPane.showMessageDialog(this, "Debe ingresar dato a buscar.");
        } else {
            cargarDatosBuscados(ICP.buscarDireccion(atributo, datoBuscado));
        }
    }//GEN-LAST:event_btn_BuscarActionPerformed

    private void btn_eliminarMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_btn_eliminarMouseClicked
        try {
            this.selectedRow = tbl_Direccion.getSelectedRow();
            if (this.selectedRow != -1) {
                int idDireccion = (Integer) tbl_Direccion.getValueAt(selectedRow, 0);
                // Mostrar un diálogo de confirmación
                int confirmacion = JOptionPane.showConfirmDialog(this,
                        "¿Estás seguro de que deseas eliminar esta dirección?", "Confirmar Eliminación",
                        JOptionPane.YES_NO_OPTION);
                if (confirmacion == JOptionPane.YES_OPTION) {
                    if (ICP.eliminarDireccion(idDireccion) == true) {
                        eliminarDireccion(this.selectedRow);
                        txt_id.setText("");
                        txt_calle.setText("");
                        txt_numeroPuerta.setText("");
                        txt_localidad.setText("");
                        txt_departamento.setText("");
                        JOptionPane.showMessageDialog(this, "La dirección se eliminó correctamente.");
                    } else {
                        JOptionPane.showMessageDialog(this, "Hubo un error al eliminar la dirección.");
                    }

                }
            } else {
                JOptionPane.showMessageDialog(this, "Selecciona una dirección para eliminar.");
            }
        } catch (Exception e) {
            e.printStackTrace(); // Puedes cambiar esto por un manejo de errores más adecuado
        } // TODO add your handling code here:
    }// GEN-LAST:event_btn_eliminarMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuDireccion.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuDireccion.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuDireccion.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuDireccion.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuDireccion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Buscar;
    private javax.swing.JButton btn_Limpiar;
    private javax.swing.JButton btn_Refrescar;
    private javax.swing.JButton btn_agregar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JComboBox<String> cmb_Atributo;
    private javax.swing.JComboBox<String> cmb_proveedor;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lbl_calle;
    private javax.swing.JLabel lbl_departamento;
    private javax.swing.JLabel lbl_direccion;
    private javax.swing.JLabel lbl_id;
    private javax.swing.JLabel lbl_localidad;
    private javax.swing.JLabel lbl_numeroPuerta;
    private javax.swing.JLabel lbl_proveedor;
    private javax.swing.JTable tbl_Direccion;
    private javax.swing.JTextPane txt_Buscar;
    private javax.swing.JTextField txt_calle;
    private javax.swing.JTextField txt_departamento;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_localidad;
    private javax.swing.JTextField txt_numeroPuerta;
    // End of variables declaration//GEN-END:variables
}
