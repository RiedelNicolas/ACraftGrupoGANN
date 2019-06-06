public class HachaDePiedra extends Hacha {

    public HachaDePiedra(){

        durabilidad = 200;
        fuerza = 5;
        desgaste = new DesgastePorPorcentaje(1);

    }

    @Override
    public void golpear(Material material) {
        try {
            durabilidad = desgastar();
            material.gastarCon(this);
        } catch (MaterialNoSeDanioException e){}
    }
}