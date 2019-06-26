package Modelo.Desgastes;

public interface Desgaste {

    int aplicar(int durabilidad);
    int calcularUsosRestantes(int _durabilidad);
}
