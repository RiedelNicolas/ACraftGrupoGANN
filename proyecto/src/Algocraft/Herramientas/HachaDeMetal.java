package Algocraft.Herramientas;

import Algocraft.Desgastes.DesgastePorPorcentajeDeFuerza;
import Algocraft.Excepciones.HerramientaRotaException;
import Algocraft.Excepciones.MaterialNoSeDanioException;
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

        try {
            desgastar();
            return material.gastarCon(this);
        } catch (HerramientaRotaException e){
            throw e;
        }

    }
}
