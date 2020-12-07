package libraries;

import contracts.IColaCadena;

public class ColaCadena implements IColaCadena {

    class Nodo{
        String dato;
        Nodo siguiente;
    }

    private Nodo primero, ultimo;

    @Override
    public void inicializarCola() {
        this.primero = null;
        this.ultimo = null;
    }

    @Override
    public void acolar(String cadena) {
        Nodo nuevoNodo = new Nodo();
        nuevoNodo.dato = cadena;
        nuevoNodo.siguiente = null;

        if(this.colaVacia()){
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
    public String primero() {
        return this.primero.dato;
    }

    @Override
    public boolean colaVacia() {
        return this.primero == null;
    }
}
