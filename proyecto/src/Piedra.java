public class Piedra extends Material {

    public Piedra(){
        durabilidad = 30;
    }

    @Override
    public void gastarCon(PicoDeMetal pico){
        durabilidad -= pico.getFuerza();
    }

    @Override
    public void gastarCon(PicoDePiedra pico){
        durabilidad -= pico.getFuerza();
    }

    @Override
    public void gastarCon(PicoDeMadera pico){
        durabilidad -= pico.getFuerza();
    }

    @Override
    public void gastarCon(PicoFino pico){
        durabilidad -= pico.getFuerza();
        throw new PicoFinoException();
    }

}
