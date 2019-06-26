package PosicionTest;

import Modelo.Excepciones.MaterialRotoException;
import Modelo.Excepciones.PosicionFueraDeRangoException;
import Modelo.Excepciones.PosicionNoGolpeableException;
import Modelo.Excepciones.PosicionOcupadaException;
import Modelo.Jugador.Jugador;
import Modelo.Materiales.*;
import Modelo.Posicion.Posicion;
import Modelo.Posicion.Posicionable;
import Modelo.Tablero.Mapa;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PosicionTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test01SeAsignaLaComponenteHorizontalCorrectamente(){
        Posicion unaPosicion = new Posicion(10, 5);

        Assert.assertEquals(unaPosicion.componenteHorizontal(), 10);

    }

    @Test
    public void test02SeAsignaLaComponenteVerticalCorrectamente(){
        Posicion unaPosicion = new Posicion(10, 5);

        Assert.assertEquals(unaPosicion.componenteVertical(), 5);
    }

    @Test
    public void test03SeAsignaUnOcupanteJugadorCorrectamente(){
        Jugador unJugador = Jugador.instanciar();
        Posicion unaPosicion = new Posicion(unJugador, 2, 2);

        Assert.assertNotNull(unaPosicion.getOcupante());
    }

    @Test
    public void test04SeAsignaUnOcupanteMaterialCorrectamente(){
        Piedra piedra = new Piedra();
        Posicion unaPosicion = new Posicion(piedra, 2, 2);

        Assert.assertNotNull(unaPosicion.getOcupante());
    }

    @Test
    public void test05SiNoSeAsignaOcupanteEsteEsNull(){
        Posicion unaPosicion = new Posicion(2, 2);

        Assert.assertNull(unaPosicion.getOcupante());
    }

    @Test
    public void test06UnPosicionablePuedeOcuparUnaPosicionSinOcupante(){
        Posicion posicionVacia = new Posicion(3, 3);
        Posicionable ocupante = Jugador.instanciar();

        posicionVacia.ocupar(ocupante);

        Assert.assertNotNull(posicionVacia.getOcupante());
    }

    @Test
    public void test07UnPosicionableNoPuedeOcuparUnaPosicionConOcupante(){
        Posicion posicionVacia = new Posicion(new Madera(), 3, 3);
        Posicionable ocupante = Jugador.instanciar();

        thrown.expect(PosicionOcupadaException.class);
        posicionVacia.ocupar(ocupante);
    }

    @Test
    public void test08UnaPosicionSinOcupanteAsignaSusVecinosNullPorDefault(){
        Posicion posicion = new Posicion(3, 3);

        Assert.assertNull(posicion.getAbajo());
        Assert.assertNull(posicion.getArriba());
        Assert.assertNull(posicion.getIzquierda());
        Assert.assertNull(posicion.getDerecha());
    }

    @Test
    public void test09UnaPosicionConOcupanteAsignaSusVecinosNullPorDefault(){
        Posicion posicion = new Posicion(new Madera(), 3, 3);

        Assert.assertNull(posicion.getAbajo());
        Assert.assertNull(posicion.getArriba());
        Assert.assertNull(posicion.getIzquierda());
        Assert.assertNull(posicion.getDerecha());
    }

    @Test
    public void test10UnaPosicionSeUbicaEnElMapaCorrectamente(){
        Mapa mapa = Mapa.instanciar(30, 30);
        mapa = mapa.limpiar(30, 30);
        Posicion posicion = new Posicion(10, 10);

        mapa.ubicar(posicion);

        Assert.assertEquals(mapa.getPosicion(10, 10), posicion);
    }

    @Test
    public void test11UnaPosicionAsignaVecinoIzquierdoCorrectamente(){
        Mapa mapa = Mapa.instanciar(30, 30);
        mapa = mapa.limpiar(30, 30);
        Posicion posicion = new Posicion(10, 10);
        Posicion posicionVecina = new Posicion(9, 10);

        mapa.ubicar(posicionVecina);
        posicion.setPosicionesVecinas(mapa);

        Assert.assertEquals(posicionVecina, posicion.getIzquierda());
    }

    @Test
    public void test12UnaPosicionAsignaVecinoDerechoCorrectamente(){
        Mapa mapa = Mapa.instanciar(30, 30);
        mapa = mapa.limpiar(30, 30);
        Posicion posicion = new Posicion(10, 10);
        Posicion posicionVecina = new Posicion(11, 10);

        mapa.ubicar(posicionVecina);
        posicion.setPosicionesVecinas(mapa);

        Assert.assertEquals(posicionVecina, posicion.getDerecha());
    }

    @Test
    public void test13UnaPosicionAsignaVecinoSuperiorCorrectamente(){
        Mapa mapa = Mapa.instanciar(30, 30);
        mapa = mapa.limpiar(30, 30);
        Posicion posicion = new Posicion(10, 10);
        Posicion posicionVecina = new Posicion(10, 9);

        mapa.ubicar(posicionVecina);
        posicion.setPosicionesVecinas(mapa);

        Assert.assertEquals(posicionVecina, posicion.getArriba());
    }

    @Test
    public void test14UnaPosicionAsignaVecinoInferiorCorrectamente(){
        Mapa mapa = Mapa.instanciar(30, 30);
        mapa = mapa.limpiar(30, 30);
        Posicion posicion = new Posicion(10, 10);
        Posicion posicionVecina = new Posicion(10, 11);

        mapa.ubicar(posicionVecina);
        posicion.setPosicionesVecinas(mapa);

        Assert.assertEquals(posicionVecina, posicion.getAbajo());
    }

    @Test
    public void test15UnaPosicionEnElLimiteIzquierdoDelMapaNoAsignaVecinoIzquierdo(){
        Mapa mapa = Mapa.instanciar(30, 30);
        mapa = mapa.limpiar(30, 30);
        Posicion posicion = new Posicion(0, 10);
        posicion.setPosicionesVecinas(mapa);

        Assert.assertNull(posicion.getIzquierda());
    }

    @Test
    public void test16UnaPosicionEnElLimiteDerechoDelMapaNoAsignaVecinoDerecho(){
        Mapa mapa = Mapa.instanciar(30, 30);
        mapa = mapa.limpiar(30, 30);
        Posicion posicion = new Posicion(29, 10);
        posicion.setPosicionesVecinas(mapa);

        Assert.assertNull(posicion.getDerecha());
    }

    @Test
    public void test17UnaPosicionEnElLimiteSuperiorDelMapaNoAsignaVecinoSuperior(){
        Mapa mapa = Mapa.instanciar(30, 30);
        mapa = mapa.limpiar(30, 30);
        Posicion posicion = new Posicion(10, 0);
        posicion.setPosicionesVecinas(mapa);

        Assert.assertNull(posicion.getArriba());
    }

    @Test
    public void test18UnaPosicionEnElLimiteInferiorDelMapaNoAsignaVecinoInferior(){
        Mapa mapa = Mapa.instanciar(30, 30);
        mapa = mapa.limpiar(30, 30);
        Posicion posicion = new Posicion(10, 29);
        posicion.setPosicionesVecinas(mapa);

        Assert.assertNull(posicion.getAbajo());
    }

    @Test
    public void test19UnaPosicionPuedeMoverASuOcupanteALaDerechaSiEstaSiguentePosicionNoEstaOcupada() {
        Mapa mapa = Mapa.instanciar(30, 30);
        mapa = mapa.limpiar(30, 30);
        Posicion posicion = new Posicion(Jugador.instanciar(), 10, 10);
        Posicion posicionVecina = new Posicion(11, 10);
        mapa.ubicar(posicionVecina);
        posicion.setPosicionesVecinas(mapa);

        Assert.assertNull(posicion.getDerecha().getOcupante());


        Assert.assertEquals(posicion.moverDerecha(), posicionVecina);
    }

    @Test
    public void test20UnaPosicionPuedeMoverASuOcupanteALaIzquierdaSiEstaSiguentePosicionNoEstaOcupada(){
        Mapa mapa = Mapa.instanciar(30, 30);
        mapa = mapa.limpiar(30, 30);
        Posicion posicion = new Posicion(Jugador.instanciar(), 10, 10);
        Posicion posicionVecina = new Posicion(9, 10);
        mapa.ubicar(posicionVecina);
        posicion.setPosicionesVecinas(mapa);

        Assert.assertNull(posicion.getIzquierda().getOcupante());

        Assert.assertEquals(posicion.moverIzquierda(), posicionVecina);
    }

    @Test
    public void test21UnaPosicionPuedeMoverASuOcupanteParaArribaSiEstaSiguentePosicionNoEstaOcupada(){
        Mapa mapa = Mapa.instanciar(30, 30);
        mapa = mapa.limpiar(30, 30);
        Posicion posicion = new Posicion(Jugador.instanciar(), 10, 10);
        Posicion posicionVecina = new Posicion(10, 9);
        mapa.ubicar(posicionVecina);
        posicion.setPosicionesVecinas(mapa);

        Assert.assertNull(posicion.getArriba().getOcupante());

        Assert.assertEquals(posicion.moverArriba(), posicionVecina);
    }

    @Test
    public void test22UnaPosicionPuedeMoverASuOcupanteParaAbajoSiEstaSiguentePosicionNoEstaOcupada(){
        Mapa mapa = Mapa.instanciar(30, 30);
        mapa = mapa.limpiar(30, 30);
        Posicion posicion = new Posicion(Jugador.instanciar(), 10, 10);
        Posicion posicionVecina = new Posicion(10, 11);
        mapa.ubicar(posicionVecina);
        posicion.setPosicionesVecinas(mapa);

        Assert.assertNull(posicion.getAbajo().getOcupante());

        Assert.assertEquals(posicion.moverAbajo(), posicionVecina);
    }

    @Test
    public void test23UnaPosicionNoPuedeMoverASuOcupanteALaDerechaSiEstaSiguentePosicionEstaOcupada(){
        Mapa mapa = Mapa.instanciar(30, 30);
        mapa = mapa.limpiar(30, 30);
        Posicion posicion = new Posicion(Jugador.instanciar(), 10, 10);
        Posicion posicionVecina = new Posicion(new Madera(),11, 10);
        mapa.ubicar(posicionVecina);
        posicion.setPosicionesVecinas(mapa);

        Assert.assertNotNull(posicion.getDerecha().getOcupante());

        Assert.assertEquals(posicion.moverDerecha(), posicion);
    }

    @Test
    public void test24UnaPosicionNoPuedeMoverASuOcupanteALaIzquierdaSiEstaSiguentePosicionEstaOcupada(){
        Mapa mapa = Mapa.instanciar(30, 30);
        mapa = mapa.limpiar(30, 30);
        Posicion posicion = new Posicion(Jugador.instanciar(), 10, 10);
        Posicion posicionVecina = new Posicion(new Piedra(),9, 10);
        mapa.ubicar(posicionVecina);
        mapa.ubicar(posicion);

        Assert.assertNotNull(posicion.getIzquierda().getOcupante());

        Assert.assertEquals(posicion.moverIzquierda(), posicion);
    }

    @Test
    public void test25UnaPosicionNoPuedeMoverASuOcupanteParaArribaSiEstaSiguentePosicionEstaOcupada(){
        Mapa mapa = Mapa.instanciar(30, 30);
        mapa = mapa.limpiar(30, 30);
        Posicion posicion = new Posicion(Jugador.instanciar(), 10, 10);
        Posicion posicionVecina = new Posicion(new Metal(),10, 9);
        mapa.ubicar(posicionVecina);
        mapa.ubicar(posicion);

        Assert.assertNotNull(posicion.getArriba().getOcupante());

        Assert.assertEquals(posicion.moverArriba(), posicion);
    }

    @Test
    public void test26UnaPosicionNoPuedeMoverASuOcupanteParaAbajoSiEstaSiguentePosicionEstaOcupada(){
        Mapa mapa = Mapa.instanciar(30, 30);
        mapa = mapa.limpiar(30, 30);
        Posicion posicion = new Posicion(Jugador.instanciar(), 10, 10);
        Posicion posicionVecina = new Posicion(new Metal(),10, 11);
        mapa.ubicar(posicionVecina);
        mapa.ubicar(posicion);

        Assert.assertNotNull(posicion.getAbajo().getOcupante());

        Assert.assertEquals(posicion.moverAbajo(), posicion);
    }

    @Test
    public void test27UnaPosicionEnElLimiteIzquierdoDelMapaNoPuedeMoverASuOcupanteAfueraDelMapa(){
        Mapa mapa = Mapa.instanciar(30, 30);
        mapa = mapa.limpiar(30, 30);
        Posicion posicion = new Posicion(Jugador.instanciar(), 0, 10);

        mapa.ubicar(posicion);

        thrown.expect(PosicionFueraDeRangoException.class);
        posicion.moverIzquierda();
    }

    @Test
    public void test28UnaPosicionEnElLimiteDerechoDelMapaNoPuedeMoverASuOcupanteAfueraDelMapa(){
        Mapa mapa = Mapa.instanciar(30, 30);
        mapa = mapa.limpiar(30, 30);
        Posicion posicion = new Posicion(Jugador.instanciar(), 29, 10);

        mapa.ubicar(posicion);

        thrown.expect(PosicionFueraDeRangoException.class);
        posicion.moverDerecha();
    }

    @Test
    public void test29UnaPosicionEnElLimiteSuperiorDelMapaNoPuedeMoverASuOcupanteAfueraDelMapa(){
        Mapa mapa = Mapa.instanciar(30, 30);
        mapa = mapa.limpiar(30, 30);
        Posicion posicion = new Posicion(Jugador.instanciar(), 10, 0);

        mapa.ubicar(posicion);

        thrown.expect(PosicionFueraDeRangoException.class);
        posicion.moverArriba();
    }

    @Test
    public void test30UnaPosicionEnElLimiteInferiorDelMapaNoPuedeMoverASuOcupanteAfueraDelMapa(){
        Mapa mapa = Mapa.instanciar(30, 30);
        mapa = mapa.limpiar(30, 30);
        Posicion posicion = new Posicion(Jugador.instanciar(), 10, 29);

        mapa.ubicar(posicion);

        thrown.expect(PosicionFueraDeRangoException.class);
        posicion.moverAbajo();
    }

    @Test
    public void test31UnJugadorEnUnaPosicionDelMapaNoPuedeGolpearParaAbajoSiEstaPosicionObjetivoEstaVacia(){
        Mapa mapa = Mapa.instanciar(30, 30);
        mapa = mapa.limpiar(30, 30);
        Posicion posicion = new Posicion(Jugador.instanciar(), 10, 10);

        mapa.ubicar(posicion);

        thrown.expect(PosicionNoGolpeableException.class);
        posicion.golpearAbajo();
    }

    @Test
    public void test32UnJugadorEnUnaPosicionDelMapaNoPuedeGolpearParaArribaSiEstaPosicionObjetivoEstaVacia(){
        Mapa mapa = Mapa.instanciar(30, 30);
        mapa = mapa.limpiar(30, 30);
        Posicion posicion = new Posicion(Jugador.instanciar(), 10, 10);

        mapa.ubicar(posicion);

        thrown.expect(PosicionNoGolpeableException.class);
        posicion.golpearArriba();
    }

    @Test
    public void test33UnJugadorEnUnaPosicionDelMapaNoPuedeGolpearParaLaIzquierdaSiEstaPosicionObjetivoEstaVacia(){
        Mapa mapa = Mapa.instanciar(30, 30);
        mapa = mapa.limpiar(30, 30);
        Posicion posicion = new Posicion(Jugador.instanciar(), 10, 10);

        mapa.ubicar(posicion);

        thrown.expect(PosicionNoGolpeableException.class);
        posicion.golpearIzquierda();
    }

    @Test
    public void test34UnJugadorEnUnaPosicionDelMapaNoPuedeGolpearParaLaDerechaSiEstaPosicionObjetivoEstaVacia(){
        Mapa mapa = Mapa.instanciar(30, 30);
        mapa = mapa.limpiar(30, 30);
        Posicion posicion = new Posicion(Jugador.instanciar(), 10, 10);

        mapa.ubicar(posicion);

        thrown.expect(PosicionNoGolpeableException.class);
        posicion.golpearDerecha();
    }

    @Test
    public void test35UnJugadorEnUnaPosicionDelMapaPuedeGolpearParaLaDerechaSiEstaPosicionObjetivoTieneUnOcupante(){
        Mapa mapa = Mapa.instanciar(30, 30);
        mapa = mapa.limpiar(30, 30);
        Madera madera = new Madera();
        Posicion posicion = new Posicion(Jugador.instanciar(), 10, 10);
        Posicion posicionObjetivo = new Posicion(madera, 11, 10);

        int durabilidadInicial = madera.getDurabilidad();

        mapa.ubicar(posicion);
        mapa.ubicar(posicionObjetivo);

        posicion.golpearDerecha();

        int durabilidadFinal = madera.getDurabilidad();

        Assert.assertNotEquals(durabilidadInicial, durabilidadFinal);
    }

    @Test
    public void test36UnJugadorEnUnaPosicionDelMapaPuedeGolpearParaLaIzquierdaSiEstaPosicionObjetivoTieneUnOcupante(){
        Mapa mapa = Mapa.instanciar(30, 30);
        mapa = mapa.limpiar(30, 30);
        Madera madera = new Madera();
        Posicion posicion = new Posicion(Jugador.instanciar(), 10, 10);
        Posicion posicionObjetivo = new Posicion(madera, 9, 10);

        int durabilidadInicial = madera.getDurabilidad();

        mapa.ubicar(posicion);
        mapa.ubicar(posicionObjetivo);

        posicion.golpearIzquierda();

        int durabilidadFinal = madera.getDurabilidad();

        Assert.assertNotEquals(durabilidadInicial, durabilidadFinal);
    }

    @Test
    public void test37UnJugadorEnUnaPosicionDelMapaPuedeGolpearParaAbajoSiEstaPosicionObjetivoTieneUnOcupante(){
        Mapa mapa = Mapa.instanciar(30, 30);
        mapa = mapa.limpiar(30, 30);
        Madera madera = new Madera();
        Posicion posicion = new Posicion(Jugador.instanciar(), 10, 10);
        Posicion posicionObjetivo = new Posicion(madera, 10, 11);

        int durabilidadInicial = madera.getDurabilidad();

        mapa.ubicar(posicion);
        mapa.ubicar(posicionObjetivo);

        posicion.golpearAbajo();

        int durabilidadFinal = madera.getDurabilidad();

        Assert.assertNotEquals(durabilidadInicial, durabilidadFinal);
    }

    @Test
    public void test38UnJugadorEnUnaPosicionDelMapaPuedeGolpearParaArribaSiEstaPosicionObjetivoTieneUnOcupante(){
        Mapa mapa = Mapa.instanciar(30, 30);
        mapa = mapa.limpiar(30, 30);
        Madera madera = new Madera();
        Posicion posicion = new Posicion(Jugador.instanciar(), 10, 10);
        Posicion posicionObjetivo = new Posicion(madera, 10, 9);

        int durabilidadInicial = madera.getDurabilidad();

        mapa.ubicar(posicion);
        mapa.ubicar(posicionObjetivo);

        posicion.golpearArriba();

        int durabilidadFinal = madera.getDurabilidad();

        Assert.assertNotEquals(durabilidadInicial, durabilidadFinal);
    }

    @Test
    public void test39UnJugadorEnUnPosicionSobreElLimiteIzquierdoDelMapaNoPuedeGolpearHaciaLaIzquierda(){
        Mapa mapa = Mapa.instanciar(30, 30);
        mapa = mapa.limpiar(30, 30);
        Madera madera = new Madera();
        Posicion posicion = new Posicion(Jugador.instanciar(), 0, 10);

        mapa.ubicar(posicion);

        thrown.expect(PosicionNoGolpeableException.class);
        posicion.golpearIzquierda();
    }

    @Test
    public void test40UnJugadorEnUnPosicionSobreElLimiteDerechoDelMapaNoPuedeGolpearHaciaLaDerecha(){
        Mapa mapa = Mapa.instanciar(30, 30);
        mapa = mapa.limpiar(30, 30);
        Madera madera = new Madera();
        Posicion posicion = new Posicion(Jugador.instanciar(), 29, 10);

        mapa.ubicar(posicion);

        thrown.expect(PosicionNoGolpeableException.class);
        posicion.golpearDerecha();
    }

    @Test
    public void test40UnJugadorEnUnPosicionSobreElLimiteSuperiorDelMapaNoPuedeGolpearHaciaArriba(){
        Mapa mapa = Mapa.instanciar(30, 30);
        mapa = mapa.limpiar(30, 30);
        Madera madera = new Madera();
        Posicion posicion = new Posicion(Jugador.instanciar(), 10, 0);

        mapa.ubicar(posicion);

        thrown.expect(PosicionNoGolpeableException.class);
        posicion.golpearArriba();
    }

    @Test
    public void test41UnJugadorEnUnPosicionSobreElLimiteInferiorDelMapaNoPuedeGolpearHaciaAbajo(){
        Mapa mapa = Mapa.instanciar(30, 30);
        mapa = mapa.limpiar(30, 30);
        Madera madera = new Madera();
        Posicion posicion = new Posicion(Jugador.instanciar(), 10, 29);

        mapa.ubicar(posicion);

        thrown.expect(PosicionNoGolpeableException.class);
        posicion.golpearAbajo();
    }

    @Test
    public void test42AlMoverUnJugadorHaciaUnaNuevaPosicionDesocupadaLaViejaPosicionQuedaSinOcupante(){
        Mapa mapa = Mapa.instanciar(30, 30);
        mapa = mapa.limpiar(30, 30);
        Posicion viejoJugador = new Posicion(Jugador.instanciar(), 10, 10);
        Posicion nuevoJugador = new Posicion(10, 11);

        mapa.ubicar(viejoJugador);
        mapa.ubicar(nuevoJugador);

        viejoJugador.moverAbajo();

        Assert.assertNull(viejoJugador.getOcupante());
    }

    @Test
    public void test43UnJugadorGolpeaUnMaterialYAlRomperseEsteSeSacaDelMapa(){
        Mapa mapa = Mapa.instanciar(30, 30);
        mapa = mapa.limpiar(30, 30);

        Madera madera = new Madera();
        Jugador jugador = Jugador.instanciar();

        boolean materialRoto = false;
        while(!materialRoto) {
            try{
                jugador.golpear(madera);
            } catch (MaterialRotoException e){
                materialRoto = true;
            }
        }

        Posicion posicionJugador = new Posicion(jugador, 10, 10);
        Posicion posicionMaterial = new Posicion(madera, 11, 10);

        mapa.ubicar(posicionJugador);
        mapa.ubicar(posicionMaterial);

        posicionJugador.golpearDerecha();

        Assert.assertNull(posicionMaterial.getOcupante());
    }
}