package HerramientasTest.PicosTest;

import Algocraft.Herramientas.Herramienta;
import Algocraft.Herramientas.PicoDeMadera;
import Algocraft.Materiales.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class PicoDeMaderaTest {
    @Test
    public void test01PicoDeMaderaSeCreaCon100DeDurabilidad() {
        Herramienta pico = new PicoDeMadera();
        assertEquals(100, pico.getDurabilidad());
    }

    @Test
    public void test02PicoDeMaderaSeCreaCon2DeFuerza() {
        Herramienta pico = new PicoDeMadera();
        assertEquals(2, pico.getFuerza());
    }

    @Test
    public void test03SeUsaPicoDeMaderaContraMaderaYPierde2DeDurabilidad(){

        Herramienta pico = new PicoDeMadera();
        Material madera = new Madera();
        pico.golpear(madera);

        assertEquals(98, pico.getDurabilidad());

    }

    @Test
    public void test04SeUsaPicoDeMaderaContraPiedraYPierde2DeDurabilidad(){

        Herramienta pico = new PicoDeMadera();
        Material piedra = new Piedra();
        pico.golpear(piedra);

        assertEquals(98, pico.getDurabilidad());

    }

    @Test
    public void test05SeUsaPicoDeMaderaContraMetalYPierde2DeDurabilidad(){

        Herramienta pico = new PicoDeMadera();
        Material metal = new Metal();
        pico.golpear(metal);

        assertEquals(98, pico.getDurabilidad());

    }

    @Test
    public void test06SeUsaPicoDeMaderaContraDiamanteYPierde2DeDurabilidad(){

        Herramienta pico = new PicoDeMadera();
        Material diamante = new Diamante();
        pico.golpear(diamante);

        assertEquals(98, pico.getDurabilidad());

    }


}
