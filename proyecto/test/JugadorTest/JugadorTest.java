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
}
