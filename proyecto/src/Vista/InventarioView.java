package Vista;

import Controlador.BotonInventario;
import javafx.scene.Group;
import javafx.scene.layout.GridPane;

public class InventarioView {

    private GridPane grid;
    Group root;
    private static InventarioView instancia_unica = null;

    public static InventarioView instaciar(Group root, double ancho, double alto){
        if(instancia_unica==null){
            instancia_unica = new InventarioView(root, ancho, alto);
        }
        return instancia_unica;
    }

    private InventarioView(Group root, double ancho, double alto){

        this.grid = new GridPane();
        this.root = root;

        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++) {
                grid.add(new BotonInventario(), j, i, 1, 1);
            }
        }

        grid.setLayoutX(ancho*0.825);
        grid.setLayoutY(alto*0.16);

        root.getChildren().add(grid);
    }

}
