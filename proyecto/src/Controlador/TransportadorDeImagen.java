package Controlador;

import Modelo.Inventario.Utilizable;
import Modelo.Jugador.Jugador;
import Modelo.MateriaPrima.Antimateria;
import Modelo.MateriaPrima.MateriaPrima;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class TransportadorDeImagen{

    private Image imagenAsociada;

    public TransportadorDeImagen(){
        imagenAsociada = new Image("file:img/Vacio.png");
    }

    public void mover(ImageView imagen){
        this.imagenAsociada = imagen.getImage();
    }

    public Image getImagenAsociada(){
        return imagenAsociada;
    }
}
