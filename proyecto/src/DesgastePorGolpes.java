public class DesgastePorGolpes implements Desgaste {

    //Atributos
    private int golpesMaximos;


    //Métodos
    public DesgastePorGolpes(int unaCantidadDeGolpes){
        golpesMaximos = unaCantidadDeGolpes;
    }

    @Override
    public int aplicar(int durabilidad) {
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
