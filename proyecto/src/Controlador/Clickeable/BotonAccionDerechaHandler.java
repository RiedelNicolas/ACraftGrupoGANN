package Controlador.Clickeable;

import Modelo.Juego.Juego;
import Vista.Imagenes.InventarioView;
import Vista.Imagenes.MapaView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;

public class BotonAccionDerechaHandler implements EventHandler<ActionEvent> {

    private MapaView mapaView;

    public BotonAccionDerechaHandler(MapaView _mapaView){
        mapaView = _mapaView;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        Juego.instanciar().jugadorGolpearDerecha();
        MapaView.instanciar(new Group(), 0, 0).rotarJugador('d');
        InventarioView.instaciar(new Group(), 0, 0).actualizarInventario();
        mapaView.actualizarMapa();
    }
}
