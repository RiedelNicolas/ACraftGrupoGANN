public abstract class Herramienta {

    protected int fuerza;

    protected int durabilidad;

    Desgaste desgaste;


   abstract public void golpear(Material material);

    public int desgastar(){
       return desgaste.aplicar(durabilidad);
    }

    public int getDurabilidad(){

       return durabilidad;
    }

    public int getFuerza(){
        return fuerza;
    }

}
