package rfplcbte;

import java.util.*;

/**
 * Write a description of class CuadradoSocial here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Social extends Celula{

    /**
     * Constructor for objects of class CuadradoSocial
     */
    public Social(int xPosition, int yPosition, int size){
        super(xPosition, yPosition, size);
        color = "light gray";
        type = "social";
        isVisible = false;
    }
    
    /**
     * Constructor for objects of class CuadradoEven
     */
    public Social(int xPosition, int yPosition, int size, Stack<String> listColors){
        super(xPosition, yPosition, size, listColors);
        color = "light gray";
        type = "social";
        isVisible = false;
    }
    
    public void replicate(int vecinos){
        if (vecinos%2 != 0){
            this.changeColor("violeta");
        }else if (vecinos == 0){
            this.changeColor("light gray");
        }
    }
}
