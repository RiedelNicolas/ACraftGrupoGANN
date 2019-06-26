package Modelo.Desgastes;

import Modelo.Excepciones.HerramientaRotaException;

public class DesgastePorPorcentajeDeFuerza extends DesgastePorPorcentaje{

    //Atributos
    private int fuerza;

    //Metodos
    public DesgastePorPorcentajeDeFuerza(double unPorcentaje, int unaFuerza){
        porcentaje = unPorcentaje;
        fuerza = unaFuerza;
    }

    @Override
    public int aplicar(int durabilidad){
        durabilidad -= (fuerza / porcentaje);
        if(durabilidad < 0){
            throw new HerramientaRotaException();
        }

        return durabilidad;
    }

    public int calcularUsosRestantes(int _durabilidad){
        return (int)(_durabilidad / (fuerza / porcentaje));
    }
}
