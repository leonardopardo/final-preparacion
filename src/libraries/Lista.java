package libraries;

import contracts.ICola;
import contracts.ILista;

public class Lista implements ILista {

    class Nodo{
        int valor;
        Nodo siguiente;
    }

    private Nodo primero;

    @Override
    public void inicializarLista() {
        this.primero = null;
    }

    @Override
    public void agregarInicio(int x) {
        Nodo nuevoNodo = new Nodo();
        nuevoNodo.valor = x;
        nuevoNodo.siguiente = this.primero;

        this.primero = nuevoNodo;
    }

    @Override
    public void agregarFinal(int x) {
        Nodo nuevoNodo = new Nodo();
        nuevoNodo.valor = x;
        nuevoNodo.siguiente = null;

        if(this.primero == null){
            this.primero =  nuevoNodo;
            return;
        }

        Nodo nodoActual = this.primero;

        while(nodoActual.siguiente != null){
            nodoActual = nodoActual.siguiente;
        }

        nodoActual.siguiente = nuevoNodo;
    }

    @Override
    public void eliminarInicio() {
        this.primero = this.primero.siguiente;
    }

    @Override
    public void eliminarFinal() {
        Nodo nodoActual = this.primero;
        Nodo nodoAnterior = null;

        while(nodoActual.siguiente != null) {
            nodoAnterior = nodoActual;
            nodoActual = nodoActual.siguiente;
        }

        nodoAnterior.siguiente = null;
    }

    @Override
    public void eliminar(int x) {
        Nodo nodoActual = this.primero;
        Nodo nodoAnterior = null;

        while(nodoActual.siguiente != null && nodoActual.valor != x) {
            nodoAnterior = nodoActual;
            nodoActual = nodoActual.siguiente;
        }

        nodoAnterior.siguiente = null;
    }

    @Override
    public boolean existe(int x) {
        Nodo actual = this.primero;

        while(actual != null && actual.valor != x) {
            actual = actual.siguiente;
        }

        return actual != null;
    }

    @Override
    public ICola valores() {
        ICola valores = new Cola();
        valores.inicializarCola();

        Nodo nodoActual = this.primero;

        while(nodoActual.siguiente != null){
            valores.acolar(nodoActual.valor);
            nodoActual = nodoActual.siguiente;
        }

        return valores;
    }

    @Override
    public boolean listaVacia() {
        return this.primero == null;
    }
}
