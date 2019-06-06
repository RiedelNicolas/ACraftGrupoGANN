public class Madera extends Material{

    public Madera(){
        durabilidad = 10;
    }

    @Override
    public void gastarCon(HachaDeMadera hacha){
        durabilidad -= hacha.getFuerza();
    }

    @Override
    public void gastarCon(HachaDePiedra hacha){
        durabilidad -= hacha.getFuerza();
    }

    @Override
    public void gastarCon(HachaDeMetal hacha) {
        durabilidad -= hacha.getFuerza();
    }
}