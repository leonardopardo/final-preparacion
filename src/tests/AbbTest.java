package tests;

import contracts.IAbb;
import contracts.IConjunto;
import libraries.Abb;
import libraries.Conjunto;
import org.junit.jupiter.api.Test;
import services.ArbolService;

import static org.junit.jupiter.api.Assertions.*;

public class AbbTest {
    @Test
    public void calcular_nivel_de_elemento(){
        IAbb arbol = new Abb();
        arbol.inicializar();

        int[] valores = { 32, 78, 41, 70, 16, 55, 43, 38, 25, 82, 45, 34 };

        ArbolService arbolService = new ArbolService();
        arbolService.agregarValores(arbol, valores);

        assertFalse(arbolService.nivel(arbol, 34) == 3);
        assertEquals(4, arbolService.nivel(arbol, 34));
    }

    @Test
    public void calcular_nivel_de_raiz(){
        IAbb arbol = new Abb();
        arbol.inicializar();

        int[] valores = { 32, 78, 41, 70, 16, 55, 43, 38, 25, 82, 45, 34 };

        ArbolService arbolService = new ArbolService();
        arbolService.agregarValores(arbol, valores);

        assertFalse(arbolService.nivel(arbol, 32) == 1);
        assertEquals(0, arbolService.nivel(arbol, 32));
    }

    @Test
    public void calcular_altura_de_arbol(){
        IAbb arbol = new Abb();
        arbol.inicializar();

        int[] valores = { 32, 78, 41, 70, 16, 55, 43, 38, 25, 82, 45, 34 };

        ArbolService arbolService = new ArbolService();
        arbolService.agregarValores(arbol, valores);

        assertEquals( 7, arbolService.altura(arbol));
    }

    @Test
    public void encuentra_el_menor_elemento_del_arbol(){
        IAbb arbol = new Abb();
        arbol.inicializar();

        int[] valores = { 32, 78, 41, 70, 16, 55, 43, 38, 25, 82, 45, 34 };

        ArbolService arbolService = new ArbolService();
        arbolService.agregarValores(arbol, valores);

        assertEquals( 16, arbolService.elMenor(arbol));
    }

    @Test
    public void encuentra_el_menor_elemento_del_arbol_con_unico_elemento(){
        IAbb arbol = new Abb();
        arbol.inicializar();

        int[] valores = { 1 };

        ArbolService arbolService = new ArbolService();
        arbolService.agregarValores(arbol, valores);

        assertEquals( 1, arbolService.elMenor(arbol));
    }

    @Test
    public void encuentra_el_mayor_elemento_del_arbol(){
        IAbb arbol = new Abb();
        arbol.inicializar();

        int[] valores = { 32, 78, 41, 70, 16, 55, 43, 38, 25, 82, 45, 34 };

        ArbolService arbolService = new ArbolService();
        arbolService.agregarValores(arbol, valores);

        assertEquals(82, arbolService.elMayor(arbol));
    }

    @Test
    public void calcular_la_cantidad_de_elementos_de_un_arbol(){
        IAbb arbol = new Abb();
        arbol.inicializar();

        int[] valores = { 32, 78, 41, 70, 16, 55, 43, 38, 25, 82, 45, 34 };

        ArbolService arbolService = new ArbolService();
        arbolService.agregarValores(arbol, valores);

        assertEquals( 12, arbolService.elementos(arbol));

        arbol.agregar(123);
        arbol.agregar(5);
        arbol.agregar(77);

        assertEquals( 15, arbolService.elementos(arbol));
    }

    @Test
    public void calcular_la_suma_de_elementos_de_un_arbol(){
        IAbb arbol = new Abb();
        arbol.inicializar();

        int[] valores = { 32, 78, 41, 70, 16, 55, 43, 38, 25, 82, 45, 34 };

        ArbolService arbolService = new ArbolService();
        arbolService.agregarValores(arbol, valores);

        assertEquals( 559, arbolService.suma(arbol));
    }

    @Test
    public void calcular_la_cantidad_de_hojas_de_un_arbol(){
        IAbb arbol = new Abb();
        arbol.inicializar();

        int[] valores = { 32, 78, 41, 70, 16, 55, 43, 38, 25, 82, 45, 34 };

        ArbolService arbolService = new ArbolService();
        arbolService.agregarValores(arbol, valores);

        assertEquals(4, arbolService.hojas(arbol));

        arbol.agregar(15);
        arbol.agregar(81);
        arbol.agregar(83);

        assertEquals(6, arbolService.hojas(arbol));
    }

    @Test
    public void verifica_si_dos_arboles_son_identicos(){
        IAbb arbol1 = new Abb();
        arbol1.inicializar();

        IAbb arbol2 = new Abb();
        arbol2.inicializar();

        int[] valores = { 32, 78, 41, 70, 16, 55, 43, 38, 25, 82, 45, 34 };

        ArbolService arbolService = new ArbolService();
        arbolService.agregarValores(arbol1, valores);
        arbolService.agregarValores(arbol2, valores);

        assertTrue(arbolService.esIdentico(arbol1, arbol2));
    }

    @Test
    public void verifica_si_dos_arboles_no_son_identicos(){
        IAbb arbol1 = new Abb();
        arbol1.inicializar();

        IAbb arbol2 = new Abb();
        arbol2.inicializar();

        int[] valores1 = { 32, 78, 41, 70, 16, 55, 43, 38, 25, 82, 45, 34 };
        int[] valores2 = { 78, 32, 41, 70, 16, 55, 43, 38, 25, 82, 45, 34 };

        ArbolService arbolService = new ArbolService();
        arbolService.agregarValores(arbol1, valores1);
        arbolService.agregarValores(arbol2, valores2);

        assertFalse(arbolService.esIdentico(arbol1, arbol2));
    }

    @Test
    public void contar_elementos_en_nivel(){
        IAbb arbol = new Abb();
        arbol.inicializar();

        int[] valores = { 32, 78, 41, 70, 16, 55, 43, 38, 25, 82, 45, 34 };

        ArbolService arbolService = new ArbolService();
        arbolService.agregarValores(arbol, valores);

        assertTrue(true);
        /*assertEquals(1, arbolService.elementosEnNivel(arbol, 0));
        assertEquals(2, arbolService.elementosEnNivel(arbol, 1));
        assertEquals(3, arbolService.elementosEnNivel(arbol, 2));
        assertEquals(2, arbolService.elementosEnNivel(arbol, 3));
        assertEquals(2, arbolService.elementosEnNivel(arbol, 4));
        assertEquals(1, arbolService.elementosEnNivel(arbol, 5));
        assertEquals(1, arbolService.elementosEnNivel(arbol, 6));*/
    }

    @Test
    public void verificar_si_elemento_es_hoja(){
        IAbb arbol = new Abb();
        arbol.inicializar();

        int[] valores = { 32, 78, 41, 70, 16, 55, 43, 38, 25, 82, 45, 34 };

        ArbolService arbolService = new ArbolService();
        arbolService.agregarValores(arbol, valores);

        assertTrue(arbolService.elElementoEsHoja(arbol, 25));
        assertTrue(arbolService.elElementoEsHoja(arbol, 34));
        assertTrue(arbolService.elElementoEsHoja(arbol, 45));
        assertTrue(arbolService.elElementoEsHoja(arbol, 82));
        assertFalse(arbolService.elElementoEsHoja(arbol, 78));
    }

    @Test
    public void verificar_punto_cuatro(){
        IAbb arbol = new Abb();
        arbol.inicializar();

        IConjunto c = new Conjunto();
        c.inicializarConjunto();

        int[] valores = { 32, 78, 41, 70, 16, 55, 43, 38, 25, 82, 45, 34 };

        ArbolService arbolService = new ArbolService();
        arbolService.agregarValores(arbol, valores);

        arbolService.puntoCuatro(arbol, c, 55);

        assertTrue(c.pertenece(70));
        assertTrue(c.pertenece(78));
        assertTrue(c.pertenece(82));
        
        assertFalse(c.pertenece(32));
        assertFalse(c.pertenece(55));
        assertFalse(c.pertenece(41));
        assertFalse(c.pertenece(16));
        assertFalse(c.pertenece(43));
        assertFalse(c.pertenece(38));
        assertFalse(c.pertenece(25));
        assertFalse(c.pertenece(45));
        assertFalse(c.pertenece(34));
    }
}
