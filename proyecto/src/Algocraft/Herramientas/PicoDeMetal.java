package Algocraft.Herramientas;

import Algocraft.Desgastes.DesgastePorGolpes;
import Algocraft.Excepciones.MaterialNoSeDanioException;
import Algocraft.Materiales.Material;

public class PicoDeMetal extends Pico {

    public PicoDeMetal(){

        durabilidad = 400;
        fuerza = 12;
        desgaste = new DesgastePorGolpes(10);
    }

    @Override
    public void usarContra(Material material) {
        try {
            desgastar();
            material.gastarCon(this);
        } catch (MaterialNoSeDanioException e){}
    }
}
