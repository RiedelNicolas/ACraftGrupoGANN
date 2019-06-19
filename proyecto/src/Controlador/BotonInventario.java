package Controlador;

import Modelo.Inventario.Utilizable;
import javafx.scene.control.Button;

public class BotonInventario extends Button {

    private static int id = 0;
    private Utilizable utilizableAsociado;

    public BotonInventario(){
        
        utilizableAsociado = null;
        id+=1;
    }

}
