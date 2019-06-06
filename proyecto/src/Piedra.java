public class Piedra extends Material {

    public Piedra(){
        durabilidad = 30;
    }

    public void gastarCon(PicoDeMetal pico){
        durabilidad -= pico.getFuerza();
    }

    public void gastarCon(PicoDePiedra pico){
        durabilidad -= pico.getFuerza();
    }

    public void gastarCon(PicoDeMadera pico){
        durabilidad -= pico.getFuerza();
    }

    public void gastarCon(PicoFino pico){
        durabilidad -= pico.getFuerza();
    }

}
