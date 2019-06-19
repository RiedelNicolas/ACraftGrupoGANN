package Controlador;

import Modelo.Juego.Juego;
import Modelo.Posicion.Posicion;
import Modelo.Tablero.Mapa;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

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
        Juego juego = Juego.crearUnico();
        inicilizarPantallaPrincipal();
    }

    private void inicilizarPantallaPrincipal(){
        
        ImageView background= new ImageView();
        background.setImage(new Image("file:img/fondoGris.jpg"));
        background.setFitHeight(alto);
        background.setFitWidth(ancho);
        root.getChildren().add(background);

        Mapa mapa = Mapa.instanciar(0,0);
        mapa.inicializar();
        Posicion campoDeJuego[][] = mapa.getCampo();
        int altoMapa = mapa.getAlto();
        int anchoMapa = mapa.getAncho();
        System.out.println(anchoMapa + " y " + altoMapa);

        GridPane grid = new GridPane();
        double anchoGrid = ancho*0.78;
        double altoGrid = alto*0.95;
        grid.setPrefSize(anchoGrid, altoGrid);
        grid.setLayoutX(ancho*0.015);
        grid.setLayoutY(alto*0.025);
        Image image = new Image("file:img/pasto.jpg");
        grid.setBackground(new Background(new BackgroundImage(image,BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT)));

        for(int i=0; i<altoMapa; i++){
            for(int j=0; j<anchoMapa; j++) {
                Posicion actual = campoDeJuego[i][j];
                if(actual.getOcupante()!=null){
                    System.out.println(actual.getOcupante().getClass().getName());

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
                        diamante.setImage(new Image("file:img/diamante.png"));
                        grid.add(diamante, j, i, 1, 1);
                    }
                }
            }
        }
        root.getChildren().addAll(grid);
    }
}
