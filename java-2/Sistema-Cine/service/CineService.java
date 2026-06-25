package service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import model.*;

public class CineService {
  private Map<String, Cliente> clientes;
  private List<Funcion> funciones;
  private List<Pelicula> peliculas;

  public CineService() {
    this.clientes = new HashMap<>();
    this.funciones = new ArrayList<>();
    this.peliculas = new ArrayList<>();
  }

  public void iniciar() {
    int opcion;
    do {
      mostrarMenu();
      opcion = util.Consola.leerInt("Seleccione una opcion: ");
      System.out.println();
      switch (opcion) {
        case 1 -> crearCliente();
        case 2 -> registrarPelicula();
        case 3 -> crearFuncion();
        case 4 -> verCartelera();
        case 5 -> comprarEntrada();
        case 6 -> verEntradasCliente();
        case 7 -> listarClientes();
        case 8 -> reporteVentas();
        case 0 -> System.out.println("Saliendo...");
        default -> System.out.println("Opcion invalida.");
      }
      System.out.println();
    } while (opcion != 0);
  }

  private void mostrarMenu() {
    System.out.println("=== SISTEMA DE CINE ===");
    System.out.println("1) Crear cliente");
    System.out.println("2) Registrar pelicula");
    System.out.println("3) Crear funcion");
    System.out.println("4) Ver cartelera");
    System.out.println("5) Comprar entrada");
    System.out.println("6) Ver entradas de cliente");
    System.out.println("7) Listar clientes");
    System.out.println("8) Reporte de ventas");
    System.out.println("0) Salir");
  }

  private void crearCliente() {
    String nombre = util.Consola.leerString("Nombre del cliente: ");
    if (clientes.containsKey(nombre)) {
      System.out.println("Ya existe un cliente con ese nombre.");
      return;
    }
    Cliente c = new Cliente(nombre);
    clientes.put(nombre, c);
    System.out.println("Cliente creado.");
  }

  private void registrarPelicula() {
    String titulo = util.Consola.leerString("Titulo de la pelicula: ");
    int minutos = util.Consola.leerInt("Duracion (minutos): ");
    peliculas.add(new Pelicula(titulo, minutos));
    System.out.println("Pelicula registrada.");
  }

  private void crearFuncion() {
    if (peliculas.isEmpty()) {
      System.out.println("No hay peliculas registradas.");
      return;
    }
    System.out.println("--- Peliculas disponibles ---");
    for (int i = 0; i < peliculas.size(); i++) {
      System.out.println((i + 1) + ") " + peliculas.get(i));
    }
    int idx = util.Consola.leerInt("Seleccione pelicula: ") - 1;
    if (idx < 0 || idx >= peliculas.size()) {
      System.out.println("Opcion invalida.");
      return;
    }
    Pelicula p = peliculas.get(idx);

    String horaStr = util.Consola.leerString("Horario (HH:mm): ");
    LocalTime horario;
    try {
      horario = LocalTime.parse(horaStr, DateTimeFormatter.ofPattern("HH:mm"));
    } catch (DateTimeParseException e) {
      System.out.println("Formato de hora invalido.");
      return;
    }

    int capacidad = util.Consola.leerInt("Capacidad de la sala: ");
    funciones.add(new Funcion(p, horario, capacidad));
    System.out.println("Funcion creada.");
  }

  private void verCartelera() {
    if (funciones.isEmpty()) {
      System.out.println("No hay funciones disponibles.");
      return;
    }
    System.out.println("--- CARTELERA ---");
    for (int i = 0; i < funciones.size(); i++) {
      Funcion f = funciones.get(i);
      String estado = f.hayAsientosDisponibles() ? "Disponible" : "AGOTADA";
      System.out.println((i + 1) + ") " + f + " [" + estado + "]");
    }
  }

  private void comprarEntrada() {
    if (funciones.isEmpty()) {
      System.out.println("No hay funciones disponibles.");
      return;
    }
    if (clientes.isEmpty()) {
      System.out.println("No hay clientes registrados.");
      return;
    }

    String nombreCliente = util.Consola.leerString("Nombre del cliente: ");
    Cliente cliente = clientes.get(nombreCliente);
    if (cliente == null) {
      System.out.println("Cliente no encontrado.");
      return;
    }

    verCartelera();
    int idxFuncion = util.Consola.leerInt("Seleccione funcion: ") - 1;
    if (idxFuncion < 0 || idxFuncion >= funciones.size()) {
      System.out.println("Opcion invalida.");
      return;
    }
    Funcion funcion = funciones.get(idxFuncion);

    if (!funcion.hayAsientosDisponibles()) {
      System.out.println("No hay asientos disponibles en esta funcion.");
      return;
    }

    int asiento = util.Consola.leerInt("Numero de asiento (1-" + funcion.getCapacidad() + "): ");
    if (!funcion.venderAsiento(asiento)) {
      System.out.println("Asiento invalido o ya ocupado.");
      return;
    }

    String tipo = util.Consola.leerString("Tipo de entrada (Normal/Estudiante): ");
    if (!tipo.equalsIgnoreCase("Normal") && !tipo.equalsIgnoreCase("Estudiante")) {
      System.out.println("Tipo invalido. Se usara Normal.");
      tipo = "Normal";
    }

    Entrada entrada = new Entrada(cliente, funcion, asiento, tipo);
    funcion.registrarEntrada(entrada);
    cliente.agregarEntrada(entrada);

    System.out.println("Entrada comprada exitosamente.");
    entrada.mostrarResumen();
  }

  private void verEntradasCliente() {
    String nombre = util.Consola.leerString("Nombre del cliente: ");
    Cliente c = clientes.get(nombre);
    if (c == null) {
      System.out.println("Cliente no encontrado.");
      return;
    }
    List<Entrada> entradas = c.getEntradas();
    if (entradas.isEmpty()) {
      System.out.println("El cliente no tiene entradas.");
      return;
    }
    for (Entrada e : entradas) {
      e.mostrarResumen();
    }
  }

  private void listarClientes() {
    if (clientes.isEmpty()) {
      System.out.println("No hay clientes registrados.");
      return;
    }
    System.out.println("--- CLIENTES ---");
    for (Cliente c : clientes.values()) {
      System.out.println("- " + c.getNombre() + " (" + c.getEntradas().size() + " entradas)");
    }
  }

  private void reporteVentas() {
    int totalEntradas = 0;
    double totalIngresos = 0;
    for (Funcion f : funciones) {
      for (Entrada e : f.getEntradasVendidas()) {
        totalEntradas++;
        totalIngresos += e.calcularPrecio();
      }
    }
    System.out.println("--- REPORTE DE VENTAS ---");
    System.out.println("Total de entradas vendidas: " + totalEntradas);
    System.out.println("Total de ingresos: $" + totalIngresos);
    System.out.println("Funciones activas: " + funciones.size());
    System.out.println("Clientes registrados: " + clientes.size());
  }
}
