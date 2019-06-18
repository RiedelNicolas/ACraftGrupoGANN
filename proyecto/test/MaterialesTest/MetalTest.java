package MaterialesTest;

import Modelo.Herramientas.*;
import Modelo.MateriaPrima.Antimateria;
import Modelo.MateriaPrima.MateriaPrimaMetal;
import Modelo.Materiales.Metal;
import org.junit.Test;

import static org.junit.Assert.*;

public class MetalTest {

    @Test
    public void test01MetalSeCreaCon50DeDurabilidad(){
        Metal metal = new Metal();
        assertEquals(50, metal.getDurabilidad());
    }

    @Test
    public void test02MetalSeGolpeaConHachaDeMaderaYNoSeReduceLaDurabilidad(){

        Metal metal = new Metal();
        HachaDeMadera hacha = new HachaDeMadera();
        metal.gastarCon(hacha);

        assertEquals(50, metal.getDurabilidad());
    }

    @Test
    public void test03MetalSeGolpeaConHachaDePiedraYNoSeReduceLaDurabilidad(){

        Metal metal = new Metal();
        HachaDePiedra hacha = new HachaDePiedra();
        metal.gastarCon(hacha);

        assertEquals(50, metal.getDurabilidad());
    }

    @Test
    public void test04MetalSeGolpeaConHachaDeMetalYNoSeReduceLaDurabilidad(){

        Metal metal = new Metal();
        HachaDeMetal hacha = new HachaDeMetal();
        metal.gastarCon(hacha);

        assertEquals(50, metal.getDurabilidad());
    }

    @Test
    public void test05MetalSeGolpeaConPicoDeMaderaYNoSeReduceLaDurabilidad(){

        Metal metal = new Metal();
        PicoDeMadera pico = new PicoDeMadera();
        metal.gastarCon(pico);

        assertEquals(50, metal.getDurabilidad());
    }

    @Test
    public void test06MetalSeGolpeaConPicoDePiedraYSeReduceEn4LaDurabilidad(){

        Metal metal = new Metal();
        PicoDePiedra pico = new PicoDePiedra();
        metal.gastarCon(pico);

        assertEquals(46, metal.getDurabilidad());
    }

    @Test
    public void test07MetalSeGolpeaConPicoDeMetalYNoSeReduceLaDurabilidad(){

        Metal metal = new Metal();
        PicoDeMetal pico = new PicoDeMetal();
        metal.gastarCon(pico);

        assertEquals(50, metal.getDurabilidad());
    }

    @Test
    public void test08MetalSeGolpeaConPicoFinoYNoSeReduceLaDurabilidad(){

        Metal metal = new Metal();
        PicoFino pico = new PicoFino();
        metal.gastarCon(pico);

        assertEquals(50, metal.getDurabilidad());
    }

    @Test
    public void test09MetalDevuelveAntimateriaSiNoSeRompe(){
        Metal metal  = new Metal();
        PicoFino pico = new PicoFino();

        assertTrue(metal.gastarCon(pico) instanceof Antimateria);
        assertNotEquals(metal.getDurabilidad(), 0);
    }

    @Test
    public void test10MaderaAlRomperseDevuelveMateriaPrimaMetal() {

        Metal metal = new Metal();
        PicoDePiedra pico = new PicoDePiedra();

        for(int i = 0; i < 12; i++) {
            metal.gastarCon(pico);
        }

        assertEquals(2, metal.getDurabilidad());

        assertTrue(metal.gastarCon(pico) instanceof MateriaPrimaMetal);
    }
}
