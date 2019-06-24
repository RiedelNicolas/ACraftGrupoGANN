package Controlador;

import Modelo.Excepciones.PosicionNoPicableException;
import Modelo.Juego.Juego;
import Vista.MapaView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonAccionAbajoHandler implements EventHandler<ActionEvent> {

    MapaView mapaView;

    public BotonAccionAbajoHandler(MapaView _mapaView){
        mapaView = _mapaView;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        Juego.instanciar().jugadorGolpearAbajo();
        mapaView.actualizarMapa();
    }
}
