package rfplcbte;

import java.util.*;

/**
 * Write a description of class CuadradoRigid here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rigid extends Celula{

    /**
     * Constructor for objects of class CuadradoRigid
     */
    public Rigid(int xPosition, int yPosition, int size){
        height = size;
        width = size;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        color = "black";
        isVisible = false;
    }
    
    /**
     * Constructor for objects of class CuadradoEven
     */
    public Rigid(int xPosition, int yPosition, int size, Stack<String> listColors){
        height = size;
        width = size;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        color = "light gray";
        this.colorOrigin = listColors;
        isVisible = false;
    }
    
    public void replicate(int vecinos){
    }
}
