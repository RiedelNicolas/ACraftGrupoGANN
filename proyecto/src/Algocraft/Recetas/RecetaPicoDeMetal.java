package Algocraft.Recetas;

import Algocraft.Herramientas.PicoDeMetal;
import Algocraft.Materiales.*;
import java.util.ArrayList;
import java.util.Arrays;

public class RecetaPicoDeMetal extends Receta {

    public RecetaPicoDeMetal(){
        herramientaAsociada = new PicoDeMetal();
        receta = new ArrayList<>(Arrays.asList(METAL, METAL, METAL,
                                                      VACIO, MADERA, VACIO,
                                                      VACIO, MADERA, VACIO));
    }
}