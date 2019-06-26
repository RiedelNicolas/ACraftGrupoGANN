package Controlador;

import Modelo.Juego.Juego;
import Vista.BotoneraDeAccionesView;
import Vista.InventarioView;
import Vista.MapaView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class BotonDePlayEventHandler implements EventHandler<ActionEvent> {

    private Group root;
    private double ancho;
    private double alto;

    public BotonDePlayEventHandler(Group root, double ancho, double alto){
        this.root = root;
        this.alto = alto;
        this.ancho = ancho;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        root.getChildren().remove(0, 3); //borra fondo, logo y a si mismo
        Juego juego = Juego.instanciar();
        juego.inicializar();
        inicilizarPantallaPrincipal();
    }

    private void inicilizarPantallaPrincipal(){

        ImageView background= new ImageView();
        background.setImage(new Image("file:img/fondoGris.jpg"));
        background.setFitHeight(alto);
        background.setFitWidth(ancho);
        root.getChildren().add(background);

        MapaView.crearUnico(root, ancho, alto);

        InventarioView inventario = InventarioView.instaciar(root, ancho, alto);
        inventario.setLayoutX(ancho*0.825);
        inventario.setLayoutY(alto*0.10);
        inventario.actualizarInventario();
        root.getChildren().add(inventario);

        BotoneraDeAccionesView botonera = new BotoneraDeAccionesView(root, ancho, alto);

        ImageView inventarioLabel = new ImageView(new Image("file:img/inventario.png"));
        inventarioLabel.setFitHeight(alto*0.05);
        inventarioLabel.setFitWidth(ancho*0.15);
        inventarioLabel.setX(ancho*0.825);
        inventarioLabel.setY(alto*0.04);

        ImageView golpearLabel = new ImageView(new Image("file:img/Golpear.png"));
        golpearLabel.setFitHeight(alto*0.05);
        golpearLabel.setFitWidth(ancho*0.12);
        golpearLabel.setX(ancho*0.84);
        golpearLabel.setY(alto*0.45);

        Button botonCraftear = new Button();
        ImageView imagenBoton = new ImageView(new Image("file:img/craftear.png"));
        imagenBoton.setFitHeight(alto*0.05);
        imagenBoton.setFitWidth(ancho*0.14);
        botonCraftear.setGraphic(imagenBoton);
        botonCraftear.setPrefHeight(alto*0.08);
        botonCraftear.setPrefWidth(ancho*0.148);
        botonCraftear.setLayoutX(ancho*0.826);
        botonCraftear.setLayoutY(alto*0.9);
        botonCraftear.setOnAction(new BotonCraftearEventHandler());

        Button botonDesequipar = new Button("DESEQUIPAR");
        botonDesequipar.setPrefSize(ancho*0.074, alto*0.03);
        botonDesequipar.setLayoutX(ancho*0.899);
        botonDesequipar.setLayoutY(alto*0.375);
        botonDesequipar.setOnAction(new BotonDesequiparEventHandler());

        Label labelEnMano = new Label("En mano: ");
        labelEnMano.setLayoutX(ancho*0.826);
        labelEnMano.setLayoutY(alto*0.80);
        labelEnMano.setTextFill(Color.WHITE);
        labelEnMano.setFont(new Font("Arial", 20));
        //labelEnMano.



        root.getChildren().addAll(inventarioLabel, golpearLabel, botonCraftear, botonDesequipar, labelEnMano);
    }
}
