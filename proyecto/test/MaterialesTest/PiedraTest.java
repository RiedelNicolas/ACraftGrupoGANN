package MaterialesTest;

import Algocraft.Excepciones.MaterialNoSeDanioException;
import Algocraft.Excepciones.MaterialRotoException;
import Algocraft.Herramientas.*;
import Algocraft.Materiales.Piedra;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PiedraTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test01PiedraSeCreaCon30DeDurabilidad(){
        Piedra piedra = new Piedra();
        assertEquals(30, piedra.getDurabilidad());
    }

    @Test
    public void test02PiedraSeGolpeaConHachaDeMaderaYNoSeReduceLaDurabilidad(){

        Piedra piedra = new Piedra();
        HachaDeMadera hacha = new HachaDeMadera();
        try {
            piedra.gastarCon(hacha);
        } catch (MaterialNoSeDanioException e){}

        assertEquals(30, piedra.getDurabilidad());
    }

    @Test
    public void test03PiedraSeGolpeaConHachaDePiedraYNoSeReduceLaDurabilidad(){

        Piedra piedra = new Piedra();
        HachaDePiedra hacha = new HachaDePiedra();
        try {
            piedra.gastarCon(hacha);
        } catch (MaterialNoSeDanioException e){}

        assertEquals(30, piedra.getDurabilidad());
    }

    @Test
    public void test04PiedraSeGolpeaConHachaDeMetalYNoSeReduceLaDurabilidad(){

        Piedra piedra = new Piedra();
        HachaDeMetal hacha = new HachaDeMetal();
        try {
            piedra.gastarCon(hacha);
        } catch (MaterialNoSeDanioException e){}

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
    public void test08PiedraSeGolpeaConPicoDeMaderaYSeRompe() {

        Piedra piedra = new Piedra();
        PicoDeMadera pico = new PicoDeMadera();

        for(int i = 0; i < 15; i++) {
            piedra.gastarCon(pico);
        }

        assertEquals(0, piedra.getDurabilidad());
    }

    @Test
    public void test09PiedraSeGolpeaConPicoFinoYSeReduceEn20LaDurabilidad(){

        Piedra piedra = new Piedra();
        PicoFino pico = new PicoFino();

        piedra.gastarCon(pico);

        assertEquals(10, piedra.getDurabilidad());
    }

    @Test
    public void test10PiedraRotaNoPuedeSerGolpeada(){

        Piedra piedra = new Piedra();
        PicoDeMadera pico = new PicoDeMadera();

        for(int i = 0; i < 15; i++) {
            piedra.gastarCon(pico);
        }

        thrown.expect(MaterialRotoException.class);
        piedra.gastarCon(pico);
    }
}
