package Algocraft.Materiales;

import Algocraft.Herramientas.*;
import Algocraft.MateriaPrima.MateriaPrima;
import Algocraft.MateriaPrima.MateriaPrimaMetal;

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
