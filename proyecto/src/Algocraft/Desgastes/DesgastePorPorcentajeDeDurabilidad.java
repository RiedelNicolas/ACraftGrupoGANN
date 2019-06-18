package Algocraft.Desgastes;

import Algocraft.Excepciones.HerramientaRotaException;

public class DesgastePorPorcentajeDeDurabilidad extends DesgastePorPorcentaje {

    public DesgastePorPorcentajeDeDurabilidad(double unPorcentaje){
        porcentaje = unPorcentaje;
    }

    @Override
    public int aplicar(int durabilidad){
        if(durabilidad == 0){
            throw new HerramientaRotaException();
        }
        durabilidad -= (durabilidad / porcentaje);
        return durabilidad;
    }
}
