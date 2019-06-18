package Modelo.Materiales;

import Modelo.Excepciones.ObjetoIncapazDeGolpearException;
import Modelo.Herramientas.*;
import Modelo.MateriaPrima.Antimateria;
import Modelo.MateriaPrima.MateriaPrima;
import Modelo.Posicion.Posicionable;

public abstract class Material implements Posicionable {

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

    public void golpear(Material material){
        throw new ObjetoIncapazDeGolpearException();
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
