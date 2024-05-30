/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import java.util.Scanner;

/**
 *
 * @author esther
 */
public class Practica1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double res = 0;
        String operacion;
        String numero1;
        String numero2;
        boolean comprobar = false;

        do {

            Double n1 = obtenerNumero(sc);
            
            operacion = obtenerOperacion(sc);

            Double n2 = obtenerNumero(sc);

            do {
                comprobar = true;
                switch (operacion) {
                    case "+":
                        res = n1 + n2;
                        break;
                    case "-":
                        res = n1 - n2;
                        break;
                    case "x":
                    case "X":
                        res = n1 * n2;
                        break;
                    case "/":
                        while (n2 == 0) {
                            do {
                                System.err.println("El denominador és zero. Introdueix un altre valor:");
                                numero2 = sc.nextLine();
                            } while (!numero2.matches("[+-]?[\\d]*[.]?[\\d]+"));
                            n2 = Double.parseDouble(numero2);
                            
                        }
                        res = n1 / n2;
                        break;
                    case "*":
                        res = Math.pow(n1, n2);
                        break;
                    case "%":
                        while (n2 == 0) {
                            do {
                                System.err.println("El denominador és zero. Introdueix un altre valor:");
                                numero2 = sc.nextLine();
                            } while (!numero2.matches("[+-]?\\d*\\.?\\d+"));
                            n2 = Double.parseDouble(numero2);
                            
                        }
                        res = n1 % n2;
                        break;
                }
            } while (comprobar != true);

            System.out.println("(" + n1 + ") " + operacion + " (" + n2 + ") = " + res);
            System.out.println("\n Vols continuar operant? [s/n]");
            do {
                comprobar = true;
                operacion = sc.nextLine();

                if (!operacion.equalsIgnoreCase("s") && !operacion.equalsIgnoreCase("n")) {
                    System.err.println("Error, posa un valor vàlid.");
                    comprobar = false;
                }
            } while (!comprobar);
        } while (operacion.equalsIgnoreCase("s"));
    }
    
    public static double obtenerNumero(Scanner sc) {
        String numero;
        double num;
        do {
            System.out.print("Introdueix el primer numero: ");
            numero = sc.nextLine();
            System.out.println();
        } while (!numero.matches("[+-]?[\\d]*[.]?[\\d]+"));
        return Double.parseDouble(numero);
    }
    
    public static String obtenerOperacion(Scanner sc) {
        String operacion;
        boolean comprobar;
        do {
            System.out.println("\nOperació? (Indica el signe)");
            System.out.println("+ = sumar");
            System.out.println("- = restar");
            System.out.println("x = multiplicar");
            System.out.println("/ = dividir");
            System.out.println("* = elevar primer num al segon num");
            System.out.println("% = residu");
            operacion = sc.nextLine();
            comprobar = operacion.matches("[+\\-xX/*%]");
            if (!comprobar) {
                System.err.println("Operació no vàlida. Intenta-ho de nou.");
            }
        } while (!comprobar);
        return operacion;
    } 
}
