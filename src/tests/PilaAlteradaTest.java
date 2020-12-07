package tests;

import contracts.IPilaAlterada;
import libraries.PilaAlterada;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PilaAlteradaTest {

    @Test
    void probar_algorimo_par(){
        int val = 2424;
        assertTrue(val % 2 == 0);
    }

    @Test
    void inicializar_pila_alterada(){
        IPilaAlterada p = new PilaAlterada();
        p.inicializarPila();

        assertTrue(p.pilaVacia());
    }

    @Test
    void validar_pila_vacia_con_elementos(){
        IPilaAlterada p = new PilaAlterada();
        p.inicializarPila();
        p.poner(1);

        assertFalse(p.pilaVacia());
    }

    @Test
    void validar_pila_vacia_poniendo_elementos_y_luego_sacarlos(){
        IPilaAlterada p = new PilaAlterada();
        p.inicializarPila();
        p.poner(1);
        p.sacar();
        p.poner(3);

        assertEquals(p.tope(), 3);
    }

    @Test
    void apilar_varios_elementos(){
        IPilaAlterada p = new PilaAlterada();
        p.inicializarPila();
        p.poner(1);
        p.poner(2);
        p.poner(11);
        p.poner(7);
        p.poner(8);

        assertFalse(p.pilaVacia());
    }

    @Test
    void apilar_varios_elementos_y_consultar_tope(){
        IPilaAlterada p = new PilaAlterada();
        p.inicializarPila();
        p.poner(1);
        p.poner(2);
        p.poner(11);
        p.poner(7);
        p.poner(8);

        int tope = p.tope();

        assertEquals(7, p.tope());
    }

    @Test
    void apilar_varios_elementos_y_consultar_tope_sin_impares(){
        IPilaAlterada p = new PilaAlterada();
        p.inicializarPila();

        p.poner(2);
        p.poner(4);
        p.poner(6);
        p.poner(12);
        p.poner(8);

        int tope = p.tope();

        assertEquals(8, p.tope());
    }

}
