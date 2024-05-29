package CinquilloGame;

import java.util.ArrayList;
import java.util.Collections;

public class Baraja {
    // DECLARACIÓN DE UNA LISTA QUE CONTIENE LAS CARTAS DE LA BARAJA ESPAÑOLA
    private ArrayList<Carta> barajaEspanola;
    // ARREGLO QUE CONTIENE LOS TIPOS DE PALOS DE LAS CARTAS
    private String[] tipoPalo = {"Oros","Copas","Espadas","Bastos"};
    // ARREGLO QUE CONTIENE LOS VALORES DE LAS CARTAS
    private int[] valoresCarta = {1, 2, 3, 4, 5, 6, 7, 10, 11, 12};
    // CONSTRUCTOR QUE INICIALIZA LA LISTA DE CARTAS
        public Baraja()
        {
            barajaEspanola = new ArrayList();
        }
        // MÉTODO PARA CREAR LA BARAJA DE CARTAS
        public void crearBaraja()
        {
            // RECORRE TODOS LOS TIPOS DE PALOS
            for(int i = 0; i < tipoPalo.length; i++)
            {
                // RECORRE TODOS LOS VALORES DE CARTAS
                for(int j = 0; j < valoresCarta.length; j++)
                {
                    // AÑADE UNA NUEVA CARTA A LA BARAJA
                    barajaEspanola.add(new Carta(valoresCarta[j], tipoPalo[i], true) );
                }
            }
        }
        // MÉTODO PARA MOSTRAR LA BARAJA COMPLETA
        public void verBaraja()
        {
            System.out.println(barajaEspanola.toString());
        }
        // MÉTODO PARA MEZCLAR LAS CARTAS DE LA BARAJA
        public void revolverBaraja()
        {
            Collections.shuffle(barajaEspanola);
        }
        // MÉTODO PARA VOLTEAR TODAS LAS CARTAS DE LA BARAJA
        public void voltearBaraja()
        {
            for(int i = 0; i < barajaEspanola.size(); i++)
            {
                barajaEspanola.get(i).voltearCarta();
            }
        }
        // MÉTODO PARA DAR UNA CARTA (REMOVER LA PRIMERA CARTA DE LA BARAJA)
        public Carta darCarta()
        {
            return barajaEspanola.remove(0);
        }
        // MÉTODO PARA OBTENER EL NÚMERO DE CARTAS RESTANTES EN LA BARAJA
        public int getNumeroCartasEnMesa()
        {
            return barajaEspanola.size();
        }
        
}