package tests;

import contracts.IConjunto;
import libraries.Conjunto;
import org.junit.jupiter.api.Test;
import services.ConjuntoService;

import static org.junit.jupiter.api.Assertions.*;

public class ConjuntoTest {
    @Test
    public void validar_inicializacion_conjunto(){
        IConjunto c = new Conjunto();
        c.inicializarConjunto();

        assertTrue(c.conjuntoVacio());
    }

    @Test
    public void agregar_elementos_y_validar_vacio(){
        IConjunto c = new Conjunto();
        c.inicializarConjunto();
        c.agregar(3);
        c.agregar(2);
        c.agregar(1);
        c.agregar(4);

        assertFalse(c.conjuntoVacio());
    }

    @Test
    public void agregar_elementos_y_validar_pertenencia(){
        IConjunto c = new Conjunto();
        c.inicializarConjunto();
        c.agregar(3);
        c.agregar(2);
        c.agregar(1);
        c.agregar(4);

        assertTrue(
                c.pertenece(1)
                        && c.pertenece(2)
                        && c.pertenece(3)
                        && c.pertenece(4)
        );
    }

    @Test
    public void agregar_elementos_y_validar_no_pertenencia(){
        IConjunto c = new Conjunto();
        c.inicializarConjunto();
        c.agregar(3);
        c.agregar(2);
        c.agregar(1);
        c.agregar(4);

        assertFalse(
                c.pertenece(1)
                        && c.pertenece(2)
                        && c.pertenece(3)
                        && c.pertenece(4)
                        && c.pertenece(5)
        );
    }

    @Test
    public void comparar_dos_conjuntos_y_son_iguales(){
        IConjunto c1 = new Conjunto();
        c1.inicializarConjunto();
        c1.agregar(3);
        c1.agregar(2);
        c1.agregar(1);
        c1.agregar(4);

        IConjunto c2 = new Conjunto();
        c2.inicializarConjunto();
        c2.agregar(3);
        c2.agregar(2);
        c2.agregar(1);
        c2.agregar(4);

        ConjuntoService service = new ConjuntoService();

        assertTrue(service.esIgual(c1, c2));
    }

    @Test
    public void comparar_dos_conjuntos_y_los_dos_son_vacios(){
        IConjunto c1 = new Conjunto();
        c1.inicializarConjunto();

        IConjunto c2 = new Conjunto();
        c2.inicializarConjunto();

        ConjuntoService service = new ConjuntoService();

        assertTrue(service.esIgual(c1, c2));
    }

    @Test
    public void comparar_dos_conjuntos_y_los_uno_es_vacios(){
        IConjunto c1 = new Conjunto();
        c1.inicializarConjunto();

        IConjunto c2 = new Conjunto();
        c2.inicializarConjunto();
        c2.agregar(3);
        c2.agregar(2);
        c2.agregar(1);
        c2.agregar(4);

        ConjuntoService service = new ConjuntoService();

        assertFalse(service.esIgual(c1, c2));
    }

    @Test
    public void comparar_dos_conjuntos_y_no_son_iguales(){
        IConjunto c1 = new Conjunto();
        c1.inicializarConjunto();
        c1.agregar(3);
        c1.agregar(2);
        c1.agregar(1);
        c1.agregar(4);

        IConjunto c2 = new Conjunto();
        c2.inicializarConjunto();
        c2.agregar(0);
        c2.agregar(2);
        c2.agregar(1);
        c2.agregar(4);

        ConjuntoService service = new ConjuntoService();

        assertFalse(service.esIgual(c1, c2));
    }

    @Test
    public void calcular_cantidad_elementos(){

        IConjunto c = new Conjunto();
        c.inicializarConjunto();
        c.agregar(3);
        c.agregar(2);
        c.agregar(1);
        c.agregar(4);

        ConjuntoService service = new ConjuntoService();

        assertEquals(4, service.lenghtConjunto(c));
    }

    @Test
    public void union_de_conjuntos_con_valores_no_repetidos(){
        IConjunto c1 = new Conjunto();
        c1.inicializarConjunto();
        c1.agregar(1);
        c1.agregar(2);
        c1.agregar(3);

        IConjunto c2 = new Conjunto();
        c2.inicializarConjunto();
        c2.agregar(8);
        c2.agregar(9);
        c2.agregar(0);


        ConjuntoService service = new ConjuntoService();
        IConjunto cUnion = service.union(c1, c2);

        assertTrue(
                cUnion.pertenece(0) &&
                        cUnion.pertenece(1) &&
                        cUnion.pertenece(2) &&
                        cUnion.pertenece(3) &&
                        cUnion.pertenece(8) &&
                        cUnion.pertenece(9)
        );
    }

    @Test
    public void union_de_conjuntos_con_valores_repetidos(){
        IConjunto c1 = new Conjunto();
        c1.inicializarConjunto();
        c1.agregar(1);
        c1.agregar(2);
        c1.agregar(3);

        IConjunto c2 = new Conjunto();
        c2.inicializarConjunto();
        c2.agregar(8);
        c2.agregar(2);
        c2.agregar(3);


        ConjuntoService service = new ConjuntoService();
        IConjunto cUnion = service.union(c1, c2);

        assertTrue(cUnion.pertenece(1)
                && cUnion.pertenece(2)
                && cUnion.pertenece(3)
                && cUnion.pertenece(8) );
    }

    @Test
    public void union_de_conjuntos_con_valores_repetidos_2(){
        IConjunto c1 = new Conjunto();
        c1.inicializarConjunto();
        c1.agregar(1);
        c1.agregar(2);
        c1.agregar(3);

        IConjunto c2 = new Conjunto();
        c2.inicializarConjunto();
        c2.agregar(8);
        c2.agregar(5);
        c2.agregar(3);


        ConjuntoService service = new ConjuntoService();
        IConjunto cUnion = service.union(c1, c2);

        assertFalse(cUnion.pertenece(1)
                && cUnion.pertenece(2)
                && cUnion.pertenece(3)
                && cUnion.pertenece(5)
                && cUnion.pertenece(9)
                && cUnion.pertenece(8) );
    }

    @Test
    public void union_de_dos_conjuntos_vacios(){
        IConjunto c1 = new Conjunto();
        c1.inicializarConjunto();

        IConjunto c2 = new Conjunto();
        c2.inicializarConjunto();

        ConjuntoService service = new ConjuntoService();
        IConjunto cUnion = service.union(c1, c2);

        assertTrue(cUnion.conjuntoVacio());
    }

    @Test
    public void interseccion_de_dos_conjuntos_pertenencia(){
        IConjunto c1 = new Conjunto();
        c1.inicializarConjunto();
        c1.agregar(1);
        c1.agregar(2);
        c1.agregar(3);
        c1.agregar(4);

        IConjunto c2 = new Conjunto();
        c2.inicializarConjunto();
        c2.agregar(3);
        c2.agregar(4);
        c2.agregar(5);
        c2.agregar(6);

        ConjuntoService service = new ConjuntoService();
        IConjunto cInterseccion = service.interseccion(c1, c2);

        assertTrue( cInterseccion.pertenece(3)
                && cInterseccion.pertenece(4));
    }

    @Test
    public void interseccion_de_dos_conjuntos_no_pertenencia(){
        IConjunto c1 = new Conjunto();
        c1.inicializarConjunto();
        c1.agregar(1);
        c1.agregar(2);
        c1.agregar(3);
        c1.agregar(4);

        IConjunto c2 = new Conjunto();
        c2.inicializarConjunto();
        c2.agregar(3);
        c2.agregar(4);
        c2.agregar(5);
        c2.agregar(6);

        ConjuntoService service = new ConjuntoService();
        IConjunto cInterseccion = service.interseccion(c1, c2);

        assertFalse( cInterseccion.pertenece(1)
                && cInterseccion.pertenece(2)
                && cInterseccion.pertenece(5)
                && cInterseccion.pertenece(6) );
    }

    @Test
    public void diferencia_de_dos_conjuntos_iguales(){
        IConjunto c1 = new Conjunto();
        c1.inicializarConjunto();
        c1.agregar(1);
        c1.agregar(2);
        c1.agregar(3);

        IConjunto c2 = new Conjunto();
        c2.inicializarConjunto();
        c2.agregar(1);
        c2.agregar(2);
        c2.agregar(3);

        ConjuntoService service = new ConjuntoService();
        IConjunto cInterseccion = service.diferencia(c1, c2);

        assertTrue(cInterseccion.conjuntoVacio());
    }

    @Test
    public void diferencia_de_dos_conjuntos_pertenencia(){
        IConjunto c1 = new Conjunto();
        c1.inicializarConjunto();
        c1.agregar(1);
        c1.agregar(2);
        c1.agregar(3);
        c1.agregar(4);

        IConjunto c2 = new Conjunto();
        c2.inicializarConjunto();
        c2.agregar(3);
        c2.agregar(4);
        c2.agregar(5);
        c2.agregar(6);

        ConjuntoService service = new ConjuntoService();
        IConjunto cInterseccion = service.diferencia(c1, c2);

        assertTrue( cInterseccion.pertenece(1) && cInterseccion.pertenece(2));
    }

    @Test
    public void diferencia_de_dos_conjuntos_no_pertenencia(){
        IConjunto c1 = new Conjunto();
        c1.inicializarConjunto();
        c1.agregar(1);
        c1.agregar(2);
        c1.agregar(3);
        c1.agregar(4);

        IConjunto c2 = new Conjunto();
        c2.inicializarConjunto();
        c2.agregar(3);
        c2.agregar(4);
        c2.agregar(5);
        c2.agregar(6);

        ConjuntoService service = new ConjuntoService();
        IConjunto cInterseccion = service.diferencia(c1, c2);

        assertFalse( cInterseccion.pertenece(3)
                && cInterseccion.pertenece(4)
                && cInterseccion.pertenece(5)
                && cInterseccion.pertenece(6) );
    }

    @Test
    public void diferencia_simetrica_de_dos_conjuntos_iguales(){
        IConjunto c1 = new Conjunto();
        c1.inicializarConjunto();
        c1.agregar(1);
        c1.agregar(2);
        c1.agregar(3);

        IConjunto c2 = new Conjunto();
        c2.inicializarConjunto();
        c2.agregar(1);
        c2.agregar(2);
        c2.agregar(3);

        ConjuntoService service = new ConjuntoService();
        IConjunto cInterseccion = service.diferenciaSimetrica(c1, c2);

        assertTrue(cInterseccion.conjuntoVacio());
    }

    @Test
    public void diferencia_simetrica_de_dos_conjuntos_pertenencia(){
        IConjunto c1 = new Conjunto();
        c1.inicializarConjunto();
        c1.agregar(1);
        c1.agregar(2);
        c1.agregar(3);
        c1.agregar(4);

        IConjunto c2 = new Conjunto();
        c2.inicializarConjunto();
        c2.agregar(3);
        c2.agregar(4);
        c2.agregar(5);
        c2.agregar(6);

        ConjuntoService service = new ConjuntoService();
        IConjunto cInterseccion = service.diferenciaSimetrica(c1, c2);

        assertTrue( cInterseccion.pertenece(1)
                && cInterseccion.pertenece(2)
                && cInterseccion.pertenece(5)
                && cInterseccion.pertenece(6)
        );
    }

    @Test
    public void diferencia_simetrica_de_dos_conjuntos_no_pertenencia(){
        IConjunto c1 = new Conjunto();
        c1.inicializarConjunto();
        c1.agregar(1);
        c1.agregar(2);
        c1.agregar(3);
        c1.agregar(4);

        IConjunto c2 = new Conjunto();
        c2.inicializarConjunto();
        c2.agregar(3);
        c2.agregar(4);
        c2.agregar(5);
        c2.agregar(6);

        ConjuntoService service = new ConjuntoService();
        IConjunto cInterseccion = service.diferenciaSimetrica(c1, c2);

        assertFalse( cInterseccion.pertenece(3) && cInterseccion.pertenece(4));
    }

    @Test
    public void el_primer_conjunto_esta_incluido_en_el_segundo(){
        IConjunto c1 = new Conjunto();
        c1.inicializarConjunto();
        c1.agregar(3);
        c1.agregar(4);

        IConjunto c2 = new Conjunto();
        c2.inicializarConjunto();
        c2.agregar(3);
        c2.agregar(4);
        c2.agregar(5);
        c2.agregar(6);

        ConjuntoService service = new ConjuntoService();

        assertTrue( service.estaIncluido(c1, c2));
    }

    @Test
    public void el_primer_conjunto_no_esta_incluido_en_el_segundo(){
        IConjunto c1 = new Conjunto();
        c1.inicializarConjunto();
        c1.agregar(3);
        c1.agregar(4);
        c1.agregar(7);

        IConjunto c2 = new Conjunto();
        c2.inicializarConjunto();
        c2.agregar(3);
        c2.agregar(4);
        c2.agregar(5);
        c2.agregar(6);

        ConjuntoService service = new ConjuntoService();

        assertFalse( service.estaIncluido(c1, c2));
    }

    @Test
    public void el_primer_conjunto_no_esta_incluido_en_el_segundo_porque_es_mas_grande(){
        IConjunto c1 = new Conjunto();
        c1.inicializarConjunto();
        c1.agregar(3);
        c1.agregar(4);
        c1.agregar(5);
        c1.agregar(6);
        c1.agregar(7);

        IConjunto c2 = new Conjunto();
        c2.inicializarConjunto();
        c2.agregar(3);
        c2.agregar(4);
        c2.agregar(5);
        c2.agregar(6);

        ConjuntoService service = new ConjuntoService();

        assertFalse(service.estaIncluido(c1, c2));
    }

    @Test
    public void el_primer_conjunto_esta_incluido_en_el_segundo_porque_son_iguales(){
        IConjunto c1 = new Conjunto();
        c1.inicializarConjunto();
        c1.agregar(3);
        c1.agregar(4);
        c1.agregar(5);

        IConjunto c2 = new Conjunto();
        c2.inicializarConjunto();
        c2.agregar(3);
        c2.agregar(4);
        c2.agregar(5);

        ConjuntoService service = new ConjuntoService();

        assertTrue( service.estaIncluido(c1, c2));
    }

    @Test
    public void el_primer_conjunto_esta_incluido_en_el_segundo_porque_ambos_son_vacios(){
        IConjunto c1 = new Conjunto();
        c1.inicializarConjunto();

        IConjunto c2 = new Conjunto();
        c2.inicializarConjunto();

        ConjuntoService service = new ConjuntoService();

        assertTrue( service.estaIncluido(c1, c2));
    }
}
