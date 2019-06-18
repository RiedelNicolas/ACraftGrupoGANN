package Algocraft.Materiales;

import Algocraft.Excepciones.MaterialNoSeDanioException;
import Algocraft.Excepciones.MaterialRotoException;
import Algocraft.Herramientas.*;
import Algocraft.MateriaPrima.Antimateria;
import Algocraft.MateriaPrima.MateriaPrima;
import Algocraft.Posicion.Posicionable;

public abstract class Material extends Posicionable {

    //Atributos
    protected int durabilidad;
    protected int id;
    protected MateriaPrima materiaPrimaAsociada;

    //Métodos
    public int getDurabilidad(){
        return durabilidad;
    }

    public int getId(){
        return id;
    }

    public MateriaPrima gastarCon(HachaDeMadera hacha){
        return new Antimateria();
    }
    public MateriaPrima gastarCon(HachaDePiedra hacha){
        return new Antimateria();
    }
    public MateriaPrima gastarCon(HachaDeMetal hacha){
        return new Antimateria();
    }
    public MateriaPrima gastarCon(PicoDeMadera pico){
        return new Antimateria();
    }
    public MateriaPrima gastarCon(PicoDePiedra pico){
        return new Antimateria();
    }
    public MateriaPrima gastarCon(PicoDeMetal pico){
        return new Antimateria();
    }
    public MateriaPrima gastarCon(PicoFino pico){
        return new Antimateria();
    }

    public MateriaPrima desgastarse(int fuerza) {
        durabilidad -= fuerza;

        if (durabilidad <= 0) {
            return materiaPrimaAsociada;
        }
        return new Antimateria();
    }
}
