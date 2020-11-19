import java.util.Arrays;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Tablero tabala1 = new Tablero();
        tabala1.llenarTablero();
        tabala1.printTablro();
        Tablero.iniciarJuego(tabala1);

    }
    
}
