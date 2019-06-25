package Controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class BotonCraftearEventHandler implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent actionEvent){

        Group root = new Group();
        Scene mesa = new Scene(root);
        Stage mesaDeCrafteo = new Stage();
        mesaDeCrafteo.setScene(mesa);

        double ancho = Screen.getPrimary().getVisualBounds().getWidth() * 0.3;
        double alto = Screen.getPrimary().getVisualBounds().getHeight() * 0.35;

        mesaDeCrafteo.setTitle("Mesa de Crafteo");
        mesaDeCrafteo.initModality(Modality.WINDOW_MODAL);
        mesaDeCrafteo.initOwner(((Node) actionEvent.getSource()).getScene().getWindow());

        mesaDeCrafteo.setY(alto*0.93);
        mesaDeCrafteo.setX(ancho);
        mesaDeCrafteo.setMinHeight(alto);
        mesaDeCrafteo.setMinWidth(ancho);

        mesaDeCrafteo.show();
    }
}