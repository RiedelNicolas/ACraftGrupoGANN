package Modelo.Recetas;

import Modelo.Herramientas.PicoFino;

import java.util.ArrayList;
import java.util.Arrays;

public class RecetaPicoFino extends Receta {

    public RecetaPicoFino(){
        herramientaAsociada = new PicoFino();
        receta = new ArrayList<>(Arrays.asList(METAL, METAL, METAL,
                                                      PIEDRA, MADERA, VACIO,
                                                      VACIO, MADERA, VACIO));
    }
}