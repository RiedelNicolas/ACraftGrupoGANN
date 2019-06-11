package Algocraft.Recetas;

import Algocraft.Materiales.*;
import java.util.ArrayList;
import java.util.Arrays;

public class RecetaPicoDeMadera extends Receta {

    public RecetaPicoDeMadera(){
        receta = new ArrayList<Material>(Arrays.asList(new Madera(), new Madera(), new Madera(),
                                                        new MaterialVacio(), new Madera(), new MaterialVacio(),
                                                        new MaterialVacio(), new Madera(), new MaterialVacio()));
    }
}
