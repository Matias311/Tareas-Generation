import java.util.HashSet;
import java.util.Set;

/** Ejercicio. */
public class Ejercicio {

  public static void main(String[] args) {
    Set<String> emails = new HashSet<>();
    emails.add("example@example.com");
    emails.add("example2@example.com");
    emails.add("example3@example.com");
    emails.add("example@example.com"); // should show only one

    System.out.println(emails);

    System.out.println(emails.contains("example@example.com"));
    System.out.println("Total: " + emails.size());
  }
}
