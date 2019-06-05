public abstract class Herramienta {

    protected int fuerza;

    private int durabilidad;

  //  Desgaste desgaste;


   /* public void golpear(Material material){

        material.gastarCon(this);
        durabilidad = desgastar();

    }*/

/*
    public int desgastar(){
        return desgaste.aplicar();
    }*/

    public int getDurabilidad(){
        return durabilidad;
    }

    public int getFuerza(){
        return fuerza;
    }


    public void setDurabilidad(int durabilidad) {
        this.durabilidad = durabilidad;
    }
}
