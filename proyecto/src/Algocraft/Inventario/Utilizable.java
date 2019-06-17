package Algocraft.Inventario;

import Algocraft.MateriaPrima.MateriaPrima;
import Algocraft.Materiales.Material;

public abstract class Utilizable {

    public abstract MateriaPrima usarContra(Material material);
}
