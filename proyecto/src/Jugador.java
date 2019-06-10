public class Jugador extends Posicionable{
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
