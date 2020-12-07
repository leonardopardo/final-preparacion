package contracts;

/**
 * Diccionario múltiple es una colección de elementos asociados clave-valores. La clave y los valores son números
 * enteros. Las claves son únicas. No puede existir clave sin valor asociado. Los valores son únicos para una misma
 * clave.
 */
public interface IDiccionarioMultiple {
    /**
     * @Tarea inicializa el diccionario.
     * @Precondición
     */
    public void inicializarDiccionarioMultiple();

    /**
     * @Tarea agrega un valor a una clave, ambos datos suministrados.
     * @Precondición El diccionario debe estar inicializado y el valor no debe existir para esa clave. Si no existe la
     * clave, se agrega.
     */
    public void agregar(int clave, int valor);

    /**
     * @Tarea elimina una clave suministrada junto con los valores asociados.
     * @Precondición La clave debe existir.
     */
    public void eliminar(int clave);

    /**
     * @Tarea elimina un valor asociado a una clave, ambos datos suministrados.
     * @Precondición Ambos deben existir.
     */
    public void eliminarValor(int clave, int valor);

    /**
     * @Tarea devuelve el conjunto de valores asociados a una clave suministrada.
     * @Precondición No elimina los valores. La clave debe existir.
     */
    public IConjunto obtener(int clave);

    /**
     * @Tarea devuelve el conjunto de claves del diccionario. No elimina las claves.
     * @Precondición El diccionario debe estar inicializado.
     */
    public IConjunto claves();
}