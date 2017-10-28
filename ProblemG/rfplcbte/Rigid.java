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
        super(xPosition, yPosition, size);
        color = "black";
        type = "rigid";
        isVisible = false;
    }
    
    /**
     * Constructor for objects of class CuadradoEven
     */
    public Rigid(int xPosition, int yPosition, int size, Stack<String> listColors){
        super(xPosition, yPosition, size, listColors);
        type = "rigid";
        color = "black";
        isVisible = false;
    }
    
    public void replicate(int vecinos){
    }
}
