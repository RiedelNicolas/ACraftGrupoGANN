package Algocraft.Inventario;

import Algocraft.MateriaPrima.MateriaPrima;
import Algocraft.Materiales.Material;

public interface Utilizable {

    public abstract MateriaPrima usarContra(Material material);

