package contracts;

/**
 * Pila es una estructura que permite almacenar una colección de valores enteros de modo tal que el último elemento en
 * ingresar sea el primer elemento por salir. También se la conoce como una estructura LIFO.
 */
public interface IPila {
    /**
     * @Tarea Inicializa la estructura pila.
     * @Precondicion No tiene.
     */
    public void inicializarPila();

    /**
     * @Tarea Agrega un elemento.
     * @Precondicion La estructura debe estar inicializada.
     */
    public void apilar(int x);

    /**
     * @Tarea Elimina el último elemento agregado.
     * @Precondicion La estructura no debe estar vacía.
     */
    public void desapilar();

    /**
     * @Tarea Obtiene el primer elemento a eliminar (no se elimina).
     * @Precondicion La estructura no debe estar vacía.
     */
    public int tope();

    /**
     * @Tarea Indica si la pila no contiene elementos.
     * @Precondicion La estructura debe estar inicializada.
     */
    public boolean pilaVacia();
}
