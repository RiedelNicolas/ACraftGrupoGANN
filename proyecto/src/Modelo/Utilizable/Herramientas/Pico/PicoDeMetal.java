package Modelo.Herramientas;

import Modelo.Desgastes.DesgastePorGolpes;
import Modelo.MateriaPrima.MateriaPrima;
import Modelo.Materiales.Material;

public class PicoDeMetal extends Pico {

    //Metodos
    public PicoDeMetal(){

        durabilidad = 400;
        fuerza = 12;
        desgaste = new DesgastePorGolpes(10);
        usosRestantes = desgaste.calcularUsosRestantes(durabilidad);
    }

    @Override
    public MateriaPrima usarContra(Material material) {

        desgastar();

        return material.gastarCon(this);
    }
}
