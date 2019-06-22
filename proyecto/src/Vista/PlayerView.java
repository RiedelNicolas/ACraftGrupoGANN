package Vista;

import javafx.scene.Node;
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
        this.coordenadaX = (int)(unAncho / 2);
        this.coordenadaY = (int)(unAlto / 2);

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
    }

    private Node getNodeFromGridPane(GridPane gridPane, int col, int row) {
        for (Node node : gridPane.getChildren()) {
            if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
                return node;
            }
        }
        return null;
    }

    public void moverVertical(int numero){
        pane.add(new ImageView(new Image("file:img/Vacio.png")), coordenadaX, coordenadaY);
        coordenadaY += numero;
        dibujar();
    }

    public void moverHorizontal(int numero){

        Node nodo = getNodeFromGridPane(pane, coordenadaX, coordenadaY);
        ImageView p = (ImageView)nodo;
        p.setImage(new Image("file:img/Vacio.png"));

        coordenadaX += numero;
        dibujar();
    }
}
