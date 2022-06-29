/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package reto1;

import java.util.Scanner;

/**
 *
 * @author Administrador
 */
public class Reto1 {

    static Scanner sc = new Scanner(System.in);

    public static String read() {
        return sc.nextLine();
    }

    public static void run() {
        /* Leer datos de entrada */
        String entrada = read();
        String entrada_array[] = entrada.split(" ");

        /* Extraer datos de entrada */
        float masa = Float.parseFloat(entrada_array[0]);
        float altura = Float.parseFloat(entrada_array[1]);
        int edad = Integer.parseInt(entrada_array[2]);

        /* Aplicar validaciones */
        if ((masa <= 0.0) || (masa >= 150.0)) {
            System.out.println("ERROR");
        } else if ((altura <= 0.1) || (altura >= 2.5)) {
            System.out.println("ERROR");
        } else if ((edad <= 0) || (edad >= 110)) {
            System.out.println("ERROR");
        } else {

            /* Cálculo IMC */
            float imc = masa / (altura * altura);

            /* Calcular riesgo */
            String riesgo;
            if (edad < 45) {
                if (imc < 22.0) {
                    riesgo = "Bajo";
                } else { // imc >= 22
                    riesgo = "Medio";
                }
            } else { //riesgo >=45
                if (imc < 22.0) {
                    riesgo = "Medio";
                } else { // imc >= 22
                    riesgo = "Alto";
                }
            }
            /* Imprimir salida */
             
            System.out.println(String.format("%.1f", imc) + " " + riesgo);
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        run();
    }

}
