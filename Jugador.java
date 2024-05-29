package CinquilloGame;

import java.util.ArrayList;

public class Jugador {
    // DECLARACIÓN DE UNA LISTA QUE CONTIENE LAS CARTAS QUE EL JUGADOR TIENE EN MANO
    private ArrayList<Carta> mazoEnMano;
    private String nombre;
        // CONSTRUCTOR QUE INICIALIZA EL NOMBRE DEL JUGADOR Y LA LISTA DE CARTAS EN MANO
        public Jugador()
        {
            this.nombre = "";
            mazoEnMano = new ArrayList();
        }
        // MÉTODO PARA ASIGNAR UN NOMBRE AL JUGADOR
        public void setNombre(String n)
        {
            this.nombre = n;
        }
        // MÉTODO PARA OBTENER EL NOMBRE DEL JUGADOR
        public String getNombre()
        {
            return nombre;
        }
        // MÉTODO PARA AÑADIR UNA CARTA A LA MANO DEL JUGADOR
        public void recibirCarta(Carta aux)
        {
            mazoEnMano.add(aux);
        }
        // MÉTODO PARA MOSTRAR LAS CARTAS QUE EL JUGADOR TIENE EN MANO
        public void verCartasEnMano()
        {
            System.out.println(mazoEnMano.toString()+"\n");
        }
        // MÉTODO PARA REMOVER UNA CARTA DE LA MANO DEL JUGADOR DADO SU ÍNDICE
        public Carta removerCarta(int indice)
        {
            return mazoEnMano.remove(indice);
        }
        // MÉTODO PARA OBTENER UNA CARTA EN MANO DADO SU ÍNDICE
        public Carta getCartaEnMano(int indice){
            return mazoEnMano.get(indice);
        }
        // MÉTODO PARA OBTENER EL NÚMERO DE CARTAS QUE EL JUGADOR TIENE EN MANO
        public int getNumeroCartas()
        {
            return mazoEnMano.size();
        }
}
