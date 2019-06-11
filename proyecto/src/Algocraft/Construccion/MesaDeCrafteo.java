package Algocraft.Construccion;

import Algocraft.Herramientas.Herramienta;
import Algocraft.Materiales.Material;
import Algocraft.Materiales.MaterialVacio;

import java.util.ArrayList;

public class MesaDeCrafteo {

    private ArrayList<Material> elementosEnMesa;
    private Constructor constructor;


    public MesaDeCrafteo(){

        for(int i=0; i<9; i++){
            elementosEnMesa.add(new MaterialVacio());
        }
    }

    public Herramienta craftear(ArrayList<Material> elementosEnMesa){
        return constructor.construirCon(elementosEnMesa);
    }

    public void anadirMaterial(Material material, int posicion){
        elementosEnMesa.set(posicion, material);
    }

}
