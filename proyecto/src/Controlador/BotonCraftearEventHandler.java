package Controlador;

import Modelo.Excepciones.ConstruccionInvalidaException;
import Modelo.Jugador.Jugador;
import Vista.ContenedorDeElementos;
import Vista.InventarioView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class BotonCraftearEventHandler implements EventHandler<ActionEvent> {

    ContenedorDeElementos contenedor;
    Group rootPadre;

    public BotonCraftearEventHandler(Group root){
        this.rootPadre = root;
    }

    @Override
    public void handle(ActionEvent actionEvent){

        Group root = new Group();
        Scene mesa = new Scene(root);
        Stage mesaDeCrafteo = new Stage();
        mesaDeCrafteo.setScene(mesa);

        double ancho = Screen.getPrimary().getVisualBounds().getWidth() * 0.3;
        double alto = Screen.getPrimary().getVisualBounds().getHeight() * 0.35;

        mesaDeCrafteo.setTitle("Mesa de Crafteo");
        mesaDeCrafteo.initModality(Modality.WINDOW_MODAL);
        mesaDeCrafteo.initOwner(((Node) actionEvent.getSource()).getScene().getWindow());

        mesaDeCrafteo.setY(alto*0.93);
        mesaDeCrafteo.setX(ancho);
        mesaDeCrafteo.setMinHeight(alto);
        mesaDeCrafteo.setMinWidth(ancho);

        insertarBackground(root, ancho, alto);
        insertarInventario(root, ancho, alto);
        insertarContenedorDeElementos(root, ancho, alto);
        insertarBotonMesaDeCrafteo(root, ancho, alto);

        mesaDeCrafteo.setOnCloseRequest((WindowEvent event1) -> {
            InventarioView inventario = InventarioView.instaciar(root, ancho, alto);
            inventario.setLayoutX((ancho*2.2));
            inventario.setLayoutY((alto*0.23));
            inventario.actualizarInventario();
            rootPadre.getChildren().add(inventario);
        });

        mesaDeCrafteo.show();
    }

    private void insertarBackground(Group root, double ancho, double alto){

        ImageView background = new ImageView(new Image("file:img/mesa.jpg"));
        background.setFitWidth(ancho);
        background.setFitHeight(alto);
        root.getChildren().add(background);
    }

    private void insertarInventario(Group root, double ancho, double alto){

        InventarioView inventario = InventarioView.instaciar(root, 0, 0);
        inventario.setLayoutX(ancho*0.53);
        inventario.setLayoutY(alto*0.1);
        root.getChildren().add(inventario);
    }

    private void insertarContenedorDeElementos(Group root, double ancho, double alto){

        contenedor = new ContenedorDeElementos(ancho*0.4);
        contenedor.setLayoutX(ancho*0.07);
        contenedor.setLayoutY(alto*0.1);
        root.getChildren().add(contenedor);
    }

    private void insertarBotonMesaDeCrafteo(Group root, double ancho, double alto){

        Button botonMesaDeCrafteo = new Button();
        ImageView imagenBoton = new ImageView(new Image("file:img/craftear.png"));
        imagenBoton.setFitHeight(alto*0.1);
        imagenBoton.setFitWidth(ancho*0.3);
        botonMesaDeCrafteo.setGraphic(imagenBoton);
        botonMesaDeCrafteo.setPrefHeight(alto*0.08);
        botonMesaDeCrafteo.setPrefWidth(ancho*0.4);
        botonMesaDeCrafteo.setLayoutX(ancho*0.3);
        botonMesaDeCrafteo.setLayoutY(alto*0.76);

        botonMesaDeCrafteo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

               try{
                   Jugador.instanciar().crearHerramienta();
               }catch(ConstruccionInvalidaException e) {
                   contenedor.devolverElementos();
               }
               InventarioView.instaciar(root, ancho, alto).actualizarInventario();
               contenedor.limpiarContenedor();
            }
        });

        root.getChildren().add(botonMesaDeCrafteo);
    }
}