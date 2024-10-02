/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Presentancion.Articulo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import logica.Clases.Articulo;
import logica.Clases.Categoria;
import logica.Clases.Fabricante;
import logica.Fabrica;
import logica.Interfaces.IControladorArticulo;

/**
 *
 * @author Luciano
 */
public class MenuFabricante extends javax.swing.JFrame {

    IControladorArticulo ICA;
    private int selectedRow;
    DefaultTableModel modeloTabla;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    public MenuFabricante() {
        initComponents();
        this.ICA = Fabrica.getInstance().getIControladorArticulo();
        cargarDatosEnTabla();
        UIManager.put("OptionPane.yesButtonText", "Sí");//poner el botón yes de la confirmaión en español
        UIManager.put("OptionPane.noButtonText", "No");//poner el botón no de la confirmaión en español

        Date fechaactual = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        String fechaFormateada = formatoFecha.format(fechaactual);

        tbl_Fabricante.getSelectionModel().addListSelectionListener(event -> {
            if (!event.getValueIsAdjusting()) { // Este chequeo asegura que solo se ejecute una vez por selección
                selectedRow = tbl_Fabricante.getSelectedRow();
                if (selectedRow != -1) {
                    // Obtener los valores de la fila seleccionada
                    String id = tbl_Fabricante.getValueAt(selectedRow, 0).toString();
                    String nombre = tbl_Fabricante.getValueAt(selectedRow, 1).toString();
                    String telefono = tbl_Fabricante.getValueAt(selectedRow, 2).toString();
                    String correo = tbl_Fabricante.getValueAt(selectedRow, 3).toString();
                    String fecha_actualizada = tbl_Fabricante.getValueAt(selectedRow, 4).toString();
                    String fecha_creada = tbl_Fabricante.getValueAt(selectedRow, 5).toString();

                    // Asignar los valores a los JTextField
                    // Asignar los valores a los JTextField
                    txt_id.setText(id);
                    txt_nombre.setText(nombre);
                    txt_correo.setText(correo);
                    txt_telefono.setText(telefono);
                    btn_Agregar.setEnabled(false);
                    btn_Modificar.setEnabled(true);
                    btn_Eliminar.setEnabled(true);
                }
            }
        });
    }

    private void cargarDatosEnTabla() {
        String[] columnas = {"ID", "Nombre", "Telefono", "Correo", "Fecha Actualización", "Fecha Creación"};
        modeloTabla = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Retornar false para que ninguna celda sea editable
                return false;
            }
        };

        ArrayList<Fabricante> fabricantes = ICA.obtenerFabricantes();
        for (Fabricante fabricante : fabricantes) {
            Object[] fila = {
                fabricante.getId(),
                fabricante.getNombre(),
                fabricante.getCorreo(),
                fabricante.getTelefono(),
                fabricante.getFechaUpdateFormateada(),
                fabricante.getFechaCreadaFormateada()
            };
            modeloTabla.addRow(fila);

        }

        tbl_Fabricante.setModel(modeloTabla);
    }

    private void cargarDatosBuscados(ArrayList<Fabricante> DatosBuscados) {
        String[] columnas = {"ID", "Nombre", "Telefono", "Correo", "Fecha Actualización", "Fecha Creación"};
        modeloTabla = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Retornar false para que ninguna celda sea editable
                return false;
            }
        };

        for (Fabricante fabricantes : DatosBuscados) {
            Object[] fila = {
                fabricantes.getId(),
                fabricantes.getNombre(),
                fabricantes.getCorreo(),
                fabricantes.getTelefono(),
                fabricantes.getFechaUpdateFormateada(),
                fabricantes.getFechaCreadaFormateada()
            };
            modeloTabla.addRow(fila);

        }

        tbl_Fabricante.setModel(modeloTabla);
    }

    private void eliminarFabricante(int selectedRow) {
        DefaultTableModel model = (DefaultTableModel) tbl_Fabricante.getModel();
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
        tbl_Fabricante = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        lbl_Fabricante = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lbl_id = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        lbl_nombre = new javax.swing.JLabel();
        lbl_telefono = new javax.swing.JLabel();
        lbl_correo = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        txt_telefono = new javax.swing.JTextField();
        txt_correo = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btn_Agregar = new javax.swing.JButton();
        btn_Eliminar = new javax.swing.JButton();
        btn_Modificar = new javax.swing.JButton();
        btn_volver = new javax.swing.JButton();
        btn_Buscar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_Buscar = new javax.swing.JTextPane();
        cmb_Atributo = new javax.swing.JComboBox<>();
        btn_Refrescar = new javax.swing.JButton();
        btn_Limpiar = new javax.swing.JButton();

        setTitle("Fabricante");
        setResizable(false);
        setSize(new java.awt.Dimension(1920, 1080));

        tbl_Fabricante.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Telefono", "Correo", "Fecha actualizada", "Fecha creada"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_Fabricante.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane1.setViewportView(tbl_Fabricante);

        jPanel2.setLayout(new java.awt.GridBagLayout());

        lbl_Fabricante.setText("Fabricante");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.insets = new java.awt.Insets(0, 324, 0, 322);
        jPanel2.add(lbl_Fabricante, gridBagConstraints);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Nuevo fabricante"));
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
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(8, 10, 0, 10);
        jPanel4.add(txt_id, gridBagConstraints);

        lbl_nombre.setText("Nombre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel4.add(lbl_nombre, gridBagConstraints);

        lbl_telefono.setText("Telefono");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel4.add(lbl_telefono, gridBagConstraints);

        lbl_correo.setText("Correo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel4.add(lbl_correo, gridBagConstraints);

        txt_nombre.setActionCommand("txtArticuloNombre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(8, 10, 0, 10);
        jPanel4.add(txt_nombre, gridBagConstraints);

        txt_telefono.setActionCommand("txtArticuloDesc");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(8, 10, 0, 10);
        jPanel4.add(txt_telefono, gridBagConstraints);

        txt_correo.setActionCommand("txtArticuloStock");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(8, 10, 0, 10);
        jPanel4.add(txt_correo, gridBagConstraints);

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
        btn_Eliminar.setEnabled(false);
        btn_Eliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_EliminarMouseClicked(evt);
            }
        });
        jPanel1.add(btn_Eliminar);

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
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(8, 10, 0, 10);
        jPanel4.add(jPanel1, gridBagConstraints);

        btn_volver.setText("Volver");
        btn_volver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_volverMouseClicked(evt);
            }
        });

        btn_Buscar.setText("Buscar");
        btn_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BuscarActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(txt_Buscar);

        cmb_Atributo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombre", "Telefono", "Email", " " }));

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_Buscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmb_Atributo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Refrescar)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Limpiar))
                    .addComponent(btn_volver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_Refrescar)
                        .addComponent(cmb_Atributo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_Limpiar))
                    .addComponent(btn_Buscar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_volver)
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_volverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_volverMouseClicked
        MenuArticulo articulo = new MenuArticulo();
        articulo.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_volverMouseClicked

    private void btn_ModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ModificarMouseClicked
        try {

            int respuesta = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea modificar este Fabricante?", "Confirmación", JOptionPane.YES_NO_OPTION);
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
                throw new Exception("El campo de telefono esta vacio");
            }

            String correo = txt_correo.getText();
            if (correo.isBlank()) {
                throw new Exception("El correo no puede estar vacío.");
            }
            if (correo.length() > 100) {
                throw new Exception("El correo no puede exceder los 100 caracteres.");
            }

            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            
             Date fechaActual = new Date();
            String fechaCreadaText = formato.format(fechaActual);;
            Date create_date;
            try {
                create_date = formato.parse(fechaCreadaText);
            } catch (ParseException e) {
                throw new Exception("La fecha de creación debe tener el formato 'yyyy-MM-dd'.");
            }

            Fabricante fabricante = new Fabricante(id, nombre, telefono, correo, new Date(), create_date);
            ICA.modificaDatosFabricante(fabricante);

            cargarDatosEnTabla();

            txt_id.setText("");
            txt_nombre.setText("");
            txt_telefono.setText("");
            txt_correo.setText("");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_btn_ModificarMouseClicked

    private void btn_EliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_EliminarMouseClicked
        try {
            this.selectedRow = tbl_Fabricante.getSelectedRow();
            if (this.selectedRow != -1) {
                int idFabricante = (Integer) tbl_Fabricante.getValueAt(selectedRow, 0);
                // Mostrar un diálogo de confirmación
                int confirmacion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que deseas eliminar este fabricante?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
                if (confirmacion == JOptionPane.YES_OPTION) {
                    if (ICA.eliminarFabricante(idFabricante) == true) {
                        eliminarFabricante(this.selectedRow);
                        JOptionPane.showMessageDialog(this, "El fabricante se eliminó correctamente.");
                    } else {
                        JOptionPane.showMessageDialog(this, "Hubo un error al eliminar el fabricante.");
                    }

                }
            } else {
                JOptionPane.showMessageDialog(this, "Selecciona un fabricante para eliminar.");
            }
        } catch (Exception e) {
            e.printStackTrace(); // Puedes cambiar esto por un manejo de errores más adecuado
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btn_EliminarMouseClicked

    private void btn_AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AgregarActionPerformed
        try {

            if (txt_nombre.getText().isBlank()
                    || txt_telefono.getText().isBlank()
                    || txt_correo.getText().isBlank()) {

                throw new Exception("Hay campos vacíos o inválidos");
            }

            Fabricante nuevoFabricante = new Fabricante();

            nuevoFabricante.setNombre(txt_nombre.getText());
            nuevoFabricante.setCorreo(txt_correo.getText());
            nuevoFabricante.setTelefono(txt_telefono.getText());
            nuevoFabricante.setUpdateDate(new Date());
            nuevoFabricante.setCreateDate(new Date());

            if (ICA.agregarFabricante(nuevoFabricante) == true) {
                JOptionPane.showMessageDialog(this, "El fabricante se agrego correctamente");

                cargarDatosEnTabla();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_AgregarActionPerformed

    private void btn_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BuscarActionPerformed
        String atributo = cmb_Atributo.getSelectedItem().toString();
        String datoBuscado = txt_Buscar.getText();

        if (atributo == "Nombre") {
            atributo = "nombre_fabricante";
        }

        if (datoBuscado == "") {
            JOptionPane.showMessageDialog(this, "Debe ingresar dato a buscar.");
        } else
            cargarDatosBuscados(ICA.buscarFabricante(datoBuscado, atributo));
    }//GEN-LAST:event_btn_BuscarActionPerformed

    private void btn_RefrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RefrescarActionPerformed
        cargarDatosEnTabla();
        btn_Agregar.setEnabled(true);
    }//GEN-LAST:event_btn_RefrescarActionPerformed

    private void btn_LimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LimpiarActionPerformed

        txt_id.setText("");
        txt_nombre.setText("");
        txt_correo.setText("");
        txt_telefono.setText("");

        btn_Agregar.setEnabled(true);
        btn_Modificar.setEnabled(false);
        btn_Eliminar.setEnabled(false);
    }//GEN-LAST:event_btn_LimpiarActionPerformed

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
            java.util.logging.Logger.getLogger(MenuFabricante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuFabricante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuFabricante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuFabricante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuFabricante().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Agregar;
    private javax.swing.JButton btn_Buscar;
    private javax.swing.JButton btn_Eliminar;
    private javax.swing.JButton btn_Limpiar;
    private javax.swing.JButton btn_Modificar;
    private javax.swing.JButton btn_Refrescar;
    private javax.swing.JButton btn_volver;
    private javax.swing.JComboBox<String> cmb_Atributo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_Fabricante;
    private javax.swing.JLabel lbl_correo;
    private javax.swing.JLabel lbl_id;
    private javax.swing.JLabel lbl_nombre;
    private javax.swing.JLabel lbl_telefono;
    private javax.swing.JTable tbl_Fabricante;
    private javax.swing.JTextPane txt_Buscar;
    private javax.swing.JTextField txt_correo;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_telefono;
    // End of variables declaration//GEN-END:variables
}
