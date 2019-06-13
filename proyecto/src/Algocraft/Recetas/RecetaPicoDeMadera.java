package Algocraft.Recetas;

import Algocraft.Herramientas.PicoDeMadera;

import java.util.ArrayList;
import java.util.Arrays;

public class RecetaPicoDeMadera extends Receta {

    public RecetaPicoDeMadera(){
        herramientaAsociada = new PicoDeMadera();
        receta = new ArrayList<Integer>(Arrays.asList(MADERA, MADERA, MADERA,
                                                      VACIO, MADERA, VACIO,
                                                      VACIO, MADERA, VACIO));
    }
}
