package Modelo.Recetas;

import Modelo.Excepciones.RecetaIncompatibleException;
import Modelo.Herramientas.Herramienta;
import Modelo.MateriaPrima.MateriaPrima;

import java.util.ArrayList;

public abstract class Receta {

    //Atributos
    protected ArrayList<Integer> receta;
    protected Herramienta herramientaAsociada;

    protected static final int VACIO = 0;
    protected static final int MADERA = 1;
    protected static final int PIEDRA = 2;
    protected static final int METAL = 3;


    //Metodos
    public void comparar(ArrayList<MateriaPrima> materialesEnMesa) {

        int i = 0;

        while ((i < receta.size()) && (materialesEnMesa.get(i).getId() == receta.get(i))) {
            i++;
        }

        if (i != receta.size()) {
            throw new RecetaIncompatibleException();
        }
    }

    public abstract Herramienta getHerramienta();
}
