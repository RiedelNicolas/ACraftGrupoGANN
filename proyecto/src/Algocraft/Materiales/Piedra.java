package Algocraft.Materiales;

import Algocraft.Herramientas.*;
import Algocraft.MateriaPrima.MateriaPrima;
import Algocraft.MateriaPrima.MateriaPrimaPiedra;

public class Piedra extends Material {

    public Piedra(){
        durabilidad = 30;
        id = 2;
        materiaPrimaAsociada = new MateriaPrimaPiedra();
    }

    @Override
    public MateriaPrima gastarCon(PicoDeMetal pico){
        return desgastarse(pico.getFuerza());
    }

    @Override
    public MateriaPrima gastarCon(PicoDePiedra pico){
        return desgastarse(pico.getFuerza());
    }

    @Override
    public MateriaPrima gastarCon(PicoDeMadera pico){
        return desgastarse(pico.getFuerza());
    }

    @Override
    public MateriaPrima gastarCon(PicoFino pico){
        return desgastarse(pico.getFuerza());
    }

}
