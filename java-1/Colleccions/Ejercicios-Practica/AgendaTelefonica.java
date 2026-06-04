import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/** AgendaTelefonica. */
public class AgendaTelefonica {

  public static void main(String[] args) {
    Map<String, String> contactos = new HashMap<>();
    System.out.println("Solicitando 5 contactos");
    Scanner sc = new Scanner(System.in);

    for (int i = 0; i < 5; i++) {
      System.out.println("Ingrese el nombre");
      String nombre = sc.nextLine();

      System.out.println("Ingrse el numero de telefono");
      String numero = sc.nextLine();
      contactos.put(nombre, numero);
    }

    System.out.println("Contactos registrados");

    for (Map.Entry<String, String> contacto : contactos.entrySet()) {
      System.out.printf("Nombre: %s\nNumero: %s\n", contacto.getKey(), contacto.getValue());
    }

    System.out.println("Ingres un nombre");
    String nombre = sc.nextLine();

    if (nombre == null) {
      System.out.println("No se encontro el numero telefonico de: " + nombre);
    } else {
      System.out.println(contactos.get(nombre));
    }

    sc.close();
  }
}
