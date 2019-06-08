public class DesgastePorGolpes implements Desgaste {

    //Atributos
    private int golpesMaximos;


    //Métodos
    public DesgastePorGolpes(int unaCantidadDeGolpes){
        golpesMaximos = unaCantidadDeGolpes;
    }

    @Override
    public int aplicar(int durabilidad) {
        if(golpesMaximos > 0){
            golpesMaximos -= 1;
            return durabilidad;
        }
        if(golpesMaximos == 0){
            golpesMaximos -= 1;
            return 0;
        }
        throw new HerramientaRotaException();
    }

    public int getGolpesMaximos(){
        return golpesMaximos;
    }
}
