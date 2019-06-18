package Algocraft.MateriaPrima;

import Algocraft.Excepciones.NoSePuedeGolpearConMateriaPrimaException;
import Algocraft.Inventario.Inventario;
import Algocraft.Inventario.Utilizable;
import Algocraft.Materiales.Material;

public abstract class MateriaPrima implements Utilizable {

    protected int id;

    @Override
    public MateriaPrima usarContra(Material material){

        throw new NoSePuedeGolpearConMateriaPrimaException(); //hay que ponerle un nombre a esta excepcion
    }

    public int getId(){return id;}

    public void equipar(Inventario inventario){
        inventario.equipar(this);
    }
}
