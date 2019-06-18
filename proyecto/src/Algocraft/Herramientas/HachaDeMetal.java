package Algocraft.Herramientas;

import Algocraft.Desgastes.DesgastePorPorcentajeDeFuerza;
import Algocraft.MateriaPrima.MateriaPrima;
import Algocraft.Materiales.Material;

public class HachaDeMetal extends Hacha {

    public HachaDeMetal(){

        durabilidad = 400;
        fuerza = 10;
        desgaste = new DesgastePorPorcentajeDeFuerza(2, fuerza);

    }

    @Override
    public MateriaPrima usarContra(Material material) {

        desgastar();
        return material.gastarCon(this);

    }
}
