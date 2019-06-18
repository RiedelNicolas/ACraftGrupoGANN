package Algocraft.Herramientas;

import Algocraft.Desgastes.DesgastePorGolpes;
import Algocraft.MateriaPrima.MateriaPrima;
import Algocraft.Materiales.Material;

public class PicoDeMetal extends Pico {

    public PicoDeMetal(){

        durabilidad = 400;
        fuerza = 12;
        desgaste = new DesgastePorGolpes(10);
    }

    @Override
    public MateriaPrima usarContra(Material material) {

        desgastar();
        return material.gastarCon(this);

    }
}
