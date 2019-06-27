package TableroTest;

import Modelo.Materiales.Diamante;
import Modelo.Materiales.Madera;
import Modelo.Materiales.Metal;
import Modelo.Materiales.Piedra;
import Modelo.Posicion.Posicion;
import Modelo.Tablero.Mapa;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UbicadorTest {
    private final int ancho = 19;
    private final int alto = 13;

    @Test
    public void test01SeUbicaMaderaEnEl20PorcientoDelMapa(){

        Mapa mapa = Mapa.instanciar(19, 13);
        mapa.limpiar(19, 13);
        Posicion[][] elementosDelMapa = mapa.getCampo();
        mapa.inicializar();

        int contador = 0;

        for(int i = 0; i < ancho; i++){
            for(int j = 0; j < alto; j++){
                if(elementosDelMapa[i][j].getOcupante() != null && (elementosDelMapa[i][j].getOcupante().getClass().equals(Madera.class))){
                    contador++;
                }
            }
        }
        assertEquals(0.2, ((float)contador/(ancho*alto)), 0.1);
    }

    @Test
    public void test02HayDiamantesEnElPrimerCuartoDelMapa(){

        Mapa mapa = Mapa.instanciar(19,13);
        mapa.limpiar(19, 13);
        Posicion[][] elementosDelMapa = mapa.getCampo();
        mapa.inicializar();

        int contador = 0;

        for(int i = 0; i < ancho/4 ; i++){
            for(int j = 0; j < alto; j++){
                if(elementosDelMapa[i][j].getOcupante() != null && (elementosDelMapa[i][j].getOcupante().getClass().equals(Diamante.class))){
                    contador++;
                }
            }
        }
        assertTrue(contador > 0);
    }

    @Test
    public void test03NoHayDiamantesEnTresCuartosDelMapa(){

        Mapa mapa = Mapa.instanciar(19, 13);
        mapa.limpiar(19, 13);
        Posicion[][] elementosDelMapa = mapa.getCampo();
        mapa.inicializar();

        int contador= 0;

        for(int i = ancho/4; i < ancho; i++){
            for(int j = 0; j < alto; j++){
                if(elementosDelMapa[i][j].getOcupante() != null && (elementosDelMapa[i][j].getOcupante().getClass().equals(Diamante.class))){
                    contador++;
                }
            }
        }
        assertEquals(0, contador);
    }

    @Test
    public void test04HayPiedraEnPrimeraMitadDelMapa(){

        Mapa mapa = Mapa.instanciar(19, 13);
        mapa.limpiar(19, 13);
        Posicion[][] elementosDelMapa = mapa.getCampo();
        mapa.inicializar();

        int contador = 0;

        for(int i = 0; i < ancho/2; i++){
            for(int j = 0; j < alto; j++){
                if(elementosDelMapa[i][j].getOcupante() != null && (elementosDelMapa[i][j].getOcupante().getClass().equals(Piedra.class))){
                    contador++;
                }
            }
        }
        assertTrue(contador > 0);
    }

    @Test
    public void test05NoHayPiedraEnLaSegundaMitadDelMapa(){

        Mapa mapa = Mapa.instanciar(19, 13);
        mapa.limpiar(19, 13);
        Posicion[][] elementosDelMapa = mapa.getCampo();
        mapa.inicializar();

        int contador = 0;

        for(int i = ancho/2; i < ancho; i++){
            for(int j = 0; j < alto; j++){
                if(elementosDelMapa[i][j].getOcupante() != null && (elementosDelMapa[i][j].getOcupante().getClass().equals(Piedra.class))){
                    contador++;
                }
            }
        }
        assertEquals(0, contador);
    }

    @Test
    public void test06NoHayMetalEnLosPrimerosTresCuartosDelMapa(){

        Mapa mapa = Mapa.instanciar(19, 13);
        mapa.limpiar(19, 13);
        Posicion[][] elementosDelMapa = mapa.getCampo();
        mapa.inicializar();

        int contador = 0;

        for(int i = 0; i < (int)(0.75*ancho); i++){
            for(int j = 0; j < alto; j++){
                if(elementosDelMapa[i][j].getOcupante() != null && (elementosDelMapa[i][j].getOcupante().getClass().equals(Metal.class))){
                    contador++;
                }
            }
        }
        assertEquals(0, contador);
    }

    @Test
    public void test07HayMetalEnElUltimoCuartoDelMapa(){

        Mapa mapa = Mapa.instanciar(19, 13);
        mapa.limpiar(19, 13);
        Posicion[][] elementosDelMapa = mapa.getCampo();
        mapa.inicializar();

        int contador = 0;

        for(int i = (int)(0.75*ancho); i < ancho; i++){
            for(int j = 0; j < alto; j++){
                if(elementosDelMapa[i][j].getOcupante() != null && (elementosDelMapa[i][j].getOcupante().getClass().equals(Metal.class))){
                    contador++;
                }
            }
        }
        assertTrue(contador > 0);
    }
}
