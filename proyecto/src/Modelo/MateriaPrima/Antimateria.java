package Modelo.MateriaPrima;

import Modelo.Excepciones.MateriaPrimaNoEquipableException;
import Modelo.Inventario.Inventario;

public class Antimateria extends MateriaPrima {

    public Antimateria(){
        id = 0;
    }

    @Override
    public void equipar(Inventario inventario){
        throw new MateriaPrimaNoEquipableException();
    }

}
