import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {


    @Test
    void testIfNameContainsNumber() {
        Player testCh = new Player("22.3");
        assertTrue(testCh.getName().matches(".*\\d.*"));
    }

    @Test
    void testNameNull(){
        Player testCh = new Player(null);
        assertNotNull(testCh.getName());
    }

    @Test
    void testNameEmpty(){
        //nameEmpty method should have a boolean return type
        Player testCh = new Player("     ");
        assertFalse(testCh.getName().trim().isEmpty());
    }

    @Test
    void testNameString(){
        Player testCh = new Player("SavageB");
        assertEquals("SavageB",testCh.getName());
    }


    @Test
    void testHealthNumberRangeNull(){
        //healthRangeCorrect should return a boolean.
        int x = Integer.parseInt(null);
        Player testCh = new Player("SavageB");
        assertFalse(testCh.healthRangeCorrect(testCh.getHealth()));
    }

    @Test
    void testHealthNumberRangeNegative(){
        Player testCh = new Player("SavageB");
        assertTrue(testCh.healthRangeCorrect(testCh.getHealth()));
    }
    @Test
    void testHealthNumberRangeAboveRange(){
        Player testCh = new Player("SavageB");
        assertTrue(testCh.healthRangeCorrect(testCh.getHealth()));

    @Test
    void pickUpItemWhenInventoryFull() {

    }

}