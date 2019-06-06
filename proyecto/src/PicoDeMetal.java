public class PicoDeMetal extends Pico {

    public PicoDeMetal(){

        durabilidad = 400;
        fuerza = 12;
        desgaste = new DesgastePorGolpes(10);
    }

    @Override
    public void golpear(Material material) {
        try {
            durabilidad = desgastar();
            material.gastarCon(this);
        } catch (MaterialNoSeDanioException e){}
    }
}
