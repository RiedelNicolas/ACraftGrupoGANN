package Algocraft.MateriaPrima;

import Algocraft.Inventario.Utilizable;
import Algocraft.Materiales.Material;

public abstract class MateriaPrima implements Utilizable {

    protected int id;

    @Override
    public MateriaPrima usarContra(Material material){

        //??????????????????
        throw new RuntimeException(); //hay que ponerle un nombre a esta excepcion
    }

    public int getId(){return id;}
}
