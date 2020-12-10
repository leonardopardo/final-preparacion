package services;

import contracts.IConjunto;
import contracts.IGrafo;
import libraries.Conjunto;

public class GrafoService {

    public void clonarGrafo(IGrafo grafoOrigen, IGrafo grafoDestino){

        IConjunto c1 = new Conjunto();
        c1.inicializarConjunto();

        IConjunto c2 = new Conjunto();
        c2.inicializarConjunto();

        c1 = grafoOrigen.vertices();

        while(!c1.conjuntoVacio()){
            int v1 = c1.obtener();
            c1.sacar(v1);
            grafoDestino.agregarVertice(v1);

            while(!c1.conjuntoVacio()){
                int v2 = c1.obtener();
                c1.sacar(v2);
                grafoDestino.agregarVertice(v2);

                if(grafoOrigen.existeArista(v1, v2)){
                    grafoDestino.agregarArista(v1, v2, grafoOrigen.peso(v1, v2));
                }

                if(grafoOrigen.existeArista(v2, v1)) {
                    grafoDestino.agregarArista(v2, v1, grafoOrigen.peso(v2, v1));
                }

                c2.agregar(v2);
            }

            while(!c2.conjuntoVacio()){
                int v3 = c2.obtener();
                c2.sacar(v3);
                c1.agregar(v3);
            }
        }
    }

    public void cargarGrafoVertices(IGrafo g, int[] v){
        for (int i = 0; i < v.length; i++) {
            if(!g.vertices().pertenece(v[i])){
                g.agregarVertice(v[i]);
            }
        }
    }

    public void cargarGrafoAristas(IGrafo g, int[][] a){
        for (int i = 0; i < a.length; i++) {
            if(g.vertices().pertenece(a[i][0])
                    && g.vertices().pertenece(a[i][1])
                    && !g.existeArista(a[i][0],a[i][1])) {
                g.agregarArista(a[i][0],a[i][1],a[i][2]);
            }
        }
    }

    public void trasponer(IGrafo g1, IGrafo g2){

        IConjunto cAux = new Conjunto();
        cAux.inicializarConjunto();

        IConjunto v1 = g1.vertices();

        copiarVertices(g1, g2);

        while(!v1.conjuntoVacio()){
            int vAux1 = v1.obtener();
            v1.sacar(vAux1);

            while(!v1.conjuntoVacio()){
                int vAux2 = v1.obtener();
                v1.sacar(vAux2);

                if(g1.existeArista(vAux1, vAux2)){
                    g2.agregarArista(vAux2, vAux1, g1.peso(vAux1, vAux2));
                }

                if(g1.existeArista(vAux2, vAux1)){
                    g2.agregarArista(vAux1, vAux2, g1.peso(vAux2, vAux1));
                }

                cAux.agregar(vAux2);
            }

            while(!cAux.conjuntoVacio()){
                int x = cAux.obtener();
                cAux.sacar(x);
                v1.agregar(x);
            }
        }
    }

    /**
     * Copia los vertices de un grafo a otro grafo.
     * @param g1
     * @param g2
     */
    public void copiarVertices(IGrafo g1, IGrafo g2){

        IConjunto c = g1.vertices();

        while(c.conjuntoVacio()){
            int v = c.obtener();
            c.sacar(v);

            g2.agregarVertice(v);
        }
    }

    public void printGrafo(IGrafo g){

        IConjunto cAux1 = g.vertices();

        IConjunto cAux2 = new Conjunto();
        cAux2.inicializarConjunto();

        while(!cAux1.conjuntoVacio()){
            int v1 = cAux1.obtener();
            cAux1.sacar(v1);

            while(!cAux1.conjuntoVacio()){
                int v2 = cAux1.obtener();
                cAux1.sacar(v2);

                if(g.existeArista(v1, v2)){
                    System.out.println("Origen: " + v1 + "\t|\t" + "Destino: " + v2 + "\t|\t" + "Peso: " + g.peso(v1, v2));
                }

                if(g.existeArista(v2, v1)){
                    System.out.println("Origen: " + v2 + "\t|\t" + "Destino: " + v1 + "\t|\t" + "Peso: " + g.peso(v2, v1));
                }

                cAux2.agregar(v2);
            }

            while(!cAux2.conjuntoVacio()){
                int v3 = cAux2.obtener();
                cAux2.sacar(v3);
                cAux1.agregar(v3);
            }
        }

    }
}
