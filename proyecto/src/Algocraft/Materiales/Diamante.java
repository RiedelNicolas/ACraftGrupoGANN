package Algocraft.Materiales;

import Algocraft.Excepciones.HerramientaRotaException;
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
        try {
            pico.desgastar();
            return desgastarse(pico.getFuerza());
        } catch (HerramientaRotaException e){
            throw e;
        }
    }
}
