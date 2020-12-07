package contracts;

/**
 * Diccionario simple es una colección de pares asociados clave-valor, ambos números enteros. Las claves son únicas. No
 * puede existir clave sin valor asociado.
 */
public interface IDiccionarioSimple {
    /**
     * @Tarea inicializa el diccionario.
     * @Precondición
     */
    public void inicializarDiccionarioSimple();

    /**
     * @Tarea permite agregar una clave con un valor, ambos suministrados.
     * @Precondición El diccionario debe estar inicializado y la clave no debe existir.
     */
    public void agregar(int clave, int valor);

    /**
     * @Tarea permite eliminar una clave suministrada.
     * @Precondición La clave debe existir.
     */
    public void eliminar(int clave);

    /**
     * @Tarea devuelve el valor asociado a una clave suministrada.
     * @Precondición No elimina el valor. La clave debe existir.
     */
    public int obtener(int clave);

    /**
     * @Tarea devuelve el conjunto de claves del diccionario. No elimina las claves.
     * @Precondición El diccionario debe estar inicializado
     */
    public IConjunto claves();
}
