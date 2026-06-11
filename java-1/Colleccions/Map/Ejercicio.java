import java.util.HashMap;
import java.util.Map;

/** Ejercicio. */
public class Ejercicio {

  public static void main(String[] args) {
    Map<String, Integer> sueldos = new HashMap<>();
    sueldos.put("Juan", 1000);
    sueldos.put("Sebastian", 10000);

    String nombreAconsultar = "Sebastian";
    System.out.println(sueldos.get(nombreAconsultar));

    sueldos.remove("Sebastian");

    System.out.println(sueldos);
  }
}
