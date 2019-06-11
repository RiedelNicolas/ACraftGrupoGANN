import java.util.ArrayList;
import java.util.Arrays;

public class RecetaHachaDeMetal extends Receta {

    public RecetaHachaDeMetal(){
        receta = new ArrayList<Material>(Arrays.asList(new Metal(), new Metal(), new MaterialVacio(),
                new Metal(), new Madera(), new MaterialVacio(),
                new MaterialVacio(), new Madera(), new MaterialVacio()));
    }
}