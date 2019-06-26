package Modelo.Construccion;

import Modelo.Excepciones.MaterialRotoException;
import Modelo.Herramientas.Herramienta;
import Modelo.MateriaPrima.Antimateria;
import Modelo.MateriaPrima.MateriaPrima;

import java.util.ArrayList;

public class MesaDeCrafteo {

    private ArrayList<MateriaPrima> elementosEnMesa;
    private Constructor constructor;


    public MesaDeCrafteo(){

        constructor = new Constructor();
        elementosEnMesa = new ArrayList<MateriaPrima>();

        for(int i=0; i<9; i++){
            elementosEnMesa.add(new Antimateria());
        }
    }

    public Herramienta craftear(){
        return constructor.construirCon(elementosEnMesa);
    }

    public void anadirMateriaPrima(MateriaPrima materiaPrima, int posicion){
        elementosEnMesa.set(posicion, materiaPrima);
    }

    public MateriaPrima quitarMateriaPrima(int posicion){

        MateriaPrima elementoRemovido = elementosEnMesa.get(posicion);
        elementosEnMesa.add(posicion, new Antimateria());

        return elementoRemovido;
    }
}
