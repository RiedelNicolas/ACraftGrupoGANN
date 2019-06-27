package Vista.Imagenes;

import Controlador.Clickeable.BotonAccionAbajoHandler;
import Controlador.Clickeable.BotonAccionArribaHandler;
import Controlador.Clickeable.BotonAccionDerechaHandler;
import Controlador.Clickeable.BotonAccionIzquierdaHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.layout.BorderPane;

public class BotoneraDeAccionesView {

    private BorderPane pane;
    private MapaView mapaView;

    public BotoneraDeAccionesView(Group root, double ancho, double alto){

        pane = new BorderPane();
        mapaView = MapaView.instanciar(root, ancho, alto);

        pane.setLayoutX(ancho*0.825);
        pane.setLayoutY(alto*0.515);
        pane.setPrefSize(ancho*0.148,ancho*0.148);
        inicializarBotones(ancho);

        root.getChildren().add(pane);
    }

    private void inicializarBotones(double ancho){

        BotonDeAccionView flechaArriba = new BotonDeAccionView("file:img/flechaArriba.png", ancho);
        BotonDeAccionView flechaAbajo = new BotonDeAccionView("file:img/flechaAbajo.png", ancho);
        BotonDeAccionView flechaIzquierda = new BotonDeAccionView("file:img/flechaIzquierda.png", ancho);
        BotonDeAccionView flechaDerecha = new BotonDeAccionView("file:img/flechaDerecha.png", ancho);

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
