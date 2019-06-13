package Algocraft.Recetas;

import Algocraft.Excepciones.RecetaIncompatibleException;
import Algocraft.Herramientas.Herramienta;
import Algocraft.Materiales.Material;

import java.util.ArrayList;

public abstract class Receta {

    protected ArrayList<Integer> receta;
    protected Herramienta herramientaAsociada;

    protected static final int VACIO = 0;
    protected static final int MADERA = 1;
    protected static final int PIEDRA = 2;
    protected static final int METAL = 3;


    public void comparar(ArrayList<Material> materialesEnMesa){

        int i = 0;

        while((i < receta.size()) && (materialesEnMesa.get(i).getId() == receta.get(i))){
            i++;
        }

        if (i != receta.size()){
            throw new RecetaIncompatibleException();
        }
    }

    public Herramienta getHerramienta() {
        return herramientaAsociada;
    }
}
