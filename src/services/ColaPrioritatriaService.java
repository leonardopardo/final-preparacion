package services;

import contracts.IColaPrioritaria;
import libraries.ColaPrioritaria;

public class ColaPrioritatriaService {

    /**
     * Copia una cola con prioridad en otra igual,
     * la cola original no se pierde.
     * @param cp1
     * @param cp2
     */
    public void copiarCola(IColaPrioritaria cp1, IColaPrioritaria cp2){

        IColaPrioritaria cpAux = new ColaPrioritaria();
        cpAux.inicializarCola();

        while(!cp1.colaVacia()){
            cpAux.acolarPrioridad(cp1.primero(), cp1.prioridad());
            cp2.acolarPrioridad(cp1.primero(), cp1.prioridad());
            cp1.desacolar();
        }

        while(!cpAux.colaVacia()){
            cp1.acolarPrioridad(cpAux.primero(), cpAux.prioridad());
            cpAux.desacolar();
        }

    }

    /**
     * Misma prioridad promedio de los valores.
     * @param cpOrigen
     * @param cpDestino
     */
    public void copiarColaPrioridadVPromedio(IColaPrioritaria cpOrigen, IColaPrioritaria cpDestino){
        IColaPrioritaria cpAux1 = new ColaPrioritaria();
        cpAux1.inicializarCola();

        copiarCola(cpOrigen, cpAux1);

        while(!cpAux1.colaVacia()){
            int v = cpAux1.primero();
            int p = cpAux1.prioridad();
            int c = 0;
            int i = 0;

            cpAux1.desacolar();

            while(!cpAux1.colaVacia() && cpAux1.prioridad() == p){
                c += cpAux1.primero();
                cpAux1.desacolar();
                i++;
            }

            int prom = i != 0 ? c/i : 0;

            cpDestino.acolarPrioridad(prom, p);
        }
    }

    /**
     * Mismo valor promedio de las prioridades.
     * @param cpOrigen
     * @param cpDestino
     */
    public void copiarColaPrioridadPPromedio(IColaPrioritaria cpOrigen, IColaPrioritaria cpDestino){

        IColaPrioritaria cpAux1 = new ColaPrioritaria();
        cpAux1.inicializarCola();

        IColaPrioritaria cpAux2 = new ColaPrioritaria();
        cpAux1.inicializarCola();

        copiarCola(cpOrigen, cpAux1);

        while(!cpAux1.colaVacia()){
            int v = cpAux1.primero();
            int p = cpAux1.prioridad();
            int c = cpAux1.prioridad();
            int i = 1;

            cpAux1.desacolar();

            while(!cpAux1.colaVacia()){
                if(cpAux1.primero() == v){
                    c += cpAux1.prioridad();
                    i++;
                }else{
                    cpAux2.acolarPrioridad(cpAux1.primero(), cpAux1.prioridad());
                }
                cpAux1.desacolar();
            }

            while(!cpAux2.colaVacia()){
                cpAux1.acolarPrioridad(cpAux2.primero(), cpAux2.prioridad());
                cpAux2.desacolar();
            }

            int prom = c/i;

            cpDestino.acolarPrioridad(v, prom);
        }
    }

    /**
     * Imprime una cola prioritaria en consola.
     * @param c
     */
    public void printConsole(IColaPrioritaria c){
        while(!c.colaVacia()){
            System.out.println("valor: " + c.primero() + "| prioridad: " + c.prioridad());
            c.desacolar();
        }
    }
}
