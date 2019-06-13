package Algocraft.PaqueteProvisorio;

import Algocraft.Excepciones.PosicionOcupadaException;

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
            throw new PosicionOcupadaException();
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
