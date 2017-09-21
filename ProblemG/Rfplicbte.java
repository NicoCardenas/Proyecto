import java.util.*;
import javax.swing.*;

/**
 * A square that can be manipulated and that draws itself on a canvas.
 * 
 * @author  Paola Cuellar
 * @author Nicolás Cárdenas
 * @version 2.0  (18 September 2017)
 */
public class Rfplicbte{
    
    private Cuadrado[][] tablero1;
    private Cuadrado[][] tablero2;
    private Cuadrado[][] tablero3;
    private Cuadrado[][] tablero4;
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
        tablero3 = new Cuadrado[width][height];
        tablero4 = new Cuadrado[width][height];
        isVisible = estado = false;
        widthT = width;
        heightT = height;
        size = 10;
        for (int i = 0; i < width; i++){
            for (int j = 0; j < height; j++){
                tablero1[i][j] = new Cuadrado( (10+(size+1)*i), 10+((size+1)*j), size);
                tablero2[i][j] = new Cuadrado( ((width*(size+1))+20)+((size+1)*i) , (10+(size+1)*j) , size );
                tablero3[i][j] = new Cuadrado( (10+(size+1)*i) , ((height*(size+1))+20)+((size+1)*j) , size);
                tablero4[i][j] = new Cuadrado( ((width*(size+1))+20)+((size+1)*i) , ((height*(size+1))+20)+((size+1)*j) , size);
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
        tablero3 = new Cuadrado[a][b];
        tablero4 = new Cuadrado[a][b];
        isVisible = estado = false;
        widthT = a;  heightT = b; size = 10;
        for (int i = 0; i < a; i++){
            for (int j = 0; j < b; j++){
                tablero1[i][j] = new Cuadrado((10+(size+1)*i),10+((size+1)*j),size);
                tablero2[i][j] = new Cuadrado( ((a*(size+1))+20)+((size+1)*i) , (10+(size+1)*j) , size );
                if (referencePattern[j].charAt(i)=='#'){
                   tablero2[i][j].changeColor("blue");                   
                }
                tablero3[i][j] = new Cuadrado( (10+(size+1)*i) , ((heightT*(size+1))+20)+((size+1)*j) , size);
                tablero4[i][j] = new Cuadrado( ((widthT*(size+1))+20)+((size+1)*i) , ((heightT*(size+1))+20)+((size+1)*j) , size);
                estado = true;
            }
        }    
    }
    
    /**
     * El método fill construye el tablero a partir de valores binarios.
     * @param cells es una matriz de posiciones.
     */
    public void fill(int[][] cells){
        estado = false;
        for (int i = 0; i < cells.length; i++){
            if (0 <= cells[i][0]-1 && cells[i][0]-1 < widthT && 0 <= cells[i][1]-1 && cells[i][1]-1 < heightT){
                tablero1[cells[i][0]-1][cells[i][1]-1].changeColor("blue");
                estado = true;
            }                           
       }
    }
    
    /**
     * El método replica la primera matriz en la segunda sin errores.
     */
    public void replicate(){
        estado = false;
        Random random = new Random();
        int a = random.nextInt(widthT+1), b = random.nextInt(heightT+1);
        while (a <= 0 || b <= 0 || b >= widthT+1 || a >= heightT+1){
            a = random.nextInt(widthT+1); b = random.nextInt(heightT+1);
        }
        System.out.println(a+" "+b);
        flip(a,b);
        replicateWhitoutBug();
        estado = true;
    }
    
    /**
     * El método flip instercambia de estado la celda seleccionada.
     * @param row fila de la celda seleccionada.
     * @param column columna de la celda seleccionada.
     */
    public void flip(int row, int column){
        estado = false;
        if (row == 0 || column == 0){
            row+=1;
            column+=1;
        }
        if (row-1 < widthT && column-1 < heightT && tablero1[row-1][column-1].getColor() == "light gray"){
            tablero1[column-1][row-1].changeColor("blue");
            estado = true;
        }else if (row-1 < widthT && column-1 < heightT){
            tablero1[column-1][row-1].changeColor("light gray");
            estado = true;
        }
    }

    /**
     * El método replicate guarda las modificaciones del primer tablero en el segundo tablero.
     */
    public void replicateWhitoutBug(){
        estado = false;
        for (int i = 0; i < tablero1[0].length; i++){
            for (int j = 0; j < tablero1.length; j++){
                int contador = vecinos(i,j);       
                if (contador%2 != 0){
                    tablero3[i][j].changeColor("blue");
                }else if (contador%2 == 0){
                    tablero3[i][j].changeColor("light gray");
                }
            }
        }
        cloneT(tablero1,tablero3);
        estado = true;
    }       
    
    /**
     * El método success verifica que el patron en ambas matrices sea igual
     * @return Retorna el valor de la comparacion de las dos matrices
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
            if (vecinos(row,column) == 9){
                tablero1[row][column].changeColor(color);
                tablero1[row-1][column-1].changeColor(color);
                tablero1[row][column-1].changeColor(color);
                tablero1[row+1][column-1].changeColor(color);
                tablero1[row+1][column].changeColor(color);
                tablero1[row+1][column+1].changeColor(color);
                tablero1[row][column+1].changeColor(color);
                tablero1[row-1][column+1].changeColor(color);
            }
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
        //System.exit(0);
    }
    
    /**
     * El método ok verifica si la ultima accion realizada fue hecha.
     * @return retorna si la ultima operacion fue realizada.
     */
    public boolean ok(){
        return estado;
    }
    
    /**
     * Permile rotar las matrices en sentido de las agujas del reloj.
     */
    public void rotate(){
        estado =false;
        for (int i = 0; i < tablero1[0].length; i++){
            for (int j = 0; j < tablero1.length; j++){
                tablero3[i][j].changeColor(tablero1[j][tablero1.length-i-1].getColor());
                tablero4[i][j].changeColor(tablero2[j][tablero1.length-i-1].getColor());
            }
        }
        cloneT(tablero1,tablero3);
        cloneT(tablero2,tablero4);
        estado = true;
    }
    
    /**
     * Intercambiar la matriz de referencia con la de edición. 
     */
    public void switchT(){        
        cloneT(tablero3,tablero1);
        cloneT(tablero1,tablero2);
        cloneT(tablero2,tablero3);
    }
    
    /**
     * Consultar el patrón de las dos matrices. 
     * @return Retorna una matriz donde están los patrones de la matriz de edición y la matriz de referencia.  
     */
    public String[][] consult(){
        String[][] res = new String[1][2];
        String lista = new String();
        String lista2 = new String();
        for (int i = 0; i < widthT; i++){
            for (int j = 0; j < heightT; j++){
                if (tablero1[i][j].getColor() == "light gray"){
                    lista+=".";
                }else if(tablero1[i][j].getColor() != "light gray"){
                    lista+="#";
                }                
                if (tablero2[i][j].getColor() == "light gray"){
                    lista2+=".";
                }else if(tablero2[i][j].getColor() != "light gray"){
                    lista2+="#";
                }
            }
        }
        res[0][0] = lista; res[0][1] = lista2;
        return res;
    }
    
    /**
     * Realiza un zoom de las dos matrices en 10 unidades .
     * @param zoom un de estos dos caracteres '+' o '-'.
     */
    public void zoom(char c){
        makeInvisible();
        int sizeC = tablero1[0][0].getSize();
        if (c == '+'){
            sizeC+=10;
        }else if(c == '-' && sizeC > 10){
            sizeC-=10;
        }
        for (int i = 0; i < widthT; i++){
            for (int j = 0; j < heightT; j++){                    
                tablero1[i][j].setSize(sizeC);
                tablero2[i][j].setSize(sizeC);
                tablero1[i][j].setPosition(0,0);
                tablero2[i][j].setPosition(0,0);
                tablero1[i][j].setPosition(((10+(sizeC+1)*i)), (10+(sizeC+1)*j));
                tablero2[i][j].setPosition((((widthT*(sizeC+1))+20)+((sizeC+1)*i)), (10+(sizeC+1)*j));
            }
        }
        makeVisible();
    }    
    
    /*
     * clona una matriz a otra.
     */
    private void cloneT(Cuadrado[][] tablero1, Cuadrado[][] tablero2){
        estado = false;
        for (int i = 0; i < tablero1[0].length; i++){
            for (int j = 0; j < tablero1.length; j++){                
                tablero1[i][j].changeColor(tablero2[i][j].getColor());                    
            }
        }        
        estado = true;
    }
    
    /*
     * calcula el numero de vecinos activos
     */
    private int vecinos(int i, int j){
        int[]  dx = new int[]{-1,-1,-1,0,0,0,1,1,1};
        int[]  dy = new int[]{-1,0,1,-1,0,1,-1,0,1};
        int contador = 0;
        for (int k = 0; k < dx.length; k++){
            if (i+dx[k] > 0 && i+dx[k] < tablero1.length && j+dy[k] > 0 && j+dy[k] < tablero1[0].length && tablero1[i+dx[k]][j+dy[k]].getColor() != "light gray"){
                contador++;
            }
        }
        return contador;
    }
}
