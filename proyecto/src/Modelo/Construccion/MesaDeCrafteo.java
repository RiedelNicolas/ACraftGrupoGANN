package Modelo.Construccion;

import Modelo.Herramientas.Herramienta;
import Modelo.MateriaPrima.Antimateria;
import Modelo.MateriaPrima.MateriaPrima;

import java.util.ArrayList;

public class MesaDeCrafteo {

    //Atributos
    private ArrayList<MateriaPrima> elementosEnMesa;
    private Constructor constructor;

    //Metodos
    public MesaDeCrafteo(){

        constructor = new Constructor();
        elementosEnMesa = new ArrayList<MateriaPrima>();

        for(int i=0; i<9; i++){
            elementosEnMesa.add(new Antimateria());
        }
    }

    public Herramienta craftear(){

        Herramienta herramienta = constructor.construirCon(elementosEnMesa);
        for(int i = 0; i < 9; i++){
            elementosEnMesa.set(i, new Antimateria());
        }

        return herramienta;
    }

    public void anadirMateriaPrima(MateriaPrima materiaPrima, int posicion){
        elementosEnMesa.set(posicion, materiaPrima);
    }

    public MateriaPrima quitarMateriaPrima(int posicion){

        MateriaPrima elementoRemovido = elementosEnMesa.get(posicion);
        elementosEnMesa.set(posicion, new Antimateria());

        return elementoRemovido;
    }
}
