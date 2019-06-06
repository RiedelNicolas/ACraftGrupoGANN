public class DesgastePorGolpes extends Desgaste {

    private int golpesMaximos;

    public DesgastePorGolpes(int unaCantidadDeGolpes){
        golpesMaximos = unaCantidadDeGolpes;
    }

    @Override
    public int aplicar(int durabilidad, int fuerza) {
        if(golpesMaximos <= 0){
            throw new GolpesExcedidosException();
        }
        else{
            return durabilidad;
        }
    }

    public int getGolpesMaximos(){
        return golpesMaximos;
    }
}
