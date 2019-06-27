package MateriaPrimaTest;

import Modelo.Construccion.MesaDeCrafteo;
import Modelo.Excepciones.MateriaPrimaNoEquipableException;
import Modelo.Inventario.Inventario;
import Modelo.MateriaPrima.*;
import Modelo.Materiales.Piedra;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MateriaPrimaTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test01SeTrataDeGolpearConUnaMateriaPrimaYSeDevuelveAntimateria(){
        MateriaPrimaMadera materiaPrimaMadera = new MateriaPrimaMadera();
        Piedra piedra = new Piedra();

        Assert.assertTrue(materiaPrimaMadera.usarContra(piedra) instanceof Antimateria);
    }

    @Test
    public void test02MateriaPrimaSeAsignaAUnaPosicionDeMesaDeCrafteoCorrectamente(){
        MateriaPrimaMadera materiaPrimaMadera = new MateriaPrimaMadera();
        MesaDeCrafteo mesa = new MesaDeCrafteo();

        materiaPrimaMadera.ubicarse(mesa, 5);
        MateriaPrima materiaPrimaDevuelta = mesa.quitarMateriaPrima(5);

        Assert.assertEquals("MateriaPrimaMadera", materiaPrimaDevuelta.getClass().getSimpleName());
    }

    @Test
    public void test03MateriaPrimaMaderaDevulveUnId1(){
        MateriaPrimaMadera materiaPrimaMadera = new MateriaPrimaMadera();

        Assert.assertEquals(1, materiaPrimaMadera.getId());
    }

    @Test
    public void test04MateriaPrimaMetalDevulveUnId3(){
        MateriaPrimaMetal materiaPrimaMetal = new MateriaPrimaMetal();

        Assert.assertEquals(3, materiaPrimaMetal.getId());
    }

    @Test
    public void test05MateriaPrimaPiedraDevulveUnId2(){
        MateriaPrimaPiedra materiaPrimaPiedra = new MateriaPrimaPiedra();

        Assert.assertEquals(2, materiaPrimaPiedra.getId());
    }

    @Test
    public void test063MateriaPrimaDiamanteDevulveUnId4(){
        MateriaPrimaDiamante materiaPrimaDiamante = new MateriaPrimaDiamante();

        Assert.assertEquals(4, materiaPrimaDiamante.getId());
    }

    @Test
    public void test07MateriaPrimaSePosicionaEnElInventarioCorrectamente(){
        MateriaPrimaMadera materiaPrimaMadera = new MateriaPrimaMadera();
        Inventario inventario = new Inventario();

        materiaPrimaMadera.equipar(inventario);

        inventario.mover(2);

        Assert.assertEquals("MateriaPrimaMadera", inventario.getUtilizableActual().getClass().getSimpleName());
    }

    @Test
    public void test08AntimateriaDevuelveErrorAlIntentarPosicionarseEnElInventario(){
        Antimateria antimateria = new Antimateria();
        Inventario inventario = new Inventario();

        thrown.expect(MateriaPrimaNoEquipableException.class);
        antimateria.equipar(inventario);
    }
}
