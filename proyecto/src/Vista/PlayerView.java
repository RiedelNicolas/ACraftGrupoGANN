package Vista;

import Modelo.Tablero.Mapa;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.io.PrintStream;

public class PlayerView {

    private int coordenadaX;
    private int coordenadaY;
    private ImageView imagenDeJugador;
    private Group root;
    private GridPane pane;
    private double ancho;
    private double alto;

    public PlayerView(Group root, double unAncho, double unAlto, GridPane gridPane){

        int anchoMapa = Mapa.instanciar(0,0).getAncho();
        int altoMapa = Mapa.instanciar(0,0).getAlto();
        this.root = root;
        this.pane = gridPane;
        this.ancho = (unAncho * 0.78) / (anchoMapa);
        this.alto = (unAlto * 0.95) / (altoMapa);
        this.coordenadaX = (int)(anchoMapa / 2);
        this.coordenadaY = (int)(altoMapa / 2);

        Image jugador = new Image("file:img/jugador.jpg");
        imagenDeJugador = new ImageView(jugador);
        imagenDeJugador.setFitWidth(this.ancho);
        imagenDeJugador.setFitHeight(this.alto);
    }


    public void dibujar(){
        pane.add(imagenDeJugador, coordenadaX, coordenadaY);
    }

    public Node obtenerNodo (int fila, int columna, GridPane gridPane) {
        Node resultado = null;
        ObservableList<Node> hijos = gridPane.getChildren();

        for (Node nodo : hijos) {

            if((GridPane.getRowIndex(nodo) == fila) && (GridPane.getColumnIndex(nodo) == columna)) {
                resultado = nodo;
                break;
            }
        }
        return resultado;
    }

    public void moverVertical(int numero){
        pane.add(new ImageView(new Image("file:img/Vacio.png")), coordenadaX, coordenadaY);
        coordenadaY += numero;
        dibujar();
    }

    public void moverHorizontal(int numero){

        Node nodo = obtenerNodo(coordenadaY, coordenadaX, pane);
        ImageView p = (ImageView)nodo;
        p.setImage(new Image("file:img/Vacio.png"));

        coordenadaX += numero;
        dibujar();
    }
}
