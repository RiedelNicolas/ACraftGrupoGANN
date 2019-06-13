package TableroTest;

import Algocraft.Posicion.Posicion;
import Algocraft.Tablero.Mapa;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MapaTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test01MapaSeInstanciaConUnMetodoPropio(){
        Mapa mapa = Mapa.instanciar();
        Assert.assertNotNull(mapa);
    }

    @Test
    public void test02MapaNoPuedeInstanciarse2Veces(){
        Mapa mapa1 = Mapa.instanciar();
        Mapa mapa2 = Mapa.instanciar();

        Assert.assertEquals(mapa1, mapa2);
    }

    @Test
    public void test03MapaInicializaAlJugadorEnElCentro(){
        int alto = 81;
        int ancho = 61;

        Mapa mapa = Mapa.instanciar();
        mapa.inicializar();
        Posicion[][] _mapa = mapa.getMapa();

        Assert.assertTrue((_mapa[ancho/2][alto/2]).estaOcupada());
    }

//    @Test

//    @Test
//    public void test03MapaInicializaAlJugadorEnElCentroDelMapa(){
//        int ancho = 61;
//        int alto = 81;
//        Mapa mapa = Mapa.instanciar();
//        Posicion jugador = mapa.getJugador();
//
//        Assert.assertEquals(jugador.componenteHorizontal(), ancho/2);
//        Assert.assertEquals(jugador.componenteVertical(), alto/2);
//    }
}
