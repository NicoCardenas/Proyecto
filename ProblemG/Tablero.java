import java.util.*;

/**
 * A square that can be manipulated and that draws itself on a canvas.
 * 
 * @author  Paola Cuellar y Nicolás Cárdenas
 * @version 1.0  (29 August 2017)
 */
public class Tablero{
    
    private ArrayList<Cuadrado> tablero;
    private boolean isVisible;
    private int x;
    private int y;
    private int size;
    
    /**
     * Constructor del objeto tablero
     */
    public Tablero(){
        tablero = new ArrayList<Cuadrado>();
        isVisible = false;
        x = y = 0;
        size = 40;
        for (int i = 0; i < 25; i++){
            tablero.add(i, new Cuadrado(0,0,size));
        }
    }
    
    /**
     * Make this rectangle visible. If it was already visible, do nothing.
     */
    public void makeVisible(){
        
        for (int i = 0; i < tablero.size(); i++){
            tablero.get(i).moveHorizontal((size+1)*x);
            tablero.get(i).moveVertical((size+1)*y);
            tablero.get(i).makeVisible();
            if (x != 4){
                x++;
            }else{
                x = 0;y++;
            }
        }
        isVisible = true;
    }
}
