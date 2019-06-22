package Vista;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Main extends Application {

    private Group root;
    private Scene scene;
    private static double ancho;
    private static double alto;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        root = new Group();
        scene = new Scene(root);
        ancho = Screen.getPrimary().getVisualBounds().getWidth() * 0.8;
        alto = Screen.getPrimary().getVisualBounds().getHeight() * 0.8;

        dibujarPantallaInicial();
        primaryStage.setTitle("AlgoCraft-AlgoritmosYProgramacionIII");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public void dibujarPantallaInicial(){

        setBackground();
        setLogo();
        setBotonInicio();
    }


    public void setBotonInicio(){

        BotonDePlayView botonInicio = new BotonDePlayView(root, ancho, alto);
        root.getChildren().add(botonInicio);
    }


    public void setLogo(){

        ImageView logo= new ImageView();
        logo.setImage(new Image("file:img/logo.png"));
        logo.setX(ancho*0.2);
        logo.setY(alto*0.30);
        logo.setFitHeight(alto*0.3);
        logo.setFitWidth(ancho*0.6);
        root.getChildren().add(logo);
    }


    public void setBackground(){
        ImageView background= new ImageView();
        background.setImage(new Image("file:img/fondoPantallaInicio.jpg"));
        background.setFitHeight(alto);
        background.setFitWidth(ancho);
        root.getChildren().add(background);
    }

}
