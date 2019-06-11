package Algocraft.Recetas;

import Algocraft.Materiales.*;
import java.util.ArrayList;
import java.util.Arrays;

public class RecetaPicoFino extends Receta {

    public RecetaPicoFino(){
        receta = new ArrayList<Material>(Arrays.asList(new Metal(), new Metal(), new Metal(),
                new Piedra(), new Madera(), new MaterialVacio(),
                new MaterialVacio(), new Madera(), new MaterialVacio()));
    }
}