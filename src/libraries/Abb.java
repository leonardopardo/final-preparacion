package libraries;

import contracts.IAbb;

public class Abb implements IAbb {

    class Nodo {
        int valor;
        IAbb der, izq;
    }

    private Nodo root;

    @Override
    public void inicializar() {
        this.root = null;
    }

    @Override
    public int raiz() {
        return this.root.valor;
    }

    @Override
    public IAbb hijoIzq() {
        return this.root.izq;
    }

    @Override
    public IAbb hijoDer() {
        return this.root.der;
    }

    @Override
    public void agregar(int valor) {
        if(this.root == null){
            this.root = new Nodo();
            this.root.valor = valor;
            this.root.izq = new Abb();
            this.root.izq.inicializar();
            this.root.der = new Abb();
            this.root.der.inicializar();
        } else if(valor < this.root.valor){
            this.hijoIzq().agregar(valor);
        } else {
            this.hijoDer().agregar(valor);
        }
    }

    @Override
    public void eliminar(int valor) {
        if(this.root.valor > valor){
            this.root.izq.eliminar(valor);
        } else if(this.root.valor < valor) {
            this.root.der.eliminar(valor);
        } else {
            if(this.root.izq.arbolVacio() && this.root.der.arbolVacio()){
                this.root = null;
            } else {
                if(!this.root.izq.arbolVacio()){
                    int v = mayor(this.root.izq);
                    this.root.valor = v;
                    this.root.izq.eliminar(v);
                } else {
                    int v = menor(this.root.der);
                    this.root.valor = v;
                    this.root.der.eliminar(v);
                }
            }
        }
    }

    /**
     * Busca el menor de forma recursiva.
     * @param arbol
     * @return
     */
    private int menor(IAbb arbol) {
        if(arbol.hijoIzq().arbolVacio()){
            return arbol.raiz();
        } else {
            return menor(arbol.hijoIzq());
        }
    }

    /**
     * Busca el mayor de forma recursiva.
     * @param arbol
     * @return
     */
    private int mayor(IAbb arbol){
        if(arbol.hijoDer().arbolVacio()){
            return arbol.raiz();
        }else{
            return mayor(arbol.hijoDer());
        }
    }

    @Override
    public boolean arbolVacio() {
        return this.root == null;
    }

    @Override
    public boolean pertenece(int valor) {
        if(this.root == null){
            return false;
        } else if(this.root.valor == valor){
            return true;
        } else if(this.root.valor > valor){
            return this.root.izq.pertenece(valor);
        } else {
            return this.root.der.pertenece(valor);
        }
    }
}
