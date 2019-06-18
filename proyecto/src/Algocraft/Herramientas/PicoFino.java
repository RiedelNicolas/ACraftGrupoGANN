package Algocraft.Herramientas;

import Algocraft.Desgastes.DesgastePorPorcentajeDeDurabilidad;
import Algocraft.Excepciones.HerramientaRotaException;
import Algocraft.Excepciones.MaterialNoSeDanioException;
import Algocraft.MateriaPrima.MateriaPrima;
import Algocraft.Materiales.*;

public class PicoFino extends Pico {

    public PicoFino (){

        durabilidad = 1000;
        fuerza = 20;
        desgaste = new DesgastePorPorcentajeDeDurabilidad(10);

    }

    @Override
    public MateriaPrima usarContra(Material material) {

        try {
            return material.gastarCon(this);
        } catch (HerramientaRotaException e){
            throw e;
        }

    }
}
