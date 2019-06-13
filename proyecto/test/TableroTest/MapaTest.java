package TableroTest;

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
    public void test03MapaInicializaAlJugadorEnElCentroDelMapa(){

    }
}
