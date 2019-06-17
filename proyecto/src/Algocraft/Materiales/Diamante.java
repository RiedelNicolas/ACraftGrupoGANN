package Algocraft.Materiales;

import Algocraft.Herramientas.PicoFino;
import Algocraft.MateriaPrima.MateriaPrima;
import Algocraft.MateriaPrima.MateriaPrimaDiamante;

public class Diamante extends Material {

    public Diamante(){
        durabilidad = 100;
        id = 4;
        materiaPrimaAsociada = new MateriaPrimaDiamante();
    }

    @Override
    public MateriaPrima gastarCon(PicoFino pico){
        desgastarse(pico.getFuerza());
        pico.desgastar();
    }
}
