import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {



    @Test
    void TestNameNumber(){
        //getNumber should control the
        Character testCh = new Player("22.3",44,66);
        assertFalse(testCh.ifItIsNumber());

    @Test
    void pickUpItemWhenInventoryFull () {

    }

}