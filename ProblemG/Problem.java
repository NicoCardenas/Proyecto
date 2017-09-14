

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
public class Problem
{
    /**
     * Default constructor for test class Problem
     */
    public Problem()
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
    public void prueba(){
        Rfplicbte cualquiera = new Rfplicbte (20,20);
        cualquiera.fill(new int[][]{{10,10},{10,9},{9,10}});
        cualquiera.makeVisible();
        cualquiera.replicateWhitoutBug();
        cualquiera.replicateWhitoutBug();
        cualquiera.replicateWhitoutBug();
        cualquiera.replicateWhitoutBug();
    }
    
    @Test
    public void prueba2(){
        Rfplicbte cualquiera = new Rfplicbte (20,20);
        cualquiera.fill(new int[][]{{10,10},{10,9},{9,10}});
        cualquiera.makeVisible();
        cualquiera.replicateWhitoutBug();
        cualquiera.replicate();
        cualquiera.replicateWhitoutBug();
        cualquiera.replicate();     
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
