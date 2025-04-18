/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Presentancion.Ingresa;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import logica.Clases.Articulo;
import logica.Clases.Ingresa;
import logica.Clases.DateLabelFormatter;
import logica.Clases.Proveedor;
import logica.Fabrica;
import logica.Interfaces.IControladorArticulo;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import logica.Fabrica;
import logica.Clases.Ingresa;
import logica.Fabrica;
import logica.Interfaces.IControladorProveedor;

import org.jdatepicker.impl.*;

/**
 *
 * @author Cristian
 */
public class MenuIngresa extends javax.swing.JPanel {

    private IControladorProveedor ICP;
    private IControladorArticulo ICA;

    private int selectedRow;
    Fabrica fabrica = Fabrica.getInstance();
    ArrayList<Integer> articulo_ingresa_id = new ArrayList<>();
    ArrayList<Integer> proveedor_ingresa_id = new ArrayList<>();

    UtilDateModel model = new UtilDateModel();
    Properties p = new Properties();
    JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
    private JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    DefaultTableModel modeloTabla;

    public MenuIngresa() {
        initComponents();
        this.ICP = fabrica.getIControladorProveedor();
        this.ICA = fabrica.getIControladorArticulo();
        cargarDatosEnTabla();
        cargarDatosCombobox();
        agregarDatePicker();

        tbl_Ingresa.getSelectionModel().addListSelectionListener(event -> {
            if (!event.getValueIsAdjusting()) { // Este chequeo asegura que solo se ejecute una vez por selección
                selectedRow = tbl_Ingresa.getSelectedRow();
                if (selectedRow != -1) {
                    // Obtener los valores de la fila seleccionada
                    String id = tbl_Ingresa.getValueAt(selectedRow, 0).toString();
                    String fecha_i = tbl_Ingresa.getValueAt(selectedRow, 1).toString();
                    String cantidad = tbl_Ingresa.getValueAt(selectedRow, 2).toString();
                    String lote = tbl_Ingresa.getValueAt(selectedRow, 3).toString();
                    String precioC = tbl_Ingresa.getValueAt(selectedRow, 4).toString();
                    String proveedor = tbl_Ingresa.getValueAt(selectedRow, 5).toString();
                    String articulo = tbl_Ingresa.getValueAt(selectedRow, 6).toString();

                    
                    Ingresa ingresaFecha = new Ingresa();
                    
                    try {
                        ingresaFecha.setFechaFormateada(fecha_i);
                    } catch (ParseException ex) {
                        Logger.getLogger(MenuIngresa.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    String fechaString = sdf.format(ingresaFecha.getFechaIngreso());
                    // Asignar los valores a los JTextField
                    // Asignar los valores a los JTextField
                    txt_id.setText(id);
                    datePicker.getJFormattedTextField().setText(fechaString);
                    txt_cantidad.setText(cantidad);
                    txt_lote.setText(lote);
                    txt_precioCompra.setText(precioC);
                    cmb_proveedor.setSelectedItem(proveedor);
                    cmb_articulo.setSelectedItem(articulo);

                    btn_agregar.setEnabled(false);
                    btn_modificar.setEnabled(true);
                    btn_eliminar.setEnabled(true);
                }
            }
        });

    }

    public void cargarDatosCombobox() {
        cmb_articulo.removeAllItems();
        cmb_proveedor.removeAllItems();

        ArrayList<Articulo> dataArticulo = ICA.obtenerArticulos(100000);

        for (Articulo item : dataArticulo) {

            cmb_articulo.addItem(item.getNombre());
            articulo_ingresa_id.add(item.getId());
        }

        ArrayList<Proveedor> dataProveedor = ICP.obtenerProveedor();

        for (Proveedor item : dataProveedor) {

            cmb_proveedor.addItem(item.getNombre());
            proveedor_ingresa_id.add(item.getId());
        }
    }

    public void cargarDatosEnTabla() {

        String[] columnas = {"ID", "Fecha Ingreso", "Cantidad", "Lote", "Precio Compra", "Proveedor", "Articulo"};
        modeloTabla = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Retornar false para que ninguna celda sea editable
                return false;
            }
        };

        ArrayList<Ingresa> ingresos = ICP.obtenerIngresosMercaderia();
        for (Ingresa ingreso : ingresos) {
            Object[] fila = {
                ingreso.getIdIngresa(),
                ingreso.getFechaFormateada(), // Cuando necesites mostrarla
                ingreso.getCantidad(),
                ingreso.getLote(),
                ingreso.getPrecioCompra(),
                ingreso.getProveedor().getNombre(),
                ingreso.getArticulo().getNombre()
            };
            modeloTabla.addRow(fila);
        }
        tbl_Ingresa.setModel(modeloTabla);
        this.ICP = Fabrica.getInstance().getIControladorProveedor();
        UIManager.put("OptionPane.yesButtonText", "Sí");//poner el botón yes de la confirmaión en español
        UIManager.put("OptionPane.noButtonText", "No");//poner el botón no de la confirmaión en español
    }

    private void eliminarIngresa(int selectedRow) {
        DefaultTableModel model = (DefaultTableModel) tbl_Ingresa.getModel();
        model.removeRow(selectedRow);

    }

    private void cargarDatosBuscados(ArrayList<Ingresa> DatosBuscados) {
        String[] columnas = {"ID", "Fecha Ingreso", "Cantidad", "Lote", "Precio Compra", "Proveedor", "Articulo"};
        modeloTabla = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Retornar false para que ninguna celda sea editable
                return false;
            }
        };

        for (Ingresa ingreso : DatosBuscados) {
            Object[] fila = {
                ingreso.getIdIngresa(),
                ingreso.getFechaFormateada(),
                ingreso.getCantidad(),
                ingreso.getLote(),
                ingreso.getPrecioCompra(),
                ingreso.getProveedor().getNombre(),
                ingreso.getArticulo().getNombre()
            };
            modeloTabla.addRow(fila);

        }

        tbl_Ingresa.setModel(modeloTabla);
    }

    private void agregarDatePicker() {
        // Configurar el JDatePicker
        p.put("text.today", "Hoy");
        p.put("text.month", "Mes");
        p.put("text.year", "Año");

        // Establecer tamaño preferido para el DatePicker
        datePicker.setPreferredSize(new java.awt.Dimension(200, 30));

        // Quitar el JTextField y agregar el DatePicker en su lugar
        txt_fecha.setVisible(false);  // Ocultar el JTextField
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 2;  // Ajustar el GridBagConstraints según la posición que desees
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;  // Ajustar el componente horizontalmente
        gbc.insets = new Insets(0, 12, 0, 12);  // Márgenes para mayor espacio alrededor

        jPanel4.add(datePicker, gbc);  // Añadir el DatePicker al JPanel
        jPanel4.revalidate();  // Actualizar el layout
        jPanel4.repaint();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Ingresa = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        lbl_id = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        lbl_fechaIngreso = new javax.swing.JLabel();
        lbl_cantidad = new javax.swing.JLabel();
        lbl_lote = new javax.swing.JLabel();
        lbl_precioCompra = new javax.swing.JLabel();
        lbl_articulo = new javax.swing.JLabel();
        lbl_proveedor = new javax.swing.JLabel();
        txt_fecha = new javax.swing.JTextField();
        txt_cantidad = new javax.swing.JTextField();
        txt_lote = new javax.swing.JTextField();
        txt_precioCompra = new javax.swing.JTextField();
        cmb_articulo = new javax.swing.JComboBox<>();
        cmb_proveedor = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        btn_agregar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lbl_ingresa = new javax.swing.JLabel();
        cmb_Atributo = new javax.swing.JComboBox<>();
        btn_Refrescar = new javax.swing.JButton();
        btn_Limpiar = new javax.swing.JButton();
        btn_Buscar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_Buscar = new javax.swing.JTextPane();

        tbl_Ingresa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Fecha Ingreso", "Cantidad", "Lote", "Precio Compra", "Articulo", "Proveedor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_Ingresa.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane1.setViewportView(tbl_Ingresa);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Nuevo ingreso"));
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
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 0, 12);
        jPanel4.add(txt_id, gridBagConstraints);

        lbl_fechaIngreso.setText("Fecha de ingreso");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel4.add(lbl_fechaIngreso, gridBagConstraints);

        lbl_cantidad.setText("Cantidad");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel4.add(lbl_cantidad, gridBagConstraints);

        lbl_lote.setText("Lote");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel4.add(lbl_lote, gridBagConstraints);

        lbl_precioCompra.setText("Precio de compra");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel4.add(lbl_precioCompra, gridBagConstraints);

        lbl_articulo.setText("Artículo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel4.add(lbl_articulo, gridBagConstraints);

        lbl_proveedor.setText("Proveedor");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel4.add(lbl_proveedor, gridBagConstraints);

        txt_fecha.setActionCommand("txtArticuloNombre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(7, 12, 1, 12);
        jPanel4.add(txt_fecha, gridBagConstraints);

        txt_cantidad.setActionCommand("txtArticuloDesc");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(7, 12, 1, 12);
        jPanel4.add(txt_cantidad, gridBagConstraints);

        txt_lote.setActionCommand("txtArticuloStock");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(7, 12, 1, 12);
        jPanel4.add(txt_lote, gridBagConstraints);

        txt_precioCompra.setActionCommand("txtArticuloPrecio");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(7, 12, 1, 12);
        jPanel4.add(txt_precioCompra, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(7, 12, 1, 12);
        jPanel4.add(cmb_articulo, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(7, 12, 1, 12);
        jPanel4.add(cmb_proveedor, gridBagConstraints);

        jPanel1.setMinimumSize(new java.awt.Dimension(325, 23));
        jPanel1.setPreferredSize(new java.awt.Dimension(688, 25));
        jPanel1.setLayout(new java.awt.GridLayout(1, 3, 10, 50));

        btn_agregar.setActionCommand("btn_agregar");
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
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(7, 12, 1, 12);
        jPanel4.add(jPanel1, gridBagConstraints);

        jPanel2.setLayout(new java.awt.GridBagLayout());

        lbl_ingresa.setText("Ingresar mercadería");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.insets = new java.awt.Insets(0, 324, 0, 322);
        jPanel2.add(lbl_ingresa, gridBagConstraints);

        cmb_Atributo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fecha Ingreso", "Cantidad", "Lote", "Precio Compra", "Articulo", "Proveedor" }));

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
                .addGap(60, 60, 60)
                .addComponent(btn_Buscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmb_Atributo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Refrescar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Limpiar)
                .addGap(48, 48, 48))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(317, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_Refrescar)
                        .addComponent(cmb_Atributo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_Limpiar))
                    .addComponent(btn_Buscar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(342, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_eliminarMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_btn_eliminarMouseClicked
        try {
            this.selectedRow = tbl_Ingresa.getSelectedRow();
            if (this.selectedRow != -1) {
                int idIngresa = (Integer) tbl_Ingresa.getValueAt(selectedRow, 0);
                // Mostrar un diálogo de confirmación
                int confirmacion = JOptionPane.showConfirmDialog(this,
                        "¿Estás seguro de que deseas eliminar este ingreso?", "Confirmar Eliminación",
                        JOptionPane.YES_NO_OPTION);
                if (confirmacion == JOptionPane.YES_OPTION) {
                    if (ICP.eliminarIngresa(idIngresa) == true) {
                        eliminarIngresa(this.selectedRow);
                        txt_id.setText("");
                        datePicker.getJFormattedTextField().setText("");
                        txt_cantidad.setText("");
                        txt_lote.setText("");
                        txt_precioCompra.setText("");
                        JOptionPane.showMessageDialog(this, "El ingreso se eliminó correctamente.");
                    } else {
                        JOptionPane.showMessageDialog(this, "Hubo un error al eliminar el ingreso.");
                    }

                }
            } else {
                JOptionPane.showMessageDialog(this, "Selecciona un ingreso para eliminar.");
            }
        } catch (Exception e) {
            e.printStackTrace(); // Puedes cambiar esto por un manejo de errores más adecuado
        } // TODO add your handling code here:
    }// GEN-LAST:event_btn_eliminarMouseClicked

    private void btn_modificarMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_btn_modificarMouseClicked
        try {

            int respuesta = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea modificar el ingreso?", "Confirmación", JOptionPane.YES_NO_OPTION);
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

            String fechaText = datePicker.getJFormattedTextField().getText();
            if (fechaText.isBlank()) {
                throw new Exception("La fecha de ingreso no puede estar vacía.");
            }
            SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
            Date fecha_ingreso;
            try {
                fecha_ingreso = formato.parse(fechaText);
            } catch (ParseException e) {
                throw new Exception("La fecha de ingreso debe tener el formato 'dd-MM-yyyy'.");
            }

            String cantidadText = txt_cantidad.getText();
            if (cantidadText.isBlank()) {
                throw new Exception("La cantidad no puede estar vacía.");
            }
            int cantidad;
            try {
                cantidad = Integer.parseInt(cantidadText);
                if (cantidad <= 0) {
                    throw new Exception("La cantidad debe ser un número positivo.");
                }
            } catch (NumberFormatException e) {
                throw new Exception("La cantidad debe ser un número entero válido.");
            }

            String loteText = txt_lote.getText();
            if (loteText.isBlank()) {
                throw new Exception("El lote no puede estar vacío.");
            }
            int lote;
            try {
                lote = Integer.parseInt(loteText);
                if (lote <= 0) {
                    throw new Exception("El lote debe ser un número positivo.");
                }
            } catch (NumberFormatException e) {
                throw new Exception("El lote debe ser un número entero válido.");
            }

            String precioCText = txt_precioCompra.getText();
            if (precioCText.isBlank()) {
                throw new Exception("El precio de compra no puede estar vacío.");
            }
            float precioC;
            try {
                precioC = Float.parseFloat(precioCText);
                if (precioC <= 0) {
                    throw new Exception("El precio de compra debe ser un número positivo.");
                }
            } catch (NumberFormatException e) {
                throw new Exception("El precio de compra debe ser un número decimal válido.");
            }

            if (cmb_articulo.getSelectedIndex() < 0) {
                throw new Exception("Debe seleccionar un artículo.");
            }
            int articuloCmb_id = articulo_ingresa_id.get(cmb_articulo.getSelectedIndex());

            // Verificación del proveedor seleccionado
            if (cmb_proveedor.getSelectedIndex() < 0) {
                throw new Exception("Debe seleccionar un proveedor.");
            }
            int proveedorCmb_id = proveedor_ingresa_id.get(cmb_proveedor.getSelectedIndex());

            Articulo nuevoArticulo = new Articulo();
            nuevoArticulo.setId(articuloCmb_id);

            Proveedor nuevoProveedor = new Proveedor();
            nuevoProveedor.setId(proveedorCmb_id);

            Ingresa ingresa = new Ingresa(id, fecha_ingreso, cantidad, lote, precioC, nuevoProveedor, nuevoArticulo);
            ICP.modificarDatosIngresa(ingresa);

            cargarDatosEnTabla();

            txt_id.setText("");
            datePicker.getJFormattedTextField().setText("");
            txt_cantidad.setText("");
            txt_lote.setText("");
            txt_precioCompra.setText("");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarActionPerformed
        try {

            if (datePicker.getJFormattedTextField().getText().isBlank()
                    || txt_cantidad.getText().isBlank()
                    || txt_lote.getText().isBlank()
                    || txt_precioCompra.getText().isBlank()) {

                throw new Exception("Hay campos vacíos o inválidos");
            }

            Ingresa nuevoIngreso = new Ingresa();

            // Definir el formato que esperas en el campo de texto
            SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");

            Date fecha_ingreso = formato.parse(datePicker.getJFormattedTextField().getText());

            nuevoIngreso.setFechaIngreso(fecha_ingreso);
            nuevoIngreso.setCantidad(Integer.parseInt(txt_cantidad.getText()));
            nuevoIngreso.setLote(Integer.parseInt(txt_lote.getText()));
            nuevoIngreso.setPrecioCompra(Float.parseFloat(txt_precioCompra.getText()));

            int articuloCmb_id = articulo_ingresa_id.get(cmb_articulo.getSelectedIndex());
            int proveedorCmb_id = proveedor_ingresa_id.get(cmb_proveedor.getSelectedIndex());

            Articulo nuevoArticulo = new Articulo();
            nuevoArticulo.setId(articuloCmb_id);
            nuevoArticulo.setNombre(cmb_articulo.getSelectedItem().toString());

            Proveedor nuevoProveedor = new Proveedor();
            nuevoProveedor.setId(proveedorCmb_id);
            nuevoProveedor.setNombre(cmb_proveedor.getSelectedItem().toString());

            nuevoIngreso.setProveedor(nuevoProveedor);
            nuevoIngreso.setArticulo(nuevoArticulo);

            if (ICP.agregarIngreso(nuevoIngreso) == true) {
                JOptionPane.showMessageDialog(this, "El ingreso se agrego correctamente");

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
        datePicker.getJFormattedTextField().setText("");
        txt_cantidad.setText("");
        txt_lote.setText("");
        txt_precioCompra.setText("");

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
            cargarDatosBuscados(ICP.buscarIngresa(atributo, datoBuscado));
        }
    }//GEN-LAST:event_btn_BuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Buscar;
    private javax.swing.JButton btn_Limpiar;
    private javax.swing.JButton btn_Refrescar;
    private javax.swing.JButton btn_agregar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JComboBox<String> cmb_Atributo;
    private javax.swing.JComboBox<String> cmb_articulo;
    private javax.swing.JComboBox<String> cmb_proveedor;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_articulo;
    private javax.swing.JLabel lbl_cantidad;
    private javax.swing.JLabel lbl_fechaIngreso;
    private javax.swing.JLabel lbl_id;
    private javax.swing.JLabel lbl_ingresa;
    private javax.swing.JLabel lbl_lote;
    private javax.swing.JLabel lbl_precioCompra;
    private javax.swing.JLabel lbl_proveedor;
    private javax.swing.JTable tbl_Ingresa;
    private javax.swing.JTextPane txt_Buscar;
    private javax.swing.JTextField txt_cantidad;
    private javax.swing.JTextField txt_fecha;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_lote;
    private javax.swing.JTextField txt_precioCompra;
    // End of variables declaration//GEN-END:variables
}
