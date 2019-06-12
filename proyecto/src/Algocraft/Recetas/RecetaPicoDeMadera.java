package Algocraft.Recetas;

import Algocraft.Materiales.*;
import java.util.ArrayList;
import java.util.Arrays;

public class RecetaPicoDeMadera extends Receta {

    public RecetaPicoDeMadera(){
        receta = new ArrayList<Integer>(Arrays.asList(MADERA, MADERA, MADERA,
                                                      VACIO, MADERA, VACIO,
                                                      VACIO, MADERA, VACIO));
    }
}
