package Vista;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PlayerView {

    private double coordenadaX;
    private double coordenadaY;
    private ImageView imagenDeJugador;
    private Group root;
    private double ancho;
    private double alto;

    public PlayerView(Group root, double unAncho, double unAlto){

        this.root = root;
        this.ancho = (unAncho * 0.78) / 19;
        this.alto = (unAlto * 0.95) / 13;
        this.coordenadaX = unAncho * 0.015;
        this.coordenadaY = unAlto * 0.025;

        Image jugador = new Image("file:img/jugador.jpg");
        imagenDeJugador = new ImageView(jugador);
        imagenDeJugador.setFitWidth(this.ancho);
        imagenDeJugador.setFitHeight(this.alto);
        imagenDeJugador.setX(coordenadaX);
        imagenDeJugador.setY(coordenadaY);

        coordenadaX = imagenDeJugador.getX();
        coordenadaY = imagenDeJugador.getY();
    }

    public ImageView getImagenDeJugador() {
        return imagenDeJugador;
    }

    public void dibujar(){
        imagenDeJugador.setTranslateX(coordenadaX);
        imagenDeJugador.setTranslateY(coordenadaY);
        root.getChildren().remove(imagenDeJugador);
        root.getChildren().add(imagenDeJugador);
    }

    public void moverVertical(int numero){

        double actual = imagenDeJugador.getX();
        imagenDeJugador.setX(actual + numero);
    }

    public void moverHorizontal(int numero){

        double actual = imagenDeJugador.getY();
        imagenDeJugador.setY(actual + numero);
    }
}
