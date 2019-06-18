package Modelo.Materiales;

import Modelo.Herramientas.*;
import Modelo.MateriaPrima.MateriaPrima;
import Modelo.MateriaPrima.MateriaPrimaMetal;

public class Metal extends Material {

    public Metal (){
        durabilidad = 50;
        id = 3;
        materiaPrimaAsociada = new MateriaPrimaMetal();
    }

    @Override
    public MateriaPrima gastarCon(PicoDePiedra pico){
        return desgastarse(pico.getFuerza());
    }
}
