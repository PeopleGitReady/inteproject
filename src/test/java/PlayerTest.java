import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {



    @Test
    void TestNameNumber(){
        //getNumber should control the
        Player testCh = new Player("22.3", 20, 30, 50 );
        assertFalse(testCh.ifItIsNumber());

    @Test
    void pickUpItemWhenInventoryFull () {

    }

}