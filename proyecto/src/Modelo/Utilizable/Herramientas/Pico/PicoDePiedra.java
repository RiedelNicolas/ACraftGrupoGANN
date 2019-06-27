package Modelo.Herramientas;

import Modelo.Desgastes.DesgastePorPorcentajeDeFuerza;
import Modelo.MateriaPrima.MateriaPrima;
import Modelo.Materiales.Material;

public class PicoDePiedra extends Pico {

    //Metodos
    public PicoDePiedra (){

        durabilidad = 200;
        fuerza = 4;
        desgaste = new DesgastePorPorcentajeDeFuerza(1.5, fuerza);
        usosRestantes = desgaste.calcularUsosRestantes(durabilidad);
    }

    @Override
    public MateriaPrima usarContra(Material material) {

        desgastar();

        return material.gastarCon(this);
    }
}
