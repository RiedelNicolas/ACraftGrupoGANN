package Algocraft.MateriaPrima;

import Algocraft.Excepciones.MateriaPrimaNoEquipableException;
import Algocraft.Inventario.Inventario;

public class Antimateria extends MateriaPrima {

    public Antimateria(){
        id = 0;
    }

    @Override
    public void equipar(Inventario inventario){
        throw new MateriaPrimaNoEquipableException();
    }

}
