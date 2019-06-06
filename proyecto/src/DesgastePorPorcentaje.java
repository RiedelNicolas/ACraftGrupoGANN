public abstract class DesgastePorPorcentaje extends Desgaste {

    protected double porcentaje;

    public abstract int aplicar(int durabilidad);

    public double getPorcentaje(){
        return porcentaje;
    }

}
