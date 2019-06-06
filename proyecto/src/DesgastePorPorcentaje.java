public abstract class DesgastePorPorcentaje implements Desgaste {

    protected double porcentaje;

    public abstract int aplicar(int durabilidad);

    public double getPorcentaje(){
        return porcentaje;
    }

}
