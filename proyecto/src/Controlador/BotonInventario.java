package Controlador;

import Modelo.Excepciones.NoHayElementoEnPosicionDelInventarioException;
import Modelo.Inventario.Utilizable;
import Modelo.Jugador.Jugador;
import Vista.ImagenInventario;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class BotonInventario extends Button {

    private static int contador = 0;
    private int id = 0;
    private double ancho;
    private ImageView labelImagen;
    private Label labelUtilizable;
    private ArrayList<ImagenInventario> imagenes;

    public BotonInventario(double ancho, ImageView label, Label nombreUtilizable){

        this.ancho = ancho;
        this.setMinSize(ancho*0.037, ancho*0.037);
        this.labelImagen = label;
        this.id = contador++;
        this.inicializarImagenesInventario();

        this.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try{
                    Jugador.instanciar().getInventario().mover(id);
                    actualizarLabel(labelImagen);
                }catch(NoHayElementoEnPosicionDelInventarioException e){
                    labelImagen.setImage(new Image("file:img/Vacio.png"));
                }
            }
        });
    }


    public void actualizar() {

        ArrayList<Utilizable> items = Jugador.instanciar().getInventario().getItems();

        if (items.size() > id) {
            Utilizable itemCorrespondiente = items.get(id);

            for (ImagenInventario imagen : imagenes) {
                if (itemCorrespondiente.getClass().getSimpleName().equals(imagen.getNombreItem()))
                    this.setGraphic(imagen);
            }
        }

        else{
            this.setGraphic(imagenes.get(0));
        }
        actualizarLabel(labelImagen);
    }

    private void actualizarLabel(ImageView label){

        try {
            Utilizable itemActual = Jugador.instanciar().getInventario().getUtilizableActual();
            for (ImagenInventario imagen : imagenes) {
                if (itemActual.getClass().getSimpleName().equals(imagen.getNombreItem()))
                    label.setImage(imagen.getImage());
            }
        } catch (NoHayElementoEnPosicionDelInventarioException e){
            label.setImage(new Image("file:img/Vacio.png"));
        }

    }


    private void inicializarImagenesInventario(){

        imagenes = new ArrayList<ImagenInventario>();
        imagenes.add(new ImagenInventario("Vacio", "file:img/Vacio.png", ancho));
        imagenes.add(new ImagenInventario("HachaDeMadera", "file:img/HachaDeMadera.png", ancho));
        imagenes.add(new ImagenInventario("HachaDePiedra", "file:img/HachaDePiedra.png", ancho));
        imagenes.add(new ImagenInventario("HachaDeMetal", "file:img/HachaDeMetal.png", ancho));
        imagenes.add(new ImagenInventario("PicoDeMadera", "file:img/PicoDeMadera.png", ancho));
        imagenes.add(new ImagenInventario("PicoDePiedra", "file:img/PicoDePiedra.png", ancho));
        imagenes.add(new ImagenInventario("PicoDeMetal", "file:img/PicoDeMetal.png", ancho));
        imagenes.add(new ImagenInventario("PicoFino", "file:img/PicoFino.png", ancho));
        imagenes.add(new ImagenInventario("MateriaPrimaMadera", "file:img/MateriaPrimaMadera.png", ancho));
        imagenes.add(new ImagenInventario("MateriaPrimaPiedra", "file:img/MateriaPrimaPiedra.png", ancho));
        imagenes.add(new ImagenInventario("MateriaPrimaMetal", "file:img/MateriaPrimaMetal.png", ancho));
        imagenes.add(new ImagenInventario("MateriaPrimaDiamante", "file:img/MateriaPrimaDiamante.png", ancho));
    }
}
