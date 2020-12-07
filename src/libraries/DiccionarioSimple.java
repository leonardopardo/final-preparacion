package libraries;

import contracts.IConjunto;
import contracts.IDiccionarioSimple;

public class DiccionarioSimple implements IDiccionarioSimple {

    class Nodo{
        int clave, valor;
        Nodo siguiente;
    }

    private Nodo primero;

    @Override
    public void inicializarDiccionarioSimple() {
        this.primero = null;
    }

    @Override
    public void agregar(int clave, int valor) {
        Nodo nuevoNodo = new Nodo();
        nuevoNodo.clave = clave;
        nuevoNodo.valor = valor;
        nuevoNodo.siguiente = this.primero;

        this.primero = nuevoNodo;
    }

    @Override
    public void eliminar(int clave) {
        Nodo anterior = null;
        Nodo actual = this.primero;

        if(actual.clave == clave){
            this.primero = actual.siguiente;
            return;
        }

        while(actual.siguiente != null && actual.clave != clave) {
            anterior = actual;
            actual = actual.siguiente;
        }

        anterior.siguiente = actual.siguiente;
    }

    @Override
    public int obtener(int clave) {
        Nodo actual = this.primero;

        while(actual.siguiente != null && actual.clave != clave) {
            actual = actual.siguiente;
        }

        return actual.valor;
    }

    @Override
    public IConjunto claves() {

        Nodo actual = this.primero;

        IConjunto conjuntoClaves = new Conjunto();
        conjuntoClaves.inicializarConjunto();

        if(actual == null){
            return conjuntoClaves;
        }

        while(actual != null) {
            conjuntoClaves.agregar(actual.clave);
            actual = actual.siguiente;
        }

        return conjuntoClaves;
    }
}
