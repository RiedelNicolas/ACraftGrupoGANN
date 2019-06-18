package ConstruccionTest;

import Algocraft.Excepciones.ConstruccionInvalidaException;
import Algocraft.Herramientas.*;
import Algocraft.MateriaPrima.MateriaPrimaMadera;
import Algocraft.MateriaPrima.MateriaPrimaPiedra;
import org.junit.Test;
import Algocraft.Construccion.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MesaDeCrafteoTest {

    @Test
    public void test01PicoDeMaderaSeCreaCorrectamente(){

        MesaDeCrafteo mesa = new MesaDeCrafteo();
        PicoDeMadera picoDeMadera = new PicoDeMadera();

        mesa.anadirMateriaPrima(new MateriaPrimaMadera(), 0);
        mesa.anadirMateriaPrima(new MateriaPrimaMadera(), 1);
        mesa.anadirMateriaPrima(new MateriaPrimaMadera(), 2);
        mesa.anadirMateriaPrima(new MateriaPrimaMadera(), 4);
        mesa.anadirMateriaPrima(new MateriaPrimaMadera(), 7);

        assertTrue(mesa.craftear().getClass().equals(picoDeMadera.getClass()));
    }

    @Test
    public void test02PicoDePiedraSeCreaCorrectamente(){

        MesaDeCrafteo mesa = new MesaDeCrafteo();
        PicoDePiedra picoDePiedra = new PicoDePiedra();

        mesa.anadirMateriaPrima(new MateriaPrimaPiedra(), 0);
        mesa.anadirMateriaPrima(new MateriaPrimaPiedra(), 1);
        mesa.anadirMateriaPrima(new MateriaPrimaPiedra(), 2);
        mesa.anadirMateriaPrima(new MateriaPrimaMadera(), 4);
        mesa.anadirMateriaPrima(new MateriaPrimaMadera(), 7);

        assertTrue(mesa.craftear().getClass().equals(picoDePiedra.getClass()));
    }

    @Test
    public void test03PicoDeMetalSeCreaCorrectamente(){

        MesaDeCrafteo mesa = new MesaDeCrafteo();
        PicoDeMetal picoDeMetal = new PicoDeMetal();

        mesa.anadirMateriaPrima(new MateriaPrimaPiedra(), 0);
        mesa.anadirMateriaPrima(new MateriaPrimaPiedra(), 1);
        mesa.anadirMateriaPrima(new MateriaPrimaPiedra(), 2);
        mesa.anadirMateriaPrima(new MateriaPrimaMadera(), 4);
        mesa.anadirMateriaPrima(new MateriaPrimaMadera(), 7);

        assertTrue(mesa.craftear().getClass().equals(picoDeMetal.getClass()));
    }

    @Test
    public void test04PicoFinoSeCreaCorrectamente(){

        MesaDeCrafteo mesa = new MesaDeCrafteo();
        PicoFino picoFino = new PicoFino();

        mesa.anadirMateriaPrima(new MateriaPrimaPiedra(), 0);
        mesa.anadirMateriaPrima(new MateriaPrimaPiedra(), 1);
        mesa.anadirMateriaPrima(new MateriaPrimaPiedra(), 2);
        mesa.anadirMateriaPrima(new MateriaPrimaPiedra(), 3);
        mesa.anadirMateriaPrima(new MateriaPrimaMadera(), 4);
        mesa.anadirMateriaPrima(new MateriaPrimaMadera(), 7);

        assertTrue(mesa.craftear().getClass().equals(picoFino.getClass()));
    }

    @Test
    public void test05HachaDeMaderaSeCreaCorrectamente(){

        MesaDeCrafteo mesa = new MesaDeCrafteo();
        HachaDeMadera hachaDeMadera = new HachaDeMadera();

        mesa.anadirMateriaPrima(new MateriaPrimaMadera(), 0);
        mesa.anadirMateriaPrima(new MateriaPrimaMadera(), 1);
        mesa.anadirMateriaPrima(new MateriaPrimaMadera(), 3);
        mesa.anadirMateriaPrima(new MateriaPrimaMadera(), 4);
        mesa.anadirMateriaPrima(new MateriaPrimaMadera(), 7);

        assertTrue(mesa.craftear().getClass().equals(hachaDeMadera.getClass()));
    }

    @Test
    public void test06HachaDePiedraSeCreaCorrectamente(){

        MesaDeCrafteo mesa = new MesaDeCrafteo();
        HachaDePiedra hachaDePiedra = new HachaDePiedra();

        mesa.anadirMateriaPrima(new MateriaPrimaPiedra(), 0);
        mesa.anadirMateriaPrima(new MateriaPrimaPiedra(), 1);
        mesa.anadirMateriaPrima(new MateriaPrimaPiedra(), 3);
        mesa.anadirMateriaPrima(new MateriaPrimaMadera(), 4);
        mesa.anadirMateriaPrima(new MateriaPrimaMadera(), 7);

        assertTrue(mesa.craftear().getClass().equals(hachaDePiedra.getClass()));
    }

    @Test
    public void test07HachaDeMetalSeCreaCorrectamente(){

        MesaDeCrafteo mesa = new MesaDeCrafteo();
        HachaDeMetal hachaDeMetal = new HachaDeMetal();

        mesa.anadirMateriaPrima(new MateriaPrimaPiedra(), 0);
        mesa.anadirMateriaPrima(new MateriaPrimaPiedra(), 1);
        mesa.anadirMateriaPrima(new MateriaPrimaPiedra(), 3);
        mesa.anadirMateriaPrima(new MateriaPrimaMadera(), 4);
        mesa.anadirMateriaPrima(new MateriaPrimaMadera(), 7);

        assertTrue(mesa.craftear().getClass().equals(hachaDeMetal.getClass()));
    }

    @Test
    public void test08SeIntentaConstruirHerramientaInexistente(){

        MesaDeCrafteo mesa = new MesaDeCrafteo();
        boolean noSePudoConstruir = false;

        mesa.anadirMateriaPrima(new MateriaPrimaPiedra(), 0);
        mesa.anadirMateriaPrima(new MateriaPrimaPiedra(), 1);

        try{
            mesa.craftear();
        }catch(ConstruccionInvalidaException e){
            noSePudoConstruir = true;
        }

        assertTrue(noSePudoConstruir);
    }


    @Test
    public void test09SePuedeConstruirPicoDeMaderaPeroAlRemoverUnMaterialEIntentarCraftearSeLanzaExcepcion() {

        MesaDeCrafteo mesa = new MesaDeCrafteo();
        PicoDeMadera picoDeMadera = new PicoDeMadera();
        boolean noSePudoConstruir = false;

        mesa.anadirMateriaPrima(new MateriaPrimaMadera(), 0);
        mesa.anadirMateriaPrima(new MateriaPrimaMadera(), 1);
        mesa.anadirMateriaPrima(new MateriaPrimaMadera(), 2);
        mesa.anadirMateriaPrima(new MateriaPrimaMadera(), 4);
        mesa.anadirMateriaPrima(new MateriaPrimaMadera(), 7);

        mesa.quitarMateriaPrima(4);

        try{
            mesa.craftear();
        }catch (ConstruccionInvalidaException e){
            noSePudoConstruir = true;
        }

        assertTrue(noSePudoConstruir);
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
