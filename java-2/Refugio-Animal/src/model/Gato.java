public class Gato extends Mascota implements Adoptable {

  public Gato(String nombre, int edad) {
    super(nombre, edad);
  }

  @Override
  public void hacerSonido() {
    System.out.println(nombre + " dice: Miau 🐱");
  }

  @Override
  public String datosAdopcion() {
    return "Gato " + nombre + " disponible para adopción";
  }
}
