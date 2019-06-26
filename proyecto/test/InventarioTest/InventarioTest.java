package InventarioTest;

import Modelo.Excepciones.*;
import Modelo.Herramientas.HachaDeMadera;
import Modelo.Herramientas.PicoDeMadera;
import Modelo.Inventario.Inventario;
import Modelo.Inventario.Utilizable;
import Modelo.Jugador.Jugador;
import Modelo.MateriaPrima.MateriaPrima;
import Modelo.MateriaPrima.MateriaPrimaDiamante;
import Modelo.MateriaPrima.MateriaPrimaMadera;
import Modelo.Materiales.*;
import Modelo.Posicion.Posicion;
import Modelo.Posicion.Posicionable;
import Modelo.Tablero.Mapa;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class InventarioTest{

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test01SeCreaElInventarioConUnHachaDeMaderaEnLaPrimeraPosicion(){
        Inventario inventario = new Inventario();
        ArrayList<Utilizable> items = inventario.getItems();
        Utilizable herramienta = items.get(0);

        Assert.assertTrue(herramienta instanceof HachaDeMadera);
    }

    @Test
    public void test02ElInventarioSeCreaConLaPosicionActualEn0(){
        Inventario inventario = new Inventario();
        int posicionActual = inventario.getPosicionActual();

        Assert.assertEquals(posicionActual, 0);
    }

    @Test
    public void test03ElMetodoMoverModificaLaPosicionActualCorrectamenteSiLoHagoDentroDeLas16PosicionesQueEsteOcupa(){
        Inventario inventario = new Inventario();
        inventario.mover(5);
        int posicionActual = inventario.getPosicionActual();

        Assert.assertEquals(posicionActual, 5);
    }

    @Test
    public void test04UtilizableActualMeDevuelveUnHachaDeMaderaQueHayEnLaPosicion0(){
        Inventario inventario = new Inventario();
        Utilizable herramienta = inventario.getUtilizableActual();

        Assert.assertTrue(herramienta instanceof HachaDeMadera);
    }

    @Test
    public void test05UtilizableActualLanzaUnaExcepcionSiNoHayUtilizableEnLaPosicionActual(){
        Inventario inventario = new Inventario();
        inventario.mover(8);

        thrown.expect(NoHayElementoEnPosicionDelInventarioException.class);
        inventario.getUtilizableActual();
    }

    @Test
    public void test06SeEquipaUnUtilizableCorrectamente() {
        MateriaPrimaDiamante diamante = new MateriaPrimaDiamante();
        Inventario inventario = new Inventario();
        inventario.equipar(diamante);
        inventario.mover(1); //Me muevo a la segunda posicion, ya que en la primera esta el hacha de madera

        assertTrue(inventario.getUtilizableActual() instanceof MateriaPrimaDiamante);
    }

    @Test
    public void test07NoSePuedeAgregarUnUtilizableSiElInventarioEstaLLeno(){
        Inventario inventario = new Inventario();
        for(int i = 1; i < 16; i++){
            MateriaPrimaMadera madera = new MateriaPrimaMadera();   //lleno cada posicion el inventario con madera
            inventario.equipar(madera);
        }

        MateriaPrimaMadera madera = new MateriaPrimaMadera();

        thrown.expect(InventarioLlenoException.class);
        inventario.equipar(madera);
    }

    @Test
    public void test08SeQuitaCorrectamenteElHachaDeMaderaQueEstaEnLaPrimeraPosicion() {
        Inventario inventario = new Inventario();
        inventario.quitar();

        assertEquals(inventario.getItems().size(), 0); //Como el hacha era el unico Utilizable en el inventario, no quedan items
    }
}
