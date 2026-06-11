import java.util.ArrayList;
import java.util.List;

/** Ejercicio. */
public class Ejercicio {

  public static void main(String[] args) {
    List<Integer> numbers = new ArrayList<>();

    numbers.add(1);
    numbers.add(2);
    numbers.add(3);
    numbers.add(4);
    numbers.add(5);

    numbers.stream().mapToInt(n -> n * 2).forEach(System.out::println);

    System.out.println(numbers.stream().count());

    numbers.stream().forEach(System.out::println);
  }
}
