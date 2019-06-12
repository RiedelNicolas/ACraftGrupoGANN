package MaterialesTest;

import Algocraft.Excepciones.MaterialNoSeDanioException;
import Algocraft.Excepciones.MaterialRotoException;
import Algocraft.Herramientas.*;
import Algocraft.Materiales.Madera;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class MaderaTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test01MaderaSeCreaCon10DeDurabilidad(){
        Madera madera = new Madera();
        assertEquals(10, madera.getDurabilidad());
    }

    @Test
    public void test02MaderaSeGolpeaConHachaDeMaderaYSeReduceEn2LaDurabilidad(){

        Madera madera = new Madera();
        HachaDeMadera hacha = new HachaDeMadera();
        madera.gastarCon(hacha);

        assertEquals(8, madera.getDurabilidad());
    }

    @Test
    public void test03MaderaSeGolpeaConHachaDePiedraYSeReduceEn5LaDurabilidad(){

        Madera madera = new Madera();
        HachaDePiedra hacha = new HachaDePiedra();
        madera.gastarCon(hacha);

        assertEquals(5, madera.getDurabilidad());
    }

    @Test
    public void test04MaderaSeGolpeaConHachaDeMetalYSeReduceEn10LaDurabilidad(){

        Madera madera = new Madera();
        HachaDeMetal hacha = new HachaDeMetal();
        try{
            madera.gastarCon(hacha);
        }catch (MaterialRotoException e){}

        assertEquals(0, madera.getDurabilidad());
    }

    @Test
    public void test05MaderaSeGolpeaConPicoDeMaderaYNoSeReduceLaDurabilidad() {

        Madera madera = new Madera();
        PicoDeMadera pico = new PicoDeMadera();
        try {
            madera.gastarCon(pico);
        } catch (MaterialNoSeDanioException e){}

        assertEquals(10, madera.getDurabilidad());
    }

    @Test
    public void test06MaderaSeGolpeaConPicoDePiedraYNoSeReduceLaDurabilidad(){

        Madera madera = new Madera();
        PicoDePiedra pico = new PicoDePiedra();
        try {
            madera.gastarCon(pico);
        } catch (MaterialNoSeDanioException e){}

        assertEquals(10, madera.getDurabilidad());
    }

    @Test
    public void test07MaderaSeGolpeaConPicoDeMetalYNoSeReduceLaDurabilidad(){

        Madera madera = new Madera();
        PicoDeMetal pico = new PicoDeMetal();
        try {
            madera.gastarCon(pico);
        } catch (MaterialNoSeDanioException e){}

        assertEquals(10, madera.getDurabilidad());
    }

    @Test
    public void test08MaderaSeGolpeaConPicoFinoYNoSeReduceLaDurabilidad(){

        Madera madera = new Madera();
        PicoFino pico = new PicoFino();
        try {
            madera.gastarCon(pico);
        } catch (MaterialNoSeDanioException e){}

        assertEquals(10, madera.getDurabilidad());
    }

    @Test
    public void test09MaderaSeGolpeaConHachaDeMaderaYSeRompe() {

        Madera madera = new Madera();
        HachaDeMadera hacha = new HachaDeMadera();

        for(int i = 0; i < 4; i++) {
            madera.gastarCon(hacha);
        }

        assertEquals(2, madera.getDurabilidad());

        thrown.expect(MaterialRotoException.class);
        madera.gastarCon(hacha); //Chequea que se rompa con el ultimo gastar
    }
}
