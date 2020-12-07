package libraries;

import contracts.ICola;
import contracts.IColaCadena;
import contracts.ITabla;

public class Tabla implements ITabla {

    class Tupla{
        int codigo;
        String nombre;
        Tupla siguiente;
    }

    private Tupla primera;
    private int tuplas;

    @Override
    public void inicializarTabla() {
        this.primera = null;
        this.tuplas = 0;
    }

    @Override
    public void agregar(String nombre) {
        Tupla nuevaTupla = new Tupla();
        nuevaTupla.codigo = this.tuplas;
        nuevaTupla.nombre = nombre;
        nuevaTupla.siguiente = null;

        Tupla tuplaActual = this.primera;

        if (tuplaActual == null){
            this.primera = nuevaTupla;
            this.tuplas++;
            return;
        }

        while(tuplaActual.siguiente != null){
            tuplaActual = tuplaActual.siguiente;
        }

        tuplaActual.siguiente = nuevaTupla;

        this.tuplas++;
    }

    @Override
    public boolean pertenece(String nombre) {
        Tupla tuplaActual = this.primera;

        while(tuplaActual != null && !tuplaActual.nombre.equals(nombre)){
            boolean x = tuplaActual.nombre.equals(nombre);
            tuplaActual = tuplaActual.siguiente;
        }

        return tuplaActual != null;
    }

    @Override
    public int codigo(String nombre) {
        Tupla tuplaActual = this.primera;

        while (tuplaActual != null && !tuplaActual.nombre.equals(nombre)) {
            tuplaActual = tuplaActual.siguiente;
        }

        return tuplaActual.codigo;
    }

    @Override
    public IColaCadena tabla() {
        Tupla tuplaActual = this.primera;
        IColaCadena cola = new ColaCadena();
        cola.inicializarCola();

        while (tuplaActual != null){

            cola.acolar( Integer
                    .toString(tuplaActual.codigo)
                    .concat(";")
                    .concat(tuplaActual.nombre)
            );

            tuplaActual = tuplaActual.siguiente;
        }

        return cola;
    }

    @Override
    public void ordenarNombres() {

        IColaCadena colaNombres = new ColaCadena();
        colaNombres.inicializarCola();

        Tupla tuplaActual = this.primera;

        while( tuplaActual != null ) {
            colaNombres.acolar( tuplaActual.nombre );
            tuplaActual = tuplaActual.siguiente;
        }

        IColaCadena colaAuxiliar = new ColaCadena();
        colaAuxiliar.inicializarCola();

        IColaCadena colaOrdenada = new ColaCadena();
        colaOrdenada.inicializarCola();

        String menor;

        while( !colaNombres.colaVacia() ) {

            menor = colaNombres.primero();

            colaNombres.desacolar();

            while( !colaNombres.colaVacia() ) {

                if( menor.compareToIgnoreCase( colaNombres.primero() ) < 0 ) {

                    colaAuxiliar.acolar( colaNombres.primero() );

                    colaNombres.desacolar();

                } else {

                    colaAuxiliar.acolar( menor );

                    menor = colaNombres.primero();

                    colaNombres.desacolar();
                }

            }

            colaOrdenada.acolar(menor);

            while(!colaAuxiliar.colaVacia()) {

                colaNombres.acolar( colaAuxiliar.primero() );

                colaAuxiliar.desacolar();

            }

        }

        while(!colaOrdenada.colaVacia()) {

            colaNombres.acolar(colaOrdenada.primero());

            colaOrdenada.desacolar();

        }

        Tupla primera = !colaNombres.colaVacia()
                ? nombreElemento(colaNombres.primero())
                : null;

        while( !colaNombres.colaVacia() ) {
            Tupla actual = nombreElemento(colaNombres.primero());
            colaNombres.desacolar();

            if( !colaNombres.colaVacia() ) {
                actual.siguiente = nombreElemento(colaNombres.primero());
            } else {
                actual.siguiente = null;
            }
        }

        this.primera = primera;
    }

    @Override
    public void ordenarCodigos(){

        ICola colaCodigos = new Cola();
        colaCodigos.inicializarCola();

        Tupla tuplaActual = this.primera;

        while( tuplaActual != null) {
            colaCodigos.acolar( tuplaActual.codigo );
            tuplaActual = tuplaActual.siguiente;
        }

        ICola colaAux =new Cola();
        colaAux.inicializarCola();

        ICola colaOrdenada=new Cola();
        colaOrdenada.inicializarCola();

        int menor;

        while(!colaCodigos.colaVacia()) {

            menor = colaCodigos.primero();

            colaCodigos.desacolar();

            while(!colaCodigos.colaVacia()) {

                if(colaCodigos.primero() > menor) {

                    colaAux.acolar(colaCodigos.primero());

                    colaCodigos.desacolar();

                } else {

                    colaAux.acolar(menor);

                    menor = colaCodigos.primero();

                    colaCodigos.desacolar();
                }

            }

            colaOrdenada.acolar(menor);

            while(!colaAux.colaVacia()) {

                colaCodigos.acolar(colaAux.primero());

                colaAux.desacolar();

            }

        }

        while(!colaOrdenada.colaVacia()) {

            colaCodigos.acolar(colaOrdenada.primero());

            colaOrdenada.desacolar();

        }


        Tupla primera = !colaCodigos.colaVacia()
                ? codigoElemento(colaCodigos.primero())
                : null;

        while(!colaCodigos.colaVacia()) {

            Tupla actual = codigoElemento(colaCodigos.primero());

            colaCodigos.desacolar();

            if( !colaCodigos.colaVacia() ) {
                actual.siguiente = codigoElemento(colaCodigos.primero());
            } else {
                actual.siguiente = null;
            }
        }

        this.primera = primera;
    }

    @Override
    public boolean estaVacia() {
        return this.primera == null;
    }

    /**
     *
     * @param codigo
     * @return
     */
    private Tupla codigoElemento(int codigo) {

        Tupla tuplaActual = this.primera;

        while ( tuplaActual != null && tuplaActual.codigo != codigo ) {
            tuplaActual = tuplaActual.siguiente;
        }

        return(tuplaActual);
    }

    /**
     *
     * @param nombre
     * @return
     */
    private Tupla nombreElemento(String nombre) {

        Tupla tuplaActual = this.primera;

        while(tuplaActual != null && tuplaActual.nombre != nombre) {
            tuplaActual = tuplaActual.siguiente;
        }

        return(tuplaActual);
    }
}
