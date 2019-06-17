package Algocraft.Herramientas;

import Algocraft.Desgastes.DesgastePorPorcentajeDeFuerza;
import Algocraft.Excepciones.MaterialNoSeDanioException;
import Algocraft.Materiales.Material;

public class PicoDePiedra extends Pico {

    public PicoDePiedra (){
        durabilidad = 200;
        fuerza = 4;
        desgaste = new DesgastePorPorcentajeDeFuerza(1.5, fuerza);
    }

    @Override
    public void usarContra(Material material) {
        try {
            desgastar();
            material.gastarCon(this);
        } catch (MaterialNoSeDanioException e){}
    }
}
