package Controlador;

import Modelo.Juego.Juego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonAccionIzquierdaHandler implements EventHandler<ActionEvent> {

    public BotonAccionIzquierdaHandler(){

    }

    @Override
    public void handle(ActionEvent actionEvent){
        Juego.instanciar().jugadorPicarIzquierda();
    }
}
