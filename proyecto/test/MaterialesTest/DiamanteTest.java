package MaterialesTest;

import Algocraft.Excepciones.MaterialNoSeDanioException;
import Algocraft.Excepciones.MaterialRotoException;
import Algocraft.Herramientas.*;
import Algocraft.Materiales.Diamante;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class DiamanteTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test01DiamanteSeCreaCon100DeDurabilidad(){
        Diamante diamante = new Diamante();
        assertEquals(100, diamante.getDurabilidad());
    }

    @Test
    public void test02DiamanteSeGolpeaConHachaDeMaderaYNoSeReduceLaDurabilidad(){

        Diamante diamante = new Diamante();
        HachaDeMadera hacha = new HachaDeMadera();
        try {
            diamante.gastarCon(hacha);
        } catch (MaterialNoSeDanioException e){}

        assertEquals(100, diamante.getDurabilidad());
    }

    @Test
    public void test03DiamanteSeGolpeaConHachaDePiedraYNoSeReduceLaDurabilidad(){

        Diamante diamante = new Diamante();
        HachaDePiedra hacha = new HachaDePiedra();
        try {
            diamante.gastarCon(hacha);
        } catch (MaterialNoSeDanioException e){}

        assertEquals(100, diamante.getDurabilidad());
    }

    @Test
    public void test04DiamanteSeGolpeaConHachaDeMetalYNoSeReduceLaDurabilidad(){

        Diamante diamante = new Diamante();
        HachaDeMetal hacha = new HachaDeMetal();
        try {
            diamante.gastarCon(hacha);
        } catch (MaterialNoSeDanioException e){}

        assertEquals(100, diamante.getDurabilidad());
    }

    @Test
    public void test05DiamanteSeGolpeaConPicoDeMaderaYNoSeReduceLaDurabilidad(){

        Diamante diamante = new Diamante();
        PicoDeMadera pico = new PicoDeMadera();
        try {
            diamante.gastarCon(pico);
        } catch (MaterialNoSeDanioException e){}

        assertEquals(100, diamante.getDurabilidad());

    }

    @Test
    public void test06DiamanteSeGolpeaConPicoDePiedraYNoSeReduceLaDurabilidad(){

        Diamante diamante = new Diamante();
        PicoDePiedra pico = new PicoDePiedra();
        try {
            diamante.gastarCon(pico);
        } catch (MaterialNoSeDanioException e){}

        assertEquals(100, diamante.getDurabilidad());

    }

    @Test
    public void test07DiamanteSeGolpeaConPicoDeMetalYNoSeReduceLaDurabilidad(){

        Diamante diamante = new Diamante();
        PicoDeMetal pico = new PicoDeMetal();
        try {
            diamante.gastarCon(pico);
        } catch (MaterialNoSeDanioException e){}

        assertEquals(100, diamante.getDurabilidad());

    }

    @Test
    public void test08DiamanteSeGolpeaConPicoFinoYSeReduceEn20LaDurabilidad(){

        Diamante diamante = new Diamante();
        PicoFino pico = new PicoFino();
        diamante.gastarCon(pico);

        assertEquals(80, diamante.getDurabilidad());
    }

    @Test
    public void test09DiamanteSeGolpeaConPicoFinoYSeRompe() {

        Diamante diamante = new Diamante();
        PicoFino pico = new PicoFino();

        for (int i = 0; i < 5; i++) {
            diamante.gastarCon(pico);
        }

        assertEquals(0, diamante.getDurabilidad());

        thrown.expect(MaterialRotoException.class);
        diamante.gastarCon(pico);
    }
}
