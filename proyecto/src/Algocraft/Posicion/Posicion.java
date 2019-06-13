package Algocraft.Posicion;

public class Posicion {

    //Atributos
    private Posicionable ocupante;
    private int componenteHorizontal;
    private int componenteVertical;

    //Métodos
    public Posicion(int _componenteHorizontal, int _componenteVertical){
        this.componenteHorizontal = _componenteHorizontal;
        this.componenteVertical = _componenteVertical;
        ocupante = null;
    }

    public Posicion(Posicionable ocupante, int _componenteHorizontal, int _componenteVertical){
        this.componenteHorizontal = _componenteHorizontal;
        this.componenteVertical = _componenteVertical;
        this.ocupante = ocupante;
    }

    public int componenteHorizontal(){
        return componenteHorizontal;
    }

    public int componenteVertical(){
        return componenteVertical;
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
