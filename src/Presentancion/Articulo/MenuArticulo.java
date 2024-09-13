/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Presentancion.Articulo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import logica.Interfaces.IControladorArticulo;

import logica.Clases.Articulo;
import logica.Clases.Categoria;

import logica.Fabrica;

public class MenuArticulo extends javax.swing.JPanel {

    /**
     * Creates new form Listar_Articulo
     */
    IControladorArticulo ICA;
    Fabrica fabrica = Fabrica.getInstance();
    private int selectedRow;

    SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
    DefaultTableModel modeloTabla;

    MenuFabricante fabricante = new MenuFabricante();
    MenuCategoria categoria = new MenuCategoria();

    ArrayList<Integer> id_categoria = new ArrayList<>();
    //ArrayList<Integer> cmbCategoria_id = new ArrayList<>();

    public MenuArticulo() {
        initComponents();

        Date fechaactual = new Date();
        String fechaFormateada = formatoFecha.format(fechaactual);

        txt_fecha_actualizada.setValue(fechaFormateada); // Establecer el valor formateado
        txt_fecha_creada.setText(fechaFormateada);

        this.ICA = fabrica.getIControladorArticulo();
        cargarDatosEnTabla();
        UIManager.put("OptionPane.yesButtonText", "Sí");//poner el botón yes de la confirmaión en español
        UIManager.put("OptionPane.noButtonText", "No");//poner el botón no de la confirmaión en español

        tbl_Articulo.getSelectionModel().addListSelectionListener(event -> {
            if (!event.getValueIsAdjusting()) { // Este chequeo asegura que solo se ejecute una vez por selección
                selectedRow = tbl_Articulo.getSelectedRow();
                if (selectedRow != -1) {
                    // Obtener los valores de la fila seleccionada
                    String id = tbl_Articulo.getValueAt(selectedRow, 0).toString();
                    String sku = tbl_Articulo.getValueAt(selectedRow, 1).toString();
                    String nombre = tbl_Articulo.getValueAt(selectedRow, 2).toString();
                    String descripcion = tbl_Articulo.getValueAt(selectedRow, 3).toString();
                    String stock = tbl_Articulo.getValueAt(selectedRow, 4).toString();
                    String precio = tbl_Articulo.getValueAt(selectedRow, 5).toString();
                    String peso = tbl_Articulo.getValueAt(selectedRow, 6).toString();
                    String fecha_actualizada = tbl_Articulo.getValueAt(selectedRow, 7).toString();
                    String fecha_creada = tbl_Articulo.getValueAt(selectedRow, 8).toString();

                    // Asignar los valores a los JTextField
                    // Asignar los valores a los JTextField
                    txt_id.setText(id);
                    txt_sku.setText(sku);
                    txt_nombre.setText(nombre);
                    txt_descripcion.setText(descripcion);
                    txt_stock.setText(stock);
                    txt_precio.setText(precio);
                    txt_peso.setText(peso);
                    txt_fecha_actualizada.setText(fecha_actualizada);
                    txt_fecha_creada.setText(fecha_creada);
                }
            }
        });

        ArrayList<Articulo> dataArticulo = ICA.obtenerArticulos();

        for (Articulo item : dataArticulo) {

            cmb_id_categoria.addItem(String.valueOf(item.getCategoria().getNombre()));
            id_categoria.add(item.getId());
        }
    }

    private void cargarDatosEnTabla() {
        String[] columnas = {"ID", "SKU", "Articulo", "Descripción", "Stock", "Precio", "Peso", "UpdateDate", "CreateDate", "Categoria"};
        modeloTabla = new DefaultTableModel(columnas, 0);

        ArrayList<Articulo> articulo = ICA.obtenerArticulos();
        for (Articulo articulos : articulo) {
            Object[] fila = {
                articulos.getId(),
                articulos.getSku(),
                articulos.getNombre(),
                articulos.getDescripcion(),
                articulos.getStock(),
                articulos.getPrecio(),
                articulos.getPeso(),
                articulos.getUpdateDate(),
                articulos.getCreateDate(),
                articulos.getCategoria().getNombre()
            };
            modeloTabla.addRow(fila);

        }

        tbl_Articulo.setModel(modeloTabla);
    }

    private void eliminarArticulo(int selectedRow) {
        DefaultTableModel model = (DefaultTableModel) tbl_Articulo.getModel();
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
        tbl_Articulo = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        lbl_Articulo = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lbl_id = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        lbl_sku = new javax.swing.JLabel();
        lbl_nombre = new javax.swing.JLabel();
        lbl_descripcion = new javax.swing.JLabel();
        lbl_stock = new javax.swing.JLabel();
        lbl_precio = new javax.swing.JLabel();
        lbl_peso = new javax.swing.JLabel();
        txt_sku = new javax.swing.JTextField();
        txt_nombre = new javax.swing.JTextField();
        txt_descripcion = new javax.swing.JTextField();
        txt_stock = new javax.swing.JTextField();
        txt_precio = new javax.swing.JTextField();
        txt_peso = new javax.swing.JTextField();
        lbl_fecha_actualizada = new javax.swing.JLabel();
        lbl_fecha_creada = new javax.swing.JLabel();
        txt_fecha_creada = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cmb_id_categoria = new javax.swing.JComboBox<>();
        txt_fecha_actualizada = new javax.swing.JFormattedTextField();
        jPanel1 = new javax.swing.JPanel();
        btn_Agregar = new javax.swing.JButton();
        btn_Eliminar = new javax.swing.JButton();
        btn_Modificar = new javax.swing.JButton();
        btn_categoria = new javax.swing.JButton();
        btn_Fabricante = new javax.swing.JButton();
        btn_Buscar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_Buscar = new javax.swing.JTextPane();
        cmb_Atributo = new javax.swing.JComboBox<>();
        btn_Refrescar = new javax.swing.JButton();
        btn_Limpiar = new javax.swing.JButton();

        setMaximumSize(getPreferredSize());

        tbl_Articulo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Sku", "Nombre", "Descripcion", "Stock", "Precio", "Peso", "Fecha actualizada", "Fecha creada", "ID Categoria"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_Articulo.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tbl_Articulo.setMaximumSize(getPreferredSize());
        jScrollPane1.setViewportView(tbl_Articulo);

        jPanel2.setLayout(new java.awt.GridBagLayout());

        lbl_Articulo.setText("Artículo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.insets = new java.awt.Insets(0, 324, 0, 322);
        jPanel2.add(lbl_Articulo, gridBagConstraints);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Nuevo articulo"));
        java.awt.GridBagLayout jPanel4Layout = new java.awt.GridBagLayout();
        jPanel4Layout.columnWidths = new int[] {0, 10, 0, 10, 0, 10, 0, 10, 0, 10, 0};
        jPanel4Layout.rowHeights = new int[] {0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0};
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
        gridBagConstraints.insets = new java.awt.Insets(1, 0, 0, 0);
        jPanel4.add(txt_id, gridBagConstraints);

        lbl_sku.setText("Sku");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel4.add(lbl_sku, gridBagConstraints);

        lbl_nombre.setText("Nombre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel4.add(lbl_nombre, gridBagConstraints);

        lbl_descripcion.setText("Descripcion");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel4.add(lbl_descripcion, gridBagConstraints);

        lbl_stock.setText("Stock");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel4.add(lbl_stock, gridBagConstraints);

        lbl_precio.setText("Precio");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel4.add(lbl_precio, gridBagConstraints);

        lbl_peso.setText("Peso");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel4.add(lbl_peso, gridBagConstraints);

        txt_sku.setActionCommand("txtArticuloNombre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(1, 0, 0, 0);
        jPanel4.add(txt_sku, gridBagConstraints);

        txt_nombre.setActionCommand("txtArticuloDesc");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(1, 0, 0, 0);
        jPanel4.add(txt_nombre, gridBagConstraints);

        txt_descripcion.setActionCommand("txtArticuloStock");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(1, 0, 0, 0);
        jPanel4.add(txt_descripcion, gridBagConstraints);

        txt_stock.setActionCommand("txtArticuloPrecio");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(1, 0, 0, 0);
        jPanel4.add(txt_stock, gridBagConstraints);

        txt_precio.setActionCommand("txtArticuloPeso");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(1, 0, 0, 0);
        jPanel4.add(txt_precio, gridBagConstraints);

        txt_peso.setActionCommand("txtArticuloSku");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(1, 0, 0, 0);
        jPanel4.add(txt_peso, gridBagConstraints);

        lbl_fecha_actualizada.setText("Fecha actualizada");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel4.add(lbl_fecha_actualizada, gridBagConstraints);

        lbl_fecha_creada.setText("Fecha creada");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel4.add(lbl_fecha_creada, gridBagConstraints);

        txt_fecha_creada.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(1, 0, 0, 0);
        jPanel4.add(txt_fecha_creada, gridBagConstraints);

        jLabel1.setText("Categoria");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel4.add(jLabel1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(1, 0, 0, 0);
        jPanel4.add(cmb_id_categoria, gridBagConstraints);

        txt_fecha_actualizada.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(1, 0, 0, 0);
        jPanel4.add(txt_fecha_actualizada, gridBagConstraints);

        jPanel1.setMaximumSize(getPreferredSize());
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
        btn_Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ModificarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Modificar);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 20;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel4.add(jPanel1, gridBagConstraints);

        btn_categoria.setText("Categorías");
        btn_categoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_categoriaMouseClicked(evt);
            }
        });
        btn_categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_categoriaActionPerformed(evt);
            }
        });

        btn_Fabricante.setText("Fabricante");
        btn_Fabricante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_FabricanteMouseClicked(evt);
            }
        });
        btn_Fabricante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_FabricanteActionPerformed(evt);
            }
        });

        btn_Buscar.setText("Buscar");
        btn_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BuscarActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(txt_Buscar);

        cmb_Atributo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombre", "Descripcion", "SKU" }));

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 734, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(btn_Buscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmb_Atributo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Refrescar)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Limpiar)
                        .addGap(15, 15, 15))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_Fabricante, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_Refrescar)
                        .addComponent(cmb_Atributo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_Limpiar))
                    .addComponent(btn_Buscar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_categoria)
                    .addComponent(btn_Fabricante))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_AgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_AgregarMouseClicked

    }//GEN-LAST:event_btn_AgregarMouseClicked

    private void btn_categoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_categoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_categoriaActionPerformed

    private void btn_categoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_categoriaMouseClicked

        categoria.setVisible(true);
    }//GEN-LAST:event_btn_categoriaMouseClicked

    private void btn_FabricanteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_FabricanteMouseClicked

    }//GEN-LAST:event_btn_FabricanteMouseClicked

    private void btn_ModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ModificarMouseClicked
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

            String skuText = txt_sku.getText();
            if (skuText.isBlank()) {
                throw new Exception("El SKU no puede estar vacío.");
            }
            int sku;
            try {
                sku = Integer.parseInt(skuText);
                if (sku <= 0) {
                    throw new Exception("El SKU debe ser un número positivo.");
                }
            } catch (NumberFormatException e) {
                throw new Exception("El SKU debe ser un número entero válido.");
            }

            String nombre = txt_nombre.getText();
            if (nombre.isBlank()) {
                throw new Exception("El nombre no puede estar vacío.");
            }
            if (nombre.length() > 50) {
                throw new Exception("El nombre no puede exceder los 50 caracteres.");
            }
            

            String descripcion = txt_descripcion.getText();
            if (descripcion.isBlank()) {
                throw new Exception("La descripción no puede estar vacía.");
            }
            if (descripcion.length() > 100) {
                throw new Exception("La descripción no puede exceder los 100 caracteres.");
            }
            
                
            

            String stockText = txt_stock.getText();
            if (stockText.isBlank()) {
                throw new Exception("El stock no puede estar vacío.");
            }
            int stock;
            try {
                stock = Integer.parseInt(stockText);
                if (stock < 0) {
                    throw new Exception("El stock no puede ser negativo.");
                }
            } catch (NumberFormatException e) {
                throw new Exception("El stock debe ser un número entero válido.");
            }

            String precioText = txt_precio.getText();
            if (precioText.isBlank()) {
                throw new Exception("El precio no puede estar vacío.");
            }
            float precio;
            try {
                precio = Float.parseFloat(precioText);
                if (precio < 0) {
                    throw new Exception("El precio no puede ser negativo.");
                }
            } catch (NumberFormatException e) {
                throw new Exception("El precio debe ser un número decimal válido.");
            }

            String pesoText = txt_peso.getText();
            if (pesoText.isBlank()) {
                throw new Exception("El peso no puede estar vacío.");
            }
            float peso;
            try {
                peso = Float.parseFloat(pesoText);
                if (peso < 0) {
                    throw new Exception("El peso no puede ser negativo.");
                }
            } catch (NumberFormatException e) {
                throw new Exception("El peso debe ser un número decimal válido.");
            }

            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

            String fechaCreadaText = txt_fecha_creada.getText();
            Date create_date;
            try {
                create_date = formato.parse(fechaCreadaText);
            } catch (ParseException e) {
                throw new Exception("La fecha de creación debe tener el formato 'yyyy-MM-dd'.");
            }

            int selectedIndex = cmb_id_categoria.getSelectedIndex();
            if (selectedIndex < 0) {
                throw new Exception("Debe seleccionar una categoría.");
            }
            int Cmb_id = id_categoria.get(selectedIndex);
            Categoria nuevaCategoria = new Categoria();
            nuevaCategoria.setId(Cmb_id);

            Articulo articulo = new Articulo(id, sku, nombre, descripcion, stock, precio, peso, new Date(), create_date, nuevaCategoria);
            ICA.modificaDatosArticulo(articulo);

            JOptionPane.showMessageDialog(this, "El artículo se ha actualizado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            cargarDatosEnTabla();

            txt_id.setText("");
            txt_sku.setText("");
            txt_nombre.setText("");
            txt_descripcion.setText("");
            txt_stock.setText("");
            txt_precio.setText("");
            txt_peso.setText("");
            txt_fecha_actualizada.setText("");
            txt_fecha_creada.setText("");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btn_ModificarMouseClicked

    private void btn_FabricanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_FabricanteActionPerformed

        fabricante.setVisible(true);
    }//GEN-LAST:event_btn_FabricanteActionPerformed

    private void btn_EliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_EliminarMouseClicked
        try {
            if (this.selectedRow != -1) {
                int idArticulo = (Integer) tbl_Articulo.getValueAt(selectedRow, 0);
                // Mostrar un diálogo de confirmación
                int confirmacion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que deseas eliminar este artículo?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
                if (confirmacion == JOptionPane.YES_OPTION) {
                    if (ICA.eliminarArticulo(idArticulo) == true) {
                        eliminarArticulo(this.selectedRow);
                        JOptionPane.showMessageDialog(this, "El artículo se eliminó correctamente.");
                    } else {
                        JOptionPane.showMessageDialog(this, "Hubo un error al eliminar el artículo.");
                    }

                }
            } else {
                JOptionPane.showMessageDialog(this, "Selecciona un artíuclo para eliminar.");
            }
        } catch (Exception e) {
            e.printStackTrace(); // Puedes cambiar esto por un manejo de errores más adecuado
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btn_EliminarMouseClicked

    private void btn_AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AgregarActionPerformed
        try {

            if (txt_nombre.getText().isBlank()
                    || txt_descripcion.getText().isBlank()
                    || txt_sku.getText().isBlank()
                    || txt_stock.getText().isBlank()
                    || txt_precio.getText().isBlank()
                    || txt_peso.getText().isBlank()
                    || txt_fecha_actualizada.getText().isBlank()
                    || txt_fecha_creada.getText().isBlank()
                    || cmb_id_categoria.getSelectedItem() == null) {

                throw new Exception("Hay campos vacíos o inválidos");
            }

            String categoria = (String) cmb_id_categoria.getSelectedItem();

            int categoriaID = id_categoria.get(cmb_id_categoria.getSelectedIndex());

            Categoria nuevaCategoria = new Categoria();
            nuevaCategoria.setId(categoriaID);
            nuevaCategoria.setNombre(cmb_id_categoria.getSelectedItem().toString());

            Articulo nuevoArticulo = new Articulo();

            nuevoArticulo.setCategoria(nuevaCategoria);
            nuevoArticulo.setNombre(txt_nombre.getText());
            nuevoArticulo.setDescripcion(txt_descripcion.getText());
            nuevoArticulo.setSku(Integer.parseInt(txt_sku.getText()));
            nuevoArticulo.setStock(Integer.parseInt(txt_stock.getText()));
            nuevoArticulo.setPrecio(Float.parseFloat(txt_precio.getText()));
            nuevoArticulo.setPeso(Float.parseFloat(txt_peso.getText()));
            nuevoArticulo.setUpdateDate(new Date());
            nuevoArticulo.setCreateDate(new Date());

            if (ICA.agregarArticulo(nuevoArticulo) == true) {
                JOptionPane.showMessageDialog(this, "El articulo se agrego correctamente");

                cargarDatosEnTabla();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_AgregarActionPerformed

    private void btn_ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ModificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_ModificarActionPerformed

    private void cargarDatosBuscados(ArrayList<Articulo> DatosBuscados) {
        String[] columnas = {"SKU", "Nombre", "Descripción", "Stock", "Precio", "Peso", "UpdateDate", "CreateDate", "Categoria"};
        modeloTabla = new DefaultTableModel(columnas, 0);

        for (Articulo articulos : DatosBuscados) {
            Object[] fila = {
                articulos.getSku(),
                articulos.getDescripcion(),
                articulos.getNombre(),
                
                articulos.getStock(),
                articulos.getPrecio(),
                articulos.getPeso(),
                articulos.getUpdateDate(),
                articulos.getCreateDate(),
                articulos.getCategoria().getNombre()
            };
            modeloTabla.addRow(fila);

        }

        tbl_Articulo.setModel(modeloTabla);
    }
    
    private void btn_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BuscarActionPerformed
        String atributo = cmb_Atributo.getSelectedItem().toString();
        String datoBuscado = txt_Buscar.getText();
        if(datoBuscado == ""){
            JOptionPane.showMessageDialog(this, "Debe ingresar dato a buscar.");
        }
        else
            cargarDatosBuscados(ICA.buscarArticulo(datoBuscado, atributo));
          
    }//GEN-LAST:event_btn_BuscarActionPerformed

    private void btn_RefrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RefrescarActionPerformed
       cargarDatosEnTabla();
    }//GEN-LAST:event_btn_RefrescarActionPerformed

    private void btn_LimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LimpiarActionPerformed
        txt_descripcion.setText("");
        txt_id.setText("");
        txt_nombre.setText("");
        txt_peso.setText("");
        txt_peso.setText("");
        txt_precio.setText("");
        txt_sku.setText("");
        txt_stock.setText("");
    }//GEN-LAST:event_btn_LimpiarActionPerformed
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
            java.util.logging.Logger.getLogger(MenuArticulo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuArticulo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuArticulo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuArticulo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuArticulo().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Agregar;
    private javax.swing.JButton btn_Buscar;
    private javax.swing.JButton btn_Eliminar;
    private javax.swing.JButton btn_Fabricante;
    private javax.swing.JButton btn_Limpiar;
    private javax.swing.JButton btn_Modificar;
    private javax.swing.JButton btn_Refrescar;
    private javax.swing.JButton btn_categoria;
    private javax.swing.JComboBox<String> cmb_Atributo;
    private javax.swing.JComboBox<String> cmb_id_categoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_Articulo;
    private javax.swing.JLabel lbl_descripcion;
    private javax.swing.JLabel lbl_fecha_actualizada;
    private javax.swing.JLabel lbl_fecha_creada;
    private javax.swing.JLabel lbl_id;
    private javax.swing.JLabel lbl_nombre;
    private javax.swing.JLabel lbl_peso;
    private javax.swing.JLabel lbl_precio;
    private javax.swing.JLabel lbl_sku;
    private javax.swing.JLabel lbl_stock;
    private javax.swing.JTable tbl_Articulo;
    private javax.swing.JTextPane txt_Buscar;
    private javax.swing.JTextField txt_descripcion;
    private javax.swing.JFormattedTextField txt_fecha_actualizada;
    private javax.swing.JTextField txt_fecha_creada;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_peso;
    private javax.swing.JTextField txt_precio;
    private javax.swing.JTextField txt_sku;
    private javax.swing.JTextField txt_stock;
    // End of variables declaration//GEN-END:variables
}
