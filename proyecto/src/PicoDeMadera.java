public class PicoDeMadera extends Pico {

    public PicoDeMadera (){
        durabilidad = 100;
        fuerza = 2;
        desgaste = new DesgastePorPorcentajeDeFuerza();
    }

}