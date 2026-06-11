public class Perro extends Mascota implements Adoptable, Entrenable {

  public Perro(String nombre, int edad) {
    super(nombre, edad);
  }

  @Override
  public void hacerSonido() {
    System.out.println(nombre + " dice: Guau 🐶");
  }

  @Override
  public String datosAdopcion() {
    return "Perro " + nombre + " listo para adopción";
  }

  @Override
  public void entrenar() {
    System.out.println(nombre + " ha sido entrenado 🐾");
  }
}
