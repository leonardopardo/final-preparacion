package libraries;

import contracts.IColaPrioritaria;

public class ColaPrioritaria implements IColaPrioritaria {

    class Nodo{
        int dato;
        int prioridad;
        Nodo siguiente;
    }

    private Nodo primero;

    @Override
    public void inicializarCola() {
        this.primero = null;
    }

    @Override
    public void acolarPrioridad(int valor, int prioridad) {
        Nodo nuevoNodo = new Nodo();
        nuevoNodo.dato = valor;
        nuevoNodo.prioridad = prioridad;

        if(this.primero == null){
            nuevoNodo.siguiente = null;
            this.primero = nuevoNodo;
            return;
        }

        if(prioridad > this.primero.prioridad){
            nuevoNodo.siguiente = this.primero;
            this.primero = nuevoNodo;
            return;
        }

        Nodo corriente = this.primero;
        Nodo anterior = null;

        while( corriente != null && prioridad <= corriente.prioridad){
            anterior = corriente;
            corriente = corriente.siguiente;
        }

        if(corriente == null) {
            nuevoNodo.siguiente = null;
            anterior.siguiente = nuevoNodo;
            return;
        }

        nuevoNodo.siguiente = corriente;
        anterior.siguiente = nuevoNodo;
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
    public int prioridad() {
        return this.primero.prioridad;
    }

    @Override
    public boolean colaVacia() {
        return this.primero == null;
    }
}
