package rfplcbte;

/**
 * A square that can be manipulated and that draws itself on a canvas.
 * 
 * @author  Paola Cuellar
 * @author Nicolás Cárdenas
 * @version 2.1  (10 Octubre 2017)
 */
public class Rfplicbte{
    
    private Tablero tablero;
    
    /**
     * Constructor del objeto tablero le entran dos parametros para construirlo.
     * @param width largo de la matriz.
     * @param height ancho de la matriz.
     */
    public Rfplicbte(int width, int height){
        tablero = new Tablero(width,height);
    }
    
    /**
     * El constructor de objeto tablero utiliza una lista para construir la matriz
     * @param referencePattern es una lista en la que la cadena esta compuesta de "."  y "#" ("." vacio y "#" activo).
     */
     // caso de prueba {"#.##","####","...."} , {"###.",".#.#",".#.#","#..#"}
    public Rfplicbte(String[] referencePattern){
        tablero = new Tablero(referencePattern);        
    }
    
    /**
     * El método fill construye el tablero a partir de valores binarios.
     * @param cells es una matriz de posiciones (x,y).
     */
    public void fill(int[][] cells){
       tablero.fill(cells);
    }
    
    /**
     * El método replica la primera matriz en la segunda sin errores.
     */
    public void replicate(){
        tablero.replicate();
    }
    
    /**
     * El método flip instercambia de estado la celda seleccionada.
     * @param row fila de la celda seleccionada.
     * @param column columna de la celda seleccionada.
     */
    public void flip(int row, int column){
        tablero.flip(row, column);
    }

    /**
     * El método replicate guarda las modificaciones del primer tablero en el segundo tablero.
     */
    public void replicateWhitoutBug(){
        tablero.replicateWhitoutBug();
    }       
    
    /**
     * El método success verifica que el patron en ambas matrices sea igual
     * @return Retorna el valor de la comparacion de las dos matrices
     */
    public boolean success(){
        return tablero.success();
    } 
    
    /**
     * El método putNexus pinta la celda seleccionada con el color indicado.
     * @param color es el color seleccionado para pintar el nexus.
     * @param row es el valor de fila de la celda.
     * @param column es el valor de columna de la celda.
     */
    public void putNexus(String color, int row, int column){
        tablero.putNexus(color, row, column);
    }
    
    /**
     * El método 
     * @param color es el color del nexus para disolver.
     */
    public void dissolveNexus(String color){
        tablero.dissolveNexus(color);                   
    }
    
    /**
     * Make this Rfplicbte visible. If it was already visible, do nothing.
     */
    public void makeVisible(){
        tablero.makeVisible();
    }
    
    /**
     * Make this Rfplicbte invisible. If it was already invisible, do nothing.
     */
    public void makeInvisible(){
        tablero.makeInvisible();
    }
    
    /**
     * El método finish termina el programa.
     */
    public void finish(){
        tablero.finish();
    }
    
    /**
     * El método ok verifica si la ultima accion realizada fue hecha.
     * @return retorna si la ultima operacion fue realizada.
     */
    public boolean ok(){
        return tablero.ok();
    }
    
    /**
     * Permile rotar las matrices en sentido de las agujas del reloj.
     */
    public void rotate(){
        tablero.rotate();
    }       
    
    /**
     * Intercambiar la matriz de referencia con la de edición. 
     */
    public void switchy(){
        tablero.switchy();
    }
    
    /**
     * Consultar el patrón de las dos matrices. 
     * @return Retorna una matriz donde están los patrones de la matriz de edición y la matriz de referencia.  
     */
    public String[][] consult(){
        return tablero.consult();
    }
    
    /**
     * Realiza un zoom de las dos matrices en 10 unidades .
     * @param zoom un de estos dos caracteres '+' o '-'.
     */
    public void zoom(char c){
        tablero.zoom(c);
    }
    
    /**
     * 
     */
    public void mutate(String type, int row, int column){
    }
    
    /**
     * 
     */
    public void mutate(String type, int[][] cells){
    }
    
    /**
     * 
     */
    public String[] solve(){
        return tablero.solve();
    }
    
    public int getHeight(){
        return tablero.getHeight();
    }
}
