package Modelo.Inventario;

import Modelo.Construccion.MesaDeCrafteo;
import Modelo.MateriaPrima.MateriaPrima;
import Modelo.Materiales.Material;

public interface Utilizable {

    //Metodos
    MateriaPrima usarContra(Material material);

    void ubicarse(MesaDeCrafteo mesa, int posicion);

    //PARA CONTROLADOR
    int getUsosRestantes();
}

