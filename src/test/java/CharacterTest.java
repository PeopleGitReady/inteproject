import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterTest {

    @Test
    void TestNameNull(){
        Character testCh = new Character(null,44,66);
        assertNotNull(testCh.getName());
    }


    @Test
    void TestNameEmpty(){
        //nameEmpty method should have a boolean return type
        Character testCh = new Character("     ",44,66);
        assertFalse(testCh.getName().isEmpty());
    }

    @Test
    void TestNameString(){
        Character testCh = new Character("SavageB",44,66);
        assertEquals("SavageB",testCh.getName());
    }

    @Test
    void TestHealthNumberRangeNegative(){
        Character testCh = new Character("SavageB",44,-99);
        assertTrue(testCh.healthRangeCorrect(testCh.getHealth));
    }
    @Test
    void TestHealthNumberRangeAboveRange(){
        Character testCh = new Character("SavageB",44,1000);
        assertTrue(testCh.healthRangeCorrect(testCh.getHealth));
    }

    @Test
    void TestSpeed(){

    }

}