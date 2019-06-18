package HerramientasTest.HachasTest;

import Modelo.Excepciones.HerramientaRotaException;
import Modelo.Herramientas.HachaDeMadera;
import Modelo.Materiales.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class HachaDeMaderaTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test01HachaDeMaderaSeCreaCon100DeDurabilidad() {
        HachaDeMadera hacha = new HachaDeMadera();
        assertEquals(100, hacha.getDurabilidad());
    }

    @Test
    public void test02HachaDeMaderaSeCreaCon2DeFuerza() {
        HachaDeMadera hacha = new HachaDeMadera();
        assertEquals(2, hacha.getFuerza());
    }

    @Test
    public void test03SeUsaHachaDeMaderaContraMaderaYPierde2DeDurabilidad(){

        HachaDeMadera hacha = new HachaDeMadera();
        Material madera = new Madera();
        hacha.usarContra(madera);

        assertEquals(98, hacha.getDurabilidad());
    }

    @Test
    public void test04SeUsaHachaDeMaderaContraPiedraYPierde2DeDurabilidad(){

        HachaDeMadera hacha = new HachaDeMadera();
        Material piedra = new Piedra();
        hacha.usarContra(piedra);

        assertEquals(98, hacha.getDurabilidad());

    }

    @Test
    public void test05SeUsaHachaDeMaderaContraMetalYPierde2DeDurabilidad(){

        HachaDeMadera hacha = new HachaDeMadera();
        Material metal = new Metal();
        hacha.usarContra(metal);

        assertEquals(98, hacha.getDurabilidad());

    }

    @Test
    public void test06SeUsaHachaDeMaderaContraDiamanteYPierde2DeDurabilidad() {

        HachaDeMadera hacha = new HachaDeMadera();
        Material diamante = new Diamante();
        hacha.usarContra(diamante);

        assertEquals(98, hacha.getDurabilidad());

    }

    @Test
    public void test07HachaDeMaderaCon0DeDurabilidadNoSeRompe(){
        HachaDeMadera hacha = new HachaDeMadera();
        Material diamante = new Diamante();

        for(int i = 0; i < 50; i++){
            hacha.usarContra(diamante);
        }

        assertEquals(hacha.getDurabilidad(), 0);

    }

    @Test
    public void test08HachaDeMaderaConMenosDe0DurabilidadSeRompe(){
        HachaDeMadera hacha = new HachaDeMadera();
        Material diamante = new Diamante();

        for(int i = 0; i < 50; i++){
            hacha.usarContra(diamante);
        }

        thrown.expect(HerramientaRotaException.class);
        hacha.usarContra(diamante);

    }

}
