import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WarriorsTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void warriors_instantiatesNewClass_true() throws Exception {
        Warriors warrior = new Warriors("shujaa", 18, "power", "weakness", 1);
        assertEquals(true, warrior instanceof Warriors);
    }

    @Test
    public void warrior_reads_hero() throws Exception{
        Warriors warrior = new Warriors("Tom Mboya",67, "power", "weakness", 1);
        assertEquals("Tom Mboya", warrior.getHero());
    }

    @After
    public void tearDown() throws Exception {
        Warriors.clearAllHero();
    }
    @Test
    public void warriors_returns_allHeros() throws Exception{
        Warriors warrior = new Warriors("Tom Mboya", 45, "power", "weakness", 1);
        Warriors secondWarrior = new Warriors("Rohlilahla Madiba", 30, "power", "weakness", 1);
        assertEquals(2, Warriors.getAll().size());
    }
    @Test
    public void warriors_contains_heros() throws Exception{
        Warriors warrior = new Warriors("Tom Mboya",38, "politics", "jail", 1);
        Warriors secondWarrior = new Warriors("Rohlilahla Mandela", 48, "colonize", "weakness",1);
        assertTrue(Warriors.getAll().contains(warrior));
        assertTrue(Warriors.getAll().contains(secondWarrior));
    }
}