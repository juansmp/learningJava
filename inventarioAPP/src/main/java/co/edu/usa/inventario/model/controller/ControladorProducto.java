/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.usa.inventario.model.controller;

import co.edu.usa.inventario.model.Producto;
import co.edu.usa.inventario.view.Vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import co.edu.usa.inventario.model.repositories.RepositorioProducto;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Administrador
 */
public class ControladorProducto implements ActionListener {

    RepositorioProducto repositorio;
    Vista vista;

    /**
     * Constructor vacío
     */
    public ControladorProducto() {
        super();
    }

    /**
     * Constructor
     *
     * @param repositorio
     * @param vista
     */
    public ControladorProducto(RepositorioProducto repositorio, Vista vista) {
        this.repositorio = repositorio;
        this.vista = vista;
        agregarEventos();
        this.vista.setVisible(true);
        this.ListarProductos();

    }

    /**
     * Método que permite actualizar un producto existente en la base de datos.
     *
     * @param e
     */
    public void ActualizarProducto(ActionEvent e) {

        int fila = vista.getTblInventario().getSelectedRow();
        if (fila >= 0) {
            if (verificarExistencia(
                    new Producto((String) vista.getTblInventario().getValueAt(fila, 1),
                            (Double) vista.getTblInventario().getValueAt(fila, 2),
                            (Integer) vista.getTblInventario().getValueAt(fila, 3)))) {
                Long codigo = (Long) vista.getTblInventario().getValueAt(fila, 0);
                Producto p = repositorio.findById(codigo).get();
                JTextField TxtNombreActualizar = new JTextField(p.getNombre());
                JTextField TxtPrecioActualizar = new JTextField(String.valueOf(p.getPrecio()));
                JTextField TxtInventarioActualizar = new JTextField(String.valueOf(p.getInventario()));
                JPanel PnlActualizar = new JPanel(new GridLayout(0, 1));
                PnlActualizar.add(new JLabel("Nombre: "));
                PnlActualizar.add(TxtNombreActualizar);
                PnlActualizar.add(new JLabel("Precio: "));
                PnlActualizar.add(TxtPrecioActualizar);
                PnlActualizar.add(new JLabel("Inventario: "));
                PnlActualizar.add(TxtInventarioActualizar);
                Integer opcion = JOptionPane.showOptionDialog(vista, PnlActualizar,
                        "Actualizar Producto " + p.getNombre(), JOptionPane.OK_OPTION,
                        JOptionPane.PLAIN_MESSAGE, null, new Object[]{"Actualizar Producto"}, 0);
                if (JOptionPane.OK_OPTION == opcion) {
                    /* Validación de campos vacíos */
                    if ((TxtNombreActualizar.getText().contentEquals(""))
                            || (TxtPrecioActualizar.getText().contentEquals(""))
                            || (TxtInventarioActualizar.getText().contentEquals(""))) {
                        /* Error en la validación de los campos */
                        JOptionPane.showMessageDialog(vista,
                                "Todos los campos son obligatorios.",
                                "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        repositorio.save(new Producto(codigo, TxtNombreActualizar.getText(),
                                Double.parseDouble(TxtPrecioActualizar.getText()),
                                Integer.parseInt(TxtInventarioActualizar.getText())));

                        JOptionPane.showMessageDialog(vista,
                                "El producto fue actualizado exitosamente.");
                    }
                }
            } else {
                /* El producto no existe */
                JOptionPane.showMessageDialog(vista,
                        "Error: El producto no existe.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            /* El producto no se ha seleccionado */
            JOptionPane.showMessageDialog(vista,
                    "Error: Seleccione el producto que desea actualizar.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }

        this.ListarProductos();

    }

    /**
     * Método que permite CrearProducto un producto en la base de datos.
     *
     * @param e
     */
    public void CrearProducto(ActionEvent e) {

        if (validarCampos()) {
            String nombre = vista.getTxtNombre().getText();
            Double precio = Double.parseDouble(vista.getTxtPrecio().getText());
            Integer inventario = Integer.parseInt(vista.getTxtInventario().getText());
            Producto productoCrear = new Producto(nombre, precio, inventario);
            if (!verificarExistencia(productoCrear)) {
                repositorio.save(productoCrear);
            } else {
                /* El producto ya existe */
                JOptionPane.showMessageDialog(vista, "Error: El producto ya existe.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            /* Error en la validación de los campos */
            JOptionPane.showMessageDialog(vista,
                    "Todos los campos son obligatorios.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        this.ListarProductos();
    }

    /**
     * Método que permite eliminar un producto existente en la base de datos.
     *
     * @param e
     */
    public void EliminarProducto(ActionEvent e) {

        int fila = vista.getTblInventario().getSelectedRow();
        if (fila >= 0) {
            Long codigo = (Long) vista.getTblInventario().getValueAt(fila, 0);
            String nombre = (String) vista.getTblInventario().getValueAt(fila, 1);
            Double precio = (Double) vista.getTblInventario().getValueAt(fila, 2);
            Integer inventario = (Integer) vista.getTblInventario().getValueAt(fila, 3);
            Producto productoEliminar = new Producto(nombre, precio, inventario);
            if (verificarExistencia(productoEliminar)) {
                Integer opcion = JOptionPane.showConfirmDialog(vista,
                        "¿Está seguro que desea eliminar el producto \"" + nombre + "\"?");
                if (JOptionPane.OK_OPTION == opcion) {
                    JOptionPane.showMessageDialog(vista,
                            "El producto fue borrado exitosamente.");
                    repositorio.deleteById(codigo);
                }
            } else {
                /* El producto no existe */
                JOptionPane.showMessageDialog(vista,
                        "Error: El producto no existe.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            /* El producto no se ha seleccionado */
            JOptionPane.showMessageDialog(vista,
                    "Error: Seleccione el producto que desea eliminar.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }

        this.ListarProductos();
    }

    /**
     * Método que permite listar los productos existentes en la base de datos.
     */
    public void ListarProductos() {
        List<Producto> listarProducto = (List<Producto>) repositorio.findAll();
        DefaultTableModel modeloTabla = new DefaultTableModel(new Object[]{"Codigo",
            "Nombre", "Precio", "Inventario"}, 0);

        for (Producto p : listarProducto) {
            modeloTabla.addRow(new Object[]{p.getCodigo(), p.getNombre(),
                p.getPrecio(), p.getInventario()});
        }
        vista.getTblInventario().setModel(modeloTabla);

    }

    /**
     * Método que permite generar el informe de los productos existentes en la
     * base de datos. Se obtiene el nombre del producto con el precio mayor; el
     * nombre del producto con el precio menor; el promedio de precios de todos
     * los productos y el valor total del inventario a la fecha.
     *
     * @param e
     */
    public void GenerarInforme(ActionEvent e) {
        //TODO: implementar
    }

    /**
     * Método que elimina todos los productos de la base de datos.
     *
     * @param e
     */
    public void LimpiarProductos(ActionEvent e) {
        Integer opcion = JOptionPane.showConfirmDialog(vista,
                "¿Está seguro que desea eliminar todos los productos?");
        if (JOptionPane.OK_OPTION == opcion) {
            JOptionPane.showMessageDialog(vista,
                    "Se han limpiado los productos de la base de datos");
            repositorio.deleteAll();
        }
        this.ListarProductos();
    }

    /**
     * Método que permite verificar si un producto se encuentra en la base de
     * datos, de acuerdo a su nombre.
     *
     * @param producto
     * @return Retorna verdadero si el producto se encuentra en la base de
     * datos, de lo contrario falso.
     */
    private boolean verificarExistencia(Producto producto) {
        List<Producto> listarProducto = (List<Producto>) repositorio.findAll();

        for (Producto p : listarProducto) {
            if (producto.getNombre().equals(p.getNombre())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Método que permite obtener Id de un producto existente en la base de
     * datos, consultando por el nombre
     *
     * @param producto
     * @return Devuelve el código del producto en la base de datos, si el
     * producto no existe o alguno de los campos no coincide devuelve 0
     */
    private Long obtenerId(Producto producto) {
        Long idProducto = 0L;

        for (Producto p : (List<Producto>) repositorio.findAll()) {
            if (producto.getNombre().equals(p.getNombre())) {
                idProducto = p.getCodigo();
            }
        }
        return idProducto;
    }

    /**
     * Permite validar de los campos de entrada no se encuentren vacíos
     *
     * @return Devuelve falso si alguno de los campos de entrada se encuentra
     * vacío, de lo contrario falso.
     */
    private boolean validarCampos() {
        String nombre = vista.getTxtNombre().getText();
        String precio = vista.getTxtPrecio().getText();
        String inventario = vista.getTxtInventario().getText();
        if ((nombre.contentEquals("")) || (precio.contentEquals(""))
                || (inventario.contentEquals(""))) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Se agregan listeners para los eventos de los botones.
     */
    private void agregarEventos() {
        vista.getBtnAgregar().addActionListener(this);
        vista.getBtnActualizar().addActionListener(this);
        vista.getBtnBorrar().addActionListener(this);
        vista.getBtnLimpiar().addActionListener(this);
        vista.getBtnGenerarInforme().addActionListener(this);
    }

    /**
     * Se conectan los eventos de los botones con los métodos implementados en
     * el controlador.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getBtnAgregar()) {
            CrearProducto(e);
        }
        if (e.getSource() == vista.getBtnActualizar()) {
            ActualizarProducto(e);
        }
        if (e.getSource() == vista.getBtnBorrar()) {
            EliminarProducto(e);
        }
        if (e.getSource() == vista.getBtnLimpiar()) {
            LimpiarProductos(e);
        }
        if (e.getSource() == vista.getBtnGenerarInforme()) {
            GenerarInforme(e);
        }
    }
}
