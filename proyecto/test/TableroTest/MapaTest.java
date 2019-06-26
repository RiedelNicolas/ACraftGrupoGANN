package TableroTest;

import Modelo.Excepciones.PosicionOcupadaException;
import Modelo.Jugador.Jugador;
import Modelo.Materiales.*;
import Modelo.Posicion.Posicion;
import Modelo.Tablero.Mapa;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MapaTest {
    private final int alto = 13;
    private final int ancho = 19;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test01MapaSeInstanciaConUnMetodoPropio(){
        Mapa mapa = Mapa.instanciar(alto, ancho);
        Assert.assertNotNull(mapa);
    }

    @Test
    public void test02MapaNoPuedeInstanciarse2Veces(){
        Mapa mapa1 = Mapa.instanciar(ancho, alto);
        Mapa mapa2 = Mapa.instanciar(1, 2);

        Assert.assertEquals(mapa1, mapa2);
    }

    @Test
    public void test03MapaSeCreaConUnaPosicionOcupadaEnElCentro(){

        Mapa mapa = Mapa.instanciar(ancho, alto);
        mapa = mapa.limpiar(ancho, alto);
        Posicion posicion = mapa.getPosicion(ancho/2, alto/2);

        Assert.assertNotNull(posicion.getOcupante());
    }

    @Test
    public void test04MapaSeCreaConElJugadorEnElCentro(){

        Mapa mapa = Mapa.instanciar(ancho, alto);
        mapa = mapa.limpiar(ancho, alto);
        Posicion jugador = mapa.getPosicion(ancho/2, alto/2);

        Assert.assertTrue(jugador.getOcupante() instanceof  Jugador);
    }

    @Test
    public void test05UnaPosicionNoPuedeUbicarseEnUnaPosicionOcupada(){
        Mapa mapa = Mapa.instanciar(ancho, alto);
        mapa = mapa.limpiar(ancho, alto);
        Posicion posicion = new Posicion(ancho/2, alto/2);

        thrown.expect(PosicionOcupadaException.class);
        mapa.ubicar(posicion);
    }

    @Test
    public void test05MapaSeInicializaSinErrores(){
        Mapa mapa = Mapa.instanciar(ancho, alto);
        mapa = mapa.limpiar(ancho, alto);
        mapa.inicializar();

        Assert.assertTrue(true);
    }

    @Test
    public void test06MapaTieneAlmenos1Madera(){

        Mapa mapa = Mapa.instanciar(ancho, alto);
        mapa = mapa.limpiar(ancho, alto);
        mapa.inicializar();
        int total = 0;

        for(int i = 0; i < ancho; i++){
            for(int j = 0; j < alto; j++){
                if(mapa.getPosicion(i, j).getOcupante() instanceof Madera){
                    total++;
                }
            }
        }

        Assert.assertTrue(total > 0);
    }

    @Test
    public void test07MapaTieneAlmenos1Metal(){

        Mapa mapa = Mapa.instanciar(ancho, alto);
        mapa = mapa.limpiar(ancho, alto);
        mapa.inicializar();
        int total = 0;

        for(int i = 0; i < ancho; i++){
            for(int j = 0; j < alto; j++){
                if(mapa.getPosicion(i, j).getOcupante() instanceof Metal){
                    total++;
                }
            }
        }

        Assert.assertTrue(total > 0);
    }

    @Test
    public void test08MapaTieneAlmenos1Piedra(){

        Mapa mapa = Mapa.instanciar(ancho, alto);
        mapa = mapa.limpiar(ancho, alto);
        mapa.inicializar();
        int total = 0;

        for(int i = 0; i < ancho; i++){
            for(int j = 0; j < alto; j++){
                if(mapa.getPosicion(i, j).getOcupante() instanceof Piedra){
                    total++;
                }
            }
        }

        Assert.assertTrue(total > 0);
    }

    @Test
    public void test09MapaTieneAlmenos1Diamante(){

        Mapa mapa = Mapa.instanciar(ancho, alto);
        mapa = mapa.limpiar(ancho, alto);
        mapa.inicializar();
        int total = 0;

        for(int i = 0; i < ancho; i++){
            for(int j = 0; j < alto; j++){
                if(mapa.getPosicion(i, j).getOcupante() instanceof Diamante){
                    total++;
                }
            }
        }

        Assert.assertTrue(total > 0);
    }

//    @Test
//    public void testintermedia(){
//        int alto = 45;
//        int ancho = 81;
//
//        Mapa mapa = Mapa.instanciar();
//        Posicion[][] _mapa = mapa.getCampo();
//        int total = 0;
//
//        for(int i = 0; i < ancho; i++){
//            for(int j = 0; j < alto; j++){
//                if((_mapa[i][j]).getOcupante() instanceof Diamante){
//                    total++;
//                }
//            }
//        }
//
//        Assert.assertTrue(total > 0);
//    }

//    @Test
//    public void test10MapaPermiteOcuparUnCasilleroVacioAUnMaterial(){
//        Mapa mapa = Mapa.instanciar();
//        Posicion material = new Posicion(new Metal(), 3, 3);
//
//        Posicion posicionDeseada = mapa.getPosicion(3, 3);
//
//        Assert.assertNull(posicionDeseada.getOcupante());
//        mapa.ubicar(material);
//        Assert.assertTrue();
//    }
//
//    @Test
//    public void test11MapaNoPermitePosicionarUnObjetoPosicionableDondeYaSeEncuentraUnoPosicionable(){
//        Mapa mapa = Mapa.instanciar();
//        Posicion material1 = new Posicion(new Madera(), 6, 8);
//        Posicion material2 = new Posicion(new Diamante(), 6, 8);
//        Posicion[][] _mapa = mapa.getCampo();
//
//        mapa.ubicar(material1);
//        Assert.assertTrue(_mapa[6][8].estaOcupada());
//
//        thrown.expect(PosicionOcupadaException.class);
//        mapa.ubicar(material2);
//    }

    @Test

    public void testDeLimpieza(){
        Mapa mapa = Mapa.instanciar(ancho, alto);
        mapa.inicializar();
        mapa = mapa.limpiar(ancho, alto);
        int total = 0;

        for(int i = 0; i < ancho; i++){
            for(int j = 0; j < alto; j++){
                if(mapa.getPosicion(i, j).getOcupante() instanceof Diamante){
                    total++;
                }
            }
        }

        for(int i = 0; i < ancho; i++){
            for(int j = 0; j < alto; j++){
                if(mapa.getPosicion(i, j).getOcupante() instanceof Madera){
                    total++;
                }
            }
        }

        for(int i = 0; i < ancho; i++){
            for(int j = 0; j < alto; j++){
                if(mapa.getPosicion(i, j).getOcupante() instanceof Metal){
                    total++;
                }
            }
        }

        for(int i = 0; i < ancho; i++){
            for(int j = 0; j < alto; j++){
                if(mapa.getPosicion(i, j).getOcupante() instanceof Piedra){
                    total++;
                }
            }
        }

        Assert.assertTrue(total == 0);
    }
}
