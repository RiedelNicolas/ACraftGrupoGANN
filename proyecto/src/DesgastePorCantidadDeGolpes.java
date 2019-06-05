public class DesgastePorCantidadDeGolpes extends Desgaste {

    protected int cantidadDeGolpesMaximo;

    public DesgastePorCantidadDeGolpes(int unaCantidadDeGolpes){
        cantidadDeGolpesMaximo = unaCantidadDeGolpes;
    }

    @Override
    public double aplicar(double durabilidad, int fuerza) {
        if(cantidadDeGolpesMaximo <= 0){
            throw new GolpesMaximosExcedidosException();
        }
        else{
            return durabilidad;
        }
    }
}
