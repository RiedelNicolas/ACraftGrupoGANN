package Algocraft.Recetas;

import Algocraft.Materiales.*;
import java.util.ArrayList;
import java.util.Arrays;

public class RecetaPicoDeMetal extends Receta {

    public RecetaPicoDeMetal(){
        receta = new ArrayList<Integer>(Arrays.asList(METAL, METAL, METAL,
                                                      VACIO, MADERA, VACIO,
                                                      VACIO, MADERA, VACIO));
    }
}