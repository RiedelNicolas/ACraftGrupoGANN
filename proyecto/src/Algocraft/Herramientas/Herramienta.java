package Algocraft.Herramientas;

import Algocraft.Desgastes.Desgaste;
import Algocraft.Materiales.Material;

public abstract class Herramienta {

    //Atributos
    protected int fuerza;

    protected int durabilidad;

    protected Desgaste desgaste;


    //Métodos
    abstract public void golpear(Material material);

    public void desgastar(){
       durabilidad = desgaste.aplicar(durabilidad);
    }

    public int getDurabilidad(){
       return durabilidad;
    }

    public int getFuerza(){
        return fuerza;
    }

}
