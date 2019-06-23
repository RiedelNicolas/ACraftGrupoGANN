
package Modelo.Tablero;

import Modelo.Excepciones.PosicionFueraDeRangoException;
import Modelo.Jugador.Jugador;
import Modelo.Posicion.Posicion;

public class Mapa {

//Atributos
    private Posicion[][] campo;
    private int alto;
    private int ancho;
    private Ubicador ubicador;
    private static Mapa instanciaUnica = null;

//Metodos
    public static Mapa instanciar(int _ancho, int _alto){
        if(instanciaUnica == null ){
            instanciaUnica = new Mapa(_ancho, _alto);
        }
        return instanciaUnica;
    }

    private Mapa(int _ancho, int _alto){
        alto = _alto;
        ancho = _ancho;
        campo = new Posicion[ancho][alto];
        ubicador = new Ubicador();

        for(int i = 0; i < ancho; i++){
            for(int j = 0; j < alto; j++){
                campo[i][j] = new Posicion(i, j);
            }
        }

        Posicion jugador = new Posicion(Jugador.instanciar(), ancho/2, alto/2);
        ubicar(jugador);
    }

    public Posicion getPosicion(int ancho, int alto){
        if(!estaEnElCampo(ancho, alto)){
            throw new PosicionFueraDeRangoException();
        }
        return campo[ancho][alto];
    }

    public void ubicar(Posicion posicion){
        campo[posicion.componenteHorizontal()][posicion.componenteVertical()] = posicion;
        this.actualizarCampo();
    }

    public void inicializar(){
        this.actualizarCampo();
        ubicador.ubicarElementos(this, ancho, alto);
    }

    public void actualizarCampo(){
        for(int i = 0; i < ancho; i++){
            for(int j = 0; j < alto; j++){
                campo[i][j].setPosicionesVecinas(this);
            }
        }
    }

    public Posicion[][] getCampo(){
        return campo;
    }

    public int getAlto(){
        return alto;
    }

    public int getAncho(){
        return ancho;
    }

    private boolean estaEnElCampo(int columna, int fila){
        return 0 <= columna && columna < ancho && 0 <= fila && fila < alto;
    }

    //PARA TESTING
    public Mapa limpiar(){
        instanciaUnica = null;
        return instanciar(ancho, alto);
    }
}

