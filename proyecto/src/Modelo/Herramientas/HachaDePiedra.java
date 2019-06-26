package Modelo.Herramientas;

import Modelo.Desgastes.DesgastePorPorcentajeDeFuerza;
import Modelo.MateriaPrima.MateriaPrima;
import Modelo.Materiales.Material;

public class HachaDePiedra extends Hacha {

    public HachaDePiedra(){

        durabilidad = 200;
        fuerza = 5;
        desgaste = new DesgastePorPorcentajeDeFuerza(1, fuerza);
        usosRestantes = desgaste.calcularUsosRestantes(durabilidad);
    }

    @Override
    public MateriaPrima usarContra(Material material) {

        desgastar();
        return material.gastarCon(this);

    }
}