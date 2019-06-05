public class Jugador {
    //Atributos
    private Herramienta HerramientaEnMano;

    //Metodos
    public Jugador() {
        HerramientaEnMano = new HachaDeMadera();
    }

    public Herramienta getHerramientaEnMano(){
        return HerramientaEnMano;
    }


}
