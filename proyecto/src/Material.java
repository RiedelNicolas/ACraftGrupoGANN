public abstract class Material {

    protected int durabilidad;

    public abstract void gastarCon(HachaDeMadera hacha);
    public abstract void gastarCon(HachaDePiedra hacha);
    public abstract void gastarCon(HachaDeMetal hacha);
    public abstract void gastarCon(PicoDeMadera pico);
    public abstract void gastarCon(PicoDePiedra pico);
    public abstract void gastarCon(PicoDeMetal pico);
    public abstract void gastarCon(PicoFino pico);
    
}
