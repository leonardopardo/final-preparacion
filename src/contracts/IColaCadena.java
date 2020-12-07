package contracts;

/**
 * Cola es una estructura que permite almacenar una colección de cadenas de caracteres (Strings), de modo tal que el
 * elemento más antiguo sea el primer elemento en salir. También se la conoce como una estructura FIFO.
 */
public interface IColaCadena {
    /**
     * @Tarea Inicializa la estructura cola.
     * @Precondición No tiene.
     */
    public void inicializarCola();

    /**
     * @Tarea Agrega una cadena a la cola.
     * @Precondición La estructura debe estar inicializada.
     */
    public void acolar(String cadena);

    /**
     * @Tarea Elimina la cadena más antigua agregada.
     * @Precondición La estructura no debe estar vacía.
     */
    public void desacolar();

    /**
     * @Tarea Obtiene la primera cadena a eliminar (no se elimina).
     * @Precondición La estructura no debe estar vacía.
     */
    public String primero();

    /**
     * @Tarea Indica si la cola no contiene cadenas.
     * @Precondición La estructura debe estar inicializada.
     */
    public boolean colaVacia();
}
