package Controlador;

import Modelo.Excepciones.PosicionNoPicableException;
import Modelo.Juego.Juego;
import Vista.MapaView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonAccionDerechaHandler implements EventHandler<ActionEvent> {

    private MapaView mapaView;

    public BotonAccionDerechaHandler(MapaView _mapaView){
        mapaView = _mapaView;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        try {
            Juego.instanciar().jugadorGolpearDerecha();
            mapaView.getJugadorView().picarHorizontal(1);
        }catch (PosicionNoPicableException e){}
    }
}
