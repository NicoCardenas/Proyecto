package rfplcbte;

import java.util.*;

/**
 * Write a description of class Floja here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Floja extends Celula{
    
    private int count;

    /**
     * Constructor for objects of class Floja
     */
    public Floja(int xPosition, int yPosition, int size){
        height = size;
        width = size;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        color = "light gray";
        isVisible = false;
    }
    
    /**
     * Constructor for objects of class CuadradoEven
     */
    public Floja(int xPosition, int yPosition, int size, Stack<String> listColors){
        height = size;
        width = size;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        color = "light gray";
        this.colorOrigin = listColors;
        isVisible = false;
    }
    
    public void replicate(int vecinos){
        count+=1;
        if (count%2 == 0 && vecinos%2 == 0){
            this.changeColor("dark red");
        }else if (vecinos%2 != 0){
            this.changeColor("light gray");
        }
    }
}
