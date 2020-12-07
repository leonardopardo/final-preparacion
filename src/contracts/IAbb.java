package contracts;

/**
 * Árbol de búsqueda binaria es una colección de elementos ordenados en forma jerárquica (todos
 * números enteros). Entre dos elementos vinculados se define la relación padre-hijo. Cada elemento
 * tiene sólo un padre, excepto el elemento raíz del árbol que no tiene padre.
 */
public interface IAbb {
    /**
     * @Tarea permite inicializar el árbol.
     * @Precondición
     */
    void inicializar();

    /**
     * @Tarea devuelve el valor de la raiz. No elimina el elemento.
     * @Precondición El árbol no puede estar vacío.
     * @return
     */
    int raiz();

    /**
     * @Tarea devuelve la referencia al subárbol izquierdo. No elimina los elementos del sub-árbol.
     * @Precondición El árbol no puede estar vacío.
     * @return
     */
    IAbb hijoIzq();

    /**
     * @Tarea devuelve la referencia al subárbol derecho. No elimina los elementos del sub-árbol.
     * @Precondición El árbol no puede estar vacío.
     * @return
     */
    IAbb hijoDer();

    /**
     * @Tarea agrega un valor suministrado.
     * @Precondición El árbol debe estar inicializado y no debe existir el valor.
     */
    void agregar(int valor);

    /**
     * @Tarea elimina un valor suministrado.
     * @Precondición El valor debe existir.
     */
    void eliminar(int valor);

    /**
     * @Tarea devuelve verdadero si el árbol no contiene elementos.
     * @Precondición La estructura debe estar inicializada.
     * @return
     */
    boolean arbolVacio();

    /**
     * @Tarea devuelve verdadero si el valor suministrado pertenece al árbol.
     * @Precondición EL árbol debe estar inicializado.
     * @return
     */
    boolean pertenece(int valor);
}