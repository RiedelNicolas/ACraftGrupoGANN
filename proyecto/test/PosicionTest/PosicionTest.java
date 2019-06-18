package PosicionTest;

import Algocraft.Jugador.Jugador;
import Algocraft.Materiales.Madera;
import Algocraft.Materiales.Piedra;
import Algocraft.Materiales.Metal;
import Algocraft.Posicion.Posicion;
import org.junit.Assert;
import org.junit.Test;

public class PosicionTest {

    @Test
    public void test01ConstructorDeDosParametrosFuncionaComoDebe(){
        Posicion unaPosicion = new Posicion(10, 5);

        Assert.assertEquals(unaPosicion.componenteHorizontal(), 10);

    }

    @Test
    public void test02ConstructorDeDosParametrosFuncionaComoDebe(){
        Posicion unaPosicion = new Posicion(10, 5);

        Assert.assertEquals(unaPosicion.componenteVertical(), 5);
    }

    @Test
    public void test03ConstructorConOcupanteDeParametroAsignaUnOcupante(){
        Jugador unJugador = Jugador.crearUnico();
        Posicion unaPosicion = new Posicion(unJugador, 2, 2);

        Assert.assertNotNull(unaPosicion.getOcupante());
    }

    @Test
    public void test04PreguntoSiUnaPosicionEstaOcupadaYObtengoResultadoPositivo(){
        Piedra piedra = new Piedra();
        Posicion unaPosicion = new Posicion(piedra, 2, 2);

        Assert.assertTrue(unaPosicion.estaOcupada());
    }

    @Test
    public void test05PreguntoSiUnaPosicionEstaOcupadaYObtengoResultadoNegativo(){
        Posicion unaPosicion = new Posicion(2, 2);

        Assert.assertFalse(unaPosicion.estaOcupada());
    }

    @Test
    public void test06OcuparUnaPosicionSinOcupanteFuncionaComoDebe(){
        Posicion unaPosicion = new Posicion(4, 6);
        Madera madera = new Madera();
        unaPosicion.ocupar(madera);

        Assert.assertEquals(unaPosicion.getOcupante(), madera);

    }

    @Test
    public void test07MuevoElOcupanteAUnaSegundaPosicionYLoHaceCorrectamente(){
        Metal metal = new Metal();
        Posicion posicionOrigen = new Posicion(metal, 0, 0);
        Posicion posicionDestino = new Posicion(0, 1);

        posicionOrigen.mover(posicionDestino);

        Assert.assertEquals(posicionDestino.getOcupante(), metal);
    }

    @Test
    public void test08MuevoElOcupanteAUnaSegundaPosicionYLoEliminaDePosicionOriginal(){
        Metal metal = new Metal();
        Posicion posicionOrigen = new Posicion(metal, 0, 0);
        Posicion posicionDestino = new Posicion(0, 1);

        posicionOrigen.mover(posicionDestino);

        Assert.assertNull(posicionOrigen.getOcupante());
    }

}