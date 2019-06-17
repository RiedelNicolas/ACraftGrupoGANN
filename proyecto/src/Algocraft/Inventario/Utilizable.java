package Algocraft.Inventario;

import Algocraft.MateriaPrima.MateriaPrima;
import Algocraft.Materiales.Material;

public interface Utilizable {

    MateriaPrima usarContra(Material material);
}
