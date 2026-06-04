import java.util.ArrayList;
import java.util.List;

/** FiltrarNotasAprobadas. */
public class FiltrarNotasAprobadas {

  public static void main(String[] args) {
    List<Double> notas = new ArrayList<>();
    notas.add(4.0);
    notas.add(2.0);
    notas.add(5.0);
    notas.add(6.0);
    notas.add(3.0);

    List<Double> notasAprobadas =
        notas.stream()
            .filter(n -> Double.compare(n, 4.0) == 1 || Double.compare(n, 4.0) == 0)
            .toList();

    notasAprobadas.forEach(System.out::println);
    System.out.println("Notas aprobadas: " + notasAprobadas.size());
  }
}
