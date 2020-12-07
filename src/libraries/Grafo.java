package libraries;

import contracts.IConjunto;
import contracts.IGrafo;

/**
 * @Implementación Dinámica
 * @Estrategia Ordena por prioririodiad, la primera es la más alta.
 * @Costo
 */
public class Grafo implements IGrafo {
    int[][] matriz;
    static final int dim = 100;

    @Override
    public void inicializarGrafo() {
        this.matriz = new int[dim][dim];
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                this.matriz[i][j] = 0;
            }
        }
    }

    @Override
    public void agregarVertice(int vertice) {
        this.matriz[vertice][vertice] = 1;
    }

    @Override
    public void eliminarVertice(int vertice) {

        this.matriz[vertice][vertice] = 0;

        for (int i = 0; i < dim ; i++) {

            this.matriz[i][vertice] = 0;

            this.matriz[vertice][i] = 0;
        }
    }

    @Override
    public void agregarArista(int verticeOrigen, int verticeDestino, int peso) {
        this.matriz[verticeOrigen][verticeDestino] = peso;
    }

    @Override
    public void eliminarArista(int verticeOrigen, int verticeDestino) {
        this.matriz[verticeOrigen][verticeDestino] = 0;
    }

    @Override
    public IConjunto vertices() {

        IConjunto c = new Conjunto();
        c.inicializarConjunto();

        for (int i = 0; i < dim; i++) {
            if(this.matriz[i][i] != 0) c.agregar(i);
        }

        return c;
    }

    @Override
    public int peso(int verticeOrigen, int verticeDestino) {
        return this.matriz[verticeOrigen][verticeDestino];
    }

    @Override
    public boolean existeArista(int verticeOrigen, int verticeDestino) {
        return this.matriz[verticeOrigen][verticeDestino] != 0;
    }
}
