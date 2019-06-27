package ConstruccionTest;

import Modelo.Excepciones.ConstruccionInvalidaException;
import Modelo.Herramientas.*;
import Modelo.MateriaPrima.MateriaPrimaMadera;
import Modelo.MateriaPrima.MateriaPrimaMetal;
import Modelo.MateriaPrima.MateriaPrimaPiedra;
import org.junit.Rule;
import org.junit.Test;
import Modelo.Construccion.*;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MesaDeCrafteoTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test01PicoDeMaderaSeCreaCorrectamente(){

        MesaDeCrafteo mesa = new MesaDeCrafteo();

        mesa.anadirMateriaPrima(new MateriaPrimaMadera(), 0);
        mesa.anadirMateriaPrima(new MateriaPrimaMadera(), 1);
        mesa.anadirMateriaPrima(new MateriaPrimaMadera(), 2);
        mesa.anadirMateriaPrima(new MateriaPrimaMadera(), 4);
        mesa.anadirMateriaPrima(new MateriaPrimaMadera(), 7);

        assertTrue(mesa.craftear() instanceof PicoDeMadera);
    }

    @Test
    public void test02PicoDePiedraSeCreaCorrectamente(){

        MesaDeCrafteo mesa = new MesaDeCrafteo();

        mesa.anadirMateriaPrima(new MateriaPrimaPiedra(), 0);
        mesa.anadirMateriaPrima(new MateriaPrimaPiedra(), 1);
        mesa.anadirMateriaPrima(new MateriaPrimaPiedra(), 2);
        mesa.anadirMateriaPrima(new MateriaPrimaMadera(), 4);
        mesa.anadirMateriaPrima(new MateriaPrimaMadera(), 7);

        assertTrue(mesa.craftear() instanceof PicoDePiedra);
    }

    @Test
    public void test03PicoDeMetalSeCreaCorrectamente(){

        MesaDeCrafteo mesa = new MesaDeCrafteo();

        mesa.anadirMateriaPrima(new MateriaPrimaMetal(), 0);
        mesa.anadirMateriaPrima(new MateriaPrimaMetal(), 1);
        mesa.anadirMateriaPrima(new MateriaPrimaMetal(), 2);
        mesa.anadirMateriaPrima(new MateriaPrimaMadera(), 4);
        mesa.anadirMateriaPrima(new MateriaPrimaMadera(), 7);

        assertTrue(mesa.craftear() instanceof PicoDeMetal);
    }

    @Test
    public void test04PicoFinoSeCreaCorrectamente(){

        MesaDeCrafteo mesa = new MesaDeCrafteo();

        mesa.anadirMateriaPrima(new MateriaPrimaMetal(), 0);
        mesa.anadirMateriaPrima(new MateriaPrimaMetal(), 1);
        mesa.anadirMateriaPrima(new MateriaPrimaMetal(), 2);
        mesa.anadirMateriaPrima(new MateriaPrimaPiedra(), 3);
        mesa.anadirMateriaPrima(new MateriaPrimaMadera(), 4);
        mesa.anadirMateriaPrima(new MateriaPrimaMadera(), 7);

        assertTrue(mesa.craftear() instanceof PicoFino);
    }

    @Test
    public void test05HachaDeMaderaSeCreaCorrectamente(){

        MesaDeCrafteo mesa = new MesaDeCrafteo();

        mesa.anadirMateriaPrima(new MateriaPrimaMadera(), 0);
        mesa.anadirMateriaPrima(new MateriaPrimaMadera(), 1);
        mesa.anadirMateriaPrima(new MateriaPrimaMadera(), 3);
        mesa.anadirMateriaPrima(new MateriaPrimaMadera(), 4);
        mesa.anadirMateriaPrima(new MateriaPrimaMadera(), 7);

        assertTrue(mesa.craftear() instanceof HachaDeMadera);
    }

    @Test
    public void test06HachaDePiedraSeCreaCorrectamente(){

        MesaDeCrafteo mesa = new MesaDeCrafteo();

        mesa.anadirMateriaPrima(new MateriaPrimaPiedra(), 0);
        mesa.anadirMateriaPrima(new MateriaPrimaPiedra(), 1);
        mesa.anadirMateriaPrima(new MateriaPrimaPiedra(), 3);
        mesa.anadirMateriaPrima(new MateriaPrimaMadera(), 4);
        mesa.anadirMateriaPrima(new MateriaPrimaMadera(), 7);

        assertTrue(mesa.craftear() instanceof HachaDePiedra);
    }

    @Test
    public void test07HachaDeMetalSeCreaCorrectamente(){

        MesaDeCrafteo mesa = new MesaDeCrafteo();

        mesa.anadirMateriaPrima(new MateriaPrimaMetal(), 0);
        mesa.anadirMateriaPrima(new MateriaPrimaMetal(), 1);
        mesa.anadirMateriaPrima(new MateriaPrimaMetal(), 3);
        mesa.anadirMateriaPrima(new MateriaPrimaMadera(), 4);
        mesa.anadirMateriaPrima(new MateriaPrimaMadera(), 7);

        assertTrue(mesa.craftear() instanceof HachaDeMetal);
    }

    @Test
    public void test08SeIntentaConstruirHerramientaInexistente(){

        MesaDeCrafteo mesa = new MesaDeCrafteo();

        mesa.anadirMateriaPrima(new MateriaPrimaPiedra(), 0);
        mesa.anadirMateriaPrima(new MateriaPrimaPiedra(), 1);

        thrown.expect(ConstruccionInvalidaException.class);
        mesa.craftear();
    }


    @Test
    public void test09SePuedeConstruirPicoDeMaderaPeroAlRemoverUnMaterialEIntentarCraftearSeLanzaExcepcion() {

        MesaDeCrafteo mesa = new MesaDeCrafteo();

        mesa.anadirMateriaPrima(new MateriaPrimaMadera(), 0);
        mesa.anadirMateriaPrima(new MateriaPrimaMadera(), 1);
        mesa.anadirMateriaPrima(new MateriaPrimaMadera(), 2);
        mesa.anadirMateriaPrima(new MateriaPrimaMadera(), 4);
        mesa.anadirMateriaPrima(new MateriaPrimaMadera(), 7);

        mesa.quitarMateriaPrima(4);

        thrown.expect(ConstruccionInvalidaException.class);
        mesa.craftear();
    }

    @Test
    public void test10MaterialRemovidoDeLaMesaSeDevuelveExitosamente(){

        MesaDeCrafteo mesa = new MesaDeCrafteo();
        MateriaPrimaMadera madera = new MateriaPrimaMadera();

        mesa.anadirMateriaPrima(madera, 6);

        MateriaPrimaMadera materialRemovido = (MateriaPrimaMadera)mesa.quitarMateriaPrima(6);

        assertEquals(madera, materialRemovido);

    }


}
