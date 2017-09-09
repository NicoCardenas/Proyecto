import java.util.*;

/**
 * A square that can be manipulated and that draws itself on a canvas.
 * 
 * @author  Paola Cuellar y Nicolás Cárdenas
 * @version 1.5  (03 September 2017)
 */
public class Rfplicbte{
    
    private Cuadrado[][] tablero1;
    private Cuadrado[][] tablero2;
    private boolean isVisible;
    private int widthT, heightT;
    private int size;
    private boolean estado;
    
    /**
     * Constructor del objeto tablero le entran dos parametros para construirlo.
     * @param width largo de la matriz.
     * @param height ancho de la matriz.
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
     * El constructor de objeto tablero utiliza una lista para construir la matriz
     * @param referencePattern es una lista en la que la cadena esta compuesta de "."  y "#" ("." vacio y "#" activo).
     */
    // caso de prueba {"#.##","####","...."} , {"###.",".#.#",".#.#","#..#"}
    public Rfplicbte(String[] referencePattern){
        int a = referencePattern[0].length();
        int b = referencePattern.length;
        tablero1 = new Cuadrado[a][b];
        tablero2 = new Cuadrado[a][b];
        isVisible = estado = false;
        widthT = a;  heightT = b; size = 10;
        for (int i = 0; i < a; i++){
            for (int j = 0; j < b; j++){
                tablero1[i][j] = new Cuadrado((10+(size+1)*i),10+((size+1)*j),size);
                tablero2[i][j] = new Cuadrado( ((a*(size+1))+20)+((size+1)*i) , (10+(size+1)*j) , size );
                
            }
        }    
        for(int i = 0; i < a; i++){
            for(int j = 0; j < b; j++){
                if (referencePattern[j].charAt(i)=='#'){
                   tablero2[i][j].changeColor("blue");
                   estado = true;
                }else if(referencePattern[j].charAt(i)=='.'){
                    estado = false;
                }
        }
        }
   }
    
    /**
     * El método fill construye el tablero a partir de valores binarios.
     * @param cells es una matriz lógica (entran 0 y 1).
     */
    public void fill(int[][] cells){
        estado = false;
        for (int i = 0; i < cells.length; i++){
            tablero2[cells[i][0]][cells[i][1]].changeColor("blue");
            estado = true;               
        }
    }
    
    /**
     * El método replica la primera matriz en la segunda sin errores.
     */
    public void replicateWhitoutBug(){
        estado = false;
        for (int i = 0; i < tablero1[0].length; i++){
            for (int j = 0; j < tablero1.length; j++){                
                if (tablero1[i][j].getError() && tablero1[i][j].getColor() == "light gray"){
                    tablero2[i][j].changeColor("blue");
                }else if (tablero1[i][j].getError() && tablero1[i][j].getColor() == "blue"){
                    tablero2[i][j].changeColor("light gray");
                }else{
                    tablero2[i][j].changeColor(tablero1[i][j].getColor());
                }
            }
        }
        estado = true;
    }
    
    /**
     * El método flip instercambia de estado la celda seleccionada.
     * @param row fila de la celda seleccionada.
     * @param column columna de la celda seleccionada.
     */
    public void flip(int row, int column){
        estado = false;        
        if (!tablero1[row][column].getError()){
            tablero1[row][column].setError(true);
        }else{
            tablero1[row][column].setError(false);
        }
        if (row < widthT && column < heightT && tablero1[row][column].getColor() == "light gray"){
            tablero1[row][column].changeColor("blue");
            estado = true;
        }else if (row < widthT && column < heightT){
            tablero1[row][column].changeColor("light gray");
            estado = true;
        }
    }

    /**
     * El método replicate guarda las modificaciones del primer tablero en el segundo tablero.
     */
    public void replicate(){
        estado = false;
        for (int i = 0; i < tablero1[0].length; i++){
            for (int j = 0; j < tablero1.length; j++){
                tablero2[i][j].changeColor(tablero1[i][j].getColor());
            }
        }
        estado = true;
    }       
    
    /**
     * El método success verifica que el patron en ambas matrices sea igual
     * @return retorna el valor de la comparacion de las dos matrices
     */
    public boolean success(){
        boolean res = true;
        estado = false;
        for (int i = 0; i < tablero1[0].length; i++){
            for (int j = 0; j < tablero1.length; j++){                
                if (tablero1[i][j].getColor() != tablero2[i][j].getColor()){
                    res = false;
                }
                estado = true;
            }
        }
        return res;
    } 
    
    /**
     * El método putNexus pinta la celda seleccionada con el color indicado.
     * @param color es el color seleccionado para pintar el nexus.
     * @param row es el valor de fila de la celda.
     * @param column es el valor de columna de la celda.
     */
    public void putNexus(String color, int row, int column){
        estado = false;
        if (tablero1[row][column].getColor() != "light gray"){
            tablero1[row][column].changeColor(color);
            estado = true;
        }
    }
    
    /**
     * El método 
     * @param color es el color del nexus para disolver.
     */
    public void dissolveNexus(String color){
        estado = false;
        for (int i = 0 ; i < tablero1.length; i++){
            for (int j = 0 ; j < tablero1[0].length && tablero1[i][j].getColor() == color; j++){
                tablero1[i][j].changeColor("light gray");
                estado = true;           
            }
        }                    
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
     * Make this Rfplicbte invisible. If it was already invisible, do nothing.
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
     * El método finish termina el programa.
     */
    public void finish(){
        System.exit(0);
    }
    
    /**
     * El método ok verifica si la ultima accion realizada fue hecha.
     * @return retorna si la ultima operacion fue realizada.
     */
    public boolean ok(){
        return estado;
    }
}
