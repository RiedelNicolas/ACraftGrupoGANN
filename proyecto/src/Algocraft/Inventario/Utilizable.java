package Algocraft.Inventario;

import Algocraft.MateriaPrima.MateriaPrima;
import Algocraft.Materiales.Material;

public interface Utilizable {

    MateriaPrima usarContra(Material material);  //Hacer prueba para que si se rompe la herramienta, no se desgaste el material

}

