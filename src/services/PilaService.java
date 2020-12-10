package services;

import contracts.ICola;
import contracts.IPila;
import libraries.Cola;
import libraries.Pila;

public class PilaService {

    /**
     * Transforma una pila a una cola, ambas pasadas como parámetro.
     * los valores de la cola quedan en orden inverso a como fueron
     * cargados en la pila original, la pila no se pierde.
     * @param pila
     * @param cola
     */
    public void aColaDirecto(IPila pila, ICola cola){

        IPila pilaAux = new Pila();
        pilaAux.inicializarPila();

        while(!pila.pilaVacia()){
            cola.acolar(pila.tope());
            pilaAux.apilar(pila.tope());
            pila.desapilar();
        }

        while(!pilaAux.pilaVacia()){
            pila.apilar(pilaAux.tope());
            pilaAux.desapilar();
        }
    }

    /**
     * Transforma una pila a una cola, ambas pasadas como parámetro.
     * Los valores de la cola queda en el orden que fueron cargados
     * en la pila original, la pila no se pierde.
     * @param pila
     * @param cola
     */
    public void aColaOrdenada(IPila pila, ICola cola){
        IPila pilaAux = new Pila();
        pilaAux.inicializarPila();

        while(!pila.pilaVacia()){
            pilaAux.apilar(pila.tope());
            pila.desapilar();
        }

        while(!pilaAux.pilaVacia()){
            cola.acolar(pilaAux.tope());
            pila.apilar(pilaAux.tope());
            pilaAux.desapilar();
        }
    }

    /**
     * Copia una pila en otra pila, ambas pasadas por argumento,
     * la pila original no se pierde.
     * @param pila1
     * @param pila2
     */
    public void copiarPila(IPila pila1, IPila pila2){

        IPila pilaAux = new Pila();
        pilaAux.inicializarPila();

        while(!pila1.pilaVacia()){
            pilaAux.apilar(pila1.tope());
            pila1.desapilar();
        }

        while(!pilaAux.pilaVacia()){
            pila1.apilar(pilaAux.tope());
            pila2.apilar(pilaAux.tope());
            pilaAux.desapilar();
        }
    }

    /**
     * Invierte una pila dada, se modifica la pila original
     * inivirtiendo el orden de los valores agregados.
     * @param pila
     */
    public void invertirPila(IPila pila){
        ICola colaAux = new Cola();
        colaAux.inicializarCola();

        while(!pila.pilaVacia()){
            colaAux.acolar(pila.tope());
            pila.desapilar();
        }

        while(!colaAux.colaVacia()){
            pila.apilar(colaAux.primero());
            colaAux.desacolar();
        }
    }

    /**
     * Ordena una pila de forma ascendente, la pila se modifica.
     * @param pila
     */
    public void ordenarPilaAsc(IPila pila){

        IPila pilaAux = new Pila();
        pilaAux.inicializarPila();

        IPila pilaOrdenada = new Pila();
        pilaOrdenada.inicializarPila();

        while (!pila.pilaVacia()){
            int min = pila.tope();
            pila.desapilar();

            while(!pila.pilaVacia()){
                if(pila.tope() < min){
                    pilaAux.apilar(min);
                    min = pila.tope();
                } else {
                    pilaAux.apilar(pila.tope());
                }

                pila.desapilar();
            }

            while(!pilaAux.pilaVacia()){
                pila.apilar(pilaAux.tope());
                pilaAux.desapilar();
            }

            pilaOrdenada.apilar(min);
        }

        while(!pilaOrdenada.pilaVacia()){
            pila.apilar(pilaOrdenada.tope());
            pilaOrdenada.desapilar();
        }
    }

    /**
     * Ordena una pila de forma descendente, la pila se modifica.
     * @param pila
     */
    public void ordenarPilaDesc(IPila pila){

        IPila pilaAux = new Pila();
        pilaAux.inicializarPila();

        IPila pilaOrdenada = new Pila();
        pilaOrdenada.inicializarPila();

        while (!pila.pilaVacia()){
            int max = pila.tope();
            pila.desapilar();

            while(!pila.pilaVacia()){
                if(pila.tope() > max){
                    pilaAux.apilar(max);
                    max = pila.tope();
                } else {
                    pilaAux.apilar(pila.tope());
                }

                pila.desapilar();
            }

            while(!pilaAux.pilaVacia()){
                pila.apilar(pilaAux.tope());
                pilaAux.desapilar();
            }

            pilaOrdenada.apilar(max);
        }

        while(!pilaOrdenada.pilaVacia()){
            pila.apilar(pilaOrdenada.tope());
            pilaOrdenada.desapilar();
        }

    }

    /**
     * Verifica si dos pilas son identicas en cantidad y posición de elemntos,
     * no se modifican las pilas.
     *
     * @param pila1
     * @param pila2
     * @return
     */
    public boolean esIdentica(IPila pila1, IPila pila2){

        if(lenghtPila(pila1) != lenghtPila(pila2))
            return false;

        IPila pila1Aux = new Pila();
        pila1Aux.inicializarPila();

        IPila pila2Aux = new Pila();
        pila2Aux.inicializarPila();

        copiarPila(pila1, pila1Aux);
        copiarPila(pila2, pila2Aux);

        boolean result = false;

        while(!pila1Aux.pilaVacia() && !pila2Aux.pilaVacia() && pila1Aux.tope() == pila2Aux.tope()){
            pila1Aux.desapilar();
            pila2Aux.desapilar();
        }

        result = pila1Aux.pilaVacia() && pila2Aux.pilaVacia();

        while(!pila1Aux.pilaVacia())
            pila1Aux.desapilar();

        while(!pila2Aux.pilaVacia())
            pila2Aux.desapilar();

        return result;
    }

    /**
     * Calcula la cantidad de elmentos de una pila,
     * no modifica la pila original.
     * @param pila
     * @return
     */
    public int lenghtPila(IPila pila){

        IPila pilaAux = new Pila();
        pilaAux.inicializarPila();

        this.copiarPila(pila, pilaAux);

        int length = 0;

        while(!pilaAux.pilaVacia()){
            pilaAux.desapilar();
            length++;
        }

        return length;
    }

    /**
     * Imprime los valores de una pila en pantalla.
     * @param pila
     */
    public void printConsole(IPila pila){
        while(!pila.pilaVacia()) {
            System.out.println(pila.tope());
            pila.desapilar();
        }
    }

    /**
     * Calcula el promedio de los número pares de una pila.
     * @param pila
     * @return
     */
    public float promedioDePares(IPila pila){
        IPila pilaAux = new Pila();
        pilaAux.inicializarPila();

        copiarPila(pila, pilaAux);

        int acum = 0;
        int cant = 0;

        while(!pilaAux.pilaVacia()){
            if(pilaAux.tope() % 2 == 0){
               acum += pilaAux.tope();
               cant++;
            }

            pilaAux.desapilar();
        }

        return cant == 0
                ? 0
                : acum / cant;
    }

    /**
     * Suma los elementos de una pila, la pila no se destruye.
     * @param pila
     * @return
     */
    public int sumarElementos(IPila pila){
        IPila pilaAux = new Pila();
        pilaAux.inicializarPila();

        this.copiarPila(pila, pilaAux);

        int acum = 0;

        while(!pilaAux.pilaVacia()){
            acum += pilaAux.tope();
            pilaAux.desapilar();
        }

        return acum;
    }

    /**
     * Calcula el promedio de los elementos de una pila, no modifica la pila.
     * @param pila
     * @return
     */
    public int promedio(IPila pila){
        IPila pilaAux = new Pila();
        pilaAux.inicializarPila();

        this.copiarPila(pila, pilaAux);

        int acum = 0;
        int cant = 0;

        while(!pilaAux.pilaVacia()){
            acum += pilaAux.tope();
            pilaAux.desapilar();
            cant++;
        }

        return cant == 0
                ? 0
                : acum / cant;
    }
}
