package Algocraft.Materiales;

import Algocraft.Herramientas.PicoFino;

public class Diamante extends Material {

    public Diamante(){
        durabilidad = 100;
    }

    @Override
    public void gastarCon(PicoFino pico){
        durabilidad -= pico.getFuerza();
        pico.desgastar();
    }
}
