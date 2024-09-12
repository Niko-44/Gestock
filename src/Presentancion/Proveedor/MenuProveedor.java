/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Presentancion.Proveedor;

import java.awt.Image;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;
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

        txt_fecha_actualizada.setValue(fechaFormateada); // Establecer el valor formateado
        UIManager.put("OptionPane.yesButtonText", "Sí");//poner el botón yes de la confirmaión en español
        UIManager.put("OptionPane.noButtonText", "No");//poner el botón no de la confirmaión en español

        tbl_Proveedor.getSelectionModel().addListSelectionListener(event -> {
            if (!event.getValueIsAdjusting()) { // Este chequeo asegura que solo se ejecute una vez por selección
                int selectedRow = tbl_Proveedor.getSelectedRow();
                if (selectedRow != -1) {
                    // Obtener los valores de la fila seleccionada
                    String id = tbl_Proveedor.getValueAt(selectedRow, 0).toString();
                    String nombre = tbl_Proveedor.getValueAt(selectedRow, 1).toString();
                    String telefono = tbl_Proveedor.getValueAt(selectedRow, 2).toString();
                    String email = tbl_Proveedor.getValueAt(selectedRow, 3).toString();
                    String update_date = tbl_Proveedor.getValueAt(selectedRow, 4).toString();
                    String create_date = tbl_Proveedor.getValueAt(selectedRow, 5).toString();

                    // Asignar los valores a los JTextField
                    txt_id.setText(id);
                    txt_nombre.setText(nombre);
                    txt_telefono.setText(telefono);
                    txt_email.setText(email);
                    txt_fecha_actualizada.setText(update_date);
                    txt_fecha_creada.setText(create_date);

                }
            }
        });
    }

    private void cargarDatosEnTabla() {
        String[] columnas = {"ID", "Nombre", "Correo", "Telefono", "Fecha Actualización", "Fecha Creación"};
        modeloTabla = new DefaultTableModel(columnas, 0);

        ArrayList<Proveedor> proveedores = ICP.obtenerProveedor();
        for (Proveedor proveedor : proveedores) {
            Object[] fila = {
                proveedor.getId(),
                proveedor.getNombre(),
                proveedor.getTelefonos(),
                proveedor.getEmail(),
                proveedor.getUpdateDate(),
                proveedor.getCreateDate()
            };
            modeloTabla.addRow(fila);
        }

        tbl_Proveedor.setModel(modeloTabla);
    }

    private void eliminarProveedor(int selectedRow) {
        DefaultTableModel model = (DefaultTableModel) tbl_Proveedor.getModel();
        model.removeRow(selectedRow);

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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_fecha_creada = new javax.swing.JTextField();
        txt_fecha_actualizada = new javax.swing.JFormattedTextField();
        jPanel1 = new javax.swing.JPanel();
        btn_agregar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lbl_proveedor = new javax.swing.JLabel();

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
                false, true, true, true, true, true
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

        jLabel1.setText("Fecha actualizada");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel4.add(jLabel1, gridBagConstraints);

        jLabel2.setText("Fecha creado");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel4.add(jLabel2, gridBagConstraints);

        txt_fecha_creada.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel4.add(txt_fecha_creada, gridBagConstraints);

        txt_fecha_actualizada.setEditable(false);
        txt_fecha_actualizada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_fecha_actualizadaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel4.add(txt_fecha_actualizada, gridBagConstraints);

        jPanel1.setMinimumSize(new java.awt.Dimension(325, 23));
        jPanel1.setPreferredSize(new java.awt.Dimension(688, 25));
        jPanel1.setLayout(new java.awt.GridLayout(1, 3, 10, 50));

        btn_agregar.setText("");
        btn_agregar.setActionCommand("jButtonAgregar");
        btn_agregar.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                btn_agregarComponentResized(evt);
            }
        });
        btn_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_agregar);

        btn_eliminar.setActionCommand("jButtonEliminar");
        btn_eliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_eliminarMouseClicked(evt);
            }
        });
        btn_eliminar.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                btn_eliminarComponentResized(evt);
            }
        });
        jPanel1.add(btn_eliminar);

        btn_modificar.setText("Modificar");
        btn_modificar.setActionCommand("jButtonModificar");
        btn_modificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_modificarMouseClicked(evt);
            }
        });
        btn_modificar.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                btn_modificarComponentResized(evt);
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
                        .addComponent(btn_direcciones)
                        .addGap(0, 0, Short.MAX_VALUE))
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
                .addGap(61, 61, 61)
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
        menuDireccion.setVisible(true);
    }//GEN-LAST:event_btn_direccionesActionPerformed

    private void btn_modificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_modificarMouseClicked
        try {

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
            if (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
                throw new Exception("El nombre solo puede contener letras y espacios.");
            }

            String telefono = txt_telefono.getText();
            if (telefono.isBlank()) {
                throw new Exception("El teléfono no puede estar vacío.");
            }
            if (!telefono.isBlank()) {
                if (!telefono.matches("\\d{7,15}")) {
                    throw new Exception("El teléfono debe contener entre 0 y 15 dígitos.");
                }
            }

            String correo = txt_email.getText();
            if (correo.isBlank()) {
                throw new Exception("El correo electrónico no puede estar vacío.");
            }
            if (!correo.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
                throw new Exception("El correo electrónico no tiene un formato válido.");
            }

            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

            // Verificación de la fecha de creación
            String fechaCreadaText = txt_fecha_creada.getText();
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

            JOptionPane.showMessageDialog(this, "El proveedor se ha actualizado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            cargarDatosEnTabla();

            // Limpieza de campos
            txt_id.setText("");
            txt_nombre.setText("");
            txt_telefono.setText("");
            txt_email.setText("");
            txt_fecha_actualizada.setText("");
            txt_fecha_creada.setText("");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_btn_modificarMouseClicked

    private void txt_fecha_actualizadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_fecha_actualizadaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_fecha_actualizadaActionPerformed

    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarActionPerformed
        try {
            Proveedor nuevoProveedor = new Proveedor();

            nuevoProveedor.setNombre(txt_nombre.getText());
            nuevoProveedor.setEmail(txt_email.getText());
            nuevoProveedor.setTelefonos(txt_telefono.getText());
            nuevoProveedor.setUpdateDate(new Date());
            nuevoProveedor.setCreateDate(new Date());

            if (ICP.agregarProveedor(nuevoProveedor) == true) {
                JOptionPane.showMessageDialog(this, "El proveedor se agrego correctamente");

                cargarDatosEnTabla();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_agregarActionPerformed

    private void btn_agregarComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_btn_agregarComponentResized
        int anchoBoton = btn_agregar.getWidth();
        int altoBoton = btn_agregar.getHeight();

        // Cargar la imagen original
        ImageIcon iconoOriginal = new ImageIcon(getClass().getResource("/Iconos/agregar.png"));

        // Redimensionar la imagen al tamaño del botón
        Image imagenRedimensionada = iconoOriginal.getImage().getScaledInstance(anchoBoton, altoBoton, Image.SCALE_SMOOTH);
        ImageIcon iconoRedimensionado = new ImageIcon(imagenRedimensionada);

        // Establecer la imagen redimensionada en el botón
        btn_agregar.setIcon(iconoRedimensionado);
    }//GEN-LAST:event_btn_agregarComponentResized

    private void btn_eliminarComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_btn_eliminarComponentResized
        int anchoBoton = btn_eliminar.getWidth();
        int altoBoton = btn_eliminar.getHeight();

        // Cargar la imagen original
        ImageIcon iconoOriginal = new ImageIcon(getClass().getResource("/Iconos/eliminar.png"));

        // Redimensionar la imagen al tamaño del botón
        Image imagenRedimensionada = iconoOriginal.getImage().getScaledInstance(anchoBoton, altoBoton, Image.SCALE_SMOOTH);
        ImageIcon iconoRedimensionado = new ImageIcon(imagenRedimensionada);

        // Establecer la imagen redimensionada en el botón
        btn_eliminar.setIcon(iconoRedimensionado);
    }//GEN-LAST:event_btn_eliminarComponentResized

    private void btn_modificarComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_btn_modificarComponentResized
        int anchoBoton = btn_modificar.getWidth();
        int altoBoton = btn_modificar.getHeight();

        // Cargar la imagen original
        ImageIcon iconoOriginal = new ImageIcon(getClass().getResource("/Iconos/editar.png"));

        // Redimensionar la imagen al tamaño del botón
        Image imagenRedimensionada = iconoOriginal.getImage().getScaledInstance(anchoBoton, altoBoton, Image.SCALE_SMOOTH);
        ImageIcon iconoRedimensionado = new ImageIcon(imagenRedimensionada);

        // Establecer la imagen redimensionada en el botón
        btn_modificar.setIcon(iconoRedimensionado);
    }//GEN-LAST:event_btn_modificarComponentResized


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_agregar;
    private javax.swing.JButton btn_direcciones;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_email;
    private javax.swing.JLabel lbl_id;
    private javax.swing.JLabel lbl_nombre;
    private javax.swing.JLabel lbl_proveedor;
    private javax.swing.JLabel lbl_telefono;
    private javax.swing.JTable tbl_Proveedor;
    private javax.swing.JTextField txt_email;
    private javax.swing.JFormattedTextField txt_fecha_actualizada;
    private javax.swing.JTextField txt_fecha_creada;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_telefono;
    // End of variables declaration//GEN-END:variables
}
