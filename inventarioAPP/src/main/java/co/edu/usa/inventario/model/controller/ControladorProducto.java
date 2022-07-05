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
import javax.swing.JOptionPane;

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
        String nombre = vista.getTxtNombre().getText();
        Double precio = Double.parseDouble(vista.getTxtPrecio().getText());
        Integer inventario = Integer.parseInt(vista.getTxtInventario().getText());
        Producto productoActualizar = new Producto(nombre, precio, inventario);
        if (verificarExistencia(productoActualizar) && validarCampos()) {

        } else {

        }

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
                JOptionPane.showMessageDialog(vista, "Error: El producto ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            /* Error en la validación de los campos */
            JOptionPane.showMessageDialog(vista, "Error: Verifique que todos los campos estén completos.", "Error", JOptionPane.ERROR_MESSAGE);
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
                repositorio.deleteById(codigo);
            } else {
                /* El producto no existe */
                JOptionPane.showMessageDialog(vista, "Error: El producto no existe.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            /* El producto no se ha seleccionado */
            JOptionPane.showMessageDialog(vista, "Error: Seleccione el producto que desea eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        this.ListarProductos();
    }

    /**
     * Método que permite listar los productos existentes en la base de datos.
     */
    public void ListarProductos() {
        List<Producto> listarProducto = (List<Producto>) repositorio.findAll();
        DefaultTableModel modeloTabla = new DefaultTableModel(new Object[]{"Codigo", "Nombre", "Precio", "Inventario"}, 0);

        for (Producto p : listarProducto) {
            modeloTabla.addRow(new Object[]{p.getCodigo(), p.getNombre(), p.getPrecio(), p.getInventario()});
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
        Integer opcion = JOptionPane.showConfirmDialog(vista, "¿Está seguro que desea eliminar todos los productos?");
        if (0 == opcion) {
            JOptionPane.showMessageDialog(vista, "Se han limpiado los productos de la base de datos");
            repositorio.deleteAll();
        }
        this.ListarProductos();
    }

    private boolean verificarExistencia(Producto productoEntrada) {
        List<Producto> listarProducto = (List<Producto>) repositorio.findAll();

        for (Producto p : listarProducto) {
            if (productoEntrada.getNombre().equals(p.getNombre())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Método que permite obtener Id de un producto existente en la base de
     * datos
     *
     * @param productoEntrada
     * @return Devuelve el código del producto en la base de datos, si el
     * producto no existe o alguno de los campos no coincide devuelve 0
     */
    private Long obtenerId(Producto productoEntrada) {
        Long idProducto = 0L;

        for (Producto p : (List<Producto>) repositorio.findAll()) {
            if ((productoEntrada.getNombre().equals(p.getNombre()))
                    && (productoEntrada.getInventario().equals(p.getInventario()))
                    && (productoEntrada.getPrecio().equals(p.getPrecio()))) {
                idProducto = p.getCodigo();
            }
        }
        return idProducto;
    }

    private boolean validarCampos() {
        String nombre = vista.getTxtNombre().getText();
        String precio = vista.getTxtPrecio().getText();
        String inventario = vista.getTxtInventario().getText();
        if ((nombre.contentEquals("")) || (precio.contentEquals("")) || (inventario.contentEquals(""))) {
            return false;
        } else {
            return true;
        }
    }

    private void agregarEventos() {
        vista.getBtnAgregar().addActionListener(this);
        vista.getBtnActualizar().addActionListener(this);
        vista.getBtnBorrar().addActionListener(this);
        vista.getBtnLimpiar().addActionListener(this);
        vista.getBtnGenerarInforme().addActionListener(this);
    }

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
