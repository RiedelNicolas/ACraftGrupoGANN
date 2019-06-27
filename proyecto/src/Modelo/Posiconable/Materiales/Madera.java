package Modelo.Materiales;

import Modelo.Herramientas.*;
import Modelo.MateriaPrima.MateriaPrima;
import Modelo.MateriaPrima.MateriaPrimaMadera;

public class Madera extends Material {

    //Metodos
    public Madera(){

        durabilidad = 10;
        id = 1;
        materiaPrimaAsociada = new MateriaPrimaMadera();
    }

    @Override
    public MateriaPrima gastarCon(HachaDeMadera hacha){
        return desgastarse(hacha.getFuerza());
    }

    @Override
    public MateriaPrima gastarCon(HachaDePiedra hacha){
        return desgastarse(hacha.getFuerza());
    }

    @Override
    public MateriaPrima gastarCon(HachaDeMetal hacha) {
        return desgastarse(hacha.getFuerza());
    }
}