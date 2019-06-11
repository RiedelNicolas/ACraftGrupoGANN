import java.util.ArrayList;
import java.util.Arrays;

public class RecetaPicoDePiedra extends Receta {

    public RecetaPicoDePiedra(){
        receta = new ArrayList<Material>(Arrays.asList(new Piedra(), new Piedra(), new Piedra(),
                new MaterialVacio(), new Madera(), new MaterialVacio(),
                new MaterialVacio(), new Madera(), new MaterialVacio()));
    }
}