public class PicoPiedra extends Pico {

    public PicoPiedra (){
        durabilidad = 200;
        fuerza = 4;
        desgaste = new DesgastePorPorcentajeDeDurabilidad();
    }

}
