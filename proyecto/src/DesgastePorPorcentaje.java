public class DesgastePorPorcentaje extends Desgaste {

    protected double porcentaje;

    public DesgastePorPorcentaje(double unPorcentaje){
        porcentaje = unPorcentaje;
    }

    @Override
    public double aplicar(int durabilidad, int fuerza){
        durabilidad -= (fuerza / porcentaje);

        return durabilidad;
    }
}
