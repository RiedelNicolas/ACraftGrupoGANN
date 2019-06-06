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

    @Test
    public void test04DesgastePorPorcentajeDeFuerzaSeCreaCorrectamente(){
        DesgastePorPorcentajeDeFuerza desgaste = new DesgastePorPorcentajeDeFuerza(5);
        Assert.assertNotNull(desgaste);
    }

    @Test
    public void test05DesgastePorPorcentajeDeFuerzaHeredaDeDesgaste(){
        Assert.assertThat(new DesgastePorPorcentajeDeFuerza(5), CoreMatchers.instanceOf(DesgastePorPorcentaje.class));
    }

    @Test
    public void test06DesgastePorPorcentajeDeFuerzaSeInicializaCon2DePorcentaje(){
        DesgastePorPorcentajeDeFuerza desgaste = new DesgastePorPorcentajeDeFuerza(2);
        Assert.assertEquals(desgaste.getPorcentaje(), 2, 0.0000001);
    }

    @Test
    public void test07DesgastePorPorcentajeDeDurabilidadSeCreaCorrectamente(){
        DesgastePorPorcentajeDeDurabilidad desgaste = new DesgastePorPorcentajeDeDurabilidad(5);
        Assert.assertNotNull(desgaste);
    }

    @Test
    public void test08DesgastePorPorcentajeDeDurabilidadHeredaDeDesgaste(){
        Assert.assertThat(new DesgastePorPorcentajeDeDurabilidad(5), CoreMatchers.instanceOf(DesgastePorPorcentaje.class));
    }

    @Test
    public void test09DesgastePorPorcentajeDeDurabilidadSeInicializaCon2DePorcentaje(){
        DesgastePorPorcentajeDeDurabilidad desgaste = new DesgastePorPorcentajeDeDurabilidad(2);
        Assert.assertEquals(desgaste.getPorcentaje(), 2, 0.0000001);
    }


//    @Test
//    public void test07DesgastePorCantidadDeGolpesAplicaBienElDesgaste(){
//        int durabilidad = 100;
//        DesgastePorGolpes desgaste = new DesgastePorGolpes(5);
//        for (int i = 0; i < 4; i++){
//            durabilidad = desgaste.aplicar(durabilidad, )
//        }
//    }






//    @Test
//    public void test02JugadorSeCreaConHachaDeMaderaEnMano() {
//        Jugador jugador = new Jugador();
//        Assert.assertThat(jugador.getHerramientaEnMano(), CoreMatchers.instanceOf(HachaDeMadera.class));
//    }
}
