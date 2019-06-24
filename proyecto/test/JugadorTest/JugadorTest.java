package JugadorTest;

import Modelo.Herramientas.HachaDeMadera;
import Modelo.Jugador.Jugador;
import org.junit.*;
import org.hamcrest.*;

public class JugadorTest {

    @Test
    public void test01JugadorSeCreaCorrectamente() {
        Jugador jugador = Jugador.instanciar();
        Assert.assertNotNull(jugador);

    }

    @Test
    public void test02JugadorSeCreaConHachaDeMaderaEnMano() {
        Jugador jugador = Jugador.instanciar();
        Assert.assertThat(jugador.getUtilizableEnMano(), CoreMatchers.instanceOf(HachaDeMadera.class));
    }

    @Test
    public void test03SeCreanDosInstanciasDeJugadorYEsLaMisma(){
        Jugador jugadorUno = Jugador.instanciar();
        Jugador jugadorDos = Jugador.instanciar();

        Assert.assertEquals(jugadorUno, jugadorDos);
    }

//    @Test
//    public void test04JugadorUtilizaSuHerramientaEnMano
}


