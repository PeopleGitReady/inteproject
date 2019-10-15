import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterTest {

    @Test
    void TestNameNumber(){
        //getNumber should control the
        Character testCh = new Character("22.3",44,66);
        assertFalse(testCh.getNumber());

    }
    @Test
    void TestNameNull(){
        Character testCh = new Character(null,44,66);
        assertNotNull(testCh.getName());
    }


    @Test
    void TestNameEmpty(){
        //nameEmpty method should have a boolean return type
        Character testCh = new Character("     ",44,66);
        assertFalse(testCh.nameEmpty());
    }

    @Test
    void TestNameString(){
        Character testCh = new Character("SavageB",44,66);

        assertEquals("SavageB",testCh.getName());
    }


    @Test
    void TestHealth(){



    }

    @Test
    void TestSpeed(){

    }

}