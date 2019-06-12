package Algocraft.Jugador;

import Algocraft.Herramientas.HachaDeMadera;
import Algocraft.Herramientas.Herramienta;
import Algocraft.PaqueteProvisorio.Posicionable;
import Algocraft.PaqueteProvisorio.Posicion;


public class Jugador extends Posicionable {
    //Atributos
    private Herramienta HerramientaEnMano;
    private static Jugador instanciaUnica = null;


    private Jugador() {
        HerramientaEnMano = new HachaDeMadera();
    }

    public static Jugador crearUnico(){
        if(instanciaUnica == null){
            instanciaUnica = new Jugador();
        }
        return instanciaUnica;
    }

    public Herramienta getHerramientaEnMano(){
        return HerramientaEnMano;
    }


    //referidos a movimiento

    public Posicion moverDerecha(){
            posicion.moverDerecha();
            return posicion;
    }

    public Posicion moverIzquierda(){
        posicion.moverIzquierda();
        return posicion;
    }

    public Posicion moverArriba(){
        posicion.moverArriba();
        return posicion;
    }

    public Posicion moverAbajo(){
        posicion.moverAbajo();
        return posicion;
    }


}
