package Controlador.Movimiento;

import Modelo.Juego.Juego;
import Vista.Imagenes.MapaView;
import javafx.event.EventHandler;
import javafx.scene.Group;
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
            MapaView.instanciar(new Group(), 0, 0).rotarJugador('w');
        }
        if( keyEvent.getCode() == KeyCode.S) {
            Juego.instanciar().jugadorMoverAbajo();
            MapaView.instanciar(new Group(), 0, 0).rotarJugador('s');
        }
        if (keyEvent.getCode() == KeyCode.D) {
            Juego.instanciar().jugadorMoverDerecha();
            MapaView.instanciar(new Group(), 0, 0).rotarJugador('d');
        }
        if (keyEvent.getCode() == KeyCode.A) {
            Juego.instanciar().jugadorMoverIzquierda();
            MapaView.instanciar(new Group(), 0, 0).rotarJugador('a');
        }
        mapaView.actualizarMapa();
        keyEvent.consume();
    }

}
