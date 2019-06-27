package JugadorTest;

import Modelo.Excepciones.MaterialRotoException;
import Modelo.Herramientas.HachaDeMadera;
import Modelo.Jugador.Jugador;
import Modelo.MateriaPrima.MateriaPrimaMadera;
import Modelo.Materiales.Diamante;
import Modelo.Materiales.Madera;
import org.junit.*;
import org.junit.rules.ExpectedException;

public class JugadorTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test01JugadorSeCreaCorrectamente() {
        Jugador jugador = Jugador.instanciar();
        Assert.assertNotNull(jugador);

    }

    @Test
    public void test02JugadorSeCreaConHachaDeMaderaEnMano() {
        Jugador jugador = Jugador.instanciar();
        Assert.assertTrue(jugador.getUtilizableEnMano() instanceof HachaDeMadera);
    }

    @Test
    public void test03SeCreanDosInstanciasDeJugadorYEsLaMisma(){
        Jugador jugadorUno = Jugador.instanciar();
        Jugador jugadorDos = Jugador.instanciar();

        Assert.assertEquals(jugadorUno, jugadorDos);
    }

    @Test
    public void test04JugadorGolpeaSinProblemasUnMaterial(){
        Jugador jugador = Jugador.instanciar();
        jugador.restaurar();
        Madera madera = new Madera();

        int durabilidadInicial = madera.getDurabilidad();

        jugador.golpear(madera);

        Assert.assertNotEquals(durabilidadInicial, madera.getDurabilidad());
    }

    @Test
    public void test05JugadorConInventarioVacioNoPuedeGolpear(){
        Jugador jugador = Jugador.instanciar();
        jugador.restaurar();
        Madera madera = new Madera();

        int durabilidadInicial = madera.getDurabilidad();

        jugador.getInventario().quitar();

        jugador.golpear(madera);

        Assert.assertEquals(durabilidadInicial, madera.getDurabilidad());
    }

    @Test
    public void test06SiLaHerramientaDelJugadorSeRompeEsteNoDaniaAlMaterial(){
        Jugador jugador = Jugador.instanciar();
        jugador.restaurar();
        Madera madera = new Madera();
        Diamante diamante = new Diamante();

        int durabilidadInicial = madera.getDurabilidad();

        for(int i = 0; i < 50; i++){
            jugador.golpear(diamante);
        }

        jugador.golpear(madera);

        Assert.assertEquals(madera.getDurabilidad(), durabilidadInicial);
    }

    @Test
    public void test07SiElUtilizableEnManoEsUnaMateriaPrimaElMaterialNoSeDania(){
        Jugador jugador = Jugador.instanciar();
        jugador.restaurar();
        Madera madera = new Madera();
        MateriaPrimaMadera materia = new MateriaPrimaMadera();

        int durabilidadInicial = madera.getDurabilidad();

        materia.equipar(jugador.getInventario());

        jugador.getInventario().mover(2);

        jugador.golpear(madera);

        Assert.assertEquals(madera.getDurabilidad(), durabilidadInicial);
    }

    @Test
    public void test08ElJugadorRompeElMaterialYDevuelveUnaExcepcion(){
        Jugador jugador = Jugador.instanciar();
        jugador.restaurar();
        Madera madera = new Madera();

        for(int i = 0; i < 4; i++){
            jugador.golpear(madera);
        }

        thrown.expect(MaterialRotoException.class);
        jugador.golpear(madera);
    }
}


