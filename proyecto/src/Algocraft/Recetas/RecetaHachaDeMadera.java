package Algocraft.Recetas;

import Algocraft.Materiales.*;
import java.util.ArrayList;
import java.util.Arrays;

public class RecetaHachaDeMadera extends Receta {

    public RecetaHachaDeMadera(){
        receta = new ArrayList<Integer>(Arrays.asList(MADERA, MADERA, VACIO,
                                                      MADERA, MADERA, VACIO,
                                                      VACIO, MADERA, VACIO));
    }
}