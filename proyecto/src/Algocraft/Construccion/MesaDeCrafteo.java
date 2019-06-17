package Algocraft.Construccion;

import Algocraft.Herramientas.Herramienta;
import Algocraft.Materiales.Material;
import Algocraft.Materiales.MaterialVacio;

import java.util.ArrayList;

public class MesaDeCrafteo {

    private ArrayList<Material> elementosEnMesa;
    private Constructor constructor;


    public MesaDeCrafteo(){

        constructor = new Constructor();
        elementosEnMesa = new ArrayList<Material>();

        for(int i=0; i<9; i++){
            elementosEnMesa.add(new MaterialVacio());
        }
    }

    public Herramienta craftear(){
        return constructor.construirCon(elementosEnMesa);
    }

    public void anadirMaterial(Material material, int posicion){
        elementosEnMesa.set(posicion, material);
    }

    public Material quitarMaterial(int posicion){

        Material elementoRemovido = elementosEnMesa.get(posicion);
        elementosEnMesa.add(posicion, new MaterialVacio());

        return elementoRemovido;
    }
}
