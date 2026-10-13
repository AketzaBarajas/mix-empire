public class Monstruo_lv2 extends Monstruo{
    
    //Parámetros
    private int fuerza;
    private int vida;
    private String forma;

    public Monstruo_lv2(int x, int y, int fuerza, int vida){
        super(x, y);

        setFuerza(10);
        setVida(20);
        setForma("2");
    }
}
