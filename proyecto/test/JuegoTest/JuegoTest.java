package JuegoTest;

import Algocraft.Juego.Juego;
import Algocraft.Posicion.Posicion;
import Algocraft.Tablero.Mapa;
import Algocraft.Materiales.*;


import org.junit.*;

public class JuegoTest {

    @Test
    public void test01JuegoSeCrea() {
        Juego juego = Juego.crearUnico();
        Assert.assertNotNull(juego);
    }

    @Test
    public void test02SeCreanDosInstanciasDeJuegoYEsLaMisma(){
        Juego juegoUno = Juego.crearUnico();
        Juego juegoDos = Juego.crearUnico();

        Assert.assertEquals(juegoUno, juegoDos);
    }

    @Test
    public void test03JuegoInstanciaAMapaCorrectamente(){
        Juego juego = Juego.crearUnico();
        Mapa mapa = juego.getMapa();

        Assert.assertNotNull(mapa);
    }

    @Test
    public void test04SeMueveAlJugadorHaciaArriba(){  //Modificar a que juego le pase los parametros del campo al mapa
        int alto = 45;
        int ancho = 81;

        Juego juego = Juego.crearUnico();
        Mapa mapa = juego.getMapa();
        Posicion[][] _mapa = mapa.getMapa();

        mapa.moverJugadorArriba();

        Assert.assertFalse(_mapa[ancho/2][alto/2].estaOcupada());
        Assert.assertTrue(_mapa[ancho/2][(alto/2) - 1].estaOcupada());

    }

    @Test
    public void test05SeMueveAlJugadorHaciaAbajo(){
        int alto = 45;
        int ancho = 81;

        Juego juego = Juego.crearUnico();
        Mapa mapa = juego.getMapa();
        Posicion[][] _mapa = mapa.getMapa();

        mapa.moverJugadorAbajo();

        Assert.assertFalse(_mapa[ancho/2][alto/2].estaOcupada());
        Assert.assertTrue(_mapa[ancho/2][(alto/2) + 1].estaOcupada());
    }

    @Test
    public void test06SeMueveAlJugadorHaciaIzquierda(){
        int alto = 45;
        int ancho = 81;

        Juego juego = Juego.crearUnico();
        Mapa mapa = juego.getMapa();
        Posicion[][] _mapa = mapa.getMapa();

        mapa.moverJugadorIzquierda();

        Assert.assertFalse(_mapa[ancho/2][alto/2].estaOcupada());
        Assert.assertTrue(_mapa[(ancho/2) - 1][(alto/2)].estaOcupada());
    }

    @Test
    public void test07SeMueveAlJugadorHaciaDerecha(){
        int alto = 45;
        int ancho = 81;

        Juego juego = Juego.crearUnico();
        Mapa mapa = juego.getMapa();
        Posicion[][] _mapa = mapa.getMapa();

        mapa.moverJugadorDerecha();

        Assert.assertFalse(_mapa[ancho/2][alto/2].estaOcupada());
        Assert.assertTrue(_mapa[(ancho/2) + 1][(alto/2)].estaOcupada());
    }


    //pruebasParaEnunciado.
    @Test
    public void test08SeCreaJuegoYContieneMadera(){

        int alto = 45;
        int ancho = 81;

        Juego juego = Juego.crearUnico();
        juego.inicializar();
        Mapa mapa = juego.getMapa();
        Posicion[][] _mapa = mapa.getMapa();

        boolean contiene = false;

        for(int i = 0; i < ancho; i++){
            for(int j = 0; j < alto; j++){
                if((_mapa[i][j]).getOcupante() instanceof Madera){
                    contiene = true;
                }
            }
        }

        Assert.assertTrue(contiene);
    }

    @Test
    public void test09SeCreaJuegoYContienePiedra(){

        int alto = 45;
        int ancho = 81;

        Juego juego = Juego.crearUnico();
        juego.inicializar();
        Mapa mapa = juego.getMapa();
        Posicion[][] _mapa = mapa.getMapa();

        boolean contiene = false;

        for(int i = 0; i < ancho; i++){
            for(int j = 0; j < alto; j++){
                if((_mapa[i][j]).getOcupante() instanceof Piedra){
                    contiene = true;
                }
            }
        }

        Assert.assertTrue(contiene);
    }

    @Test
    public void test10SeCreaJuegoYContieneDiamante(){

        int alto = 45;
        int ancho = 81;

        Juego juego = Juego.crearUnico();
        juego.inicializar();
        Mapa mapa = juego.getMapa();
        Posicion[][] _mapa = mapa.getMapa();

        boolean contiene = false;

        for(int i = 0; i < ancho; i++){
            for(int j = 0; j < alto; j++){
                if((_mapa[i][j]).getOcupante() instanceof Diamante){
                    contiene = true;
                }
            }
        }

        Assert.assertTrue(contiene);
    }

    @Test
    public void test11SeCreaJuegoYContieneMetal(){

        int alto = 45;
        int ancho = 81;

        Juego juego = Juego.crearUnico();
        juego.inicializar();
        Mapa mapa = juego.getMapa();
        Posicion[][] _mapa = mapa.getMapa();

        boolean contiene = false;

        for(int i = 0; i < ancho; i++){
            for(int j = 0; j < alto; j++){
                if((_mapa[i][j]).getOcupante() instanceof Metal){
                    contiene = true;
                }
            }
        }

        Assert.assertTrue(contiene);
    }


}
