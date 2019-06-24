package Modelo.Juego;

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

    public void jugadorGolpearArriba(){
        jugador.golpearArriba();
    }

    public void jugadorGolpearAbajo(){
        jugador.golpearAbajo();
    }

    public void jugadorGolpearIzquierda(){
        jugador.golpearIzquierda();
    }

    public void jugadorGolpearDerecha(){
        jugador.golpearDerecha();
    }

    //PARA TESTING
    public void restaurar(){
        mapa = mapa.limpiar(19, 13);
        //jugador = jugador.getOcupante().restaurar();
    }
}
