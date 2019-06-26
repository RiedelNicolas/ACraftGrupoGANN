package Modelo.Materiales;

import Modelo.Excepciones.HerramientaRotaException;
import Modelo.Herramientas.PicoFino;
import Modelo.MateriaPrima.MateriaPrima;
import Modelo.MateriaPrima.MateriaPrimaDiamante;

public class Diamante extends Material {

    //Metodos
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

        } catch (HerramientaRotaException e){ throw e; }
    }
}
