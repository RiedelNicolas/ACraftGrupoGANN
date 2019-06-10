
import java.lang.*;

public class Posicion {

    //Atributos
    protected int x;
    protected int y;

    //Métodos
    public posicion(int x, int y){
        this.x=x;
        this.y=y;
    }

    public posicion(){
        //hacer excepcion.
    }

    public int calcularDistanciaCon(Posicion posicionRecibida){
        return 0;
    }

    //no se si deberian ser publica, ver tema de paquetes.
    public int getVertical(){
        return y;
    }

    public int getHorizontal(){
        return x;
    }

    //distancia Manhattan
    public int distanciaCon(Posicion posicionRecibida){
        int diferenciaDeColumnas, diferenciaDeFilas;
        diferenciaDeColumnas = Math.abs(posicionRecibida.getVertical() - x );
        diferenciaDeFilas  = Math.abs(posicionRecibida.getHorizontal() - y );

        return ( diferenciaDeColumnas+ diferenciaDeFilas );
    }

    public boolean esIgual(Posicion posicionRecibida){
        return( this.distanciaCon(posicionRecibida) == 0 );
    }


}
