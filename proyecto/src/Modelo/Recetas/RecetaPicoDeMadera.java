package Modelo.Recetas;

import Modelo.Herramientas.Herramienta;
import Modelo.Herramientas.Pico;
import Modelo.Herramientas.PicoDeMadera;

import java.util.ArrayList;
import java.util.Arrays;

public class RecetaPicoDeMadera extends Receta {

    public RecetaPicoDeMadera(){
        herramientaAsociada = new PicoDeMadera();
        receta = new ArrayList<>(Arrays.asList(MADERA, MADERA, MADERA,
                                                      VACIO, MADERA, VACIO,
                                                      VACIO, MADERA, VACIO));
    }


    @Override
    public Herramienta getHerramienta(){
        return new PicoDeMadera();
    }
}
