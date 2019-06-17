package HerramientasTest.HachasTest;

import Algocraft.Excepciones.MaterialRotoException;
import Algocraft.Herramientas.HachaDeMetal;
import Algocraft.Herramientas.Herramienta;
import Algocraft.Materiales.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class HachaDeMetalTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

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
    public void test03SeUsaHachaDeMetalContraMaderaYPierde5DeDurabilidad(){

        Herramienta hacha = new HachaDeMetal();
        Material madera = new Madera();

        thrown.expect(MaterialRotoException.class);
        hacha.usarContra(madera);

    }

    @Test
    public void test04SeUsaHachaDeMetalContraPiedraYPierde5DeDurabilidad(){

        Herramienta hacha = new HachaDeMetal();
        Material piedra = new Piedra();
        hacha.usarContra(piedra);

        assertEquals(395, hacha.getDurabilidad());

    }

    @Test
    public void test05SeUsaHachaDeMetalContraMetalYPierde5DeDurabilidad(){

        Herramienta hacha = new HachaDeMetal();
        Material metal = new Metal();
        hacha.usarContra(metal);

        assertEquals(395, hacha.getDurabilidad());

    }

    @Test
    public void test06SeUsaHachaDeMetalContraDiamanteYPierde5DeDurabilidad(){

        Herramienta hacha = new HachaDeMetal();
        Material diamante = new Diamante();
        hacha.usarContra(diamante);

        assertEquals(395, hacha.getDurabilidad());


    }

}
