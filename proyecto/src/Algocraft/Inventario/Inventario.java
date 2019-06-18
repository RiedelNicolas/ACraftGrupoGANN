package Algocraft.Inventario;

import Algocraft.Herramientas.HachaDeMadera;
import Algocraft.MateriaPrima.Antimateria;

import java.util.ArrayList;

public class Inventario {

    private ArrayList<Utilizable> items;
    private int posicionActual;

    public Inventario(){

        items = new ArrayList<>();
        items.add(new HachaDeMadera());
        posicionActual = 0;
    }

    public void mover(int numero){
        posicionActual = numero;
    }

    public Utilizable herramientaEnMano(){
        return items.get(posicionActual);
    }

    public void quitar(){
        items.remove(posicionActual);
    }

    public void equipar(Utilizable item){
        items.add(item);
    }
}
