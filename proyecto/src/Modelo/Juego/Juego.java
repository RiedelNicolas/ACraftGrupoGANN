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

    //para pruebas parciales
    public Mapa getMapa(){
        return mapa;
    }

    public void JugadorMoverArriba(){
        try {
            jugador = jugador.moverArriba();
        } catch (PosicionFueraDeRangoException e){}
    }

    public void JugadorMoverAbajo(){
        try {
            jugador = jugador.moverAbajo();
        } catch (PosicionFueraDeRangoException e){}
    }

    public void JugadorMoverIzquierda(){
        try {
            jugador = jugador.moverIzquierda();
        } catch (PosicionFueraDeRangoException e){}
    }

    public void JugadorMoverDerecha(){
        try {
            jugador = jugador.moverDerecha();
        } catch (PosicionFueraDeRangoException e){}
    }

    public void JugadorPicarArriba(){
        try {
            jugador.picarArriba();
        } catch (PosicionNoPicableException e){}
    }

    public void JugadorPicarAbajo(){
        try {
            jugador.picarAbajo();
        } catch (PosicionNoPicableException e){}
    }

    public void JugadorPicarIzquierda(){
        try {
            jugador.picarIzquierda();
        } catch (PosicionNoPicableException e){}
    }

    public void JugadorPicarDerecha(){
        try {
            jugador.picarDerecha();
        } catch (PosicionNoPicableException e){}
    }

}
