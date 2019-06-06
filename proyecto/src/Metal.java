public class Metal extends Material {

    public Metal (){
        durabilidad = 50;
    }

    public void gastarCon(PicoDePiedra pico){
        durabilidad -= pico.getFuerza();
    }
}
