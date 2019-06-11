package Algocraft.Recetas;

import Algocraft.Materiales.*;
import java.util.ArrayList;
import java.util.Arrays;

public class RecetaHachaDeMadera extends Receta {

    public RecetaHachaDeMadera(){
        receta = new ArrayList<Material>(Arrays.asList(new Madera(), new Madera(), new MaterialVacio(),
                new Madera(), new Madera(), new MaterialVacio(),
                new MaterialVacio(), new Madera(), new MaterialVacio()));
    }
}