package Algocraft.Recetas;

import Algocraft.Materiales.Material;

import java.util.ArrayList;

public abstract class Receta {

    protected ArrayList<Material> receta;


    public boolean comparar(ArrayList<Material> materialesEnMesa){

        int i = 0;

        while(i<9 && materialesEnMesa.get(i).getClass().equals(receta.get(i).getClass())){
            i++;
        }

        return (i==9);
    }
}