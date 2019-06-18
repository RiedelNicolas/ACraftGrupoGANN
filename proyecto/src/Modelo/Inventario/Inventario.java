package Modelo.Inventario;

import Modelo.Excepciones.InventarioVacioException;
import Modelo.Herramientas.HachaDeMadera;

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

    public Utilizable getUtilizableActual(){
        if(items.isEmpty()) {
            throw new InventarioVacioException();
        }
        return items.get(posicionActual);
    }

    public Utilizable quitar(){
        return items.remove(posicionActual);
    }

    public void equipar(Utilizable item){
        items.add(item);
    }
}
