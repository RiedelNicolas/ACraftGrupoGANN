import org.junit.*;

import static org.junit.Assert.assertEquals;

public class MaterialesTest {

    @Test
    public void test01MaderaSeCreaCon10DeDurabilidad(){
        Madera madera = new Madera();
        assertEquals(10, madera.getDurabilidad());
    }

    @Test
    public void test02PiedraSeCreaCon30DeDurabilidad(){
        Piedra piedra = new Piedra();
        assertEquals(30, piedra.getDurabilidad());
    }

    @Test
    public void test03MetalSeCreaCon50DeDurabilidad(){
        Metal metal = new Metal();
        assertEquals(50, metal.getDurabilidad());
    }

    @Test
    public void test04DiamanteSeCreaCon100DeDurabilidad(){
        Diamante diamante = new Diamante();
        assertEquals(100, diamante.getDurabilidad());
    }

    @Test
    public void test05MaderaSeGolpeaConHachaDeMaderaYSeReduceEn2LaDurabilidad(){

        Madera madera = new Madera();
        HachaDeMadera hacha = new HachaDeMadera();
        madera.gastarCon(hacha);

        assertEquals(8, madera.getDurabilidad());
    }

    @Test
    public void test06MaderaSeGolpeaConHachaDePiedraYSeReduceEn5LaDurabilidad(){

        Madera madera = new Madera();
        HachaDePiedra hacha = new HachaDePiedra();
        madera.gastarCon(hacha);

        assertEquals(5, madera.getDurabilidad());
    }

    @Test
    public void test07MaderaSeGolpeaConHachaDeMetalYSeRompe(){

        Madera madera = new Madera();
        HachaDeMetal hacha = new HachaDeMetal();
        madera.gastarCon(hacha);

        assertEquals(0, madera.getDurabilidad());
    }

    @Test
    public void test08MaderaSeGolpeaConPicoDeMaderaYNoSeReduceLaDurabilidad() {

        Madera madera = new Madera();
        PicoDeMadera pico = new PicoDeMadera();
        madera.gastarCon(pico);

        assertEquals(10, madera.getDurabilidad());
    }

    @Test
    public void test09MaderaSeGolpeaConPicoDePiedraYNoSeReduceLaDurabilidad(){

        Madera madera = new Madera();
        PicoDePiedra pico = new PicoDePiedra();
        madera.gastarCon(pico);

        assertEquals(10, madera.getDurabilidad());
    }

    @Test
    public void test10MaderaSeGolpeaConPicoDeMetalYNoSeReduceLaDurabilidad(){

        Madera madera = new Madera();
        PicoDeMetal pico = new PicoDeMetal();
        madera.gastarCon(pico);

        assertEquals(10, madera.getDurabilidad());
    }

    @Test
    public void test11MaderaSeGolpeaConPicoFinoYNoSeReduceLaDurabilidad(){

        Madera madera = new Madera();
        PicoFino pico = new PicoFino();
        madera.gastarCon(pico);

        assertEquals(10, madera.getDurabilidad());
    }

    @Test
    public void test12PiedraSeGolpeaConHachaDeMaderaYNoSeReduceLaDurabilidad(){

        Piedra piedra = new Piedra();
        HachaDeMadera hacha = new HachaDeMadera();
        piedra.gastarCon(hacha);

        assertEquals(30, piedra.getDurabilidad());
    }

    @Test
    public void test13PiedraSeGolpeaConHachaDePiedraYNoSeReduceLaDurabilidad(){

        Piedra piedra = new Piedra();
        HachaDePiedra hacha = new HachaDePiedra();
        piedra.gastarCon(hacha);

        assertEquals(30, piedra.getDurabilidad());
    }

    @Test
    public void test14PiedraSeGolpeaConHachaDeMetalYNoSeReduceLaDurabilidad(){

        Piedra piedra = new Piedra();
        HachaDeMetal hacha = new HachaDeMetal();
        piedra.gastarCon(hacha);

        assertEquals(30, piedra.getDurabilidad());
    }

    @Test
    public void test15PiedraSeGolpeaConPicoDeMaderaYSeReduceEn2LaDurabilidad(){

        Piedra piedra = new Piedra();
        PicoDeMadera pico = new PicoDeMadera();
        piedra.gastarCon(pico);

        assertEquals(28, piedra.getDurabilidad());
    }

    @Test
    public void test16PiedraSeGolpeaConPicoDePiedraYSeReduceEn4LaDurabilidad(){

        Piedra piedra = new Piedra();
        PicoDePiedra pico = new PicoDePiedra();
        piedra.gastarCon(pico);

        assertEquals(26, piedra.getDurabilidad());
    }

    @Test
    public void test17PiedraSeGolpeaConPicoDeMetalYNoSeReduceEn12LaDurabilidad(){

        Piedra piedra = new Piedra();
        PicoDeMetal pico = new PicoDeMetal();
        piedra.gastarCon(pico);

        assertEquals(18, piedra.getDurabilidad());
    }

    @Test
    public void test18PiedraSeGolpeaConPicoFinoYNoSeReduceEn20LaDurabilidad(){

        Piedra piedra = new Piedra();
        PicoFino pico = new PicoFino();
        piedra.gastarCon(pico);

        assertEquals(10, piedra.getDurabilidad());
    }

    @Test
    public void test19MetalSeGolpeaConHachaDeMaderaYNoSeReduceLaDurabilidad(){

        Metal metal = new Metal();
        HachaDeMadera hacha = new HachaDeMadera();
        metal.gastarCon(hacha);

        assertEquals(50, metal.getDurabilidad());
    }

    @Test
    public void test20MetalSeGolpeaConHachaDePiedraYNoSeReduceLaDurabilidad(){

        Metal metal = new Metal();
        HachaDePiedra hacha = new HachaDePiedra();
        metal.gastarCon(hacha);

        assertEquals(50, metal.getDurabilidad());
    }

    @Test
    public void test21MetalSeGolpeaConHachaDeMetalYNoSeReduceLaDurabilidad(){

        Metal metal = new Metal();
        HachaDeMetal hacha = new HachaDeMetal();
        metal.gastarCon(hacha);

        assertEquals(50, metal.getDurabilidad());
    }

    @Test
    public void test22MetalSeGolpeaConPicoDeMaderaYNoSeReduceLaDurabilidad(){

        Metal metal = new Metal();
        PicoDeMadera pico = new PicoDeMadera();
        metal.gastarCon(pico);

        assertEquals(50, metal.getDurabilidad());
    }

    @Test
    public void test23MetalSeGolpeaConPicoDePiedraYSeReduceEn4LaDurabilidad(){

        Metal metal = new Metal();
        PicoDePiedra pico = new PicoDePiedra();
        metal.gastarCon(pico);

        assertEquals(46, metal.getDurabilidad());
    }

    @Test
    public void test24MetalSeGolpeaConPicoDeMetalYNoSeReduceLaDurabilidad(){

        Metal metal = new Metal();
        PicoDeMetal pico = new PicoDeMetal();
        metal.gastarCon(pico);

        assertEquals(50, metal.getDurabilidad());
    }

    @Test
    public void test25MetalSeGolpeaConPicoFinoYNoSeReduceLaDurabilidad(){

        Metal metal = new Metal();
        PicoFino pico = new PicoFino();
        metal.gastarCon(pico);

        assertEquals(50, metal.getDurabilidad());
    }

    @Test
    public void test26DiamanteSeGolpeaConHachaDeMaderaYNoSeReduceLaDurabilidad(){

        Diamante diamante = new Diamante();
        HachaDeMadera hacha = new HachaDeMadera();
        diamante.gastarCon(hacha);

        assertEquals(100, diamante.getDurabilidad());
    }

    @Test
    public void test27DiamanteSeGolpeaConHachaDePiedraYNoSeReduceLaDurabilidad(){

        Diamante diamante = new Diamante();
        HachaDePiedra hacha = new HachaDePiedra();
        diamante.gastarCon(hacha);

        assertEquals(100, diamante.getDurabilidad());
    }

    @Test
    public void test28DiamanteSeGolpeaConHachaDeMetalYNoSeReduceLaDurabilidad(){

        Diamante diamante = new Diamante();
        HachaDeMetal hacha = new HachaDeMetal();
        diamante.gastarCon(hacha);

        assertEquals(100, diamante.getDurabilidad());
    }

    @Test
    public void test29DiamanteSeGolpeaConPicoDeMaderaYNoSeReduceLaDurabilidad(){

        Diamante diamante = new Diamante();
        PicoDeMadera pico = new PicoDeMadera();
        diamante.gastarCon(pico);

        assertEquals(100, diamante.getDurabilidad());

    }

    @Test
    public void test30DiamanteSeGolpeaConPicoDePiedraYNoSeReduceLaDurabilidad(){

        Diamante diamante = new Diamante();
        PicoDePiedra pico = new PicoDePiedra();
        diamante.gastarCon(pico);

        assertEquals(100, diamante.getDurabilidad());

    }

    @Test
    public void test31DiamanteSeGolpeaConPicoDeMetalYNoSeReduceLaDurabilidad(){

        Diamante diamante = new Diamante();
        PicoDeMetal pico = new PicoDeMetal();
        diamante.gastarCon(pico);

        assertEquals(100, diamante.getDurabilidad());

    }

    @Test
    public void test32DiamanteSeGolpeaConPicoFinoYSeReduceEn20LaDurabilidad(){

        Diamante diamante = new Diamante();
        PicoFino pico = new PicoFino();
        diamante.gastarCon(pico);

        assertEquals(80, diamante.getDurabilidad());
    }
}