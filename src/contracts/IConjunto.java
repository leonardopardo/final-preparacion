package contracts;

/**
 * Conjunto es una estructura que permite almacenar una colección de valores enteros, no repetidos y no necesariamente
 * ordenado.
 */
public interface IConjunto {
    /**
     * @Tarea inicializa el conjunto.
     * @Precondición No tiene.
     */
    public void inicializarConjunto();

    /**
     * @Tarea agrega un elemento suministrado.
     * @Precondición El conjunto debe estar inicializado y el elemento no debe existir.
     */
    public void agregar(int x);

    /**
     * @Tarea elimina un elemento suministrado.
     * @Precondición EL elemento debe pertenecer al conjunto.
     */
    public void sacar(int x);

    /**
     * @Tarea devuelve un valor cualquiera del conjunto.
     * @Precondición El elemento no se elimina. El conjunto no debe estar vacío.
     */
    public int obtener();

    /**
     * @Tarea devuelve verdadero si el conjunto no tiene elementos.
     * @Precondición El conjunto debe estar inicializado.
     */
    public boolean conjuntoVacio();

    /**
     * @Tarea devuelve verdadero si el valor suministrado pertenece al conjunto.
     * @Precondición El conjunto debe estar inicializado.
     */
    public boolean pertenece(int x);
}