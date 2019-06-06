import org.hamcrest.*;
import org.junit.*;

public class DesgasteTest {

    @Test
    public void test01DesgastePorGolpesSeCreaCorrectamente(){
        DesgastePorGolpes desgaste = new DesgastePorGolpes(5);
        Assert.assertNotNull(desgaste);
    }

    @Test
    public void test02DesgastePorGolpesHeredaDeDesgaste(){
        Assert.assertThat(new DesgastePorGolpes(5), CoreMatchers.instanceOf(Desgaste.class));
    }

    @Test
    public void test03DesgastePorGolpesSeInicializaCon5GolpesMaximos(){
        DesgastePorGolpes desgaste = new DesgastePorGolpes(5);
        Assert.assertEquals(desgaste.getGolpesMaximos(), 5);
    }

//    @Test
//    public void test02JugadorSeCreaConHachaDeMaderaEnMano() {
//        Jugador jugador = new Jugador();
//        Assert.assertThat(jugador.getHerramientaEnMano(), CoreMatchers.instanceOf(HachaDeMadera.class));
//    }
}
