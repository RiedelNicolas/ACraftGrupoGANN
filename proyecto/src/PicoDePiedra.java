public class PicoDePiedra extends Pico {

    public PicoDePiedra (){
        durabilidad = 200;
        fuerza = 4;
        desgaste = new DesgastePorPorcentajeDeFuerza(1.5);
    }

    @Override
    public void golpear(Material material) {
        try {
            durabilidad = desgastar();
            material.gastarCon(this);
        } catch (MaterialNoSeDanioException e){}
    }
}
