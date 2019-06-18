package Modelo.Inventario;

import Modelo.Construccion.MesaDeCrafteo;
import Modelo.MateriaPrima.MateriaPrima;
import Modelo.Materiales.Material;

public interface Utilizable {

    MateriaPrima usarContra(Material material);  //Hacer prueba para que si se rompe la herramienta, no se desgaste el material

    void ubicarse(MesaDeCrafteo mesa, int posicion);

}

