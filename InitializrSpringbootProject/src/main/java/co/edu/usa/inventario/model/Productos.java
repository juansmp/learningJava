/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.usa.inventario.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

/**
 *
 * @author Administrador
 */
// Con el siguiente decorador o anotación se relaciona la clase con una tabla en la base d edatos
@Table("Productos")
public class Productos {
    @Id
    private Integer codigo;
    private String nombre;
    private Double precio;
    private Integer inventario;

    public Productos() {
    }
    
    
    public Productos(Integer codigo, String nombre, Double precio, Integer inventario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.inventario = inventario;
    }
    
    
    /**
     * Constructor sin el código del producto
     * @param nombre
     * @param precio
     * @param inventario 
     */
    public Productos(String nombre, Double precio, Integer inventario) {
        this.nombre = nombre;
        this.precio = precio;
        this.inventario = inventario;
    }

    

    public Integer getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public Integer getInventario() {
        return inventario;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public void setInventario(Integer inventario) {
        this.inventario = inventario;
    }
    
    @Override
    public String toString() {
        return "Productos{" + "codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio + ", inventario=" + inventario + '}';
    }
    
    
}
