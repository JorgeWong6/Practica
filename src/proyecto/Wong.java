 package proyecto;

import java.util.Scanner;

public class Wong {
    public static void main (String args[]){

    Scanner in = new Scanner(System.in);
    String nombre = "";
    int a = 0, b = 0, resultado =0;

    System.out.println("Cual es tu nombre");
    nombre = in.nextLine();

    System.out.println("Dame el primer valor para tu suma:");
    a = in.nextInt();

    System.out.println("Dame el segundo valor para tu suma:");
    b = in.nextInt();

    resultado = a + b;
    System.out.println("Hola:"+ nombre + " el resultado de tu suma es:" + resultado);
    }
}

