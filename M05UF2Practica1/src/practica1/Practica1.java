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
        boolean comprobar = false;

        do {

            String numero1;
            do {
                System.out.print("Introdueix el primer numero: ");
                numero1 = sc.nextLine();
                System.out.println();
            } while (!numero1.matches("[+-]?[\\d]*[.]?[\\d]+"));
            double n1 = Double.parseDouble(numero1);
       

            do {
                System.out.println("\nOperació? (Indica el signe)");
                System.out.println("+ = sumar");
                System.out.println("- = restar");
                System.out.println("x = multiplicar");
                System.out.println("/ = dividir");
                System.out.println("* = elevar primer num al segon num");
                System.out.println("% = residu");
                operacion = sc.nextLine();
                if (operacion.equals("+") || operacion.equals("-") || operacion.equals("x")
                        || operacion.equals("X") || operacion.equals("/") || operacion.equals("%")
                        || operacion.equals("*")) {
                    comprobar = true;
                } else {
                    comprobar = false;
                    System.err.println("Operació no vàlida. Intenta-ho de nou.");
                }
            } while (comprobar != true);

            String numero2;
            do {
                System.out.print("\n Introdueix el segon numero: ");
                numero2 = sc.nextLine();
                System.out.println();
            } while (!numero2.matches("[+-]?[\\d]*[.]?[\\d]+"));
            double n2 = Double.parseDouble(numero2);

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
}
