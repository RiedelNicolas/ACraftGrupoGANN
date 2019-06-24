package Controlador;

import Modelo.Posicion.Posicion;
import Modelo.Tablero.Mapa;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class MapaController {

    private int altoMapa;
    private int anchoMapa;
    private Posicion[][] campoDeJuego;

    public MapaController(){
        Mapa mapa = Mapa.instanciar(0,0);
        this.campoDeJuego = mapa.getCampo();
        this.altoMapa = mapa.getAlto();
        this.anchoMapa = mapa.getAncho();
    }

    public void agregarMateriales(GridPane grid, double altoGrid, double anchoGrid){

        for(int i=0; i<altoMapa; i++){
            for(int j=0; j<anchoMapa; j++) {
                Posicion actual = campoDeJuego[j][i];
                ImageView imagen = new ImageView();
                imagen.setFitHeight(altoGrid/altoMapa);
                imagen.setFitWidth(anchoGrid/anchoMapa);

                asignarImagen(actual, imagen);

                grid.add(imagen, j, i, 1, 1);
            }
        }
    }

    public void actualizarMapa(GridPane grid, double altoGrid, double anchoGrid){

        ObservableList<Node> hijos = grid.getChildren();

        for(int i=0; i<altoMapa; i++) {
            for (int j = 0; j < anchoMapa; j++) {
                for (Node nodo : hijos) {
                    if((GridPane.getRowIndex(nodo) == i) && (GridPane.getColumnIndex(nodo) == j)) {
                        asignarImagen(campoDeJuego[j][i], (ImageView)nodo);
                    }
                }
            }
        }
    }


    public void asignarImagen(Posicion actual, ImageView imagen){
        if(actual.getOcupante()!=null){
            if(actual.getOcupante().getClass().getSimpleName().equals("Madera")){
                imagen.setImage(new Image("file:img/madera.jpg"));
            }
            if(actual.getOcupante().getClass().getSimpleName().equals("Piedra")){
                imagen.setImage(new Image("file:img/piedra.jpg"));
            }
            if(actual.getOcupante().getClass().getSimpleName().equals("Metal")){
                imagen.setImage(new Image("file:img/metal.jpg"));
            }
            if(actual.getOcupante().getClass().getSimpleName().equals("Diamante")){
                imagen.setImage(new Image("file:img/diamante.jpg"));
            }
            if(actual.getOcupante().getClass().getSimpleName().equals("Jugador")){
                imagen.setImage(new Image("file:img/jugador.jpg"));
            }
        }
        else{
            imagen.setImage(new Image("file:img/Vacio.png"));
        }
    }

}
