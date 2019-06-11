package MaterialesTest;

import Algocraft.Excepciones.MaterialNoSeDanioException;
import Algocraft.Excepciones.MaterialRotoException;
import Algocraft.Herramientas.*;
import Algocraft.Materiales.Metal;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class MetalTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test01MetalSeCreaCon50DeDurabilidad(){
        Metal metal = new Metal();
        assertEquals(50, metal.getDurabilidad());
    }

    @Test
    public void test02MetalSeGolpeaConHachaDeMaderaYNoSeReduceLaDurabilidad(){

        Metal metal = new Metal();
        HachaDeMadera hacha = new HachaDeMadera();
        try {
            metal.gastarCon(hacha);
        } catch (MaterialNoSeDanioException e){}

        assertEquals(50, metal.getDurabilidad());
    }

    @Test
    public void test03MetalSeGolpeaConHachaDePiedraYNoSeReduceLaDurabilidad(){

        Metal metal = new Metal();
        HachaDePiedra hacha = new HachaDePiedra();
        try {
            metal.gastarCon(hacha);
        } catch (MaterialNoSeDanioException e){}

        assertEquals(50, metal.getDurabilidad());
    }

    @Test
    public void test04MetalSeGolpeaConHachaDeMetalYNoSeReduceLaDurabilidad(){

        Metal metal = new Metal();
        HachaDeMetal hacha = new HachaDeMetal();
        try {
            metal.gastarCon(hacha);
        } catch (MaterialNoSeDanioException e){}

        assertEquals(50, metal.getDurabilidad());
    }

    @Test
    public void test05MetalSeGolpeaConPicoDeMaderaYNoSeReduceLaDurabilidad(){

        Metal metal = new Metal();
        PicoDeMadera pico = new PicoDeMadera();
        try {
            metal.gastarCon(pico);
        } catch (MaterialNoSeDanioException e){}

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
        try {
            metal.gastarCon(pico);
        } catch (MaterialNoSeDanioException e){}

        assertEquals(50, metal.getDurabilidad());
    }

    @Test
    public void test08MetalSeGolpeaConPicoFinoYNoSeReduceLaDurabilidad(){

        Metal metal = new Metal();
        PicoFino pico = new PicoFino();
        try {
            metal.gastarCon(pico);
        } catch (MaterialNoSeDanioException e){}

        assertEquals(50, metal.getDurabilidad());
    }

    @Test
    public void test09MetalSeGolpeaConPicoDePiedraYSeRompe() {

        Metal metal = new Metal();
        PicoDePiedra pico = new PicoDePiedra();

        for (int i = 0; i < 12; i++) {
            metal.gastarCon(pico);
        }

        assertEquals(2, metal.getDurabilidad());

        thrown.expect(MaterialRotoException.class);
        metal.gastarCon(pico);
    }
}
