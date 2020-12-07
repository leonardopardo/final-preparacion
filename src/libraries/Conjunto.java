package libraries;

import contracts.IConjunto;

public class Conjunto implements IConjunto {

    class Nodo{
        int dato;
        Nodo siguiente;
    }

    private Nodo primero;

    @Override
    public void inicializarConjunto() {
        this.primero = null;
    }

    @Override
    public void agregar(int x) {
        Nodo nuevoNodo = new Nodo();
        nuevoNodo.dato = x;
        nuevoNodo.siguiente = primero;

        this.primero = nuevoNodo;
    }

    @Override
    public void sacar(int x) {
        Nodo nodoAnterior = null;
        Nodo nodoActual = this.primero;

        if(nodoActual.dato == x){
            this.primero = nodoActual.siguiente;
            return;
        }

        while(nodoActual.dato != x){
            nodoAnterior = nodoActual;
            nodoActual = nodoActual.siguiente;
        }

        nodoAnterior.siguiente = nodoActual.siguiente;
    }

    @Override
    public int obtener() {
        return this.primero.dato;
    }

    @Override
    public boolean conjuntoVacio() {
        return this.primero == null;
    }

    @Override
    public boolean pertenece(int x) {
        Nodo actual = this.primero;

        while(actual != null && actual.dato != x) {
            actual = actual.siguiente;
        }

        return actual != null;
    }
}
