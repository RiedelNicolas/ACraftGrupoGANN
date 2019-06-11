package Algocraft.Construccion;

import Algocraft.Excepciones.ConstruccionInvalidaException;
import Algocraft.Herramientas.*;
import Algocraft.Materiales.Material;
import Algocraft.Recetas.*;

import java.util.ArrayList;

public class Constructor {

    private RecetaPicoDeMadera recetaPicoDeMadera;
    private RecetaPicoDePiedra recetaPicoDePiedra;
    private RecetaPicoDeMetal recetaPicoDeMetal;
    private RecetaPicoFino recetaPicoFino;
    private RecetaHachaDeMadera recetaHachaDeMadera;
    private RecetaHachaDePiedra recetaHachaDePiedra;
    private RecetaHachaDeMetal recetaHachaDeMetal;


    public Constructor(){
        recetaPicoDeMadera = new RecetaPicoDeMadera();
        recetaPicoDePiedra = new RecetaPicoDePiedra();
        recetaPicoDeMetal = new RecetaPicoDeMetal();
        recetaPicoFino = new RecetaPicoFino();
        recetaHachaDeMadera = new RecetaHachaDeMadera();
        recetaHachaDePiedra = new RecetaHachaDePiedra();
        recetaHachaDeMetal = new RecetaHachaDeMetal();
    }

    public Herramienta construirCon(ArrayList<Material> elementosEnMesa){

        if(recetaPicoDeMadera.comparar(elementosEnMesa))
            return new PicoDeMadera();

        if(recetaPicoDePiedra.comparar(elementosEnMesa))
            return new PicoDePiedra();

        if(recetaPicoDeMetal.comparar(elementosEnMesa))
            return new PicoDeMetal();

        if(recetaPicoFino.comparar(elementosEnMesa))
            return new PicoFino();

        if(recetaHachaDeMadera.comparar(elementosEnMesa))
            return new HachaDeMadera();

        if(recetaHachaDePiedra.comparar(elementosEnMesa))
            return new HachaDePiedra();

        if(recetaHachaDeMetal.comparar(elementosEnMesa))
            return new HachaDeMetal();

        throw new ConstruccionInvalidaException();
    }


}
