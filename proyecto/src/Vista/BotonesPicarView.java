package Vista;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

public class BotonesPicarView extends Node {

    private BorderPane pane;
    private static BotonesPicarView instancia_unica = null;

    public static BotonesPicarView crearUnico(Group root){
        if(instancia_unica==null){
            instancia_unica = new BotonesPicarView(root);
        }
        return instancia_unica;
    }

    BotonesPicarView(Group root){

        Button flechaArriba = new Button();
        Button flechaAbajo = new Button();
        Button flechaIzquierda = new Button();
        Button flechaDerecha = new Button();

        flechaArriba.setGraphic(new ImageView(new Image("file:img/flechaArriba.jpg")));
        flechaAbajo.setGraphic(new ImageView(new Image(("file:img/flechaAbajo.jpg"))));
        flechaIzquierda.setGraphic(new ImageView(new Image("file:img/flechaIzquierda.jpg")));
        flechaDerecha.setGraphic(new ImageView(new Image("file:img/flechaDerecha.jpg")));

        pane = new BorderPane();
        pane.setPrefSize(500,500);
        pane.setTop(flechaArriba);
        pane.setBottom(flechaAbajo);
        pane.setLeft(flechaIzquierda);
        pane.setRight(flechaDerecha);

        root.getChildren().add(pane);
    }
}
