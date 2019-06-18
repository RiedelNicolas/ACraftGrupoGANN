package Modelo.Herramientas;

import Modelo.Desgastes.DesgastePorPorcentajeDeFuerza;
import Modelo.MateriaPrima.MateriaPrima;
import Modelo.Materiales.Material;

public class HachaDeMadera extends Hacha {

    public HachaDeMadera(){

        durabilidad = 100;
        fuerza = 2;
        desgaste = new DesgastePorPorcentajeDeFuerza(1, fuerza);
    }

    @Override
    public MateriaPrima usarContra(Material material) {

        desgastar();
        return material.gastarCon(this);

    }
}
