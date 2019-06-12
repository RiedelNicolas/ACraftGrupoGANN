package Algocraft.Materiales;

import Algocraft.Herramientas.*;

public class Madera extends Material {

    public Madera(){
        durabilidad = 10;
        id = 1;
    }

    @Override
    public void gastarCon(HachaDeMadera hacha){
        desgastarse(hacha.getFuerza());
    }

    @Override
    public void gastarCon(HachaDePiedra hacha){
        desgastarse(hacha.getFuerza());
    }

    @Override
    public void gastarCon(HachaDeMetal hacha) {
        desgastarse(hacha.getFuerza());
    }
}