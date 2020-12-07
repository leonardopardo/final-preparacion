package services;

import contracts.IConjunto;
import libraries.Conjunto;

public class ConjuntoService {

    /**
     * Pasa los valores de un conjunto a otro, se pierden los valores del
     * conjunto original.
     * @param cOrigen
     * @param cDestino
     */
    public void pasarConjunto(IConjunto cOrigen, IConjunto cDestino){
        while(!cOrigen.conjuntoVacio()){
            int val = cOrigen.obtener();
            cOrigen.sacar(val);

            cDestino.agregar(val);
        }
    }

    /**
     * Hace una copia en otro conjunto, el conjunto original no se modifica.
     * @param cOrigen
     * @param cDestino
     */
    public void copiarConjunto(IConjunto cOrigen, IConjunto cDestino){
        IConjunto cAux = new Conjunto();
        cAux.inicializarConjunto();

        vaciarConjunto(cDestino);

        while(!cOrigen.conjuntoVacio()){
            int val = cOrigen.obtener();
            cOrigen.sacar(val);

            cDestino.agregar(val);
            cAux.agregar(val);
        }

        while(!cAux.conjuntoVacio()){
            int val = cAux.obtener();
            cAux.sacar(val);
            cOrigen.agregar(val);
        }
    }

    /**
     * Elimina todos los elementos de un conjunto.
     * @param c
     */
    public void vaciarConjunto(IConjunto c){
        while(!c.conjuntoVacio()){
            int val = c.obtener();
            c.sacar(val);
        }
    }

    /**
     * Verifica si dos conjuntos son iguales
     * @param c1
     * @param c2
     * @return
     */
    public boolean esIgual(IConjunto c1, IConjunto c2){

        if(lenghtConjunto(c1) != lenghtConjunto(c2))
            return false;

        IConjunto c1Aux = new Conjunto();
        c1Aux.inicializarConjunto();

        IConjunto c2Aux = new Conjunto();
        c2Aux.inicializarConjunto();

        copiarConjunto(c1, c1Aux);
        copiarConjunto(c2, c2Aux);

        int flag = 0;

        while(!c1Aux.conjuntoVacio()){
            int val = c1Aux.obtener();
            c1Aux.sacar(val);
            if(!c2.pertenece(val)){
                flag++;
            }
        }

        return flag == 0;
    }

    /**
     * Cuenta la cantidad de elmentos de un conjunto.
     * @param c
     * @return
     */
    public int lenghtConjunto(IConjunto c){
        IConjunto cAux = new Conjunto();
        cAux.inicializarConjunto();

        copiarConjunto(c, cAux);

        int length = 0;

        while(!cAux.conjuntoVacio()){
            int val = cAux.obtener();
            cAux.sacar(val);
            length++;
        }

        return length;
    }

    /**
     * Genera un nuevo conjunto con la unión de dos conjuntos dados,
     * no se modifican los conjuntos dados.
     * @param c1
     * @param c2
     * @return
     */
    public IConjunto union(IConjunto c1, IConjunto c2){

        IConjunto cUnion = new Conjunto();
        cUnion.inicializarConjunto();

        IConjunto c1Aux = new Conjunto();
        c1Aux.inicializarConjunto();

        IConjunto c2Aux = new Conjunto();
        c2Aux.inicializarConjunto();

        copiarConjunto(c1, c1Aux);
        copiarConjunto(c2, c2Aux);

        while(!c1Aux.conjuntoVacio()){
            int val = c1Aux.obtener();
            c1Aux.sacar(val);
            cUnion.agregar(val);
        }

        while(!c2Aux.conjuntoVacio()){
            int val = c2Aux.obtener();
            c2Aux.sacar(val);

            if(!cUnion.pertenece(val)){
                cUnion.agregar(val);
            }
        }

        vaciarConjunto(c2Aux);

        return cUnion;
    }

    /**
     * Obtiene un nuevo conjunto con la interseccion de los dos conjuntos dados.
     * Los conjuntos originales no se modifican.
     * @param c1
     * @param c2
     * @return
     */
    public IConjunto interseccion(IConjunto c1, IConjunto c2){

        IConjunto iConjunto = new Conjunto();
        iConjunto.inicializarConjunto();

        IConjunto c1Aux = new Conjunto();
        c1Aux.inicializarConjunto();

        IConjunto c2Aux = new Conjunto();
        c2Aux.inicializarConjunto();

        copiarConjunto(c1, c1Aux);
        copiarConjunto(c2, c2Aux);

        while(!c1Aux.conjuntoVacio()){
            int val = c1Aux.obtener();
            c1Aux.sacar(val);

            if(c2Aux.pertenece(val)){
                iConjunto.agregar(val);
            }
        }

        vaciarConjunto(c2Aux);

        return iConjunto;
    }

    public IConjunto diferencia(IConjunto c1, IConjunto c2){

        IConjunto dConjunto = new Conjunto();
        dConjunto.inicializarConjunto();

        IConjunto c1Aux = new Conjunto();
        c1Aux.inicializarConjunto();

        IConjunto c2Aux = new Conjunto();
        c2Aux.inicializarConjunto();

        copiarConjunto(c1, c1Aux);
        copiarConjunto(c2, c2Aux);

        while(!c1Aux.conjuntoVacio()){
            int val = c1Aux.obtener();
            c1Aux.sacar(val);

            if(!c2Aux.pertenece(val)){
                dConjunto.agregar(val);
            }
        }

        vaciarConjunto(c2Aux);

        return dConjunto;
    }

    /**
     * Calcula la diferencia simética de dos conjuntos, los conjuntos originales
     * no se modifican, devuleve un nuevo conjunto con los valores no comunes.
     * @param c1
     * @param c2
     * @return
     */
    public IConjunto diferenciaSimetrica(IConjunto c1, IConjunto c2){

        IConjunto dsConjunto = new Conjunto();
        dsConjunto.inicializarConjunto();

        IConjunto c1Aux = new Conjunto();
        c1Aux.inicializarConjunto();

        IConjunto c2Aux = new Conjunto();
        c2Aux.inicializarConjunto();

        copiarConjunto(c1, c1Aux);
        copiarConjunto(c2, c2Aux);

        while(!c1Aux.conjuntoVacio()){
            int val = c1Aux.obtener();
            c1Aux.sacar(val);

            if(!c2Aux.pertenece(val))
                dsConjunto.agregar(val);
            else
                c2Aux.sacar(val);
        }

        while(!c2Aux.conjuntoVacio()){
            int val = c2Aux.obtener();
            c2Aux.sacar(val);
            dsConjunto.agregar(val);
        }

        return dsConjunto;
    }

    /**
     * Valida si el primer conjunto es subconjunto del segundo,
     * no se modifican los conjuntos.
     * @param c1
     * @param c2
     * @return
     */
    public boolean estaIncluido(IConjunto c1, IConjunto c2){

        IConjunto c1Aux = new Conjunto();
        c1Aux.inicializarConjunto();

        copiarConjunto(c1, c1Aux);

        int flag = 0;

        while(!c1Aux.conjuntoVacio()){
            int val = c1Aux.obtener();
            c1Aux.sacar(val);

            if(!c2.pertenece(val)){
                flag++;
            }
        }

        return flag == 0;
    }

    public void printConjunto(IConjunto c){
        while(!c.conjuntoVacio()){
            int v = c.obtener();
            c.sacar(v);

            System.out.println(v);
        }
    }
}
