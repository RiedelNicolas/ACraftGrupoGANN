package ConstruccionTest;

import Algocraft.Construccion.Constructor;
import Algocraft.Recetas.Receta;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class ConstructorTest {

    @Test
    public void test01ConstrucctorSeCreaCon7Recetas(){
        Constructor constructor = new Constructor();
        ArrayList<Receta> recetas = constructor.getRecetas();

        Assert.assertEquals(recetas.size(), 7);

    }
}
