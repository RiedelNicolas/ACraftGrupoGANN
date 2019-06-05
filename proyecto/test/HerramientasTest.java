import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class HerramientasTest {

    @Test
    public void test01PicoDeMaderaSeCreaCon100DeDurabilidad(){
        Herramienta pico = new PicoDeMadera();
        assertEquals(100, pico.getDurabilidad());
    }

    @Test
    public void test02PicoDeMaderaSeCreaCon2DeFuerza(){
        Herramienta pico = new PicoDeMadera();
        assertEquals(2, pico.getFuerza());
    }

    @Test
    public void test03PicoDePiedraSeCreaCon200DeDurabilidad(){
        Herramienta pico = new PicoDePiedra();
        assertEquals(200, pico.getDurabilidad());
    }

    @Test
    public void test04PicoDePiedraSeCreaCon4DeFuerza(){
        Herramienta pico = new PicoDePiedra();
        assertEquals(4, pico.getFuerza());
    }

    @Test
    public void test05PicoDeMetalSeCreaCon400DeDurabilidad(){
        Herramienta pico = new PicoDeMetal();
        assertEquals(400, pico.getDurabilidad());
    }

    @Test
    public void test06PicoDeMetalSeCreaCon12DeFuerza(){
        Herramienta pico = new PicoDeMetal();
        assertEquals(12, pico.getFuerza());
    }

    @Test
    public void test07PicoFinoSeCreaCon1000DeDurabilidad(){
        Herramienta pico = new PicoFino();
        assertEquals(1000, pico.getDurabilidad());
    }

    @Test
    public void test08PicoFinoSeCreaCon20DeFuerza(){
        Herramienta pico = new PicoFino();
        assertEquals(20, pico.getFuerza());
    }

    @Test
    public void test09HachaDeMaderaSeCreaCon100DeDurabilidad(){
        Herramienta hacha = new HachaDeMadera();
        assertEquals(100, hacha.getDurabilidad());
    }

    @Test
    public void test10HachaDeMaderaSeCreaCon2DeFuerza(){
        Herramienta hacha = new HachaDeMadera();
        assertEquals(2, hacha.getFuerza());
    }

    @Test
    public void test11HachaDeMaderaSeCreaCon200DeDurabilidad(){
        Herramienta hacha = new HachaDePiedra();
        assertEquals(200, hacha.getDurabilidad());
    }

    @Test
    public void test12HachaDePiedraSeCreaCon5DeFuerza(){
        Herramienta hacha = new HachaDePiedra();
        assertEquals(5, hacha.getFuerza());
    }

    @Test
    public void test13HachaDeMetalSeCreaCon400DeDurabilidad(){
        Herramienta hacha = new HachaDeMetal();
        assertEquals(400, hacha.getDurabilidad());
    }

    @Test
    public void test14HachaDeMetalSeCreaCon10DeFuerza(){
        Herramienta hacha = new HachaDeMadera();
        assertEquals(2, hacha.getFuerza());
    }
}
