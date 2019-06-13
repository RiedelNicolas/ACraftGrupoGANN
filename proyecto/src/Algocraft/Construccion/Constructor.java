package Algocraft.Construccion;

import Algocraft.Excepciones.ConstruccionInvalidaException;
import Algocraft.Excepciones.RecetaIncompatibleException;
import Algocraft.Herramientas.*;
import Algocraft.Materiales.Material;
import Algocraft.Recetas.*;

import java.util.ArrayList;

public class Constructor {

    private ArrayList<Receta> recetas;


    public Constructor(){
        recetas = new ArrayList<>();
        recetas.add(new RecetaPicoDeMadera());
        recetas.add(new RecetaPicoDePiedra());
        recetas.add(new RecetaPicoDeMetal());
        recetas.add(new RecetaPicoFino());
        recetas.add(new RecetaHachaDeMadera());
        recetas.add(new RecetaHachaDePiedra());
        recetas.add(new RecetaHachaDeMetal());
    }

    public Herramienta construirCon(ArrayList<Material> elementosEnMesa){  //Cada receta es unica

        for( Receta receta : recetas){
            try{
                receta.comparar(elementosEnMesa);
                return receta.getHerramienta();
            } catch (RecetaIncompatibleException e){}
        }

        throw new ConstruccionInvalidaException();
    }

    public ArrayList<Receta> getRecetas() {
        return recetas;
    }
}
