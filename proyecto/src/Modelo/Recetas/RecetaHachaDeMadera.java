package Modelo.Recetas;

import Modelo.Herramientas.HachaDeMadera;
import Modelo.Herramientas.Herramienta;

import java.util.ArrayList;
import java.util.Arrays;

public class RecetaHachaDeMadera extends Receta {

    //Metodos
    public RecetaHachaDeMadera(){
        herramientaAsociada = new HachaDeMadera();
        receta = new ArrayList<>(Arrays.asList(MADERA, MADERA, VACIO,
                                               MADERA, MADERA, VACIO,
                                                VACIO, MADERA, VACIO));
    }

    @Override
    public Herramienta getHerramienta(){
        return new HachaDeMadera();
    }
}