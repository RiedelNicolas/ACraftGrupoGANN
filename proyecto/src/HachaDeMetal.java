public class HachaDeMetal extends Hacha {

    public HachaDeMetal(){

        durabilidad = 400;
        fuerza = 10;
        desgaste = new DesgastePorPorcentaje(2);

    }

    @Override
    public void golpear(Material material) {
        try {
            durabilidad = desgastar();
            material.gastarCon(this);
        } catch (MaterialNoSeDanioException e){}
    }
}
