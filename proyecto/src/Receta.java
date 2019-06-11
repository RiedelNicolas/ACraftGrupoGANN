import java.util.ArrayList;

public abstract class Receta {

    protected ArrayList<Material> receta;


    public boolean comparar(ArrayList<Material> materialesEnMesa){

        int i = 0;

        while(materialesEnMesa.get(i).getClass().equals(receta.get(i).getClass())){
            i++;
        }

        return (i==9);
    }
}
