package Modelo.Materiales;

import Modelo.Herramientas.*;
import Modelo.MateriaPrima.MateriaPrima;
import Modelo.MateriaPrima.MateriaPrimaPiedra;

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
