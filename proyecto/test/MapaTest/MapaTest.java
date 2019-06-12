package MapaTest;

import Algocraft.PaqueteProvisorio.Mapa;
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
        Assert.assertEquals(50, mapa.getAncho());
    }

    @Test
    public void test02MapaNoPuedeInstanciarse2Veces(){
        Mapa mapa1 = Mapa.instanciar(1, 1);
        Mapa mapa2 = Mapa.instanciar(1, 1);

        Assert.assertEquals(mapa1, mapa2);
    }

    @Test
    public void test03MapaInicializaAlJugadorEnElCentroDelMapa(){

    }
}
