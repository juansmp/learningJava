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

/**
 *
 * @author Administrador
 */
public class ControladorProducto implements ActionListener{

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
     * @param e 
     */
    public void ActualizarProducto(ActionEvent e){
        String nombre = vista.getTxtNombre().getText();
        Double precio = Double.parseDouble(vista.getTxtPrecio().getText());
        Integer inventario = Integer.parseInt(vista.getTxtInventario().getText());
        Producto productoActualizar = new Producto(nombre, precio, inventario);
        if(verificarExistencia(productoActualizar) && validarCampos()){
            
        }else{
            
        }
        
    }
    /**
     * Método que permite CrearProducto un producto en la base de datos.     
     * @param e
     */
    public void CrearProducto(ActionEvent e){
        
        if(validarCampos()){
            String nombre = vista.getTxtNombre().getText();
            Double precio = Double.parseDouble(vista.getTxtPrecio().getText());
            Integer inventario = Integer.parseInt(vista.getTxtInventario().getText());
            Producto productoCrear = new Producto(nombre, precio, inventario);
            if(!verificarExistencia(productoCrear)){
                repositorio.save(productoCrear);
            }else{

            }
        }else{
        
        }
        this.ListarProductos();        
    }
    
    /**
     * Método que permite listar los productos existentes en la base de datos.
     */
    public void ListarProductos(){
        List<Producto>  listarProducto = (List<Producto>) repositorio.findAll();
        DefaultTableModel modeloTabla = new DefaultTableModel(new Object[]{"Codigo", "Nombre", "Precio", "Inventario"}, 0);
        
        for(Producto p : listarProducto){
            modeloTabla.addRow(new Object[]{p.getCodigo(),p.getNombre(),p.getPrecio(),p.getInventario()} );
        }
        vista.getTblInventario().setModel(modeloTabla);
        
    }
    
    
    /**
     * Método que permite eliminar un producto existente en la base de datos.
     * @param e 
     */
    public void EliminarProducto(ActionEvent e){
        String nombre = vista.getTxtNombre().getText();
        Double precio = Double.parseDouble(vista.getTxtPrecio().getText());
        Integer inventario = Integer.parseInt(vista.getTxtInventario().getText());
        Producto productoEliminar = new Producto(nombre, precio, inventario);
        if(verificarExistencia(productoEliminar)){
            
        }
        
    }
    
    /**
     * Método que permite generar el informe de los productos existentes en la base de datos.
     * Se obtiene el nombre del producto con el precio mayor; el nombre del producto con el 
     * precio menor; el promedio de precios de todos los productos y el valor total del 
     * inventario a la fecha.
     * @param e 
     */    
    public void GenerarInforme(ActionEvent e){
        
    }
    
    private boolean verificarExistencia(Producto productoEntrada){
         List<Producto>  listarProducto = (List<Producto>) repositorio.findAll();
        
        for(Producto p : listarProducto){
            if(productoEntrada.getNombre().equals(p.getNombre())){
                return true;
            }           
        }
        return false;
    }
    
    private boolean validarCampos(){
        String nombre = vista.getTxtNombre().getText();
        String precio = vista.getTxtPrecio().getText();
        String inventario = vista.getTxtInventario().getText();
        if((nombre.contentEquals("")) || (precio.contentEquals("")) || (inventario.contentEquals(""))){
            return false;
        }else{
            return true;
        }
    }
    
    
    
    
    
    private void agregarEventos(){
        vista.getBtnAgregar().addActionListener(this);
        vista.getBtnActualizar().addActionListener(this);
        vista.getBtnBorrar().addActionListener(this);
        vista.getBtnLimpiar().addActionListener(this);        
        vista.getBtnGenerarInforme().addActionListener(this);        
    }
         
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vista.getBtnAgregar()){
            CrearProducto(e);
            
        }
        if(e.getSource() == vista.getBtnActualizar()){
            ActualizarProducto(e);
        }
        if(e.getSource() == vista.getBtnBorrar()){
            EliminarProducto(e);
        }
        if(e.getSource() == vista.getBtnLimpiar()){
            
        }
        if(e.getSource() == vista.getBtnGenerarInforme()){
            
        }        
    }
}
