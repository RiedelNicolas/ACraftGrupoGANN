package Vista.Imagenes;

import Controlador.Mapa.MapaController;
import Controlador.Movimiento.WASDEventHandler;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class MapaView{

    private Group root;
    private MapaController mapaController;
    private GridPane grid;
    private double anchoGrid;
    private double altoGrid;

    private static MapaView instancia_unica = null;

    public static MapaView instanciar(Group root, double ancho, double alto){
        if(instancia_unica == null){
            instancia_unica = new MapaView(root, ancho, alto);
        }
        return instancia_unica;
    }

    private MapaView(Group root, double ancho, double alto){

        this.root = root;
        this.mapaController = new MapaController();
        this.grid = new GridPane();
        this.anchoGrid = ancho*0.78;
        this.altoGrid = alto*0.95;
        grid.setPrefSize(anchoGrid, altoGrid);
        grid.setLayoutX(ancho*0.015);
        grid.setLayoutY(alto*0.025);
        Image image = new Image("file:img/pasto.jpg");
        grid.setBackground(new Background(new BackgroundImage(image, BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT)));

        mapaController.agregarMateriales(grid, altoGrid, anchoGrid);
        root.setOnKeyPressed(new WASDEventHandler(this));
        root.getChildren().addAll(grid);
    }

    public void actualizarMapa(){
        mapaController.actualizarMapa(grid);
    }

    public void rotarJugador(char orientacion) {
        mapaController.rotarJugador(orientacion);
    }

}
