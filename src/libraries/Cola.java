package libraries;

import contracts.ICola;

public class Cola implements ICola {

    class Nodo{
        int dato;
        Nodo siguiente;
    }

    private Nodo primero, ultimo;

    @Override
    public void inicializarCola() {
        this.primero = null;
        this.ultimo = null;
    }

    @Override
    public void acolar(int x) {
        Nodo nuevoNodo = new Nodo();
        nuevoNodo.dato = x;
        nuevoNodo.siguiente = null;

        if (this.colaVacia()) {
            this.primero = nuevoNodo;
            this.ultimo = nuevoNodo;
        } else {
            this.ultimo.siguiente = nuevoNodo;
            this.ultimo = nuevoNodo;
        }
    }

    @Override
    public void desacolar() {
        this.primero = this.primero.siguiente;
    }

    @Override
    public int primero() {
        return this.primero.dato;
    }

    @Override
    public boolean colaVacia() {
        return this.primero == null;
    }
}
