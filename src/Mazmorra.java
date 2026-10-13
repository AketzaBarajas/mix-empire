import java.util.ArrayList;
import java.util.Random;

public class Mazmorra {
    private int [][] mazmorra1; //La matriz que va a ocupar la mazmorra
    private int x,y; // Los valores de x e y
    private ArrayList<Monstruo> monstruos = new ArrayList<>(); // La lista de monstruos que van a existir
    public Personaje jugador;
    private Random random = new Random();

    //Constructor de la mazmorra
    public Mazmorra(int x, int y){
        this.x=x;
        this.y=y;
        this.mazmorra1=new int [x][y]; // Inicializamos la matriz
        this.jugador = new Personaje(5, 0);
        colocarMonstruo(5);
    }

    // Función para colocar aleatoriamente un monstruo en el mapa
    public void colocarMonstruo(int cantidad){
        int colocados = 0;
        while (colocados < cantidad){
            int i = random.nextInt(x); //Establece un valor i aleatorio
            int j = random.nextInt(y); //Establece un valor j aleatorio 
            int seleccion = random.nextInt(2);

            if (mazmorra1[i][j]==0){
                mazmorra1[i][j]=1; //Le da a la posición el valor de 1
                if (seleccion == 0){
                    monstruos.add(new Monstruo_lv1(i, j, 5, 25)); //Añade un mosntruo a la lista con las coordenadas donde ha sico comprobado
                }
                else if(seleccion == 1){
                    monstruos.add(new Monstruo_lv2(i, j, 10, 40));
                }                
                else{
                    monstruos.add(new Monstruo_lv3(i, j, 20, 55));
                }
                colocados++;  //Suma el número de monstruos en el mapa
            }

        }
    
    }

    // Función para monstrar una mazmorra
    public void mostrarMazmorra(){
        jugador.espada(jugador.getFuerza());
        jugador.escudo(jugador.getVida());
        for (int i=0;i<x;i++){ //Comprueba cada espacio del mapa uno por uno
            for (int j=0;j<y;j++){
                if (i==jugador.getX() && j==jugador.getY()){
                    System.out.print('&'); // Punto de inicio como referencia
                }
                else if (this.mazmorra1[i][j]==1){
                    for(Monstruo monstruo : monstruos){
                        if (monstruo.getX() == i && monstruo.getY() == j){
                            System.out.print(monstruo.getForma());
                        }
                    }
                }
                else{
                    System.out.print('█'); //Espacio en blanco
                }
            }
            System.out.println();
        }
    }

    //Función para mover al jugador
    public boolean moverJugador(char direccion){
        int corX = jugador.getX();
        int corY = jugador.getY();
        jugador.mover(direccion,x,y);
        return comprobarMonstruo();
    }

    //Función para comprobar si hay monstruo o no
    public boolean comprobarMonstruo(){
        for (Monstruo monstruo : monstruos){
            if (jugador.getX() == monstruo.getX() && jugador.getY() == monstruo.getY()){
                System.out.println("¡Te has encontrado con un monstruo!");
                return pelear(monstruo);
            }
        }
        return false;
    }

    //Función para el manejo del combate
    private boolean pelear(Monstruo monstruo){

        //Bucle que comprueba que tanto usuario como monstruo estén vivos
        while (jugador.getVida() >0 && monstruo.getVida() >0){
            int fuerzaJugador = new Random().nextInt(5)+5;
            int fuerzaMonstruo =  monstruo.getFuerza();

            //Turno del jugador
            System.out.println("Atacas al monstruo con una fuerza "+ fuerzaJugador);
            boolean monstruoMuerto = monstruo.recibirDanyo(fuerzaJugador); //Variable booleana para ver si en el ataque el monstruo ha muerto

            if (monstruoMuerto){
                System.out.println("¡Has derrotado al monstruo!");
                monstruos.remove(monstruo); //Elimina al monstro de la lista
                mazmorra1[monstruo.getX()][monstruo.getY()]=0; //Elimina al monstruo del mapa
            }
            else{
                 //Turno del monstruo
            System.out.println("Turno del monstruo, que te ataca con una fuerza "+ fuerzaMonstruo);
            boolean jugadorMuerto = jugador.recibirDanyo(fuerzaMonstruo);

            if (jugadorMuerto){
                System.out.println("¡Has sido derrotado!");
                return true; //Finalizar el juego
            }
            System.out.println("Tu vida actual: " + jugador.getVida());
            }
           
        }
        return false;
    }
}