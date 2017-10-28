package rfplcbte;

import java.util.*;
import shapes.*;

/**
 * Abstract class CelulaP - write a description of the class here
 * 
 * @author: 
 * Date: 
 */
public abstract class Celula{
    protected int height;
    protected int width;
    protected int xPosition;
    protected int yPosition;
    protected String color;
    protected boolean isVisible;
    protected Stack<String> colorOrigin;
    
    public abstract void replicate(int vecinos);
    
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
    
    public Stack<String> getColorOrigin(){
        return colorOrigin;
    }
}
