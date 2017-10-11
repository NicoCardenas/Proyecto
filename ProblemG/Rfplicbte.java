import java.util.*;
import javax.swing.*;
import javax.swing.JFrame;

/**
 * A square that can be manipulated and that draws itself on a canvas.
 * 
 * @author  Paola Cuellar
 * @author Nicolás Cárdenas
 * @version 2.1  (10 Octubre 2017)
 */
public class Rfplicbte{
    
    private Cuadrado[][] tablero1;
    private Cuadrado[][] tablero2;
    private Cuadrado[][] tablero3;
    private Cuadrado[][] tablero4;
    private boolean isVisible, fin;
    private int w , h;
    private int size;
    private boolean estado;
    
    /**
     * Constructor del objeto tablero le entran dos parametros para construirlo.
     * @param width largo de la matriz.
     * @param height ancho de la matriz.
     */
    public Rfplicbte(int width, int height){
        tablero1 = new Cuadrado[height][width];
        tablero2 = new Cuadrado[height][width];
        tablero3 = new Cuadrado[height][width];
        tablero4 = new Cuadrado[height][width];
        isVisible = estado = fin = false;        
        size = 10;
        for (int i = 0; i < height; i++){
            for (int j = 0; j < width; j++){
                tablero1[i][j] = new Cuadrado( (10+(size+1)*i), 10+((size+1)*j), size);
                tablero2[i][j] = new Cuadrado( ((width*(size+1))+19)+((size+1)*i) , (10+(size+1)*j) , size );
                tablero3[i][j] = new Cuadrado( (10+(size+1)*i) , ((height*(size+1))+20)+((size+1)*j) , size);
                tablero4[i][j] = new Cuadrado( ((width*(size+1))+20)+((size+1)*i) , ((height*(size+1))+20)+((size+1)*j) , size);
            }
        }
        h = tablero1[height-1][width-1].getPositionY()+11; w = tablero1[height-1][width-1].getPositionX()+11;        
    }
    
    /**
     * El constructor de objeto tablero utiliza una lista para construir la matriz
     * @param referencePattern es una lista en la que la cadena esta compuesta de "."  y "#" ("." vacio y "#" activo).
     */
     // caso de prueba {"#.##","####","...."} , {"###.",".#.#",".#.#","#..#"}
    public Rfplicbte(String[] referencePattern){
        int a = referencePattern.length;
        int b = referencePattern[0].length();
        tablero1 = new Cuadrado[a][b];
        tablero2 = new Cuadrado[a][b];
        tablero3 = new Cuadrado[a][b];
        tablero4 = new Cuadrado[a][b];
        isVisible = estado = fin = false;
        size = 10;
        for (int i = 0; i < a; i++){
            for (int j = 0; j < b; j++){
                tablero1[i][j] = new Cuadrado((10+(size+1)*i),10+((size+1)*j),size);
                tablero2[i][j] = new Cuadrado( ((a*(size+1))+19)+((size+1)*i) , (10+(size+1)*j) , size );
                if (referencePattern[j].charAt(i)=='#'){
                   tablero2[i][j].changeColor("blue");                   
                }
                tablero3[i][j] = new Cuadrado( (10+(size+1)*i) , ((b*(size+1))+20)+((size+1)*j) , size);
                tablero4[i][j] = new Cuadrado( ((a*(size+1))+20)+((size+1)*i) , ((b*(size+1))+20)+((size+1)*j) , size);
                estado = true;
            }
        }    
        h = tablero1[a-1][b-1].getPositionY()+11; w = tablero1[a-1][b-1].getPositionX()+11;
    }
    
    /**
     * El método fill construye el tablero a partir de valores binarios.
     * @param cells es una matriz de posiciones (x,y).
     */
    public void fill(int[][] cells){
       if (!fin){ 
         estado = false;
         for (int i = 0; i < cells.length; i++){
               if (0 <= cells[i][0]-1 && cells[i][0]-1 < tablero1.length && 0 <= cells[i][1]-1 && cells[i][1]-1 < tablero1[0].length){
                   tablero1[cells[i][0]-1][cells[i][1]-1].changeColor("blue");
                estado = true;
            }                           
         }
       }
    }
    
    /**
     * El método replica la primera matriz en la segunda sin errores.
     */
    public void replicate(){
        if (!fin){
            estado = false;
            Random random = new Random();
            int a = random.nextInt(tablero1[0].length+1), b = random.nextInt(tablero1.length+1);
            while (a <= 0 || b <= 0){
                a = random.nextInt(tablero1[0].length+1); b = random.nextInt(tablero1.length+1);
            }
            flip(a,b);
            replicateWhitoutBug();
            estado = true;
        }
    }
    
    /**
     * El método flip instercambia de estado la celda seleccionada.
     * @param row fila de la celda seleccionada.
     * @param column columna de la celda seleccionada.
     */
    public void flip(int row, int column){
        if (!fin){
            estado = false;
            if (row-1 < tablero1[0].length && column-1 < tablero1.length && tablero1[column-1][row-1].getColor() == "light gray"){
                tablero1[column-1][row-1].changeColor("blue");
                estado = true;
            }else if (row-1 < tablero1[0].length && column-1 < tablero1.length){
                tablero1[column-1][row-1].changeColor("light gray");
                estado = true;
            }
        }
    }

    /**
     * El método replicate guarda las modificaciones del primer tablero en el segundo tablero.
     */
    public void replicateWhitoutBug(){
        if (!fin){
            estado = false;
            for (int i = 0; i < tablero1.length; i++){
                for (int j = 0; j < tablero1[0].length; j++){
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
    }       
    
    /**
     * El método success verifica que el patron en ambas matrices sea igual
     * @return Retorna el valor de la comparacion de las dos matrices
     */
    public boolean success(){
        boolean res = true;
        if (!fin){            
            estado = false;
            for (int i = 0; i < tablero1.length; i++){
                for (int j = 0; j < tablero1[0].length; j++){                
                    if (tablero1[i][j].getColor() != tablero2[i][j].getColor()){
                        res = false;
                    }
                    estado = true;
                }
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
        if (!fin){
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
        if (!fin){
            estado = false;
            for (int i = 0; i < tablero1.length; i++){
                for (int j = 0; j < tablero1[0].length; j++){
                    tablero1[i][j].makeVisible();
                    tablero2[i][j].makeVisible();                
                }
                estado = true;
            }
            isVisible = true;
        }
    }
    
    /**
     * Make this Rfplicbte invisible. If it was already invisible, do nothing.
     */
    public void makeInvisible(){
        if (!fin){
            for (int i = 0; i < tablero1.length; i++){
                for (int j = 0; j < tablero1[0].length; j++){
                    tablero1[i][j].makeInvisible();
                    tablero2[i][j].makeInvisible();
                }
            }
            isVisible = false;
        }
    }
    
    /**
     * El método finish termina el programa.
     */
    public void finish(){
        if (!fin){
            fin = true;
            Canvas canvas = Canvas.getCanvas();
            canvas.close();
        }
    }
    
    /**
     * El método ok verifica si la ultima accion realizada fue hecha.
     * @return retorna si la ultima operacion fue realizada.
     */
    public boolean ok(){
        boolean res = false;
        if (!fin){
            res = estado;
        }
        return res;
    }
    
    /**
     * Permile rotar las matrices en sentido de las agujas del reloj.
     */
    public void rotate(){
        if (!fin){
            estado =false;       
            makeInvisible();
            tablero3 = new Cuadrado [tablero1[0].length][tablero1.length];
            tablero4 = new Cuadrado [tablero1[0].length][tablero1.length];
            int a,b;
            for (int i = 0; i < tablero1.length; i++){
                for (int j = 0; j < tablero1[0].length; j++){
                    tablero1[i][j].setPosition(h-tablero1[i][j].getPositionY()-1,tablero1[i][j].getPositionX());
                    a = pos(tablero1[i][j].getPositionY());
                    b = pos(tablero1[i][j].getPositionX());
                    tablero3[b-1][a-1] = tablero1[i][j];
                    tablero2[i][j].setPosition(w+h-tablero2[i][j].getPositionY()-2,tablero1[i][j].getPositionY());                
                    tablero4[b-1][a-1] = tablero2[i][j];
                }
            }
            int temp = h; h = w; w = temp;
            makeVisible();
            tablero1 = tablero3; tablero2 = tablero4;
            estado = true;
        }
    }       
    
    /**
     * Intercambiar la matriz de referencia con la de edición. 
     */
    public void switchy(){
        if (!fin){
            tablero3 = new Cuadrado [tablero1.length][tablero1[0].length];
            tablero4 = new Cuadrado [tablero1.length][tablero1[0].length];
            for (int i = 0; i < tablero1.length; i++){
                for (int j = 0; j < tablero1[0].length; j++){
                    tablero3[i][j] = new Cuadrado(0, 0, size);
                    tablero4[i][j] = new Cuadrado(0, 0, size);
                }
            }
            cloneT(tablero3,tablero1);
            cloneT(tablero1,tablero2);
            cloneT(tablero2,tablero3);
        }
    }
    
    /**
     * Consultar el patrón de las dos matrices. 
     * @return Retorna una matriz donde están los patrones de la matriz de edición y la matriz de referencia.  
     */
    public String[][] consult(){
        String[][] res = new String[1][2];
        if (!fin){            
            String lista = new String();
            String lista2 = new String();
            for (int i = 0; i < tablero1.length; i++){
                for (int j = 0; j < tablero1[0].length; j++){
                    lista+=patron(tablero1[i][j]);
                    lista2+=patron(tablero2[i][j]);               
                }
            }
            res[0][0] = lista; res[0][1] = lista2;            
        }
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
        for (int i = 0; i < tablero1.length; i++){
            for (int j = 0; j < tablero1[0].length; j++){                    
                tablero1[i][j].setSize(sizeC);
                tablero2[i][j].setSize(sizeC);
                tablero1[i][j].setPosition(0,0);
                tablero2[i][j].setPosition(0,0);
                tablero1[i][j].setPosition(((10+(sizeC+1)*i)), (10+(sizeC+1)*j));
                tablero2[i][j].setPosition((((tablero1.length*(sizeC+1))+20)+((sizeC+1)*i)), (10+(sizeC+1)*j));
            }
        }
        makeVisible();
    }
    
    public int getHeight(){
        return tablero1.length;
    }
    
    public int getWidth(){
        return tablero1[0].length;
    }
    
    /*
     * clona una matriz a otra.
     */
    private void cloneT(Cuadrado[][] tablero1, Cuadrado[][] tablero2){
        estado = false;
        for (int i = 0; i < tablero1.length; i++){
            for (int j = 0; j < tablero1[0].length; j++){                
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
            if (i+dx[k] >= 0 && i+dx[k] < tablero1.length && j+dy[k] >= 0 && j+dy[k] < tablero1[0].length && tablero1[i+dx[k]][j+dy[k]].getColor() != "light gray"){
                contador++;
            }
        }
        return contador;
    }
    
    private String patron(Cuadrado cuad){
        String a = "";
        if (cuad.getColor() == "light gray"){
            a = ".";
        }else if(cuad.getColor() != "light gray"){
            a ="#";
        }
        return a;
    }
    
    private int pos(int i){
        int a;
        if(Integer.toString(i).length() > 2){
            a = Integer.parseInt(Integer.toString(i).substring(0, 2));
        }else{
            a = Integer.parseInt(Integer.toString(i).substring(0, 1));
        }
        return a;
    }
}
