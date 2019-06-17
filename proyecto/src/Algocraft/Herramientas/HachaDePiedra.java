package Algocraft.Herramientas;

import Algocraft.Desgastes.DesgastePorPorcentajeDeFuerza;
import Algocraft.Excepciones.MaterialNoSeDanioException;
import Algocraft.Materiales.Material;

public class HachaDePiedra extends Hacha {

    public HachaDePiedra(){

        durabilidad = 200;
        fuerza = 5;
        desgaste = new DesgastePorPorcentajeDeFuerza(1, fuerza);

    }

    @Override
    public void usarContra(Material material) {
        try {
            desgastar();
            material.gastarCon(this);
        } catch (MaterialNoSeDanioException e){}
    }
}