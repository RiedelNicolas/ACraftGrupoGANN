import org.junit.*;

import static org.junit.Assert.assertEquals;

public class MaterialesTest {

    @Test
    public void test01MaderaSeCreaCon10DeDurabilidad(){
        Material madera = new Madera();
        assertEquals(10, madera.getDurabilidad());
    }

    @Test
    public void test02PiedraSeCreaCon30DeDurabilidad(){
        Material piedra = new Piedra();
        assertEquals(30, piedra.getDurabilidad());
    }

    @Test
    public void test03MetalSeCreaCon50DeDurabilidad(){
        Material metal = new Metal();
        assertEquals(50, metal.getDurabilidad());
    }

    @Test
    public void test04DiamanteSeCreaCon100DeDurabilidad(){
        Material diamante = new Diamante();
        assertEquals(100, diamante.getDurabilidad());
    }

    
}
