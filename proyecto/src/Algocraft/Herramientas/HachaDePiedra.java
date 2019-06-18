package Algocraft.Herramientas;

import Algocraft.Desgastes.DesgastePorPorcentajeDeFuerza;
import Algocraft.MateriaPrima.MateriaPrima;
import Algocraft.Materiales.Material;

public class HachaDePiedra extends Hacha {

    public HachaDePiedra(){

        durabilidad = 200;
        fuerza = 5;
        desgaste = new DesgastePorPorcentajeDeFuerza(1, fuerza);

    }

    @Override
    public MateriaPrima usarContra(Material material) {

        desgastar();
        return material.gastarCon(this);

    }
}