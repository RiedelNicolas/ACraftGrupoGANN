public class HachaDeMadera extends Hacha {

    public HachaDeMadera(){

        durabilidad = 100;
        fuerza = 2;
        desgaste = new DesgastePorPorcentajeDeFuerza(1, fuerza);
    }

    @Override
    public void golpear(Material material) {
        try {
            durabilidad = desgastar();
            material.gastarCon(this);
        } catch (MaterialNoSeDanioException e){}
    }
}
