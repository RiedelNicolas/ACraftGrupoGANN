package Vista;

import Controlador.ElementoDeMesa;
import Controlador.Transportador;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;


public class ContenedorDeElementos extends GridPane {

    public ContenedorDeElementos(double ancho){

        Transportador transportador = InventarioView.instaciar(new Group(), 0, 0).getTransportador();

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                this.add(new ElementoDeMesa(ancho, transportador), j, i, 1, 1);
            }
        }
        this.setHgap(3);
        this.setVgap(3);
        this.setMinSize(ancho*0.4, ancho*0.4);
    }

    public void limpiarContenedor(){

        ObservableList<Node> hijos = this.getChildren();

        for(Node hijo:hijos){
            ElementoDeMesa elemento = (ElementoDeMesa)hijo;
            elemento.limpiar();
        }
    }

    public void devolverElementos(){
        ObservableList<Node> hijos = this.getChildren();

        for(Node hijo:hijos){
            ElementoDeMesa elemento = (ElementoDeMesa)hijo;
            elemento.devolver();
        }
    }
}
