package Controlador;

import Modelo.Juego.Juego;
import Vista.InventarioView;
import Vista.MapaView;
import Vista.PlayerView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BotonDePlayEventHandler implements EventHandler<ActionEvent> {

    private Group root;
    private double ancho;
    private double alto;

    public BotonDePlayEventHandler(Group root, double ancho, double alto){
        this.root = root;
        this.alto = alto;
        this.ancho = ancho;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        root.getChildren().remove(0, 3); //borra fondo, logo y a si mismo
        Juego juego = Juego.instanciar();
        juego.inicializar();
        inicilizarPantallaPrincipal();
    }

    private void inicilizarPantallaPrincipal(){

        ImageView background= new ImageView();
        background.setImage(new Image("file:img/fondoGris.jpg"));
        background.setFitHeight(alto);
        background.setFitWidth(ancho);
        root.getChildren().add(background);

        MapaView.crearUnico(root, ancho, alto);

        InventarioView inventario = InventarioView.instaciar(root, ancho, alto);
        inventario.actualizarInventario();

        BotoneraDeAcciones botonera = new BotoneraDeAcciones(root, ancho, alto);
    }
}
