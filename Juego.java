package CinquilloGame;

import java.util.ArrayList;
import java.util.Scanner;

public class Juego {
    private ArrayList<Jugador> jugadores;
    private Baraja barajaJuego;
    private Carta cartaTablero;
    private int numJugadores;
    private String tablero;
        public Juego()
        {
            this.numJugadores = 0;
            jugadores = new ArrayList();
            barajaJuego = new Baraja();
            cartaTablero = new Carta();
            tablero = "";
        }
        
        public void jugar()
        {
            Scanner s = new Scanner(System.in);
            boolean jugadorSinCartas = false;
            int n;
            int turno = 0;
            asignarNumeroJugadores();
            repartirCartas();
            
            System.out.println("Inicio juego el quintillo. \n");
            do{
                System.out.println("CARTA EN LA MESA: \tCARTAS DE BARAJA RESTANTES: "+barajaJuego.getNumeroCartasEnMesa());
                System.out.println(tablero+"\n");
            
                System.out.println("CARTAS DE: "+jugadores.get(turno).getNombre());
                jugadores.get(turno).verCartasEnMano();
            
                System.out.println("INGRESE EL INDICE DEL NUMERO DE CARTA QUE DESEA INGRESAR: ");
                n = s.nextInt();
            
                if(tablero.isEmpty())
                // SI EL TABLERO ESTÁ VACÍO, SE COLOCA LA PRIMERA CARTA
                {
                    cartaTablero = jugadores.get(turno).removerCarta(n-1);
                    tablero = cartaTablero.toString();
                }
                else if(cartaTablero.getPalo().equals(jugadores.get(turno).getCartaEnMano(n-1).getPalo()) || cartaTablero.getValor() == jugadores.get(turno).getCartaEnMano(n-1).getValor())
                {
                     // SI LA CARTA ES VÁLIDA, SE COLOCA EN EL TABLERO
                    cartaTablero = jugadores.get(turno).removerCarta(n-1);
                    tablero = cartaTablero.toString();
                    System.out.println("Tu carta fue colocada. \n");
                }
                else
                {
                    // SI LA CARTA NO ES VÁLIDA, EL JUGADOR TOMA UNA CARTA DE LA BARAJA
                    if(barajaJuego.getNumeroCartasEnMesa() > 0)
                    {
                        System.out.println("NO SE PUEDE COLOCAR EN EL TABLERO. TOMA UNA CARTA MAS.");
                        jugadores.get(turno).recibirCarta(barajaJuego.darCarta());
                        System.out.println(jugadores.get(turno).getCartaEnMano(jugadores.get(turno).getNumeroCartas()-1));
                        // SE VERIFICA SI LA NUEVA CARTA ES VÁLIDA
                        if(cartaTablero.getPalo().equals(jugadores.get(turno).getCartaEnMano(jugadores.get(turno).getNumeroCartas()-1).getPalo()) 
                        || cartaTablero.getValor() == jugadores.get(turno).getCartaEnMano(jugadores.get(turno).getNumeroCartas()-1).getValor())
                        {
                            cartaTablero = jugadores.get(turno).removerCarta(jugadores.get(turno).getNumeroCartas()-1);
                            tablero = cartaTablero.toString();
                            System.out.println("TU CARTA FUE COLOCADA EN EL TABLERO. \n");
                        }
                        else
                        {
                            System.out.println("LA CARTA QUE TOMASTE DE LA BARAJA NO SE PUDO COLOCAR. \n");
                        }
                    }
                    else
                    {
                        System.out.println("SE AGOTARON LAS CARTAS DE LA BARAJA, AHORA ES EL TURNO DEL SIGUIENTE JUGADOR. \n");
                    }
                }
                // SE VERIFICA SI EL JUGADOR ACTUAL NO TIENE MÁS CARTAS
                if(jugadores.get(turno).getNumeroCartas() == 0)
                {
                    System.out.println("EL GANADOR ES: "+jugadores.get(turno).getNombre());
                    System.out.println("FELICIDADES.");
                    jugadorSinCartas = true;
                }
                else
                {
                    System.out.println("\nSIGUIENTE JUGADOR. \n\n");
                }
                // SE CAMBIA EL TURNO AL SIGUIENTE JUGADOR
                if(turno == (jugadores.size()-1))
                {
                    turno = 0;
                }
                else
                {
                    turno++;
                }
            // EL BUCLE SE REPITE HASTA QUE HAYA UN JUGADOR SIN CARTAS    
            }while(jugadorSinCartas!=true);
            
        }
        // MÉTODO PARA ASIGNAR EL NÚMERO DE JUGADORES
        public void asignarNumeroJugadores()
        {
            int n;
            String nomAux;
            Scanner scn = new Scanner(System.in);
            Scanner scnCadenas = new Scanner(System.in);
            
            System.out.println("INGRESE NUMERO DE JUGADORES:(2-4)");
            n = scn.nextInt();
            while(n < 2 || n > 4)
            {
                System.out.println("INGRESA UN NUMERO DENTRO DEL RANGO: ");
                n = scn.nextInt();
            }
            
            for(int i = 0; i < n; i++)
            {
                jugadores.add(new Jugador());// SE AÑADE UN NUEVO JUGADOR A LA LISTA
                System.out.println("INGRESE EL NOMBRE DEL JUGADOR "+(i+1)+": ");
                nomAux = scnCadenas.nextLine();// SE LEE EL NOMBRE DEL JUGADOR
                jugadores.get(i).setNombre(nomAux);// SE ASIGNA EL NOMBRE AL JUGADOR
            }
            
            System.out.println("SE CREARON LOS JUGADORES\n");
        }
        // MÉTODO PARA REPARTIR LAS CARTAS A LOS JUGADORES
        public void repartirCartas()
        {
            barajaJuego.crearBaraja();// SE CREA LA BARAJA
            barajaJuego.revolverBaraja();// SE MEZCLA LA BARAJA
            // SE REPARTEN LAS CARTAS A LOS JUGADORES
            for(int i = 0; i < jugadores.size(); i++)
            {
                for(int j = 0; j < 4; j++)
                {
                    jugadores.get(i).recibirCarta(barajaJuego.darCarta());
                }
            }
        }
   
}
