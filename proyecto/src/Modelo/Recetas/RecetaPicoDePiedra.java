package Modelo.Recetas;

import Modelo.Herramientas.Herramienta;
import Modelo.Herramientas.PicoDePiedra;

import java.util.ArrayList;
import java.util.Arrays;

public class RecetaPicoDePiedra extends Receta {

    public RecetaPicoDePiedra(){
        herramientaAsociada = new PicoDePiedra();
        receta = new ArrayList<>(Arrays.asList(PIEDRA, PIEDRA, PIEDRA,
                                                      VACIO, MADERA, VACIO,
                                                      VACIO, MADERA, VACIO));
    }


    @Override
    public Herramienta getHerramienta(){
        return new PicoDePiedra();
    }
}