package Modelo.Desgastes;

public interface Desgaste {

    //Metodos
    int aplicar(int durabilidad);
    int calcularUsosRestantes(int _durabilidad);
}
