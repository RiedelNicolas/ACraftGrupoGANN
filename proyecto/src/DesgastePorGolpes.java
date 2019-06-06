public class DesgastePorGolpes implements Desgaste {

    //Atributos
    private int golpesMaximos;


    //Métodos
    public DesgastePorGolpes(int unaCantidadDeGolpes){
        golpesMaximos = unaCantidadDeGolpes;
    }

    @Override
    public int aplicar(int durabilidad) {

        golpesMaximos -= 1;

        if(golpesMaximos == 0){
            return 0;
        }
        if (golpesMaximos > 0){
            return durabilidad;
        }
        throw new GolpesExcedidosException();
    }

    public int getGolpesMaximos(){
        return golpesMaximos;
    }
}
