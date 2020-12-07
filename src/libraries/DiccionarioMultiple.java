package libraries;

import contracts.IConjunto;
import contracts.IDiccionarioMultiple;

public class DiccionarioMultiple implements IDiccionarioMultiple {

    class Nodo {
        int clave;
        NodoValor valores;
        Nodo siguiente;
    }

    class NodoValor{
        int valor;
        NodoValor siguiente;
    }

    private Nodo primero;

    @Override
    public void inicializarDiccionarioMultiple() {
        this.primero = null;
    }

    @Override
    public void agregar(int clave, int valor) {

        Nodo nodoActual = this.buscarClave(clave);

        if(nodoActual == null){
            Nodo nuevoNodo = new Nodo();
            nuevoNodo.clave = clave;
            nuevoNodo.valores = null;
            nuevoNodo.siguiente = this.primero;
            this.primero = nuevoNodo;
            nodoActual = this.primero;
        }

        NodoValor nuevoValor = new NodoValor();
        nuevoValor.valor = valor;
        nuevoValor.siguiente = nodoActual.valores;
        nodoActual.valores = nuevoValor;
    }

    @Override
    public void eliminar(int clave) {
        Nodo nodoAnterior = null;
        Nodo nodoActual = this.primero;

        while(nodoActual.clave != clave){
            nodoAnterior = nodoActual;
            nodoActual = nodoActual.siguiente;
        }

        if(nodoAnterior == null)
            this.primero = this.primero.siguiente;
        else
            nodoAnterior.siguiente = nodoActual.siguiente;
    }

    @Override
    public void eliminarValor(int clave, int valor) {
        Nodo nodoActual = this.buscarClave(clave);
        NodoValor nodoValorActual = nodoActual.valores;
        NodoValor nodoValorAnterior = null;

        while(nodoValorActual.valor != valor){
            nodoValorAnterior = nodoValorActual;
            nodoValorActual = nodoValorActual.siguiente;
        }

        if(nodoValorAnterior == null){
            nodoActual.valores = nodoActual.valores.siguiente;
        }else{
            nodoValorAnterior.siguiente = nodoValorActual.siguiente;
        }

        if(nodoActual.valores == null){
            eliminar(nodoActual.clave);
        }
    }

    @Override
    public IConjunto obtener(int clave) {
        Nodo nodoActual = this.buscarClave(clave);

        IConjunto conjuntoValores = new Conjunto();
        conjuntoValores.inicializarConjunto();

        NodoValor nodoValorActual = nodoActual.valores;

        while(nodoValorActual != null){
            conjuntoValores.agregar(nodoValorActual.valor);
            nodoValorActual = nodoValorActual.siguiente;
        }

        return conjuntoValores;
    }

    @Override
    public IConjunto claves() {
        Nodo nodoActual = this.primero;

        IConjunto conjuntoClaves = new Conjunto();
        conjuntoClaves.inicializarConjunto();

        if(nodoActual == null){
            return conjuntoClaves;
        }

        while(nodoActual != null) {
            conjuntoClaves.agregar(nodoActual.clave);
            nodoActual = nodoActual.siguiente;
        }

        return conjuntoClaves;
    }

    private Nodo buscarClave(int clave){
        Nodo actual = this.primero;

        while(actual != null && actual.clave != clave){
            actual = actual.siguiente;
        }

        return actual;
    }

    private NodoValor buscarValor(NodoValor inicio, int x){
        NodoValor nodoActual = inicio;

        while(nodoActual != null && nodoActual.valor != x){
            nodoActual = nodoActual.siguiente;
        }

        return nodoActual;
    }
}
