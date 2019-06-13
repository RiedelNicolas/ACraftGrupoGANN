package Algocraft.Recetas;

import Algocraft.Herramientas.HachaDeMadera;
import java.util.ArrayList;
import java.util.Arrays;

public class RecetaHachaDeMadera extends Receta {

    public RecetaHachaDeMadera(){
        herramientaAsociada = new HachaDeMadera();
        receta = new ArrayList<Integer>(Arrays.asList(MADERA, MADERA, VACIO,
                                                      MADERA, MADERA, VACIO,
                                                      VACIO, MADERA, VACIO));
    }
}