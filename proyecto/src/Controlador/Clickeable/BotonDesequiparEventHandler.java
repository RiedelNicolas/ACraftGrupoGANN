package Controlador.Clickeable;

import Modelo.Jugador.Jugador;
import Vista.Imagenes.InventarioView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;

public class BotonDesequiparEventHandler implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent actionEvent) {
        Jugador.instanciar().getInventario().quitar();
        InventarioView.instaciar(new Group(), 0, 0).actualizarInventario();
    }
}
