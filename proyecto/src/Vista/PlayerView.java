package Vista;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class PlayerView {

    private int coordenadaX;
    private int coordenadaY;
    private ImageView imagenDeJugador;
    private Group root;
    private GridPane pane;
    private double ancho;
    private double alto;

    public PlayerView(Group root, double unAncho, double unAlto, GridPane gridPane){

        this.root = root;
        this.pane = gridPane;
        this.ancho = (unAncho * 0.78) / 19;
        this.alto = (unAlto * 0.95) / 13;
        this.coordenadaX = 9;
        this.coordenadaY = 6;

        Image jugador = new Image("file:img/jugador.jpg");
        imagenDeJugador = new ImageView(jugador);
        imagenDeJugador.setFitWidth(this.ancho);
        imagenDeJugador.setFitHeight(this.alto);
    }

    public ImageView getImagenDeJugador() {
        return imagenDeJugador;
    }

    public void dibujar(){
        pane.add(imagenDeJugador, coordenadaX, coordenadaY);
        root.getChildren().remove(pane);
        root.getChildren().add(pane);
    }

    public void moverVertical(int numero){

        coordenadaY += numero;
    }

    public void moverHorizontal(int numero){

        coordenadaY += numero;
    }

    public double getCoordenadaX() {
        return coordenadaX;
    }

    public double getCoordenadaY() {
        return coordenadaY;
    }
}
