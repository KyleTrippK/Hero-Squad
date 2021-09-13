import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HeroTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void Hero_instantiatesNewClass_true() throws Exception {
        Hero hero = new Hero("shujaa", 18, "power", "weakness");
        assertEquals(true, hero instanceof Hero);
    }

    @Test
    public void Hero_reads_hero() throws Exception{
        Hero.clearAllHero();
        Hero hero = new Hero("Tom Mboya",67, "power", "weakness");
        assertEquals("Tom Mboya", Hero.getAll());
    }

    @After
    public void tearDown() throws Exception {
        Hero.clearAllHero();
    }
    @Test
    public void Hero_returns_allHero() throws Exception{
        Hero hero = new Hero("Tom Mboya", 45, "power", "weakness");
        Hero secondHero = new Hero("Rohlilahla Madiba", 30, "power", "weakness");
        assertEquals(2, Hero.getAll().size());
    }
    @Test
    public void Hero_contains_hero() throws Exception{
        Hero hero = new Hero("Tom Mboya",38, "politics", "jail");
        Hero secondHero = new Hero("Rohlilahla Mandela", 48, "colonize", "weakness");
        assertTrue(Hero.getAll().contains(hero));
        assertTrue(Hero.getAll().contains(secondHero));
    }
}