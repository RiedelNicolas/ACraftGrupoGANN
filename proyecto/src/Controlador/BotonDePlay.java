package Controlador;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.*;

public class BotonDePlay extends Button {

    private BotonDePlayEventHandler botonHandler;

    public BotonDePlay(Group root, double ancho, double alto){
        super();

        botonHandler = new BotonDePlayEventHandler(root, ancho, alto);

        ImageView skin = new ImageView(new Image("file:img/botonPlay.png"));
        skin.setFitHeight(alto*0.1);
        skin.setFitWidth(ancho*0.16);

        this.setDefaultButton(true);
        this.setGraphic(skin);
        this.setLayoutX(ancho*0.42);
        this.setLayoutY(alto*0.65);

        this.setOnAction(botonHandler);
    }

}
