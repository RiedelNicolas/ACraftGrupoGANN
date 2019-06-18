package HerramientasTest.HachasTest;

import Modelo.Excepciones.HerramientaRotaException;
import Modelo.Herramientas.HachaDeMetal;
import Modelo.Materiales.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class HachaDeMetalTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test01HachaDeMetalSeCreaCon400DeDurabilidad() {
        HachaDeMetal hacha = new HachaDeMetal();
        assertEquals(400, hacha.getDurabilidad());
    }

    @Test
    public void test02HachaDeMetalSeCreaCon10DeFuerza() {
        HachaDeMetal hacha = new HachaDeMetal();
        assertEquals(10, hacha.getFuerza());
    }


    @Test
    public void test03SeUsaHachaDeMetalContraMaderaYPierde5DeDurabilidad(){

        HachaDeMetal hacha = new HachaDeMetal();
        Material madera = new Madera();

        hacha.usarContra(madera);

    }

    @Test
    public void test04SeUsaHachaDeMetalContraPiedraYPierde5DeDurabilidad(){

        HachaDeMetal hacha = new HachaDeMetal();
        Material piedra = new Piedra();
        hacha.usarContra(piedra);

        assertEquals(395, hacha.getDurabilidad());

    }

    @Test
    public void test05SeUsaHachaDeMetalContraMetalYPierde5DeDurabilidad(){

        HachaDeMetal hacha = new HachaDeMetal();
        Material metal = new Metal();
        hacha.usarContra(metal);

        assertEquals(395, hacha.getDurabilidad());

    }

    @Test
    public void test06SeUsaHachaDeMetalContraDiamanteYPierde5DeDurabilidad(){

        HachaDeMetal hacha = new HachaDeMetal();
        Material diamante = new Diamante();
        hacha.usarContra(diamante);

        assertEquals(395, hacha.getDurabilidad());


    }

    @Test
    public void test07HachaDeMetalCon0DeDurabilidadNoSeRompe(){
        HachaDeMetal hacha = new HachaDeMetal();
        Material diamante = new Diamante();

        for(int i = 0; i < 80; i++){
            hacha.usarContra(diamante);
        }

        assertEquals(hacha.getDurabilidad(), 0);

    }

    @Test
    public void test08HachaDeMetalConMenosDe0DurabilidadSeRompe(){
        HachaDeMetal hacha = new HachaDeMetal();
        Material diamante = new Diamante();

        for(int i = 0; i < 80; i++){
            hacha.usarContra(diamante);
        }

        thrown.expect(HerramientaRotaException.class);
        hacha.usarContra(diamante);

    }

}
