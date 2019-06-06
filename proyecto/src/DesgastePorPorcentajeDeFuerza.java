public class DesgastePorPorcentajeDeFuerza extends DesgastePorPorcentaje{

    public DesgastePorPorcentajeDeFuerza(double unPorcentaje){
        porcentaje = unPorcentaje;
    }

    @Override
    public int aplicar(int durabilidad, int fuerza){
        durabilidad -= (fuerza / porcentaje);

        return durabilidad;
    }
}
