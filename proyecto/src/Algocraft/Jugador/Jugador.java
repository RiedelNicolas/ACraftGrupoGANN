package Algocraft.Jugador;

import Algocraft.Herramientas.HachaDeMadera;
import Algocraft.Herramientas.Herramienta;
import Algocraft.Materiales.Material;
import Algocraft.Posicion.Posicionable;


public class Jugador extends Posicionable {
    //Atributos
    private Herramienta herramientaEnMano;
    private static Jugador instanciaUnica = null;


    private Jugador() {
        herramientaEnMano = new HachaDeMadera();
    }

    public static Jugador crearUnico(){
        if(instanciaUnica == null){
            instanciaUnica = new Jugador();
        }
        return instanciaUnica;
    }

    public Herramienta getHerramientaEnMano(){
        return herramientaEnMano;
    }

    public void golpear(Material material){
        herramientaEnMano.usarContra(material);
    }

}
