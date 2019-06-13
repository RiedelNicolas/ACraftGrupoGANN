package Algocraft.Materiales;

import Algocraft.Excepciones.MaterialNoSeDanioException;
import Algocraft.Excepciones.MaterialRotoException;
import Algocraft.Herramientas.*;
import Algocraft.Posicion.Posicionable;

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

    public void desgastarse(int fuerza) {
        durabilidad -= fuerza;

        if (durabilidad <= 0) {
            //aca se devuelve materia prima.
            throw new MaterialRotoException();
        }
    // acá se devuelve antimateria
    //y luego el jugador le dice a las materias primas o antimateria "equipar" y se manda por parametro, y solo las materias primas se equipan gg
    }



}
