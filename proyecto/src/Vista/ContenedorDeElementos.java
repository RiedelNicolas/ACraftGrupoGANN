package Vista;

import Controlador.ElementoDeMesa;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class ContenedorDeElementos extends GridPane {

    ArrayList<ElementoDeMesa> elementos;

    public ContenedorDeElementos(double ancho){

        elementos = new ArrayList<ElementoDeMesa>();

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                this.add(new ElementoDeMesa(ancho), j, i, 1, 1);
            }
        }

        this.setPadding(new Insets(5,5,5,5));
        this.setMinSize(ancho*0.4, ancho*0.4);
    }
}
