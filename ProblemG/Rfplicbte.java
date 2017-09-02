import java.util.*;

/**
 * A square that can be manipulated and that draws itself on a canvas.
 * 
 * @author  Paola Cuellar y Nicolás Cárdenas
 * @version 1.0  (29 August 2017)
 */
public class Rfplicbte{
    
    private ArrayList<Cuadrado> tablero1;
    private ArrayList<Cuadrado> tablero2;
    private boolean isVisible;
    private int x;
    private int y;
    private int size;
    private boolean estado;
    
    /**
     * Constructor del objeto tablero
     */
    public Rfplicbte(int width, int height){
        tablero1 = tablero2 = new ArrayList<Cuadrado>();
        isVisible = estado = false;
        x = y = 0;
        size = 1;
        for (int i = 0; i < (width*height); i++){
            tablero1.add(i, new Cuadrado((10+(size+1)*x),10+((size+1)*y),size));
            tablero2.add(i, new Cuadrado((((width*(size+1))+20)+((size+1)*x)),(10+(size+1)*y),size));
             if (x != width-1){
                x++;
            }else{
                x = 0;y++;
            }
        }
    }
    
    /**
     * 
     */
    public Rfplicbte(ArrayList<String> referencePattern){
        
    }
    
    /**
     * 
     */
    public void fill(int[][] cells){
        
    }
    
    /**
     * 
     */
    public void replicateWhitoutBug(){
        
    }
    
    /**
     * 
     */
    public void flip(int row, int column){
        
    }

    /**
     * 
     */
    public void replicate(){
        
    }       
    
    /**
     * 
     */
    public boolean success(){
        return true;
    } 
    
    /**
     * 
     */
    public void putNexus(String color, int row, int column){
        
    }
    
    /**
     * 
     */
    public void dissolveNexus(String color){
        
    }
    
    /**
     * Make this Rfplicbte visible. If it was already visible, do nothing.
     */
    public void makeVisible(){   
        for (int i = 0; i < tablero1.size(); i++){
            tablero1.get(i).makeVisible();
            tablero2.get(i).makeVisible();
        }
        isVisible = true;
    }
    
    /**
     * Make this Rfplicbte visible. If it was already visible, do nothing.
     */
    public void makeInvisible(){
        for (int i = 0; i < tablero1.size(); i++){
            tablero1.get(i).makeInvisible();
            tablero2.get(i).makeInvisible();            
        }
        isVisible = false;
    }
    
    /**
     * 
     */
    public void finish(){
        
    }
    
    /**
     * 
     */
    public boolean ok(){
        return estado;
    }
}
