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
    public void test06MapaSeInicializaSinErrores(){
        Mapa mapa = Mapa.instanciar(ancho, alto);
        mapa = mapa.limpiar(ancho, alto);
        mapa.inicializar();

        Assert.assertTrue(true);
    }

    @Test
    public void test07MapaTieneAlmenos1Madera(){

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
    public void test08MapaTieneAlmenos1Metal(){

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
    public void test09MapaTieneAlmenos1Piedra(){

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
    public void test10MapaTieneAlmenos1Diamante(){

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
}
