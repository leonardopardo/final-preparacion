package tests;

import contracts.IGrafo;
import libraries.Grafo;
import org.junit.jupiter.api.Test;
import services.GrafoService;

import static org.junit.jupiter.api.Assertions.*;

public class GrafoTest {

    @Test
    public void inicializar_grafo_estatico() {
        IGrafo grafo = new Grafo();
        grafo.inicializarGrafo();

        assertTrue(grafo.vertices().conjuntoVacio());
    }

    @Test
    public void inicializar_grafo_dinamico() {
        IGrafo grafo = new libraries.dynamics.Grafo();
        grafo.inicializarGrafo();

        assertTrue(grafo.vertices().conjuntoVacio());
    }

    @Test
    public void agregar_vertice_grafo_estatico(){
        IGrafo grafo = new Grafo();
        grafo.inicializarGrafo();
        grafo.agregarVertice(1);

        assertTrue(!grafo.vertices().conjuntoVacio());
    }

    @Test
    public void agregar_vertice_grafo_dinamico(){
        IGrafo grafo = new libraries.dynamics.Grafo();
        grafo.inicializarGrafo();
        grafo.agregarVertice(1);

        assertTrue(!grafo.vertices().conjuntoVacio());
    }

    @Test
    public void agregar_varios_vertices_grafo_estatico(){
        IGrafo grafo = new Grafo();
        grafo.inicializarGrafo();
        grafo.agregarVertice(1);
        grafo.agregarVertice(7);
        grafo.agregarVertice(16);

        assertTrue(!grafo.vertices().conjuntoVacio());
    }

    @Test
    public void agregar_varios_vertices_grafo_dinamico(){
        IGrafo grafo = new libraries.dynamics.Grafo();
        grafo.inicializarGrafo();
        grafo.agregarVertice(1);
        grafo.agregarVertice(7);
        grafo.agregarVertice(16);

        assertTrue(!grafo.vertices().conjuntoVacio());
    }

    @Test
    public void agregar_vertices_grafo_estatico_y_validar_pertenencia(){
        IGrafo grafo = new Grafo();
        grafo.inicializarGrafo();
        grafo.agregarVertice(1);
        grafo.agregarVertice(7);
        grafo.agregarVertice(16);

        assertTrue(grafo.vertices().pertenece(1));
        assertTrue(grafo.vertices().pertenece(7));
        assertTrue(grafo.vertices().pertenece(16));
        assertFalse(grafo.vertices().pertenece(32));
    }

    @Test
    public void agregar_vertices_grafo_dinamico_y_validar_pertenencia(){
        IGrafo grafo = new libraries.dynamics.Grafo();
        grafo.inicializarGrafo();
        grafo.agregarVertice(1);
        grafo.agregarVertice(7);
        grafo.agregarVertice(16);

        assertTrue(grafo.vertices().pertenece(1));
        assertTrue(grafo.vertices().pertenece(7));
        assertTrue(grafo.vertices().pertenece(16));
        assertFalse(grafo.vertices().pertenece(32));
    }

    @Test
    public void eliminar_vertice_grafo_estatico_y_validar_pertenencia(){
        IGrafo grafo = new Grafo();
        grafo.inicializarGrafo();
        grafo.agregarVertice(1);
        grafo.agregarVertice(7);
        grafo.agregarVertice(16);
        grafo.eliminarVertice(7);

        assertTrue(grafo.vertices().pertenece(1));
        assertTrue(grafo.vertices().pertenece(16));
        assertFalse(grafo.vertices().pertenece(7));
        assertFalse(grafo.vertices().pertenece(32));
    }

    @Test
    public void eliminar_vertice_grafo_dinamico_y_validar_pertenencia(){
        IGrafo grafo = new libraries.dynamics.Grafo();
        grafo.inicializarGrafo();

        grafo.agregarVertice(1);
        grafo.agregarVertice(7);
        grafo.agregarVertice(8);
        grafo.agregarVertice(9);
        grafo.agregarVertice(16);
        grafo.agregarArista(1, 7, 1);
        grafo.agregarArista(1, 8, 1);
        grafo.agregarArista(1, 9, 1);
        grafo.agregarArista(1, 16, 1);
        grafo.agregarArista(1, 7, 1);
        grafo.agregarArista(1, 7, 1);


        grafo.eliminarVertice(7);
        grafo.eliminarVertice(16);
        grafo.eliminarVertice(1);


        assertFalse(grafo.vertices().pertenece(1));
        assertFalse(grafo.vertices().pertenece(16));
        assertFalse(grafo.vertices().pertenece(7));
        assertFalse(grafo.vertices().pertenece(32));
    }

    @Test
    public void test_grafo_traspuesto(){
        IGrafo grafo1 = new Grafo();
        grafo1.inicializarGrafo();

        IGrafo grafo2 = new Grafo();
        grafo2.inicializarGrafo();

        grafo1.agregarVertice(1);
        grafo1.agregarVertice(2);
        grafo1.agregarVertice(3);
        grafo1.agregarVertice(4);
        grafo1.agregarVertice(5);
        grafo1.agregarVertice(6);
        grafo1.agregarVertice(7);

        grafo1.agregarArista(1,2,4);
        grafo1.agregarArista(2,3,6);
        grafo1.agregarArista(3,1,5);
        grafo1.agregarArista(2,4,3);
        grafo1.agregarArista(4,5,4);
        grafo1.agregarArista(5,7,1);
        grafo1.agregarArista(7,6,5);
        grafo1.agregarArista(6,5,3);

        GrafoService grafoService = new GrafoService();
        grafoService.trasponer(grafo1, grafo2);

        assertTrue(grafo2.existeArista(2,1));
        assertEquals(grafo1.peso(1,2), grafo2.peso(2,1));
        assertEquals(grafo1.peso(2,3), grafo2.peso(3,2));
        assertEquals(grafo1.peso(2,4), grafo2.peso(4,2));
        assertNotEquals(grafo1.peso(2,4), grafo2.peso(4,5));
    }

}
