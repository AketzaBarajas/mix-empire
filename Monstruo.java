import java.util.Random;

public abstract class Monstruo{
    protected int x;
    protected int y;
    protected String forma;
    protected int fuerza;
    protected int vida;

    public Monstruo(int x, int y){
        this.x=x;
        this.y=y;
    }

    //Getters
    public int getX(){return x;}
    public int getY(){return y;}
    public String getForma(){return forma;}
    public int getFuerza(){return fuerza;}
    public int getVida(){return vida;}

    //Setters
    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public void setForma(String forma){
        this.forma = forma;
    }

    public void setFuerza(int fuerza){
        this.fuerza = fuerza;
    }

    public void setVida(int vida){
        this.vida = vida;
    }

    //Método para recibir daño
    public boolean recibirDanyo(int danyo){
        this.vida -= danyo;
        return vida <= 0;
    }
}
