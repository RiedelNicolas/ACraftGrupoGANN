package TestAcciones;

import Algocraft.Excepciones.PosicionFueraDeRangoException;
import Algocraft.Excepciones.PosicionOcupadaException;
import Algocraft.Jugador.Jugador;
import Algocraft.Materiales.Madera;
import Algocraft.Posicion.Posicion;
import Algocraft.Tablero.*;

import org.junit.*;
import org.hamcrest.*;

public class AccionesTest {

  /*  @Test
    public void test01AccionesSeCrea() {
        Acciones acciones = new Acciones(41, 85);
        Assert.assertNotNull(acciones);
    }

    @Test
    public void test02SeCreaAccionesYSeIntentaMoverJugadorEntreDosPosicionesvalidas() {
        Acciones acciones = new Acciones(41, 85);
        Posicion posicionAnterior = new Posicion(0, 0);
        Posicion posicionNueva = new Posicion(1, 0);

        posicionAnterior.ocupar(Jugador.crearUnico());
        acciones.mover(posicionAnterior, posicionNueva);

        Assert.assertNotNull(posicionNueva.getOcupante());
    }

    @Test(expected = PosicionFueraDeRangoException.class)
    public void test03SeCreaAccionesYSeIntentaMoverJugadorAUnaPosicionFueraDeRangoLevantaExcepcion() {
        Acciones acciones = new Acciones(41, 85);
        Posicion posicionAnterior = new Posicion(0, 0);
        Posicion posicionNueva = new Posicion(80, 87);

        posicionAnterior.ocupar(Jugador.crearUnico());
        acciones.mover(posicionAnterior, posicionNueva);

    }


    @Test(expected = PosicionOcupadaException.class)
    public void test04SeCreaAccionesYSeIntentaMoverJugadorAUnaPosicionOcupadaLevantaExcepcion() {
        Acciones acciones = new Acciones(41, 85);
        Posicion posicionAnterior = new Posicion(0, 0);
        Posicion posicionNueva = new Posicion(1, 5);

        posicionAnterior.ocupar(Jugador.crearUnico());
        posicionNueva.ocupar( new Madera() );

        acciones.mover(posicionAnterior, posicionNueva);

    }

    @Test(expected = PosicionFueraDeRangoException.class)
    public void test05SeCreaAccionesYSeIntentaGolpearUnMineralEnUnaPosicionNoValida() {
        Acciones acciones = new Acciones(41, 85);
        Posicion posicionJuegador = new Posicion(0, 0);
        Posicion posicionMaterial = new Posicion(80, 0;

        posicionJuegador.ocupar(Jugador.crearUnico());
        posicionMaterial.ocupar( new Madera() );

        acciones.golpear(posicionJuegador, posicionMaterial);

    }

*/


}