package Controlador;

import Modelo.Posicion.Posicion;
import Modelo.Tablero.Mapa;
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
                Posicion actual = campoDeJuego[i][j];
                if(actual.getOcupante()!=null){
                    if(actual.getOcupante().getClass().getName().equals("Modelo.Materiales.Madera")){
                        ImageView madera = new ImageView();
                        madera.setFitHeight(altoGrid/altoMapa);
                        madera.setFitWidth(anchoGrid/anchoMapa);
                        madera.setImage(new Image("file:img/madera.jpg"));
                        grid.add(madera, j, i, 1, 1);
                    }
                    if(actual.getOcupante().getClass().getName().equals("Modelo.Materiales.Piedra")){
                        ImageView piedra = new ImageView();
                        piedra.setFitHeight(altoGrid/altoMapa);
                        piedra.setFitWidth(anchoGrid/anchoMapa);
                        piedra.setImage(new Image("file:img/piedra.jpg"));
                        grid.add(piedra, j, i, 1, 1);
                    }

                    if(actual.getOcupante().getClass().getName().equals("Modelo.Materiales.Metal")){
                        ImageView metal = new ImageView();
                        metal.setFitHeight(altoGrid/altoMapa);
                        metal.setFitWidth(anchoGrid/anchoMapa);
                        metal.setImage(new Image("file:img/metal.jpg"));
                        grid.add(metal, j, i, 1, 1);
                    }
                    if(actual.getOcupante().getClass().getName().equals("Modelo.Materiales.Diamante")){
                        ImageView diamante = new ImageView();
                        diamante.setFitHeight(altoGrid/altoMapa);
                        diamante.setFitWidth(anchoGrid/anchoMapa);
                        diamante.setImage(new Image("file:img/diamante.jpg"));
                        grid.add(diamante, j, i, 1, 1);
                    }
                }
            }
        }
    }
}
