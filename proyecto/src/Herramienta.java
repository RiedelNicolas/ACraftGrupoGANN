public abstract class Herramienta {

    protected int fuerza;

    protected double durabilidad;

    Desgaste desgaste;


   public void golpear(Material material){

       //material.gastarCon(this);
       durabilidad = desgastar();

    }


    public double desgastar(){
       return desgaste.aplicar(durabilidad, fuerza);
    }

    public double getDurabilidad(){

       return durabilidad;
    }

    public int getFuerza(){
        return fuerza;
    }

}
