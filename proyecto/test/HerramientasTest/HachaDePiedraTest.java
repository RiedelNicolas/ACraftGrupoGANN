package HerramientasTest;

import Algocraft.Herramientas.HachaDePiedra;
import Algocraft.Herramientas.Herramienta;
import Algocraft.Materiales.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class HachaDePiedraTest {

    @Test
    public void test01HachaDePiedraSeCreaCon200DeDurabilidad() {
        Herramienta hacha = new HachaDePiedra();
        assertEquals(200, hacha.getDurabilidad());
    }

    @Test
    public void test02HachaDePiedraSeCreaCon5DeFuerza() {
        Herramienta hacha = new HachaDePiedra();
        assertEquals(5, hacha.getFuerza());
    }

    @Test
    public void test03SeUsaHachaDePiedraContraMaderaYPierde5DeDurabilidad(){

        Herramienta hacha = new HachaDePiedra();
        Material madera = new Madera();
        hacha.golpear(madera);

        assertEquals(195, hacha.getDurabilidad());
    }

    @Test
    public void test04SeUsaHachaDePiedraContraPiedraYPierde5DeDurabilidad(){

        Herramienta hacha = new HachaDePiedra();
        Material piedra = new Piedra();
        hacha.golpear(piedra);

        assertEquals(195, hacha.getDurabilidad());

    }

    @Test
    public void test05SeUsaHachaDePiedraContraMetalYPierde5DeDurabilidad(){

        Herramienta hacha = new HachaDePiedra();
        Material metal = new Metal();
        hacha.golpear(metal);

        assertEquals(195, hacha.getDurabilidad());

    }

    @Test
    public void test06SeUsaHachaDePiedraContraDiamanteYPierde5DeDurabilidad() {

        Herramienta hacha = new HachaDePiedra();
        Material diamante = new Diamante();
        hacha.golpear(diamante);

        assertEquals(195, hacha.getDurabilidad());

    }


}
