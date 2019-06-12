package Algocraft.Recetas;

import Algocraft.Materiales.*;
import java.util.ArrayList;
import java.util.Arrays;

public class RecetaHachaDePiedra extends Receta {

    public RecetaHachaDePiedra(){
        receta = new ArrayList<Integer>(Arrays.asList(PIEDRA, PIEDRA, VACIO,
                                                      PIEDRA, MADERA, VACIO,
                                                      VACIO, MADERA, VACIO));
    }
}