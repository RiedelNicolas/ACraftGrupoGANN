package Algocraft.Materiales;

import Algocraft.Excepciones.MaterialNoSeDanioException;
import Algocraft.Excepciones.MaterialRotoException;
import Algocraft.Herramientas.*;
import Algocraft.PaqueteProvisorio.Posicion;
import Algocraft.PaqueteProvisorio.Posicionable;

public abstract class Material extends Posicionable {

    //Atributos
    protected int durabilidad;
    protected int id;

    //Métodos
    public int getDurabilidad(){
        return durabilidad;
    }

    public int getId(){
        return id;
    }

    public void gastarCon(HachaDeMadera hacha){
        throw new MaterialNoSeDanioException();
    }
    public void gastarCon(HachaDePiedra hacha){
        throw new MaterialNoSeDanioException();
    }
    public void gastarCon(HachaDeMetal hacha){
        throw new MaterialNoSeDanioException();
    }
    public void gastarCon(PicoDeMadera pico){
        throw new MaterialNoSeDanioException();
    }
    public void gastarCon(PicoDePiedra pico){
        throw new MaterialNoSeDanioException();
    }
    public void gastarCon(PicoDeMetal pico){
        throw new MaterialNoSeDanioException();
    }
    public void gastarCon(PicoFino pico){
        throw new MaterialNoSeDanioException();
    }

    public void desgastarse(int fuerza){
        durabilidad -= fuerza;

        if(durabilidad <= 0){
            throw new MaterialRotoException();
        }
    }



}
