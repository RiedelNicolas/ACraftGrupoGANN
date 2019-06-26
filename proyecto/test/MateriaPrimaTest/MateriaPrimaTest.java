package MateriaPrimaTest;

import Modelo.Excepciones.ObjetoIncapazDeGolpearException;
import Modelo.MateriaPrima.MateriaPrimaMadera;
import Modelo.Materiales.Piedra;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MateriaPrimaTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test01SeTrataDeUsarUnaMateriaPrimaYSeLanzaUnaExcepcion(){
        MateriaPrimaMadera materiaPrimaMadera = new MateriaPrimaMadera();
        Piedra piedra = new Piedra();

        thrown.expect(ObjetoIncapazDeGolpearException.class);
        materiaPrimaMadera.usarContra(piedra);
    }
}
