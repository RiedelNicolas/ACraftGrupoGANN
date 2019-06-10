import org.hamcrest.*;
import org.junit.*;

public class DesgasteTest {

    @Test
    public void test01DesgastePorGolpesSeCreaCorrectamente() {
        DesgastePorGolpes desgaste = new DesgastePorGolpes(5);
        Assert.assertNotNull(desgaste);
    }

    @Test
    public void test02DesgastePorGolpesHeredaDeDesgaste() {
        Assert.assertThat(new DesgastePorGolpes(5), CoreMatchers.instanceOf(Desgaste.class));
    }

    @Test
    public void test03DesgastePorGolpesSeInicializaCon5GolpesMaximos() {
        DesgastePorGolpes desgaste = new DesgastePorGolpes(5);
        Assert.assertEquals(desgaste.getGolpesMaximos(), 5);
    }

    @Test
    public void test04DesgastePorPorcentajeDeFuerzaSeCreaCorrectamente() {
        DesgastePorPorcentajeDeFuerza desgaste = new DesgastePorPorcentajeDeFuerza(5, 5);
        Assert.assertNotNull(desgaste);
    }

    @Test
    public void test05DesgastePorPorcentajeDeFuerzaHeredaDeDesgaste() {
        Assert.assertThat(new DesgastePorPorcentajeDeFuerza(5, 5), CoreMatchers.instanceOf(DesgastePorPorcentaje.class));
    }

    @Test
    public void test06DesgastePorPorcentajeDeFuerzaSeInicializaCon2DePorcentaje() {
        DesgastePorPorcentajeDeFuerza desgaste = new DesgastePorPorcentajeDeFuerza(2, 10);
        Assert.assertEquals(desgaste.getPorcentaje(), 2, 0.0000001);
    }

    @Test
    public void test07DesgastePorPorcentajeDeFuerzaSeCreaCon5DeFuerza() {
        DesgastePorPorcentajeDeFuerza desgaste = new DesgastePorPorcentajeDeFuerza(20, 5);
        Assert.assertEquals(desgaste.aplicar(20), 19);
    }

    @Test
    public void test07DesgastePorPorcentajeDeDurabilidadSeCreaCorrectamente() {
        DesgastePorPorcentajeDeDurabilidad desgaste = new DesgastePorPorcentajeDeDurabilidad(5);
        Assert.assertNotNull(desgaste);
    }

    @Test
    public void test08DesgastePorPorcentajeDeDurabilidadHeredaDeDesgaste() {
        Assert.assertThat(new DesgastePorPorcentajeDeDurabilidad(5), CoreMatchers.instanceOf(DesgastePorPorcentaje.class));
    }

    @Test
    public void test09DesgastePorPorcentajeDeDurabilidadSeInicializaCon2DePorcentaje() {
        DesgastePorPorcentajeDeDurabilidad desgaste = new DesgastePorPorcentajeDeDurabilidad(2);
        Assert.assertEquals(desgaste.getPorcentaje(), 2, 0.0000001);
    }


    @Test
    public void test10DesgastePorCantidadDeGolpesAplicaBienElDesgaste() {
        int durabilidad = 100;
        DesgastePorGolpes desgaste = new DesgastePorGolpes(5);
        for (int i = 0; i < 4; i++) { // cantidad de desgastes es menor a cantidad de golpes, asi que deberia seguir igual la durabilidad
            durabilidad = desgaste.aplicar(durabilidad);
        }
        Assert.assertEquals(100, durabilidad);
    }
/*
    @Test
    public void test11DesgastePorPorcentajeDeFuerzaAplicaBienElDesgaste() {
        int durabilidad = 100;
        DesgastePorPorcentajeDeFuerza desgaste = new DesgastePorPorcentajeDeFuerza(2, 10);
        for (int i = 0; i < 3; i++) {
            desgaste.aplicar(durabilidad);
        }
        Assert.assertEquals(80, desgaste.aplicar(durabilidad)); //100- (5*4)
    }

    @Test
    public void test12DesgastePorPorcentajeDeDurabilidadAplicaBienElDesgaste() {
        int durabilidad = 110;
        DesgastePorPorcentajeDeDurabilidad desgaste = new DesgastePorPorcentajeDeDurabilidad(9);

        durabilidad = desgaste.aplicar(durabilidad);

        Assert.assertEquals(101.1, durabilidad, 0.1);
    }*/

    @Test
    public void test13DesgastePorGolpesDevuelve0AlDecimoUso() {
        int durabilidad = 50;
        DesgastePorGolpes desgaste = new DesgastePorGolpes(10);
        for (int i = 0; i < 9; i++) {
            desgaste.aplicar(durabilidad);
        }

        Assert.assertEquals(0, desgaste.aplicar(durabilidad));
    }
}

  /*  @Test
    public void test14DesgastePorGolpesDevuelvoErrorAlOnceavoUso(){  //FALTA MODIFICAR
        int durabilidad = 50;
        DesgastePorGolpes desgaste = new DesgastePorGolpes(10);
        for (int i = 0; i < 10; i++){
            desgaste.aplicar(durabilidad);
        }

    }

    @Test
    public void test15DesgastePorGolpesDevuelveErrorConDurabilidadNegativa(){  //FALTA MODIFICAR
        int durabilidad = -1;
        DesgastePorGolpes desgaste = new DesgastePorGolpes(10);

        desgaste.aplicar(durabilidad);

    }

    @Test
    public void test16DesgastePorPorcentajeDeDurabilidadDevuelveErrorSiRecibe0DeDurabilidad(){  //FALTA MODIFICAR, Asumimos que la durabilidad inicial de una herramienta es solamente positiva
        int durabilidad = 0;
        DesgastePorPorcentajeDeDurabilidad desgaste = new DesgastePorPorcentajeDeDurabilidad(50);  //Asumimos que el porcentaje no puede ser mayor a 100%

        desgaste.aplicar(durabilidad);
    }

    @Test
    public void test17DesgastePorPorcentajeDeFuerzaDevuelveErrorSiLaDurabilidadQueDeberiaDevolverEsNegativa(){  //FALTA MODIFICAR
        int durabilidad = 1;
        DesgastePorPorcentajeDeFuerza desgaste = new DesgastePorPorcentajeDeFuerza(50, 5);

        desgaste.aplicar(durabilidad);
    }

}*/
