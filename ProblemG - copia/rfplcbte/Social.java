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
    public Social(int xPosition, int yPosition, int size, Stack<String> listColors){
        height = size;
        width = size;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        color = "light gray";
        this.colorOrigin = listColors;
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
