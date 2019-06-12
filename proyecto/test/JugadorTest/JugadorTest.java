package JugadorTest;

import Algocraft.Herramientas.HachaDeMadera;
import Algocraft.Jugador.Jugador;
import org.junit.*;
import org.hamcrest.*;

public class JugadorTest {

    @Test
    public void test01JugadorSeCreaCorrectamente() {
        Jugador jugador = Jugador.crearUnico();
        Assert.assertNotNull(jugador);

    }

    @Test
    public void test02JugadorSeCreaConHachaDeMaderaEnMano() {
        Jugador jugador = Jugador.crearUnico();
        Assert.assertThat(jugador.getHerramientaEnMano(), CoreMatchers.instanceOf(HachaDeMadera.class));
    }

    @Test
    public void test03SeCreanDosInstanciasDeJugadorYEsLaMisma(){
        Jugador jugadorUno = Jugador.crearUnico();
        Jugador jugadorDos = Jugador.crearUnico();

        Assert.assertEquals(jugadorUno, jugadorDos);
    }

//    @Test
//    public void test04SeInicializaAlJugadorEnElCentroDelMapa(){
//
//    }


}


