package Algocraft.Tablero;

import Algocraft.Excepciones.PosicionOcupadaException;
import Algocraft.Excepciones.PosicionFueraDeRangoException;
import Algocraft.Jugador.Jugador;
import Algocraft.Materiales.Material;
import Algocraft.Posicion.Posicion;

public class Acciones {

    public Posicion mover(Posicion jugador, Posicion deseada){
        if(deseada.estaOcupada()){
            throw new PosicionOcupadaException();
        }
        jugador.mover(deseada);
        return deseada;
    }

    public void golpear(Posicion jugador, Posicion mineral){
        if(mineral.estaOcupada()){
            Jugador _jugador = (Jugador) jugador.getOcupante();
            _jugador.golpear((Material) mineral.getOcupante());
        }
    }
}
