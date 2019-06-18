package Algocraft.Inventario;

import Algocraft.Construccion.MesaDeCrafteo;
import Algocraft.MateriaPrima.MateriaPrima;
import Algocraft.Materiales.Material;

public interface Utilizable {

    MateriaPrima usarContra(Material material);
    void ubicarse(MesaDeCrafteo mesa, int posicion);

}

