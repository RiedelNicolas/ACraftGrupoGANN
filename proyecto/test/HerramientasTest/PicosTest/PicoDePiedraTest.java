package HerramientasTest.PicosTest;

import Algocraft.Excepciones.HerramientaRotaException;
import Algocraft.Herramientas.PicoDePiedra;
import Algocraft.Materiales.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class PicoDePiedraTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test01PicoDePiedraSeCreaCon200DeDurabilidad() {
        PicoDePiedra pico = new PicoDePiedra();
        assertEquals(200, pico.getDurabilidad());
    }

    @Test
    public void test02PicoDePiedraSeCreaCon4DeFuerza() {
        PicoDePiedra pico = new PicoDePiedra();
        assertEquals(4, pico.getFuerza());
    }

    @Test
    public void test03SeUsaPicoDePiedraContraMaderaYPierde3DeDurabilidad(){

        PicoDePiedra pico = new PicoDePiedra();
        Material madera = new Madera();
        pico.usarContra(madera);

        assertEquals(197, pico.getDurabilidad());

    }

    @Test
    public void test04SeUsaPicoDePiedraContraPiedraYPierde3DeDurabilidad(){

        PicoDePiedra pico = new PicoDePiedra();
        Material piedra = new Piedra();
        pico.usarContra(piedra);

        assertEquals(197, pico.getDurabilidad());

    }

    @Test
    public void test05SeUsaPicoDePiedraContraMetalYPierde3DeDurabilidad(){

        PicoDePiedra pico = new PicoDePiedra();
        Material metal = new Metal();
        pico.usarContra(metal);

        assertEquals(197, pico.getDurabilidad());

    }

    @Test
    public void test06SeUsaPicoDePiedraContraDiamanteYPierde3DeDurabilidad(){
        PicoDePiedra pico = new PicoDePiedra();
        Material diamante = new Diamante();
        pico.usarContra(diamante);

        assertEquals(197, pico.getDurabilidad());

    }

    @Test
    public void test07PicoDePiedraCon0DeDurabilidadNoSeRompe(){
        PicoDePiedra pico = new PicoDePiedra();
        Material diamante = new Diamante();

        for(int i = 0; i < 67; i++){
            pico.usarContra(diamante);
        }

        assertEquals(pico.getDurabilidad(), 0);

    }

    @Test
    public void test08PicoDePiedraConMenosDe0DurabilidadSeRompe(){
        PicoDePiedra pico = new PicoDePiedra();
        Material diamante = new Diamante();

        for(int i = 0; i < 67; i++){
            pico.usarContra(diamante);
        }

        thrown.expect(HerramientaRotaException.class);
        pico.usarContra(diamante);

    }

}
