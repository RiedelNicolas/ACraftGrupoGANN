package Modelo.Tablero;

import Modelo.Excepciones.PosicionOcupadaException;
import Modelo.Materiales.*;
import Modelo.Posicion.Posicion;

import java.util.concurrent.ThreadLocalRandom;

public class Ubicador {

    //Metodos
    public void ubicarElementos(Mapa mapa, int ancho, int alto){
        ubicarMadera(mapa, ancho, alto);
        ubicarPiedra(mapa, ancho, alto);
        ubicarMetal(mapa, ancho, alto);
        ubicarDiamante(mapa, ancho, alto);
    }

    private void ubicarMadera(Mapa mapa, int ancho, int alto){

        int maderasAUbicar = (ancho*alto)/5;

        for(int i = 0; i < maderasAUbicar; i++){

            Posicion posicion = new Posicion(new Madera(), ThreadLocalRandom.current().nextInt(0, ancho), ThreadLocalRandom.current().nextInt(0, alto));
            try{
                mapa.ubicar(posicion);
            }catch(PosicionOcupadaException e){ }

        }
    }

    private void ubicarPiedra(Mapa mapa, int ancho, int alto){

        int piedrasAUbicar = (ancho*alto)/10;

        for(int i = 0; i < piedrasAUbicar; i++){  //No tenemos un minimo o maximo de piedras para ubicar

            Posicion posicion = new Posicion(new Piedra(), ThreadLocalRandom.current().nextInt(0, ancho/2), ThreadLocalRandom.current().nextInt(0, alto));
            try{
                mapa.ubicar(posicion);
            }catch(PosicionOcupadaException e){ }

        }
    }

    private void ubicarMetal(Mapa mapa, int ancho, int alto){

        int metalesAUbicar = (ancho*alto)/15;

        for(int i = 0; i < metalesAUbicar; i++){

            Posicion posicion = new Posicion(new Metal(), ThreadLocalRandom.current().nextInt((int) (0.75 * ancho), ancho), ThreadLocalRandom.current().nextInt(0, alto));
            try{
                mapa.ubicar(posicion);
            }catch(PosicionOcupadaException e){ }

        }
    }

    private void ubicarDiamante(Mapa mapa, int ancho, int alto){

        int diamantesAUbicar = (ancho*alto)/20;

        for(int i = 0; i < diamantesAUbicar; i++){

            Posicion posicion = new Posicion(new Diamante(), ThreadLocalRandom.current().nextInt(0, ancho/4), ThreadLocalRandom.current().nextInt(0, alto));
            try{
                mapa.ubicar(posicion);
            }catch(PosicionOcupadaException e){ }

        }
    }
}
