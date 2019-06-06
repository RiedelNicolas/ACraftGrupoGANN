public class PicoFino extends Pico {

    public PicoFino (){

        durabilidad = 1000;
        fuerza = 20;
        desgaste = new DesgastePorPorcentajeDeDurabilidad(10);

    }

    @Override
    public void golpear(Material material) {
        try {
            material.gastarCon(this);
            durabilidad = desgastar();
        } catch (RuntimeException e){}
    }
}
