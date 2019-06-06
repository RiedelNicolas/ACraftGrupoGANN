public class DesgastePorPorcentaje extends Desgaste {

    protected double porcentaje;

    public DesgastePorPorcentaje(double unPorcentaje){
        porcentaje = unPorcentaje;
    }

    @Override
    public int aplicar(int durabilidad, int fuerza){
        durabilidad -= (fuerza / porcentaje);

        return durabilidad;
    }
}
