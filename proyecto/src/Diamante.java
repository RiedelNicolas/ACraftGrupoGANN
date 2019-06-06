public class Diamante extends Material {

    public Diamante(){
        durabilidad = 100;
    }

    public void gastarCon(PicoFino pico){
        durabilidad -= pico.getFuerza();
    }
}
