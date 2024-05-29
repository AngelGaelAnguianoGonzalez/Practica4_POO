package CinquilloGame;

public class Carta {
    private int valor;
    private String palo;
    private boolean isVisible;
        // CONSTRUCTOR POR DEFECTO QUE INICIALIZA LOS ATRIBUTOS A VALORES POR DEFECTO
        public Carta()
        {
            this.palo = "";
            this.valor = 0;
            this.isVisible = true;
        }
        // CONSTRUCTOR QUE INICIALIZA LOS ATRIBUTOS CON VALORES ESPECÍFICOS
        public Carta(int val, String p, boolean v)
        {
            this.valor = val;
            this.palo = p;
            this.isVisible = v;
        }
        
        public int getValor()
        {
            return valor;
        }
        
        public String getPalo()
        {
            return palo;
        }
        
        public void setValor(int v)
        {
            this.valor = v;
        }
        
        public void setPalo(String p)
        {
            this.palo = p;
        }
        
        public void voltearCarta()
        {
            if(isVisible == true)
            {
                isVisible = false;
            }
            else
            {
                isVisible = true;
            }
        }
        // MÉTODO QUE DEVUELVE UNA REPRESENTACIÓN EN STRING DE LA CARTA
        @Override
        public String toString()
        {
            if(isVisible == true)
            {
                return "[ "+valor+" / "+palo+" ]";
            }
            else
            {
                return "[ Espanola ]";
            }
        }
}
