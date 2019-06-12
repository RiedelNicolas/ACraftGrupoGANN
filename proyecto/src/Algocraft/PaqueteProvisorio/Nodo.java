package Algocraft.PaqueteProvisorio;

import Algocraft.Excepciones.NodoOcupadoException;

public class Nodo {
    private Posicionable contenido;


    public Nodo(){
        contenido = null;
    }

    public Posicionable getContenido() {
        return contenido;
    }

    public void setContenido(Posicionable contenidoRecibido) {
        if( this.ocupado() ){
            throw new NodoOcupadoException();
        }
        contenido=contenidoRecibido;
    }

    public void limpiar(){
        this.contenido = null;
    }

    public boolean ocupado(){
        return (contenido != null);
    }


}
