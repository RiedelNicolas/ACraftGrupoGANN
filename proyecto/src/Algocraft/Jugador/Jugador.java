package Algocraft.Jugador;

import Algocraft.Construccion.MesaDeCrafteo;
import Algocraft.Excepciones.MateriaPrimaNoEquipableException;
import Algocraft.Excepciones.NoSePuedeGolpearConMateriaPrimaException;
import Algocraft.Herramientas.HachaDeMadera;
import Algocraft.Herramientas.Herramienta;
import Algocraft.Inventario.Inventario;
import Algocraft.Inventario.Utilizable;
import Algocraft.MateriaPrima.MateriaPrima;
import Algocraft.Materiales.Material;
import Algocraft.Posicion.Posicionable;


public class Jugador extends Posicionable {
    //Atributos

    private static Jugador instanciaUnica = null;
    private Inventario inventario;
    private MesaDeCrafteo mesaDeCrafteo;


    private Jugador() {
        inventario = new Inventario();
        mesaDeCrafteo = new MesaDeCrafteo();
    }

    public static Jugador crearUnico(){
        if(instanciaUnica == null){
            instanciaUnica = new Jugador();
        }
        return instanciaUnica;
    }

    public Utilizable getUtilizableEnMano(){
        return inventario.herramientaEnMano();
    }

    public void golpear(Material material){

        MateriaPrima materiaPrima;

        try {
            materiaPrima = getUtilizableEnMano().usarContra(material);
        } catch (NoSePuedeGolpearConMateriaPrimaException e) {}

        try{
            materiaPrima.equipar(inventario);
        } catch (MateriaPrimaNoEquipableException e){}
    }

}
