
package Algocraft.PaqueteProvisorio;

public class Mapa {
    private Nodo[][] plano;

    public Mapa(int ancho, int alto){
        plano = new Nodo[ancho][alto];
    }

    public void limpiar( Posicion posicion) {

        ( plano[posicion.getVertical()][posicion.getHorizontal()] ).limpiar();
    }

    public boolean fueraDeRango(Posicion posicion){ return false;}
}
