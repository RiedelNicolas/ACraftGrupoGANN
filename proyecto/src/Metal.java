public class Metal extends Material {

    public void Metal (){
        durabilidad = 50;
    }

    public void gastarCon(PicoDePiedra pico){
        durabilidad -= pico.getFuerza();
    }
}
