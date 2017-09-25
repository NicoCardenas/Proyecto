import javax.swing.JOptionPane;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class RfplicbteTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class RfplicbteSpecialTest
{
    /**
     * Default constructor for test class RfplicbteTest
     */
    public static final int WAIT= 1000;
    
    public RfplicbteSpecialTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    @Test
    public void deberiaGenerarElPrimerPatron(){
        Rfplicbte r= new Rfplicbte(10,10);
        int inicio[][]={{5,6},{6,5},{6,6}};
        r.makeVisible();
        r.fill(inicio);
        pause();
        r.replicateWhitoutBug();
        pause();
        r.replicateWhitoutBug();
        pause();
        r.replicateWhitoutBug();
        pause();
        r.replicateWhitoutBug();
        pause();
        assertTrue(ok());
        r.makeInvisible();
        r.finish();
    }
    
    
    @Test
    public void deberiaMostrarPatronDeReferencia(){
        String reference[]={".#...#...#",
                            "##..##..##",
                            "..........",
                            "..........",
                            ".#...#...#",
                            "##..##..##",
                            "..........",
                            "..........",
                            ".#...#...#",
                            "##..##..##"};
        Rfplicbte r= new Rfplicbte(reference);
        int inicio[][]={{5,6},{6,5},{6,6}};
        r.makeVisible();
        r.fill(inicio);
        r.replicateWhitoutBug();
        r.replicateWhitoutBug();
        r.replicateWhitoutBug();
        r.replicateWhitoutBug();
        assertTrue(ok());
        r.makeInvisible();
    }
    
    @Test
    public void deberiaValidarPatronDeReferencia(){
        String reference[]={".#...#...#",
                            "##..##..##",
                            "..........",
                            "..........",
                            ".#...#...#",
                            "##..##..##",
                            "..........",
                            "..........",
                            ".#...#...#",
                            "##..##..##"};
        Rfplicbte r= new Rfplicbte(reference);
        int inicio[][]={{5,6},{6,5},{6,6}};
        r.makeVisible();
        r.fill(inicio);
        r.replicateWhitoutBug();
        r.replicateWhitoutBug();
        r.replicateWhitoutBug();
        r.replicateWhitoutBug();
        assertTrue(r.success());
        r.makeInvisible();
    }
    
    
    @Test
    public void deberiaGenerarElSegundoPatron(){
        Rfplicbte r= new Rfplicbte(11,11);
        int inicio[][]={{5,6},{6,5},{6,6}};
        r.makeVisible();
        r.fill(inicio);
        r.replicateWhitoutBug();
        pause();
        r.flip(6,4);
        pause();
        r.replicateWhitoutBug();
        pause();
        r.replicateWhitoutBug();
        pause();
        r.flip(6,8);
        pause();
        r.replicateWhitoutBug();
        pause();        
        assertTrue(ok());
        r.makeInvisible(); 
    }
    
    @Test
    public void deberiaPonerNexusUnNivel(){
        Rfplicbte r= new Rfplicbte(10,10);
        r.makeVisible();
        int cells[][][]={{{1,1},{1,2},{2,1},{2,2}},
                         {{1,3},{1,4},{2,3},{2,4}},
                         {{3,1},{3,2},{3,3},{3,4}},
                         {{3,3},{3,4},{4,3},{4,4}}};
                         
        String colors[]={"red","blue","yellow","green"};
        for (int i=0;i<cells.length;i++){
            r.fill(cells[i]);
            pause();
            r.putNexus(colors[i],cells[i][0][0],cells[i][0][1]);
            pause();
        }
        assertTrue(ok());
        r.makeInvisible();        
    }
    
    @Test
    public void deberiaPonerNexusDosNiveles(){
        Rfplicbte r= new Rfplicbte(10,10);
        r.makeVisible();
        int cells[][][]={{{1,1},{1,2},{2,1},{2,2}},
                         {{1,3},{1,4},{2,3},{2,4}},
                         {{3,1},{3,2},{4,1},{4,2}},
                         {{3,3},{3,4},{4,3},{4,4}}};
                         
        String colors[]={"red","blue","yellow","green"};
        for (int i=0;i<cells.length;i++){
            r.fill(cells[i]);
            pause();
            r.putNexus(colors[i],cells[i][0][0],cells[i][0][1]);
            pause();
        }
        r.putNexus("orange",1,1);
        pause();
        assertTrue(ok());
        r.makeInvisible();        
    }   
    
    @Test
    public void deberiaDisolverNexusUnNivel(){
        Rfplicbte r= new Rfplicbte(10,10);
        r.makeVisible();
        int cells[][][]={{{1,1},{1,2},{2,1},{2,2}},
                         {{1,3},{1,4},{2,3},{2,4}},
                         {{3,1},{3,2},{3,3},{3,4}},
                         {{3,3},{3,4},{4,3},{4,4}}};
                         
        String colors[]={"red","blue","yellow","green"};
        for (int i=0;i<cells.length;i++){
            r.fill(cells[i]);
            r.putNexus(colors[i],cells[i][0][0],cells[i][0][1]);
        }
        pause();
        for (int i=0;i<colors.length;i++){
            r.dissolveNexus(colors[i]);
            pause();
        }        
        assertTrue(ok());
        r.makeInvisible();        
    }
    
    @Test
    public void deberiaDisolverNexusDosNiveles(){
        Rfplicbte r= new Rfplicbte(10,10);
        r.makeVisible();
        int cells[][][]={{{1,1},{1,2},{2,1},{2,2}},
                         {{1,3},{1,4},{2,3},{2,4}},
                         {{3,1},{3,2},{4,1},{4,2}},
                         {{3,3},{3,4},{4,3},{4,4}}};
                         
        String colors[]={"red","blue","yellow","green"};
        for (int i=0;i<cells.length;i++){
            r.fill(cells[i]);
            r.putNexus(colors[i],cells[i][0][0],cells[i][0][1]);
        }
        r.putNexus("orange",1,1);
        pause();
        r.dissolveNexus("orange");
        pause();
        assertTrue(ok());
        r.makeInvisible();        
    }   
    
    @Test
    public void deberiaRotar(){
        String reference[]={".#...#...#",
                            "##..##..##",
                            "..........",
                            "..........",
                            ".#...#...#",
                            "##..##..##",
                            "..........",
                            "..........",
                            ".#...#...#",
                            "##..##..##"};
        Rfplicbte r= new Rfplicbte(reference);
        int inicio[][]={{5,6},{6,5},{6,6}};
        r.makeVisible();
        r.fill(inicio);
        r.rotate();
        pause();
        r.rotate();
        pause();
        r.rotate();
        pause();
        r.rotate();
        pause();
        assertTrue(ok());
        r.makeInvisible();
    }
 
    private void pause(){
       Canvas.getCanvas().wait(WAIT);
    }
    
    private boolean ok(){
        return (JOptionPane.OK_OPTION==JOptionPane.showConfirmDialog(null,"¿Es lo esperado?"));
    }
    
    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}