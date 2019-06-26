package Modelo.Recetas;

import Modelo.Herramientas.HachaDePiedra;
import Modelo.Herramientas.Herramienta;

import java.util.ArrayList;
import java.util.Arrays;

public class RecetaHachaDePiedra extends Receta {

    //Metodos
    public RecetaHachaDePiedra(){
        herramientaAsociada = new HachaDePiedra();
        receta = new ArrayList<>(Arrays.asList(PIEDRA, PIEDRA, VACIO,
                                              PIEDRA, MADERA, VACIO,
                                               VACIO, MADERA, VACIO));
    }

    @Override
    public Herramienta getHerramienta(){
        return new HachaDePiedra();
    }
}