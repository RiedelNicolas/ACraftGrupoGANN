package Algocraft.Jugador;

import Algocraft.Herramientas.HachaDeMadera;
import Algocraft.Herramientas.Herramienta;
import Algocraft.PaqueteProvisorio.Posicionable;
import Algocraft.PaqueteProvisorio.Posicion;


public class Jugador extends Posicionable {
    //Atributos
    private Herramienta HerramientaEnMano;
    private static Jugador instancia_unica = null;


    private Jugador() {
        HerramientaEnMano = new HachaDeMadera();
    }

    public static Jugador crearUnico(){
        if(instancia_unica == null){
            instancia_unica = new Jugador();
        }
        return instancia_unica;
    }

    public Herramienta getHerramientaEnMano(){
        return HerramientaEnMano;
    }


    //referidos a movimiento

    public void moverDerecha(){
        posicion.moverDerecha();
    }

    public void moverIzquierda(){
        posicion.moverIzquierda();
    }

    public void moverArriba(){
        posicion.moverArriba();
    }

    public void moverAbajo(){
        posicion.moverAbajo();
    }


}
