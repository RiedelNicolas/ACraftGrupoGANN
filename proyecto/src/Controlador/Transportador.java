package Controlador;

import Modelo.Inventario.Utilizable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Transportador {

    private Image imagenAsociada;
    private Utilizable utilizableAsociado;

    public Transportador(){
        imagenAsociada = new Image("file:img/Vacio.png");
    }

    public void mover(ImageView imagen, Utilizable utilizable){
        this.imagenAsociada = imagen.getImage();
        this.utilizableAsociado = utilizable;
    }

    public Image getImagenAsociada(){
        return imagenAsociada;
    }

    public Utilizable getUtilizableAsociado(){
        return utilizableAsociado;
    }
}
