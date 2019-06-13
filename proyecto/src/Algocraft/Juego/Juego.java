package Algocraft.Juego;

import Algocraft.Tablero.*;

public class Juego {

    private Mapa mapa;

    private static Juego instancia_unica = null;

    public Juego(){
        mapa = Mapa.instanciar();
    }

    public static Juego crearUnico(){
        if(instancia_unica == null){
            instancia_unica = new Juego();
        }
        return instancia_unica;
    }

    public void inicializar(){
        mapa.inicializar();
    }

    //para pruebas parciales
    public Mapa getMapa(){
        return mapa;
    }

}
