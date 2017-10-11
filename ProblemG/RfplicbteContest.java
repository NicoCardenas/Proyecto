
/**
 * @author Paola Cuellar
 * @author Nicolás Cárdenas
 * @version 1.0  (10 Octubre 2017)
 */
public class RfplicbteContest{

    /**
     * Constructor for objects of class RfplicbteContest
     */
    public RfplicbteContest(){
        
    }

    public static String[] solve(String[] referencePattern){
        Rfplicbte var = new Rfplicbte(referencePattern);
        String[] res = new String[var.getHeight()];
        for (int i = var.getHeight(); i > 2; i-=2){
           res = var.solve();
        }        
        return res;
    }
    
    public static void simulate(String[] referencePattern, boolean slow){
        Rfplicbte var = new Rfplicbte(referencePattern);
        int[][] patron = convert(solve(referencePattern));
        var.fill(patron);
        var.makeVisible();
        pause(); 
        for (int i = 2; i < var.getHeight(); i+=2){
            if (slow){
                pause();
            }
            var.replicateWhitoutBug();
        }
    }
    
    private static int[][] convert(String[] patron){
        int[][] cells = new int[patron.length*patron[0].length()][2];
        int count = 0;
        for(int i = 0; i < patron.length-1; i++){
            for(int j = 0; j < patron[0].length(); j++){
                System.out.println("i: "+i+" j: "+j);
                if (patron[i].charAt(j) == '#'){
                    cells[count][0] = j+1;
                    cells[count][1] = i+1;
                    count+=1;
                }
            }
        }
        return cells;
    }
    
    private static void pause(){
       Canvas.getCanvas().wait(1000);
    }
}
