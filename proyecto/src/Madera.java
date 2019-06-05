public class Madera extends Material{

    public void Madera(){
        durabilidad = 10;
    }

    public void gastarCon(HachaDeMadera hacha){
        durabilidad -= hacha.getFuerza();
    }

    public void gastarCon(HachaDePiedra hacha){
        durabilidad -= hacha.getFuerza();
    }

    public void gastarCon(HachaDeMetal hacha) {
        durabilidad -= hacha.getFuerza();
    }
}