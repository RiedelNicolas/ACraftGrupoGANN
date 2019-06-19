package Modelo.Juego;

import Modelo.Excepciones.PosicionFueraDeRangoException;
import Modelo.Excepciones.PosicionNoPicableException;
import Modelo.Posicion.Posicion;
import Modelo.Tablero.*;

public class Juego {

    private Mapa mapa;
    private Posicion jugador;

    private static Juego instancia_unica = null;

    private Juego(){
        int ancho = 81;
        int alto = 45;
        mapa = Mapa.instanciar(ancho, alto);
        jugador = mapa.getPosicion(ancho/2, alto/2);
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

    public Mapa getMapa(){
        return mapa;
    }

    public Posicion getJugador(){
        return jugador;
    }

    public void jugadorMoverArriba(){
        try {
            jugador = jugador.moverArriba();
        } catch (PosicionFueraDeRangoException e){}
    }

    public void jugadorMoverAbajo(){
        try {
            jugador = jugador.moverAbajo();
        } catch (PosicionFueraDeRangoException e){}
    }

    public void jugadorMoverIzquierda(){
        try {
            jugador = jugador.moverIzquierda();
        } catch (PosicionFueraDeRangoException e){}
    }

    public void jugadorMoverDerecha(){
        try {
            jugador = jugador.moverDerecha();
        } catch (PosicionFueraDeRangoException e){}
    }

    public void jugadorPicarArriba(){
        try {
            jugador.picarArriba();
        } catch (PosicionNoPicableException e){}
    }

    public void jugadorPicarAbajo(){
        try {
            jugador.picarAbajo();
        } catch (PosicionNoPicableException e){}
    }

    public void jugadorPicarIzquierda(){
        try {
            jugador.picarIzquierda();
        } catch (PosicionNoPicableException e){}
    }

    public void jugadorPicarDerecha(){
        try {
            jugador.picarDerecha();
        } catch (PosicionNoPicableException e){}
    }

}
