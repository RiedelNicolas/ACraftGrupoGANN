
package Algocraft.Tablero;

import Algocraft.Excepciones.PosicionFueraDeRangoException;
import Algocraft.Excepciones.PosicionOcupadaException;
import Algocraft.Jugador.Jugador;
import Algocraft.Posicion.Posicion;

public class Mapa {

//Atributos
    private Posicion[][] campo;
    final int alto = 45;  //Asumimos que es esta la dimension del ancho y del alto
    final int ancho = 81;
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
        campo = new Posicion[ancho][alto];
        ubicador = new Ubicador();
        for(int i = 0; i < ancho; i++){
            for(int j = 0; j < alto; j++){
                campo[i][j] = new Posicion(i, j);
            }
        }
        jugador = new Posicion(Jugador.crearUnico(), ancho/2, alto/2);
        ubicar(jugador);
    }

    public Posicion getPosicion(int x, int y){
        if(!estaEnElCampo(x, y)){
            throw new PosicionFueraDeRangoException();
        }
        return campo[x][y];
    }

    public void ubicar(Posicion posicion){
        campo[posicion.componenteVertical()][posicion.componenteHorizontal()].ocupar(posicion.getOcupante());
    }

    public void inicializar(){
        for(int i = 0; i < ancho; i++){
            for(int j = 0; j < alto; j++){
                campo[i][j].setPosicionesVecinas(this);
            }
        }
        ubicador.ubicarElementos(this, ancho, alto);
    }

    public Posicion[][] getCampo(){
        return campo;
    }

    private boolean estaEnElCampo(int x, int y){
        return 0 <= x && x < ancho && 0 <= y && y < alto;
    }
}

