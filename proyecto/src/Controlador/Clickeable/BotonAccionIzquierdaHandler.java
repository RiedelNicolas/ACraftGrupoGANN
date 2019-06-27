package Controlador.Clickeable;

import Modelo.Juego.Juego;
import Vista.Imagenes.InventarioView;
import Vista.Imagenes.MapaView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;

public class BotonAccionIzquierdaHandler implements EventHandler<ActionEvent> {

    private MapaView mapaView;

    public BotonAccionIzquierdaHandler(MapaView _mapaView){
        mapaView = _mapaView;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        Juego.instanciar().jugadorGolpearIzquierda();
        MapaView.instanciar(new Group(), 0, 0).rotarJugador('a');
        InventarioView.instaciar(new Group(), 0, 0).actualizarInventario();
        mapaView.actualizarMapa();
    }
}
