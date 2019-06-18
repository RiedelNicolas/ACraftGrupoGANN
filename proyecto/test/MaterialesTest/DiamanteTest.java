package MaterialesTest;

import Algocraft.Herramientas.*;
import Algocraft.MateriaPrima.Antimateria;
import Algocraft.MateriaPrima.MateriaPrima;
import Algocraft.MateriaPrima.MateriaPrimaDiamante;
import Algocraft.Materiales.Diamante;
import org.junit.Test;

import static org.junit.Assert.*;

public class DiamanteTest {

    @Test
    public void test01DiamanteSeCreaCon100DeDurabilidad(){
        Diamante diamante = new Diamante();
        assertEquals(100, diamante.getDurabilidad());
    }

    @Test
    public void test02DiamanteSeGolpeaConHachaDeMaderaYNoSeReduceLaDurabilidad(){

        Diamante diamante = new Diamante();
        HachaDeMadera hacha = new HachaDeMadera();
        diamante.gastarCon(hacha);

        assertEquals(100, diamante.getDurabilidad());
    }

    @Test
    public void test03DiamanteSeGolpeaConHachaDePiedraYNoSeReduceLaDurabilidad(){

        Diamante diamante = new Diamante();
        HachaDePiedra hacha = new HachaDePiedra();
        diamante.gastarCon(hacha);

        assertEquals(100, diamante.getDurabilidad());
    }

    @Test
    public void test04DiamanteSeGolpeaConHachaDeMetalYNoSeReduceLaDurabilidad(){

        Diamante diamante = new Diamante();
        HachaDeMetal hacha = new HachaDeMetal();
        diamante.gastarCon(hacha);

        assertEquals(100, diamante.getDurabilidad());
    }

    @Test
    public void test05DiamanteSeGolpeaConPicoDeMaderaYNoSeReduceLaDurabilidad(){

        Diamante diamante = new Diamante();
        PicoDeMadera pico = new PicoDeMadera();
        diamante.gastarCon(pico);

        assertEquals(100, diamante.getDurabilidad());

    }

    @Test
    public void test06DiamanteSeGolpeaConPicoDePiedraYNoSeReduceLaDurabilidad(){

        Diamante diamante = new Diamante();
        PicoDePiedra pico = new PicoDePiedra();
        diamante.gastarCon(pico);

        assertEquals(100, diamante.getDurabilidad());

    }

    @Test
    public void test07DiamanteSeGolpeaConPicoDeMetalYNoSeReduceLaDurabilidad(){

        Diamante diamante = new Diamante();
        PicoDeMetal pico = new PicoDeMetal();
        diamante.gastarCon(pico);

        assertEquals(100, diamante.getDurabilidad());

    }

    @Test
    public void test08DiamanteSeGolpeaConPicoFinoYSeReduceEn20LaDurabilidad(){

        Diamante diamante = new Diamante();
        PicoFino pico = new PicoFino();
        diamante.gastarCon(pico);

        assertEquals(80, diamante.getDurabilidad());
    }

    @Test
    public void test09DiamanteDevuelveAntimateriaSiNoSeRompe(){
        Diamante diamante = new Diamante();
        PicoFino pico = new PicoFino();

        assertTrue(diamante.gastarCon(pico) instanceof Antimateria);
        assertNotEquals(diamante.getDurabilidad(), 0);
    }

    @Test
    public void test10DiamanteAlRomperseDevuelveMateriaPrimaDiamante() {

        Diamante diamante = new Diamante();
        PicoFino pico = new PicoFino();

        for (int i = 0; i < 4; i++) {
            diamante.gastarCon(pico);
        }

        assertEquals(20, diamante.getDurabilidad());

        assertTrue(diamante.gastarCon(pico) instanceof MateriaPrimaDiamante);
    }
}
