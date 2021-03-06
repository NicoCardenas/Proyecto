package rfplcbte;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class Problem.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class RfplicbteTest {
    /**
     * Default constructor for test class Problem
     */
    public RfplicbteTest()
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
    public void debeCrearLaSimulacionDelProblemaSinErrores(){
        Rfplicbte cualquiera = new Rfplicbte (20,20);
        cualquiera.fill(new int[][]{{10,10},{10,9},{9,10}});
        cualquiera.makeVisible();
        cualquiera.replicateWhitoutBug();
        cualquiera.replicateWhitoutBug();
        cualquiera.replicateWhitoutBug();
        cualquiera.replicateWhitoutBug();
        cualquiera.makeInvisible();        
        assertTrue(cualquiera.ok());
    }
    
    @Test
    public void debeCrearLaSimulacionDelProblemaConErrores(){
        Rfplicbte cualquiera = new Rfplicbte (20,20);
        cualquiera.fill(new int[][]{{10,10},{10,9},{9,10}});
        cualquiera.makeVisible();
        cualquiera.replicateWhitoutBug();
        cualquiera.replicate();
        cualquiera.replicateWhitoutBug();
        cualquiera.replicate();
        cualquiera.makeInvisible();        
        assertTrue(cualquiera.ok());
    }
    
    @Test
    public void debePoderRotarLasDosMatrices(){
        String reference[]={"..........",
                            "....#.....",
                            "....#.....",
                            "....#.....",
                            "....#.....",
                            "..........",
                            "..........",
                            "..........",
                            "..........",
                            ".........."};
        Rfplicbte cualquiera = new Rfplicbte (reference);
        cualquiera.fill(new int[][]{{5,2},{5,3},{5,4},{5,5}});
        cualquiera.makeVisible();
        cualquiera.rotate();
        cualquiera.makeInvisible();
        assertTrue(cualquiera.success());
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
