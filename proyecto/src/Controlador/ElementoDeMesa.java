package Controlador;

import Vista.ImagenInventario;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ElementoDeMesa extends ImageView {

    private String item;
    private int id;
    private static int contador = 0;

    public ElementoDeMesa(double ancho){

        this.item = "Vacio";
        this.setFitHeight(ancho*0.32);
        this.setFitWidth(ancho*0.32);
        this.setImage(new Image("file:img/elementoVacio.jpg"));
        this.id = contador++;
    }

//    public String getNombreItem(){
//        return item;
//    }
}
