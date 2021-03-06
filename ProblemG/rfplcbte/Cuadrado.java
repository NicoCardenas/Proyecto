package rfplcbte; 
import java.util.*;
import shapes.*;

/**
 * A square that can be manipulated and that draws itself on a canvas.
 * 
 * @author  Paola Cuellar
 * @author Nicolás Cárdenas
 * @version 1.5  (18 September 2017)
 */

public class Cuadrado{

    private int height;
    private int width;
    private int xPosition;
    private int yPosition;
    private String color;
    private boolean isVisible;
    private Stack<String> colorOrigin;
    private int perimeter;
    private String type;

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
        type = "normal";
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
     * Modifica el tamaño del cuadrado. 
     */
    public void setSize(int size){
        height = size;
        width = size;
    }
    
    /**
     * Modifica la posición del cuadrado. 
     */
    public void setPosition(int x, int y){
        xPosition = x;
        yPosition = y;
    }
    
    /**
     * Retorna un entero .
     * @return Retorna el tamaño del cuadrado. 
     */
    public int getSize(){
        return width;
    }
    
    /**
     * Retorna un entero .
     * @return Retorna la posición en X del cuadrado. 
     */
    public int getPositionX(){
        return xPosition;
    }
    
    /**
     * Retorna un entero .
     * @return Retorna la posición en Y del cuadrado. 
     */
    public int getPositionY(){
        return yPosition;
    }
    
    /**
     * 
     */
    public void setOriginColor(String color){
        colorOrigin.push(color);
    }
    
    /**
     * 
     */
    public String popOriginColor(){
        return colorOrigin.pop();
    }
}