package HerramientasTest.HachasTest;

import Modelo.Excepciones.HerramientaRotaException;
import Modelo.Herramientas.HachaDePiedra;
import Modelo.Materiales.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class HachaDePiedraTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test01HachaDePiedraSeCreaCon200DeDurabilidad() {
        HachaDePiedra hacha = new HachaDePiedra();
        assertEquals(200, hacha.getDurabilidad());
    }

    @Test
    public void test02HachaDePiedraSeCreaCon5DeFuerza() {
        HachaDePiedra hacha = new HachaDePiedra();
        assertEquals(5, hacha.getFuerza());
    }

    @Test
    public void test03SeUsaHachaDePiedraContraMaderaYPierde5DeDurabilidad(){

        HachaDePiedra hacha = new HachaDePiedra();
        Material madera = new Madera();
        hacha.usarContra(madera);

        assertEquals(195, hacha.getDurabilidad());
    }

    @Test
    public void test04SeUsaHachaDePiedraContraPiedraYPierde5DeDurabilidad(){

        HachaDePiedra hacha = new HachaDePiedra();
        Material piedra = new Piedra();
        hacha.usarContra(piedra);

        assertEquals(195, hacha.getDurabilidad());

    }

    @Test
    public void test05SeUsaHachaDePiedraContraMetalYPierde5DeDurabilidad(){

        HachaDePiedra hacha = new HachaDePiedra();
        Material metal = new Metal();
        hacha.usarContra(metal);

        assertEquals(195, hacha.getDurabilidad());

    }

    @Test
    public void test06SeUsaHachaDePiedraContraDiamanteYPierde5DeDurabilidad() {

        HachaDePiedra hacha = new HachaDePiedra();
        Material diamante = new Diamante();
        hacha.usarContra(diamante);

        assertEquals(195, hacha.getDurabilidad());

    }

    @Test
    public void test07HachaDePiedraCon0DeDurabilidadNoSeRompe(){
        HachaDePiedra hacha = new HachaDePiedra();
        Material diamante = new Diamante();

        for(int i = 0; i < 40; i++){
            hacha.usarContra(diamante);
        }

        assertEquals(hacha.getDurabilidad(), 0);

    }

    @Test
    public void test08HachaDePiedraConMenosDe0DurabilidadSeRompe(){
        HachaDePiedra hacha = new HachaDePiedra();
        Material diamante = new Diamante();

        for(int i = 0; i < 40; i++){
            hacha.usarContra(diamante);
        }

        thrown.expect(HerramientaRotaException.class);
        hacha.usarContra(diamante);

    }


}
