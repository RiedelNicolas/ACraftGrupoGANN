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

    @Test
    public void test01AccionesSeCrea() {
        Acciones acciones = new Acciones();
        Assert.assertNotNull(acciones);
    }

    @Test
    public void test02SeCreaAccionesYSeIntentaMoverJugadorEntreDosPosicionesvalidas() {
        Acciones acciones = new Acciones();
        Posicion posicionAnterior = new Posicion(0, 0);
        Posicion posicionNueva = new Posicion(1, 0);

        posicionAnterior.ocupar(Jugador.crearUnico());
        acciones.mover(posicionAnterior, posicionNueva);

        Assert.assertNotNull(posicionNueva.getOcupante());
    }



    @Test(expected = PosicionOcupadaException.class)
    public void test03SeCreaAccionesYSeIntentaMoverJugadorAUnaPosicionOcupadaLevantaExcepcion() {
        Acciones acciones = new Acciones();
        Posicion posicionAnterior = new Posicion(0, 0);
        Posicion posicionNueva = new Posicion(1, 5);

        posicionAnterior.ocupar(Jugador.crearUnico());
        posicionNueva.ocupar( new Madera() );

        acciones.mover(posicionAnterior, posicionNueva);

    }




}