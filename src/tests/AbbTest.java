package tests;

import contracts.AbbTDA;
import contracts.IAbb;
import libraries.Abb;
import libraries.AbbDin;
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
    public void calcular_altura_de_arbol(){
        IAbb arbol = new Abb();
        arbol.inicializar();

        int[] valores = { 32, 78, 41, 70, 16, 55, 43, 38, 25, 82, 45, 34 };

        ArbolService arbolService = new ArbolService();
        arbolService.agregarValores(arbol, valores);

        assertEquals(arbolService.altura(arbol), 7);
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
}
