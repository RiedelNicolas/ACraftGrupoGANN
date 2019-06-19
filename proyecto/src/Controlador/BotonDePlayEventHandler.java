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
        grid.setPrefSize(ancho*0.78, alto*0.95);
        grid.setLayoutX(ancho*0.015);
        grid.setLayoutY(alto*0.025);
        Image image = new Image("file:img/pasto.jpg");
        grid.setBackground(new Background(new BackgroundImage(image,BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT)));

        ImageView madera = new ImageView();
        madera.setImage(new Image("file:img/madera.jpg"));

        ImageView piedra = new ImageView();
        piedra.setImage(new Image("file:img/piedra.jpg"));

        ImageView metal = new ImageView();
        metal.setImage(new Image("file:img/metal.jpg"));

        ImageView diamante = new ImageView();
        diamante.setImage(new Image("file:img/diamante.png"));

        for(int i=0; i<altoMapa; i++){
            for(int j=0; j<anchoMapa; j++) {
                Posicion actual = campoDeJuego[i][j];
                if(actual.getOcupante()!=null){
                    if(actual.getOcupante().getClass().getName().equals("Madera"))
                        grid.add(madera, j, i, 1, 1);
                    if(actual.getOcupante().getClass().getName().equals("Piedra"))
                        grid.add(piedra, j, i, 1, 1);
                    if(actual.getOcupante().getClass().getName().equals("Metal"))
                        grid.add(metal, j, i, 1, 1);
                    if(actual.getOcupante().getClass().getName().equals("Diamante"))
                        grid.add(diamante, j, i, 1, 1);
                }
            }
        }

        grid.add(diamante, anchoMapa-1, altoMapa-1, 1, 1);
        root.getChildren().addAll(grid);
    }
}
