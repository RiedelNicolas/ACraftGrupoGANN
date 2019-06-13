package HerramientasTest.PicosTest;

import Algocraft.Excepciones.HerramientaRotaException;
import Algocraft.Herramientas.Herramienta;
import Algocraft.Herramientas.PicoDeMetal;
import Algocraft.Materiales.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class PicoDeMetalTest {


    @Test
    public void test01PicoDeMetalSeCreaCon400DeDurabilidad() {
        Herramienta pico = new PicoDeMetal();
        assertEquals(400, pico.getDurabilidad());
    }

    @Test
    public void test02PicoDeMetalSeCreaCon12DeFuerza() {
        Herramienta pico = new PicoDeMetal();
        assertEquals(12, pico.getFuerza());
    }

    @Test
    public void test03SeUsaPicoDeMetalContraMaderaYDurabilidadNoSeVeAfectadaTrasUnUso(){

        Herramienta pico = new PicoDeMetal();
        Material madera = new Madera();
        pico.golpear(madera);

        assertEquals(400, pico.getDurabilidad());

    }

    @Test
    public void test04SeUsaPicoDeMetalContraPiedraYDurabilidadNoSeVeAfectadaTrasUnUso(){

        Herramienta pico = new PicoDeMetal();
        Material piedra = new Piedra();
        pico.golpear(piedra);

        assertEquals(400, pico.getDurabilidad());

    }

    @Test
    public void test05SeUsaPicoDeMetalContraMetalYDurabilidadNoSeVeAfectadaTrasUnUso(){

        Herramienta pico = new PicoDeMetal();
        Material metal = new Metal();
        pico.golpear(metal);

        assertEquals(400, pico.getDurabilidad());

    }

    @Test
    public void test06SeUsaPicoDeMetalContraDiamanteYDurabilidadNoSeVeAfectadaTrasUnUso(){

        Herramienta pico = new PicoDeMetal();
        Material diamante = new Diamante();
        pico.golpear(diamante);

        assertEquals(400, pico.getDurabilidad());

    }

    @Test
    public void test07PicoDeMetalSeQuedaSinDurabilidadAlDecimoUsoContraMadera(){

        Herramienta pico = new PicoDeMetal();
        Madera madera = new Madera();

        for(int i=0; i<10; i++){
            pico.golpear(madera);
        }

        assertEquals(0, pico.getDurabilidad());
    }

    @Test
    public void test08PicoDeMetalSeGastaContraPiedra(){

        Herramienta pico = new PicoDeMetal();
        Material piedra = new Piedra();

        for(int i = 0; i < 2; i++) {
            pico.golpear(piedra);
        }
        assertEquals(400, pico.getDurabilidad());
    }

    @Test
    public void test09PicoDeMetalSeQuedaSinDurabilidadAlDecimoUsoContraMetal(){

        Herramienta pico = new PicoDeMetal();
        Material metal = new Metal();

        for(int i = 0; i < 10; i++){
            pico.golpear(metal);
        }

        assertEquals(0, pico.getDurabilidad());

    }

    @Test
    public void test10PicoDeMetalSeQuedaSinDurabilidadAlDecimoUsoContraDiamante(){

        Herramienta pico = new PicoDeMetal();
        Material diamante = new Diamante();

        for(int i = 0; i < 10; i++){
            pico.golpear(diamante);
        }

        assertEquals(0, pico.getDurabilidad());

    }

    @Test
    public void test11NoSePuedeUsarPicoDeMetalMasDe10Veces() {

        Herramienta pico = new PicoDeMetal();
        Diamante diamante = new Diamante();
        boolean herramientaRota = false;

        for (int i = 0; i < 10; i++) {
            pico.golpear(diamante);
        }

        try {
            pico.golpear(diamante);
        } catch (HerramientaRotaException e) {
            herramientaRota = true;
        }

        assertTrue(herramientaRota);
    }

}


