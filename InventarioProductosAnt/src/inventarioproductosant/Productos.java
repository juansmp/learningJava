/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventarioproductosant;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Administrador
 */
public class Productos {

    private static Scanner sc = new Scanner(System.in);

    public static String read() {
        return sc.nextLine();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // TODO code application logic here
        run();
    }

    public static void run() {
        BaseDatosProductos BaseDatos = new BaseDatosProductos();
        //BaseDatos.VerIntentario(); 
        //while(true)
        {
            String Operacion = read();
            String Datos = read();
            String ArrDatos[] = Datos.split(" ");

            Producto ProductoEntrada = new Producto(Integer.parseInt(ArrDatos[0]), ArrDatos[1], Double.parseDouble(ArrDatos[2]), Integer.parseInt(ArrDatos[3]));

            switch (Operacion) {
                case "ACTUALIZAR":
                    BaseDatos.Actualizar(ProductoEntrada);
                    break;
                case "BORRAR":
                    BaseDatos.Eliminar(ProductoEntrada);
                    break;
                case "AGREGAR":
                    BaseDatos.Agregar(ProductoEntrada);
                    break;
                default:
                    throw new AssertionError();
            }

        }

    }

}

class Producto {

    private int codigo;
    private String nombre;
    private double precio;
    private int inventario;

    /**
     * Constructor vacio de clase Producto
     */
    public Producto() {
    }

    /**
     * Constructor producto
     *
     * @param codigo código del producto
     * @param nombre nombre del producto
     * @param precio precio del producto
     * @param inventario inventario del producto
     */
    public Producto(int codigo, String nombre, double precio, int inventario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.inventario = inventario;
    }

    /**
     *
     * @return
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     *
     * @param codigo
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return
     */
    public double getPrecio() {
        return precio;
    }

    /**
     *
     * @param precio
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     *
     * @return
     */
    public int getInventario() {
        return inventario;
    }

    /**
     *
     * @param inventario
     */
    public void setInventario(int inventario) {
        this.inventario = inventario;
    }

}

class BaseDatosProductos {

    /**
     * Este hashmap representa la base de datos de los productos La llave es el
     * código del producto y el valor es una instancia de la clase Producto.
     */
    private HashMap<Integer, Producto> listaProductos;// = new HashMap<>(); 

    public BaseDatosProductos() {
        this.listaProductos = new HashMap<>();
        /**
         * Inicializar hashmap con datos existentes a la fecha en el inventario
         * 1	Manzanas 5000.0	25 2	Limones 2300.0	15 3	Peras 2700.0	33 4
         * Arandanos 9300.0	5 5	Tomates 2100.0	42 6	Fresas 4100.0	3 7	Helado
         * 4500.0	41 8 Galletas 500.0	8 9	Chocolates 3500.0	80 10	Jamon 15000.0
         * 10
         */
        this.listaProductos.put(1, new Producto(1, "Manzanas", 5000.0, 25));
        this.listaProductos.put(2, new Producto(2, "Limones", 2300.0, 15));
        this.listaProductos.put(3, new Producto(3, "Peras", 2700.0, 33));
        this.listaProductos.put(4, new Producto(4, "Arandanos", 9300.0, 5));
        this.listaProductos.put(5, new Producto(5, "Tomates", 2100.0, 42));
        this.listaProductos.put(6, new Producto(6, "Fresas", 4100.0, 3));
        this.listaProductos.put(7, new Producto(7, "Helado", 4500.0, 41));
        this.listaProductos.put(8, new Producto(8, "Galletas", 500.0, 8));
        this.listaProductos.put(9, new Producto(9, "Chocolates", 3500.0, 80));
        this.listaProductos.put(10, new Producto(10, "Jamon", 15000.0, 10));

    }

    public void VerIntentario() {
        //System.out.println(this.listaProductos.toString());
        System.out.println("-----");
        System.out.println("Lista productos: ");

        for (Producto value : listaProductos.values()) {
            System.out.println("Código: " + value.getCodigo() + " Nombre: " + value.getNombre() + " Precio: " + value.getPrecio() + " Inventario: " + value.getInventario());
            System.out.println("-----");
        }

        this.generarInforme();

    }

    public void Agregar(Producto ProductoEntrada) {
        if (this.verificarExisencia(ProductoEntrada.getCodigo())) {
            System.out.println("ERROR");
        } else {
            this.listaProductos.put(ProductoEntrada.getCodigo(), ProductoEntrada);
            this.generarInforme();
        }
    }

    public void Actualizar(Producto ProductoEntrada) {
        if (this.verificarExisencia(ProductoEntrada.getCodigo())) {
            this.listaProductos.put(ProductoEntrada.getCodigo(), ProductoEntrada);
            this.generarInforme();
        } else {
            System.out.println("ERROR");
        }
    }

    public void Eliminar(Producto ProductoEntrada) {
        if (this.verificarExisencia(ProductoEntrada.getCodigo())) {
            this.listaProductos.remove(ProductoEntrada.getCodigo());
            this.generarInforme();
        } else {
            System.out.println("ERROR");
        }
    }

    public void generarInforme() {
        System.out.println(totalInventario());
    }

    public boolean verificarExisencia(int codigo) {
        if (this.listaProductos.get(codigo) == null) {
            return false;
        } else {
            return true;
        }

    }

    /**
     * Método que retorna los productos en un modelo de tabla que se puede
     * visualizar en el JTable del inventario
     *
     * @return
     */
    public TableModel obtenerTabla() {
        DefaultTableModel modeloTabla = new DefaultTableModel(new Object[]{"Codigo", "Nombre", "Precio", "Inventario"}, 0);
        for (Producto producto : listaProductos.values()) {
            modeloTabla.addRow(new Object[]{producto.getCodigo(), producto.getNombre(), producto.getPrecio(), producto.getInventario()});

        }
        return modeloTabla;
    }

    public Producto productoMayor() {
        Producto productoMayor = null;
        Double mayor = 0.0;
        for (Producto producto : listaProductos.values()) {
            Double valorPrecio = producto.getPrecio();
            if (valorPrecio >= mayor) {
                mayor = valorPrecio;
                productoMayor = producto;
            }
        }
        return productoMayor;
    }

    public Producto productoMenor() {
        Producto productoMenor = listaProductos.values().iterator().next();
        Double menor = productoMenor.getPrecio();
        for (Producto producto : listaProductos.values()) {
            Double valorPrecio = producto.getPrecio();
            if (valorPrecio < menor) {
                menor = valorPrecio;
                productoMenor = producto;
            }
        }
        return productoMenor;
    }

    public Double totalInventario() {
        Double ValorDelInventario = 0.0;
        for (Producto value : listaProductos.values()) {
            ValorDelInventario += value.getPrecio() * value.getInventario();
        }
        return ValorDelInventario;
    }

    public Double promedioProducto() {
        int cantidadProductosInventario = 0;
        for (Producto value : listaProductos.values()) {
            cantidadProductosInventario += value.getInventario();
        }
        return (totalInventario() / cantidadProductosInventario);

    }

}
