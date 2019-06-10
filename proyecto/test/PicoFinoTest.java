import org.junit.Test;

import static org.junit.Assert.*;

public class PicoFinoTest {

    @Test
    public void test01PicoFinoSeCreaCon1000DeDurabilidad() {
        Herramienta pico = new PicoFino();
        assertEquals(1000, pico.getDurabilidad());
    }

    @Test
    public void test02PicoFinoSeCreaCon20DeFuerza() {
        Herramienta pico = new PicoFino();
        assertEquals(20, pico.getFuerza());
    }


    @Test
    public void test03PicoFinoSeUsaContraDiamanteYPierde100DeDurabilidad(){

        Herramienta pico = new PicoFino();
        Material diamante = new Diamante();
        pico.golpear(diamante);

        assertEquals(900, pico.getDurabilidad());

    }

    @Test
    public void test04SeUsaPicoFinoContraMaderaYDurabilidadNoSeVeAfectada(){

        Herramienta pico = new PicoFino();
        Material madera = new Madera();
        pico.golpear(madera);

        assertEquals(1000, pico.getDurabilidad());

    }

    @Test
    public void test05SeUsaPicoFinoContraPiedraYDurabilidadNoSeVeAfectada(){

        Herramienta pico = new PicoFino();
        Material piedra = new Piedra();
        pico.golpear(piedra);

        assertEquals(1000, pico.getDurabilidad());

    }

    @Test
    public void test06SeUsaPicoFinoContraMetalYDurabilidadNoSeVeAfectada(){

        Herramienta pico = new PicoFino();
        Material metal = new Metal();
        pico.golpear(metal);

        assertEquals(1000, pico.getDurabilidad());

    }


}