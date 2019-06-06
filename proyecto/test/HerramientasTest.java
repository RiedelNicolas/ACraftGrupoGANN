import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class HerramientasTest {

    @Test
    public void test01PicoDeMaderaSeCreaCon100DeDurabilidad() {
        Herramienta pico = new PicoDeMadera();
        assertEquals(100, pico.getDurabilidad());
    }

    @Test
    public void test02PicoDeMaderaSeCreaCon2DeFuerza() {
        Herramienta pico = new PicoDeMadera();
        assertEquals(2, pico.getFuerza());
    }

    @Test
    public void test03PicoDePiedraSeCreaCon200DeDurabilidad() {
        Herramienta pico = new PicoDePiedra();
        assertEquals(200, pico.getDurabilidad());
    }

    @Test
    public void test04PicoDePiedraSeCreaCon4DeFuerza() {
        Herramienta pico = new PicoDePiedra();
        assertEquals(4, pico.getFuerza());
    }

    @Test
    public void test05PicoDeMetalSeCreaCon400DeDurabilidad() {
        Herramienta pico = new PicoDeMetal();
        assertEquals(400, pico.getDurabilidad());
    }

    @Test
    public void test06PicoDeMetalSeCreaCon12DeFuerza() {
        Herramienta pico = new PicoDeMetal();
        assertEquals(12, pico.getFuerza());
    }

    @Test
    public void test07PicoFinoSeCreaCon1000DeDurabilidad() {
        Herramienta pico = new PicoFino();
        assertEquals(1000, pico.getDurabilidad());
    }

    @Test
    public void test08PicoFinoSeCreaCon20DeFuerza() {
        Herramienta pico = new PicoFino();
        assertEquals(20, pico.getFuerza());
    }

    @Test
    public void test09HachaDeMaderaSeCreaCon100DeDurabilidad() {
        Herramienta hacha = new HachaDeMadera();
        assertEquals(100, hacha.getDurabilidad());
    }

    @Test
    public void test10HachaDeMaderaSeCreaCon2DeFuerza() {
        Herramienta hacha = new HachaDeMadera();
        assertEquals(2, hacha.getFuerza());
    }

    @Test
    public void test11HachaDePiedraSeCreaCon200DeDurabilidad() {
        Herramienta hacha = new HachaDePiedra();
        assertEquals(200, hacha.getDurabilidad());
    }

    @Test
    public void test12HachaDePiedraSeCreaCon5DeFuerza() {
        Herramienta hacha = new HachaDePiedra();
        assertEquals(5, hacha.getFuerza());
    }

    @Test
    public void test13HachaDeMetalSeCreaCon400DeDurabilidad() {
        Herramienta hacha = new HachaDeMetal();
        assertEquals(400, hacha.getDurabilidad());
    }

    @Test
    public void test14HachaDeMetalSeCreaCon10DeFuerza() {
        Herramienta hacha = new HachaDeMetal();
        assertEquals(10, hacha.getFuerza());
    }


    @Test
    public void test15SeUsaHachaDeMaderaContraMaderaYPierde2DeDurabilidad(){

        Herramienta hacha = new HachaDeMadera();
        Material madera = new Madera();
        hacha.golpear(madera);

        assertEquals(98, hacha.getDurabilidad());
    }

    @Test
    public void test16SeUsaHachaDeMaderaContraPiedraYPierde2DeDurabilidad(){

        Herramienta hacha = new HachaDeMadera();
        Material piedra = new Piedra();
        hacha.golpear(piedra);

        assertEquals(98, hacha.getDurabilidad());

    }

    @Test
    public void test17SeUsaHachaDeMaderaContraMetalYPierde2DeDurabilidad(){

        Herramienta hacha = new HachaDeMadera();
        Material metal = new Metal();
        hacha.golpear(metal);

        assertEquals(98, hacha.getDurabilidad());

    }

    @Test
    public void test18SeUsaHachaDeMaderaContraDiamanteYPierde2DeDurabilidad() {

        Herramienta hacha = new HachaDeMadera();
        Material diamante = new Diamante();
        hacha.golpear(diamante);

        assertEquals(98, hacha.getDurabilidad());

    }

    @Test
    public void test19SeUsaHachaDePiedraContraMaderaYPierde5DeDurabilidad(){

        Herramienta hacha = new HachaDePiedra();
        Material madera = new Madera();
        hacha.golpear(madera);

        assertEquals(195, hacha.getDurabilidad());
    }

    @Test
    public void test20SeUsaHachaDePiedraContraPiedraYPierde5DeDurabilidad(){

        Herramienta hacha = new HachaDePiedra();
        Material piedra = new Piedra();
        hacha.golpear(piedra);

        assertEquals(195, hacha.getDurabilidad());

    }

    @Test
    public void test21SeUsaHachaDePiedraContraMetalYPierde5DeDurabilidad(){

        Herramienta hacha = new HachaDePiedra();
        Material metal = new Metal();
        hacha.golpear(metal);

        assertEquals(195, hacha.getDurabilidad());

    }

    @Test
    public void test22SeUsaHachaDePiedraContraDiamanteYPierde5DeDurabilidad() {

        Herramienta hacha = new HachaDePiedra();
        Material diamante = new Diamante();
        hacha.golpear(diamante);

        assertEquals(195, hacha.getDurabilidad());

    }


    @Test
    public void test23SeUsaHachaDeMetalContraMaderaYPierde5DeDurabilidad(){

        Herramienta hacha = new HachaDeMetal();
        Material madera = new Madera();
        hacha.golpear(madera);

        assertEquals(395, hacha.getDurabilidad());
    }

    @Test
    public void test24SeUsaHachaDeMetalContraPiedraYPierde5DeDurabilidad(){

        Herramienta hacha = new HachaDeMetal();
        Material piedra = new Piedra();
        hacha.golpear(piedra);

        assertEquals(395, hacha.getDurabilidad());

    }

    @Test
    public void test25SeUsaHachaDeMetalContraMetalYPierde5DeDurabilidad(){

        Herramienta hacha = new HachaDeMetal();
        Material metal = new Metal();
        hacha.golpear(metal);

        assertEquals(395, hacha.getDurabilidad());

    }

    @Test
    public void test26SeUsaHachaDeMetalContraDiamanteYPierde5DeDurabilidad(){

        Herramienta hacha = new HachaDeMetal();
        Material diamante = new Diamante();
        hacha.golpear(diamante);

        assertEquals(395, hacha.getDurabilidad());

    }

    @Test
    public void test27SeUsaPicoDeMaderaContraMaderaYPierde2DeDurabilidad(){

        Herramienta pico = new PicoDeMadera();
        Material madera = new Madera();
        pico.golpear(madera);

        assertEquals(98, pico.getDurabilidad());

    }

    @Test
    public void test28SeUsaPicoDeMaderaContraPiedraYPierde2DeDurabilidad(){

        Herramienta pico = new PicoDeMadera();
        Material piedra = new Piedra();
        pico.golpear(piedra);

        assertEquals(98, pico.getDurabilidad());

    }

    @Test
    public void test29SeUsaPicoDeMaderaContraMetalYPierde2DeDurabilidad(){

        Herramienta pico = new PicoDeMadera();
        Material metal = new Metal();
        pico.golpear(metal);

        assertEquals(98, pico.getDurabilidad());

    }

    @Test
    public void test30SeUsaPicoDeMaderaContraDiamanteYPierde2DeDurabilidad(){

        Herramienta pico = new PicoDeMadera();
        Material diamante = new Diamante();
        pico.golpear(diamante);

        assertEquals(98, pico.getDurabilidad());

    }

    @Test
    public void test31SeUsaPicoDePiedraContraMaderaYPierde3DeDurabilidad(){

        Herramienta pico = new PicoDePiedra();
        Material madera = new Madera();
        pico.golpear(madera);

        assertEquals(197, pico.getDurabilidad());

    }

    @Test
    public void test32SeUsaPicoDePiedraContraPiedraYPierde3DeDurabilidad(){

        Herramienta pico = new PicoDePiedra();
        Material piedra = new Piedra();
        pico.golpear(piedra);

        assertEquals(197, pico.getDurabilidad());

    }

    @Test
    public void test33SeUsaPicoDePiedraContraMetalYPierde3DeDurabilidad(){

        Herramienta pico = new PicoDePiedra();
        Material metal = new Metal();
        pico.golpear(metal);

        assertEquals(197, pico.getDurabilidad());

    }

    @Test
    public void test34SeUsaPicoDePiedraContraDiamanteYPierde3DeDurabilidad(){

        Herramienta pico = new PicoDePiedra();
        Material diamante = new Diamante();
        pico.golpear(diamante);

        assertEquals(197, pico.getDurabilidad());

    }

    @Test
    public void test35SeUsaPicoDeMetalContraMaderaYDurabilidadNoSeVeAfectadaTrasUnUso(){

        Herramienta pico = new PicoDeMetal();
        Material madera = new Madera();
        pico.golpear(madera);

        assertEquals(400, pico.getDurabilidad());

    }

    @Test
    public void test36SeUsaPicoDeMetalContraPiedraYDurabilidadNoSeVeAfectadaTrasUnUso(){

        Herramienta pico = new PicoDeMetal();
        Material piedra = new Piedra();
        pico.golpear(piedra);

        assertEquals(400, pico.getDurabilidad());

    }

    @Test
    public void test37SeUsaPicoDeMetalContraMetalYDurabilidadNoSeVeAfectadaTrasUnUso(){

        Herramienta pico = new PicoDeMetal();
        Material metal = new Metal();
        pico.golpear(metal);

        assertEquals(400, pico.getDurabilidad());

    }

    @Test
    public void test38SeUsaPicoDeMetalContraDiamanteYDurabilidadNoSeVeAfectadaTrasUnUso(){

        Herramienta pico = new PicoDeMetal();
        Material diamante = new Diamante();
        pico.golpear(diamante);

        assertEquals(400, pico.getDurabilidad());

    }

    @Test
    public void test39PicoDeMetalSeQuedaSinDurabilidadAlDecimoUsoContraMadera(){

        Herramienta pico = new PicoDeMetal();
        Madera madera = new Madera();

        for(int i=0; i<10; i++){
            pico.golpear(madera);
        }

        assertEquals(0, pico.getDurabilidad());
    }

    @Test
    public void test40PicoDeMetalSeQuedaSinDurabilidadAlDecimoUsoContraPiedra(){

        Herramienta pico = new PicoDeMetal();
        Material piedra = new Piedra();

        for(int i=0; i<10; i++){
            pico.golpear(piedra);
        }

        assertEquals(0, pico.getDurabilidad());
    }

    @Test
    public void test41PicoDeMetalSeQuedaSinDurabilidadAlDecimoUsoContraMetal(){

        Herramienta pico = new PicoDeMetal();
        Material metal = new Metal();

        for(int i=0; i<10; i++){
            pico.golpear(metal);
        }

        assertEquals(0, pico.getDurabilidad());

    }

    @Test
    public void test42PicoDeMetalSeQuedaSinDurabilidadAlDecimoUsoContraDiamante(){

        Herramienta pico = new PicoDeMetal();
        Material diamante = new Diamante();

        for(int i=0; i<10; i++){
            pico.golpear(diamante);
        }

        assertEquals(0, pico.getDurabilidad());

    }

    @Test
    public void test43PicoFinoSeUsaContraDiamanteYPierde100DeDurabilidad(){

        Herramienta pico = new PicoFino();
        Material diamante = new Diamante();
        pico.golpear(diamante);

        assertEquals(900, pico.getDurabilidad());

    }

    @Test
    public void test44SeUsaPicoFinoContraMaderaYDurabilidadNoSeVeAfectada(){

        Herramienta pico = new PicoFino();
        Material madera = new Madera();
        pico.golpear(madera);

        assertEquals(1000, pico.getDurabilidad());

    }

    @Test
    public void test45SeUsaPicoFinoContraPiedraYDurabilidadNoSeVeAfectada(){

        Herramienta pico = new PicoFino();
        Material piedra = new Piedra();
        pico.golpear(piedra);

        assertEquals(1000, pico.getDurabilidad());

    }

    @Test
    public void test46SeUsaPicoFinoContraMetalYDurabilidadNoSeVeAfectada(){

        Herramienta pico = new PicoFino();
        Material metal = new Metal();
        pico.golpear(metal);

        assertEquals(1000, pico.getDurabilidad());

    }

    @Test
    public void test47NoSePuedeUsarPicoDeMetalMasDe10Veces() {

        Herramienta pico = new PicoDeMetal();
        Diamante diamante = new Diamante();
        boolean herramientaRota = false;

        for (int i = 0; i < 10; i++) {
            pico.golpear(diamante);
        }

        try {
            pico.golpear(diamante);
        } catch (GolpesExcedidosException e) {
            herramientaRota = true;
        }

        assertTrue(herramientaRota);
    }
}
