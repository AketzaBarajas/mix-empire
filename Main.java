import java.util.Scanner;

public class Main {
    public static void main(String[] argumentos){
        Scanner scanner = new Scanner(System.in);
        
        //Creamos la mazmorra de nivel 1
        Mazmorra mazmorra1 = new Mazmorra(11,25);

        //Creamos la variable gameOver para saber cuando se ha perdido
        boolean gameOver = false; 
        
        while (!gameOver){
            //Mostramos el mapa
            mazmorra1.mostrarMazmorra();
            System.out.println("Mueva con W A S D y presiona Enter: ");
            char movimiento = scanner.next().charAt(0);
            gameOver = mazmorra1.moverJugador(movimiento);
        }
        System.out.println("Ha terminado el juego. Gracias por jugar");
        scanner.close();
        
        }
    }