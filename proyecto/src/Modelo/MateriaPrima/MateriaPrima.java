package Modelo.MateriaPrima;

import Modelo.Construccion.MesaDeCrafteo;
import Modelo.Excepciones.ObjetoIncapazDeGolpearException;
import Modelo.Inventario.Inventario;
import Modelo.Inventario.Utilizable;
import Modelo.Materiales.Material;

public abstract class MateriaPrima implements Utilizable {

    //Atributos
    protected int id;

    //Metodos
    @Override
    public MateriaPrima usarContra(Material material){

        throw new ObjetoIncapazDeGolpearException();
    }

    @Override
    public void ubicarse(MesaDeCrafteo mesa, int posicion){

        mesa.anadirMateriaPrima(this, posicion);
    }

    public int getId(){ return id; }

    public void equipar(Inventario inventario){
        inventario.equipar(this);
    }

    //PARA EL CONTROLADOR
    @Override
    public int getUsosRestantes(){
        return 0;
    }
}
