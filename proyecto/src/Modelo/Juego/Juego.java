package Modelo.Juego;

import Modelo.Excepciones.PosicionFueraDeRangoException;
import Modelo.Excepciones.PosicionNoGolpeableException;
import Modelo.Posicion.Posicion;
import Modelo.Tablero.*;

public class Juego {

    private Mapa mapa;
    private Posicion posicionJugador;

    private static Juego instancia_unica = null;

    private Juego(){
        int ancho = 19;
        int alto = 13;
        mapa = Mapa.instanciar(ancho, alto);
        posicionJugador = mapa.getPosicion(ancho/2, alto/2);
    }

    public static Juego instanciar(){
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

    public Posicion getPosicionJugador(){
        return posicionJugador;
    }

    public void jugadorMoverArriba(){
        try {
            posicionJugador = posicionJugador.moverArriba();
        }catch (PosicionFueraDeRangoException e){}
    }

    public void jugadorMoverAbajo(){
        try {
            posicionJugador = posicionJugador.moverAbajo();
        }catch (PosicionFueraDeRangoException e){}
    }

    public void jugadorMoverIzquierda(){
        try {
            posicionJugador = posicionJugador.moverIzquierda();
        }catch (PosicionFueraDeRangoException e){}
    }

    public void jugadorMoverDerecha(){
        try {
            posicionJugador = posicionJugador.moverDerecha();
        }catch (PosicionFueraDeRangoException e){}
    }

    public void jugadorGolpearArriba() {
        try {
            posicionJugador.golpearArriba();
        } catch (PosicionNoGolpeableException e) {}
    }

    public void jugadorGolpearAbajo(){
        try {
            posicionJugador.golpearAbajo();
        } catch (PosicionNoGolpeableException e) {}
    }

    public void jugadorGolpearIzquierda(){
        try {
            posicionJugador.golpearIzquierda();
        } catch (PosicionNoGolpeableException e) {}
    }

    public void jugadorGolpearDerecha(){
        try {
            posicionJugador.golpearDerecha();
        } catch (PosicionNoGolpeableException e) {}
    }

    //PARA TESTING
    public void restaurar(){
        int ancho = 19;
        int alto = 13;
        mapa = mapa.limpiar(ancho, alto);
        posicionJugador = mapa.getPosicion(ancho/2, alto/2);
    }
}
