package Modelo.Herramientas;

import Modelo.Construccion.MesaDeCrafteo;
import Modelo.Desgastes.Desgaste;
import Modelo.Excepciones.NoSePuedeAnadirUtilizableAMesa;
import Modelo.Inventario.Utilizable;

public abstract class Herramienta implements Utilizable {

    //Atributos
    protected int fuerza;

    protected int durabilidad;

    protected Desgaste desgaste;


    //Métodos

    public void desgastar(){

        durabilidad = desgaste.aplicar(durabilidad);
    }

    public int getDurabilidad(){
       return durabilidad;
    }

    public int getFuerza(){
        return fuerza;
    }

    @Override
    public void ubicarse(MesaDeCrafteo mesa, int posicion){
        throw new NoSePuedeAnadirUtilizableAMesa();
    }

}
