package HerramientasTest.PicosTest;

import Algocraft.Excepciones.HerramientaRotaException;
import Algocraft.Herramientas.PicoDeMadera;
import Algocraft.Materiales.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class PicoDeMaderaTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test01PicoDeMaderaSeCreaCon100DeDurabilidad() {
        PicoDeMadera pico = new PicoDeMadera();
        assertEquals(100, pico.getDurabilidad());
    }

    @Test
    public void test02PicoDeMaderaSeCreaCon2DeFuerza() {
        PicoDeMadera pico = new PicoDeMadera();
        assertEquals(2, pico.getFuerza());
    }

    @Test
    public void test03SeUsaPicoDeMaderaContraMaderaYPierde2DeDurabilidad(){

        PicoDeMadera pico = new PicoDeMadera();
        Material madera = new Madera();
        pico.usarContra(madera);

        assertEquals(98, pico.getDurabilidad());

    }

    @Test
    public void test04SeUsaPicoDeMaderaContraPiedraYPierde2DeDurabilidad(){

        PicoDeMadera pico = new PicoDeMadera();
        Material piedra = new Piedra();
        pico.usarContra(piedra);

        assertEquals(98, pico.getDurabilidad());

    }

    @Test
    public void test05SeUsaPicoDeMaderaContraMetalYPierde2DeDurabilidad(){

        PicoDeMadera pico = new PicoDeMadera();
        Material metal = new Metal();
        pico.usarContra(metal);

        assertEquals(98, pico.getDurabilidad());

    }

    @Test
    public void test06SeUsaPicoDeMaderaContraDiamanteYPierde2DeDurabilidad(){

        PicoDeMadera pico = new PicoDeMadera();
        Material diamante = new Diamante();
        pico.usarContra(diamante);

        assertEquals(98, pico.getDurabilidad());

    }

    @Test
    public void test07PicoDeMaderaCon0DeDurabilidadNoSeRompe(){
        PicoDeMadera pico = new PicoDeMadera();
        Material diamante = new Diamante();

        for(int i = 0; i < 50; i++){
            pico.usarContra(diamante);
        }

        assertEquals(pico.getDurabilidad(), 0);

    }

    @Test
    public void test08PicoDeMaderaConMenosDe0DurabilidadSeRompe(){
        PicoDeMadera pico = new PicoDeMadera();
        Material diamante = new Diamante();

        for(int i = 0; i < 50; i++){
            pico.usarContra(diamante);
        }

        thrown.expect(HerramientaRotaException.class);
        pico.usarContra(diamante);

    }


}
