
package Algocraft.PaqueteProvisorio;

import Algocraft.Excepciones.NodoOcupadoException;

public class Mapa {

    private Posicion[][] mapa;
    final int alto = 81;
    final int ancho = 61;

    private Ubicador ubicador;

    private static Mapa instanciaUnica = null;

    public static Mapa instanciar(){
        if(instanciaUnica == null ){
            instanciaUnica = new Mapa();
        }
        return instanciaUnica;
    }

    private Mapa(){
        mapa = new Posicion[ancho][alto];
        ubicador = new Ubicador();
    }

    public void ubicar(Posicion posicion){
        Posicion aOcupar = mapa[posicion.componenteHorizontal()][posicion.componenteVertical()];
        if(aOcupar != null){
            throw new NodoOcupadoException();
        }
        aOcupar = posicion;
    }

    public void limpiar(Posicion posicion) {

        ( plano[posicion.getHorizontal()][posicion.getVertical()] ).limpiar();
    }

    public boolean fueraDeRango(Posicion posicion){
            return( !(posicion.getHorizontal()<=ancho && posicion.getVertical()<=alto) );
    }

    public void inicializar(){
//        for(int i : ancho){
//            for(int j : alto){
//                mapa[i][j] = null;
//            }
//        }
        ubicador.ubicarElementos(this, ancho, alto);
    }

}

