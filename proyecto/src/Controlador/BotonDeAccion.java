package Controlador;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BotonDeAccion extends Button {

    public BotonDeAccion(String pathImagen, double ancho){

        this.setMinSize(ancho*0.05, ancho*0.05);
        ImageView imagen = new ImageView(new Image(pathImagen));
        imagen.setFitHeight(ancho*0.03);
        imagen.setFitWidth(ancho*0.03);
        this.setGraphic(imagen);
    }
}
