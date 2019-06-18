package HerramientasTest.PicosTest;

import Algocraft.Excepciones.HerramientaRotaException;
import Algocraft.Herramientas.PicoDeMetal;
import Algocraft.Materiales.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class PicoDeMetalTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test01PicoDeMetalSeCreaCon400DeDurabilidad() {
        PicoDeMetal pico = new PicoDeMetal();
        assertEquals(400, pico.getDurabilidad());
    }

    @Test
    public void test02PicoDeMetalSeCreaCon12DeFuerza() {
        PicoDeMetal pico = new PicoDeMetal();
        assertEquals(12, pico.getFuerza());
    }

    @Test
    public void test03SeUsaPicoDeMetalContraMaderaYDurabilidadNoSeVeAfectadaTrasUnUso(){

        PicoDeMetal pico = new PicoDeMetal();
        Material madera = new Madera();
        int durabilidadInicial = pico.getDurabilidad();

        pico.usarContra(madera);

        assertEquals(durabilidadInicial, pico.getDurabilidad());

    }

    @Test
    public void test04SeUsaPicoDeMetalContraPiedraYDurabilidadNoSeVeAfectadaTrasUnUso(){

        PicoDeMetal pico = new PicoDeMetal();
        Material piedra = new Piedra();
        int durabilidadInicial = pico.getDurabilidad();

        pico.usarContra(piedra);

        assertEquals(durabilidadInicial, pico.getDurabilidad());

    }

    @Test
    public void test05SeUsaPicoDeMetalContraMetalYDurabilidadNoSeVeAfectadaTrasUnUso(){

        PicoDeMetal pico = new PicoDeMetal();
        Material metal = new Metal();
        int durabilidadInicial = pico.getDurabilidad();

        pico.usarContra(metal);

        assertEquals(durabilidadInicial, pico.getDurabilidad());

    }

    @Test
    public void test06SeUsaPicoDeMetalContraDiamanteYDurabilidadNoSeVeAfectadaTrasUnUso(){

        PicoDeMetal pico = new PicoDeMetal();
        Material diamante = new Diamante();
        int durabilidadInicial = pico.getDurabilidad();

        pico.usarContra(diamante);

        assertEquals(durabilidadInicial, pico.getDurabilidad());

    }

    @Test
    public void test07PicoDeMetalNoSeDesgasteAlNovenoUsoContraMadera(){

        PicoDeMetal pico = new PicoDeMetal();
        Madera madera = new Madera();
        int durabilidadInicial = pico.getDurabilidad();

        for(int i = 0; i < 10; i++){
            pico.usarContra(madera);
        }

        assertEquals(durabilidadInicial, pico.getDurabilidad());
    }

    @Test
    public void test08PicoDeMetalNoSeDesgasteAlNovenoUsoContraPiedra(){

        PicoDeMetal pico = new PicoDeMetal();
        Piedra piedra = new Piedra();
        int durabilidadInicial = pico.getDurabilidad();

        for(int i = 0; i < 10; i++){
            pico.usarContra(piedra);
        }

        assertEquals(durabilidadInicial, pico.getDurabilidad());
    }

    @Test
    public void test09PicoDeMetalNoSeDesgasteAlNovenoUsoContraMetal(){
        PicoDeMetal pico = new PicoDeMetal();
        Metal metal = new Metal();
        int durabilidadInicial = pico.getDurabilidad();

        for(int i = 0; i < 10; i++){
            pico.usarContra(metal);
        }

        assertEquals(durabilidadInicial, pico.getDurabilidad());
    }

    @Test
    public void test10PicoDeMetalNoSeDesgasteAlNovenoUsoContraDiamante(){
        PicoDeMetal pico = new PicoDeMetal();
        Diamante diamante = new Diamante();
        int durabilidadInicial = pico.getDurabilidad();

        for(int i = 0; i < 10; i++){
            pico.usarContra(diamante);
        }

        assertEquals(durabilidadInicial, pico.getDurabilidad());
    }

    @Test
    public void test11PicoDeMetalSeQuedaSinDurabilidadAlDecimoUsoContraMadera(){

        PicoDeMetal pico = new PicoDeMetal();
        Madera madera = new Madera();

        for(int i = 0; i < 10; i++){
            pico.usarContra(madera);
        }

        assertEquals(0, pico.getDurabilidad());
    }

    @Test
    public void test12PicoDeMetalSeQuedaSinDurabilidadAlDecimoUsoContraPiedra(){

        PicoDeMetal pico = new PicoDeMetal();
        Piedra piedra = new Piedra();

        for(int i = 0; i < 10; i++){
            pico.usarContra(piedra);
        }

        assertEquals(0, pico.getDurabilidad());
    }

    @Test
    public void test13PicoDeMetalSeQuedaSinDurabilidadAlDecimoUsoContraMetal(){

        PicoDeMetal pico = new PicoDeMetal();
        Metal metal = new Metal();

        for(int i = 0; i < 10; i++){
            pico.usarContra(metal);
        }

        assertEquals(0, pico.getDurabilidad());
    }

    @Test
    public void test14PicoDeMetalSeQuedaSinDurabilidadAlDecimoUsoContraDiamante(){

        PicoDeMetal pico = new PicoDeMetal();
        Diamante diamante = new Diamante();

        for(int i=0; i<10; i++){
            pico.usarContra(diamante);
        }

        assertEquals(0, pico.getDurabilidad());
    }

    @Test
    public void test15PicoDeMetalConMenosDe0DurabilidadSeRompe(){
        PicoDeMetal pico = new PicoDeMetal();
        Material diamante = new Diamante();

        for(int i = 0; i < 50; i++){
            pico.usarContra(diamante);
        }

        thrown.expect(HerramientaRotaException.class);
        pico.usarContra(diamante);

    }

}


