package Controlador;

import Modelo.Juego.Juego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.layout.BorderPane;

public class BotoneraDeAcciones {

    private BorderPane pane;

    public BotoneraDeAcciones(Group root, double ancho, double alto){

        pane = new BorderPane();

        pane.setLayoutX(ancho*0.825);
        pane.setLayoutY(alto*0.6);
        pane.setPrefSize(ancho*0.148,ancho*0.148);
        inicializarBotones(ancho);

        root.getChildren().add(pane);
    }

    private void inicializarBotones(double ancho){

        BotonDeAccion flechaArriba = new BotonDeAccion("file:img/flechaArriba.png", ancho);
        BotonDeAccion flechaAbajo = new BotonDeAccion("file:img/flechaAbajo.png", ancho);
        BotonDeAccion flechaIzquierda = new BotonDeAccion("file:img/flechaIzquierda.png", ancho);
        BotonDeAccion flechaDerecha = new BotonDeAccion("file:img/flechaDerecha.png", ancho);

        flechaArriba.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Juego.instanciar().jugadorPicarArriba();
            }
        });

        flechaAbajo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Juego.instanciar().jugadorPicarAbajo();
            }
        });

        flechaDerecha.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Juego.instanciar().jugadorPicarDerecha();
            }
        });

        flechaIzquierda.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Juego.instanciar().jugadorPicarIzquierda();
            }
        });

        pane.setTop(flechaArriba);
        pane.setBottom(flechaAbajo);
        pane.setLeft(flechaIzquierda);
        pane.setRight(flechaDerecha);
        BorderPane.setAlignment(flechaArriba, Pos.TOP_CENTER);
        BorderPane.setAlignment(flechaAbajo, Pos.BOTTOM_CENTER);
    }
}
