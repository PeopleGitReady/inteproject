import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {



    @Test
    void testNameNumber() {
        //getNumber should control the
        Player testCh = new Player("22.3", 20, 30, 50, 100, 44);
        assertFalse(testCh.ifItIsNumber());
    }

    @Test
    void testNameNull(){
        Player testCh = new Player(null,44,66, 100, 100, 50);
        assertNotNull(testCh.getName());
    }

    // Ändra till isEmpty
    @Test
    void testNameEmpty(){
        //nameEmpty method should have a boolean return type
        Player testCh = new Player("     ",44,66, 100, 100, 59);
        assertFalse(testCh.getName().isEmpty());
    }

    @Test
    void testNameString(){
        Player testCh = new Player("SavageB",44,66, 100, 100,);
        assertEquals("SavageB",testCh.getName());
    }


    @Test
    void testHealthNumberRangeNull(){
        //healthRangeCorrect should return a boolean.
        int x = Integer.parseInt(null);
        Player testCh = new Player("SavageB",44, x, 100, 100, 50);
        assertFalse(testCh.healthRangeCorrect(testCh.getHealth));
    }

    @Test
    void testHealthNumberRangeNegative(){
        Player testCh = new Player("SavageB",44,-99, 11, 100, 110);
        assertTrue(testCh.healthRangeCorrect(testCh.getHealth));
    }
    @Test
    void testHealthNumberRangeAboveRange(){
        Player testCh = new Player("SavageB",44,1000, 233, 100, 11);
        assertTrue(testCh.healthRangeCorrect(testCh.getHealth));


    @Test
    void pickUpItemWhenInventoryFull () {

    }

}