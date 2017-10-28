package rfplcbte;

import java.util.*;

/**
 * Write a description of class CuadradoEven here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Even extends Celula{

    /**
     * Constructor for objects of class CuadradoEven
     */
    public Even(int xPosition, int yPosition, int size){
        super(xPosition, yPosition, size);
        color = "light gray";
        type = "even";
        isVisible = false;
    }
    
    /**
     * Constructor for objects of class CuadradoEven
     */
    public Even(int xPosition, int yPosition, int size, Stack<String> listColors){
        super(xPosition, yPosition, size, listColors);        
        type = "even";
        color = "light gray";
        isVisible = false;
    }
    
    public void replicate(int vecinos){
        if (vecinos%2 == 0){
            this.changeColor("cyan");
        }else if (vecinos%2 != 0){
            this.changeColor("light gray");
        }
    }
}
