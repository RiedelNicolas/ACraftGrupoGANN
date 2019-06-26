package Modelo.Inventario;

import Modelo.Excepciones.InventarioLlenoException;
import Modelo.Excepciones.NoHayElementoEnPosicionDelInventarioException;
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

    public void mover(int numero) {
        posicionActual = numero;
    }

    public Utilizable getUtilizableActual(){
        if(posicionActual >= items.size()) {
            throw new NoHayElementoEnPosicionDelInventarioException();
        }
        return items.get(posicionActual);
    }

    public void quitar(){
        if(posicionActual < items.size()) {
            items.remove(posicionActual);
        }
    }

    public void equipar(Utilizable item){

        if(items.size()>=tamanioMaximo) {
            throw new InventarioLlenoException();
        }
        items.add(item);
    }

    public int getPosicionActual() {
        return posicionActual;
    }

    //PARA CONTROLADOR
    public ArrayList<Utilizable> getItems(){
        return items;
    }
}
