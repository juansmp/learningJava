/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


        
        
package sesion4;
import java.util.Scanner;
/**
 *
 * @author Administrador
 */
public class Sesion4 {

     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        String[] cadena = new String[2];
        String cadena2[] = {"Hola", "nuevo", "2"};
        
        
        /* Dos ciclos equivalentes */ 
        for(int i=0; i<cadena2.length; i++){
            System.out.println(cadena2[i]);
        }
        
        for(String texto : cadena2){ // For each
            System.out.println(texto);            
        }
        
        System.out.println(cadena[0]);
        
        
        int dimension = cadena.length;
        
        System.out.println(dimension);
        
        /*
        Scanner sc = new Scanner(System.in);
        
                
        System.out.println("Por favor ingrese un texto: ");
        
        String cadena = sc.nextLine();
        
        if(cadena.equals("S")){
            System.out.println("Cadena ingresada adecuadamente");
        }       
        */
        
    }
    
}


