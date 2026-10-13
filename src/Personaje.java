class Personaje implements Espada, Escudo{
    private int vida;
    private int x;
    private int y;
    private int fuerza;

    public Personaje(int i, int j) {
        this.vida = 30;
        this.x=x;
        this.y=y;
        this.fuerza = fuerza;
    }

    //Getters
    public int getX(){return x;}
    public int getY(){return y;}
    public int getVida(){return vida;}
    public int getFuerza(){return fuerza;}

    //Función para mover al personaje
    public void mover(char direccion, int maxX, int maxY){
        switch (direccion) {
            case 'w': if (x>0) x--; break;
            case 's': if (x<maxX-1) x++; break;
            case 'a': if (y>0) y--; break;
            case 'd': if (y<maxY-1) y++; break;
            default: System.out.println("Movimiento inválido");
        }
    }

    //Función para recibir daño
    public boolean recibirDanyo(int danyo){
        this.vida-= danyo;
        return vida<=0; //Retorna un True si la vida llega a 0
    }

    public void espada(int fuerza){
        this.fuerza = fuerza + 5;
        System.out.println("Llevas una espada contigo");
    }

    public void escudo(int vida){
        this.vida = vida + 10;
        System.out.println("Te has echado un miniescudo");

    }

    @Override
    public void escudo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'escudo'");
    }

    @Override
    public void espada() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'espada'");
    }
}