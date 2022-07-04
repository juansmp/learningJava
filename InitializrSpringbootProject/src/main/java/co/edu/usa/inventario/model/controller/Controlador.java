/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.usa.inventario.model.controller;

import co.edu.usa.inventario.model.Productos;
import co.edu.usa.inventario.model.repositories.RepositorioProductos;
import co.edu.usa.inventario.view.Vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrador
 */
public class Controlador implements ActionListener{

    RepositorioProductos repositorio;
    Vista vista;

    public Controlador() {
        super();
    }

    /**
     * Constructor 
     * @param repositorio
     * @param vista
     */
    public Controlador(RepositorioProductos repositorio, Vista vista) {
        this.repositorio = repositorio;
        this.vista = vista;
        agregarEventos();
        this.vista.setVisible(true);
        this.listar();
        
    }
    
    public void actualizar(ActionEvent e){
        String nombre = vista.getTxtNombre().getText();
        Double precio = Double.parseDouble(vista.getTxtPrecio().getText());
        Integer inventario = Integer.parseInt(vista.getTxtInventario().getText());
        Productos productoActualizar = new Productos(nombre, precio, inventario);
        if(verificarExistencia(productoActualizar) && validarCampos(productoActualizar)){
            
        }else{
            
        }
        
    }
    /**
     * Método que permite crear un producto en la base de datos.     
     * @param e
     */
    public void crear(ActionEvent e){
        String nombre = vista.getTxtNombre().getText();
        Double precio = Double.parseDouble(vista.getTxtPrecio().getText());
        Integer inventario = Integer.parseInt(vista.getTxtInventario().getText());
        Productos productoCrear = new Productos(nombre, precio, inventario);
        if(!verificarExistencia(productoCrear) && validarCampos(productoCrear)){
            repositorio.save(productoCrear);
        }else{
            
        }
        this.listar();
        
    }
    
    
    public void listar(){
        List<Productos>  listarProducto = (List<Productos>) repositorio.findAll();
        DefaultTableModel modeloTabla = new DefaultTableModel(new Object[]{"Codigo", "Nombre", "Precio", "Inventario"}, 0);
        
        for(Productos p : listarProducto){
            modeloTabla.addRow(new Object[]{p.getCodigo(),p.getNombre(),p.getPrecio(),p.getInventario()} );
        }
        vista.getTblInventario().setModel(modeloTabla);
        
    }
    
    public void buscar(ActionEvent e){
        
    }
    
    
    
    public void eliminar(ActionEvent e){
        String nombre = vista.getTxtNombre().getText();
        Double precio = Double.parseDouble(vista.getTxtPrecio().getText());
        Integer inventario = Integer.parseInt(vista.getTxtInventario().getText());
        Productos productoEliminar = new Productos(nombre, precio, inventario);
        if(verificarExistencia(productoEliminar)){
            
        }
        
    }
    
    private boolean verificarExistencia(Productos productoEntrada){
         List<Productos>  listarProducto = (List<Productos>) repositorio.findAll();
        
        for(Productos p : listarProducto){
            if(productoEntrada.getNombre().equals(p.getNombre())){
                return true;
            }           
        }
        return false;
    }
    
    private boolean validarCampos(Productos productoEntrada){
        return true;
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
            crear(e);
            
        }
        if(e.getSource() == vista.getBtnActualizar()){
            actualizar(e);
        }
        if(e.getSource() == vista.getBtnBorrar()){
            eliminar(e);
        }
        if(e.getSource() == vista.getBtnLimpiar()){
            
        }
        if(e.getSource() == vista.getBtnGenerarInforme()){
            
        }        
    }
}
