package HerramientasTest.PicosTest;

import Modelo.Excepciones.HerramientaRotaException;
import Modelo.Herramientas.PicoFino;
import Modelo.Materiales.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class PicoFinoTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test01PicoFinoSeCreaCon1000DeDurabilidad() {
        PicoFino pico = new PicoFino();
        assertEquals(1000, pico.getDurabilidad());
    }

    @Test
    public void test02PicoFinoSeCreaCon20DeFuerza() {
        PicoFino pico = new PicoFino();
        assertEquals(20, pico.getFuerza());
    }


    @Test
    public void test03PicoFinoSeUsaContraDiamanteYPierde100DeDurabilidad(){

        PicoFino pico = new PicoFino();
        Material diamante = new Diamante();

        pico.usarContra(diamante);

        assertEquals(900, pico.getDurabilidad());

    }

    @Test
    public void test04SeUsaPicoFinoContraMaderaYDurabilidadNoSeVeAfectada(){

        PicoFino pico = new PicoFino();
        Material madera = new Madera();
        int durabilidadInicial = pico.getDurabilidad();

        pico.usarContra(madera);

        assertEquals(durabilidadInicial, pico.getDurabilidad());

    }

    @Test
    public void test05SeUsaPicoFinoContraPiedraYDurabilidadNoSeVeAfectada(){

        PicoFino pico = new PicoFino();
        Material piedra = new Piedra();
        int durabilidadInicial = pico.getDurabilidad();

        pico.usarContra(piedra);

        assertEquals(durabilidadInicial, pico.getDurabilidad());

    }

    @Test
    public void test06SeUsaPicoFinoContraMetalYDurabilidadNoSeVeAfectada(){

        PicoFino pico = new PicoFino();
        Material metal = new Metal();
        int durabilidadInicial = pico.getDurabilidad();

        pico.usarContra(metal);

        assertEquals(durabilidadInicial, pico.getDurabilidad());

    }

    @Test
    public void test07PicoFinoCon0DeDurabilidadNoSeRompe(){
        PicoFino pico = new PicoFino();
        Material diamante = new Diamante();

        for(int i = 0; i < 50; i++){
            pico.usarContra(diamante);
        }

        assertEquals(pico.getDurabilidad(), 0);

    }

    @Test
    public void test08PicoFinoConMenosDe0DurabilidadSeRompe(){
        PicoFino pico = new PicoFino();
        Material diamante = new Diamante();

        for(int i = 0; i < 50; i++){
            pico.usarContra(diamante);
        }

        thrown.expect(HerramientaRotaException.class);
        pico.usarContra(diamante);

    }

}
