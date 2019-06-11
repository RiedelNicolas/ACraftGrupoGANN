package HerramientasTest;

import Algocraft.Herramientas.HachaDeMetal;
import Algocraft.Herramientas.Herramienta;
import Algocraft.Materiales.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class HachaDeMetalTest {

    @Test
    public void test01HachaDeMetalSeCreaCon400DeDurabilidad() {
        Herramienta hacha = new HachaDeMetal();
        assertEquals(400, hacha.getDurabilidad());
    }

    @Test
    public void test02HachaDeMetalSeCreaCon10DeFuerza() {
        Herramienta hacha = new HachaDeMetal();
        assertEquals(10, hacha.getFuerza());
    }


    @Test
    public void test23SeUsaHachaDeMetalContraMaderaYPierde5DeDurabilidad(){

        Herramienta hacha = new HachaDeMetal();
        Material madera = new Madera();
        hacha.golpear(madera);

        assertEquals(395, hacha.getDurabilidad());
    }

    @Test
    public void test24SeUsaHachaDeMetalContraPiedraYPierde5DeDurabilidad(){

        Herramienta hacha = new HachaDeMetal();
        Material piedra = new Piedra();
        hacha.golpear(piedra);

        assertEquals(395, hacha.getDurabilidad());

    }

    @Test
    public void test25SeUsaHachaDeMetalContraMetalYPierde5DeDurabilidad(){

        Herramienta hacha = new HachaDeMetal();
        Material metal = new Metal();
        hacha.golpear(metal);

        assertEquals(395, hacha.getDurabilidad());

    }

    @Test
    public void test26SeUsaHachaDeMetalContraDiamanteYPierde5DeDurabilidad(){

        Herramienta hacha = new HachaDeMetal();
        Material diamante = new Diamante();
        hacha.golpear(diamante);

        assertEquals(395, hacha.getDurabilidad());

    }

}
