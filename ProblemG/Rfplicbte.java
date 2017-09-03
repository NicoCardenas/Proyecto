import java.util.*;

/**
 * A square that can be manipulated and that draws itself on a canvas.
 * 
 * @author  Paola Cuellar y Nicolás Cárdenas
 * @version 1.0  (29 August 2017)
 */
public class Rfplicbte{
    
    private Cuadrado[][] tablero1;
    private Cuadrado[][] tablero2;
    private boolean isVisible;
    private int widthT, heightT;
    private int size;
    private boolean estado;
    
    /**
     * Constructor del objeto tablero
     */
    public Rfplicbte(int width, int height){
        tablero1 = new Cuadrado[width][height];
        tablero2 = new Cuadrado[width][height];
        isVisible = estado = false;
        widthT = width;
        heightT = height;
        size = 10;
        for (int i = 0; i < width; i++){
            for (int j = 0; j < height; j++){
                tablero1[i][j] = new Cuadrado((10+(size+1)*i),10+((size+1)*j),size);
                tablero2[i][j] = new Cuadrado( ((width*(size+1))+20)+((size+1)*i) , (10+(size+1)*j) , size );    
            }
        }
    }
    
    /**
     * {"#.##","####","...."}
     * "." empty and "#" filled
     */
    public Rfplicbte(String[] referencePattern){
        int a = referencePattern[0].length();
        int b = referencePattern.length;
        tablero1 = new Cuadrado[a][b];
        tablero2 = new Cuadrado[a][b];
        isVisible = estado = false;
        widthT = a;
        heightT = b;
        size = 10;
        for (int i = 0; i < a; i++){
            for (int j = 0; j < b; j++){
                tablero1[i][j] = new Cuadrado((10+(size+1)*i),10+((size+1)*j),size);
                tablero2[i][j] = new Cuadrado( ((a*(size+1))+20)+((size+1)*i) , (10+(size+1)*j) , size );
                
            }
        }    
        for(int i = 0; i < a; i++){
            for(int j = 0; j < b; j++){
                if (referencePattern[j].charAt(i)=='#'){
                   tablero1[i][j].changeColor("blue");
                   tablero2[i][j].changeColor("blue");
                   estado = true;
                }else if(referencePattern[j].charAt(i)=='.'){
                    estado = false;
                }
        }
        }
   }
    
    /**
     * 
     */
    public void fill(int[][] cells){
        estado = false;
        for (int i = 0; i < cells.length && widthT >= cells.length; i++){
            for (int j = 0; j < cells[i].length && heightT >= cells[i].length; j++){
                if (cells[i][j] == 1){
                    tablero1[i][j].changeColor("blue");
                    tablero2[i][j].changeColor("blue");
                    estado = true;
                }
            }
        }
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
        if (row < widthT && column < heightT && tablero1[row][column].getColor() == "light gray"){
            tablero1[row][column].changeColor("blue");
        }else if (row < widthT && column < heightT && tablero1[row][column].getColor() == "blue"){
            tablero1[row][column].changeColor("light gray");
        }else if (!estado){
            estado = false;
        }
        if (estado){doClone();}
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
        for (int i = 0; i < widthT; i++){
            for (int j = 0; j < heightT; j++){
                tablero1[i][j].makeVisible();
                tablero2[i][j].makeVisible();
            }
        }
        isVisible = true;
    }
    
    /**
     * Make this Rfplicbte visible. If it was already visible, do nothing.
     */
    public void makeInvisible(){
        for (int i = 0; i < widthT; i++){
            for (int j = 0; j < heightT; j++){
                tablero1[i][j].makeInvisible();
                tablero2[i][j].makeInvisible();
            }
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
    
    /**
     * Clona la matris 1 en la dos.
     */
    private void doClone() {
        for (int i = 0; i < widthT; i++){
            for (int j = 0; j < heightT; j++){
                if (tablero1[i][j].getColor() == "blue"){
                    tablero2[i][j].changeColor("blue");
                }
            }
        }
    }
}
