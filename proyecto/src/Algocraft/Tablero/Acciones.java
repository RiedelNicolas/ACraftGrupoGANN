package Algocraft.Tablero;

import Algocraft.Excepciones.PosicionOcupadaException;
import Algocraft.Excepciones.PosicionFueraDeRangoException;
import Algocraft.Jugador.Jugador;
import Algocraft.Materiales.Material;
import Algocraft.Posicion.Posicion;

public class Acciones {

 //Atributos
    private int ancho;
    private int alto;

 //Metodos
    public Acciones(int ancho, int alto){
        this.ancho = ancho;
        this.alto = alto;
    }

    public void mover(Posicion jugador, Posicion deseada){
        if(!estaEnElMapa(deseada)){
            throw new PosicionFueraDeRangoException();
        }
        if(deseada.estaOcupada()){
            throw new PosicionOcupadaException();
        }
        jugador.mover(deseada);
    }

    public void golpear(Posicion jugador, Posicion mineral){
        if(!estaEnElMapa(mineral)){
            throw new PosicionFueraDeRangoException();
        }
        if(mineral.estaOcupada()){
            Jugador _jugador = (Jugador) jugador.getOcupante();
            _jugador.golpear((Material) mineral.getOcupante());
        }
    }

    private boolean estaEnElMapa(Posicion posicion){
        int x = posicion.componenteHorizontal();
        int y = posicion.componenteVertical();
        return ((0 <= x) && (x < ancho) && (0 <= y) && (y < alto));
    }
}
