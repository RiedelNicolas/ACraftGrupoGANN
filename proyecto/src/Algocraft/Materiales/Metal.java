package Algocraft.Materiales;

import Algocraft.Herramientas.*;
import Algocraft.MateriaPrima.MateriaPrimaMetal;

public class Metal extends Material {

    public Metal (){
        durabilidad = 50;
        id = 3;
        materiaPrimaAsociada = new MateriaPrimaMetal();
    }

    @Override
    public void gastarCon(PicoDePiedra pico){
        desgastarse(pico.getFuerza());
    }
}
