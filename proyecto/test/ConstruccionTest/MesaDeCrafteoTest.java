package ConstruccionTest;

import Algocraft.Herramientas.*;
import org.junit.Test;
import Algocraft.Construccion.*;
import Algocraft.Materiales.*;

import static org.junit.Assert.assertTrue;

public class MesaDeCrafteoTest {

    @Test
    public void test01PicoDeMaderaSeCreaCorrectamente(){

        MesaDeCrafteo mesa = new MesaDeCrafteo();
        PicoDeMadera picoDeMadera = new PicoDeMadera();

        mesa.anadirMaterial(new Madera(), 0);
        mesa.anadirMaterial(new Madera(), 1);
        mesa.anadirMaterial(new Madera(), 2);
        mesa.anadirMaterial(new Madera(), 4);
        mesa.anadirMaterial(new Madera(), 7);

        assertTrue(mesa.craftear().getClass().equals(picoDeMadera.getClass()));
    }

    @Test
    public void test02PicoDePiedraSeCreaCorrectamente(){

        MesaDeCrafteo mesa = new MesaDeCrafteo();
        PicoDePiedra picoDePiedra = new PicoDePiedra();

        mesa.anadirMaterial(new Piedra(), 0);
        mesa.anadirMaterial(new Piedra(), 1);
        mesa.anadirMaterial(new Piedra(), 2);
        mesa.anadirMaterial(new Madera(), 4);
        mesa.anadirMaterial(new Madera(), 7);

        assertTrue(mesa.craftear().getClass().equals(picoDePiedra.getClass()));
    }

    @Test
    public void test03PicoDeMetalSeCreaCorrectamente(){

        MesaDeCrafteo mesa = new MesaDeCrafteo();
        PicoDeMetal picoDeMetal = new PicoDeMetal();

        mesa.anadirMaterial(new Metal(), 0);
        mesa.anadirMaterial(new Metal(), 1);
        mesa.anadirMaterial(new Metal(), 2);
        mesa.anadirMaterial(new Madera(), 4);
        mesa.anadirMaterial(new Madera(), 7);

        assertTrue(mesa.craftear().getClass().equals(picoDeMetal.getClass()));
    }

    @Test
    public void test04PicoFinoSeCreaCorrectamente(){

        MesaDeCrafteo mesa = new MesaDeCrafteo();
        PicoFino picoFino = new PicoFino();

        mesa.anadirMaterial(new Metal(), 0);
        mesa.anadirMaterial(new Metal(), 1);
        mesa.anadirMaterial(new Metal(), 2);
        mesa.anadirMaterial(new Piedra(), 3);
        mesa.anadirMaterial(new Madera(), 4);
        mesa.anadirMaterial(new Madera(), 7);

        assertTrue(mesa.craftear().getClass().equals(picoFino.getClass()));
    }

    @Test
    public void test05HachaDeMaderaSeCreaCorrectamente(){

        MesaDeCrafteo mesa = new MesaDeCrafteo();
        HachaDeMadera hachaDeMadera = new HachaDeMadera();

        mesa.anadirMaterial(new Madera(), 0);
        mesa.anadirMaterial(new Madera(), 1);
        mesa.anadirMaterial(new Madera(), 3);
        mesa.anadirMaterial(new Madera(), 4);
        mesa.anadirMaterial(new Madera(), 7);

        assertTrue(mesa.craftear().getClass().equals(hachaDeMadera.getClass()));
    }

    @Test
    public void test06HachaDePiedraSeCreaCorrectamente(){

        MesaDeCrafteo mesa = new MesaDeCrafteo();
        HachaDePiedra hachaDePiedra = new HachaDePiedra();

        mesa.anadirMaterial(new Piedra(), 0);
        mesa.anadirMaterial(new Piedra(), 1);
        mesa.anadirMaterial(new Piedra(), 3);
        mesa.anadirMaterial(new Madera(), 4);
        mesa.anadirMaterial(new Madera(), 7);

        assertTrue(mesa.craftear().getClass().equals(hachaDePiedra.getClass()));
    }

    @Test
    public void test07HachaDeMetalSeCreaCorrectamente(){

        MesaDeCrafteo mesa = new MesaDeCrafteo();
        HachaDeMetal hachaDeMetal = new HachaDeMetal();

        mesa.anadirMaterial(new Metal(), 0);
        mesa.anadirMaterial(new Metal(), 1);
        mesa.anadirMaterial(new Metal(), 3);
        mesa.anadirMaterial(new Madera(), 4);
        mesa.anadirMaterial(new Madera(), 7);

        assertTrue(mesa.craftear().getClass().equals(hachaDeMetal.getClass()));
    }
}
