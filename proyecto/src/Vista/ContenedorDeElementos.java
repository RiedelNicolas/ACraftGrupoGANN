package Vista;

import Controlador.ElementoDeMesa;
import Controlador.TransportadorDeImagen;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class ContenedorDeElementos extends GridPane {

    ArrayList<ElementoDeMesa> elementos;

    public ContenedorDeElementos(double ancho){

        elementos = new ArrayList<ElementoDeMesa>();
        TransportadorDeImagen transportador = InventarioView.instaciar(new Group(), 0, 0).getTransportador();

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                this.add(new ElementoDeMesa(ancho, transportador), j, i, 1, 1);
            }
        }
        this.setHgap(3);
        this.setVgap(3);
        this.setMinSize(ancho*0.4, ancho*0.4);
    }
}
