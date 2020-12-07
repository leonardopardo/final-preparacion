package tests;


import contracts.ICola;
import contracts.IPila;
import libraries.Cola;
import libraries.Pila;
import org.junit.jupiter.api.Test;
import services.PilaService;

import static org.junit.jupiter.api.Assertions.*;

public class PilaTest {

    @Test
    public void validar_pila_vacia(){
        IPila pìla = new Pila();
        pìla.inicializarPila();

        assertTrue(pìla.pilaVacia());
    }

    @Test
    public void apilar_elemento_y_validar_vacia(){
        IPila pila = new Pila();
        pila.inicializarPila();
        pila.apilar(14);

        assertFalse(pila.pilaVacia());
    }

    @Test
    public void apilar_elemento_y_consultar_primero(){
        IPila pila = new Pila();
        pila.inicializarPila();
        pila.apilar(14);

        assertEquals(14, pila.tope());
    }

    @Test
    public void apilar_elementos_y_consultar_primero(){
        IPila pila = new Pila();
        pila.inicializarPila();
        pila.apilar(123);
        pila.apilar(12);
        pila.apilar(5);
        pila.apilar(66);
        pila.apilar(42);
        pila.apilar(101);

        assertEquals(101, pila.tope());
    }

    @Test
    public void apilar_elementos_desacolar_uno_y_consultar_primero(){
        IPila pila = new Pila();
        pila.inicializarPila();
        pila.apilar(123);
        pila.apilar(12);
        pila.apilar(5);
        pila.apilar(66);
        pila.apilar(42);
        pila.apilar(101);

        pila.desapilar();

        assertEquals(42, pila.tope());
    }

    @Test
    public void copiar_una_pila_a_una_cola_directo_y_comparar_tope_con_primero(){
        IPila pila = new Pila();
        pila.inicializarPila();
        pila.apilar(123);
        pila.apilar(12);
        pila.apilar(5);
        pila.apilar(66);
        pila.apilar(42);
        pila.apilar(101);

        ICola cola = new Cola();
        cola.inicializarCola();

        PilaService service = new PilaService();
        service.aColaDirecto(pila, cola);

        assertTrue(pila.tope() == 101 && cola.primero() == 101);
    }

    @Test
    public void copiar_una_pila_a_una_cola_en_orden_original_y_comparar_tope_con_primero(){
        IPila pila = new Pila();
        pila.inicializarPila();
        pila.apilar(123);
        pila.apilar(12);
        pila.apilar(5);
        pila.apilar(66);
        pila.apilar(42);
        pila.apilar(101);

        ICola cola = new Cola();
        cola.inicializarCola();

        PilaService service = new PilaService();
        service.aColaOrdenada(pila, cola);

        assertTrue(pila.tope() == 101 && cola.primero() == 123);
    }

    @Test
    public void copiar_una_pila_en_otra_y_comparar_topes(){

        IPila pila1 = new Pila();
        pila1.inicializarPila();
        pila1.apilar(123);
        pila1.apilar(12);
        pila1.apilar(5);
        pila1.apilar(66);
        pila1.apilar(42);
        pila1.apilar(101);

        IPila pila2 = new Pila();
        pila2.inicializarPila();

        PilaService service = new PilaService();
        service.copiarPila(pila1, pila2);

        assertTrue(pila1.tope() == pila2.tope());

    }

    @Test
    public void invertir_pila_y_verificar_tope(){
        IPila pila = new Pila();
        pila.inicializarPila();
        pila.apilar(123);
        pila.apilar(12);
        pila.apilar(5);
        pila.apilar(66);
        pila.apilar(42);
        pila.apilar(101);

        assertEquals(pila.tope(), 101);

        PilaService service = new PilaService();
        service.invertirPila(pila);

        assertEquals(pila.tope(), 123);
    }

    @Test
    public void cantidad_de_elementos(){
        IPila pila = new Pila();
        pila.inicializarPila();
        pila.apilar(123);
        pila.apilar(12);
        pila.apilar(5);
        pila.apilar(66);
        pila.apilar(42);
        pila.apilar(101);

        PilaService service = new PilaService();

        assertEquals(6, service.lenghtPila(pila));
    }

    @Test
    public void verifica_si_dos_pilas_son_identicas(){

        IPila pila1 = new Pila();
        pila1.inicializarPila();
        pila1.apilar(21);
        pila1.apilar(33);
        pila1.apilar(24);

        IPila pila2 = new Pila();
        pila2.inicializarPila();

        pila2.apilar(21);
        pila2.apilar(33);
        pila2.apilar(24);

        PilaService service = new PilaService();

        assertTrue(service.esIdentica(pila1, pila2));
    }

    @Test
    public void verifica_si_dos_pilas_no_son_iguales_por_cantidad_de_elementos(){

        IPila pila1 = new Pila();
        pila1.inicializarPila();
        pila1.apilar(21);
        pila1.apilar(33);
        pila1.apilar(24);
        pila1.apilar(12);

        IPila pila2 = new Pila();
        pila2.inicializarPila();

        pila2.apilar(21);
        pila2.apilar(33);
        pila2.apilar(24);

        PilaService service = new PilaService();

        assertFalse(service.esIdentica(pila1, pila2));
    }

    @Test
    public void verfica_si_dos_pilas_no_son_iguales_por_posicion_de_elementos(){
        IPila pila1 = new Pila();
        pila1.inicializarPila();
        pila1.apilar(33);
        pila1.apilar(21);
        pila1.apilar(24);

        IPila pila2 = new Pila();
        pila2.inicializarPila();

        pila2.apilar(21);
        pila2.apilar(33);
        pila2.apilar(24);

        PilaService service = new PilaService();

        assertFalse(service.esIdentica(pila1, pila2));
    }

    @Test
    public void promedio_de_pares_pila_vacia(){
        IPila pila = new Pila();
        pila.inicializarPila();

        PilaService service = new PilaService();

        assertEquals(0, service.promedioDePares(pila));
    }

    @Test
    public void promedio_de_pares_pila_sin_pares(){
        IPila pila = new Pila();
        pila.inicializarPila();
        pila.apilar(1);
        pila.apilar(3);
        pila.apilar(5);
        pila.apilar(7);
        pila.apilar(9);

        PilaService service = new PilaService();

        assertEquals(0, service.promedioDePares(pila));
    }

    @Test
    public void promedio_de_pares(){
        IPila pila = new Pila();
        pila.inicializarPila();
        pila.apilar(2);
        pila.apilar(5);
        pila.apilar(6);
        pila.apilar(1);
        pila.apilar(4);
        pila.apilar(11);
        pila.apilar(16);

        PilaService service = new PilaService();

        assertEquals(7, service.promedioDePares(pila));
    }
}
