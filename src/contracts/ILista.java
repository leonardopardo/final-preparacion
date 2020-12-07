package contracts;

public interface ILista {
    /**
     * @Tarea Inicializa la lista
     * @Precondición No tiene.
     */
    void inicializarLista();

    /**
     * @Tarea agrega el elemento al inicio de la lista.
     * @Precondición la lista debe estar inicializada.
     * @param x
     */
    void agregarInicio(int x);

    /**
     * @Tarea agrega el elemento al final de la lista.
     * @Precondición la lista debe estar inicializada.
     * @param x
     */
    void agregarFinal(int x);

    /**
     * @Tarea elimina el primer elemento de la lista.
     * @Precondición la lista debe estar inicializada.
     */
    void eliminarInicio();

    /**
     * @Tarea elimina último elemento de la lista.
     * @Precondición la lista debe estar inicializada.
     */
    void eliminarFinal();

    /**
     * @Tarea elimina un elementdo dado de la lista.
     * @Precondición la lista debe estar inicializada.
     * @param x
     */
    void eliminar(int x);

    /**
     * @Tarea devuelve verdadero si un elemento dado está en la lista.
     * @Precondición la lista debe estar inicializada.
     * @param x
     * @return
     */
    boolean existe(int x);

    /**
     * @Tarea devuelve todos los elementos de la lista en el orden que se encuntran.
     * @Precondición la lista debe estar inicializada.
     * @return
     */
    ICola valores();

    /**
     * @Tarea devuelve verdadero si la lista está vacia.
     * @Precondición la lista debe estar inicializada.
     * @return
     */
    boolean listaVacia();
}