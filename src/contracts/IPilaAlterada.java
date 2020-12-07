package contracts;


/**
 * PilaAlterada
 * Este tipo de dato almacena en un vector valores enteros. Para ello se almacenarán desde la posición 0 en forma de
 * llegada, en posiciones pares los valores pares y en posiciones impares los valores impares.
 * Para ello se deberá llevar el control cual es la última posición del último valor par e impar que fue guardado.
 */
public interface IPilaAlterada {

    /**
     * @Tarea permite inicializar la pila.
     * @Precondición no tiene.
     */
    void inicializarPila();

    /**
     * @Tarea agrega un valor según lo establecido en el párrafo anterior.
     * @Precondición La pila debe estar inicializada.
     * @param val
     */
    void poner(int val);

    /**
     * @Tarea elimina el último valor impar ingresado.
     * En caso de no tener valores impares almacenados se eliminará el último valor par ingresado
     * @Precondición La pila no puede estar vacía.
     */
    void sacar();

    /**
     * @Tarea se obtiene el último valor impar ingresado, en caso de que no haya más valores impares
     * se obtiene el último valor par ingresado. Esta operación no modifica la pila.
     * @Precondición La pila no puede estar vacía.
     * @return
     */
    int tope();

    /**
     * @Tarea se obtiene verdadero si la pila no tiene elementos.
     * La pila debe estar inicializada.
     * @return
     */
    boolean pilaVacia();
}
