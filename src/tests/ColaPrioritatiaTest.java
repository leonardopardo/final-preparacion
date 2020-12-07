package tests;

import contracts.IColaPrioritaria;
import libraries.ColaPrioritaria;
import org.junit.jupiter.api.Test;
import services.ColaPrioritatriaService;

import static org.junit.jupiter.api.Assertions.*;

public class ColaPrioritatiaTest {

    @Test
    public void inicializar_cola_prioridad(){
        IColaPrioritaria cp = new ColaPrioritaria();
        cp.inicializarCola();

        assertTrue(cp.colaVacia());
    }

    @Test
    public void inicializar_cola_prioridad_validar_vacia(){
        IColaPrioritaria cp = new ColaPrioritaria();
        cp.inicializarCola();
        cp.acolarPrioridad(1,1);

        assertFalse(cp.colaVacia());
    }

    @Test
    public void copiar_cola_prioridad_con_el_promedio_de_valores_con_prioridad_repetida(){
        IColaPrioritaria cp = new ColaPrioritaria();
        cp.inicializarCola();
        cp.acolarPrioridad(1,1);
        cp.acolarPrioridad(2,1);
        cp.acolarPrioridad(3,1);
        cp.acolarPrioridad(4,1);
        cp.acolarPrioridad(5,1);

        IColaPrioritaria cpd = new ColaPrioritaria();
        cpd.inicializarCola();

        ColaPrioritatriaService service = new ColaPrioritatriaService();
        service.copiarColaPrioridadVPromedio(cp, cpd);

        assertTrue(cpd.primero() == 3 && cpd.prioridad() == 1);
    }

}
