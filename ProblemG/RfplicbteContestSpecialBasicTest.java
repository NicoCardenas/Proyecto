import javax.swing.JOptionPane;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class RfplicbteContestSpecialBasicTest
{
   
    public RfplicbteContestSpecialBasicTest()
    {
    }

    @Test
    public void deberiaResolverCaso1(){
        String given [] = { "..#...#...#",
                            "##..##..##",
                            "##.#.##...",
                            "##.#.##...",
                            ".#...#####",
                            "...##..#.#",
                            "......###.",
                            "##.#.##...",
                            "#..#..#..#",
                            "##..##..##"};
        String initial[]= { ".#",
                            "##"};
        assertArrayEquals(initial,RfplicbteContest.solve(given));
    }
    
    @Test
    public void deberiaResolverCaso2(){
        String given [] = {"##..#.##",
                           "#.####.#",
                           ".#.#.#..",
                           ".##.#.##",
                           ".#.#.#..",
                           ".##.#.##",
                           "#..#.###",
                           "##.#.##."};
        String initial[]= {"####",
                           "#..#",
                           "#.##",
                           "###."};
        assertArrayEquals(RfplicbteContest.solve(given),initial);
    }
    
   @Test
    public void deberiaResolverCaso3(){
        String given [] = {"#....",
                           "..###",
                           "..###",
                           "..###"};
        String initial[]= {"#"};
        assertArrayEquals(RfplicbteContest.solve(given),initial);
    }  
    
    @Test
    public void deberiaSimularRapidoCaso1(){
        String given [] = { "..#...#...#",
                            "##..##..##",
                            "##.#.##...",
                            "##.#.##...",
                            ".#...#####",
                            "...##..#.#",
                            "......###.",
                            "##.#.##...",
                            "#..#..#..#",
                            "##..##..##"};
        RfplicbteContest.simulate(given,false);
        assertTrue(ok());
    } 
    
    @Test
    public void deberiaSimularLentoCaso2(){
        String given [] = {"##..#.##",
                           "#.####.#",
                           ".#.#.#..",
                           ".##.#.##",
                           ".#.#.#..",
                           ".##.#.##",
                           "#..#.###",
                           "##.#.##."};
        RfplicbteContest.simulate(given,true);
        assertTrue(ok());
    }
    ;
   @Test
    public void deberiaSimularRapidoCaso3(){
        String given [] = {"#....",
                           "..###",
                           "..###",
                           "..###"};
        RfplicbteContest.simulate(given,true);
        assertTrue(ok());
    }  
    
    private boolean ok(){
        return (JOptionPane.OK_OPTION==JOptionPane.showConfirmDialog(null,"¿Es lo esperado?"));
    }
   
}