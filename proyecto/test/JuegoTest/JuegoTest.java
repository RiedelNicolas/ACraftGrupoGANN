package JuegoTest;

import Modelo.Juego.Juego;
import Modelo.Jugador.Jugador;
import Modelo.Posicion.Posicion;
import Modelo.Tablero.Mapa;
import Modelo.Materiales.*;


import org.junit.*;

public class JuegoTest {
    private final int alto = 13;
    private final int ancho = 19;

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
        Posicion jugador = juego.getPosicionJugador();

        Assert.assertTrue(jugador.getOcupante() instanceof Jugador);
    }

    @Test
    public void test05SeMueveAlJugadorHaciaArriba(){

        Juego juego = Juego.instanciar();
        Posicion jugadorPosicionInicial = juego.getPosicionJugador();

        juego.jugadorMoverArriba();
        Posicion jugadorPosicionFinal = juego.getPosicionJugador();

        Assert.assertNotEquals(jugadorPosicionInicial, jugadorPosicionFinal);
    }

    @Test
    public void test06SeMueveAlJugadorHaciaAbajo(){

        Juego juego = Juego.instanciar();
        Posicion jugadorPosicionInicial = juego.getPosicionJugador();

        juego.jugadorMoverAbajo();
        Posicion jugadorPosicionFinal = juego.getPosicionJugador();

        Assert.assertNotEquals(jugadorPosicionInicial, jugadorPosicionFinal);
    }

    @Test
    public void test07SeMueveAlJugadorHaciaIzquierda(){

        Juego juego = Juego.instanciar();
        Posicion jugadorPosicionInicial = juego.getPosicionJugador();

        juego.jugadorMoverIzquierda();
        Posicion jugadorPosicionFinal = juego.getPosicionJugador();

        Assert.assertNotEquals(jugadorPosicionInicial, jugadorPosicionFinal);
    }

    @Test
    public void test08SeMueveAlJugadorHaciaDerecha(){

        Juego juego = Juego.instanciar();
        Posicion jugadorPosicionInicial = juego.getPosicionJugador();

        juego.jugadorMoverArriba();
        Posicion jugadorPosicionFinal = juego.getPosicionJugador();

        Assert.assertNotEquals(jugadorPosicionInicial, jugadorPosicionFinal);
    }

    @Test
    public void test09NoSeMueveALaDerechaSiLaPosicionEstaOcupada(){

        Juego juego = Juego.instanciar();
        juego.restaurar();
        Mapa mapa = juego.getMapa();
        Posicion material = new Posicion(new Madera(), ancho/2 + 1, alto/2);

        mapa.ubicar(material);

        Assert.assertNotNull(juego.getPosicionJugador().getDerecha().getOcupante());
        Posicion jugadorPosicionInicial = juego.getPosicionJugador();

        juego.jugadorMoverDerecha();
        Posicion jugadorPosicionFinal = juego.getPosicionJugador();

        Assert.assertEquals(jugadorPosicionInicial, jugadorPosicionFinal);
    }

    @Test
    public void test10NoSeMueveALaIzquierdaSiLaPosicionEstaOcupada(){

        Juego juego = Juego.instanciar();
        juego.restaurar();
        Mapa mapa = juego.getMapa();
        Posicion material = new Posicion(new Madera(), ancho/2 - 1, alto/2);

        mapa.ubicar(material);

        Assert.assertNotNull(juego.getPosicionJugador().getIzquierda().getOcupante());
        Posicion jugadorPosicionInicial = juego.getPosicionJugador();

        juego.jugadorMoverIzquierda();
        Posicion jugadorPosicionFinal = juego.getPosicionJugador();

        Assert.assertEquals(jugadorPosicionInicial, jugadorPosicionFinal);
    }

    @Test
    public void test11NoSeMueveParaArribaSiLaPosicionEstaOcupada(){

        Juego juego = Juego.instanciar();
        juego.restaurar();
        Mapa mapa = juego.getMapa();
        Posicion material = new Posicion(new Madera(), ancho/2, alto/2 - 1);

        mapa.ubicar(material);

        Assert.assertNotNull(juego.getPosicionJugador().getArriba().getOcupante());
        Posicion jugadorPosicionInicial = juego.getPosicionJugador();

        juego.jugadorMoverArriba();
        Posicion jugadorPosicionFinal = juego.getPosicionJugador();

        Assert.assertEquals(jugadorPosicionInicial, jugadorPosicionFinal);
    }

    @Test
    public void test12NoSeMueveParaAbajoSiLaPosicionEstaOcupada(){

        Juego juego = Juego.instanciar();
        juego.restaurar();
        Mapa mapa = juego.getMapa();
        Posicion material = new Posicion(new Madera(), ancho/2, alto/2 + 1);

        mapa.ubicar(material);

        Assert.assertNotNull(juego.getPosicionJugador().getAbajo().getOcupante());
        Posicion jugadorPosicionInicial = juego.getPosicionJugador();

        juego.jugadorMoverAbajo();
        Posicion jugadorPosicionFinal = juego.getPosicionJugador();

        Assert.assertEquals(jugadorPosicionInicial, jugadorPosicionFinal);
    }

    @Test
    public void test13SiElJugadorIntentaGolpearFueraDelMapaNoSeProducenCambiosEnElJuego(){
        Juego juego = Juego.instanciar();
        juego.restaurar();
        Jugador jugador = (Jugador) juego.getPosicionJugador().getOcupante();

        int usosHerramientaInicial = jugador.getUtilizableEnMano().getUsosRestantes();
        Posicion PosicionAntesDelGolpe = juego.getPosicionJugador();

        juego.jugadorGolpearDerecha();

        Assert.assertEquals(PosicionAntesDelGolpe, juego.getPosicionJugador());
        Assert.assertEquals(usosHerramientaInicial, jugador.getUtilizableEnMano().getUsosRestantes());
    }

    @Test
    public void test14SiElJugadorIntentaGolpearUnLugarVacioNoSeProducenCambiosEnElJuego(){
        Juego juego = Juego.instanciar();
        juego.restaurar();
        Posicion vacio = new Posicion(ancho/2, alto/2 + 1);
        Jugador jugador = (Jugador) juego.getPosicionJugador().getOcupante();

        juego.getMapa().ubicar(vacio);

        int usosHerramientaInicial = jugador.getUtilizableEnMano().getUsosRestantes();
        Posicion PosicionAntesDelGolpe = juego.getPosicionJugador();

        juego.jugadorGolpearAbajo();

        Assert.assertEquals(PosicionAntesDelGolpe, juego.getPosicionJugador());
        Assert.assertEquals(usosHerramientaInicial, jugador.getUtilizableEnMano().getUsosRestantes());
    }

    @Test
    public void test15SiElJugadorGolpeaUnMaterialAbajoElJuegoContinuaComoDebe(){
        Juego juego = Juego.instanciar();
        juego.restaurar();
        Madera madera = new Madera();
        Posicion posicionMaterial = new Posicion(madera, ancho/2, alto/2 + 1);
        Jugador jugador = (Jugador) juego.getPosicionJugador().getOcupante();

        juego.getMapa().ubicar(posicionMaterial);

        int usosHerramientaInicial = jugador.getUtilizableEnMano().getUsosRestantes();
        int durabilidadMaterialInicial = madera.getDurabilidad();

        juego.jugadorGolpearAbajo();

        Assert.assertNotEquals(durabilidadMaterialInicial, madera.getDurabilidad());
        Assert.assertNotEquals(usosHerramientaInicial, jugador.getUtilizableEnMano().getUsosRestantes());
    }

    @Test
    public void test16SiElJugadorGolpeaUnMaterialASuIzquierdaElJuegoContinuaComoDebe(){
        Juego juego = Juego.instanciar();
        juego.restaurar();
        Madera madera = new Madera();
        Posicion posicionMaterial = new Posicion(madera, ancho/2 -1, alto/2);
        Jugador jugador = (Jugador) juego.getPosicionJugador().getOcupante();

        juego.getMapa().ubicar(posicionMaterial);

        int usosHerramientaInicial = jugador.getUtilizableEnMano().getUsosRestantes();
        int durabilidadMaterialInicial = madera.getDurabilidad();

        juego.jugadorGolpearIzquierda();

        Assert.assertNotEquals(durabilidadMaterialInicial, madera.getDurabilidad());
        Assert.assertNotEquals(usosHerramientaInicial, jugador.getUtilizableEnMano().getUsosRestantes());
    }


    @Test
    public void test17SiElJugadorGolpeaUnMaterialArribaElJuegoContinuaComoDebe(){
        Juego juego = Juego.instanciar();
        juego.restaurar();
        Madera madera = new Madera();
        Posicion posicionMaterial = new Posicion(madera, ancho/2, alto/2 -1);
        Jugador jugador = (Jugador) juego.getPosicionJugador().getOcupante();

        juego.getMapa().ubicar(posicionMaterial);

        int usosHerramientaInicial = jugador.getUtilizableEnMano().getUsosRestantes();
        int durabilidadMaterialInicial = madera.getDurabilidad();

        juego.jugadorGolpearArriba();

        Assert.assertNotEquals(durabilidadMaterialInicial, madera.getDurabilidad());
        Assert.assertNotEquals(usosHerramientaInicial, jugador.getUtilizableEnMano().getUsosRestantes());
    }

    @Test
    public void test18SiElJugadorGolpeaUnMaterialAsuDerechaElJuegoContinuaComoDebe(){
        Juego juego = Juego.instanciar();
        juego.restaurar();
        Madera madera = new Madera();
        Posicion posicionMaterial = new Posicion(madera, ancho/2 +1, alto/2);
        Jugador jugador = (Jugador) juego.getPosicionJugador().getOcupante();

        juego.getMapa().ubicar(posicionMaterial);

        int usosHerramientaInicial = jugador.getUtilizableEnMano().getUsosRestantes();
        int durabilidadMaterialInicial = madera.getDurabilidad();

        juego.jugadorGolpearDerecha();

        Assert.assertNotEquals(durabilidadMaterialInicial, madera.getDurabilidad());
        Assert.assertNotEquals(usosHerramientaInicial, jugador.getUtilizableEnMano().getUsosRestantes());
    }

}
