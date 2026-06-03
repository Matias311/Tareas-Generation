/** ArrayIntroduccion. */
public class ArrayIntroduccion {

  public static void main(String[] args) {
    String[] nombres = {"Matias", "Elvis", "Catalina", "Cristian", "Jorge"};
    for (String nombre : nombres) {
      System.out.println(nombre);
    }

    nombres[2] = "Cata";
    System.out.println("El total de los elementos es: " + nombres.length);

    for (String nombre : nombres) {
      System.out.println(nombre);
    }
  }
}
