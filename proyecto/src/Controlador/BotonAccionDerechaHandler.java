package Controlador;

import Modelo.Juego.Juego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonAccionDerechaHandler implements EventHandler<ActionEvent> {

    public BotonAccionDerechaHandler(){

    }

    @Override
    public void handle(ActionEvent actionEvent){
        Juego.instanciar().jugadorPicarDerecha();
    }
}
