package contracts;

/**
 * Grafo es una colección de vértices etiquetados con un valor entero y aristas con un peso asociado, definidas por un
 * vértice origen y un vértice destino. El grafo no puede tener aristas paralelas ni bucles. Los pesos de las aristas
 * son números enteros.
 */
public interface IGrafo {
    /**
     * @Tarea inicializa el grafo.
     * @Precondición
     */
    public void inicializarGrafo();

    /**
     * @Tarea agrega un vértice.
     * @Precondición El grafo debe estar inicializado y el vértice no debe existir.
     */
    public void agregarVertice(int vertice);

    /**
     * @Tarea elimina un vértice suministrado.
     * @Precondición El vértice debe existir.
     */
    public void eliminarVertice(int vertice);

    /**
     * @Tarea agrega una arista identificada por los vértices de origen y destino y el peso.
     * @Precondición Los vértices deben existir, pero no debe existir la arista.
     */
    public void agregarArista(int verticeOrigen, int verticeDestino, int peso);

    /**
     * @Tarea elimina una arista. Se suministran los vértices de origen y destino.
     * @Precondición La arista debe existir.
     */
    public void eliminarArista(int verticeOrigen, int verticeDestino);

    /**
     * @Tarea devuelve el conjunto de vértices de. No elimina los vértices.
     * @Precondición El grafo debe estar inicializado
     */
    public IConjunto vertices();

    /**
     * @Tarea devuelve el peso de la arista, identificada por los vértices de origen y destino.
     * @Precondición La arista debe existir
     */
    public int peso(int verticeOrigen, int verticeDestino);

    /**
     * @Tarea devuelve verdadero si la arista, identificada por los vértices de origen y destino, existe.
     * @Precondición El grafo debe estar inicializado.
     */
    public boolean existeArista(int verticeOrigen, int verticeDestino);
}