package Algocraft.Inventario;

import Algocraft.MateriaPrima.Antimateria;

import java.util.ArrayList;

public class Inventario {

    private ArrayList<Utilizable> items;
    private int posicionActual;

    public Inventario(){

        items = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            items.add(new Antimateria());
        }
        posicionActual = 0;
    }

    public void mover(int numero){
        posicionActual = numero;
    }

    public Utilizable herramientaEnMano(){
        return items.get(posicionActual);
    }
}
