public class DesgastePorPorcentajeDeDurabilidad extends DesgastePorPorcentaje {

    public DesgastePorPorcentajeDeDurabilidad(double unPorcentaje){
        porcentaje = unPorcentaje;
    }

    @Override
    public int aplicar(int durabilidad){
        durabilidad -= (durabilidad / porcentaje);

        return durabilidad;
    }
}
