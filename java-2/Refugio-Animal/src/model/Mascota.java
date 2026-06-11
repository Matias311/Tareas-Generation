public abstract class Mascota {

  protected String nombre;
  protected int edad;

  public Mascota(String nombre, int edad) {
    if (edad <= 0) {
      throw new IllegalArgumentException("La edad debe ser mayor a 0");
    }
    this.nombre = nombre;
    this.edad = edad;
  }

  public abstract void hacerSonido();

  public void mostrarInfo() {
    System.out.println(nombre + " | Edad: " + edad);
  }

  public String getNombre() {
    return nombre;
  }

  public int getEdad() {
    return edad;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
    result = prime * result + edad;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    Mascota other = (Mascota) obj;
    if (nombre == null) {
      if (other.nombre != null) return false;
    } else if (!nombre.equals(other.nombre)) return false;
    if (edad != other.edad) return false;
    return true;
  }
}
