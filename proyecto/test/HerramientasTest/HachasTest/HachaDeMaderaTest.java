package HerramientasTest.HachasTest;

import Algocraft.Herramientas.HachaDeMadera;
import Algocraft.Herramientas.Herramienta;
import Algocraft.Materiales.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class HachaDeMaderaTest {

    @Test
    public void test01HachaDeMaderaSeCreaCon100DeDurabilidad() {
        Herramienta hacha = new HachaDeMadera();
        assertEquals(100, hacha.getDurabilidad());
    }

    @Test
    public void test02HachaDeMaderaSeCreaCon2DeFuerza() {
        Herramienta hacha = new HachaDeMadera();
        assertEquals(2, hacha.getFuerza());
    }

    @Test
    public void test03SeUsaHachaDeMaderaContraMaderaYPierde2DeDurabilidad(){

        Herramienta hacha = new HachaDeMadera();
        Material madera = new Madera();
        hacha.golpear(madera);

        assertEquals(98, hacha.getDurabilidad());
    }

    @Test
    public void test04SeUsaHachaDeMaderaContraPiedraYPierde2DeDurabilidad(){

        Herramienta hacha = new HachaDeMadera();
        Material piedra = new Piedra();
        hacha.golpear(piedra);

        assertEquals(98, hacha.getDurabilidad());

    }

    @Test
    public void test05SeUsaHachaDeMaderaContraMetalYPierde2DeDurabilidad(){

        Herramienta hacha = new HachaDeMadera();
        Material metal = new Metal();
        hacha.golpear(metal);

        assertEquals(98, hacha.getDurabilidad());

    }

    @Test
    public void test06SeUsaHachaDeMaderaContraDiamanteYPierde2DeDurabilidad() {

        Herramienta hacha = new HachaDeMadera();
        Material diamante = new Diamante();
        hacha.golpear(diamante);

        assertEquals(98, hacha.getDurabilidad());

    }

}
