import java.util.ArrayList;
import java.util.Arrays;

public class RecetaPicoDeMetal extends Receta {

    public RecetaPicoDeMetal(){
        receta = new ArrayList<Material>(Arrays.asList(new Metal(), new Metal(), new Metal(),
                new MaterialVacio(), new Madera(), new MaterialVacio(),
                new MaterialVacio(), new Madera(), new MaterialVacio()));
    }
}