
package Algocraft.PaqueteProvisorio;

import Algocraft.Excepciones.PosicionFueraDeRangoException;

public class Mapa {
    private Nodo[][] plano;
    private int alto;
    private int ancho;
    private Ubicador ubicador;

    //para el singleton
    private static Mapa instancia_unica = null;

    public static Mapa NuevoConDimesiones(int ancho, int alto){
        if(instancia_unica == null ){
            instancia_unica = new Mapa(ancho,alto);
        }
        return instancia_unica;
    }

    private Mapa(int ancho, int alto){
        plano = new Nodo[ancho][alto];
        this.alto = alto;
        this.ancho = ancho;
        ubicador = new Ubicador();
    }

    public void agregarElemento(Posicionable elemento, Posicion pos){
        if(fueraDeRango(pos)){
            throw new PosicionFueraDeRangoException();
        }
        Nodo nodoActual = plano[pos.getHorizontal()][pos.getVertical()];
        nodoActual.setContenido(elemento);
    }

    public Posicionable getElemento(Posicion pos){
        if( fueraDeRango(pos) ){
            throw new PosicionFueraDeRangoException();
        }

        Nodo nodoActual = plano[pos.getHorizontal()][pos.getVertical()];
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

    public void actualizar(){

    }

    private void limpiarNodosAbsurdos(){

    }

}
