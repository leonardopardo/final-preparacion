package services;

import contracts.*;
import libraries.Cola;
import libraries.ColaPrioritaria;
import libraries.Conjunto;
import libraries.Pila;

public class ArbolService {

    /**
     * Calcula el factor de Equilibrio de cada nodo de forma recursiva.
     * @param a
     * @param cp
     */
    public void factorEquilibrio(IAbb a, IColaPrioritaria cp){
        if(!a.arbolVacio()){
            cp.acolarPrioridad(a.raiz(), Math.abs(altura(a.hijoDer()) - altura(a.hijoIzq())));
            factorEquilibrio(a.hijoDer(), cp);
            factorEquilibrio(a.hijoIzq(), cp);
        }
    }

    public void copiar(IAbb a1, IAbb a2){
        if(!a1.arbolVacio()){
            a2.agregar(a1.raiz());
            copiar(a1.hijoDer(), a2);
            copiar(a1.hijoIzq(), a2);
        }
    }

    public int altura(IAbb a){
        int h = 0;

        if(esSubArbol(a)){

            if(a.hijoDer() != null)
                h = mayor(h, altura(a.hijoDer()));

            if(a.hijoIzq() != null)
                h = mayor(h, altura(a.hijoIzq()));

            h++;
        }

        return h;
    }

    public int nivel(IAbb a, int x){
        int n = -1;

        if(!a.arbolVacio() && a.pertenece(x)){

            if(x < a.raiz())
                n = nivel(a.hijoIzq(), x);

            if(x > a.raiz())
                n = nivel(a.hijoDer(), x);

            n++;
        }

        return n;
    }

    public boolean esHoja(IAbb a){
        return a.arbolVacio();
    }

    public boolean esSubArbol(IAbb a){
        return !esHoja(a);
    }

    public void aCola(IAbb a, ICola c){
        if(!a.arbolVacio()){
            c.acolar(a.raiz());
            aCola(a.hijoDer(), c);
            aCola(a.hijoIzq(), c);
        }
    }

    public void aConjunto(IAbb a, IConjunto c){
        if(!a.arbolVacio()){
            c.agregar(a.raiz());
            aConjunto(a.hijoDer(), c);
            aConjunto(a.hijoIzq(), c);
        }
    }

    public void agregarValores(IAbb a, int[] valores){

        for (int i = 0; i < valores.length ; i++) {

            int val = valores[i];

            if(!a.pertenece(val)){
                a.agregar(val);
            }
        }
    }

    public void agregarDePila(IAbb a, IPila p){
        IPila pAux = new Pila();
        pAux.inicializarPila();

        while (!p.pilaVacia()){
            if(!a.pertenece(p.tope())){
                a.agregar(p.tope());
            }
            pAux.apilar(p.tope());
            p.desapilar();
        }

        while(!pAux.pilaVacia()){
            p.apilar(pAux.tope());
            pAux.desapilar();
        }
    }

    public void agregarDeCola(IAbb a, ICola c){
        ICola cAux = new Cola();
        cAux.inicializarCola();

        while (!c.colaVacia()){
            if(!a.pertenece(c.primero())){
                a.agregar(c.primero());
            }
            cAux.acolar(c.primero());
            c.desacolar();
        }

        while(!cAux.colaVacia()){
            c.acolar(cAux.primero());
            cAux.desacolar();
        }
    }

    public void agregarDeConjunto(IAbb a, IConjunto c){

        IConjunto cAux = new Conjunto();
        cAux.inicializarConjunto();

        while(!c.conjuntoVacio()){
            int val = c.obtener();
            c.sacar(val);

            if(!a.pertenece(val)){
                a.agregar(val);
            }

            cAux.agregar(val);
        }

        while(!cAux.conjuntoVacio()){
            int val = cAux.obtener();
            cAux.sacar(val);

            c.agregar(val);
        }
    }

    public void printOrden(IAbb a){
        if(!a.arbolVacio()){
            printOrden(a.hijoIzq());
            System.out.println(a.raiz());
            printOrden(a.hijoDer());
        }
    }

    public void printOrdenDesc(IAbb a){
        if(!a.arbolVacio()){
            printOrden(a.hijoDer());
            System.out.println(a.raiz());
            printOrden(a.hijoIzq());
        }
    }

    public void printPreorden(IAbb a){
        if(!a.arbolVacio()){
            System.out.println(a.raiz());
            printPreorden(a.hijoDer());
            printPreorden(a.hijoIzq());
        }
    }

    public void printPosorden(IAbb a){
        if(!a.arbolVacio()){
            printPosorden(a.hijoDer());
            printPosorden(a.hijoIzq());
            System.out.println(a.raiz());
        }
    }

    public void recorrerHasta(IAbb a, ICola c, int val){
        if(!a.arbolVacio()){

            if(a.raiz() != val) {

                if(val < a.raiz()) {
                    c.acolar(a.raiz());
                    recorrerHasta(a.hijoIzq(), c, val);
                }

                if(val > a.raiz()){
                    c.acolar(a.raiz());
                    recorrerHasta(a.hijoDer(), c, val);
                }
            }

        }
    }

    public int elMenor(IAbb a){
        return a.hijoIzq().arbolVacio()
            ? a.raiz()
            : elMenor(a.hijoIzq());
    }

    public int elMayor(IAbb a){
        return a.hijoDer().arbolVacio()
                ? a.raiz()
                : elMayor(a.hijoDer());
    }

    public int elementos(IAbb a){
        return a.arbolVacio()
                ? 0
                : 1 + elementos(a.hijoIzq()) + elementos(a.hijoDer());
    }

    public int suma(IAbb a){
        return a.arbolVacio()
                ? 0
                : a.raiz() + suma(a.hijoIzq()) + suma(a.hijoDer());
    }

    public int hojas(IAbb a){

        if (a.arbolVacio())
            return 0;

        if (a.hijoIzq().arbolVacio() && a.hijoDer().arbolVacio())
            return 1;

        return hojas(a.hijoIzq()) + hojas(a.hijoDer());
    }

    private int mayor(int x, int y){
        return x > y
                ? x
                : y;
    }

    private int menor(int x, int y){
        return x < y
                ? x
                : y;
    }
}
