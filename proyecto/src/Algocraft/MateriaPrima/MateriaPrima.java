package Algocraft.MateriaPrima;

import Algocraft.Construccion.MesaDeCrafteo;
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

    @Override
    public void ubicarse(MesaDeCrafteo mesa, int posicion){
        mesa.anadirMateriaPrima(this, posicion);
    }

    public int getId(){return id;}

    public void equipar(Inventario inventario){
        inventario.equipar(this);
    }
}
