package Algocraft.Posicion;

import Algocraft.Excepciones.PosicionFueraDeRangoException;
import Algocraft.Excepciones.PosicionOcupadaException;
import Algocraft.Excepciones.PosicionNoPicableException;
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

    public Posicion moverArriba(){
        return mover(arriba);
    }

    public Posicion moverAbajo(){
        return mover(abajo);
    }

    public Posicion moverIzquierda(){
        return mover(izquierda);
    }

    public Posicion moverDerecha(){
        return mover(derecha);
    }

    public void picarArriba() { picar(arriba); }

    public void picarAbajo() { picar(arriba); }

    public void picarIzquierda() { picar(arriba); }

    public void picarDerecha() { picar(arriba); }

    private Posicion mover(Posicion posicion){
        if(posicion == null){
            throw new PosicionFueraDeRangoException();
        }
        try{
            posicion.ocupar(ocupante);
            ocupante = null;
            return posicion;
        } catch (PosicionOcupadaException e){
            return this;
        }
    }

    private void picar(Posicion objetivo){
        if(objetivo == null){
            throw new PosicionFueraDeRangoException();
        }
        try{
            objetivo.recibirGolpe(ocupante);
        } catch (PosicionNoPicableException e){}
    }

    public void recibirGolpe(Posicionable posicionable){
        if(ocupante == null){
            throw new PosicionNoPicableException();
        }
        try{
            posicionable.golpear(ocupante);
        } catch (PosicionFueraDeRangoException e){}
    }

}
