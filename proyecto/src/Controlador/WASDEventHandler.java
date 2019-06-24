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
            Juego.instanciar().jugadorMoverArriba();
            //mapaView.getJugadorView().moverVertical(-1);
            mapaView.actualizarMapa();
        }
        if( keyEvent.getCode() == KeyCode.S) {
            Juego.instanciar().jugadorMoverAbajo();
            //mapaView.getJugadorView().moverVertical(1);
            mapaView.actualizarMapa();
        }
        if (keyEvent.getCode() == KeyCode.D) {
            Juego.instanciar().jugadorMoverDerecha();
            //mapaView.getJugadorView().moverHorizontal(1);
            mapaView.actualizarMapa();
        }
        if (keyEvent.getCode() == KeyCode.A) {
            Juego.instanciar().jugadorMoverIzquierda();
            //mapaView.getJugadorView().moverHorizontal(-1);
            mapaView.actualizarMapa();
        }
        keyEvent.consume();
    }

}
