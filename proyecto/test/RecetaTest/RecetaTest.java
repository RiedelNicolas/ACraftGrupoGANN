package RecetaTest;

import Modelo.Excepciones.RecetaIncompatibleException;
import Modelo.Herramientas.*;
import Modelo.MateriaPrima.*;
import Modelo.Recetas.*;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;

public class RecetaTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test01RecetaHachaDeMaderaDevuelveHachaDeMaderaSiLosElementosDeLaMesaSonIgualesASuReceta(){
        RecetaHachaDeMadera receta = new RecetaHachaDeMadera();
        ArrayList<MateriaPrima> elementosDeLaMesa = new ArrayList<>();

        elementosDeLaMesa.set(0, new MateriaPrimaMadera());
        elementosDeLaMesa.set(1, new MateriaPrimaMadera());
        elementosDeLaMesa.set(3, new MateriaPrimaMadera());
        elementosDeLaMesa.set(4, new MateriaPrimaMadera());
        elementosDeLaMesa.set(7, new MateriaPrimaMadera());

        Assert.assertTrue(receta.comparar(elementosDeLaMesa) instanceof HachaDeMadera);
    }

    @Test
    public void test02RecetaHachaDeMetalDevuelveHachaDeMetalSiLosElementosDeLaMesaSonIgualesASuReceta(){
        RecetaHachaDeMetal receta = new RecetaHachaDeMetal();
        ArrayList<MateriaPrima> elementosDeLaMesa = new ArrayList<>();

        elementosDeLaMesa.set(0, new MateriaPrimaMetal());
        elementosDeLaMesa.set(1, new MateriaPrimaMetal());
        elementosDeLaMesa.set(3, new MateriaPrimaMetal());
        elementosDeLaMesa.set(4, new MateriaPrimaMadera());
        elementosDeLaMesa.set(7, new MateriaPrimaMadera());

        Assert.assertTrue(receta.comparar(elementosDeLaMesa) instanceof HachaDeMetal);
    }

    @Test
    public void test03RecetaHachaDePiedraDevuelveHachaDePiedraSiLosElementosDeLaMesaSonIgualesASuReceta(){
        RecetaHachaDePiedra receta = new RecetaHachaDePiedra();
        ArrayList<MateriaPrima> elementosDeLaMesa = new ArrayList<>();

        elementosDeLaMesa.set(0, new MateriaPrimaPiedra());
        elementosDeLaMesa.set(1, new MateriaPrimaPiedra());
        elementosDeLaMesa.set(3, new MateriaPrimaPiedra());
        elementosDeLaMesa.set(4, new MateriaPrimaMadera());
        elementosDeLaMesa.set(7, new MateriaPrimaMadera());

        Assert.assertTrue(receta.comparar(elementosDeLaMesa) instanceof HachaDePiedra);
    }

    @Test
    public void test04RecetaPicoDeMaderaDevuelvePicoDeMaderaSiLosElementosDeLaMesaSonIgualesASuReceta(){
        RecetaPicoDeMadera receta = new RecetaPicoDeMadera();
        ArrayList<MateriaPrima> elementosDeLaMesa = new ArrayList<>();

        elementosDeLaMesa.set(0, new MateriaPrimaMadera());
        elementosDeLaMesa.set(1, new MateriaPrimaMadera());
        elementosDeLaMesa.set(2, new MateriaPrimaMadera());
        elementosDeLaMesa.set(4, new MateriaPrimaMadera());
        elementosDeLaMesa.set(7, new MateriaPrimaMadera());

        Assert.assertTrue(receta.comparar(elementosDeLaMesa) instanceof PicoDeMadera);
    }

    @Test
    public void test05RecetaPicoDeMetalDevuelvePicoDeMetalSiLosElementosDeLaMesaSonIgualesASuReceta(){
        RecetaPicoDeMetal receta = new RecetaPicoDeMetal();
        ArrayList<MateriaPrima> elementosDeLaMesa = new ArrayList<>();

        elementosDeLaMesa.set(0, new MateriaPrimaMetal());
        elementosDeLaMesa.set(1, new MateriaPrimaMetal());
        elementosDeLaMesa.set(2, new MateriaPrimaMetal());
        elementosDeLaMesa.set(4, new MateriaPrimaMadera());
        elementosDeLaMesa.set(7, new MateriaPrimaMadera());

        Assert.assertTrue(receta.comparar(elementosDeLaMesa) instanceof PicoDeMetal);
    }

    @Test
    public void test06RecetaPicoDePiedraDevuelvePicoDePiedraSiLosElementosDeLaMesaSonIgualesASuReceta(){
        RecetaPicoDePiedra receta = new RecetaPicoDePiedra();
        ArrayList<MateriaPrima> elementosDeLaMesa = new ArrayList<>();

        elementosDeLaMesa.set(0, new MateriaPrimaPiedra());
        elementosDeLaMesa.set(1, new MateriaPrimaPiedra());
        elementosDeLaMesa.set(2, new MateriaPrimaPiedra());
        elementosDeLaMesa.set(4, new MateriaPrimaMadera());
        elementosDeLaMesa.set(7, new MateriaPrimaMadera());

        Assert.assertTrue(receta.comparar(elementosDeLaMesa) instanceof PicoDePiedra);
    }

    @Test
    public void test06RecetaPicoFinoDevuelvePicoFinoSiLosElementosDeLaMesaSonIgualesASuReceta(){
        RecetaPicoFino receta = new RecetaPicoFino();
        ArrayList<MateriaPrima> elementosDeLaMesa = new ArrayList<>();

        elementosDeLaMesa.set(0, new MateriaPrimaMetal());
        elementosDeLaMesa.set(1, new MateriaPrimaMetal());
        elementosDeLaMesa.set(2, new MateriaPrimaMetal());
        elementosDeLaMesa.set(3, new MateriaPrimaPiedra());
        elementosDeLaMesa.set(4, new MateriaPrimaMadera());
        elementosDeLaMesa.set(7, new MateriaPrimaMadera());

        Assert.assertTrue(receta.comparar(elementosDeLaMesa) instanceof PicoFino);
    }

    @Test
    public void test07RecetaHachaDeMaderaDevuelveExcepcionSiLosElementosDeLaMesaNoSonIgualesASuReceta(){
        RecetaHachaDeMadera receta = new RecetaHachaDeMadera();
        ArrayList<MateriaPrima> elementosDeLaMesa = new ArrayList<>();

        elementosDeLaMesa.set(0, new MateriaPrimaMadera());
        elementosDeLaMesa.set(1, new MateriaPrimaMadera());
        elementosDeLaMesa.set(3, new MateriaPrimaMadera());
        elementosDeLaMesa.set(4, new MateriaPrimaMadera());
        elementosDeLaMesa.set(7, new MateriaPrimaDiamante());

        thrown.expect(RecetaIncompatibleException.class);
        receta.comparar(elementosDeLaMesa);
    }

    @Test
    public void test08RecetaHachaDeMetalDevuelveExcepcionSiLosElementosDeLaMesaNOSonIgualesASuReceta(){
        RecetaHachaDeMetal receta = new RecetaHachaDeMetal();
        ArrayList<MateriaPrima> elementosDeLaMesa = new ArrayList<>();

        elementosDeLaMesa.set(0, new MateriaPrimaMadera());
        elementosDeLaMesa.set(1, new MateriaPrimaMadera());
        elementosDeLaMesa.set(3, new MateriaPrimaMadera());
        elementosDeLaMesa.set(4, new MateriaPrimaMadera());
        elementosDeLaMesa.set(7, new MateriaPrimaDiamante());

        thrown.expect(RecetaIncompatibleException.class);
        receta.comparar(elementosDeLaMesa);
    }

    @Test
    public void test09RecetaHachaDePiedraDevuelveExcepcionSiLosElementosDeLaMesaNoSonIgualesASuReceta(){
        RecetaHachaDePiedra receta = new RecetaHachaDePiedra();
        ArrayList<MateriaPrima> elementosDeLaMesa = new ArrayList<>();

        elementosDeLaMesa.set(0, new MateriaPrimaMadera());
        elementosDeLaMesa.set(1, new MateriaPrimaMadera());
        elementosDeLaMesa.set(3, new MateriaPrimaMadera());
        elementosDeLaMesa.set(4, new MateriaPrimaMadera());
        elementosDeLaMesa.set(7, new MateriaPrimaDiamante());

        thrown.expect(RecetaIncompatibleException.class);
        receta.comparar(elementosDeLaMesa);
    }

    @Test
    public void test10RecetaPicoDeMaderaDevuelveExcepcionSiLosElementosDeLaMesaSonIgualesASuReceta(){
        RecetaPicoDeMadera receta = new RecetaPicoDeMadera();
        ArrayList<MateriaPrima> elementosDeLaMesa = new ArrayList<>();

        elementosDeLaMesa.set(0, new MateriaPrimaMadera());
        elementosDeLaMesa.set(1, new MateriaPrimaMadera());
        elementosDeLaMesa.set(3, new MateriaPrimaMadera());
        elementosDeLaMesa.set(4, new MateriaPrimaMadera());
        elementosDeLaMesa.set(7, new MateriaPrimaDiamante());

        thrown.expect(RecetaIncompatibleException.class);
        receta.comparar(elementosDeLaMesa);
    }

    @Test
    public void test11RecetaPicoDeMetalDevuelveExcepcionSiLosElementosDeLaMesaNoSonIgualesASuReceta(){
        RecetaPicoDeMetal receta = new RecetaPicoDeMetal();
        ArrayList<MateriaPrima> elementosDeLaMesa = new ArrayList<>();

        elementosDeLaMesa.set(0, new MateriaPrimaMadera());
        elementosDeLaMesa.set(1, new MateriaPrimaMadera());
        elementosDeLaMesa.set(3, new MateriaPrimaMadera());
        elementosDeLaMesa.set(4, new MateriaPrimaMadera());
        elementosDeLaMesa.set(7, new MateriaPrimaDiamante());

        thrown.expect(RecetaIncompatibleException.class);
        receta.comparar(elementosDeLaMesa);
    }

    @Test
    public void test12RecetaPicoDePiedraDevuelveExcepcionSiLosElementosDeLaMesaNoSonIgualesASuReceta(){
        RecetaPicoDePiedra receta = new RecetaPicoDePiedra();
        ArrayList<MateriaPrima> elementosDeLaMesa = new ArrayList<>();

        elementosDeLaMesa.set(0, new MateriaPrimaMadera());
        elementosDeLaMesa.set(1, new MateriaPrimaMadera());
        elementosDeLaMesa.set(3, new MateriaPrimaMadera());
        elementosDeLaMesa.set(4, new MateriaPrimaMadera());
        elementosDeLaMesa.set(7, new MateriaPrimaDiamante());

        thrown.expect(RecetaIncompatibleException.class);
        receta.comparar(elementosDeLaMesa);
    }

    @Test
    public void test13RecetaPicoFinoDevuelveExcepcionSiLosElementosDeLaMesaNoSonIgualesASuReceta(){
        RecetaPicoFino receta = new RecetaPicoFino();
        ArrayList<MateriaPrima> elementosDeLaMesa = new ArrayList<>();

        elementosDeLaMesa.set(0, new MateriaPrimaMadera());
        elementosDeLaMesa.set(1, new MateriaPrimaMadera());
        elementosDeLaMesa.set(2, new MateriaPrimaMadera());
        elementosDeLaMesa.set(3, new MateriaPrimaMadera());
        elementosDeLaMesa.set(4, new MateriaPrimaMadera());
        elementosDeLaMesa.set(7, new MateriaPrimaDiamante());

        thrown.expect(RecetaIncompatibleException.class);
        receta.comparar(elementosDeLaMesa);
    }
}
