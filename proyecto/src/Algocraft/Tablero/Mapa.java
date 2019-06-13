
package Algocraft.Tablero;

import Algocraft.Excepciones.PosicionFueraDeRangoException;
import Algocraft.Excepciones.PosicionOcupadaException;
import Algocraft.Jugador.Jugador;
import Algocraft.Posicion.Posicion;

public class Mapa {

//Atributos
    private Posicion[][] mapa;
    final int alto = 45;  //Asumimos que es esta la dimension del ancho y del alto
    final int ancho = 81;
    private Ubicador ubicador;
    private static Mapa instanciaUnica = null;
    private Posicion jugador;
    Acciones accion;

//Metodos
    public static Mapa instanciar(){
        if(instanciaUnica == null ){
            instanciaUnica = new Mapa();
        }
        return instanciaUnica;
    }

    private Mapa(){
        mapa = new Posicion[ancho][alto];
        ubicador = new Ubicador();
        for(int i = 0; i < ancho; i++){
            for(int j = 0; j < alto; j++){
                mapa[i][j] = new Posicion(i, j);
            }
        }
        jugador = new Posicion(Jugador.crearUnico(), ancho/2, alto/2);
        ubicar(jugador);
        accion = new Acciones();
    }

    public void ubicar(Posicion posicion){
        if(mapa[posicion.componenteHorizontal()][posicion.componenteVertical()].estaOcupada()){
            throw new PosicionOcupadaException();
        }
        mapa[posicion.componenteHorizontal()][posicion.componenteVertical()] = posicion;
    }

    public void inicializar(){
        ubicador.ubicarElementos(this, ancho, alto);
    }

    public Posicion[][] getMapa(){
        return mapa;
    }

    public void moverJugadorIzquierda(){   //Refactoring
        if(!estaEnElMapa(jugador.componenteHorizontal() - 1, jugador.componenteVertical())){
            throw new PosicionFueraDeRangoException();
        }
        try {
            jugador = accion.mover(jugador, mapa[jugador.componenteHorizontal() - 1][jugador.componenteVertical()]);
        } catch (PosicionOcupadaException e) {}
    }

    public void moverJugadorDerecha(){
        if(!estaEnElMapa(jugador.componenteHorizontal() + 1, jugador.componenteVertical())){
            throw new PosicionFueraDeRangoException();
        }
        try {
            jugador = accion.mover(jugador, mapa[jugador.componenteHorizontal() + 1][jugador.componenteVertical()]);
        } catch (PosicionOcupadaException e) {}
    }

    public void moverJugadorArriba(){
        if(!estaEnElMapa(jugador.componenteHorizontal(), jugador.componenteVertical() - 1)){
            throw new PosicionFueraDeRangoException();
        }
        try {
            jugador = accion.mover(jugador, mapa[jugador.componenteHorizontal()][jugador.componenteVertical() - 1]);
        } catch (PosicionOcupadaException e) {}
    }

    public void moverJugadorAbajo(){
        if(!estaEnElMapa(jugador.componenteHorizontal(), jugador.componenteVertical() + 1)){
            throw new PosicionFueraDeRangoException();
        }
        try {
            jugador = accion.mover(jugador, mapa[jugador.componenteHorizontal()][jugador.componenteVertical() + 1]);
        } catch (PosicionOcupadaException e) {}
    }

    private boolean estaEnElMapa(int componenteHorizontal, int componenteVertical){
        return ((0 <= componenteHorizontal) && (componenteHorizontal < ancho) && (0 <= componenteVertical) && (componenteVertical < alto));
    }
}

