package contracts;

/**
 * Tabla es una estructura que permite almacenar una colección de elementos. Cada elemento consta de un nombre asociado
 * a un código (tipo de dato entero).
 */
public interface ITabla {
    /**
     * @Tarea Inicializa la tabla.
     * @Precondición No tiene.
     */
    public void inicializarTabla();

    /**
     * @Tarea Esta operación agrega un elemento nuevo a la tabla, donde el código corresponde a la cantidad de elementos
     * de la tabla antes de ingresar un nuevo nombre.
     * @Precondición El nombre no debe existir previamente en la tabla. La tabla debe estar inicializada. Al no existir
     * las operaciones eliminarElemento ni actualizarElemento, los códigos serán únicos y consecutivos.
     */
    public void agregar(String nombre);

    /**
     * @Tarea Esta operación permite saber si un nombre ya fue ingresado a la tabla.
     * @Precondición La tabla debe estar inicializada.
     */
    public boolean pertenece(String nombre);

    /**
     * @Tarea Indica cuál es el código de un nombre suministrado (no se elimina).
     * @Precondición El nombre debe existir.
     */
    public int codigo(String nombre);

    /**
     * @Tarea Devuelve los elementos en una estructura cola, donde cada elemento de la cola corresponde a la
     * concatenación del código y el nombre separado por el carácter “;”, según el orden en que se encuentren guardados.
     * @Precondición La tabla debe estar inicializada.
     */
    public IColaCadena tabla();

    /**
     * @Tarea Ordena los elementos de la tabla, alfabéticamente por los nombres.
     * @Precondición La tabla debe estar inicializada.
     */
    public void ordenarNombres();

    /**
     * @Tarea Ordena los elementos de la tabla por los códigos, en forma ascendente.
     * @Precondición La tabla debe estar inicializada.
     */
    public void ordenarCodigos();

    /**
     * @Tarea Informa si la tabla no tiene elementos.
     * @Precondición La tabla debe estar inicializada.
     */
    public boolean estaVacia();
}
