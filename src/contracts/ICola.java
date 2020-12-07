package contracts;

/**
 * Cola es una estructura que permite almacenar una colección de valores enteros, de modo tal que el elemento más
 * antiguo sea el primer elemento en salir. También se la conoce como una estructura FIFO.
 */
public interface ICola {
    /**
     * @Tarea Inicializa la estructura cola.
     * @Precondición
     */
    public void inicializarCola();

    /**
      @Tarea Agrega un elemento a la cola.
     @Precondición La estructura debe estar inicializada.
     */
    public void acolar(int x);

    /**
      @Tarea Elimina el elemento más antiguo agregado.
     @Precondición La estructura no debe estar vacía.
     */
    public void desacolar();

    /**
      @Tarea Obtiene el primer elemento a eliminar (no se elimina).
     @Precondición La estructura no debe estar vacía.
     */
    public int primero();

    /**
      @Tarea Indica si la cola no contiene elementos.
     @Precondición La estructura debe estar inicializada.
     */
    public boolean colaVacia();
}
