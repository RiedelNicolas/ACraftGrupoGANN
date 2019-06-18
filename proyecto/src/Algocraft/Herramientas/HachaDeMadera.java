package Algocraft.Herramientas;

import Algocraft.Desgastes.DesgastePorPorcentajeDeFuerza;
import Algocraft.MateriaPrima.MateriaPrima;
import Algocraft.Materiales.Material;

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
