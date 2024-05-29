package CinquilloGame;
import java.util.Scanner;
import java.awt.*;

import java.awt.Color;
import java.util.Scanner;

public class CinquilloGame {

    public static void main(String[] args) {
        // SE CREA UN OBJETO SCANNER PARA LEER LA ENTRADA DEL USUARIO
        Scanner scn = new Scanner(System.in);
        // SE DECLARA UN OBJETO CANVAS
        Canvas cvs;
        // SE INICIALIZA EL OBJETO CANVAS CON UN TÍTULO, DIMENSIONES Y COLOR DE FONDO
        cvs = new Canvas("Quintillo game", 900, 700, Color.red);
        // SE HACE VISIBLE EL OBJETO CANVAS
        cvs.setVisible(true);
        // SE CREA UNA NUEVA INSTANCIA DE LA CLASE JUEGO
        Juego quintillo = new Juego();
        int n;
        do{
            // SE LLAMA AL MÉTODO JUGAR DEL OBJETO JUEGO
            quintillo.jugar();
            // SE PREGUNTA AL USUARIO SI DESEA VOLVER A JUGAR
            System.out.println("INGRESA SI QUIERES VOLVER A JUGAR");
            System.out.println("1) Si \n2)No");
            n = scn.nextInt();
        }while(n != 2);
        System.out.println("HASTA LA PROXIMA");
    }
}
