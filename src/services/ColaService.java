package services;

import contracts.ICola;
import contracts.IPila;
import libraries.Cola;
import libraries.Pila;

public class ColaService {

    /**
     * Pasa los valores de una cola a otra, la cola original
     * se pierde.
     * @param cola1
     * @param cola2
     */
    public void pasarCola(ICola cola1, ICola cola2) {
        while(!cola1.colaVacia()){
            cola2.acolar(cola1.primero());
            cola1.desacolar();
        }
    }

    /**
     *
     * @param cola1
     * @param cola2
     */
    public void copiarCola(ICola cola1, ICola cola2){
        ICola colaAux = new Cola();
        colaAux.inicializarCola();

        while(!cola1.colaVacia()){
            colaAux.acolar(cola1.primero());
            cola2.acolar(cola1.primero());
            cola1.desacolar();
        }

        while(!colaAux.colaVacia()){
            cola1.acolar(colaAux.primero());
            colaAux.desacolar();
        }
    }

    /**
     * Invierte una cola, utiliza una pilar como estructura auxiliar
     * se modifica la cola original.
     * @param cola
     */
    public void invertirCola(ICola cola){
        IPila pilaAux = new Pila();
        pilaAux.inicializarPila();

        while(!cola.colaVacia()){
            pilaAux.apilar(cola.primero());
            cola.desacolar();
        }

        while(!pilaAux.pilaVacia()){
            cola.acolar(pilaAux.tope());
            pilaAux.desapilar();
        }
    }

    /**
     * Ordena una cola de forma ascendente, la cola se pasa como argumento.
     * Se modifica la cola original.
     * @param cola
     */
    public void ordenarColaAsc(ICola cola){
        ICola colaAux = new Cola();
        colaAux.inicializarCola();

        ICola colaOrdenada = new Cola();
        colaOrdenada.inicializarCola();

        while(!cola.colaVacia()){
            int min = cola.primero();
            cola.desacolar();

            while(!cola.colaVacia()){
                if(cola.primero() < min){
                    colaAux.acolar(min);
                    min = cola.primero();
                } else {
                    colaAux.acolar(cola.primero());
                }
                cola.desacolar();
            }

            while(!colaAux.colaVacia()){
                cola.acolar(colaAux.primero());
                colaAux.desacolar();
            }

            colaOrdenada.acolar(min);
        }

        while (!colaOrdenada.colaVacia()){
            cola.acolar(colaOrdenada.primero());
            colaOrdenada.desacolar();
        }
    }

    /**
     * Ordena una cola de forma descendente, la cola se pasa como argumento.
     * Se modifica la cola original.
     * @param cola
     */
    public void ordenarColaDesc(ICola cola){
        ICola colaAux = new Cola();
        colaAux.inicializarCola();

        ICola colaOrdenada = new Cola();
        colaOrdenada.inicializarCola();

        while(!cola.colaVacia()){
            int max = cola.primero();
            cola.desacolar();

            while(!cola.colaVacia()){
                if(cola.primero() > max){
                    colaAux.acolar(max);
                    max = cola.primero();
                } else {
                    colaAux.acolar(cola.primero());
                }
                cola.desacolar();
            }

            while(!colaAux.colaVacia()){
                cola.acolar(colaAux.primero());
                colaAux.desacolar();
            }

            colaOrdenada.acolar(max);
        }

        while (!colaOrdenada.colaVacia()){
            cola.acolar(colaOrdenada.primero());
            colaOrdenada.desacolar();
        }
    }

    /**
     * Verifica si una cola es subcola de otra,
     * las colas originales no se modifican.
     * @param cola1
     * @param cola2
     * @return
     */
    public boolean subcolaOrdenada(ICola cola1, ICola cola2){

        ICola cola1Aux = new Cola();
        cola1Aux.inicializarCola();

        ICola cola2Aux = new Cola();
        cola2Aux.inicializarCola();

        copiarCola(cola1, cola1Aux);
        copiarCola(cola2, cola2Aux);

        invertirCola(cola1Aux);
        invertirCola(cola2Aux);

        boolean result = false;

        if(this.lengthCola(cola1Aux) > this.lengthCola(cola2Aux)){
            while(!cola2Aux.colaVacia() && cola1Aux.primero() == cola2Aux.primero()){
                cola1Aux.desacolar();
                cola2Aux.desacolar();
            }

            result = cola2Aux.colaVacia();
        }

        if(this.lengthCola(cola1Aux) < this.lengthCola(cola2Aux)){
            while(!cola1Aux.colaVacia() && cola1Aux.primero() == cola2Aux.primero()){
                cola1Aux.desacolar();
                cola2Aux.desacolar();
            }

            result = cola1Aux.colaVacia();
        }

        if(this.lengthCola(cola1Aux) == this.lengthCola(cola2Aux)){
            while(!cola1Aux.colaVacia() && cola1Aux.primero() == cola2Aux.primero()){
                cola1Aux.desacolar();
                cola2Aux.desacolar();
            }

            result = cola1Aux.colaVacia() && cola2Aux.colaVacia();
        }

        while(!cola1Aux.colaVacia()){
            cola1Aux.desacolar();
        }

        while(!cola2Aux.colaVacia()){
            cola2Aux.desacolar();
        }

        return result;
    }

    /**
     * Calcula la cantidad de elementos de una cola y retorna su valor,
     * no se modifica la cola.
     * @param cola
     * @return
     */
    public int lengthCola(ICola cola){
        ICola colaAux = new Cola();
        colaAux.inicializarCola();

        this.copiarCola(cola, colaAux);

        int length = 0;

        while(!colaAux.colaVacia()){
            colaAux.desacolar();
            length++;
        }

        return length;
    }

    /**
     * Verifica si dos colas son identicas, mismos elementos en mismo orden.
     * @param cola1
     * @param cola2
     * @return
     */
    public boolean esIdentica(ICola cola1, ICola cola2){

        ICola colaAux1 = new Cola();
        colaAux1.inicializarCola();

        ICola colaAux2 = new Cola();
        colaAux2.inicializarCola();

        copiarCola(cola1, colaAux1);
        copiarCola(cola2, colaAux2);

        while( (!colaAux1.colaVacia() && !colaAux2.colaVacia())
                && (colaAux1.primero() == colaAux2.primero()) ){
            colaAux1.desacolar();
            colaAux2.desacolar();
        }

        return colaAux1.colaVacia() && colaAux2.colaVacia();
    }

    /**
     * Imprime los valores de una cola en consola.
     * @param cola
     */
    public void printCola(ICola cola){
        while(!cola.colaVacia()) {
            System.out.println(cola.primero());
            cola.desacolar();
        }
    }
}
