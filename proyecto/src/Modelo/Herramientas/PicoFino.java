package Modelo.Herramientas;

import Modelo.Desgastes.DesgastePorPorcentajeDeDurabilidad;
import Modelo.MateriaPrima.MateriaPrima;
import Modelo.Materiales.*;

public class PicoFino extends Pico {

    public PicoFino (){

        durabilidad = 1000;
        fuerza = 20;
        desgaste = new DesgastePorPorcentajeDeDurabilidad(10);

    }

    @Override
    public MateriaPrima usarContra(Material material) {

        return material.gastarCon(this);

    }
}
