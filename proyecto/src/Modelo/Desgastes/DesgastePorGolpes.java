package Modelo.Desgastes;

import Modelo.Excepciones.HerramientaRotaException;

public class DesgastePorGolpes implements Desgaste {

    //Atributos
    private int golpesMaximos;

    //Métodos
    public DesgastePorGolpes(int unaCantidadDeGolpes){
        golpesMaximos = unaCantidadDeGolpes;
    }

    @Override
    public int aplicar(int durabilidad) {

        golpesMaximos -= 1;

        if(golpesMaximos == 0){
            return 0;
        }
        if (golpesMaximos > 0){
            return durabilidad;
        }
        throw new HerramientaRotaException();
    }

    public int calcularUsosRestantes(int _durabilidad){
        return golpesMaximos;
    }

    public int getGolpesMaximos(){
        return golpesMaximos;
    }
}
