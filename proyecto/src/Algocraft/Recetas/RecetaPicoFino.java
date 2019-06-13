package Algocraft.Recetas;

import Algocraft.Herramientas.PicoFino;
import Algocraft.Materiales.*;
import java.util.ArrayList;
import java.util.Arrays;

public class RecetaPicoFino extends Receta {

    public RecetaPicoFino(){
        herramientaAsociada = new PicoFino();
        receta = new ArrayList<Integer>(Arrays.asList(METAL, METAL, METAL,
                                                      PIEDRA, MADERA, VACIO,
                                                      VACIO, MADERA, VACIO));
    }
}