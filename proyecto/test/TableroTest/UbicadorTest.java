package TableroTest;

import Algocraft.Materiales.Diamante;
import Algocraft.Materiales.Madera;
import Algocraft.Materiales.Metal;
import Algocraft.Materiales.Piedra;
import Algocraft.Posicion.Posicion;
import Algocraft.Tablero.Mapa;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UbicadorTest {
    final int ancho = 81;
    final int alto = 45;
    //el mapa está dividido en 4 regiones verticales

    @Test
    public void test01SeUbicaMaderaEnEl20PorcientoDelMapa(){

        Mapa mapa = Mapa.instanciar();
        Posicion[][] elementosDelMapa = mapa.getCampo();
        mapa.inicializar();//el unico metodo de ubicador se llama aca adentro

        int contadorDeMaderas = 0;

        for(int i=0; i<ancho; i++){
            for(int j=0; j<alto; j++){
                if(elementosDelMapa[i][j].getOcupante() != null && (elementosDelMapa[i][j].getOcupante().getClass().equals(Madera.class))){
                    contadorDeMaderas++;
                }
            }
        }
        assertEquals(0.2, ((float)contadorDeMaderas/(ancho*alto)), 0.1);
    }

    @Test
    public void test02HayDiamantesEnElPrimerCuartoDelMapa(){

        Mapa mapa = Mapa.instanciar();
        Posicion[][] elementosDelMapa = mapa.getCampo();
        mapa.inicializar();//el unico metodo de ubicador se llama aca adentro

        int i = 0, j = 0;
        int contadorDeDiamantes = 0;

        while(i<ancho/4 && contadorDeDiamantes==0){
            while(j<alto && contadorDeDiamantes==0){
                if(elementosDelMapa[i][j].getOcupante() != null && (elementosDelMapa[i][j].getOcupante().getClass().equals(Diamante.class))){
                    contadorDeDiamantes++;
                }
                j++;
            }
            i++;
        }
        assertTrue(contadorDeDiamantes!=0);
    }

    @Test
    public void test03NoHayDiamantesEnTresCuartosDelMapa(){

        Mapa mapa = Mapa.instanciar();
        Posicion[][] elementosDelMapa = mapa.getCampo();
        mapa.inicializar();//el unico metodo de ubicador se llama aca adentro

        int contadorDeDiamantes = 0;

        for(int i=ancho/4; i<ancho; i++){
            for(int j=0; j<alto; j++){
                if(elementosDelMapa[i][j].getOcupante() != null && (elementosDelMapa[i][j].getOcupante().getClass().equals(Diamante.class))){
                    contadorDeDiamantes++;
                }
            }
        }
        assertTrue(contadorDeDiamantes==0);
    }

    @Test
    public void test04HayPiedraEnPrimeraMitadDelMapa(){

        Mapa mapa = Mapa.instanciar();
        Posicion[][] elementosDelMapa = mapa.getCampo();
        mapa.inicializar();//el unico metodo de ubicador se llama aca adentro

        int i = 0, j = 0;
        int contadorDePiedras = 0;

        while(i<ancho/2 && contadorDePiedras==0){
            while(j<alto && contadorDePiedras==0){
                if(elementosDelMapa[i][j].getOcupante() != null && (elementosDelMapa[i][j].getOcupante().getClass().equals(Piedra.class))){
                    contadorDePiedras++;
                }
                j++;
            }
            i++;
        }
        assertTrue(contadorDePiedras!=0);
    }

    @Test
    public void test05NoHayPiedraEnLaSegundaMitadDelMapa(){

        Mapa mapa = Mapa.instanciar();
        Posicion[][] elementosDelMapa = mapa.getCampo();
        mapa.inicializar();//el unico metodo de ubicador se llama aca adentro

        int contadorDePiedras = 0;

        for(int i=ancho/2; i<ancho; i++){
            for(int j=0; j<alto; j++){
                if(elementosDelMapa[i][j].getOcupante() != null && (elementosDelMapa[i][j].getOcupante().getClass().equals(Piedra.class))){
                    contadorDePiedras++;
                }
            }
        }
        assertTrue(contadorDePiedras==0);
    }

    @Test
    public void test06NoHayMetalEnLosPrimerosTresCuartosDelMapa(){

        Mapa mapa = Mapa.instanciar();
        Posicion[][] elementosDelMapa = mapa.getCampo();
        mapa.inicializar();//el unico metodo de ubicador se llama aca adentro

        int contadorDeMetal = 0;

        for(int i=0; i<((int)0.75*ancho); i++){
            for(int j=0; j<alto; j++){
                if(elementosDelMapa[i][j].getOcupante() != null && (elementosDelMapa[i][j].getOcupante().getClass().equals(Metal.class))){
                    contadorDeMetal++;
                }
            }
        }
        assertTrue(contadorDeMetal==0);
    }

    @Test
    public void test07HayMetalEnElUltimoCuartoDelMapa(){

        Mapa mapa = Mapa.instanciar();
        Posicion[][] elementosDelMapa = mapa.getCampo();
        mapa.inicializar();//el unico metodo de ubicador se llama aca adentro

        int i = (int)(0.75*ancho), j = 0;
        int contadorDeMetal = 0;

        while(i<ancho && contadorDeMetal==0){
            while(j<alto && contadorDeMetal==0){
                if(elementosDelMapa[i][j].getOcupante() != null && (elementosDelMapa[i][j].getOcupante().getClass().equals(Metal.class))){
                    contadorDeMetal++;
                }
                j++;
            }
            i++;
        }
        assertTrue(contadorDeMetal!=0);
    }
}
