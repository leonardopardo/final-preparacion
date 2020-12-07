package contracts;

/**
 * Cola con prioridad es una estructura que permite almacenar una colección de valores enteros asociados a una prioridad,
 * de modo tal que el primer elemento a salir sea el de mayor prioridad.
 */
public interface IColaPrioritaria {
    /**
     * @Tarea inicializa la estructura cola.
     * @Precondición No Tiene
     */
    public void inicializarCola();

    /**
     * @Tarea agrega un elemento ‘x’ con prioridad ‘p’, ambos datos suministrados.
     * @Precondición La estructura debe estar inicializada.
     */
    public void acolarPrioridad(int x, int p);

    /**
     * @Tarea elimina el elemento con mayor prioridad.
     * @Precondición La estructura no debe estar vacía.
     */
    public void desacolar();

    /**
     * @Tarea obtiene el valor del dato de mayor prioridad.
     * @Precondición El valor no se elimina. La estructura no debe estar vacía.
     */
    public int primero();

    /**
     * @Tarea obtiene la prioridad del dato de mayor prioridad (no se elimina).
     * @Precondición La estructura no debe estar vacía.
     */
    public int prioridad();

    /**
     * @Tarea indica si la cola no contiene elementos.
     * @Precondición La estructura debe estar inicializada.
     */
    public boolean colaVacia();
}

