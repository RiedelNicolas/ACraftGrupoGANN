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
        int ancho = 19;
        int alto = 13;
        mapa = Mapa.instanciar(ancho, alto);
        jugador = mapa.getPosicion(alto/2, ancho/2);
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
        jugador = jugador.moverArriba();
    }

    public void jugadorMoverAbajo(){
        jugador = jugador.moverAbajo();
    }

    public void jugadorMoverIzquierda(){
        jugador = jugador.moverIzquierda();
    }

    public void jugadorMoverDerecha(){
        jugador = jugador.moverDerecha();
    }

    public void jugadorPicarArriba(){
        jugador.picarArriba();
    }

    public void jugadorPicarAbajo(){
        jugador.picarAbajo();
    }

    public void jugadorPicarIzquierda(){
        jugador.picarIzquierda();
    }

    public void jugadorPicarDerecha(){
        jugador.picarDerecha();
    }
}
