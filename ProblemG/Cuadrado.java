import java.awt.*;

/**
 * A square that can be manipulated and that draws itself on a canvas.
 * 
 * @author  Paola Cuellar
 * @author Nicolás Cárdenas
 * @version 1.1  (03 September 2017)
 */


 
public class Cuadrado{

    private int height;
    private int width;
    private int xPosition;
    private int yPosition;
    private String color;
    private boolean isVisible;
    private String ColorOrigin;
    private int perimeter;
    private boolean error;

    /**
     * Create a new square at default position with default color.
     */
    public Cuadrado(){
        height = 40;
        width = 40;
        xPosition = 0;
        yPosition = 0;
        color = "light gray";
        isVisible = false;
        error = false;
    }
    
    /**
     * Crear un cuadrado en las posiciones y el tamaño indicado
     */
    public Cuadrado(int xPosition, int yPosition, int size){
        height = size;
        width = size;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        color = "light gray";
        isVisible = false;
    }

    /**
     * Make this square visible. If it was already visible, do nothing.
     */
    public void makeVisible(){
        isVisible = true;
        draw();
    }
    
    /**
     * Make this square invisible. If it was already invisible, do nothing.
     */
    public void makeInvisible(){
        erase();
        isVisible = false;
    }

    /**
     * Move the square horizontally.
     * @param distance the desired distance in pixels
     */
    public void moveHorizontal(int distance){
        erase();
        xPosition += distance;
        draw();
    }

    /**
     * Move the square vertically.
     * @param distance the desired distance in pixels
     */
    public void moveVertical(int distance){
        erase();
        yPosition += distance;
        draw();
    }
    
    /**
     * Change the color. 
     * @param color the new color. Valid colors are "red", "yellow", "blue", "green",
     * "magenta" and "black".
     */
    public void changeColor(String newColor){
        color = newColor;
        draw();
    }          

    /*
     * Draw the rectangle with current specifications on screen.
     */

    private void draw() {
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.draw(this, color,
                new java.awt.Rectangle(xPosition, yPosition, width, height));
            canvas.wait(0);
        }
    }

    /*
     * Erase the rectangle on screen.
     */
    private void erase(){
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(this);
        }
    }
    /**
     * El método getColor retorna el color del Cuadrado.
     * @return color
     */
    public String getColor(){
        return color;
    }
    
    /**
     * El método getError retorna si el Cuadrado tiene error.
     * @return error un valor booleano que determina si tiene error.
     */
    public boolean getError(){
        return error;
    }
    
     /**
     * El método setError asigna un boleano que determina si tiene error.
     * @param value es si tiene error o no.
     */
    public void setError(boolean value){
         error = value;
    }
    
}