package Modelo.Inventario;

import Modelo.Excepciones.InventarioLlenoException;
import Modelo.Excepciones.InventarioVacioException;
import Modelo.Herramientas.HachaDeMadera;

import java.util.ArrayList;

public class Inventario {

    private ArrayList<Utilizable> items;
    private int posicionActual;
    private final int tamanioMaximo = 16;

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

        if(items.size()>=tamanioMaximo) {
            throw new InventarioLlenoException();
        }
        items.add(item);
    }

    //PARA CONTROLADOR
    public ArrayList<Utilizable> getItems(){
        return items;
    }
}
