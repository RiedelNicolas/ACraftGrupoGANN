package Algocraft.Juego;

import Algocraft.PaqueteProvisorio.*;
import Algocraft.Jugador.*;

public class Juego {

    private Mapa mapa;
    private Jugador jugador;

    private static Juego instancia_unica = null;

    public Juego(){

        mapa = Mapa.instanciar();
        jugador = Jugador.crearUnico();

    }

    public static Juego crearUnico(){
        if(instancia_unica == null){
            instancia_unica = new Juego();
        }
        return instancia_unica;
    }

    public void inicializarMapa(){
        mapa.inicializar();
    }

}
