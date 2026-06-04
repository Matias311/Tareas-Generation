import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** RegistroProductos. */
public class RegistroProductos {

  public static void main(String[] args) {
    List<String> productos = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    System.out.println("Ingrese la cantidad de productos a guardar");
    int cantidad = sc.nextInt();
    sc.nextLine();

    if (cantidad == 0) {
      System.out.println("Terminando programa");
      sc.close();
      return;
    }

    for (int i = 0; i < cantidad; i++) {
      System.out.println("Ingrese el nombre del producto a guardar");
      productos.add(sc.nextLine());
    }

    productos.stream().forEach(System.out::println);
    System.out.println("La cantidad de productos que se han guardado es: " + productos.size());
    sc.close();
  }
}
