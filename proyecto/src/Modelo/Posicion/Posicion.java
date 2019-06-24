package Modelo.Posicion;

import Modelo.Excepciones.*;
import Modelo.Jugador.Jugador;
import Modelo.Materiales.Material;
import Modelo.Tablero.Mapa;

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
            arriba = mapa.getPosicion(componenteHorizontal, componenteVertical - 1);
        } catch (PosicionFueraDeRangoException e){}

        try {
            abajo = mapa.getPosicion(componenteHorizontal, componenteVertical + 1);
        } catch (PosicionFueraDeRangoException e){}

        try {
            izquierda = mapa.getPosicion(componenteHorizontal - 1, componenteVertical);
        } catch (PosicionFueraDeRangoException e){}

        try {
            derecha = mapa.getPosicion(componenteHorizontal + 1, componenteVertical);
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

    public Posicion moverDerecha() { return mover(derecha); }

    public void golpearArriba() { golpear(arriba); }

    public void golpearAbajo() { golpear(abajo); }

    public void golpearIzquierda() { golpear(izquierda); }

    public void golpearDerecha() { golpear(derecha); }

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

    private void golpear(Posicion objetivo){
        if(objetivo == null){
            throw new PosicionNoPicableException();
        }
        objetivo.recibirGolpe(ocupante);
    }

    private void recibirGolpe(Posicionable posicionable){
        if(ocupante == null){
            throw new PosicionNoPicableException();
        }
        try{
            posicionable.golpear((Material) ocupante);
        } catch (MaterialRotoException e){
            ocupante = null;
        }
    }

    //PARA TESTING
    public Posicion getArriba(){
        return arriba;
    }

    public Posicion getAbajo(){
        return abajo;
    }

    public Posicion getIzquierda(){
        return izquierda;
    }

    public Posicion getDerecha(){
        return derecha;
    }

//    public Posicion restaurar(){
//        //(Jugador) ocupante.restaurar();
//    }
}
