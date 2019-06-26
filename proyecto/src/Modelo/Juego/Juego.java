package Modelo.Juego;

import Modelo.Excepciones.PosicionFueraDeRangoException;
import Modelo.Excepciones.PosicionNoGolpeableException;
import Modelo.Posicion.Posicion;
import Modelo.Tablero.*;

public class Juego {

    private Mapa mapa;
    private Posicion jugador;

    private static Juego instancia_unica = null;

    private Juego(){
        int ancho = 19;
        int alto = 13;
        mapa = Mapa.instanciar(ancho, alto);
        jugador = mapa.getPosicion(ancho/2, alto/2);
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

    public Posicion getJugador(){
        return jugador;
    }

    public void jugadorMoverArriba(){
        try {
            jugador = jugador.moverArriba();
        }catch (PosicionFueraDeRangoException e){}
    }

    public void jugadorMoverAbajo(){
        try {
            jugador = jugador.moverAbajo();
        }catch (PosicionFueraDeRangoException e){}
    }

    public void jugadorMoverIzquierda(){
        try {
            jugador = jugador.moverIzquierda();
        }catch (PosicionFueraDeRangoException e){}
    }

    public void jugadorMoverDerecha(){
        try {
            jugador = jugador.moverDerecha();
        }catch (PosicionFueraDeRangoException e){}
    }

    public void jugadorGolpearArriba() {
        try {
            jugador.golpearArriba();
        } catch (PosicionNoGolpeableException e) {}
    }

    public void jugadorGolpearAbajo(){
        try {
            jugador.golpearAbajo();
        } catch (PosicionNoGolpeableException e) {}
    }

    public void jugadorGolpearIzquierda(){
        try {
            jugador.golpearIzquierda();
        } catch (PosicionNoGolpeableException e) {}
    }

    public void jugadorGolpearDerecha(){
        try {
            jugador.golpearDerecha();
        } catch (PosicionNoGolpeableException e) {}
    }

    //PARA TESTING
    public void restaurar(){
        int ancho = 19;
        int alto = 13;
        mapa = mapa.limpiar(ancho, alto);
        jugador = mapa.getPosicion(ancho/2, alto/2);
    }
}
