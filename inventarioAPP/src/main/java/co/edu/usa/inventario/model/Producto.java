/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.usa.inventario.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

/**
 *
 * @author Juan Morant
 */
/* Con el siguiente decorador o anotación se relaciona la clase con una tabla en la base de datos */
@Table("Productos")
public class Producto {

    /* Se define el atributo codigo como la llave primaria de la base de datos */
    @Id
    private Long codigo;
    private String nombre;
    private Double precio;
    private Integer inventario;

    public Producto() {
    }

    /**
     * Constructor donde se especifica código del producto.
     *
     * @param codigo
     * @param nombre
     * @param precio
     * @param inventario
     */
    public Producto(Long codigo, String nombre, Double precio, Integer inventario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.inventario = inventario;
    }

    /**
     * Constructor sin el código del producto, es decir, autoincremental
     *
     * @param nombre
     * @param precio
     * @param inventario
     */
    public Producto(String nombre, Double precio, Integer inventario) {
        this.nombre = nombre;
        this.precio = precio;
        this.inventario = inventario;
    }

    /**
     * Getter para obtener codigo
     *
     * @return
     */
    public Long getCodigo() {
        return codigo;
    }

    /**
     * Getter para obtener nombre
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Getter para obtener precio
     *
     * @return
     */
    public Double getPrecio() {
        return precio;
    }

    /**
     * Getter para obtener inventario
     *
     * @return
     */
    public Integer getInventario() {
        return inventario;
    }

    /**
     * Setter para configurar codigo
     *
     * @param codigo
     */
    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    /**
     * Setter para configurar nombre
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Setter para configurar precio
     *
     * @param precio
     */
    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    /**
     * Setter para configurar inventario
     *
     * @param inventario
     */
    public void setInventario(Integer inventario) {
        this.inventario = inventario;
    }

    /**
     * Método que retorna un String representando un producto
     *
     * @return
     */
    @Override
    public String toString() {
        return "Productos{" + "codigo=" + codigo + ", nombre=" + nombre
                + ", precio=" + precio + ", inventario=" + inventario + '}';
    }

}
