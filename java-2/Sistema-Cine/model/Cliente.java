package model;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Persona {
    private List<Entrada> entradas;

    public Cliente(String nombre) {
        super(nombre);
        this.entradas = new ArrayList<>();
    }

    public List<Entrada> getEntradas() {
        return entradas;
    }

    public void agregarEntrada(Entrada entrada) {
        this.entradas.add(entrada);
    }
}
