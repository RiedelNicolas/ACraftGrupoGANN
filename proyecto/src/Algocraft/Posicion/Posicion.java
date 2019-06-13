package Algocraft.Posicion;

public class Posicion {

    //Atributos
    private Posicionable ocupante;
    private int x;
    private int y;

    //Métodos
    public Posicion(int x, int y){
        this.x = x;
        this.y = y;
        ocupante = null;
    }

    public Posicion(Posicionable ocupante, int x, int y){
        this.x = x;
        this.y = y;
        this.ocupante = ocupante;
    }

    public int componenteHorizontal(){
        return y;
    }

    public int componenteVertical(){
        return x;
    }

    public void ocupar(Posicionable nuevoOcupante){
        ocupante = nuevoOcupante;
    }

    public Posicionable getOcupante(){
        return ocupante;
    }

    public void mover(Posicion posicion){
        posicion.ocupar(ocupante);
        ocupante = null;
    }

    public boolean estaOcupada(){
        if(ocupante == null){
            return false;
        }
        return true;
    }
}
