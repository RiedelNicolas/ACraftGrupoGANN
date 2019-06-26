package Vista;

import Controlador.BotonInventario;
import Controlador.Transportador;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class InventarioView extends GridPane{

    private final int anchoGrid = 4;
    private final int altoGrid = 4;
    private static InventarioView instancia_unica = null;
    private Transportador transportador;

    public static InventarioView instaciar(Group root, double ancho, double alto){
        if(instancia_unica==null){
            instancia_unica = new InventarioView(root, ancho, alto);
        }
        return instancia_unica;
    }

    private InventarioView(Group root, double ancho, double alto){

        this.transportador = new Transportador();
        ImageView labelImagen = new ImageView();
        Label labelEnMano = new Label("HachaDeMadera");
        Label labelUsos = new Label("50");
        labelImagen.setImage(new Image("file:img/HachaDeMadera.png"));

        for(int i=0; i<altoGrid; i++){
            for(int j=0; j<anchoGrid; j++) {
                this.add(new BotonInventario(ancho, labelImagen, labelEnMano, labelUsos, transportador), j, i, 1, 1);
            }
        }

        labelImagen.setFitWidth(ancho*0.025);
        labelImagen.setFitHeight(ancho*0.025);
        labelImagen.setX(ancho*0.885);
        labelImagen.setY(alto*0.63);

        labelEnMano.setLayoutX(ancho*0.8705);
        labelEnMano.setLayoutY(alto*0.81);
        labelEnMano.setTextFill(Color.WHITE);
        labelEnMano.setStyle("-fx-font-weight: bold;");
        labelEnMano.setFont(new Font(14));

        labelUsos.setLayoutX(ancho*0.905);
        labelUsos.setLayoutY(alto*0.84);
        labelUsos.setTextFill(Color.WHITE);
        labelUsos.setStyle("-fx-font-weight: bold;");
        labelUsos.setFont(new Font(14));

        root.getChildren().addAll(labelImagen, labelEnMano, labelUsos);
    }

    public void actualizarInventario(){

        ObservableList<Node> botones = this.getChildren();

        for(Node hijo:botones){
            BotonInventario boton = (BotonInventario)hijo;
            boton.actualizar();
        }
    }

    public Transportador getTransportador(){
        return transportador;
    }

}
