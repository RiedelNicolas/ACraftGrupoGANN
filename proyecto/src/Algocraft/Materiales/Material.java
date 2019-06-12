package Algocraft.Materiales;

import Algocraft.Excepciones.MaterialNoSeDanioException;
import Algocraft.Herramientas.*;
import Algocraft.PaqueteProvisorio.Posicion;
import Algocraft.PaqueteProvisorio.Posicionable;

public abstract class Material extends Posicionable {

    //Atributos
    protected int durabilidad;
    protected Posicion posicion;

    //Métodos
    public int getDurabilidad(){
        return durabilidad;
    }
    public Posicion getPosicion(){
        return posicion;
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

    
}
