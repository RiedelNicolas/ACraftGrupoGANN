package JuegoTest;

import Algocraft.Juego.Juego;
import Algocraft.Jugador.Jugador;
import org.junit.*;
import org.hamcrest.*;


public class JuegoTest {

    @Test
    public void test01JuegoSeCrea() {
        Juego juego = Juego.crearUnico();
        Assert.assertNotNull(juego);

    }

    @Test
    public void test02SeCreanDosInstanciasDeJuegoYEsLaMisma(){
        Juego juegoUno = Juego.crearUnico();
        Juego juegoDos = Juego.crearUnico();

        Assert.assertEquals(juegoUno, juegoDos);
    }




}
