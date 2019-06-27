package Modelo.Jugador;

import Modelo.Construccion.MesaDeCrafteo;
import Modelo.Excepciones.*;
import Modelo.Inventario.Inventario;
import Modelo.Inventario.Utilizable;
import Modelo.MateriaPrima.MateriaPrima;
import Modelo.Materiales.Material;
import Modelo.Posicion.Posicionable;


public class Jugador implements Posicionable {

    //Atributos
    private Inventario inventario;
    private MesaDeCrafteo mesaDeCrafteo;
    private static Jugador instanciaUnica = null;

    //Metodos
    private Jugador() {
        inventario = new Inventario();
        mesaDeCrafteo = new MesaDeCrafteo();
    }

    public static Jugador instanciar(){
        if(instanciaUnica == null){
            instanciaUnica = new Jugador();
        }
        return instanciaUnica;
    }

    public Utilizable getUtilizableEnMano() {
        return inventario.getUtilizableActual();
    }

    public void golpear(Material material){

        MateriaPrima materiaPrima;
        Utilizable utilizable;

        try {

            utilizable = this.getUtilizableEnMano();

            try {
                materiaPrima = utilizable.usarContra(material);

                try{
                    materiaPrima.equipar(inventario);
                    throw new MaterialRotoException();

                } catch (MateriaPrimaNoEquipableException e3) {}

            } catch (HerramientaRotaException e2){ inventario.quitar();}

        } catch (NoHayElementoEnPosicionDelInventarioException e1) {}

    }

    public void crearHerramienta(){
        inventario.equipar(mesaDeCrafteo.craftear());
    }

    public void anadirMateriaPrimaAMesa(int posicion){

        Utilizable utilizable = inventario.getUtilizableActual();
        utilizable.ubicarse(mesaDeCrafteo, posicion);
        inventario.quitar();
    }

    public void quitarMateriaPrimaDeMesa(int posicion){
        inventario.equipar(mesaDeCrafteo.quitarMateriaPrima(posicion));
    }

    //PARA CONTROLADOR
    public Inventario getInventario(){
        return inventario;
    }

    //PARA TESTING
    public Jugador restaurar(){
        instanciaUnica = null;
        return instanciar();
    }
}
