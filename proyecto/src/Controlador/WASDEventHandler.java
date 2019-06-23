package Controlador;

import Modelo.Juego.Juego;
import Vista.MapaView;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class WASDEventHandler implements EventHandler<KeyEvent> {

    private MapaView mapaView;

    public WASDEventHandler(MapaView _mapaView){
        mapaView = _mapaView;
    }

    @Override
    public void handle(KeyEvent keyEvent) {
        if(keyEvent.getCode() == KeyCode.W) {
            mapaView.getJugadorView().moverVertical(-1);
            Juego.instanciar().jugadorMoverArriba();
        }
        if( keyEvent.getCode() == KeyCode.S) {
            mapaView.getJugadorView().moverVertical(1);
            Juego.instanciar().jugadorMoverAbajo();
        }
        if (keyEvent.getCode() == KeyCode.D) {
            mapaView.getJugadorView().moverHorizontal(1);
            Juego.instanciar().jugadorMoverDerecha();
        }
        if (keyEvent.getCode() == KeyCode.A) {
            mapaView.getJugadorView().moverHorizontal(-1);
            Juego.instanciar().jugadorMoverIzquierda();
        }
        keyEvent.consume();
    }

}
