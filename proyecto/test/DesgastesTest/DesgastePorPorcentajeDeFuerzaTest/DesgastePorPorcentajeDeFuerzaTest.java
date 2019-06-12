package DesgastesTest.DesgastePorPorcentajeDeFuerzaTest;

import Algocraft.Desgastes.DesgastePorPorcentaje;
import Algocraft.Desgastes.DesgastePorPorcentajeDeDurabilidad;
import Algocraft.Desgastes.DesgastePorPorcentajeDeFuerza;
import Algocraft.Excepciones.HerramientaRotaException;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class DesgastePorPorcentajeDeFuerzaTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test01DesgastePorPorcentajeDeFuerzaSeCreaCorrectamente() {
        DesgastePorPorcentajeDeFuerza desgaste = new DesgastePorPorcentajeDeFuerza(5, 5);
        Assert.assertNotNull(desgaste);
    }

    @Test
    public void test02DesgastePorPorcentajeDeFuerzaHeredaDeDesgaste() {
        Assert.assertThat(new DesgastePorPorcentajeDeFuerza(5, 5), CoreMatchers.instanceOf(DesgastePorPorcentaje.class));
    }

    @Test
    public void test03DesgastePorPorcentajeDeFuerzaSeInicializaCon2DePorcentaje() {
        DesgastePorPorcentajeDeFuerza desgaste = new DesgastePorPorcentajeDeFuerza(2, 10);
        Assert.assertEquals(desgaste.getPorcentaje(), 2, 0.0000001);
    }

    @Test
    public void test04DesgastePorPorcentajeDeFuerzaSeCreaCon5DeFuerza() {
        DesgastePorPorcentajeDeFuerza desgaste = new DesgastePorPorcentajeDeFuerza(20, 5);
        Assert.assertEquals(desgaste.aplicar(20), 19);
    }


    @Test
    public void test05DesgastePorPorcentajeDeFuerzaAplicaBienElDesgaste() {
        int durabilidad = 100;
        DesgastePorPorcentajeDeFuerza desgaste = new DesgastePorPorcentajeDeFuerza(2, 10);
        for (int i = 0; i < 3; i++) {
            durabilidad = desgaste.aplicar(durabilidad);
        }
        Assert.assertEquals(85, durabilidad);
    }

    @Test
    public void test06DesgastePorPorcentajeDeFuerzaDevuelveErrorSiLaDurabilidadQueDeberiaDevolverEsNegativa(){
        int durabilidad = 1;
        DesgastePorPorcentajeDeFuerza desgaste = new DesgastePorPorcentajeDeFuerza(50, 5);

        desgaste.aplicar(durabilidad);
    }


    @Test
    public void test07DesgastePorPorcentajeDeFuerzaDevuelveErrorSiRecibe0DeDurabilidad(){
        int durabilidad = 1;
        DesgastePorPorcentajeDeFuerza desgaste = new DesgastePorPorcentajeDeFuerza(2, 10);

        thrown.expect(HerramientaRotaException.class);
        desgaste.aplicar(durabilidad);
    }
}
