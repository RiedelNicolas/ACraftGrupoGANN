
package Algocraft.Tablero;

import Algocraft.Excepciones.PosicionOcupadaException;
import Algocraft.Jugador.Jugador;
import Algocraft.Posicion.Posicion;

public class Mapa {

//Atributos
    private Posicion[][] mapa;
    final int alto = 81;  //Asumimos que es esta la dimension del ancho y del alto
    final int ancho = 61;
    private Ubicador ubicador;
    private static Mapa instanciaUnica = null;
    private Posicion jugador;

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

}

