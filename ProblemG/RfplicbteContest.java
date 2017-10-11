
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

    public String[] solve(String[] referencePattern){
        Rfplicbte var = new Rfplicbte(referencePattern);
        var.makeVisible();
        return referencePattern;
    }
    
    public void simulate(String[] referencePattern, boolean slow){
        Rfplicbte var = new Rfplicbte(referencePattern);
        int[][] patron = convert(solve(referencePattern));
        var.fill(patron);
        var.makeVisible();
        for (int i = 1; i < var.getHeight(); i+=2){
            if (slow){
                pause();
            }
            var.replicateWhitoutBug();
        }
    }
    
    private int[][] convert(String[] patron){
        int[][] cells = new int[patron.length*patron[0].length()][2];
        int count = 0;
        for(int i = 0; i < patron.length; i++){
            for(int j = 0; j < patron[i].length(); j++){
                if (patron[i].charAt(j)== '#'){
                    cells[count][0] = j+1;
                    cells[count][1] = i+1;
                    count+=1;
                }
            }
        }
        return cells;
    }
    
    private void pause(){
       Canvas.getCanvas().wait(1000);
    }
}
