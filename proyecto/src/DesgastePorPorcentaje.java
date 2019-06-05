public class DesgastePorPorcentaje extends Desgaste {

    protected double porcentaje;

    public DesgastePorPorcentaje(double unPorcentaje){
        porcentaje = unPorcentaje;
    }

    @Override
    public double aplicar(double durabilidad, int fuerza){
        durabilidad -= (fuerza / porcentaje);

        return durabilidad;
    }
}
