package DesgastesTest.DesgastePorGolpeTest;
import Algocraft.Desgastes.*;
import Algocraft.Excepciones.HerramientaRotaException;
import org.hamcrest.CoreMatchers;
import org.junit.*;
import org.junit.rules.ExpectedException;


public class DesgastePorGolpeTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

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
    public void test04DesgastePorCantidadDeGolpesAplicaBienElDesgaste() {
        int durabilidad = 100;
        DesgastePorGolpes desgaste = new DesgastePorGolpes(5);
        for (int i = 0; i < 4; i++) { // cantidad de desgastes es menor a cantidad de golpes, asi que deberia seguir igual la durabilidad
            durabilidad = desgaste.aplicar(durabilidad);
        }
        Assert.assertEquals(100, durabilidad);
    }

    @Test
    public void test05DesgastePorGolpesDevuelve0AlDecimoUso() {
        int durabilidad = 50;
        DesgastePorGolpes desgaste = new DesgastePorGolpes(10);
        for (int i = 0; i < 9; i++) {
            desgaste.aplicar(durabilidad);
        }

        Assert.assertEquals(0, desgaste.aplicar(durabilidad));
    }

    @Test
    public void test06DesgastePorGolpesDevuelvoErrorAlOnceavoUso(){
        int durabilidad = 50;
        DesgastePorGolpes desgaste = new DesgastePorGolpes(10);
        for (int i = 0; i < 10; i++){
            desgaste.aplicar(durabilidad);
        }

        thrown.expect(HerramientaRotaException.class);
        desgaste.aplicar(durabilidad);
    }

}
