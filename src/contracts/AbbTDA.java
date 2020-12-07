package contracts;

public interface AbbTDA {

    /**@Tarea : permite inicializar el Arbol **/
    void InicializarABB();


    /** @Tarea Devuelve el valor de la raiz. El elemento no lo elimina.  @Precondición    El árbol no puede estar vacio
     * @return**/
    int Raiz();



    /** @Tarea Devuelve la referencia al subárbol izquierdo. No elimina los elementos del sub árbol. @Precondición El árbol no puede estar vacío.**/
    AbbTDA HijoIzq();


    /** @Tarea Devuelve la referencia al subárbol derecho. No elimina los elementos del sub árbol.   @Precondición El árbol no puede estar vacío.**/
    AbbTDA HijoDer();


    /** @Tarea Agrega un valor x suministrado. @Precondición El árbol debe estar inicializado y no debe existir el    valor **/
    void Agregar(int x);


    /**@Tarea Elimina un valor suministrado. @Precondición    El valor debe existir **/
    void Eliminar(int x);


    /** @Tarea Devuelve verdadero si el valor suministrado pertenece al árbol.   @Precondición EL árbol debe estar inicializado **/
    boolean Pertenece(int x);


    /** @Tarea Devuelve verdadero o falso si el árbol contiene elementos o no.  @Precondición La estructura debe estar inicializada. **/
    boolean ArbolVacio();


}