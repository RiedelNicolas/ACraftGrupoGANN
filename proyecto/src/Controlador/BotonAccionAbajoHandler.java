package Controlador;

import Modelo.Juego.Juego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonAccionAbajoHandler implements EventHandler<ActionEvent> {

    public BotonAccionAbajoHandler(){

    }

    @Override
    public void handle(ActionEvent actionEvent){
        Juego.instanciar().jugadorPicarAbajo();
    }
}
