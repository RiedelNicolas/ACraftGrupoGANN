package Algocraft.Herramientas;

import Algocraft.Desgastes.DesgastePorPorcentajeDeDurabilidad;
import Algocraft.Excepciones.MaterialNoSeDanioException;
import Algocraft.Materiales.*;

public class PicoFino extends Pico {

    public PicoFino (){

        durabilidad = 1000;
        fuerza = 20;
        desgaste = new DesgastePorPorcentajeDeDurabilidad(10);

    }

    @Override
    public void usarContra(Material material) {
        try {
            material.gastarCon(this);
        } catch (MaterialNoSeDanioException e){}
    }
}
