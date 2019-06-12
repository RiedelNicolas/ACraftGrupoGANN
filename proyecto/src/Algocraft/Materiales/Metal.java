package Algocraft.Materiales;

import Algocraft.Herramientas.*;

public class Metal extends Material {

    public Metal (){
        durabilidad = 50;
    }

    @Override
    public void gastarCon(PicoDePiedra pico){
        desgastarse(pico.getFuerza());
    }
}
