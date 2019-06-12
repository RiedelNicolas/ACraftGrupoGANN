package Algocraft.Recetas;

import Algocraft.Materiales.*;
import java.util.ArrayList;
import java.util.Arrays;

public class RecetaHachaDeMetal extends Receta {

    public RecetaHachaDeMetal(){
        receta = new ArrayList<Integer>(Arrays.asList(METAL, METAL, VACIO,
                                                      METAL, MADERA, VACIO,
                                                      VACIO, MADERA, VACIO));
    }
}