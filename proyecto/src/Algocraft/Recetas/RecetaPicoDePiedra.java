package Algocraft.Recetas;

import Algocraft.Materiales.*;
import java.util.ArrayList;
import java.util.Arrays;

public class RecetaPicoDePiedra extends Receta {

    public RecetaPicoDePiedra(){
        receta = new ArrayList<Integer>(Arrays.asList(PIEDRA, PIEDRA, PIEDRA,
                                                      VACIO, MADERA, VACIO,
                                                      VACIO, MADERA, VACIO));
    }
}