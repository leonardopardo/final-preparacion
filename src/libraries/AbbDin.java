package libraries;

import contracts.AbbTDA;

public class AbbDin implements AbbTDA {

    class NodoABB{
        int info;
        AbbTDA hijoDer;
        AbbTDA hijoIzq;
    }

    NodoABB raiz;

    public int Raiz() {
        return raiz.info;
    }


    public AbbTDA HijoIzq() {
        return raiz.hijoIzq;
    }


    public AbbTDA HijoDer() {
        return raiz.hijoDer;
    }


    public boolean ArbolVacio() {
        return raiz == null;
    }


    public void InicializarABB() {
        raiz = null;
    }



    public void Agregar(int x) {
        if(raiz == null) {
            raiz = new NodoABB();
            raiz.info = x;
            raiz.hijoIzq = new AbbDin();
            raiz.hijoIzq.InicializarABB();
            raiz.hijoDer = new AbbDin();
            raiz.hijoDer.InicializarABB();
        }else {
            if(raiz.info > x) {
                raiz.hijoIzq.Agregar(x);
            }else {
                raiz.hijoDer.Agregar(x);
            }
        }
    }


    public void Eliminar(int x) {
        if(raiz != null) {
            if(raiz.info == x && raiz.hijoIzq.ArbolVacio() && raiz.hijoDer.ArbolVacio()) {
                raiz = null;
            }else {
                if(raiz.info == x && !raiz.hijoIzq.ArbolVacio()){
                    raiz.info = Mayor(raiz.hijoIzq);
                    raiz.hijoIzq.Eliminar(raiz.info);
                }

                else if(raiz.info == x && !raiz.hijoDer.ArbolVacio()) {
                    raiz.info = Menor(raiz.hijoDer);
                    raiz.hijoDer.Eliminar(raiz.info);
                }
                else if(raiz.info < x) {
                    raiz.hijoDer.Eliminar(x);
                }else {
                    raiz.hijoIzq.Eliminar(x);
                }
            }
        }
    }


    public boolean Pertenece(int x) {
        if (raiz == null){
            return false;

        }else if (x == raiz.info) {
            return true;
        }

        else if (x > raiz.info) {
            return raiz.hijoDer.Pertenece(x);
        }
        else {
            return raiz.hijoIzq.Pertenece(x);
        }

    }


    public void preOrder(AbbTDA a) {
        if (!a.ArbolVacio()){
            System.out.println(a.Raiz());
            preOrder(a.HijoIzq());
            preOrder(a.HijoDer());
        }
    }

    public void inOrder(AbbTDA a){
        if (!a.ArbolVacio()){
            inOrder(a.HijoIzq());
            System.out.println(a.Raiz());
            inOrder(a.HijoDer());
        }
    }

    public void postOrder(AbbTDA a) {
        if (!a.ArbolVacio()){
            postOrder(a.HijoIzq());
            postOrder(a.HijoDer());
            System.out.println(a.Raiz());
        }
    }


    private int Mayor(AbbTDA a) {
        if(a.HijoDer().ArbolVacio()) {
            return a.Raiz();
        }else {
            return Mayor(a.HijoDer());
        }
    }

    private int Menor(AbbTDA a) {
        if (a.HijoIzq().ArbolVacio()) {
            return a.Raiz();
        }else {
            return Menor(a.HijoIzq());
        }
    }



}