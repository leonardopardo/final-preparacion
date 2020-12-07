import contracts.*;
import libraries.*;
import services.ArbolService;
import services.ColaService;
import services.ConjuntoService;
import services.GrafoService;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        IAbb arbol = new Abb();
        arbol.inicializar();
        //int[] valores = { 32, 78, 41, 70, 16, 55, 43, 38, 25, 82, 45, 34 };
        int[] valores = {1,2,4,7,11,3,5,8,9,6,10,12};

        ArbolService arbolService = new ArbolService();
        arbolService.agregarValores(arbol, valores);
        arbolService.printPreorden(arbol);

    }

    static void test(){
        IAbb arbol = new Abb();
        arbol.inicializar();

        int[] valores = { 32, 78, 41, 70, 16, 55, 43, 38, 25, 82, 45, 34 };

        ArbolService arbolService = new ArbolService();
        ColaService colaService = new ColaService();



        ICola colaTernas = ternasAbb(arbol);

        // ternasAbb
        System.out.println("Camino del 1/3 de arbol separado por 3 ceros");
        colaService.printCola(colaTernas);

        System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n");

        // equilibrio máximo
        ICola colaFactor = new Cola();
        colaFactor.inicializarCola();

        System.out.println("Factor equilibrio máximo: " + factorEquilibrioMaximo(arbol, colaFactor));
        System.out.println("Nodos:");
        colaService.printCola(colaFactor);

        System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n");

        IGrafo grafo = new Grafo();
        grafo.inicializarGrafo();

        int[] vertices = {9,2,26,88,3,99,65,12};

        int[][] aristas = {{2,9,6}, {2,26,14}, {2,99,1}, {3,2,1}, {3,9,5}, {3,99,6}, {9,2,16}, {9,3,66}, {9,99,26},
                {9,65,6}, {9,88,1}, {12,9,8}, {12,65,6}, {26,65,1}, {65,2,6}, {65,3,1}, {65,9,16}, {65,99,1}, {88,2,5},
                {99,9,1}};

        GrafoService grafoService = new GrafoService();
        grafoService.cargarGrafoVertices(grafo, vertices);
        grafoService.cargarGrafoAristas(grafo, aristas);

        int v1 = 12;
        int v2 = 99;

        IConjunto cPuentes = verticePuente(grafo, v1, v2);
        ConjuntoService conjuntoService = new ConjuntoService();
        System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n");
        System.out.println("Nodos Puente entre el vertice " + v1 + " y el vertice: " + v2);
        conjuntoService.printConjunto(cPuentes);
    }

    /**
     * Dado un árbol ABB, devuelva una cola con secuencias de valores separados por
     * tres valores iguales a 0, donde los valores de cada secuencia son los nodos
     * pertenecientes al camino del árbol cuya longitud sea igual al tercio de la
     * altura del árbol original.
     * @param arbol
     * @return
     */
    static ICola ternasAbb(IAbb arbol){

        ICola cola = new Cola();
        cola.inicializarCola();

        ArbolService arbolService = new ArbolService();
        arbolService.aCola(arbol, cola);

        ICola cNodosAltura = new Cola();
        cNodosAltura.inicializarCola();

        int altura = arbolService.altura(arbol) / 3;

        while(!cola.colaVacia()){
            if(arbolService.nivel(arbol, cola.primero()) == altura){
                cNodosAltura.acolar(cola.primero());
            }
            cola.desacolar();
        }

        int flag = 0;

        while(!cNodosAltura.colaVacia()){
            arbolService.recorrerHasta(arbol, cola, cNodosAltura.primero());
            cola.acolar(cNodosAltura.primero());
            if(flag < altura){
                cola.acolar(0);
                cola.acolar(0);
                cola.acolar(0);
                flag++;
            }
            cNodosAltura.desacolar();
        }

        return cola;
    }

    /**
     * Dado un árbol ABB, devuelva la magnitud del factor de equilibro máximo y guarde
     * en una cola las etiquetas de los nodos que posean el factor de equilibrio máximo
     * en una cola, ordenados en forma ascendente.
     * @param a
     * @param c
     * @return
     */
    static int factorEquilibrioMaximo(IAbb a, ICola c){

        IColaPrioritaria cp = new ColaPrioritaria();
        cp.inicializarCola();

        ArbolService arbolService = new ArbolService();
        arbolService.factorEquilibrio(a, cp);

        int fMax = cp.prioridad();

        while(!cp.colaVacia() && cp.prioridad() == fMax){
            c.acolar(cp.primero());
            cp.desacolar();
        }

        ColaService service = new ColaService();
        service.ordenarColaAsc(c);

        return fMax;
    }

    /**
     * Dado un vértice v de un grafo, calcular el mayor de los costos de las aristas salientes.
     * @param grafo
     * @param vertice
     * @return
     */
    static int mayorCosto(IGrafo grafo, int vertice){

        IConjunto conjuntoV = new Conjunto();
        conjuntoV.inicializarConjunto();

        conjuntoV = grafo.vertices();

        int costo = 0;

        if(conjuntoV.pertenece(vertice)){
            conjuntoV.sacar(vertice);

            while(!conjuntoV.conjuntoVacio()){
                int v = conjuntoV.obtener();
                conjuntoV.sacar(v);

                if(grafo.existeArista(vertice, v)){
                    if(grafo.peso(vertice, v) > costo ){
                        costo = grafo.peso(vertice, v);
                    }
                }
            }
        }

        return costo;
    }

    /**
     * Dado un Grafo G y dos vértices v1 y v2, escribir un método que permita obtener el
     * conjunto de todos los vértices puente entre v1 y v2. Se define que un vértice p es
     * puente entre dos vértices o y d, si hay una arista que comienza en o y termina en
     * p y otra que comienza en p y termina en d.
     * @param grafo
     * @param v1
     * @param v2
     * @return
     */
    static IConjunto verticePuente(IGrafo grafo, int v1, int v2){

        IConjunto conjuntoV = new Conjunto();
        conjuntoV.inicializarConjunto();

        IConjunto c = new Conjunto();
        c.inicializarConjunto();

        conjuntoV = grafo.vertices();

        if( conjuntoV.pertenece(v1) && conjuntoV.pertenece(v2) ){
            conjuntoV.sacar(v1);
            conjuntoV.sacar(v2);

            while(!conjuntoV.conjuntoVacio()){
                int p = conjuntoV.obtener();
                conjuntoV.sacar(p);

                if(grafo.existeArista(v1, p) && grafo.existeArista(p, v2)){
                    c.agregar(p);
                }
            }
        }

        return c;
    }

    /**
     * Dado dos grafos, devolver un nuevo grafo cuyo conjunto de vértices sea la
     * diferencia simétrica entre los conjuntos de vértices de los dos grafos de origen y
     * las aristas donde sus vértices pertenezcan al conjunto de vértices del nuevo grafo.
     * @param g1
     * @param g2
     * @return
     */
    static IGrafo diferenciaSimetricaGrafo(IGrafo g1, IGrafo g2){

        IConjunto gC1 = g1.vertices();
        IConjunto gC2 = g2.vertices();

        IGrafo grafo = new Grafo();
        grafo.inicializarGrafo();

        ConjuntoService cService = new ConjuntoService();
        IConjunto cAux = cService.diferenciaSimetrica(gC1, gC2);

        while(!cAux.conjuntoVacio()){
            int v = cAux.obtener();
            cAux.sacar(v);
            grafo.agregarVertice(v);
        }

        IConjunto vertices = grafo.vertices();

        IConjunto cAux2 = new Conjunto();
        cAux2.inicializarConjunto();

        while (!vertices.conjuntoVacio()){
            int v1 = vertices.obtener();
            vertices.sacar(v1);

            while(!vertices.conjuntoVacio()){
                int v2 = vertices.obtener();
                vertices.sacar(v2);

                if( g1.vertices().pertenece(v1) && g1.vertices().pertenece(v2)){
                    if( g1.existeArista(v1, v2) )
                        grafo.agregarArista(v1, v2, g1.peso(v1, v2));

                    if(g1.existeArista(v2, v1))
                        grafo.agregarArista(v2, v1, g1.peso(v2, v1));
                }

                if(g2.vertices().pertenece(v1) && g2.vertices().pertenece(v2)){
                    if(g2.existeArista(v1, v2) )
                        grafo.agregarArista(v1, v2, g2.peso(v1, v2));

                    if(g2.existeArista(v2, v1) )
                        grafo.agregarArista(v2, v1, g2.peso(v2, v1));
                }

                cAux2.agregar(v2);
            }

            while(!cAux2.conjuntoVacio()){
                int x = cAux2.obtener();
                cAux2.sacar(x);
                vertices.agregar(x);
            }
        }

        return grafo;
    }
}