package CinquilloGame;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class Canvas
{
    private JFrame frame;// MARCO DE LA VENTANA
    private CanvasPane canvas;// PANEL DE DIBUJO
    private Graphics2D graphic;// OBJETO PARA DIBUJAR GRÁFICOS
    private Color backgroundColor;// COLOR DE FONDO DEL CANVAS
    private Image canvasImage;// IMAGEN DEL CANVAS
    // CONSTRUCTOR QUE INICIALIZA EL CANVAS CON UN TÍTULO, TAMAÑO Y COLOR DE FONDO POR DEFECTO
    public Canvas(String title)
    {
        this(title, 300, 300, Color.white);
    }
    // CONSTRUCTOR QUE INICIALIZA EL CANVAS CON UN TÍTULO Y TAMAÑO ESPECÍFICO, COLOR DE FONDO POR DEFECTO
    public Canvas(String title, int width, int height)
    {
        this(title, width, height, Color.white);
    }

    public Canvas(String title, int width, int height, Color bgColor)
    {
        frame = new JFrame();
        canvas = new CanvasPane();
        frame.setContentPane(canvas);
        frame.setTitle(title);
        canvas.setPreferredSize(new Dimension(width, height));
        backgroundColor = bgColor;
        frame.pack();
        setVisible(true);
    }
    // MÉTODO PARA HACER VISIBLE EL CANVAS
    public void setVisible(boolean visible)
    {
        if(graphic == null) {
            // PRIMERA VEZ: INSTANCIAR LA IMAGEN FUERA DE PANTALLA Y LLENARLA CON EL COLOR DE FONDO
            Dimension size = canvas.getSize();
            canvasImage = canvas.createImage(size.width, size.height);
            graphic = (Graphics2D)canvasImage.getGraphics();
            graphic.setColor(backgroundColor);
            graphic.fillRect(0, 0, size.width, size.height);
            graphic.setColor(Color.black);
        }
        frame.setVisible(true);
    }

    public boolean isVisible()
    {
        return frame.isVisible();
    }

    public void draw(Shape shape)
    {
        graphic.draw(shape);
        canvas.repaint();
    }
    
    public void fill(Shape shape)
    {
        graphic.fill(shape);
        canvas.repaint();
    }

    public void fillCircle(int xPos, int yPos, int diameter)
    {
        Ellipse2D.Double circle = new Ellipse2D.Double(xPos, yPos, diameter, diameter);
        fill(circle);
    }

    public void fillRectangle(int xPos, int yPos, int width, int height)
    {
        fill(new Rectangle(xPos, yPos, width, height));
    }

    public void erase()
    {
        Color original = graphic.getColor();
        graphic.setColor(backgroundColor);
        Dimension size = canvas.getSize();
        graphic.fill(new Rectangle(0, 0, size.width, size.height));
        graphic.setColor(original);
        canvas.repaint();
    }

    public void eraseCircle(int xPos, int yPos, int diameter)
    {
        Ellipse2D.Double circle = new Ellipse2D.Double(xPos, yPos, diameter, diameter);
        erase(circle);
    }

    public void eraseRectangle(int xPos, int yPos, int width, int height)
    {
        erase(new Rectangle(xPos, yPos, width, height));
    }

    public void erase(Shape shape)
    {
        Color original = graphic.getColor();
        graphic.setColor(backgroundColor);
        graphic.fill(shape);              // erase by filling background color
        graphic.setColor(original);
        canvas.repaint();
    }

    public void eraseOutline(Shape shape)
    {
        Color original = graphic.getColor();
        graphic.setColor(backgroundColor);
        graphic.draw(shape);  // erase by drawing background color
        graphic.setColor(original);
        canvas.repaint();
    }

    public boolean drawImage(Image image, int x, int y)
    {
        boolean result = graphic.drawImage(image, x, y, null);
        canvas.repaint();
        return result;
    }

    public void drawString(String text, int x, int y)
    {
        graphic.drawString(text, x, y);   
        canvas.repaint();
    }

    public void eraseString(String text, int x, int y)
    {
        Color original = graphic.getColor();
        graphic.setColor(backgroundColor);
        graphic.drawString(text, x, y);   
        graphic.setColor(original);
        canvas.repaint();
    }

    public void drawLine(int x1, int y1, int x2, int y2)
    {
        graphic.drawLine(x1, y1, x2, y2);   
        canvas.repaint();
    }

    public void setForegroundColor(Color newColor)
    {
        graphic.setColor(newColor);
    }

    public Color getForegroundColor()
    {
        return graphic.getColor();
    }

    public void setBackgroundColor(Color newColor)
    {
        backgroundColor = newColor;   
        graphic.setBackground(newColor);
    }

    public Color getBackgroundColor()
    {
        return backgroundColor;
    }

    public void setFont(Font newFont)
    {
        graphic.setFont(newFont);
    }

    public Font getFont()
    {
        return graphic.getFont();
    }
    // MÉTODO PARA ESTABLECER EL TAMAÑO DEL CANVAS
    public void setSize(int width, int height)
    {
        canvas.setPreferredSize(new Dimension(width, height));
        Image oldImage = canvasImage;
        canvasImage = canvas.createImage(width, height);
        graphic = (Graphics2D)canvasImage.getGraphics();
        graphic.setColor(backgroundColor);
        graphic.fillRect(0, 0, width, height);
        graphic.drawImage(oldImage, 0, 0, null);
        frame.pack();
    }
    // MÉTODO PARA OBTENER EL TAMAÑO DEL CANVAS
    public Dimension getSize()
    {
        return canvas.getSize();
    }
    // MÉTODO PARA ESPERAR UN DETERMINADO TIEMPO
    public void wait(int milliseconds)
    {
        try
        {
            Thread.sleep(milliseconds);
        } 
        catch (InterruptedException e)
        {
            // IGNORAR LA EXCEPCIÓN POR AHORA
        }
    }
    // CLASE INTERNA QUE REPRESENTA EL PANEL DE DIBUJO
    // MÉTODO PARA DIBUJAR LA IMAGEN DEL CANVAS
    private class CanvasPane extends JPanel
    {
        public void paint(Graphics g)
        {
            g.drawImage(canvasImage, 0, 0, null);
        }
    }
}