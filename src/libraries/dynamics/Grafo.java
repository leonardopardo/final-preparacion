package libraries.dynamics;

import contracts.IConjunto;
import contracts.IGrafo;
import libraries.Conjunto;


public class Grafo implements IGrafo {

    class NodoV {
        int vOrigen;
        NodoA inicioArista;
        NodoV siguienteVertice;
    }

    class NodoA {
        int peso;
        NodoV destino;
        NodoA siguiente;
    }

    private NodoV inicioVertices;

    @Override
    public void inicializarGrafo() {
        this.inicioVertices = null;
    }

    @Override
    public void agregarVertice(int vertice) {

        NodoV nuevoVertice = new NodoV();

        nuevoVertice.vOrigen = vertice;

        nuevoVertice.inicioArista = null;

        nuevoVertice.siguienteVertice = this.inicioVertices;

        this.inicioVertices = nuevoVertice;

    }

    @Override
    public void eliminarVertice(int vertice) {

        NodoV vAnterior = null;

        NodoV elVertice = this.buscarVertice(vertice); // Nodo vertice.

        NodoV verticeActual = this.inicioVertices;

        while(verticeActual != null){

            NodoA aristaActual = verticeActual.inicioArista;

            while( aristaActual != null && aristaActual.destino.vOrigen != vertice)
                aristaActual = aristaActual.siguiente;

            if(aristaActual != null)
                this.eliminarArista(verticeActual.vOrigen, vertice);

            if(verticeActual.siguienteVertice != null && verticeActual.siguienteVertice.vOrigen == vertice)
                vAnterior = verticeActual;

            verticeActual = verticeActual.siguienteVertice;
        }

        if(vAnterior == null){
            this.inicioVertices = elVertice.siguienteVertice;
        } else {
            vAnterior.siguienteVertice = elVertice.siguienteVertice;
        }

    }

    @Override
    public void agregarArista(int verticeOrigen, int verticeDestino, int peso) {

        NodoA nuevaArista = new NodoA();
        nuevaArista.destino = this.buscarVertice(verticeDestino);
        nuevaArista.peso = peso;

        NodoV nodoOrigen = this.buscarVertice(verticeOrigen);
        nuevaArista.siguiente = nodoOrigen.inicioArista;
        nodoOrigen.inicioArista = nuevaArista;
    }

    @Override
    public void eliminarArista(int verticeOrigen, int verticeDestino) {

        NodoA arista = buscarArista(verticeOrigen, verticeDestino);

        NodoV vertice = buscarVertice(verticeOrigen);

        NodoA aristaAnterior = null;

        NodoA aristaActual = vertice.inicioArista;

        while(aristaActual != null && aristaActual.destino.vOrigen != arista.destino.vOrigen){
            aristaAnterior = aristaActual;
            aristaActual = aristaActual.siguiente;
        }

        if(aristaAnterior == null){
            vertice.inicioArista = aristaActual.siguiente;
        } else {
            aristaAnterior.siguiente = aristaActual.siguiente;
        }
    }

    @Override
    public IConjunto vertices() {
        IConjunto c = new Conjunto();
        c.inicializarConjunto();

        NodoV verticeActual = this.inicioVertices;

        while(verticeActual != null ){
            c.agregar(verticeActual.vOrigen);
            verticeActual = verticeActual.siguienteVertice;
        }

        return c;
    }

    @Override
    public int peso(int verticeOrigen, int verticeDestino) {
        return this.buscarArista(verticeOrigen, verticeDestino).peso;
    }

    @Override
    public boolean existeArista(int verticeOrigen, int verticeDestino) {
        return this.buscarArista(verticeOrigen, verticeDestino) != null;
    }

    private NodoV buscarVertice(int vertice){
        NodoV verticeActual = this.inicioVertices;

        while(verticeActual.siguienteVertice != null && verticeActual.vOrigen != vertice){
            verticeActual = verticeActual.siguienteVertice;
        }

        return verticeActual;
    }

    private NodoA buscarArista(int verticeOrigen, int verticeDestino) {
        NodoV verticeO = buscarVertice(verticeOrigen);
        NodoV verticeD = buscarVertice(verticeDestino);

        NodoA artistaActual = verticeO.inicioArista;

        while(artistaActual != null && artistaActual.destino.vOrigen != verticeD.vOrigen){
            artistaActual = artistaActual.siguiente;
        }

        return artistaActual;
    }
}
