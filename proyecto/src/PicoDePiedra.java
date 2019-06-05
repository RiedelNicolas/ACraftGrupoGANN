public class PicoDePiedra extends Pico {

    public PicoDePiedra (){
        durabilidad = 200;
        fuerza = 4;
        desgaste = new DesgastePorPorcentajeDeFuerza();
    }

}
