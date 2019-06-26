package Modelo.Desgastes;

import Modelo.Excepciones.HerramientaRotaException;

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

    public int calcularUsosRestantes(int _durabilidad){
        int durabilidadInicial = _durabilidad;
        int i = 0;

        while(durabilidadInicial > 0){
            durabilidadInicial -= (durabilidadInicial * 0.1);
            i++;
        }
        return i;
    }
}
