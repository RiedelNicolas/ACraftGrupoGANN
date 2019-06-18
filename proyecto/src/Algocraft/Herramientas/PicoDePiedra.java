package Algocraft.Herramientas;

import Algocraft.Desgastes.DesgastePorPorcentajeDeFuerza;
import Algocraft.Excepciones.HerramientaRotaException;
import Algocraft.Excepciones.MaterialNoSeDanioException;
import Algocraft.MateriaPrima.Antimateria;
import Algocraft.MateriaPrima.MateriaPrima;
import Algocraft.Materiales.Material;

public class PicoDePiedra extends Pico {

    public PicoDePiedra (){
        durabilidad = 200;
        fuerza = 4;
        desgaste = new DesgastePorPorcentajeDeFuerza(1.5, fuerza);
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
