package Controlador;

import Modelo.Excepciones.PosicionNoPicableException;
import Modelo.Juego.Juego;
import Vista.MapaView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonAccionArribaHandler implements EventHandler<ActionEvent> {

    MapaView mapaView;

    public BotonAccionArribaHandler(MapaView _mapaView){
        mapaView = _mapaView;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        try {
            Juego.instanciar().jugadorGolpearArriba();
            mapaView.getJugadorView().picarVertical(-1);
            System.out.println("ENTRO");
        }catch (PosicionNoPicableException e){}
    }
}