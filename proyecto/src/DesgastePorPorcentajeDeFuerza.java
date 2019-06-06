public class DesgastePorPorcentajeDeFuerza extends DesgastePorPorcentaje{

    private int fuerza;

    public DesgastePorPorcentajeDeFuerza(double unPorcentaje, int _fuerza){
        porcentaje = unPorcentaje;
        fuerza = _fuerza;
    }

    @Override
    public int aplicar(int durabilidad){
        durabilidad -= (fuerza / porcentaje);

        return durabilidad;
    }
}
