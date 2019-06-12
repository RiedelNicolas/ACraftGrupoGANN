
package Algocraft.PaqueteProvisorio;

import Algocraft.Excepciones.PosicionFueraDeRangoException;

public class Mapa {
    private Nodo[][] plano;
    final int alto = 60;       // Plano Fijo
    final int ancho = 80;
    private Ubicador ubicador;

    private static Mapa instanciaUnica = null;

    public static Mapa instanciar(){
        if(instanciaUnica == null ){
            instanciaUnica = new Mapa();
        }
        return instanciaUnica;
    }

    private Mapa(){
        plano = new Nodo[ancho][alto];
        ubicador = new Ubicador();
    }

    public void agregarElemento(Posicionable elemento, Posicion pos){
        if(fueraDeRango(pos)){
            throw new PosicionFueraDeRangoException();
        }
        Nodo nodoActual = plano [pos.getHorizontal()] [pos.getVertical()];
        nodoActual.setContenido(elemento);
    }

    public Posicionable getElemento(Posicion pos){
        if( fueraDeRango(pos) ){
            throw new PosicionFueraDeRangoException();
        }

        Nodo nodoActual = plano [pos.getHorizontal()] [pos.getVertical()];
        return nodoActual.getContenido();
    }

    public void limpiar(Posicion posicion) {

        ( plano[posicion.getHorizontal()][posicion.getVertical()] ).limpiar();
    }

    public void mover(Posicion posicionAnterior, Posicion posicionNueva){
        if( fueraDeRango(posicionAnterior) || fueraDeRango(posicionNueva) ){
            throw new PosicionFueraDeRangoException();
        }

        //esto tiene que quedar mas lindo.
        Nodo auxiliar = plano[posicionAnterior.getHorizontal()][posicionAnterior.getVertical()];
        plano[posicionNueva.getHorizontal()][posicionNueva.getVertical()] = auxiliar;
        limpiar(posicionAnterior);

    }

    public boolean fueraDeRango(Posicion posicion){
            return( !(posicion.getHorizontal()<=ancho && posicion.getVertical()<=alto) );
    }

    public void inicializar(){
        ubicador.ubicarElementos(this, ancho, alto);
    }

}

