package Algocraft.Posicion;

import Algocraft.Excepciones.PosicionFueraDeRangoException;
import Algocraft.Excepciones.PosicionOcupadaException;
import Algocraft.Excepciones.PosicionableInamovibleException;
import Algocraft.Tablero.Mapa;

public class Posicion {

    //Atributos
    private Posicionable ocupante;
    private int componenteHorizontal;
    private int componenteVertical;

    private Posicion derecha;
    private Posicion izquierda;
    private Posicion arriba;
    private Posicion abajo;

    //Métodos
    public Posicion(int _componenteHorizontal, int _componenteVertical){
        this.componenteHorizontal = _componenteHorizontal;
        this.componenteVertical = _componenteVertical;
    }

    public Posicion(Posicionable ocupante, int _componenteHorizontal, int _componenteVertical){
        this.componenteHorizontal = _componenteHorizontal;
        this.componenteVertical = _componenteVertical;
        this.ocupante = ocupante;
    }

    public int componenteHorizontal(){
        return componenteHorizontal;
    }

    public int componenteVertical(){
        return componenteVertical;
    }

    public void ocupar(Posicionable nuevoOcupante){
        if(ocupante != null){
            throw new PosicionOcupadaException();
        }
        ocupante = nuevoOcupante;
    }

    public Posicionable getOcupante(){
        return ocupante;
    }

    public void setPosicionesVecinas(Mapa mapa){
        try {
            izquierda = mapa.getPosicion(componenteVertical - 1, componenteHorizontal);
        } catch (PosicionFueraDeRangoException e){}

        try {
            derecha = mapa.getPosicion(componenteVertical + 1, componenteHorizontal);
        } catch (PosicionFueraDeRangoException e){}

        try {
            arriba = mapa.getPosicion(componenteVertical, componenteHorizontal - 1);
        } catch (PosicionFueraDeRangoException e){}

        try {
            abajo = mapa.getPosicion(componenteVertical, componenteHorizontal + 1);
        } catch (PosicionFueraDeRangoException e){}
    }

    public void moverArriba(){
        mover(arriba);
    }

    public void moverAbajo(){
        mover(abajo);
    }

    public void moverIzquierda(){
        mover(izquierda);
    }

    public void moverDerecha(){
        mover(derecha);
    }

    private void mover(Posicion posicion){
        if(posicion == null){
            throw new PosicionFueraDeRangoException();
        }
        try{
            posicion.ocupar(ocupante);
            ocupante = null;
        } catch (PosicionOcupadaException e){}
    }

    private Posicion getIzquierda(){
        return izquierda;
    }

}
