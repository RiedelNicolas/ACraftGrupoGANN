package Controlador;

import Modelo.Excepciones.NoHayElementoEnPosicionDelInventarioException;
import Modelo.Excepciones.NoSePuedeAnadirUtilizableAMesa;
import Modelo.Inventario.Inventario;
import Modelo.Jugador.Jugador;
import Vista.InventarioView;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;

public class ElementoDeMesa extends ImageView {

    private int id;
    private TransportadorDeImagen transportador;
    private boolean ocupado;
    private static int contador = 0;

    public ElementoDeMesa(double ancho, TransportadorDeImagen transportador){

        this.transportador = transportador;
        this.setFitHeight(ancho*0.32);
        this.setFitWidth(ancho*0.32);
        this.setImage(new Image("file:img/elementoVacio.jpg"));
        this.ocupado = false;
        this.id = contador++;
        this.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(ocupado){
                    Jugador.instanciar().quitarMateriaPrimaDeMesa(id);
                    ((ElementoDeMesa)(event.getSource())).setImage(new Image("file:img/elementoVacio.jpg"));
                    ocupado=false;
                }
                else{
                    try{
                        try {
                            Jugador.instanciar().anadirMateriaPrimaAMesa(id);
                            ((ElementoDeMesa) (event.getSource())).setImage(transportador.getImagenAsociada());
                            ocupado = true;
                        }catch(NoHayElementoEnPosicionDelInventarioException e){}
                    }catch(NoSePuedeAnadirUtilizableAMesa e){}
                }
                InventarioView.instaciar(new Group(), 0, 0).actualizarInventario();
            }
        });
    }
}
