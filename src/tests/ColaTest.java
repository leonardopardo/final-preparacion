package tests;


import contracts.ICola;
import libraries.Cola;
import org.junit.jupiter.api.Test;
import services.ColaService;

import static org.junit.jupiter.api.Assertions.*;

public class ColaTest {

    @Test
    public void validar_cola_vacia(){
        ICola cola = new Cola();
        cola.inicializarCola();

        assertTrue(cola.colaVacia());
    }

    @Test
    public void acolar_elemento_y_validar_vacia(){
        ICola cola = new Cola();
        cola.inicializarCola();
        cola.acolar(14);

        assertFalse(cola.colaVacia());
    }

    @Test
    public void acolar_elemento_y_consultar_primero(){
        ICola cola = new Cola();
        cola.inicializarCola();
        cola.acolar(14);

        assertEquals(14, cola.primero());
    }

    @Test
    public void acolar_elementos_y_consultar_primero(){
        ICola cola = new Cola();
        cola.inicializarCola();
        cola.acolar(123);
        cola.acolar(12);
        cola.acolar(5);
        cola.acolar(66);
        cola.acolar(42);
        cola.acolar(101);

        assertEquals(123, cola.primero());
    }

    @Test
    public void acolar_elementos_desacolar_uno_y_consultar_primero(){
        ICola cola = new Cola();
        cola.inicializarCola();
        cola.acolar(123);
        cola.acolar(12);
        cola.acolar(5);
        cola.acolar(66);
        cola.acolar(42);
        cola.acolar(101);

        cola.desacolar();

        assertEquals(12, cola.primero());
    }

    @Test
    public void pasar_de_una_cola_a_otra_y_validar_primer_y_vacio(){
        ICola cola1 = new Cola();
        cola1.inicializarCola();
        cola1.acolar(123);
        cola1.acolar(12);
        cola1.acolar(5);
        cola1.acolar(66);
        cola1.acolar(42);
        cola1.acolar(101);

        ICola cola2 = new Cola();
        cola2.inicializarCola();

        ColaService service = new ColaService();
        service.pasarCola(cola1, cola2);

        assertTrue(cola1.colaVacia() && cola2.primero() == 123);
    }

    @Test
    public void invertir_cola_y_validar_primero(){
        ICola cola = new Cola();
        cola.inicializarCola();
        cola.acolar(123);
        cola.acolar(12);
        cola.acolar(5);
        cola.acolar(66);
        cola.acolar(42);
        cola.acolar(101);

        ColaService service = new ColaService();
        service.invertirCola(cola);

        assertEquals(cola.primero(), 101);
    }

    @Test
    public void cantidad_de_elementos_de_una_cola(){
        ICola cola = new Cola();
        cola.inicializarCola();
        cola.acolar(123);
        cola.acolar(12);
        cola.acolar(5);
        cola.acolar(66);
        cola.acolar(42);
        cola.acolar(101);

        ColaService service = new ColaService();

        assertEquals(6, service.lengthCola(cola));
    }

    @Test
    public void validar_subcola_ordenada_cola1_mayor_cola2(){
        ICola cola1 = new Cola();
        cola1.inicializarCola();
        cola1.acolar(123);
        cola1.acolar(12);
        cola1.acolar(5);
        cola1.acolar(66);
        cola1.acolar(42);
        cola1.acolar(101);

        ICola cola2 = new Cola();
        cola2.inicializarCola();

        cola2.acolar(66);
        cola2.acolar(42);
        cola2.acolar(101);

        ColaService service = new ColaService();

        assertTrue(service.subcolaOrdenada(cola1, cola2));
    }

    @Test
    public void validar_subcola_ordenada_cola1_menor_cola2(){
        ICola cola1 = new Cola();
        cola1.inicializarCola();
        cola1.acolar(66);
        cola1.acolar(42);
        cola1.acolar(101);

        ICola cola2 = new Cola();
        cola2.inicializarCola();

        cola2.acolar(123);
        cola2.acolar(12);
        cola2.acolar(5);
        cola2.acolar(66);
        cola2.acolar(42);
        cola2.acolar(101);

        ColaService service = new ColaService();

        assertTrue(service.subcolaOrdenada(cola1, cola2));
    }

    @Test
    public void validar_subcola_ordenada_cola1_igual_cola2(){
        ICola cola1 = new Cola();
        cola1.inicializarCola();
        cola1.acolar(123);
        cola1.acolar(12);
        cola1.acolar(5);
        cola1.acolar(66);
        cola1.acolar(42);
        cola1.acolar(101);

        ICola cola2 = new Cola();
        cola2.inicializarCola();
        cola2.acolar(123);
        cola2.acolar(12);
        cola2.acolar(5);
        cola2.acolar(66);
        cola2.acolar(42);
        cola2.acolar(101);

        ColaService service = new ColaService();

        assertTrue(service.subcolaOrdenada(cola1, cola2));
    }
}
