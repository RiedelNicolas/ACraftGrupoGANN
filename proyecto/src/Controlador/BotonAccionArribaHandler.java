package Controlador;

import Modelo.Juego.Juego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonAccionArribaHandler implements EventHandler<ActionEvent> {

    public BotonAccionArribaHandler(){

    }

    @Override
    public void handle(ActionEvent actionEvent){
        Juego.instanciar().jugadorPicarArriba();
    }
}
