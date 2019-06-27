package Controlador.Clickeable;

import Modelo.Juego.Juego;
import Vista.Imagenes.InventarioView;
import Vista.Imagenes.MapaView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;

public class BotonAccionArribaHandler implements EventHandler<ActionEvent> {

    MapaView mapaView;

    public BotonAccionArribaHandler(MapaView _mapaView){
        mapaView = _mapaView;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Juego.instanciar().jugadorGolpearArriba();
        MapaView.instanciar(new Group(), 0, 0).rotarJugador('w');
        InventarioView.instaciar(new Group(), 0, 0).actualizarInventario();
        mapaView.actualizarMapa();
    }
}