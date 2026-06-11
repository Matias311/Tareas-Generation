import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** GestionFrutas. */
public class GestionFrutas {

  public static void main(String[] args) {
    List<String> frutas = new ArrayList<>();
    frutas.add("Platano");
    frutas.add("Manzana");
    frutas.add("Pera");
    Scanner sc = new Scanner(System.in);
    agregarFrutas(frutas, sc);
    mostrarFrutas(frutas);
    mostrarCantidad(frutas);
    reemplazarFrutas(frutas, sc);
    eliminarFruta(frutas, sc);
    mostrarFrutas(frutas);
    sc.close();
  }

  private static void agregarFrutas(List<String> frutas, Scanner sc) {
    System.out.println("Ingrese la fruta a agregar");
    String fruta = sc.nextLine();

    if (fruta.isEmpty()) {
      System.out.println("el nombre no puede estar vacio");
      return;
    }

    frutas.add(fruta);
  }

  private static void mostrarFrutas(List<String> frutas) {
    frutas.forEach(System.out::println);
  }

  private static void mostrarCantidad(List<String> frutas) {
    System.out.println(frutas.size());
  }

  private static void reemplazarFrutas(List<String> frutas, Scanner sc) {
    System.out.println("Ingrese el nombre de la fruta a reemplazar");
    String antiguo = sc.nextLine();

    if (antiguo.isEmpty()) {
      System.out.println("El nombre de la fruta no puede estar vacio");
      return;
    }

    if (!frutas.contains(antiguo)) {
      System.out.println("La fruta no se encuentra en la lista.");
      return;
    }

    System.out.println("Ingrese el nuevo nombre de la fruta");
    String nuevo = sc.nextLine();

    if (nuevo.isEmpty()) {
      System.out.println("El nombre de la fruta no puede estar vacio");
      return;
    }

    int index = frutas.indexOf(antiguo);
    frutas.remove(index);
    frutas.add(index, nuevo);
  }

  private static void eliminarFruta(List<String> frutas, Scanner sc) {
    System.out.println("Ingrese el nombre de la fruta a eliminar");
    String fruta = sc.nextLine();

    if (fruta.isEmpty()) {
      System.out.println("El nombre de la fruta no puede estar vacio");
      return;
    }
    if (!frutas.contains(fruta)) {
      System.out.println("La fruta no se encuentra en la lista");
      return;
    }

    frutas.remove(fruta);
  }
}
