package MaterialesTest;

import Algocraft.Herramientas.*;
import Algocraft.MateriaPrima.Antimateria;
import Algocraft.MateriaPrima.MateriaPrimaPiedra;
import Algocraft.Materiales.Piedra;
import org.junit.Test;

import static org.junit.Assert.*;

public class PiedraTest {

    @Test
    public void test01PiedraSeCreaCon30DeDurabilidad(){
        Piedra piedra = new Piedra();
        assertEquals(30, piedra.getDurabilidad());
    }

    @Test
    public void test02PiedraSeGolpeaConHachaDeMaderaYNoSeReduceLaDurabilidad(){

        Piedra piedra = new Piedra();
        HachaDeMadera hacha = new HachaDeMadera();
        piedra.gastarCon(hacha);

        assertEquals(30, piedra.getDurabilidad());
    }

    @Test
    public void test03PiedraSeGolpeaConHachaDePiedraYNoSeReduceLaDurabilidad(){

        Piedra piedra = new Piedra();
        HachaDePiedra hacha = new HachaDePiedra();
        piedra.gastarCon(hacha);

        assertEquals(30, piedra.getDurabilidad());
    }

    @Test
    public void test04PiedraSeGolpeaConHachaDeMetalYNoSeReduceLaDurabilidad(){

        Piedra piedra = new Piedra();
        HachaDeMetal hacha = new HachaDeMetal();
        piedra.gastarCon(hacha);

        assertEquals(30, piedra.getDurabilidad());
    }

    @Test
    public void test05PiedraSeGolpeaConPicoDeMaderaYSeReduceEn2LaDurabilidad(){

        Piedra piedra = new Piedra();
        PicoDeMadera pico = new PicoDeMadera();
        piedra.gastarCon(pico);

        assertEquals(28, piedra.getDurabilidad());
    }

    @Test
    public void test06PiedraSeGolpeaConPicoDePiedraYSeReduceEn4LaDurabilidad(){

        Piedra piedra = new Piedra();
        PicoDePiedra pico = new PicoDePiedra();
        piedra.gastarCon(pico);

        assertEquals(26, piedra.getDurabilidad());
    }

    @Test
    public void test07PiedraSeGolpeaConPicoDeMetalYSeReduceEn12LaDurabilidad(){

        Piedra piedra = new Piedra();
        PicoDeMetal pico = new PicoDeMetal();
        piedra.gastarCon(pico);

        assertEquals(18, piedra.getDurabilidad());
    }

    @Test
    public void test08PiedraSeGolpeaConPicoFinoYSeReduceEn20LaDurabilidad(){

        Piedra piedra = new Piedra();
        PicoFino pico = new PicoFino();

        piedra.gastarCon(pico);

        assertEquals(10, piedra.getDurabilidad());
    }

    @Test
    public void test09PiedraDevuelveAntimateriaSiNoSeRompe(){
        Piedra metal  = new Piedra();
        PicoFino pico = new PicoFino();

        assertTrue(metal.gastarCon(pico) instanceof Antimateria);
        assertNotEquals(metal.getDurabilidad(), 0);
    }

    @Test
    public void test10PiedraAlRomperseDevuelveMateriaPrimaPiedra() {

        Piedra piedra = new Piedra();
        PicoDeMadera pico = new PicoDeMadera();

        for(int i = 0; i < 14; i++) {
            piedra.gastarCon(pico);
        }

        assertEquals(2, piedra.getDurabilidad());

        assertTrue(piedra.gastarCon(pico) instanceof MateriaPrimaPiedra);
    }

}
