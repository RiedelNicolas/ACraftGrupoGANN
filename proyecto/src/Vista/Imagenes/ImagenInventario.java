package Vista.Imagenes;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImagenInventario extends ImageView {

    private String item;

    public ImagenInventario(String item, String path, double ancho){

        this.item = item;
        this.setFitHeight(ancho*0.02);
        this.setFitWidth(ancho*0.02);
        this.setImage(new Image(path));
    }

    public String getNombreItem(){
        return item;
    }
}
