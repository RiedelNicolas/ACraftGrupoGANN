package Modelo.Recetas;

import Modelo.Herramientas.Herramienta;
import Modelo.Herramientas.PicoFino;

import java.util.ArrayList;
import java.util.Arrays;

public class RecetaPicoFino extends Receta {

    //Metodos
    public RecetaPicoFino(){
        receta = new ArrayList<>(Arrays.asList(METAL, METAL, METAL,
                                               PIEDRA, MADERA, VACIO,
                                               VACIO, MADERA, VACIO));
    }

    @Override
    public Herramienta getHerramienta(){
        return new PicoFino();
    }
}