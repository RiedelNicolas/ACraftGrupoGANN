package Modelo.Recetas;

import Modelo.Herramientas.HachaDeMetal;
import Modelo.Herramientas.Herramienta;

import java.util.ArrayList;
import java.util.Arrays;

public class RecetaHachaDeMetal extends Receta {

    //Metodos
    public RecetaHachaDeMetal(){
        receta = new ArrayList<>(Arrays.asList(METAL, METAL, VACIO,
                                               METAL, MADERA, VACIO,
                                               VACIO, MADERA, VACIO));
    }

    @Override
    public Herramienta getHerramienta(){
        return new HachaDeMetal();
    }
}