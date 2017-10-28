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
        super(xPosition, yPosition, size);
        color = "light gray";
        type = "floja";
        isVisible = false;
    }
    
    /**
     * Constructor for objects of class CuadradoEven
     */
    public Floja(int xPosition, int yPosition, int size, Stack<String> listColors){
        super(xPosition, yPosition, size, listColors);
        type = "floja";
        color = "light gray";
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
