package Algocraft.Recetas;

import Algocraft.Materiales.Material;

import java.util.ArrayList;

public abstract class Receta {

    protected ArrayList<Integer> receta;

    protected static final int VACIO = 0;
    protected static final int MADERA = 1;
    protected static final int PIEDRA = 2;
    protected static final int METAL = 3;


    public boolean comparar(ArrayList<Material> materialesEnMesa){

        int i = 0;

        while(i<9 && materialesEnMesa.get(i).getId() == receta.get(i)){
            i++;
        }

        return (i==9);
    }
}
