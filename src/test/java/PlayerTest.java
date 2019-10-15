import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {



    @Test
    void TestNameNumber() {
        //getNumber should control the
        Player testCh = new Player("22.3", 20, 30, 50, 100, 44);
        assertFalse(testCh.ifItIsNumber());
    }

    @Test
    void TestNameNull(){
        Player testCh = new Player(null,44,66);
        assertNotNull(testCh.getName());
    }

    @Test
    void pickUpItemWhenInventoryFull () {

    }

}