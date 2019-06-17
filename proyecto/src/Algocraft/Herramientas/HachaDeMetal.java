package Algocraft.Herramientas;

import Algocraft.Desgastes.DesgastePorPorcentajeDeFuerza;
import Algocraft.Excepciones.MaterialNoSeDanioException;
import Algocraft.Materiales.Material;

public class HachaDeMetal extends Hacha {

    public HachaDeMetal(){

        durabilidad = 400;
        fuerza = 10;
        desgaste = new DesgastePorPorcentajeDeFuerza(2, fuerza);

    }

    @Override
    public void usarContra(Material material) {
        try {
            desgastar();
            material.gastarCon(this);
        } catch (MaterialNoSeDanioException e){}
    }
}
