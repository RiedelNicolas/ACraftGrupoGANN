package Algocraft.Materiales;

import Algocraft.Herramientas.*;

public class Piedra extends Material {

    public Piedra(){
        durabilidad = 30;
    }

    @Override
    public void gastarCon(PicoDeMetal pico){
        desgastarse(pico.getFuerza());
    }

    @Override
    public void gastarCon(PicoDePiedra pico){
        desgastarse(pico.getFuerza());
    }

    @Override
    public void gastarCon(PicoDeMadera pico){
        desgastarse(pico.getFuerza());
    }

    @Override
    public void gastarCon(PicoFino pico){
        desgastarse(pico.getFuerza());
    }

}
