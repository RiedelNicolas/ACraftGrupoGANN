public class DesgastePorGolpes extends Desgaste {

    private int golpesMaximos;

    public DesgastePorGolpes(int unaCantidadDeGolpes){
        golpesMaximos = unaCantidadDeGolpes;
    }

    @Override
    public int aplicar(int durabilidad, int fuerza) {
        if(golpesMaximos <= 0){
            return 0;
        }
        else{
            golpesMaximos -= 1;
            return durabilidad;
        }
    }

    public int getGolpesMaximos(){
        return golpesMaximos;
    }
}
