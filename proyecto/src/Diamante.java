public class Diamante extends Material {

    public void Diamante(){
        durabilidad = 100;
    }

    public void gastarCon(PicoFino pico){
        durabilidad -= pico.getFuerza();
    }
}
