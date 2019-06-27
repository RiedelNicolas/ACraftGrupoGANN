package Modelo.Recetas;

import Modelo.Herramientas.Herramienta;
import Modelo.Herramientas.PicoDeMetal;

import java.util.ArrayList;
import java.util.Arrays;

public class RecetaPicoDeMetal extends Receta {

    //Metodos
    public RecetaPicoDeMetal(){
        receta = new ArrayList<>(Arrays.asList(METAL, METAL, METAL,
                                               VACIO, MADERA, VACIO,
                                               VACIO, MADERA, VACIO));
    }

    @Override
    public Herramienta getHerramienta(){
        return new PicoDeMetal();
    }
}