package Modelo.Construccion;

import Modelo.Excepciones.ConstruccionInvalidaException;
import Modelo.Excepciones.RecetaIncompatibleException;
import Modelo.Herramientas.*;
import Modelo.MateriaPrima.MateriaPrima;
import Modelo.Recetas.*;

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

    public Herramienta construirCon(ArrayList<MateriaPrima> elementosEnMesa){  //Cada receta es unica

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
