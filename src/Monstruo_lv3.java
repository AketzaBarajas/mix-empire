public class Monstruo_lv3 extends Monstruo{

    private int fuerza;
    private int vida;
    
    public Monstruo_lv3(int x, int y, int fuerza, int vida){
        super(x, y);

        setFuerza(20);
        setVida(40);
        setForma("3");
    }
}
