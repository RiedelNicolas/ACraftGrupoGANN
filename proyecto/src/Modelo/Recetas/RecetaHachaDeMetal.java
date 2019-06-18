package Modelo.Recetas;

import Modelo.Herramientas.HachaDeMetal;

import java.util.ArrayList;
import java.util.Arrays;

public class RecetaHachaDeMetal extends Receta {

    public RecetaHachaDeMetal(){
        herramientaAsociada = new HachaDeMetal();
        receta = new ArrayList<>(Arrays.asList(METAL, METAL, VACIO,
                                                      METAL, MADERA, VACIO,
                                                      VACIO, MADERA, VACIO));
    }
}