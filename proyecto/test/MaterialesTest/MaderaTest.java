package MaterialesTest;

import Modelo.Herramientas.*;
import Modelo.MateriaPrima.Antimateria;
import Modelo.MateriaPrima.MateriaPrimaMadera;
import Modelo.Materiales.Madera;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaderaTest {

    @Test
    public void test01MaderaSeCreaCon10DeDurabilidad(){
        Madera madera = new Madera();
        assertEquals(10, madera.getDurabilidad());
    }

    @Test
    public void test02MaderaSeGolpeaConHachaDeMaderaYSeReduceEn2LaDurabilidad(){

        Madera madera = new Madera();
        HachaDeMadera hacha = new HachaDeMadera();
        madera.gastarCon(hacha);

        assertEquals(8, madera.getDurabilidad());
    }

    @Test
    public void test03MaderaSeGolpeaConHachaDePiedraYSeReduceEn5LaDurabilidad(){

        Madera madera = new Madera();
        HachaDePiedra hacha = new HachaDePiedra();
        madera.gastarCon(hacha);

        assertEquals(5, madera.getDurabilidad());
    }

    @Test
    public void test04MaderaSeGolpeaConHachaDeMetalYSeReduceEn10LaDurabilidad(){

        Madera madera = new Madera();
        HachaDeMetal hacha = new HachaDeMetal();
        madera.gastarCon(hacha);

        assertEquals(0, madera.getDurabilidad());
    }

    @Test
    public void test05MaderaSeGolpeaConPicoDeMaderaYNoSeReduceLaDurabilidad() {

        Madera madera = new Madera();
        PicoDeMadera pico = new PicoDeMadera();
        madera.gastarCon(pico);

        assertEquals(10, madera.getDurabilidad());
    }

    @Test
    public void test06MaderaSeGolpeaConPicoDePiedraYNoSeReduceLaDurabilidad(){

        Madera madera = new Madera();
        PicoDePiedra pico = new PicoDePiedra();
        madera.gastarCon(pico);

        assertEquals(10, madera.getDurabilidad());
    }

    @Test
    public void test07MaderaSeGolpeaConPicoDeMetalYNoSeReduceLaDurabilidad(){

        Madera madera = new Madera();
        PicoDeMetal pico = new PicoDeMetal();
        madera.gastarCon(pico);

        assertEquals(10, madera.getDurabilidad());
    }

    @Test
    public void test08MaderaSeGolpeaConPicoFinoYNoSeReduceLaDurabilidad(){

        Madera madera = new Madera();
        PicoFino pico = new PicoFino();
        madera.gastarCon(pico);

        assertEquals(10, madera.getDurabilidad());
    }

    @Test
    public void test09MaderaDevuelveAntimateriaSiNoSeRompe(){
        Madera madera = new Madera();
        PicoFino pico = new PicoFino();

        assertTrue(madera.gastarCon(pico) instanceof Antimateria);
        assertNotEquals(madera.getDurabilidad(), 0);
    }

    @Test
    public void test10MaderaAlRomperseDevuelveMateriaPrimaMadera() {

        Madera madera = new Madera();
        HachaDeMadera hacha = new HachaDeMadera();

        for(int i = 0; i < 4; i++) {
            madera.gastarCon(hacha);
        }

        assertEquals(2, madera.getDurabilidad());

        assertTrue(madera.gastarCon(hacha) instanceof MateriaPrimaMadera);
    }
}
