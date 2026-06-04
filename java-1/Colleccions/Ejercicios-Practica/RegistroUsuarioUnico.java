import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/** RegistroUsuarioUnico. */
public class RegistroUsuarioUnico {
  public static void main(String[] args) {
    Set<String> nombresUsuarios = new HashSet<>();

    Scanner sc = new Scanner(System.in);
    System.out.println("Cuantos usuarios se ingresan?");
    int cantidad = sc.nextInt();
    sc.nextLine(); // limpia el scanner

    for (int i = 0; i < cantidad; i++) {
      System.out.println("Ingrese el nombre de usuario");
      String nombre = sc.nextLine();

      if (nombresUsuarios.contains(nombre)) {
        System.out.println("Usuario repetido");
      } else {
        nombresUsuarios.add(nombre);
      }
    }

    nombresUsuarios.forEach(System.out::println);
    System.out.println("Cantidad de nombre de usuarios unicos: " + nombresUsuarios.size());
    sc.close();
  }
}
