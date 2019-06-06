public abstract class Herramienta {

    //Atributos
    protected int fuerza;

    protected int durabilidad;

    Desgaste desgaste;


    //Métodos
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
