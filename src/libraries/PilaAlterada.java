package libraries;

import contracts.IPilaAlterada;

public class PilaAlterada implements IPilaAlterada {


    private static final int max = 10;

    private int[] pila;

    private int ultimoPar;
    private int ultimoImpar;

    public PilaAlterada() {
    }

    @Override
    public void inicializarPila() {
        this.pila = new int[this.max];
        this.ultimoPar = 0;
        this.ultimoImpar = 1;
    }

    /**
     * @Importante
     * @param val
     */
    @Override
    public void poner(int val) {
        if(esPar(val)){
            this.pila[ultimoPar] = val;
            this.ultimoPar += 2;
        } else {
            this.pila[ultimoImpar] = val;
            this.ultimoImpar += 2;
        }
    }

    /**
     * @Importante
     */
    @Override
    public void sacar() {
        if (this.ultimoImpar == 1)
            this.ultimoPar -= 2;
        else
            this.ultimoImpar -= 2;
    }

    /**
     * @Importante
     * @return
     */
    @Override
    public int tope() {
        if(this.ultimoImpar == 1){
            return this.pila[ultimoPar - 2];
        }

        return this.pila[ultimoImpar - 2];
    }

    @Override
    public boolean pilaVacia() {
        return this.ultimoPar == 0 && this.ultimoImpar == 1;
    }

    private boolean esPar(int val){
        return val % 2 == 0;
    }
}
