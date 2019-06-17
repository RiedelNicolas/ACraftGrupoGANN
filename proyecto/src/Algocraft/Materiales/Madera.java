package Algocraft.Materiales;

import Algocraft.Herramientas.*;
import Algocraft.MateriaPrima.MateriaPrimaMadera;

public class Madera extends Material {

    public Madera(){
        durabilidad = 10;
        id = 1;
        materiaPrimaAsociada = new MateriaPrimaMadera();
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