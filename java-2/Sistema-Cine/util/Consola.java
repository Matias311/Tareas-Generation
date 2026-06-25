package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Consola {
  private static final Scanner scanner = new Scanner(System.in);

  public static int leerInt(String mensaje) {
    while (true) {
      try {
        System.out.print(mensaje);
        int valor = scanner.nextInt();
        scanner.nextLine();
        return valor;
      } catch (InputMismatchException e) {
        System.out.println("Error: ingrese un numero valido.");
        scanner.nextLine();
      }
    }
  }

  public static String leerString(String mensaje) {
    System.out.print(mensaje);
    return scanner.nextLine().trim();
  }

  public static double leerDouble(String mensaje) {
    while (true) {
      try {
        System.out.print(mensaje);
        double valor = scanner.nextDouble();
        scanner.nextLine();
        return valor;
      } catch (InputMismatchException e) {
        System.out.println("Error: ingrese un numero valido.");
        scanner.nextLine();
      }
    }
  }
}
