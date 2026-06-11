import java.util.Scanner;

/** InputUtil. */
public class InputUtil {

  public static int leerInt() {
    try (Scanner sc = new Scanner(System.in)) {
      return Integer.parseInt(sc.nextLine());
    } catch (Exception e) {
      System.out.println(e);
      return -10;
    }
  }

  public static String pedirString(String message) {
    System.out.println(message);
    try (Scanner sc = new Scanner(System.in)) {
      String in = sc.nextLine();
      if (in.isBlank()) {
        throw new IllegalStateException("Error, no puede estar vacio");
      }
      return in;
    } catch (Exception e) {
      System.out.println(e);
      return null;
    }
  }
}
