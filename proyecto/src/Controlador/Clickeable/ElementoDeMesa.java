package Controlador.Clickeable;

import Modelo.Excepciones.NoHayElementoEnPosicionDelInventarioException;
import Modelo.Excepciones.NoSePuedeAnadirUtilizableAMesa;
import Modelo.Jugador.Jugador;
import Modelo.MateriaPrima.MateriaPrima;
import Vista.Imagenes.InventarioView;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;

public class ElementoDeMesa extends ImageView {

    private int id;
    private Transportador transportador;
    private MateriaPrima materia;
    private boolean ocupado;
    private static int contador = 0;

    public ElementoDeMesa(double ancho, Transportador transportador){

        this.transportador = transportador;
        this.setFitHeight(ancho*0.32);
        this.setFitWidth(ancho*0.32);
        this.setImage(new Image("file:img/elementoVacio.jpg"));
        this.ocupado = false;
        this.id = asignarID();
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
                            materia = (MateriaPrima)transportador.getUtilizableAsociado();
                            ocupado = true;
                        }catch(NoHayElementoEnPosicionDelInventarioException e){}
                    }catch(NoSePuedeAnadirUtilizableAMesa e){}
                }
                InventarioView.instaciar(new Group(), 0, 0).actualizarInventario();
            }
        });
    }

    public void limpiar(){
        this.setImage(new Image("file:img/elementoVacio.jpg"));
        materia = null;
        ocupado = false;
    }

    public void devolver() {
        if (materia != null && materia.getClass().getSimpleName() != "Antimateria")
            materia.equipar(Jugador.instanciar().getInventario());
        this.limpiar();
    }

    private int asignarID(){
        int nuevaID = contador++;
        if(contador >= 9) contador = 0;
        return nuevaID;
    }
}
