package Controlador;

import Modelo.Excepciones.PosicionNoPicableException;
import Modelo.Juego.Juego;
import Vista.MapaView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonAccionIzquierdaHandler implements EventHandler<ActionEvent> {

    private MapaView mapaView;

    public BotonAccionIzquierdaHandler(MapaView _mapaView){
        mapaView = _mapaView;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        Juego.instanciar().jugadorGolpearIzquierda();
        mapaView.actualizarMapa();
    }
}
