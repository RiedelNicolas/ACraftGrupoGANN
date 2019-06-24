package Controlador;

import Modelo.Excepciones.PosicionNoPicableException;
import Modelo.Juego.Juego;
import Vista.InventarioView;
import Vista.MapaView;
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
        InventarioView.instaciar(new Group(), 0, 0).actualizarInventario();
        mapaView.actualizarMapa();
    }
}