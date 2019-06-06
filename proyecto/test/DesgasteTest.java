import org.hamcrest.*;
import org.junit.*;

public class DesgasteTest {

    @Test
    public void test01DesgasteSeCreaCorrectamente(){
        Desgaste desgaste = new Desgaste();
        Assert.assertNotNull(desgaste);
    }

    @Test
    public void test02DesgastePorGolpesSeCreaCorrectamente(){
        DesgastePorGolpes desgaste = new DesgastePorGolpes();
        Assert.assertNotNull(desgaste);
    }

    @Test
    public void test03DesgastePorGolpesHeredaDeDesgaste(){
        Assert.assertThat(new DesgastePorGolpes(), CoreMatchers.instanceOf(Desgaste.class));
    }

    @Test
    public void test04DesgastePorGolpesSeInicializaCon5GolpesMaximos(){
        DesgastePorGolpes desgaste = new DesgastePorGolpes(5);
        Assert.assertEquals(desgaste.getGolpesMaximos(), 5);
    }

//    @Test
//    public void test02JugadorSeCreaConHachaDeMaderaEnMano() {
//        Jugador jugador = new Jugador();
//        Assert.assertThat(jugador.getHerramientaEnMano(), CoreMatchers.instanceOf(HachaDeMadera.class));
//    }
}
