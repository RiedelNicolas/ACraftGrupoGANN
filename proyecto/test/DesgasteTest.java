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


    @Test
    public void test10DesgastePorCantidadDeGolpesAplicaBienElDesgaste(){
        int durabilidad = 100;
        int fuerza = 10;
        DesgastePorGolpes desgaste = new DesgastePorGolpes(5);
        for (int i = 0; i < 4; i++){ // cantidad de desgastes es menor a cantidad de golpes, asi que deberia seguir igual la durabilidad
            durabilidad = desgaste.aplicar(durabilidad, fuerza);
        }
        Assert.assertEquals(100, durabilidad);
    }

    @Test
    public void test11DesgastePorPorcentajeDeFuerzaAplicaBienElDesgaste(){
        int durabilidad = 100;
        int fuerza = 10;
        DesgastePorPorcentajeDeFuerza desgaste = new DesgastePorPorcentajeDeFuerza(2);
        for (int i = 0; i < 4; i++){
            durabilidad = desgaste.aplicar(durabilidad, fuerza);
        }
        Assert.assertEquals(80, durabilidad); //100- (5*4)
    }

    @Test
    public void test12DesgastePorPorcentajeDeDurabilidadAplicaBienElDesgaste(){
        int durabilidad = 100;
        int fuerza = 10;
        DesgastePorPorcentajeDeDurabilidad desgaste = new DesgastePorPorcentajeDeDurabilidad(10);

        durabilidad = desgaste.aplicar(durabilidad, fuerza);

        Assert.assertEquals(90, durabilidad); //100- (100/10)
    }






//    @Test
//    public void test02JugadorSeCreaConHachaDeMaderaEnMano() {
//        Jugador jugador = new Jugador();
//        Assert.assertThat(jugador.getHerramientaEnMano(), CoreMatchers.instanceOf(HachaDeMadera.class));
//    }
}
