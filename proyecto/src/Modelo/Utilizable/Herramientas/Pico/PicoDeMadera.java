package Modelo.Herramientas;

import Modelo.Desgastes.DesgastePorPorcentajeDeFuerza;
import Modelo.MateriaPrima.MateriaPrima;
import Modelo.Materiales.Material;

public class PicoDeMadera extends Pico {

    //Metodos
    public PicoDeMadera (){

        durabilidad = 100;
        fuerza = 2;
        desgaste = new DesgastePorPorcentajeDeFuerza(1, fuerza);
        usosRestantes = desgaste.calcularUsosRestantes(durabilidad);
    }

    @Override
    public MateriaPrima usarContra(Material material) {

        desgastar();

        return material.gastarCon(this);
    }
}