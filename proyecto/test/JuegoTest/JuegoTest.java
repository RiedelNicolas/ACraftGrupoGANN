package JuegoTest;

import Modelo.Juego.Juego;
import Modelo.Jugador.Jugador;
import Modelo.Posicion.Posicion;
import Modelo.Tablero.Mapa;
import Modelo.Materiales.*;


import org.junit.*;

public class JuegoTest {
    private final int alto = 45;
    private final int ancho = 81;

    @Test
    public void test01JuegoSeCrea() {
        Juego juego = Juego.instanciar();
        Assert.assertNotNull(juego);
    }

    @Test
    public void test02SeCreanDosInstanciasDeJuegoYEsLaMisma(){
        Juego juegoUno = Juego.instanciar();
        Juego juegoDos = Juego.instanciar();

        Assert.assertEquals(juegoUno, juegoDos);
    }

    @Test
    public void test03JuegoInstanciaAMapaCorrectamente(){
        Juego juego = Juego.instanciar();
        Mapa mapa = juego.getMapa();

        Assert.assertNotNull(mapa);
    }

    @Test
    public void test04JuegoTieneLaPosicionDelJugador(){
        Juego juego = Juego.instanciar();
        Posicion jugador = juego.getJugador();

        Assert.assertTrue(jugador.getOcupante() instanceof Jugador);
    }

    @Test
    public void test05SeMueveAlJugadorHaciaArriba(){

        Juego juego = Juego.instanciar();
        Posicion jugadorPosicionInicial = juego.getJugador();

        juego.jugadorMoverArriba();
        Posicion jugadorPosicionFinal = juego.getJugador();

        Assert.assertNotEquals(jugadorPosicionInicial, jugadorPosicionFinal);
    }

    @Test
    public void test06SeMueveAlJugadorHaciaAbajo(){

        Juego juego = Juego.instanciar();
        Posicion jugadorPosicionInicial = juego.getJugador();

        juego.jugadorMoverAbajo();
        Posicion jugadorPosicionFinal = juego.getJugador();

        Assert.assertNotEquals(jugadorPosicionInicial, jugadorPosicionFinal);
    }

    @Test
    public void test07SeMueveAlJugadorHaciaIzquierda(){

        Juego juego = Juego.instanciar();
        Posicion jugadorPosicionInicial = juego.getJugador();

        juego.jugadorMoverIzquierda();
        Posicion jugadorPosicionFinal = juego.getJugador();

        Assert.assertNotEquals(jugadorPosicionInicial, jugadorPosicionFinal);
    }

    @Test
    public void test08SeMueveAlJugadorHaciaDerecha(){

        Juego juego = Juego.instanciar();
        Posicion jugadorPosicionInicial = juego.getJugador();

        juego.jugadorMoverArriba();
        Posicion jugadorPosicionFinal = juego.getJugador();

        Assert.assertNotEquals(jugadorPosicionInicial, jugadorPosicionFinal);
    }

    @Test
    public void test09NoSeMueveALaDerechaSiLaPosicionEstaOcupada(){

        Juego juego = Juego.instanciar();
        Posicion material = new Posicion(new Madera(), ancho/2 + 1, alto/2);
        juego.getMapa().ubicar(material);
        Posicion jugadorPosicionInicial = juego.getJugador();

        juego.jugadorMoverDerecha();
        Posicion jugadorPosicionFinal = juego.getJugador();

        Assert.assertEquals(jugadorPosicionInicial, jugadorPosicionFinal);
    }

    @Test
    public void test10NoSeMueveALaIzquierdaSiLaPosicionEstaOcupada(){  //

        Juego juego = Juego.instanciar();
        Posicion material = new Posicion(new Madera(), ancho/2 - 1, alto/2);
        Posicion jugadorPosicionInicial = juego.getJugador();

        juego.jugadorMoverDerecha();
        Posicion jugadorPosicionFinal = juego.getJugador();

        Assert.assertEquals(jugadorPosicionInicial, jugadorPosicionFinal);
    }
}
