public class Monstruo_lv1 extends Monstruo{
    //Parámetros
    private int fuerza;
    private int vida;
    private String forma;

    public Monstruo_lv1(int x, int y, int fuerza, int vida){
        super(x, y);

        setFuerza(5);
        setVida(10);
        setForma("1");
    }
}