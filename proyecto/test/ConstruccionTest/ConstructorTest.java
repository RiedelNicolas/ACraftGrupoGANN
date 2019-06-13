package ConstruccionTest;

import Algocraft.Materiales.*;
import Algocraft.Herramientas.*;
import Algocraft.Construccion.*;
import Algocraft.Recetas.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class ConstructorTest {

    @Test
    public void test01ConstrucctorSeCreaCon7Recetas(){
        Constructor constructor = new Constructor();
        ArrayList<Receta> recetas = constructor.getRecetas();

        Assert.assertEquals(recetas.size(), 7);
    }
}
