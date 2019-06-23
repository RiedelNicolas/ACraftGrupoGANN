package Vista;

import Controlador.*;
import Modelo.Juego.Juego;
import Modelo.Tablero.Mapa;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class BotoneraDeAccionesView {

    private BorderPane pane;
    private MapaView mapaView;

    public BotoneraDeAccionesView(Group root, double ancho, double alto){

        pane = new BorderPane();
        mapaView = MapaView.crearUnico(root, ancho, alto);

        pane.setLayoutX(ancho*0.825);
        pane.setLayoutY(alto*0.575);
        pane.setPrefSize(ancho*0.148,ancho*0.148);
        inicializarBotones(ancho);

        root.getChildren().add(pane);
    }

    private void inicializarBotones(double ancho){

        BotonDeAccion flechaArriba = new BotonDeAccion("file:img/flechaArriba.png", ancho);
        BotonDeAccion flechaAbajo = new BotonDeAccion("file:img/flechaAbajo.png", ancho);
        BotonDeAccion flechaIzquierda = new BotonDeAccion("file:img/flechaIzquierda.png", ancho);
        BotonDeAccion flechaDerecha = new BotonDeAccion("file:img/flechaDerecha.png", ancho);

        flechaArriba.setOnAction(new BotonAccionArribaHandler(mapaView));
        flechaAbajo.setOnAction(new BotonAccionAbajoHandler(mapaView));
        flechaDerecha.setOnAction(new BotonAccionDerechaHandler(mapaView));
        flechaIzquierda.setOnAction(new BotonAccionIzquierdaHandler(mapaView));

        pane.setTop(flechaArriba);
        pane.setBottom(flechaAbajo);
        pane.setLeft(flechaIzquierda);
        pane.setRight(flechaDerecha);
        BorderPane.setAlignment(flechaArriba, Pos.TOP_CENTER);
        BorderPane.setAlignment(flechaAbajo, Pos.BOTTOM_CENTER);
    }
}
