/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package sesion2;
import java.util.Scanner;
/**
 *
 * @author Administrador
 */
public class Sesion2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner sc = new Scanner(System.in);
        
                
        System.out.println("Por favor ingrese un texto: ");
        
        String cadena = sc.nextLine();
        
        if(cadena.equals("S")){
            System.out.println("Cadena ingresada adecuadamente");
        }       
        
        
    }
    
}
